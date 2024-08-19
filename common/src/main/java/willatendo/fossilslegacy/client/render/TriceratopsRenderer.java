package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.dinosaur.TriceratopsModel;
import willatendo.fossilslegacy.client.model.dinosaur.legacy.LegacyTriceratopsModel;
import willatendo.fossilslegacy.server.entity.Triceratops;

public class TriceratopsRenderer extends LegacyEntityRenderer<Triceratops> {
    public TriceratopsRenderer(Context context) {
        super(context, new TriceratopsModel(context.bakeLayer(FossilsLegacyModelLayers.TRICERATOPS.getFirst())), new LegacyTriceratopsModel(context.bakeLayer(FossilsLegacyModelLayers.TRICERATOPS.getSecond())), 0.3F);
    }

    @Override
    protected ResourceLocation legacyTextureLocation(Triceratops triceratops) {
        return triceratops.legacyTextures()[triceratops.getSubSpecies()][triceratops.isBaby() ? 1 : 0];
    }

    @Override
    protected ResourceLocation textureLocation(Triceratops triceratops) {
        return triceratops.textures()[triceratops.getSubSpecies()][triceratops.isBaby() ? 1 : 0];
    }
}
