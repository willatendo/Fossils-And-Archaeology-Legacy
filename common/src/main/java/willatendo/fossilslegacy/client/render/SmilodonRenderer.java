package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.SmilodonRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Smilodon;

public class SmilodonRenderer extends DataDrivenModelDinosaurRenderer<Smilodon, SmilodonRenderState> {
    public SmilodonRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public SmilodonRenderState createRenderState() {
        return new SmilodonRenderState();
    }

    @Override
    public void extractRenderState(Smilodon smilodon, SmilodonRenderState smilodonRenderState, float partialTick) {
        super.extractRenderState(smilodon, smilodonRenderState, partialTick);
        smilodonRenderState.sitAnimationState.copyFrom(smilodon.sitAnimationState);
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("smilodon");
    }
}
