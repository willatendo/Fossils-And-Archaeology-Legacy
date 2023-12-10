package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.legacy.GroundPteranodonLegacyModel;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PteranodonRenderer extends MobRenderer<Pteranodon, GroundPteranodonLegacyModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/legacy/pteranodon/pteranodon.png");

	public PteranodonRenderer(Context context) {
		super(context, new GroundPteranodonLegacyModel(context.bakeLayer(FossilsLegacyModels.LEGACY_GROUND_PTERANODON)), 0.5F);
	}

	@Override
	public void render(Pteranodon pteranodon, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.shadowRadius = 0.15F * (float) pteranodon.getGrowthStage();
		super.render(pteranodon, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Pteranodon pteranodon, PoseStack poseStack, float scale) {
		float newScale = this.growScale(pteranodon, true);

		poseStack.scale(1.0F * (1 + newScale), 1.0F * (1 + newScale), 1.0F * (1 + newScale));
	}

	public float growScale(Pteranodon pteranodon, boolean isLegacyModel) {
		return isLegacyModel ? (pteranodon.getGrowthStage() * 0.25F) : (pteranodon.getGrowthStage() - (pteranodon.isBaby() ? 0 : 2)) * 0.25F;
	}

	@Override
	public ResourceLocation getTextureLocation(Pteranodon pteranodon) {
		return TEXTURE;
	}
}
