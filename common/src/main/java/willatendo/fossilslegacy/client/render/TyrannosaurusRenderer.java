package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.state.TyrannosaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Tyrannosaurus;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.information.TextureType;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

import java.util.List;
import java.util.Optional;

public class TyrannosaurusRenderer extends DataDrivenModelMobRenderer<Tyrannosaurus, TyrannosaurusRenderState> {
    public TyrannosaurusRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public TyrannosaurusRenderState createRenderState() {
        return new TyrannosaurusRenderState();
    }

    @Override
    public Optional<ResourceLocation> getAdditionalModel(TyrannosaurusRenderState tyrannosaurusRenderState, ModelType modelType) {
        ModelType.Models models = modelType.models();
        return tyrannosaurusRenderState.knockedOut ? this.additionalModel(models.knockedOutModel(), models) : Optional.empty();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(TyrannosaurusRenderState tyrannosaurusRenderState, Pattern pattern) {
        return (tyrannosaurusRenderState.knockedOut && this.hasKnockedOutTexture(pattern)) ? Optional.of(this.getKnockedOutTexture(pattern)) : (!tyrannosaurusRenderState.isBaby && !tyrannosaurusRenderState.isTame && this.hasAggressiveTexture(pattern)) ? Optional.of(this.getAggressiveTexture(pattern)) : Optional.empty();
    }

    @Override
    public String baseTextureName() {
        return "tyrannosaurus";
    }

    @Override
    public List<TextureType> requiredTextures() {
        return List.of(TextureType.BASE, TextureType.BABY, TextureType.AGGRESSIVE, TextureType.KNOCKED_OUT);
    }
}
