package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Therizinosaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;

public class TherizinosaurusRenderer extends DataDrivenModelDinosaurRenderer<Therizinosaurus, DinosaurRenderState> {
    public TherizinosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "therizinosaurus";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY);
    }
}
