package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.guadalupian.Dimetrodon;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;
import java.util.Optional;

public class DimetrodonRenderer extends DataDrivenModelDinosaurRenderer<Dimetrodon, DinosaurRenderState> {
    public DimetrodonRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Registry<Texture> textureRegistry, DinosaurRenderState dinosaurRenderState, PatternGene patternGene) {
        return (!dinosaurRenderState.isBaby && !dinosaurRenderState.isTame && this.hasAggressiveTexture(textureRegistry, patternGene)) ? Optional.of(this.getAggressiveTexture(textureRegistry, patternGene)) : Optional.empty();
    }

    @Override
    public String baseTextureName() {
        return "dimetrodon";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY, FATextures.AGGRESSIVE);
    }
}
