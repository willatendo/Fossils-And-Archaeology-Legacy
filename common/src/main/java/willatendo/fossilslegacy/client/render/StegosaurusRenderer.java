package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Stegosaurus;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;

public class StegosaurusRenderer extends DataDrivenModelMobRenderer<Stegosaurus, DinosaurRenderState> {
    public StegosaurusRenderer(Context context) {
        super(context, 0.15F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "stegosaurus";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE, TextureType.BABY);
    }
}
