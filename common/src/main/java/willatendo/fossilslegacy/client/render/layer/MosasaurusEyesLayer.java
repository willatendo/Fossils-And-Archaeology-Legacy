package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import willatendo.fossilslegacy.client.render.DataDrivenModelMobRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Mosasaurus;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

public class MosasaurusEyesLayer extends RenderLayer<DinosaurRenderState, EntityModel<DinosaurRenderState>> {
    private DataDrivenModelMobRenderer<Mosasaurus, DinosaurRenderState> dataDrivenModelMobRenderer;

    public MosasaurusEyesLayer(DataDrivenModelMobRenderer<Mosasaurus, DinosaurRenderState> dataDrivenModelMobRenderer) {
        super(dataDrivenModelMobRenderer);
        this.dataDrivenModelMobRenderer = dataDrivenModelMobRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, DinosaurRenderState dinosaurRenderState, float packedLight, float packedOverlay) {
        Pattern skin = dinosaurRenderState.skin.value();
        if (this.dataDrivenModelMobRenderer.hasEyeTexture(skin)) {
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(RenderType.eyes(this.dataDrivenModelMobRenderer.getEyeTexture(skin)));
            this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 15728640, OverlayTexture.NO_OVERLAY);
        }
    }
}
