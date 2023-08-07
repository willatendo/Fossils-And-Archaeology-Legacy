package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.SmilodonModel;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class SmilodonRenderer extends MobRenderer<Smilodon, SmilodonModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/smilodon/smilodon.png");

	public SmilodonRenderer(Context context) {
		super(context, new SmilodonModel(context.bakeLayer(FossilsLegacyModels.SMILODON)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Smilodon smilodon) {
		return TEXTURE;
	}
}
