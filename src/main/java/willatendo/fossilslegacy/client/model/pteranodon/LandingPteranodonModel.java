package willatendo.fossilslegacy.client.model.pteranodon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.server.entity.Pteranodon;

public class LandingPteranodonModel extends AbstractPteranodonModel {
	private final ModelPart root;

	public LandingPteranodonModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -5.0F, 2.12453F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(16, 22).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -6.0F, 1.084867F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(44, 9).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -8.0F, 0.7684471F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 17.0F, -9.0F, 0.5235988F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(8, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 1.130069F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 15.0F, -3.0F, 1.446489F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 17.0F, 2.0F, 0.587636F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_wing_1", CubeListBuilder.create().texOffs(16, 7).addBox(0.0F, 0.0F, -1.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 14.0F, 1.0F, 2.617994F, -0.4363323F, -2.792527F));
		partDefinition.addOrReplaceChild("right_wing_2", CubeListBuilder.create().texOffs(46, 18).addBox(0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-8.0F, 11.0F, 5.0F, -0.6108652F, 3.141593F, 0.0F));
		partDefinition.addOrReplaceChild("left_wing_1", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(2.0F, 14.0F, 1.0F, -2.617994F, -2.740167F, 2.792527F));
		partDefinition.addOrReplaceChild("left_wing_2", CubeListBuilder.create().texOffs(46, 23).addBox(0.0F, 0.0F, -1.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 11.0F, 5.0F, 0.6108652F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 4).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 21.0F, 2.0F, 0.2712166F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 21.0F, 2.0F, -0.2712166F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 19.0F, 5.0F, 0.2260139F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}

	@Override
	public void setupAnim(Pteranodon pteranodon, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
