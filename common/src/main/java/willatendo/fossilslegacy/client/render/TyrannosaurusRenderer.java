package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.TyrannosaurusRenderState;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Tyrannosaurus;
import willatendo.fossilslegacy.server.pattern.Pattern;

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
    protected Optional<ResourceLocation> getAdditionalTexture(TyrannosaurusRenderState tyrannosaurusRenderState, Pattern pattern) {
        return (tyrannosaurusRenderState.knockedOut && pattern.hasKnockedOutTexture()) ? Optional.of(pattern.getKnockedOutTexture()) : (!tyrannosaurusRenderState.isBaby && !tyrannosaurusRenderState.isTame && pattern.hasAggressiveTexture()) ? Optional.of(pattern.getAggressiveTexture()) : Optional.empty();
    }
}
