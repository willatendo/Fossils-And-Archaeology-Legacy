package willatendo.fossilslegacy.client.model.fossils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import willatendo.fossilslegacy.server.entity.Fossil;

public abstract class AbstractSkeletonModel extends EntityModel<Fossil> {
	private final ModelPart root;

	public AbstractSkeletonModel(ModelPart root) {
		this.root = root;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(Fossil fossil, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
