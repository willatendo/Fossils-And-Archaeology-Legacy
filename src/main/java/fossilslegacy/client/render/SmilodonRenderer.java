package fossilslegacy.client.render;

import fossilslegacy.client.FossilsLegacyModels;
import fossilslegacy.client.model.SmilodonModel;
import fossilslegacy.server.entity.Smilodon;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

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
