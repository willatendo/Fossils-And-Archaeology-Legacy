package willatendo.fossilslegacy.client.render;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.MammothModel;
import willatendo.fossilslegacy.client.model.legacy.MammothLegacyModel;
import willatendo.fossilslegacy.server.entity.Mammoth;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class MammothRenderer extends DinosaurRenderer<Mammoth, EntityModel<Mammoth>, MammothModel, MammothLegacyModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/mammoth/mammoth.png");
	public static final ResourceLocation SHEARED_TEXTURE = FossilsLegacyUtils.resource("textures/entities/mammoth/sheared_mammoth.png");
	public static final ResourceLocation BABY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/mammoth/baby_mammoth.png");

	public static final ResourceLocation LEGACY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/mammoth/mammoth.png");
	public static final ResourceLocation SHEARED_LEGACY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/mammoth/sheared_mammoth.png");
	public static final ResourceLocation BABY_LEGACY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/mammoth/baby_mammoth.png");

	public MammothRenderer(Context context) {
		super(context, new MammothModel(context.bakeLayer(FossilsLegacyModels.MAMMOTH)), new MammothLegacyModel(context.bakeLayer(FossilsLegacyModels.LEGACY_MAMMOTH)), 0.3F);
	}

	@Override
	public float legacyScaleFactor(Mammoth mammoth) {
		return mammoth.isBaby() ? 1.0F : 4.0F;
	}

	@Override
	public ResourceLocation getTextures(Mammoth mammoth) {
		return mammoth.isBaby() ? BABY_TEXTURE : (mammoth.isSheared() ? SHEARED_TEXTURE : TEXTURE);
	}

	@Override
	public ResourceLocation getLegacyTextures(Mammoth mammoth) {
		return mammoth.isBaby() ? BABY_LEGACY_TEXTURE : (mammoth.isSheared() ? SHEARED_LEGACY_TEXTURE : LEGACY_TEXTURE);
	}
}
