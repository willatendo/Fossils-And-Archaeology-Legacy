package fossilslegacy.client.render;

import fossilslegacy.client.FossilsLegacyModels;
import fossilslegacy.client.model.EggModel;
import fossilslegacy.server.entity.Egg;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EggRenderer extends MobRenderer<Egg, EggModel> {
	public static final ResourceLocation TRICERATOPS = FossilsLegacyUtils.resource("textures/entities/egg/triceratops.png");

	public EggRenderer(Context context) {
		super(context, new EggModel(context.bakeLayer(FossilsLegacyModels.EGG)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Egg egg) {
		return FossilsLegacyUtils.resource("textures/entities/egg/" + egg.getEgg().getTexture() + ".png");
	}
}
