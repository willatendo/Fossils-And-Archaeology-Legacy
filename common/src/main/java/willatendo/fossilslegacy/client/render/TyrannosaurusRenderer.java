package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.TyrannosaurusRenderState;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Tyrannosaurus;

import java.util.Optional;

public class TyrannosaurusRenderer extends DataDrivenModelMobRenderer<Tyrannosaurus, TyrannosaurusRenderState> {
    public TyrannosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public TyrannosaurusRenderState createRenderState() {
        return new TyrannosaurusRenderState();
    }

    @Override
    public Optional<ResourceLocation> getAdditionalModel(TyrannosaurusRenderState tyrannosaurusRenderState, ModelType modelType) {
        ModelType.Models models = modelType.models();
        return tyrannosaurusRenderState.knockedOut ? this.additionalModel(models.knockedOutModel(), models) : Optional.empty();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(TyrannosaurusRenderState tyrannosaurusRenderState, ModelType modelType) {
        return (tyrannosaurusRenderState.knockedOut && modelType.patterns().getFirst().hasKnockedOutTexture()) ? Optional.of(modelType.patterns().getFirst().getKnockedOutTexture()) : (!tyrannosaurusRenderState.isBaby && !tyrannosaurusRenderState.isTame && modelType.patterns().getFirst().hasAggressiveTexture()) ? Optional.of(modelType.patterns().getFirst().getAggressiveTexture()) : Optional.empty();
    }
}
