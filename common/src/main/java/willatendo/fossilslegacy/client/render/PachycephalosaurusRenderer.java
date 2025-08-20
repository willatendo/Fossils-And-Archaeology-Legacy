package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Pachycephalosaurus;

public class PachycephalosaurusRenderer extends DataDrivenModelDinosaurRenderer<Pachycephalosaurus, DinosaurRenderState> {
    public PachycephalosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("pachycephalosaurus");
    }
}
