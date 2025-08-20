package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Carnotaurus;

public class CarnotaurusRenderer extends DataDrivenModelDinosaurRenderer<Carnotaurus, DinosaurRenderState> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("carnotaurus");
    }
}
