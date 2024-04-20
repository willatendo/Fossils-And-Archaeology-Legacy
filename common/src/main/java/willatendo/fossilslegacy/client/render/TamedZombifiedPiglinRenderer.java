package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

public class TamedZombifiedPiglinRenderer extends HumanoidMobRenderer<Mob, PiglinModel<Mob>> {
	private static final ResourceLocation TEXTURES = new ResourceLocation("textures/entity/piglin/zombified_piglin.png");

	public TamedZombifiedPiglinRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, ModelLayerLocation modelLayerLocation2, ModelLayerLocation modelLayerLocation3, boolean bl) {
		super(context, TamedZombifiedPiglinRenderer.createModel(context.getModelSet(), modelLayerLocation, bl), 0.5f, 1.0019531f, 1.0f, 1.0019531f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidArmorModel(context.bakeLayer(modelLayerLocation2)), new HumanoidArmorModel(context.bakeLayer(modelLayerLocation3)), context.getModelManager()));
	}

	private static PiglinModel<Mob> createModel(EntityModelSet entityModelSet, ModelLayerLocation modelLayerLocation, boolean bl) {
		PiglinModel<Mob> piglinModel = new PiglinModel<Mob>(entityModelSet.bakeLayer(modelLayerLocation));
		if (bl) {
			piglinModel.rightEar.visible = false;
		}
		return piglinModel;
	}

	@Override
	public ResourceLocation getTextureLocation(Mob mob) {
		return TEXTURES;
	}

	@Override
	protected boolean isShaking(Mob mob) {
		return super.isShaking(mob) || mob instanceof AbstractPiglin && ((AbstractPiglin) mob).isConverting();
	}
}
