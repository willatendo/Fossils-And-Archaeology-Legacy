package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.Optional;

public class DimetrodonRenderer extends CoatTypeMobRenderer<Dimetrodon> {
    public DimetrodonRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Dimetrodon dimetrodon, CoatType coatType) {
        return (!dimetrodon.isBaby() && !dimetrodon.isTame()) ? coatType.patterns().getFirst().textures().aggressiveTexture() : Optional.empty();
    }
}
