package willatendo.fossilslegacy.client.model.legacy;

//public class MosasaurusLegacyModel extends DinosaurLegacyModel {
//	public MosasaurusLegacyModel(ModelPart modelPart) {
//		super(modelPart);
//		Body = new ModelRenderer(this, 32, 0);
//		Body.addBox(-4F, 0F, 0F, 8, 6, 8);
//		Body.setRotationPoint(1F, 16F, 0F);
//		Body.rotateAngleX = 0F;
//		Body.rotateAngleY = 0F;
//		Body.rotateAngleZ = 0F;
//		Body.mirror = false;
//		Tail_1 = new ModelRenderer(this, 35, 14);
//		Tail_1.addBox(-3F, -2F, -4F, 6, 4, 6);
//		Tail_1.setRotationPoint(1F, 19F, 11F);
//		Tail_1.rotateAngleX = 0F;
//		Tail_1.rotateAngleY = 0F;
//		Tail_1.rotateAngleZ = 0F;
//		Tail_1.mirror = false;
//		Tail_2 = new ModelRenderer(this, 36, 24);
//		Tail_2.addBox(-2F, -1F, -4F, 4, 2, 6);
//		Tail_2.setRotationPoint(1F, 19F, 16F);
//		Tail_2.rotateAngleX = 0F;
//		Tail_2.rotateAngleY = 0F;
//		Tail_2.rotateAngleZ = 0F;
//		Tail_2.mirror = false;
//		Tail_3 = new ModelRenderer(this, 16, 8);
//		Tail_3.addBox(-1F, -1F, -4F, 2, 2, 6);
//		Tail_3.setRotationPoint(1F, 19F, 21F);
//		Tail_3.rotateAngleX = 0F;
//		Tail_3.rotateAngleY = 0F;
//		Tail_3.rotateAngleZ = 0F;
//		Tail_3.mirror = false;
//		Head = new ModelRenderer(this, 0, 24);
//		Head.addBox(-3F, -2F, -4F, 6, 4, 4);
//		Head.setRotationPoint(1F, 19F, 0F);
//		Head.rotateAngleX = 0F;
//		Head.rotateAngleY = 0F;
//		Head.rotateAngleZ = 0F;
//		Head.mirror = false;
//		Upper_Jaws = new ModelRenderer(this, 17, 22);
//		Upper_Jaws.addBox(-2F, -1F, -9F, 4, 1, 5);
//		Upper_Jaws.setRotationPoint(1F, 19F, 0F);
//		Upper_Jaws.rotateAngleX = 0F;
//		Upper_Jaws.rotateAngleY = 0F;
//		Upper_Jaws.rotateAngleZ = 0F;
//		Upper_Jaws.mirror = false;
//		right_arm = new ModelRenderer(this, 0, 0);
//		right_arm.addBox(-4F, 0F, 0F, 4, 1, 6);
//		right_arm.setRotationPoint(-3F, 20F, 0F);
//		right_arm.rotateAngleX = -0.34907F;
//		right_arm.rotateAngleY = -1.0472F;
//		right_arm.rotateAngleZ = -0.43633F;
//		right_arm.mirror = false;
//		Left_arm = new ModelRenderer(this, 0, 0);
//		Left_arm.addBox(0F, 0F, 0F, 4, 1, 6);
//		Left_arm.setRotationPoint(5F, 20F, 0F);
//		Left_arm.rotateAngleX = -0.34907F;
//		Left_arm.rotateAngleY = 1.0472F;
//		Left_arm.rotateAngleZ = 0.43633F;
//		Left_arm.mirror = false;
//		Right_Leg = new ModelRenderer(this, 20, 1);
//		Right_Leg.addBox(-3F, 0F, 0F, 3, 1, 5);
//		Right_Leg.setRotationPoint(-2F, 20F, 7F);
//		Right_Leg.rotateAngleX = -0.34907F;
//		Right_Leg.rotateAngleY = -0.87266F;
//		Right_Leg.rotateAngleZ = -0.43633F;
//		Right_Leg.mirror = false;
//		Left_Leg = new ModelRenderer(this, 20, 1);
//		Left_Leg.addBox(0F, 0F, 0F, 3, 1, 5);
//		Left_Leg.setRotationPoint(4F, 20F, 7F);
//		Left_Leg.rotateAngleX = -0.34907F;
//		Left_Leg.rotateAngleY = 0.87266F;
//		Left_Leg.rotateAngleZ = 0.43633F;
//		Left_Leg.mirror = false;
//		Lower_jaw = new ModelRenderer(this, 0, 7);
//		Lower_jaw.addBox(-1F, 0F, -8F, 2, 2, 6);
//		Lower_jaw.setRotationPoint(1F, 19F, 0F);
//		Lower_jaw.rotateAngleX = 0F;
//		Lower_jaw.rotateAngleY = 0F;
//		Lower_jaw.rotateAngleZ = 0F;
//		Lower_jaw.mirror = false;
//		Upper_Teeth = new ModelRenderer(this, 0, 16);
//		Upper_Teeth.addBox(-2F, 0F, -9F, 4, 2, 6);
//		Upper_Teeth.setRotationPoint(1F, 19F, 0F);
//		Upper_Teeth.rotateAngleX = 0F;
//		Upper_Teeth.rotateAngleY = 0F;
//		Upper_Teeth.rotateAngleZ = 0F;
//		Upper_Teeth.mirror = false;
//		Tail_3_dec = new ModelRenderer(this, 26, 23);
//		Tail_3_dec.addBox(0F, -2F, -2F, 1, 2, 5);
//		Tail_3_dec.setRotationPoint(1F, 19F, 20F);
//		Tail_3_dec.rotateAngleX = 0F;
//		Tail_3_dec.rotateAngleY = 0F;
//		Tail_3_dec.rotateAngleZ = 0F;
//		Tail_3_dec.mirror = false;
//		Tail_2_dec = new ModelRenderer(this, 26, 22);
//		Tail_2_dec.addBox(0F, -3F, -4F, 1, 2, 6);
//		Tail_2_dec.setRotationPoint(1F, 19F, 16F);
//		Tail_2_dec.rotateAngleX = 0F;
//		Tail_2_dec.rotateAngleY = 0F;
//		Tail_2_dec.rotateAngleZ = 0F;
//		Tail_2_dec.mirror = false;
//	}
//
//	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		super.render(entity, f, f1, f2, f3, f4, f5);
//		setRotationAngles(f, f1, f2, f3, f4, f5, false/*((EntityDinosaurce) entity).isModelized()*/);
//		Body.render(f5);
//		Tail_1.render(f5);
//		Tail_2.render(f5);
//		Tail_3.render(f5);
//		Head.render(f5);
//		Upper_Jaws.render(f5);
//		right_arm.render(f5);
//		Left_arm.render(f5);
//		Right_Leg.render(f5);
//		Left_Leg.render(f5);
//		Lower_jaw.render(f5);
//		Upper_Teeth.render(f5);
//		Tail_3_dec.render(f5);
//		Tail_2_dec.render(f5);
//	}
//
//	public void OpenMouth(int time) {
//		if (this.Lower_jaw.rotateAngleX < 0.349066)
//			this.Lower_jaw.rotateAngleX += (0.349066 / time);
//		else
//			this.Lower_jaw.rotateAngleX = 0.349066F;
//
//		if (this.Upper_Jaws.rotateAngleX > -0.174533)
//			this.Upper_Jaws.rotateAngleX -= (0.174533 / time);
//		else
//			this.Upper_Jaws.rotateAngleX = -0.174533F;
//
//		this.Upper_Teeth.rotateAngleX = this.Upper_Jaws.rotateAngleX;
//	}
//
//	public void CloseMouth(int time) {
//		if (this.Lower_jaw.rotateAngleX > 0)
//			this.Lower_jaw.rotateAngleX -= (0.349066 / time);
//		else
//			this.Lower_jaw.rotateAngleX = 0;
//
//		if (this.Upper_Jaws.rotateAngleX < 0)
//			this.Upper_Jaws.rotateAngleX += (0.174533 / time);
//		else
//			this.Upper_Jaws.rotateAngleX = 0;
//
//		this.Upper_Teeth.rotateAngleX = this.Upper_Jaws.rotateAngleX;
//	}
//
//	// fields
//	ModelRenderer Body;
//	ModelRenderer Tail_1;
//	ModelRenderer Tail_2;
//	ModelRenderer Tail_3;
//	ModelRenderer Head;
//	ModelRenderer Upper_Jaws;
//	ModelRenderer right_arm;
//	ModelRenderer Left_arm;
//	ModelRenderer Right_Leg;
//	ModelRenderer Left_Leg;
//	ModelRenderer Lower_jaw;
//	ModelRenderer Upper_Teeth;
//	ModelRenderer Tail_3_dec;
//	ModelRenderer Tail_2_dec;
//
//	@Override
//	protected void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean modelized) {
//		if (modelized)
//			return;
//		Body.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 1)) * -0.0872664625997165 * f1 + 0);
//		Tail_1.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 1)) * 0.174532925199433 * f1 + 0);
//		Tail_2.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 1)) * -0.174532925199433 * f1 + 0);
//		Tail_3.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 1)) * 0.174532925199433 * f1 + 0);
//		right_arm.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 3)) * -0.174532925199433 * f1 + -1.0471975511966);
//		Left_arm.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 3)) * 0.174532925199433 * f1 + 1.0471975511966);
//		Right_Leg.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 3)) * -0.174532925199433 * f1 + -0.872664625997165);
//		Left_Leg.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 3)) * 0.174532925199433 * f1 + 0.872664625997165);
//		Tail_3_dec.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 1)) * 0.174532925199433 * f1 + 0);
//		Tail_2_dec.rotateAngleY = (float) (Mth.cos(f / (1.919107651F * 1)) * -0.174532925199433 * f1 + 0);
//
//	}
//}
