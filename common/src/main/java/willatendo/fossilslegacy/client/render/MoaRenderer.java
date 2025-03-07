package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Moa;
import willatendo.fossilslegacy.server.pattern.information.TextureType;

import java.util.List;

public class MoaRenderer extends DataDrivenModelMobRenderer<Moa, DinosaurRenderState> {
    public MoaRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "moa";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE);
    }
}
