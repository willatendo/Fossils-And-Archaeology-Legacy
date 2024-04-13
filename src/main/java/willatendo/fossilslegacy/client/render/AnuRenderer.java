package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.AnuModel;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class AnuRenderer extends MobRenderer<Anu, AnuModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/anu/anu.png");
	public static final ResourceLocation CHARGING = FossilsLegacyUtils.resource("textures/entities/anu/anu_charging.png");

	public AnuRenderer(Context context) {
		super(context, new AnuModel(context.bakeLayer(FossilsLegacyModels.ANU)), 0.3F);
		this.addLayer(new CustomHeadLayer(this, context.getModelSet(), 1.0F, 1.0F, 1.0F, context.getItemInHandRenderer()));
		this.addLayer(new ElytraLayer(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Anu anu) {
		return TEXTURE;
	}
}
