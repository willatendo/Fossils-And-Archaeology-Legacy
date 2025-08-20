package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.MammothRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Mammoth;

public class MammothFurLayer extends RenderLayer<MammothRenderState, EntityModel<MammothRenderState>> {
    private EntityModel<MammothRenderState> model;
    private DataDrivenModelDinosaurRenderer<Mammoth, MammothRenderState> dataDrivenModelDinosaurRenderer;
    private ResourceLocation modelId;

    public MammothFurLayer(DataDrivenModelDinosaurRenderer<Mammoth, MammothRenderState> dataDrivenModelDinosaurRenderer) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
    }

    private void setModel(ResourceLocation model) {
        if (this.modelId != model) {
            this.modelId = model;
            this.model = this.dataDrivenModelDinosaurRenderer.getModel(model);
        }
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, MammothRenderState mammothRenderState, float packedLight, float packedOverlay) {

    }
}
