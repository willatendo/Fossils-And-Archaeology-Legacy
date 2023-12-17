package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.SmilodonModel;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class SmilodonRenderer extends MobRenderer<Smilodon, SmilodonModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/smilodon/smilodon.png");
	public static final ResourceLocation BABY_TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/smilodon/baby_smilodon.png");

	public SmilodonRenderer(Context context) {
		super(context, new SmilodonModel(context.bakeLayer(FossilsLegacyModels.SMILODON)), 0.3F);
	}

	@Override
	public void render(Smilodon smilodon, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		if (smilodon.isWet()) {
			float f = smilodon.getWetShade(packedOverlay);
			this.model.setColor(f, f, f);
		}

		super.render(smilodon, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Smilodon smilodon, PoseStack poseStack, float scale) {
		if (smilodon.isBaby()) {
			poseStack.scale(0.5F, 0.5F, 0.5F);
		}

		super.scale(smilodon, poseStack, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(Smilodon smilodon) {
		return smilodon.isBaby() ? BABY_TEXTURE : TEXTURE;
	}
}