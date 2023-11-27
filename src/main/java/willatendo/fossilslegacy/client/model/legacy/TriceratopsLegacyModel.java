package willatendo.fossilslegacy.client.model.legacy;

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
import willatendo.fossilslegacy.server.entity.Triceratops;

public class TriceratopsLegacyModel extends EntityModel<Triceratops> {
	private final ModelPart root;
	private final ModelPart lowerBody;
	private final ModelPart back;
	private final ModelPart tail;
	private final ModelPart rightFrontThigh;
	private final ModelPart rightFrontLeg;
	private final ModelPart leftFrontThigh;
	private final ModelPart leftFrontLeg;
	private final ModelPart rightBackThigh;
	private final ModelPart rightBackLeg;
	private final ModelPart leftBackThigh;
	private final ModelPart leftBackLeg;

	public TriceratopsLegacyModel(ModelPart root) {
		this.root = root;
		this.lowerBody = root.getChild("lower_body");
		this.back = root.getChild("back");
		this.tail = root.getChild("tail");
		this.rightFrontThigh = root.getChild("right_front_thigh");
		this.rightFrontLeg = root.getChild("right_front_leg");
		this.leftFrontThigh = root.getChild("left_front_thigh");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.rightBackThigh = root.getChild("right_back_thigh");
		this.rightBackLeg = root.getChild("right_back_leg");
		this.leftBackThigh = root.getChild("left_back_thigh");
		this.leftBackLeg = root.getChild("left_back_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(42, 0).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 20.0F, -1.0F));
		partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(48, 10).addBox(-2.5F, -0.2F, 0.0F, 5.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.2712F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(54, 17).addBox(-1.5F, 0.0F, 3.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.4519F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(54, 21).addBox(-1.0F, 2.0F, 4.0F, 2.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.1808F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(20, 0).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.4F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("crest_overlay", CubeListBuilder.create().texOffs(20, 8).addBox(-5.0F, -9.0F, 0.0F, 10.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.4F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, 0.1396F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 10).addBox(-1F, -2.5F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, 0.81364F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("nose_horn", CubeListBuilder.create().texOffs(24, 24).addBox(-0.5F, 2.0F, -3.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -1.13F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_horn_base", CubeListBuilder.create().texOffs(24, 27).addBox(-2.0F, -4.0F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(33, 27).addBox(-2.0F, -4.0F, -6.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_horn_base", CubeListBuilder.create().texOffs(24, 27).addBox(1.0F, -4.0F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(33, 27).addBox(1.0F, -4.0F, -6.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_front_thigh", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, 1.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 19.0F, -2.0F));
		partDefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(8, 19).addBox(-3.0F, 1.0F, -6.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 19.0F, -2.0F, 1.0F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_front_thigh", CubeListBuilder.create().texOffs(0, 16).addBox(2.0F, 2.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 18.0F, -2.0F));
		partDefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(16, 19).addBox(2.0F, 1.0F, -6.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.0F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_back_thigh", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 18.0F, 2.0F));
		partDefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(24, 19).addBox(-3.0F, 2.0F, -5.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 1.0F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_back_thigh", CubeListBuilder.create().texOffs(12, 24).addBox(2.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 18.0F, 2.0F));
		partDefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(32, 19).addBox(2.0F, 2.0F, -5.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 1.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}

//	public void RunningPose(float f, float f1, float f2, float f3, float f4, float f5, boolean modelized) {
//		super.setRotationAngles(f, f1, f2, f3, f4, f5);
//		if (modelized)
//			return;
//		noumenon1.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.0872664625997165F * f1 + 0F;
//		noumenon2.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.174532925199433F * f1 + -0.271216631964586F;
//		noumenon3.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.261799387799149F * f1 + -0.452027719940978F;
//		noumenon4.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.349065850398866F * f1 + -0.180811087976391F;
//		thigh_R1.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * -0.174532925199433F * f1 + 0F;
//		leg_R1.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * -0.174532925199433F * f1 + 0.994460983870151F;
//		thigh_L1.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * -0.261799387799149F * f1 + 0F;
//		leg_L1.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * -0.261799387799149F * f1 + 0.994460983870151F;
//		thigh_R2.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.261799387799149F * f1 + 0F;
//		leg_R2.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.261799387799149F * f1 + 0.994460983870151F;
//		thigh_L2.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.174532925199433F * f1 + 0F;
//		leg_L2.xRot = Mth.cos(f / (1.919107651F * 0.33F)) * 0.174532925199433F * f1 + 0.994460983870151F;
//	}

	@Override
	public void setupAnim(Triceratops triceratops, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.lowerBody.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.0F;
		this.back.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.261799387799149F * limbSwingAmount + 0.0F;
		this.tail.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount + 0.0F;
		this.rightFrontThigh.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.0F;
		this.rightFrontThigh.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
		this.rightFrontLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F;
		this.rightFrontLeg.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
		this.leftFrontThigh.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.0F;
		this.leftFrontThigh.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
		this.leftFrontLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F;
		this.leftFrontLeg.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
		this.rightBackThigh.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.0F;
		this.rightBackThigh.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
		this.rightBackLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F;
		this.rightBackLeg.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
		this.leftBackThigh.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.0F;
		this.leftBackThigh.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
		this.leftBackLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F;
		this.leftBackLeg.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount + 0.0F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
