package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.EggModel;
import willatendo.fossilslegacy.server.entity.Egg;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class EggRenderer extends MobRenderer<Egg, EggModel> {
	public EggRenderer(Context context) {
		super(context, new EggModel(context.bakeLayer(FossilsLegacyModels.EGG)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Egg egg) {
		return FossilsLegacyUtils.resource("textures/entities/egg/" + egg.getEgg().getTexture() + ".png");
	}
}
