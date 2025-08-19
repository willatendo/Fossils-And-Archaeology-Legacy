package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.TyrannosaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Tyrannosaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;
import java.util.Optional;

public class TyrannosaurusRenderer extends DataDrivenModelDinosaurRenderer<Tyrannosaurus, TyrannosaurusRenderState> {
    public TyrannosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public TyrannosaurusRenderState createRenderState() {
        return new TyrannosaurusRenderState();
    }

    @Override
    public Optional<ResourceLocation> getAdditionalModel(TyrannosaurusRenderState tyrannosaurusRenderState, ModelGene modelGene) {
        ModelGene.Models models = modelGene.models();
        return tyrannosaurusRenderState.knockedOut ? this.additionalModel(models.knockedOutModel(), models) : Optional.empty();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Registry<Texture> textureRegistry, TyrannosaurusRenderState tyrannosaurusRenderState, PatternGene patternGene) {
        return (tyrannosaurusRenderState.knockedOut && this.hasKnockedOutTexture(textureRegistry, patternGene)) ? Optional.of(this.getKnockedOutTexture(textureRegistry, patternGene)) : (!tyrannosaurusRenderState.isBaby && !tyrannosaurusRenderState.isTame && this.hasAggressiveTexture(textureRegistry, patternGene)) ? Optional.of(this.getAggressiveTexture(textureRegistry, patternGene)) : Optional.empty();
    }

    @Override
    public String baseTextureName() {
        return "tyrannosaurus";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY, FATextures.AGGRESSIVE, FATextures.KNOCKED_OUT);
    }
}
