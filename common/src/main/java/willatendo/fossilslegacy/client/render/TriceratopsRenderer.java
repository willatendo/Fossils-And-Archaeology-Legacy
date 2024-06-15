package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.TriceratopsModel;
import willatendo.fossilslegacy.server.entity.Triceratops;

public class TriceratopsRenderer extends DinosaurRenderer<Triceratops, TriceratopsModel> {
    public TriceratopsRenderer(Context context) {
        super(context, new TriceratopsModel(context.bakeLayer(FossilsLegacyModels.TRICERATOPS)), 0.15F);
    }

    @Override
    public ResourceLocation getTextureLocation(Triceratops triceratops) {
        return triceratops.textures()[triceratops.getSubSpecies()][triceratops.isBaby() ? 1 : 0];
    }
}
