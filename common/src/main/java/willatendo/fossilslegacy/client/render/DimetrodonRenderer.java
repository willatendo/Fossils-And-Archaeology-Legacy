package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.pattern.Pattern;

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
        return (!dinosaurRenderState.isBaby && !dinosaurRenderState.isTame && pattern.hasAggressiveTexture()) ? Optional.of(pattern.getAggressiveTexture()) : Optional.empty();
    }
}
