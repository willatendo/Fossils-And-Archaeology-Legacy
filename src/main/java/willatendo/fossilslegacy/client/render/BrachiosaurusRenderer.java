package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.legacy.BrachiosaurusLegacyModel;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class BrachiosaurusRenderer extends DinosaurRenderer<Brachiosaurus, EntityModel<Brachiosaurus>, BrachiosaurusLegacyModel, BrachiosaurusLegacyModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/brachiosaurus/brachiosaurus.png");
	public static final ResourceLocation LEGACY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/brachiosaurus/brachiosaurus.png");

	public BrachiosaurusRenderer(Context context) {
		super(context, new BrachiosaurusLegacyModel(context.bakeLayer(FossilsLegacyModels.BRACHIOSAURUS)), new BrachiosaurusLegacyModel(context.bakeLayer(FossilsLegacyModels.BRACHIOSAURUS)), 0.3F);
	}

	@Override
	public void render(Brachiosaurus brachiosaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.shadowRadius = 0.15F * (float) brachiosaurus.getGrowthStage();
		super.render(brachiosaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Brachiosaurus brachiosaurus, PoseStack poseStack, float scale) {
		float newScale = this.growScale(brachiosaurus, this.useLegacyModels());

		poseStack.scale(1.0F * (1 + newScale), 1.0F * (1 + newScale), 1.0F * (1 + newScale));
	}

	public float growScale(Brachiosaurus brachiosaurus, boolean isLegacyModel) {
		return isLegacyModel ? (brachiosaurus.getGrowthStage() * 0.5F) : (brachiosaurus.getGrowthStage() - (brachiosaurus.isBaby() ? 0 : 2)) * 0.25F;
	}

	@Override
	public float legacyScaleFactor(Brachiosaurus brachiosaurus) {
		return 1.0F;
	}

	@Override
	public ResourceLocation getTextures(Brachiosaurus brachiosaurus) {
		return TEXTURE;
	}

	@Override
	public ResourceLocation getLegacyTextures(Brachiosaurus brachiosaurus) {
		return LEGACY_TEXTURE;
	}
}
