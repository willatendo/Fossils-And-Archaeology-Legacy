package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.client.render.json.DataDrivenModelDinosaurRenderer;
import willatendo.fossilslegacy.client.render.layer.EyeLayer;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Brachiosaurus;
import willatendo.fossilslegacy.server.gene.cosmetics.FATextures;
import willatendo.fossilslegacy.server.gene.cosmetics.texture.Texture;

import java.util.List;

public class BrachiosaurusRenderer extends DataDrivenModelDinosaurRenderer<Brachiosaurus, DinosaurRenderState> {
    public BrachiosaurusRenderer(Context context) {
        super(context, 0.3F);
        this.addLayer(new EyeLayer<>(this, false));
    }

    @Override
    public DinosaurRenderState createRenderState() {
        return new DinosaurRenderState();
    }

    @Override
    public String baseTextureName() {
        return "brachiosaurus";
    }

    @Override
    public List<ResourceKey<Texture>> requiredTextures() {
        return List.of(FATextures.BASE, FATextures.BABY);
    }
}
