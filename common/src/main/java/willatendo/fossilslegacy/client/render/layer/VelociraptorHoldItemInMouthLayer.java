package willatendo.fossilslegacy.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.client.model.VelociraptorModel;
import willatendo.fossilslegacy.server.entity.Velociraptor;

public class VelociraptorHoldItemInMouthLayer extends RenderLayer<Velociraptor, VelociraptorModel> {
	private final ItemInHandRenderer itemInHandRenderer;

	public VelociraptorHoldItemInMouthLayer(RenderLayerParent<Velociraptor, VelociraptorModel> renderLayerParent, ItemInHandRenderer itemInHandRenderer) {
		super(renderLayerParent);
		this.itemInHandRenderer = itemInHandRenderer;
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int partialTicks, Velociraptor velociraptor, float position, float speed, float packedOverlay, float bob, float headPitch, float headYaw) {
		float ageOffset = (1.0F + 0.0F * ((float) velociraptor.getGrowthStage()));
		ItemStack heldItem = velociraptor.getHeldItem();
		poseStack.pushPose();
		if (Math.abs(this.getParentModel().leftThigh.xRot) >= 0.174532F) {
			poseStack.translate(0.0F, 0.15F, -0.95F);
		} else {
			poseStack.translate(0.0F, 0.4F, -0.75F);
		}
		poseStack.mulPose(Axis.ZP.rotation(60.0F));
		poseStack.mulPose(Axis.XP.rotation(-90.0F));
		poseStack.mulPose(Axis.ZP.rotation(20.0F));
		float scale = 0.625F;
		poseStack.scale(scale * ageOffset, scale * ageOffset, scale * ageOffset);
		this.itemInHandRenderer.renderItem(velociraptor, heldItem, ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, partialTicks);
		poseStack.popPose();
	}
}
