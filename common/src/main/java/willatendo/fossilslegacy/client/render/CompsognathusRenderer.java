package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Compsognathus;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;

public class CompsognathusRenderer extends DataDrivenModelMobRenderer<Compsognathus, DinosaurRenderState> {
    public CompsognathusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "compsognathus";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE);
    }
}
