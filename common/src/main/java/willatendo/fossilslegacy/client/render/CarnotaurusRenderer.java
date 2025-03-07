package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Carnotaurus;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;

public class CarnotaurusRenderer extends DataDrivenModelMobRenderer<Carnotaurus, DinosaurRenderState> {
    public CarnotaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "carnotaurus";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE, TextureType.BABY);
    }
}
