package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;

public class FossilRenderer extends EntityRenderer<Fossil> {
    private EntityModel<Entity> model;

    public FossilRenderer(Context context) {
        super(context);

        this.shadowRadius = 0.5F;
    }

    private void setModel(EntityModel<Entity> entityModel) {
        if (this.model != entityModel) {
            this.model = entityModel;
        }
    }

    private EntityModel<Entity> getModel(ResourceLocation id) {
        if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else if (JsonModelLoader.isBuiltInModel(id)) {
            return JsonModelLoader.getBuiltInModel(id, true);
        } else {
            return null;
        }
    }

    @Override
    public void render(Fossil fossil, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        FossilVariant fossilVariant = fossil.getFossilVariant().value();
        this.setModel(this.getModel(fossilVariant.model()));
        this.shadowRadius = fossilVariant.shadowSize();

        poseStack.pushPose();
        this.model.riding = fossil.isPassenger();
        this.model.young = fossil.isBaby();
        float yBodyRot = Mth.rotLerp(partialTicks, fossil.yBodyRotO, fossil.yBodyRot);
        float yHeadRot = Mth.rotLerp(partialTicks, fossil.yHeadRotO, fossil.yHeadRot);
        float totalHeadRot = yHeadRot - yBodyRot;
        float scale;
        if (fossil.isPassenger()) {
            Entity entity = fossil.getVehicle();
            if (entity instanceof LivingEntity livingEntity) {
                yBodyRot = Mth.rotLerp(partialTicks, livingEntity.yBodyRotO, livingEntity.yBodyRot);
                totalHeadRot = yHeadRot - yBodyRot;
                scale = Mth.wrapDegrees(totalHeadRot);
                if (scale < -85.0F) {
                    scale = -85.0F;
                }

                if (scale >= 85.0F) {
                    scale = 85.0F;
                }

                yBodyRot = yHeadRot - scale;
                if (scale * scale > 2500.0F) {
                    yBodyRot += scale * 0.2F;
                }

                totalHeadRot = yHeadRot - yBodyRot;
            }
        }

        float xRot = Mth.lerp(partialTicks, fossil.xRotO, fossil.getXRot());

        totalHeadRot = Mth.wrapDegrees(totalHeadRot);
        float bob;
        if (fossil.hasPose(Pose.SLEEPING)) {
            Direction direction = fossil.getBedOrientation();
            if (direction != null) {
                bob = fossil.getEyeHeight(Pose.STANDING) - 0.1F;
                poseStack.translate((float) (-direction.getStepX()) * bob, 0.0F, (float) (-direction.getStepZ()) * bob);
            }
        }

        poseStack.scale(fossil.renderScaleWidth(), fossil.renderScaleHeight(), fossil.renderScaleWidth());
        bob = fossil.tickCount + partialTicks;
        this.setupRotations(fossil, poseStack, bob, yBodyRot, partialTicks);
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.translate(0.0F, -1.501F, 0.0F);
        float walkSpeed = 0.0F;
        float walkPosition = 0.0F;
        if (!fossil.isPassenger() && fossil.isAlive()) {
            walkSpeed = fossil.walkAnimation.speed(partialTicks);
            walkPosition = fossil.walkAnimation.position(partialTicks);
            if (fossil.isBaby()) {
                walkPosition *= 3.0F;
            }

            if (walkSpeed > 1.0F) {
                walkSpeed = 1.0F;
            }
        }

        this.model.prepareMobModel(fossil, walkPosition, walkSpeed, partialTicks);
        this.model.setupAnim(fossil, walkPosition, walkSpeed, bob, totalHeadRot, xRot);
        Minecraft minecraft = Minecraft.getInstance();
        boolean isBodyVisible = !fossil.isInvisible();
        boolean isVisible = !isBodyVisible && !fossil.isInvisibleTo(minecraft.player);
        boolean isGlowing = minecraft.shouldEntityAppearGlowing(fossil);
        RenderType renderType = this.getRenderType(fossil, isBodyVisible, isVisible, isGlowing);
        if (renderType != null) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
            int packedOverlay = OverlayTexture.pack(OverlayTexture.u(0.0F), OverlayTexture.v(fossil.hurtTime > 0 || fossil.deathTime > 0));
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, isVisible ? 654311423 : -1);
        }

        poseStack.popPose();
        super.render(fossil, entityYaw, partialTicks, poseStack, multiBufferSource, packedLight);
    }

    protected RenderType getRenderType(Fossil fossil, boolean isBodyVisible, boolean isVisible, boolean isGlowing) {
        ResourceLocation textureLocation = this.getTextureLocation(fossil);
        if (isVisible) {
            return RenderType.itemEntityTranslucentCull(textureLocation);
        } else if (isBodyVisible) {
            return this.model.renderType(textureLocation);
        } else {
            return isGlowing ? RenderType.outline(textureLocation) : null;
        }
    }

    protected void setupRotations(Fossil fossil, PoseStack poseStack, float bob, float yBodyRot, float partialTicks) {
        if (fossil.isFullyFrozen()) {
            yBodyRot += (float) (Math.cos((double) fossil.tickCount * 3.25) * Math.PI * 0.4000000059604645);
        }

        if (!fossil.hasPose(Pose.SLEEPING)) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - yBodyRot));
        }

        if (fossil.deathTime > 0) {
            float deathTime = ((float) fossil.deathTime + partialTicks - 1.0F) / 20.0F * 1.6F;
            deathTime = Mth.sqrt(deathTime);
            if (deathTime > 1.0F) {
                deathTime = 1.0F;
            }

            poseStack.mulPose(Axis.ZP.rotationDegrees(deathTime * 90.0F));
        } else if (fossil.isAutoSpinAttack()) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F - fossil.getXRot()));
            poseStack.mulPose(Axis.YP.rotationDegrees(((float) fossil.tickCount + partialTicks) * -75.0F));
        }
    }

    @Override
    protected float getShadowRadius(Fossil fossil) {
        FossilVariant fossilVariant = fossil.getFossilVariant().value();
        return fossilVariant.shadowSize() + (fossilVariant.shadowGrowth() * fossil.getSize());
    }

    @Override
    public ResourceLocation getTextureLocation(Fossil fossil) {
        FossilVariant fossilVariant = fossil.getFossilVariant().value();
        return fossilVariant.texture();
    }
}
