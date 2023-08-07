package willatendo.fossilslegacy.client.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.MammothModel;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class MammothRenderer extends MobRenderer<Mammoth, MammothModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/mammoth/mammoth.png");
	public static final ResourceLocation SHEARED_TEXTURE = FossilsLegacyUtils.resource("textures/entities/mammoth/sheared_mammoth.png");
	public static final ResourceLocation BABY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/mammoth/baby_mammoth.png");

	public MammothRenderer(Context context) {
		super(context, new MammothModel(context.bakeLayer(FossilsLegacyModels.MAMMOTH)), 0.3F);
	}

	@Override
	public ResourceLocation getTextureLocation(Mammoth mammoth) {
		return mammoth.isBaby() ? BABY_TEXTURE : (mammoth.isSheared() ? SHEARED_TEXTURE : TEXTURE);
	}
}
