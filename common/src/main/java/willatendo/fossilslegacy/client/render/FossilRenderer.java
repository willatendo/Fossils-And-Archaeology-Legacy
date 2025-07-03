package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import willatendo.fossilslegacy.client.model.json.JsonModelLoader;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.FossilRenderState;
import willatendo.fossilslegacy.server.entity.entities.Fossil;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;

public class FossilRenderer extends EntityRenderer<Fossil, FossilRenderState> {
    private JsonTypeModel<FossilRenderState> model;

    public FossilRenderer(Context context) {
        super(context);
    }

    @Override
    public void extractRenderState(Fossil fossil, FossilRenderState fossilRenderState, float partialTick) {
        super.extractRenderState(fossil, fossilRenderState, partialTick);
        float yHeadRot = Mth.rotLerp(partialTick, fossil.yHeadRotO, fossil.yHeadRot);
        fossilRenderState.bodyRot = this.solveBodyRot(fossil, yHeadRot, partialTick);
        fossilRenderState.fossilRotations = fossil.getFossilRotations();
        fossilRenderState.fossilPositions = fossil.getFossilPositions();
        fossilRenderState.variant = fossil.getFossilVariant();
        fossilRenderState.size = fossil.getSize();
        fossilRenderState.renderScaleWidth = fossil.renderScaleWidth();
        fossilRenderState.renderScaleHeight = fossil.renderScaleHeight();
        Minecraft minecraft = Minecraft.getInstance();
        fossilRenderState.isInvisibleToPlayer = fossil.isInvisible() && fossil.isInvisibleTo(minecraft.player);
        fossilRenderState.appearsGlowing = minecraft.shouldEntityAppearGlowing(fossil);
        fossilRenderState.isUpsideDown = this.isEntityUpsideDown(fossil);
    }

    private float solveBodyRot(Fossil fossil, float yHeadRot, float partialTick) {
        Entity vehicle = fossil.getVehicle();
        if (vehicle instanceof LivingEntity livingentity) {
            float bodyRot = Mth.rotLerp(partialTick, livingentity.yBodyRotO, livingentity.yBodyRot);
            float clamp = Mth.clamp(Mth.wrapDegrees(yHeadRot - bodyRot), -85.0F, 85.0F);
            bodyRot = yHeadRot - clamp;
            if (Math.abs(clamp) > 50.0F) {
                bodyRot += clamp * 0.2F;
            }

            return bodyRot;
        } else {
            return Mth.rotLerp(partialTick, fossil.yBodyRotO, fossil.yBodyRot);
        }
    }

    private boolean isEntityUpsideDown(Fossil fossil) {
        if (fossil.hasCustomName()) {
            String s = ChatFormatting.stripFormatting(fossil.getName().getString());
            return "Dinnerbone".equals(s) || "Grumm".equals(s);
        }

        return false;
    }

    @Override
    public FossilRenderState createRenderState() {
        return new FossilRenderState();
    }

    private void setModel(JsonTypeModel<FossilRenderState> entityModel) {
        if (this.model != entityModel) {
            this.model = entityModel;
        }
    }

    private JsonTypeModel<FossilRenderState> getModel(ResourceLocation id) {
        if (JsonModelLoader.isJsonModel(id)) {
            return JsonModelLoader.getModel(id);
        } else {
            return null;
        }
    }

    @Override
    public void render(FossilRenderState fossilRenderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
        FossilVariant fossilVariant = fossilRenderState.variant.value();
        this.setModel(this.getModel(fossilVariant.model()));

        poseStack.pushPose();

        poseStack.scale(1.0F, 1.0F, 1.0F);
        this.setupRotations(fossilRenderState, poseStack, fossilRenderState.bodyRot, 1.0F);
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        this.model.setupAnim(fossilRenderState);
        poseStack.scale(fossilRenderState.renderScaleWidth, fossilRenderState.renderScaleHeight, fossilRenderState.renderScaleWidth);
        poseStack.translate(0.0F, -1.501F, 0.0F);
        boolean isInvisible = !fossilRenderState.isInvisible;
        boolean visible = !isInvisible && !fossilRenderState.isInvisibleToPlayer;
        RenderType renderType = this.getRenderType(fossilRenderState, isInvisible, visible, fossilRenderState.appearsGlowing);
        if (renderType != null) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
            int packedOverlay = OverlayTexture.pack(OverlayTexture.u(0.0F), OverlayTexture.v(false));
            int color = ARGB.multiply(visible ? 654311423 : -1, -1);
            this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }

        poseStack.popPose();
        super.render(fossilRenderState, poseStack, multiBufferSource, packedLight);
    }

    protected RenderType getRenderType(FossilRenderState fossilRenderState, boolean isBodyVisible, boolean isVisible, boolean isGlowing) {
        ResourceLocation textureLocation = this.getTextureLocation(fossilRenderState);
        if (isVisible) {
            return RenderType.itemEntityTranslucentCull(textureLocation);
        } else if (isBodyVisible) {
            return this.model.renderType(textureLocation);
        } else {
            return isGlowing ? RenderType.outline(textureLocation) : null;
        }
    }

    protected void setupRotations(FossilRenderState fossilRenderState, PoseStack poseStack, float bodyRot, float scale) {
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - bodyRot));

        if (fossilRenderState.isUpsideDown) {
            poseStack.translate(0.0F, (fossilRenderState.boundingBoxHeight + 0.1F) / scale, 0.0F);
            poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        }
    }

    @Override
    protected float getShadowRadius(FossilRenderState fossilRenderState) {
        FossilVariant fossilVariant = fossilRenderState.variant.value();
        return fossilVariant.shadowSize() + (fossilVariant.shadowGrowth() * fossilRenderState.size);
    }

    public ResourceLocation getTextureLocation(FossilRenderState fossilRenderState) {
        FossilVariant fossilVariant = fossilRenderState.variant.value();
        return fossilVariant.texture();
    }
}
