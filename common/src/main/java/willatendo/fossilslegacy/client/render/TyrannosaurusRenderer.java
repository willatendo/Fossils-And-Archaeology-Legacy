package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.Tyrannosaurus;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Optional;

public class TyrannosaurusRenderer extends CoatTypeMobRenderer<Tyrannosaurus> {
    public TyrannosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Tyrannosaurus tyrannosaurus, CoatType coatType) {
        return tyrannosaurus.isKnockedOut() ? coatType.textures().knockedOutTexture() : (!tyrannosaurus.isBaby() && !tyrannosaurus.isTame()) ? coatType.textures().aggressiveTexture() : Optional.empty();
    }
}
