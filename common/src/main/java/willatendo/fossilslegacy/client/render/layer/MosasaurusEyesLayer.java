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
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Mosasaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;

public class MosasaurusEyesLayer extends RenderLayer<DinosaurRenderState, EntityModel<DinosaurRenderState>> {
    private DataDrivenModelDinosaurRenderer<Mosasaurus, DinosaurRenderState> dataDrivenModelDinosaurRenderer;

    public MosasaurusEyesLayer(DataDrivenModelDinosaurRenderer<Mosasaurus, DinosaurRenderState> dataDrivenModelDinosaurRenderer) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, DinosaurRenderState dinosaurRenderState, float packedLight, float packedOverlay) {
        PatternGene skin = dinosaurRenderState.skinGene.value();
        if (this.dataDrivenModelDinosaurRenderer.hasEyeTexture(dinosaurRenderState.textureRegistry, skin)) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.eyes(this.dataDrivenModelDinosaurRenderer.getEyeTexture(dinosaurRenderState.textureRegistry, skin)));
            this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 15728640, OverlayTexture.NO_OVERLAY);
        }
    }
}
