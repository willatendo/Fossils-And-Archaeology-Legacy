package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Baryonyx;
import willatendo.fossilslegacy.server.pattern.information.TextureType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

import java.util.List;
import java.util.Optional;

public class BaryonyxRenderer extends DataDrivenModelMobRenderer<Baryonyx, DinosaurRenderState> {
    public BaryonyxRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(DinosaurRenderState dinosaurRenderState, Pattern pattern) {
        return (!dinosaurRenderState.isBaby && !dinosaurRenderState.isTame && this.hasAggressiveTexture(pattern)) ? Optional.of(this.getAggressiveTexture(pattern)) : Optional.empty();
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE);
    }

    @Override
    public String baseTextureName() {
        return "baryonyx";
    }
}
