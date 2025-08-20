package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public class PatternLayer<T extends Dinosaur, S extends DinosaurRenderState> extends RenderLayer<S, EntityModel<S>> {
    private final DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer;

    public PatternLayer(DataDrivenModelDinosaurRenderer<T, S> dataDrivenModelDinosaurRenderer) {
        super(dataDrivenModelDinosaurRenderer);
        this.dataDrivenModelDinosaurRenderer = dataDrivenModelDinosaurRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, DinosaurRenderState dinosaurRenderState, float yRot, float xRot) {

    }
}
