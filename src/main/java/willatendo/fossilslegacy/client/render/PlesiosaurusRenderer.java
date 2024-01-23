package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.PlesiosaurusModel;
import willatendo.fossilslegacy.server.entity.Plesiosaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PlesiosaurusRenderer extends MobRenderer<Plesiosaurus, PlesiosaurusModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/plesiosaurus/plesiosaurus.png");

	public PlesiosaurusRenderer(Context context) {
		super(context, new PlesiosaurusModel(context.bakeLayer(FossilsLegacyModels.PLESIOSAURUS)), 0.3F);
	}

	@Override
	public void render(Plesiosaurus plesiosaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.shadowRadius = 0.15F * (float) plesiosaurus.getGrowthStage();
		super.render(plesiosaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Plesiosaurus plesiosaurus, PoseStack poseStack, float packedOverlay) {
		poseStack.scale(1.5F + (0.3F * (float) plesiosaurus.getGrowthStage()), 1.5F + (0.3F * (float) plesiosaurus.getGrowthStage()), 1.5F + (0.3F * (float) plesiosaurus.getGrowthStage()));
		super.scale(plesiosaurus, poseStack, packedOverlay);
	}

	@Override
	public ResourceLocation getTextureLocation(Plesiosaurus plesiosaurus) {
		return TEXTURE;
	}
}
