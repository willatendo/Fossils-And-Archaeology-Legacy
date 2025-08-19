package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.render.layer.EyeLayer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Dilophosaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;
import java.util.Optional;

public class DilophosaurusRenderer extends DataDrivenModelDinosaurRenderer<Dilophosaurus, DinosaurRenderState> {
    public DilophosaurusRenderer(Context context) {
        super(context, 0.3F);
        this.addLayer(new EyeLayer<>(this, false));
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Registry<Texture> textureRegistry, DinosaurRenderState dinosaurRenderState, PatternGene patternGene) {
        return dinosaurRenderState.isAttacking ? (dinosaurRenderState.isBaby && this.hasAggressiveBabyTexture(textureRegistry, patternGene)) ? Optional.of(this.getAggressiveBabyTexture(textureRegistry, patternGene)) : Optional.of(this.getAggressiveTexture(textureRegistry, patternGene)) : Optional.empty();
    }

    @Override
    public String baseTextureName() {
        return "dilophosaurus";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY, FATextures.AGGRESSIVE, FATextures.AGGRESSIVE_BABY);
    }
}
