package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.state.DodoRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Dodo;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

import java.util.List;

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
    public String baseTextureName() {
        return "dodo";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE);
    }
}
