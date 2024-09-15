package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
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
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.fossils.*;
import willatendo.fossilslegacy.client.model.fossils.legacy.PteranodonSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.legacy.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariants;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;

import java.util.HashMap;
import java.util.Map;

public class FossilRenderer extends EntityRenderer<Fossil> {
    private final Map<FossilVariant, AbstractSkeletonModel> models = new HashMap<>();

    private AbstractSkeletonModel model;

    public FossilRenderer(Context context) {
        super(context);

        this.shadowRadius = 0.5F;

        this.models.put(FossilsLegacyFossilVariants.BRACHIOSAURUS.get(), new BrachiosaurusSkeletonModel(context.bakeLayer(FossilsLegacyModelLayers.BRACHIOSAURUS_SKELETON.getFirst())));
        this.models.put(FossilsLegacyFossilVariants.FUTABASAURUS.get(), new FutabasaurusSkeletonModel(context.bakeLayer(FossilsLegacyModelLayers.FUTABASAURUS_SKELETON.getFirst())));
        this.models.put(FossilsLegacyFossilVariants.PTERANODON.get(), new PteranodonSkeletonModel(context.bakeLayer(FossilsLegacyModelLayers.PTERANODON_SKELETON)));
        this.models.put(FossilsLegacyFossilVariants.TRICERATOPS.get(), new TriceratopsSkeletonModel(context.bakeLayer(FossilsLegacyModelLayers.TRICERATOPS_SKELETON)));
        this.models.put(FossilsLegacyFossilVariants.PACHYCEPHALOSAURUS.get(), new PachycephalosaurusSkeletonModel(context.bakeLayer(FossilsLegacyModelLayers.PACHYCEPHALOSAURUS_SKELETON)));
        this.models.put(FossilsLegacyFossilVariants.COMPSOGNATHUS.get(), new CompsognathusSkeletonModel(context.bakeLayer(FossilsLegacyModelLayers.COMPSOGNATHUS_SKELETON)));
        this.models.put(FossilsLegacyFossilVariants.VELOCIRAPTOR.get(), new VelociraptorSkeletonModel(context.bakeLayer(FossilsLegacyModelLayers.VELOCIRAPTOR_SKELETON)));
    }

    @Override
    public void render(Fossil fossil, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        this.model = this.models.get(fossil.getFossilVariant().value());

        poseStack.pushPose();
        this.model.riding = fossil.isPassenger();
        this.model.young = fossil.isBaby();
        float yBodyRot = Mth.rotLerp(partialTicks, fossil.yBodyRotO, fossil.yBodyRot);
        float yHeadRot = Mth.rotLerp(partialTicks, fossil.yHeadRotO, fossil.yHeadRot);
        float $$8 = yHeadRot - yBodyRot;
        float scale;
        if (fossil.isPassenger()) {
            Entity entity = fossil.getVehicle();
            if (entity instanceof LivingEntity livingEntity) {
                yBodyRot = Mth.rotLerp(partialTicks, livingEntity.yBodyRotO, livingEntity.yBodyRot);
                $$8 = yHeadRot - yBodyRot;
                scale = Mth.wrapDegrees($$8);
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

                $$8 = yHeadRot - yBodyRot;
            }
        }

        float xRot = Mth.lerp(partialTicks, fossil.xRotO, fossil.getXRot());

        $$8 = Mth.wrapDegrees($$8);
        float bob;
        if (fossil.hasPose(Pose.SLEEPING)) {
            Direction $$12 = fossil.getBedOrientation();
            if ($$12 != null) {
                bob = fossil.getEyeHeight(Pose.STANDING) - 0.1F;
                poseStack.translate((float) (-$$12.getStepX()) * bob, 0.0F, (float) (-$$12.getStepZ()) * bob);
            }
        }

        scale = fossil.getScale();
        poseStack.scale(scale, scale, scale);
        bob = fossil.tickCount + partialTicks;
        this.setupRotations(fossil, poseStack, bob, yBodyRot, partialTicks, scale);
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
        this.model.setupAnim(fossil, walkPosition, walkSpeed, bob, $$8, xRot);
        Minecraft minecraft = Minecraft.getInstance();
        boolean isBodyVisible = !fossil.isInvisible();
        boolean isVisible = !isBodyVisible && !fossil.isInvisibleTo(minecraft.player);
        boolean isGlowing = minecraft.shouldEntityAppearGlowing(fossil);
        RenderType renderType = this.getRenderType(fossil, isBodyVisible, isVisible, isGlowing);
        if (renderType != null) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
            int overlayCoords = OverlayTexture.pack(OverlayTexture.u(0.0F), OverlayTexture.v(fossil.hurtTime > 0 || fossil.deathTime > 0));
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, overlayCoords, isVisible ? 654311423 : -1);
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

    protected void setupRotations(Fossil fossil, PoseStack poseStack, float bob, float yBodyRot, float partialTicks, float scale) {
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
        return fossil.getFossilVariant().value().shadowSize() * fossil.getScale();
    }


    @Override
    public ResourceLocation getTextureLocation(Fossil fossil) {
        FossilVariant fossilVariant = fossil.getFossilVariant().value();
        return fossilVariant.fossilTexture();
    }
}
