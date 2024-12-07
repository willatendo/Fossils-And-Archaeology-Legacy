package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Tyrannosaurus;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.Optional;

public class TyrannosaurusRenderer extends CoatTypeMobRenderer<Tyrannosaurus> {
    public TyrannosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    protected Optional<EntityModel<Tyrannosaurus>> getAdditionalModel(Tyrannosaurus tyrannosaurus, CoatType coatType) {
        CoatType.Models models = coatType.models();
        return tyrannosaurus.isKnockedOut() ? this.additionalModel(tyrannosaurus, models.knockedOutModel(), models) : Optional.empty();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Tyrannosaurus tyrannosaurus, CoatType coatType) {
        return tyrannosaurus.isKnockedOut() ? coatType.patterns().getFirst().textures().knockedOutTexture() : (!tyrannosaurus.isBaby() && !tyrannosaurus.isTame()) ? coatType.patterns().getFirst().textures().aggressiveTexture() : Optional.empty();
    }
}
