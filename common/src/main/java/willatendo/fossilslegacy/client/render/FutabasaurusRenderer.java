package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.state.FutabasaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Futabasaurus;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

import java.util.List;

public class FutabasaurusRenderer extends DataDrivenModelMobRenderer<Futabasaurus, FutabasaurusRenderState> {
    public FutabasaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public FutabasaurusRenderState createRenderState() {
        return new FutabasaurusRenderState();
    }

    @Override
    public void extractRenderState(Futabasaurus futabasaurus, FutabasaurusRenderState futabasaurusRenderState, float partialTick) {
        super.extractRenderState(futabasaurus, futabasaurusRenderState, partialTick);
        futabasaurusRenderState.divePose = futabasaurus.divePose() && futabasaurus.hasControllingPassenger();
    }

    @Override
    public String baseTextureName() {
        return "futabasaurus";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE);
    }
}
