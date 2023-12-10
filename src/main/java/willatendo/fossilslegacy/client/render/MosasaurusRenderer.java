package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.legacy.MosasaurusLegacyModel;
import willatendo.fossilslegacy.server.entity.Mosasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class MosasaurusRenderer extends DinosaurRenderer<Mosasaurus, EntityModel<Mosasaurus>, MosasaurusLegacyModel, MosasaurusLegacyModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/mosasaurus/mosasaurus.png");
	public static final ResourceLocation LEGACY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/mosasaurus/mosasaurus.png");

	public MosasaurusRenderer(Context context) {
		super(context, new MosasaurusLegacyModel(context.bakeLayer(FossilsLegacyModels.LEGACY_MOSASAURUS)), new MosasaurusLegacyModel(context.bakeLayer(FossilsLegacyModels.LEGACY_MOSASAURUS)), 0.3F);
//		this.addLayer(new MosasaurusEyesLayer(this));
	}

	@Override
	public void render(Mosasaurus mosasaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.shadowRadius = 0.15F * (float) mosasaurus.getGrowthStage();
		super.render(mosasaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Mosasaurus mosasaurus, PoseStack poseStack, float scale) {
		float newScale = this.growScale(mosasaurus, this.useLegacyModels());

		poseStack.scale(1.0F * (1 + newScale), 1.0F * (1 + newScale), 1.0F * (1 + newScale));
	}

	public float growScale(Mosasaurus mosasaurus, boolean isLegacyModel) {
		return isLegacyModel ? (mosasaurus.getGrowthStage() * 0.5F) : (mosasaurus.getGrowthStage() - (mosasaurus.isBaby() ? 0 : 2)) * 0.25F;
	}

	@Override
	public float legacyScaleFactor(Mosasaurus mosasaurus) {
		return 1.0F;
	}

	@Override
	public ResourceLocation getTextures(Mosasaurus mosasaurus) {
		return TEXTURE;
	}

	@Override
	public ResourceLocation getLegacyTextures(Mosasaurus mosasaurus) {
		return LEGACY_TEXTURE;
	}
}
