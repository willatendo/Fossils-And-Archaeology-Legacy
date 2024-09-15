package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.Tyrannosaurus;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;

import java.util.Optional;

public class TyrannosaurusRenderer extends CoatTypeMobRenderer<Tyrannosaurus> {
    public TyrannosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    protected Optional<EntityModel<Tyrannosaurus>> getAdditionalModel(Tyrannosaurus tyrannosaurus, CoatType coatType) {
        return tyrannosaurus.isKnockedOut() ? Optional.of(this.models.getOrDefault(coatType.models().knockedOutModel().get(), this.models.get(coatType.models().model()))) : Optional.empty();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Tyrannosaurus tyrannosaurus, CoatType coatType) {
        return tyrannosaurus.isKnockedOut() ? coatType.textures().knockedOutTexture() : (!tyrannosaurus.isBaby() && !tyrannosaurus.isTame()) ? coatType.textures().aggressiveTexture() : Optional.empty();
    }
}
