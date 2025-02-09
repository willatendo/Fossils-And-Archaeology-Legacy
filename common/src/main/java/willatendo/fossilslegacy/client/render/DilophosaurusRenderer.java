package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dilophosaurus;

import java.util.Optional;

public class DilophosaurusRenderer extends CoatTypeMobRenderer<Dilophosaurus, DinosaurRenderState> {
    public DilophosaurusRenderer(Context context) {
        super(new DinosaurRenderState(), context, 0.3F);
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(DinosaurRenderState dinosaurRenderState, CoatType coatType) {
        return dinosaurRenderState.isAttacking ? (dinosaurRenderState.isBaby && coatType.patterns().getFirst().textures().aggressiveBabyTexture().isPresent()) ? coatType.patterns().getFirst().textures().aggressiveBabyTexture() : coatType.patterns().getFirst().textures().aggressiveTexture() : Optional.empty();
    }
}
