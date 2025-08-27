package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Cryolophosaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.CompositeTextureRules;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.FACompositeTextureRuleSources;

public class CryolophosaurusRenderer extends DataDrivenModelDinosaurRenderer<Cryolophosaurus, DinosaurRenderState> {
    public CryolophosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, 0.15F);
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getSkinCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.CRYOLOPHOSAURUS_SKIN;
    }

    @Override
    public ResourceKey<CompositeTextureRules.RuleSource> getPatternCompositeTextureRuleSource() {
        return FACompositeTextureRuleSources.CRYOLOPHOSAURUS_PATTERN;
    }

    @Override
    public ResourceLocation getBasePath() {
        return this.createPath("cryolophosaurus");
    }
}
