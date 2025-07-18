package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelMobRenderer;
import willatendo.fossilslegacy.client.state.DataDrivenRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician.Isotelus;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

import java.util.List;

public class IsotelusRenderer extends DataDrivenModelMobRenderer<Isotelus, DataDrivenRenderState> {
    public IsotelusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.25F);
    }

    @Override
    public DataDrivenRenderState createRenderState() {
        return new DataDrivenRenderState();
    }

    @Override
    public String baseTextureName() {
        return "isotelus";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE);
    }
}
