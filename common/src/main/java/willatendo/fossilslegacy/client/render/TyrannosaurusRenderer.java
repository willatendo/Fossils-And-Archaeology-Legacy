package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.TyrannosaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Tyrannosaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;

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
    public ResourceLocation getBasePath() {
        return this.createPath("tyrannosaurus");
    }
}
