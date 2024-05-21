package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.Brachiosaurus;

public class BrachiosaurusModel extends EntityModel<Brachiosaurus> {
	private final ModelPart root;
	private final ModelPart frontRightThigh;
	private final ModelPart frontLeftCalf;
	private final ModelPart frontLeftThigh;
	private final ModelPart frontRightCalf;
	private final ModelPart backRightThigh;
	private final ModelPart backLeftCalf;
	private final ModelPart backLeftThigh;
	private final ModelPart backRightCalf;

	public BrachiosaurusModel(ModelPart root) {
		this.root = root;
		this.frontRightThigh = root.getChild("front_right_thigh");
		this.frontRightCalf = root.getChild("front_right_calf");
		this.frontLeftThigh = root.getChild("front_left_thigh");
		this.frontLeftCalf = root.getChild("front_left_calf");
		this.backRightThigh = root.getChild("back_right_thigh");
		this.backRightCalf = root.getChild("back_right_calf");
		this.backLeftThigh = root.getChild("back_left_thigh");
		this.backLeftCalf = root.getChild("back_left_calf");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 14).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F).mirror(), PartPose.offset(0.0F, -6.0F, -10.5F));
		partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(50, 8).addBox(-1.5F, -1.0F, -6.5F, 3.0F, 2.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, -6.0F, -11.0F, 0.2617994F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(52, 0).addBox(-1.0F, -3.0F, -5.0F, 2.0F, 4.0F, 4.0F).mirror(), PartPose.offset(0.0F, -6.0F, -11.0F));
		partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -6.0F, -10.5F, -0.7853982F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -4.5F, -9.0F, -0.9599311F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_3", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -1.23464F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_4", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_5", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 2.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_6", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 4.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_7", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 6.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_8", CubeListBuilder.create().texOffs(34, 11).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 3.0F).mirror(), PartPose.offsetAndRotation(0.0F, 6.0F, -6.5F, -0.9637522F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("lower_neck_1", CubeListBuilder.create().texOffs(32, 24).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 4.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 7.0F, -5.0F, -0.8377581F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("lower_neck_2", CubeListBuilder.create().texOffs(10, 21).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 7.0F, -5.0F, -0.3907885F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 7.0F, 6.0F).mirror(), PartPose.offsetAndRotation(0.0F, 8.0F, -3.0F, -0.1115358F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(28, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.3346075F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("front_right_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(0.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F).mirror(), PartPose.offset(3.0F, 12.0F, -3.5F));
		partDefinition.addOrReplaceChild("front_right_calf", CubeListBuilder.create().texOffs(0, 24).addBox(0.5F, 7.0F, -2.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(3.0F, 12.0F, -3.5F));
		partDefinition.addOrReplaceChild("front_left_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F).mirror(), PartPose.offset(-3.0F, 12.0F, -3.5F));
		partDefinition.addOrReplaceChild("front_left_calf", CubeListBuilder.create().texOffs(0, 24).addBox(-2.5F, 7.0F, -2.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(-3.0F, 12.0F, -3.5F));
		partDefinition.addOrReplaceChild("back_right_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F).mirror(), PartPose.offset(3.0F, 14.0F, 4.5F));
		partDefinition.addOrReplaceChild("back_right_calf", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, 5.0F, -1.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(3.0F, 14.0F, 4.5F));
		partDefinition.addOrReplaceChild("back_left_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F).mirror(), PartPose.offset(-3.0F, 14.0F, 4.5F));
		partDefinition.addOrReplaceChild("back_left_calf", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, 5.0F, -1.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(-3.0F, 14.0F, 4.5F));
		partDefinition.addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 11.0F, 6.0F, -0.7064018F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail_mid", CubeListBuilder.create().texOffs(18, 13).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, 8.0F, -0.5576873F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail_end", CubeListBuilder.create().texOffs(34, 17).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 16.5F, 10.5F, -0.3717943F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}

	@Override
	public void setupAnim(Brachiosaurus brachiosaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.frontRightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.frontRightCalf.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.frontLeftThigh.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
		this.frontLeftCalf.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
		this.backLeftThigh.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
		this.backLeftCalf.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
		this.backRightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.backRightCalf.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
