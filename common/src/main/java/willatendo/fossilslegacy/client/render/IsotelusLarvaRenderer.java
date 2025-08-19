package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelMobRenderer;
import willatendo.fossilslegacy.client.state.DataDrivenRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.ordovician.IsotelusLarva;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;

public class IsotelusLarvaRenderer extends DataDrivenModelMobRenderer<IsotelusLarva, DataDrivenRenderState> {
    public IsotelusLarvaRenderer(EntityRendererProvider.Context context) {
        super(context, 0.1F);
    }

    @Override
    public DataDrivenRenderState createRenderState() {
        return new DataDrivenRenderState();
    }

    @Override
    public String baseTextureName() {
        return "isotelus_larva";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE);
    }
}
