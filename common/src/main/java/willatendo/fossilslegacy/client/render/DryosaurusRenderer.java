package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dryosaurus;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;

public class DryosaurusRenderer extends DataDrivenModelMobRenderer<Dryosaurus, DinosaurRenderState> {
    public DryosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE);
    }

    @Override
    public String baseTextureName() {
        return "dryosaurus";
    }
}
