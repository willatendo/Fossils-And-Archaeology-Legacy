package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.pteranodon.AbstractPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.FlyingPteranodonModel;
import willatendo.fossilslegacy.client.model.pteranodon.GroundPteranodonModel;
import willatendo.fossilslegacy.server.entity.Pteranodon;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PteranodonRenderer extends MobRenderer<Pteranodon, AbstractPteranodonModel> {
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/entities/animals/pteranodon/pteranodon.png");
	private final GroundPteranodonModel groundPteranodonLegacyModel;
	private final FlyingPteranodonModel flyingPteranodonLegacyModel;

	public PteranodonRenderer(Context context) {
		super(context, new GroundPteranodonModel(context.bakeLayer(FossilsLegacyModels.GROUND_PTERANODON)), 0.5F);
		this.groundPteranodonLegacyModel = new GroundPteranodonModel(context.bakeLayer(FossilsLegacyModels.GROUND_PTERANODON));
		this.flyingPteranodonLegacyModel = new FlyingPteranodonModel(context.bakeLayer(FossilsLegacyModels.FLYING_PTERANODON));
	}

	@Override
	public void render(Pteranodon pteranodon, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.model = pteranodon.isFlying ? this.flyingPteranodonLegacyModel : this.groundPteranodonLegacyModel;
		this.shadowRadius = 0.15F * (float) pteranodon.getGrowthStage();
		super.render(pteranodon, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Pteranodon pteranodon, PoseStack poseStack, float packedOverlay) {
		poseStack.scale(0.8F * (0.2F + (float) pteranodon.getGrowthStage()), 0.8F * (0.2F + (float) pteranodon.getGrowthStage()), 0.8F * (0.2F + (float) pteranodon.getGrowthStage()));
		super.scale(pteranodon, poseStack, packedOverlay);
	}

	@Override
	public ResourceLocation getTextureLocation(Pteranodon pteranodon) {
		return TEXTURE;
	}
}
