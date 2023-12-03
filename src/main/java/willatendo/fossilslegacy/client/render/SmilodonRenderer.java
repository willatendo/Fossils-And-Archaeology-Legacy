package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.CommonSmilodonRenderer;
import willatendo.fossilslegacy.client.model.SmilodonModel;
import willatendo.fossilslegacy.client.model.legacy.SmilodonLegacyModel;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class SmilodonRenderer extends DinosaurRenderer<Smilodon, EntityModel<Smilodon>, SmilodonModel, SmilodonLegacyModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/smilodon/smilodon.png");
	public static final ResourceLocation LEGACY_ADULT_TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/smilodon/adult_smilodon.png");
	public static final ResourceLocation LEGACY_BABY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/smilodon/baby_smilodon.png");

	public SmilodonRenderer(Context context) {
		super(context, new SmilodonModel(context.bakeLayer(FossilsLegacyModels.SMILODON)), new SmilodonLegacyModel(context.bakeLayer(FossilsLegacyModels.LEGACY_SMILODON)), 0.3F);
	}

	@Override
	public void render(Smilodon smilodon, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		if (smilodon.isWet()) {
			float f = smilodon.getWetShade(packedOverlay);
			((CommonSmilodonRenderer) this.model).setColor(f, f, f);
		}

		super.render(smilodon, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Smilodon smilodon, PoseStack poseStack, float scale) {
		if (this.useLegacyModels() & smilodon.isBaby()) {
			poseStack.scale(0.5F, 0.5F, 0.5F);
		}

		super.scale(smilodon, poseStack, scale);
	}

	@Override
	public float legacyScaleFactor(Smilodon smilodon) {
		return 2.0F;
	}

	@Override
	public ResourceLocation getTextures(Smilodon smilodon) {
		return TEXTURE;
	}

	@Override
	public ResourceLocation getLegacyTextures(Smilodon smilodon) {
		return smilodon.isBaby() ? LEGACY_BABY_TEXTURE : LEGACY_ADULT_TEXTURE;
	}
}
