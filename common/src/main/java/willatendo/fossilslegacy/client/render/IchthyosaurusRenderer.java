package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.render.layer.IchthyosaurusCarryingItemLayer;
import willatendo.fossilslegacy.client.state.IchthyosaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Ichthyosaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.FACompositeTextureRuleSources;

public class IchthyosaurusRenderer extends DataDrivenModelDinosaurRenderer<Ichthyosaurus, IchthyosaurusRenderState> {
    public IchthyosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.5F);
        this.addLayer(new IchthyosaurusCarryingItemLayer(this));
    }

    @Override
    public IchthyosaurusRenderState createRenderState() {
        return new IchthyosaurusRenderState();
    }

    @Override
    public void extractRenderState(Ichthyosaurus ichthyosaurus, IchthyosaurusRenderState ichthyosaurusRenderState, float partialTick) {
        super.extractRenderState(ichthyosaurus, ichthyosaurusRenderState, partialTick);
        IchthyosaurusRenderState.extractHeldItemRenderState(ichthyosaurus, ichthyosaurusRenderState, this.itemModelResolver);
        ichthyosaurusRenderState.isMoving = ichthyosaurus.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7;
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getSkinCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.ICHTHYOSAURUS_SKIN;
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getPatternCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.ICHTHYOSAURUS_PATTERN;
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("ichthyosaurus");
    }
}
