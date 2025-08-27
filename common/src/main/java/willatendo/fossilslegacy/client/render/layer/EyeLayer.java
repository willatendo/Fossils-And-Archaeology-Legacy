package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.TextureInformation;

public class EyeLayer<T extends Dinosaur, S extends DinosaurRenderState> extends RenderLayer<S, EntityModel<S>> {
    private final DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer;

    public EyeLayer(DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
    }

    protected RenderType getRenderType(S dinosaurRenderState, boolean isVisible, boolean renderTranslucent, boolean appearsGlowing) {
        TextureInformation.EyeTextures eyeTextures = this.dataDrivenModelDinosaurRenderer.getSkinTextureInformation(dinosaurRenderState).eyeTextures();
        ResourceLocation texture = dinosaurRenderState.isTranquilized ? eyeTextures.closedEyeTexture().get() : eyeTextures.eyeTexture().get();
        if (renderTranslucent) {
            return RenderType.itemEntityTranslucentCull(texture);
        } else if (isVisible) {
            return this.getParentModel().renderType(texture);
        } else {
            return appearsGlowing ? RenderType.outline(texture) : null;
        }
    }

    protected boolean isBodyVisible(S dinosaurRenderState) {
        return !dinosaurRenderState.isInvisible;
    }

    protected float getWhiteOverlayProgress(S dinosaurRenderState) {
        return 0.0F;
    }

    protected int getModelTint(S dinosaurRenderState) {
        return -1;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, S dinosaurRenderState, float yRot, float xRot) {
        poseStack.pushPose();
        boolean bodyVisible = this.isBodyVisible(dinosaurRenderState);
        boolean renderTranslucent = !bodyVisible && !dinosaurRenderState.isInvisibleToPlayer;
        RenderType renderType = this.getRenderType(dinosaurRenderState, bodyVisible, renderTranslucent, dinosaurRenderState.appearsGlowing);
        if (renderType != null) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(renderType);
            int packedOverlay = LivingEntityRenderer.getOverlayCoords(dinosaurRenderState, this.getWhiteOverlayProgress(dinosaurRenderState));
            int color = ARGB.multiply(renderTranslucent ? 654311423 : -1, this.getModelTint(dinosaurRenderState));
            this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }
        poseStack.popPose();
    }
}