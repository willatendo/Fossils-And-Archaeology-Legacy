package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

public class PatternLayer<T extends Dinosaur, S extends DinosaurRenderState> extends RenderLayer<S, EntityModel<S>> {
    private final DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer;

    public PatternLayer(DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, DinosaurRenderState dinosaurRenderState, float yRot, float xRot) {
        if (dinosaurRenderState.pattern != null && !dinosaurRenderState.pattern.is(FAPatterns.BLANK)) {
            Pattern pattern = dinosaurRenderState.pattern.value();
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(this.dataDrivenModelDinosaurRenderer.getBaseTexture(dinosaurRenderState.textureRegistry, pattern)));
            poseStack.pushPose();
            this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}
