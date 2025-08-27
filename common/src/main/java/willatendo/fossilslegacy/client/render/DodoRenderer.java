package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DodoRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Dodo;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.FACompositeTextureRuleSources;

public class DodoRenderer extends DataDrivenModelDinosaurRenderer<Dodo, DodoRenderState> {
    public DodoRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    public DodoRenderState createRenderState() {
        return new DodoRenderState();
    }

    @Override
    public void extractRenderState(Dodo dodo, DodoRenderState dodoRenderState, float partialTick) {
        super.extractRenderState(dodo, dodoRenderState, partialTick);
        dodoRenderState.fallAnimationState.copyFrom(dodo.fallAnimationState);
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getSkinCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.DODO_SKIN;
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getPatternCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.DODO_PATTERN;
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("dodo");
    }
}
