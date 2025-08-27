package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Elasmotherium;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.FACompositeTextureRuleSources;

public class ElasmotheriumRenderer extends DataDrivenModelDinosaurRenderer<Elasmotherium, DinosaurRenderState> {
    public ElasmotheriumRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getSkinCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.ELASMOTHERIUM_SKIN;
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getPatternCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.ELASMOTHERIUM_SKIN;
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("elasmotherium");
    }
}
