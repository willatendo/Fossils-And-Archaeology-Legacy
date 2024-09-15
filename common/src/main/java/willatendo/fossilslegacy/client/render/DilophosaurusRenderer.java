package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.Dilophosaurus;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;

import java.util.Optional;

public class DilophosaurusRenderer extends CoatTypeMobRenderer<Dilophosaurus> {
    public DilophosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Dilophosaurus dilophosaurus, CoatType coatType) {
        return dilophosaurus.isAttacking() ? (dilophosaurus.isBaby() && coatType.textures().aggressiveBabyTexture().isPresent()) ? coatType.textures().aggressiveBabyTexture() : coatType.textures().aggressiveTexture() : Optional.empty();
    }
}
