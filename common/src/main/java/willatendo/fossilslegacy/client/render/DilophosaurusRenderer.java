package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dilophosaurus;
import willatendo.fossilslegacy.server.pattern.information.TextureType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

import java.util.List;
import java.util.Optional;

public class DilophosaurusRenderer extends DataDrivenModelMobRenderer<Dilophosaurus, DinosaurRenderState> {
    public DilophosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(DinosaurRenderState dinosaurRenderState, Pattern pattern) {
        return dinosaurRenderState.isAttacking ? (dinosaurRenderState.isBaby && this.hasAggressiveBabyTexture(pattern)) ? Optional.of(this.getAggressiveBabyTexture(pattern)) : Optional.of(this.getAggressiveTexture(pattern)) : Optional.empty();
    }

    @Override
    public String baseTextureName() {
        return "dilophosaurus";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE, TextureType.BABY, TextureType.AGGRESSIVE, TextureType.AGGRESSIVE_BABY);
    }
}
