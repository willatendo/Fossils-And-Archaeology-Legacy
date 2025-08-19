package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.render.layer.MammothFurLayer;
import willatendo.fossilslegacy.client.state.MammothRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Mammoth;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;

public class MammothRenderer extends DataDrivenModelDinosaurRenderer<Mammoth, MammothRenderState> {
    public MammothRenderer(Context context) {
        super(context, 0.3F);
        this.addLayer(new MammothFurLayer(this));
    }

    @Override
    public MammothRenderState createRenderState() {
        return new MammothRenderState();
    }

    @Override
    public void extractRenderState(Mammoth mammoth, MammothRenderState mammothRenderState, float partialTick) {
        super.extractRenderState(mammoth, mammothRenderState, partialTick);
        mammothRenderState.isSheared = mammoth.isSheared();
        mammothRenderState.woolColor = mammoth.getColor();
        mammothRenderState.id = mammoth.getId();
    }

    @Override
    public String baseTextureName() {
        return "mammoth";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY, FATextures.FUR, FATextures.BABY, FATextures.BABY_FUR, FATextures.SHEARED);
    }
}
