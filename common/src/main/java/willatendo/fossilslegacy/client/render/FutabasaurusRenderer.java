package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.client.state.FutabasaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;

public class FutabasaurusRenderer extends CoatTypeMobRenderer<Futabasaurus, FutabasaurusRenderState> {
    public FutabasaurusRenderer(Context context) {
        super(new FutabasaurusRenderState(), context, 0.3F);
    }

    @Override
    public void extractRenderState(Futabasaurus futabasaurus, FutabasaurusRenderState futabasaurusRenderState, float partialTick) {
        super.extractRenderState(futabasaurus, futabasaurusRenderState, partialTick);
        futabasaurusRenderState.divePose = futabasaurus.divePose() && futabasaurus.hasControllingPassenger();
    }
}
