package willatendo.fossilslegacy.client.render;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.client.FossilsLegacyModels;
import willatendo.fossilslegacy.client.model.VelociraptorModel;
import willatendo.fossilslegacy.server.entity.Velociraptor;

public class VelociraptorRenderer extends MobRenderer<Velociraptor, VelociraptorModel> {
	public VelociraptorRenderer(Context context) {
		super(context, new VelociraptorModel(context.bakeLayer(FossilsLegacyModels.VELOCIRAPTOR)), 0.3F);
	}

	@Override
	protected void scale(Velociraptor velociraptor, PoseStack poseStack, float packedOverlay) {
		poseStack.scale(0.2F + (0.1F * (float) velociraptor.getGrowthStage()), 0.32F + (0.1F * (float) velociraptor.getGrowthStage()), 0.2F + (0.1F * (float) velociraptor.getGrowthStage()));
		super.scale(velociraptor, poseStack, packedOverlay);
	}

	@Override
	public ResourceLocation getTextureLocation(Velociraptor velociraptor) {
		return velociraptor.textures()[velociraptor.getSubSpecies()][velociraptor.isBaby() ? 1 : 0];
	}
}
