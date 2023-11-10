package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.SmilodonAnimations;
import willatendo.fossilslegacy.server.entity.Smilodon;
import willatendo.fossilslegacy.server.utils.DinosaurOrder;

public class SmilodonModel extends HierarchicalModel<Smilodon> {
	private final ModelPart head;
	private final ModelPart root;
	private final ModelPart tail;
//	private final ModelPart body;
//	private final ModelPart backRightLeg;
//	private final ModelPart backLeftLeg;
//	private final ModelPart frontRightLeg;
//	private final ModelPart frontLeftLeg;

	public SmilodonModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.tail = root.getChild("tail");
//		this.body = root.getChild("body");
//		this.backRightLeg = root.getChild("back_right_leg");
//		this.backLeftLeg = root.getChild("back_left_leg");
//		this.frontRightLeg = root.getChild("front_right_leg");
//		this.frontLeftLeg = root.getChild("front_left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(37, 36).addBox(-4.0F, -5.0F, -7.0F, 8.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(1.0F, -7.0F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 6).addBox(-3.0F, -7.0F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(1.5F, 3.0F, -11.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(33, 0).addBox(-2.5F, 3.0F, -11.5F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(41, 18).addBox(-3.0F, -3.0F, -12.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, -5.0F));
		head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(44, 29).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -7.0F));
		partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 14.0F, -2.0F));
		partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(16, 43).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 14.0F, -2.0F));
		partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(32, 52).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 14.0F, 14.0F));
		partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(46, 52).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 14.0F, 14.0F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 16.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 23).addBox(-7.0F, -7.0F, -9.25F, 14.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-5.0F, -5.0F, -1.25F, 10.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 4.25F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void prepareMobModel(Smilodon smilodon, float limbSwing, float limbSwingAmount, float headPitch) {
		this.tail.yRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		super.prepareMobModel(smilodon, limbSwing, limbSwingAmount, headPitch);

		if (smilodon.getCommand() == DinosaurOrder.STAY) {
		} else {
		}
	}

	@Override
	public void setupAnim(Smilodon smilodon, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(smilodon, netHeadYaw, headPitch, ageInTicks);
		float f = (float) smilodon.getDeltaMovement().horizontalDistanceSqr();
		float f1 = Mth.clamp(f * 400.0F, 0.3F, 2.0F);
		this.animate(smilodon.walkAnimationState, SmilodonAnimations.SMILODON_WALK, ageInTicks, f1);
		this.tail.xRot = -smilodon.getTailAngle();
	}

	private void applyHeadRotation(Smilodon smilodon, float x, float y, float z) {
		x = Mth.clamp(x, -30.0F, 30.0F);
		y = Mth.clamp(y, -25.0F, 45.0F);

		this.head.yRot = x * ((float) Math.PI / 180F);
		this.head.xRot = y * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		if (this.young) {
			poseStack.pushPose();
			poseStack.translate(0.0F, 0.75F, 0.0F);
			poseStack.scale(0.5F, 0.5F, 0.5F);
			this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
			poseStack.popPose();
		} else {
			this.root().render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		}
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}