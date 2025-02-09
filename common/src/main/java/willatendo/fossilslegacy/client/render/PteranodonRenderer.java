package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import willatendo.fossilslegacy.client.state.PteranodonRenderState;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Pteranodon;

import java.util.Optional;

public class PteranodonRenderer extends CoatTypeMobRenderer<Pteranodon, PteranodonRenderState> {
    public PteranodonRenderer(Context context) {
        super(new PteranodonRenderState(), context, 0.5F);
    }

    @Override
    public void extractRenderState(Pteranodon pteranodon, PteranodonRenderState pteranodonRenderState, float partialTick) {
        super.extractRenderState(pteranodon, pteranodonRenderState, partialTick);
        pteranodonRenderState.shouldFly = pteranodon.shouldFly();
        pteranodonRenderState.shouldLand = pteranodon.shouldLand();
        pteranodonRenderState.airPitch = pteranodon.getAirPitch();
        pteranodonRenderState.airAngle = pteranodon.getAirAngle();
        pteranodonRenderState.flyingAnimationState.copyFrom(pteranodon.getFlyingAnimationState());
        pteranodonRenderState.landAnimationState.copyFrom(pteranodon.getLandingAnimationState());
    }

    @Override
    public Optional<EntityModel<PteranodonRenderState>> getAdditionalModel(PteranodonRenderState pteranodonRenderState, CoatType coatType) {
        CoatType.Models models = coatType.models();
        return pteranodonRenderState.shouldLand ? this.additionalModel(models.landingModel(), models) : pteranodonRenderState.shouldFly ? this.additionalModel(models.flyingModel(), models) : Optional.empty();
    }
}
