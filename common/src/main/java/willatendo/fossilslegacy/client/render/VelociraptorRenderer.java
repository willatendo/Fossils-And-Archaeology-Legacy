package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Velociraptor;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;

public class VelociraptorRenderer extends DataDrivenModelMobRenderer<Velociraptor, DinosaurRenderState> {
    public VelociraptorRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "velociraptor";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE, TextureType.BABY);
    }
}
