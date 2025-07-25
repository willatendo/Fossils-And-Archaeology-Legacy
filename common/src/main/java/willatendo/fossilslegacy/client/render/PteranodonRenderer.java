package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.PteranodonRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Pteranodon;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

import java.util.List;
import java.util.Optional;

public class PteranodonRenderer extends DataDrivenModelDinosaurRenderer<Pteranodon, PteranodonRenderState> {
    public PteranodonRenderer(Context context) {
        super(context, 0.5F);
    }

    @Override
    public PteranodonRenderState createRenderState() {
        return new PteranodonRenderState();
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
    public Optional<ResourceLocation> getAdditionalModel(PteranodonRenderState pteranodonRenderState, ModelType modelType) {
        ModelType.Models models = modelType.models();
        return pteranodonRenderState.shouldLand ? this.additionalModel(models.landingModel(), models) : pteranodonRenderState.shouldFly ? this.additionalModel(models.flyingModel(), models) : Optional.empty();
    }

    @Override
    public String baseTextureName() {
        return "pteranodon";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY);
    }
}
