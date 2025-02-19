package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.TyrannosaurusRenderState;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Tyrannosaurus;

import java.util.Optional;

public class TyrannosaurusRenderer extends CoatTypeMobRenderer<Tyrannosaurus, TyrannosaurusRenderState> {
    public TyrannosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public TyrannosaurusRenderState createRenderState() {
        return new TyrannosaurusRenderState();
    }

    @Override
    public Optional<ResourceLocation> getAdditionalModel(TyrannosaurusRenderState tyrannosaurusRenderState, CoatType coatType) {
        CoatType.Models models = coatType.models();
        return tyrannosaurusRenderState.knockedOut ? this.additionalModel(models.knockedOutModel(), models) : Optional.empty();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(TyrannosaurusRenderState tyrannosaurusRenderState, CoatType coatType) {
        return tyrannosaurusRenderState.knockedOut ? coatType.patterns().getFirst().textures().knockedOutTexture() : (!tyrannosaurusRenderState.isBaby && !tyrannosaurusRenderState.isTame) ? coatType.patterns().getFirst().textures().aggressiveTexture() : Optional.empty();
    }
}
