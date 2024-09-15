package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;

import java.util.Optional;

public class PteranodonRenderer extends CoatTypeMobRenderer<Pteranodon> {
    public PteranodonRenderer(Context context) {
        super(context, 0.5F);
    }

    @Override
    protected Optional<EntityModel<Pteranodon>> getAdditionalModel(Pteranodon pteranodon, CoatType coatType) {
        return pteranodon.landing ? Optional.of(this.models.getOrDefault(pteranodon.getCoatType().value().models().landingModel().get(), this.models.get(pteranodon.getCoatType().value().models().model()))) : pteranodon.shouldFly() ? Optional.of(this.models.getOrDefault(pteranodon.getCoatType().value().models().flyingModel().get(), this.models.get(pteranodon.getCoatType().value().models().model()))) : Optional.empty();
    }
}
