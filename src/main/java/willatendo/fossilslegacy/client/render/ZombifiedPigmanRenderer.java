package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.model.ZombifiedPigmanModel;
import willatendo.fossilslegacy.server.entity.ZombifiedPigman;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class ZombifiedPigmanRenderer extends AbstractZombieRenderer<ZombifiedPigman, ZombifiedPigmanModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/zombified_pigman.png");

	public ZombifiedPigmanRenderer(Context context) {
		super(context, new ZombifiedPigmanModel(context.bakeLayer(ModelLayers.ZOMBIE)), new ZombifiedPigmanModel(context.bakeLayer(ModelLayers.ZOMBIE_INNER_ARMOR)), new ZombifiedPigmanModel(context.bakeLayer(ModelLayers.ZOMBIE_OUTER_ARMOR)));
	}

	@Override
	public ResourceLocation getTextureLocation(ZombifiedPigman zombifiedPigman) {
		return TEXTURE;
	}
}
