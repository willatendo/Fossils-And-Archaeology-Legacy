package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dilophosaurus;
import willatendo.fossilslegacy.server.pattern.Pattern;

import java.util.Optional;

public class DilophosaurusRenderer extends DataDrivenModelMobRenderer<Dilophosaurus, DinosaurRenderState> {
    public DilophosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(DinosaurRenderState dinosaurRenderState, Pattern pattern) {
        return dinosaurRenderState.isAttacking ? (dinosaurRenderState.isBaby && pattern.hasAggressiveBabyTexture()) ? Optional.of(pattern.getAggressiveBabyTexture()) : Optional.of(pattern.getAggressiveTexture()) : Optional.empty();
    }
}
