package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Pteranodon;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.Optional;

public class PteranodonRenderer extends CoatTypeMobRenderer<Pteranodon> {
    public PteranodonRenderer(Context context) {
        super(context, 0.5F);
    }

    @Override
    public Optional<EntityModel<Pteranodon>> getAdditionalModel(Pteranodon pteranodon, CoatType coatType) {
        CoatType.Models models = coatType.models();
        return pteranodon.landing ? this.additionalModel(pteranodon, models.landingModel(), models) : pteranodon.shouldFly() ? this.additionalModel(pteranodon, models.flyingModel(), models) : Optional.empty();
    }
}
