package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.fossils.AbstractSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.BrachiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PlesiosaurusSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.PteranodonSkeletonModel;
import willatendo.fossilslegacy.client.model.fossils.TriceratopsSkeletonModel;
import willatendo.fossilslegacy.server.entity.Fossil;
import willatendo.fossilslegacy.server.entity.FossilTypes;
import willatendo.fossilslegacy.server.entity.FossilTypes.FossilScaleFactor;

public class FossilRenderer extends MobRenderer<Fossil, AbstractSkeletonModel> {
	private AbstractSkeletonModel[] models;

	public FossilRenderer(Context context) {
		super(context, new BrachiosaurusSkeletonModel(context.bakeLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON)), 0.5F);
		this.models = new AbstractSkeletonModel[] { new BrachiosaurusSkeletonModel(context.bakeLayer(FossilsLegacyModels.BRACHIOSAURUS_SKELETON)), new PlesiosaurusSkeletonModel(context.bakeLayer(FossilsLegacyModels.PLESIOSAURUS_SKELETON)), new PteranodonSkeletonModel(context.bakeLayer(FossilsLegacyModels.PTERANODON_SKELETON)), new TriceratopsSkeletonModel(context.bakeLayer(FossilsLegacyModels.TRICERATOPS_SKELETON)) };
	}

	@Override
	public void render(Fossil fossil, float packedLight, float packedOverlay, PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks) {
		this.shadowRadius = 0.15F * (float) fossil.getSize();
		this.model = this.models[fossil.getFossil()];

		super.render(fossil, packedOverlay, packedLight, poseStack, multiBufferSource, partialTicks);
	}

	@Override
	protected void scale(Fossil fossil, PoseStack poseStack, float packedOverlay) {
		FossilTypes fossils = FossilTypes.get(fossil.getFossil());
		FossilScaleFactor scaleFactor = fossils.getScaleFactor(fossil);

		poseStack.scale(scaleFactor.x(), scaleFactor.y(), scaleFactor.z());

		super.scale(fossil, poseStack, packedOverlay);
	}

	@Override
	public ResourceLocation getTextureLocation(Fossil fossil) {
		return FossilTypes.get(fossil.getFossil()).getFossilTexture();
	}
}
