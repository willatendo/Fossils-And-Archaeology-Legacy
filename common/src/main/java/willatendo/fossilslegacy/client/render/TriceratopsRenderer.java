package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Triceratops;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

import java.util.List;

public class TriceratopsRenderer extends DataDrivenModelMobRenderer<Triceratops, DinosaurRenderState> {
    public TriceratopsRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "triceratops";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY);
    }
}
