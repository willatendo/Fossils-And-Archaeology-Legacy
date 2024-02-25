package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.FutabasaurusModel;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FutabasaurusRenderer extends MobRenderer<Futabasaurus, FutabasaurusModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/futabasaurus/futabasaurus.png");

	public FutabasaurusRenderer(Context context) {
		super(context, new FutabasaurusModel(context.bakeLayer(FossilsLegacyModels.FUTABASAURUS)), 0.3F);
	}

	@Override
	public void render(Futabasaurus futabasaurus, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.shadowRadius = 0.15F * (float) futabasaurus.getGrowthStage();
		super.render(futabasaurus, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Futabasaurus futabasaurus, PoseStack poseStack, float packedOverlay) {
		poseStack.scale(1.5F + (0.3F * (float) futabasaurus.getGrowthStage()), 1.5F + (0.3F * (float) futabasaurus.getGrowthStage()), 1.5F + (0.3F * (float) futabasaurus.getGrowthStage()));
		super.scale(futabasaurus, poseStack, packedOverlay);
	}

	@Override
	public ResourceLocation getTextureLocation(Futabasaurus futabasaurus) {
		return TEXTURE;
	}
}
