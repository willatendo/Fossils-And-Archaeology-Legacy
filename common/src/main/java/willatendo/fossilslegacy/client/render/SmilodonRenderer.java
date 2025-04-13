package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.state.SmilodonRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Smilodon;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.pattern.texture.Texture;

import java.util.List;

public class SmilodonRenderer extends DataDrivenModelMobRenderer<Smilodon, SmilodonRenderState> {
    public SmilodonRenderer(Context context) {
        super(context, 0.3F);
    }

    @Override
    public SmilodonRenderState createRenderState() {
        return new SmilodonRenderState();
    }

    @Override
    public void extractRenderState(Smilodon smilodon, SmilodonRenderState smilodonRenderState, float partialTick) {
        super.extractRenderState(smilodon, smilodonRenderState, partialTick);
        smilodonRenderState.sitAnimationState.copyFrom(smilodon.sitAnimationState);
    }

    @Override
    public String baseTextureName() {
        return "smilodon";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY);
    }
}
