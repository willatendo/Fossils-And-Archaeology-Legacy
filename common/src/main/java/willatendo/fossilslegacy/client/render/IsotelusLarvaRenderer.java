package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelMobRenderer;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician.IsotelusLarva;

public class IsotelusLarvaRenderer extends DataDrivenModelMobRenderer<IsotelusLarva, ChromosomedEntityRenderState> {
    public IsotelusLarvaRenderer(EntityRendererProvider.Context context) {
        super(context, 0.1F);
    }

    @Override
    public ChromosomedEntityRenderState createRenderState() {
        return new ChromosomedEntityRenderState();
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("isotelus_larva");
    }
}
