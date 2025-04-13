package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Elasmotherium;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

import java.util.List;

public class ElasmotheriumRenderer extends DataDrivenModelMobRenderer<Elasmotherium, DinosaurRenderState> {
    public ElasmotheriumRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE);
    }

    @Override
    public String baseTextureName() {
        return "elasmotherium";
    }
}
