package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.render.layer.EyeLayer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.cretaceous.Baryonyx;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;

import java.util.List;
import java.util.Optional;

public class BaryonyxRenderer extends DataDrivenModelMobRenderer<Baryonyx, DinosaurRenderState> {
    public BaryonyxRenderer(EntityRendererProvider.Context context) {
        super(context, 0.3F);
        this.addLayer(new EyeLayer<>(this, true));
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    protected Optional<ResourceLocation> getAdditionalTexture(Registry<Texture> textureRegistry, DinosaurRenderState dinosaurRenderState, Pattern pattern) {
        return (!dinosaurRenderState.isBaby && !dinosaurRenderState.isTame && this.hasAggressiveTexture(textureRegistry, pattern)) ? Optional.of(this.getAggressiveTexture(textureRegistry, pattern)) : Optional.empty();
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE);
    }

    @Override
    public String baseTextureName() {
        return "baryonyx";
    }
}
