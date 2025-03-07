package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.pattern.information.TextureType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

import java.util.List;
import java.util.Optional;

public class DimetrodonRenderer extends DataDrivenModelMobRenderer<Dimetrodon, DinosaurRenderState> {
    public DimetrodonRenderer(EntityRendererProvider.Context context) {
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
    public String baseTextureName() {
        return "dimetrodon";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE, TextureType.BABY, TextureType.AGGRESSIVE);
    }
}
