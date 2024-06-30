package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModelLayers;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.server.entity.Egg;

public class EggRenderer extends MobRenderer<Egg, EggModel> {
    public EggRenderer(Context context) {
        super(context, new EggModel(context.bakeLayer(FossilsLegacyModelLayers.EGG)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Egg egg) {
        return egg.getEggVariant().value().texture();
    }
}
