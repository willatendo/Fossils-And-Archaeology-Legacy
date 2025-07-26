package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.TyrannosaurusRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Tyrannosaurus;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

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
    public Optional<ResourceLocation> getAdditionalModel(TyrannosaurusRenderState tyrannosaurusRenderState, ModelType modelType) {
        ModelType.Models models = modelType.models();
        return tyrannosaurusRenderState.knockedOut ? this.additionalModel(models.knockedOutModel(), models) : Optional.empty();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Registry<Texture> textureRegistry, TyrannosaurusRenderState tyrannosaurusRenderState, Pattern pattern) {
        return (tyrannosaurusRenderState.knockedOut && this.hasKnockedOutTexture(textureRegistry, pattern)) ? Optional.of(this.getKnockedOutTexture(textureRegistry, pattern)) : (!tyrannosaurusRenderState.isBaby && !tyrannosaurusRenderState.isTame && this.hasAggressiveTexture(textureRegistry, pattern)) ? Optional.of(this.getAggressiveTexture(textureRegistry, pattern)) : Optional.empty();
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
