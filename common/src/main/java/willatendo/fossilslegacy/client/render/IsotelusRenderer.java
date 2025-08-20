package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelMobRenderer;
import willatendo.fossilslegacy.client.state.ChromosomedEntityRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician.Isotelus;

public class IsotelusRenderer extends DataDrivenModelMobRenderer<Isotelus, ChromosomedEntityRenderState> {
    public IsotelusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.25F);
    }

    @Override
    public ChromosomedEntityRenderState createRenderState() {
        return new ChromosomedEntityRenderState();
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("isotelus");
    }
}
