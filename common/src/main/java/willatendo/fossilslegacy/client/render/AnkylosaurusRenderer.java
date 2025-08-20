package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.render.layer.EyeLayer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Ankylosaurus;

public class AnkylosaurusRenderer extends DataDrivenModelDinosaurRenderer<Ankylosaurus, DinosaurRenderState> {
    public AnkylosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
        this.addLayer(new EyeLayer<>(this, false));
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("ankylosaurus");
    }
}
