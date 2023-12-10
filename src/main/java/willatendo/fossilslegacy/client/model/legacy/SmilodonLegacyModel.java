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
import willatendo.fossilslegacy.client.model.CommonSmilodonRenderer;
import willatendo.fossilslegacy.server.entity.Smilodon;

public class SmilodonLegacyModel extends EntityModel<Smilodon> implements CommonSmilodonRenderer {
	private float r = 1.0F;
	private float g = 1.0F;
	private float b = 1.0F;

	private final ModelPart root;
	private final ModelPart body;
	private final ModelPart back;
	private final ModelPart tail;
	private final ModelPart rightFrontLeg;
	private final ModelPart rightBackLeg;
	private final ModelPart leftFrontLeg;
	private final ModelPart leftBackLeg;

	public SmilodonLegacyModel(ModelPart root) {
		this.root = root;
		this.body = root.getChild("body");
		this.back = root.getChild("back");
		this.tail = root.getChild("tail");
		this.rightFrontLeg = root.getChild("right_front_leg");
		this.rightBackLeg = root.getChild("right_back_leg");
		this.leftFrontLeg = root.getChild("left_front_leg");
		this.leftBackLeg = root.getChild("left_back_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 4.0F, 4.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(6, 8).addBox(-2.5F, -2.5F, -3.0F, 1.0F, 1.0F, 2.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(6, 8).addBox(1.5F, -2.5F, -3.0F, 1.0F, 1.0F, 2.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(18, 5).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(48, 7).addBox(-1.0F, 0.0F, -3.5F, 2.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 16.5F, -6.0F, 0.1745329F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_tooth_top", CubeListBuilder.create().texOffs(44, 14).addBox(-1.5F, 2.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("right_tooth_bottom", CubeListBuilder.create().texOffs(44, 17).addBox(-1.5F, 4.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("left_tooth_top", CubeListBuilder.create().texOffs(44, 14).addBox(0.5F, 2.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("left_tooth_bottom", CubeListBuilder.create().texOffs(44, 17).addBox(0.5F, 4.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 6.0F, 4.0F).mirror(), PartPose.offset(0.0F, 15.0F, 0.0F));
		partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F).mirror(), PartPose.offset(0.0F, 16.0F, 1.0F));
		partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(44, 7).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, 6.5F, 0.5576792F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 19.0F, -2.0F));
		partDefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 19.0F, 6.0F));
		partDefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(1.5F, 19.0F, -2.0F));
		partDefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(1.5F, 19.0F, 6.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}

	@Override
	public void setColor(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	@Override
	public void setupAnim(Smilodon smilodon, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
//		if (smilodon.isAngry()) {
//			this.tail.yRot = 0.0F;
//		} else {
		this.tail.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
//		}
		if (smilodon.isOrderedToSit()) {
			this.body.setPos(0.0F, 17.0F, 0.0F);
			this.body.xRot = -0.314F;
			this.body.yRot = 0.0F;
			this.back.setPos(0.0F, 20.0F, -1.0F);
			this.back.xRot = -0.7853982F;
			this.tail.setPos(0.0F, 23.0F, 4.5F);
			this.leftFrontLeg.setPos(-1.5F, 25.0F, 1.0F);
			this.leftFrontLeg.xRot = 4.712389F;
			this.leftBackLeg.setPos(1.5F, 25.0F, 1.0F);
			this.leftBackLeg.xRot = 4.712389F;
			this.rightFrontLeg.xRot = 5.811947F;
			this.rightFrontLeg.setPos(-1.5F, 20.0F, -2.0F);
			this.rightBackLeg.xRot = 5.811947F;
			this.rightBackLeg.setPos(1.5F, 20.0F, -2.0F);
		} else {
			this.body.setPos(0.0F, 15.0F, 0.0F);
			this.back.setPos(0.0F, 16.0F, 1.0F);
			this.back.xRot = 0.0F;
			this.body.xRot = back.xRot;

			this.tail.setPos(0.0F, 14.0F, 6.5F);
			this.leftFrontLeg.setPos(-1.5F, 19.0F, 6.0F);
			this.leftBackLeg.setPos(1.5F, 19.0F, 6.0F);
			this.rightFrontLeg.setPos(-1.5F, 19.0F, -2.0F);
			this.rightBackLeg.setPos(1.5F, 19.0F, -2.0F);
			this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.leftBackLeg.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
			this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount;
			this.rightBackLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		}

		this.body.zRot = smilodon.getBodyRollAngle(ageInTicks, -0.08F);
		this.back.zRot = smilodon.getBodyRollAngle(ageInTicks, -0.16F);
		this.tail.zRot = smilodon.getBodyRollAngle(ageInTicks, -0.2F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, this.r * red, this.g * green, this.b * blue, alpha);
	}
}
