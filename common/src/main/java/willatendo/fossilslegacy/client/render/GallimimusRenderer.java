package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Gallimimus;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;

public class GallimimusRenderer extends DataDrivenModelMobRenderer<Gallimimus, DinosaurRenderState> {
    public GallimimusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "gallimimus";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE, TextureType.BABY);
    }
}
