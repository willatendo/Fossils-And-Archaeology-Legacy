package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.entity.DrownedPirate;

public class DrownedPirateRenderer extends HumanoidMobRenderer<DrownedPirate, SkeletonModel<DrownedPirate>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/skeleton/skeleton.png");

	public DrownedPirateRenderer(Context context) {
		super(context, new SkeletonModel(context.bakeLayer(ModelLayers.SKELETON)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(DrownedPirate drownedPirate) {
		return TEXTURE;
	}
}
