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
import net.minecraft.world.entity.Entity;

public class PlesiosaurusLegacyModel extends EntityModel<Entity> {
	private final ModelPart root;

	public PlesiosaurusLegacyModel(ModelPart root) {
		this.root = root;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 9.0F, -15.0F, 0.49723F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(20, 23).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, -0.99446F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(47, 23).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -4.0F, -0.88974F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_3", CubeListBuilder.create().texOffs(35, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 12.73333F, -8.0F, -0.58764F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_4", CubeListBuilder.create().texOffs(35, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 10.0F, -11.0F, -0.13561F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
		partDefinition.addOrReplaceChild("front_right_flipper", CubeListBuilder.create().texOffs(44, 13).addBox(0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, 21.0F, -3.0F, -0.5236F, -2.35619F, 0.0F));
		partDefinition.addOrReplaceChild("front_left_flipper", CubeListBuilder.create().texOffs(44, 18).addBox(0.0F, 0.0F, -4.0F, 6.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.0F, 21.0F, -3.0F, 0.5236F, -0.7854F, 0.0F));
		partDefinition.addOrReplaceChild("back_right_flipper", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, 21.0F, 4.0F, -0.5236F, -2.0944F, 0.0F));
		partDefinition.addOrReplaceChild("back_left_flipper", CubeListBuilder.create().texOffs(48, 4).addBox(0.0F, 0.0F, -3.0F, 5.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(3.0F, 21.0F, 4.0F, 0.5236F, -1.0472F, 0.0F));
		partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -5.0F, 2.0F, 6.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, -0.45203F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(18, 14).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 5.0F, -0.27122F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 21.0F, 11.0F, -0.18081F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}

	@Override
	public void setupAnim(Entity plesiosaurus, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
//	public boolean WaveTail(float TargetAngle, boolean ClockDirection, int step) {
//		boolean result1, result2, result3 = false;
//		float ActionTargetAngle = TargetAngle;
//		if (TargetAngle < 0)
//			return false;
//		if (step <= 0)
//			return false;
//		if (ClockDirection) {
//			// Clockwise
//			if (tail1.rotateAngleY < ActionTargetAngle)
//				tail1.rotateAngleY += (ActionTargetAngle / step);
//			else
//				tail1.rotateAngleY = ActionTargetAngle;
//			result1 = (tail1.rotateAngleY >= ActionTargetAngle);
//			ActionTargetAngle += TargetAngle;
//			if (!result1) {
//				tail2.rotationPointX = (float) ((tail2.rotationPointX - tail1.rotationPointX) * Math.cos(-(ActionTargetAngle / step)) - (tail2.rotationPointZ - tail1.rotationPointZ) * Math.sin(-(ActionTargetAngle / step)) + tail1.rotationPointX);
//				tail2.rotationPointZ = (float) ((tail2.rotationPointX - tail1.rotationPointX) * Math.sin(-(ActionTargetAngle / step)) + (tail2.rotationPointZ - tail1.rotationPointZ) * Math.cos(-(ActionTargetAngle / step)) + tail1.rotationPointZ);
//			}
//			if (tail2.rotateAngleY < ActionTargetAngle)
//				tail2.rotateAngleY += (ActionTargetAngle / step);
//			else
//				tail2.rotateAngleY = ActionTargetAngle;
//			result2 = (tail2.rotateAngleY >= ActionTargetAngle);
//			ActionTargetAngle += TargetAngle;
//			if (!result2) {
//				tail3.rotationPointX = (float) ((tail3.rotationPointX - tail2.rotationPointX) * Math.cos(-(ActionTargetAngle / step)) - (tail3.rotationPointZ - tail2.rotationPointZ) * Math.sin(-(ActionTargetAngle / step)) + tail2.rotationPointX);
//				tail3.rotationPointZ = (float) ((tail3.rotationPointX - tail2.rotationPointX) * Math.sin(-(ActionTargetAngle / step)) + (tail3.rotationPointZ - tail2.rotationPointZ) * Math.cos(-(ActionTargetAngle / step)) + tail2.rotationPointZ);
//			}
//			if (tail3.rotateAngleY < ActionTargetAngle)
//				tail3.rotateAngleY += (ActionTargetAngle / step);
//			else
//				tail3.rotateAngleY = ActionTargetAngle;
//			result3 = (tail3.rotateAngleY >= ActionTargetAngle);
//		} else {
//			ActionTargetAngle = -ActionTargetAngle;
//			// Anti-Clockwise
//			if (tail1.rotateAngleY > ActionTargetAngle)
//				tail1.rotateAngleY += (ActionTargetAngle / step);
//			else
//				tail1.rotateAngleY = ActionTargetAngle;
//			result1 = (tail1.rotateAngleY <= ActionTargetAngle);
//			ActionTargetAngle -= TargetAngle;
//			if (!result1) {
//				tail2.rotationPointX = (float) ((tail2.rotationPointX - tail1.rotationPointX) * Math.cos(-(ActionTargetAngle / step)) - (tail2.rotationPointZ - tail1.rotationPointZ) * Math.sin(-(ActionTargetAngle / step)) + tail1.rotationPointX);
//				tail2.rotationPointZ = (float) ((tail2.rotationPointX - tail1.rotationPointX) * Math.sin(-(ActionTargetAngle / step)) + (tail2.rotationPointZ - tail1.rotationPointZ) * Math.cos(-(ActionTargetAngle / step)) + tail1.rotationPointZ);
//			}
//			if (tail2.rotateAngleY > ActionTargetAngle)
//				tail2.rotateAngleY += (ActionTargetAngle / step);
//			else
//				tail2.rotateAngleY = ActionTargetAngle;
//			result2 = (tail2.rotateAngleY <= ActionTargetAngle);
//			ActionTargetAngle -= TargetAngle;
//			if (!result2) {
//				tail3.rotationPointX = (float) ((tail3.rotationPointX - tail2.rotationPointX) * Math.cos(-(ActionTargetAngle / step)) - (tail3.rotationPointZ - tail2.rotationPointZ) * Math.sin(-(ActionTargetAngle / step)) + tail2.rotationPointX);
//				tail3.rotationPointZ = (float) ((tail3.rotationPointX - tail2.rotationPointX) * Math.sin(-(ActionTargetAngle / step)) + (tail3.rotationPointZ - tail2.rotationPointZ) * Math.cos(-(ActionTargetAngle / step)) + tail2.rotationPointZ);
//			}
//			if (tail3.rotateAngleY > ActionTargetAngle)
//				tail3.rotateAngleY += (ActionTargetAngle / step);
//			else
//				tail3.rotateAngleY = ActionTargetAngle;
//			result3 = (tail3.rotateAngleY <= ActionTargetAngle);
//		}
//		return (result1 && result2 && result3);
//	}
//
//	public void ReturnTail() {
//		tail1.rotateAngleY = tail2.rotateAngleY = tail3.rotateAngleY = 0F;
//		tail1.setRotationPoint(0F, 21F, 0F);
//		tail2.setRotationPoint(0F, 19F, 5F);
//		tail3.setRotationPoint(0F, 19F, 11F);
//	}
//
//	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
//
//	}
//
//	public void setLivingAnimations(LivingEntity entityliving, float f, float f1, float f2) {
////    	  if (((EntityDinosaurce)entityliving).isModelized()) return;
////    	  EntityPlesiosaur MainEntity=(EntityPlesiosaur)entityliving;
////    	  final int STEPS=16+MainEntity.getDinoAge();
////    	  if (MainEntity.riddenByEntity==null || MainEntity.isOnSurface()) PoseSurface(STEPS);
////    	  else PoseDive(STEPS);
//	}
//
//	public boolean PoseDive(int steps) {
//		boolean result = true;
//		if (Neck1.rotateAngleX < -0.453F) {
//			Neck1.rotateAngleX += ((0.994F - 0.453F) / steps);
//			result &= false;
//		} else
//			Neck1.rotateAngleX = -0.453F;
//
//		if (Neck2.rotateAngleX < -0.174F) {
//			Neck2.rotateAngleX += ((0.890F - 0.174F) / steps);
//			result &= false;
//		} else
//			Neck2.rotateAngleX = -0.174F;
//
//		if (Neck2.rotationPointY < 18F) {
//			Neck2.rotationPointY += ((18F - 16F) / steps);
//			result &= false;
//		} else
//			Neck2.rotationPointY = 18F;
//
//		if (Neck2.rotationPointZ < -3F) {
//			Neck2.rotationPointZ += ((4F - 3F) / steps);
//			result &= false;
//		} else
//			Neck2.rotationPointZ = -3F;
//
//		if (Neck3.rotateAngleX < -0.116F) {
//			Neck3.rotateAngleX += ((0.588F - 0.116F) / steps);
//			result &= false;
//		} else
//			Neck3.rotateAngleX = -0.116F;
//
//		if (Neck3.rotationPointY < 17.7F) {
//			Neck3.rotationPointY += ((17.7F - 12.7F) / steps);
//			result &= false;
//		} else
//			Neck3.rotationPointY = 17.7F;
//
//		if (Neck3.rotationPointZ > -9F) {
//			Neck3.rotationPointZ -= ((9F - 8F) / steps);
//			result &= false;
//		} else
//			Neck3.rotationPointZ = -9F;
//
//		if (Neck4.rotateAngleX < -0.013F) {
//			Neck4.rotateAngleX += ((0.136F - 0.013F) / steps);
//			result &= false;
//		} else
//			Neck4.rotateAngleX = -0.013F;
//
//		if (Neck4.rotationPointY < 17F) {
//			Neck4.rotationPointY += ((17F - 10F) / steps);
//			result &= false;
//		} else
//			Neck4.rotationPointY = 17F;
//
//		if (Neck4.rotationPointZ > -13F) {
//			Neck4.rotationPointZ -= ((13F - 11F) / steps);
//			result &= false;
//		} else
//			Neck4.rotationPointZ = -13F;
//
//		if (head.rotateAngleX > 0.009F) {
//			head.rotateAngleX -= ((0.497F - 0.009F) / steps);
//			result &= false;
//		} else
//			head.rotateAngleX = 0.009F;
//
//		if (head.rotationPointY < 16F) {
//			head.rotationPointY += ((16F - 9F) / steps);
//			result &= false;
//		} else
//			head.rotationPointY = 16F;
//
//		if (head.rotationPointZ > -18F) {
//			head.rotationPointZ -= ((18F - 15F) / steps);
//			result &= false;
//		} else
//			head.rotationPointZ = -18F;
//		return result;
//	}
//
//	public boolean PoseSurface(int steps) {
//		boolean result = true;
//		if (Neck1.rotateAngleX > -0.994F) {
//			Neck1.rotateAngleX -= ((0.994F - 0.453F) / steps);
//			result &= false;
//		} else
//			Neck1.rotateAngleX = -0.994F;
//
//		if (Neck2.rotateAngleX > -0.890F) {
//			Neck2.rotateAngleX -= ((0.890F - 0.174F) / steps);
//			result &= false;
//		} else
//			Neck2.rotateAngleX = -0.890F;
//
//		if (Neck2.rotationPointY > 16F) {
//			Neck2.rotationPointY -= ((18F - 16F) / steps);
//			result &= false;
//		} else
//			Neck2.rotationPointY = 16F;
//
//		if (Neck2.rotationPointZ > -4F) {
//			Neck2.rotationPointZ -= ((4F - 3F) / steps);
//			result &= false;
//		} else
//			Neck2.rotationPointZ = -4F;
//
//		if (Neck3.rotateAngleX > -0.588F) {
//			Neck3.rotateAngleX -= ((0.588F - 0.116F) / steps);
//			result &= false;
//		} else
//			Neck3.rotateAngleX = -0.588F;
//
//		if (Neck3.rotationPointY > 12.7F) {
//			Neck3.rotationPointY -= ((17.7F - 12.7F) / steps);
//			result &= false;
//		} else
//			Neck3.rotationPointY = 12.7F;
//
//		if (Neck3.rotationPointZ < -8F) {
//			Neck3.rotationPointZ += ((9F - 8F) / steps);
//			result &= false;
//		} else
//			Neck3.rotationPointZ = -8F;
//
//		if (Neck4.rotateAngleX > -0.136F) {
//			Neck4.rotateAngleX -= ((0.136F - 0.013F) / steps);
//			result &= false;
//		} else
//			Neck4.rotateAngleX = -0.136F;
//
//		if (Neck4.rotationPointY > 10F) {
//			Neck4.rotationPointY -= ((17F - 10F) / steps);
//			result &= false;
//		} else
//			Neck4.rotationPointY = 10F;
//
//		if (Neck4.rotationPointZ < -11F) {
//			Neck4.rotationPointZ += ((13F - 11F) / steps);
//			result &= false;
//		} else
//			Neck4.rotationPointZ = -11F;
//
//		if (head.rotateAngleX < 0.497F) {
//			head.rotateAngleX += ((0.497F - 0.009F) / steps);
//			result &= false;
//		} else
//			head.rotateAngleX = 0.497F;
//
//		if (head.rotationPointY > 9F) {
//			head.rotationPointY -= ((16F - 9F) / steps);
//			result &= false;
//		} else
//			head.rotationPointY = 9F;
//
//		if (head.rotationPointZ < -15F) {
//			head.rotationPointZ += ((18F - 15F) / steps);
//			result &= false;
//		} else
//			head.rotationPointZ = -15F;
//		return result;
//	}
//
//	// fields
//	ModelRenderer Body;
//	ModelRenderer Neck1;
//	ModelRenderer tail3;
//	ModelRenderer tail2;
//	ModelRenderer tail1;
//	ModelRenderer Neck2;
//	ModelRenderer Neck3;
//	ModelRenderer Neck4;
//	ModelRenderer head;
//	ModelRenderer right_arm;
//	ModelRenderer left_arm;
//	ModelRenderer right_leg;
//	ModelRenderer left_leg;
//	public boolean LandFlag = false;
//
//	@Override
//	protected void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean modelized) {
//		if (modelized)
//			return;
//		// super.setRotationAngles(f, f1, f2, f3, f4, f5);
//
//		// Head Yaw
//		// head.rotateAngleY = -f3 / 57.29578F;
//
//		right_arm.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 0.5F)) * 0.785398163397448 * f1 + -2.35619449019234);
//		right_leg.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 0.5F)) * 0.785398163397448 * f1 + -2.0943951023932);
//		if (LandFlag) {
//
//			left_arm.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 0.5F)) * 0.785398163397448 * f1 + -0.785398163397448);
//
//			left_leg.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 0.5F)) * 0.785398163397448 * f1 + -1.0471975511966);
//		} else {
//
//			left_arm.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 0.5F)) * -0.785398163397448 * f1 + -0.785398163397448);
//
//			left_leg.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 0.5F)) * -0.785398163397448 * f1 + -1.0471975511966);
//		}
//
//	}
}
