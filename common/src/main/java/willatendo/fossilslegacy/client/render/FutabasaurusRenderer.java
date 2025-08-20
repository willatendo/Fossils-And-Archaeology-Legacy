package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.FutabasaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;

public class FutabasaurusRenderer extends DataDrivenModelDinosaurRenderer<Futabasaurus, FutabasaurusRenderState> {
    public FutabasaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public FutabasaurusRenderState createRenderState() {
        return new FutabasaurusRenderState();
    }

    @Override
    public void extractRenderState(Futabasaurus futabasaurus, FutabasaurusRenderState futabasaurusRenderState, float partialTick) {
        super.extractRenderState(futabasaurus, futabasaurusRenderState, partialTick);
        futabasaurusRenderState.divePose = futabasaurus.divePose() && futabasaurus.hasControllingPassenger();
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("futabasaurus");
    }
}
