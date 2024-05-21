package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.TriceratopsModel;
import willatendo.fossilslegacy.server.entity.Triceratops;

public class TriceratopsRenderer extends MobRenderer<Triceratops, TriceratopsModel> {
	public TriceratopsRenderer(Context context) {
		super(context, new TriceratopsModel(context.bakeLayer(FossilsLegacyModels.TRICERATOPS)), 0.15F);
	}

	@Override
	public void render(Triceratops triceratops, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.shadowRadius = 0.15F * (float) triceratops.getGrowthStage();
		super.render(triceratops, packedLight, packedOverlay, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Triceratops triceratops, PoseStack poseStack, float packedOverlay) {
		poseStack.scale(1.5F + (0.3F * (float) triceratops.getGrowthStage()), 1.5F + (0.3F * (float) triceratops.getGrowthStage()), 1.5F + (0.3F * (float) triceratops.getGrowthStage()));
		super.scale(triceratops, poseStack, packedOverlay);
	}

	@Override
	public ResourceLocation getTextureLocation(Triceratops triceratops) {
		return triceratops.textures()[triceratops.getSubSpecies()][triceratops.isBaby() ? 1 : 0];
	}
}
