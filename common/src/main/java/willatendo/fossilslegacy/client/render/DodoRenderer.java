package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DodoRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Dodo;

public class DodoRenderer extends CoatTypeMobRenderer<Dodo, DodoRenderState> {
    public DodoRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    public DodoRenderState createRenderState() {
        return new DodoRenderState();
    }

    @Override
    public void extractRenderState(Dodo dodo, DodoRenderState dodoRenderState, float partialTick) {
        super.extractRenderState(dodo, dodoRenderState, partialTick);
        dodoRenderState.fallAnimationState.copyFrom(dodo.fallAnimationState);
    }
}
