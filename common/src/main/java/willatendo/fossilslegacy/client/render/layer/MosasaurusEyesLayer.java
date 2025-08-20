package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Mosasaurus;

public class MosasaurusEyesLayer extends RenderLayer<DinosaurRenderState, EntityModel<DinosaurRenderState>> {
    private DataDrivenModelDinosaurRenderer<Mosasaurus, DinosaurRenderState> dataDrivenModelDinosaurRenderer;

    public MosasaurusEyesLayer(DataDrivenModelDinosaurRenderer<Mosasaurus, DinosaurRenderState> dataDrivenModelDinosaurRenderer) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, DinosaurRenderState dinosaurRenderState, float packedLight, float packedOverlay) {
    }
}
