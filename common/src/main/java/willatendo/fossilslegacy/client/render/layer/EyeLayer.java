package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class EyeLayer<T extends Dinosaur, S extends DinosaurRenderState> extends RenderLayer<S, EntityModel<S>> {
    private final DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer;
    private final boolean hasAggressiveEye;
    private final boolean hasBabyEye;

    public EyeLayer(DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer, boolean hasAggressiveEye, boolean hasBabyEye) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
        this.hasAggressiveEye = hasAggressiveEye;
        this.hasBabyEye = hasBabyEye;
    }

    public EyeLayer(DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer, boolean hasAggressiveEye) {
        this(dataDrivenModelDinosaurRenderer, hasAggressiveEye, true);
    }


    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, DinosaurRenderState dinosaurRenderState, float yRot, float xRot) {
        ResourceKey<Texture> eyeTexture;
        if (dinosaurRenderState.isTranquilized) {
            eyeTexture = FATextures.CLOSED_EYE;
        } else if (dinosaurRenderState.isBaby && this.hasBabyEye) {
            eyeTexture = FATextures.BABY_EYE;
        } else if (this.hasAggressiveEye && !dinosaurRenderState.isTame) {
            eyeTexture = FATextures.AGGRESSIVE_EYE;
        } else {
            eyeTexture = FATextures.ADULT_EYE;
        }

        ResourceLocation texture = FAUtils.resource("textures/entity/" + dinosaurRenderState.textureRegistry.getValue(eyeTexture).getTextureName(dinosaurRenderState.textureRegistry, this.dataDrivenModelDinosaurRenderer.baseTextureName(), this.hasBabyEye) + ".png");
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(texture));
        poseStack.pushPose();
        int overlay = LivingEntityRenderer.getOverlayCoords(dinosaurRenderState, 0.0F);
        this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, overlay);
        poseStack.popPose();
    }
}