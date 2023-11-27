package willatendo.fossilslegacy.client.model.legacy;

//public class LandedPteranodonLegacyModel extends DinosaurLegacyModel {
//	// fields
//	ModelRenderer Body;
//	ModelRenderer Neck1;
//	ModelRenderer Neck2;
//	ModelRenderer Head;
//	ModelRenderer Crown;
//	ModelRenderer Jaw1;
//	ModelRenderer Jaw2;
//	ModelRenderer LeftWing1;
//	ModelRenderer RightWing1;
//	ModelRenderer LeftWing2;
//	ModelRenderer RightWing2;
//	ModelRenderer TAil;
//	ModelRenderer LeftLeg;
//	ModelRenderer RightLeg;
//
//	public LandedPteranodonLegacyModel(ModelPart modelPart) {
//		super(modelPart);
//		Body = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
//		;
//		Body.addBox(-2F, -3F, -2F, 4, 7, 4);
//		Body.setRotationPoint(0F, 17F, 2F);
//		setRotation(Body, 0.5876361F, 0F, 0F);
//		Body.mirror = true;
//		Neck1 = new ModelRenderer(this, 8, 16).setTextureSize(64, 32);
//		;
//		Neck1.addBox(-1F, -2F, -1F, 2, 4, 2);
//		Neck1.setRotationPoint(0F, 16F, 0F);
//		setRotation(Neck1, 1.130069F, 0F, 0F);
//		Neck1.mirror = true;
//		Neck2 = new ModelRenderer(this, 0, 16).setTextureSize(64, 32);
//		;
//		Neck2.addBox(-1F, -2F, -1F, 2, 4, 2);
//		Neck2.setRotationPoint(0F, 15F, -3F);
//		setRotation(Neck2, 1.446489F, 0F, 0F);
//		Neck2.mirror = true;
//		Head = new ModelRenderer(this, 0, 23).setTextureSize(64, 32);
//		;
//		Head.addBox(-2F, -4F, 0F, 4, 5, 4);
//		Head.setRotationPoint(0F, 16F, -5F);
//		setRotation(Head, 2.12453F, 0F, 0F);
//		Head.mirror = true;
//		Crown = new ModelRenderer(this, 16, 22).setTextureSize(64, 32);
//		;
//		Crown.addBox(-1F, -4F, -2F, 2, 4, 6);
//		Crown.setRotationPoint(0F, 13F, -6F);
//		setRotation(Crown, 1.084867F, 0F, 0F);
//		Crown.mirror = true;
//		Jaw1 = new ModelRenderer(this, 44, 0).setTextureSize(64, 32);
//		;
//		Jaw1.addBox(-1F, -1F, -8F, 2, 1, 8);
//		Jaw1.setRotationPoint(0F, 17F, -9F);
//		setRotation(Jaw1, 0.5235988F, 0F, 0F);
//		Jaw1.mirror = true;
//		Jaw2 = new ModelRenderer(this, 44, 9).setTextureSize(64, 32);
//		;
//		Jaw2.addBox(-1F, 0F, -8F, 2, 1, 8);
//		Jaw2.setRotationPoint(0F, 16F, -8F);
//		setRotation(Jaw2, 0.7684471F, 0F, 0F);
//		Jaw2.mirror = true;
//		LeftWing1 = new ModelRenderer(this, 16, 0).setTextureSize(64, 32);
//		;
//		LeftWing1.addBox(0F, 0F, 0F, 8, 6, 1);
//		LeftWing1.setRotationPoint(2F, 14F, 1F);
//		setRotation(LeftWing1, -2.617994F, -2.740167F, 2.792527F);
//		LeftWing1.mirror = true;
//		RightWing1 = new ModelRenderer(this, 16, 7).setTextureSize(64, 32);
//		;
//		RightWing1.addBox(0F, 0F, -1F, 8, 6, 1);
//		RightWing1.setRotationPoint(-2F, 14F, 1F);
//		setRotation(RightWing1, 2.617994F, -0.4363323F, -2.792527F);
//		RightWing1.mirror = true;
//		LeftWing2 = new ModelRenderer(this, 46, 23).setTextureSize(64, 32);
//		;
//		LeftWing2.addBox(0F, 0F, -1F, 8, 4, 1);
//		LeftWing2.setRotationPoint(8F, 11F, 5F);
//		setRotation(LeftWing2, 0.6108652F, 0F, 0F);
//		LeftWing2.mirror = true;
//		RightWing2 = new ModelRenderer(this, 46, 18).setTextureSize(64, 32);
//		;
//		RightWing2.addBox(0F, 0F, 0F, 8, 4, 1);
//		RightWing2.setRotationPoint(-8F, 11F, 5F);
//		setRotation(RightWing2, -0.6108652F, 3.141593F, 0F);
//		RightWing2.mirror = true;
//		TAil = new ModelRenderer(this, 0, 11).setTextureSize(64, 32);
//		;
//		TAil.addBox(-1F, 0F, -2F, 2, 3, 2);
//		TAil.setRotationPoint(0F, 19F, 5F);
//		setRotation(TAil, 0.2260139F, 0F, 0F);
//		TAil.mirror = true;
//		LeftLeg = new ModelRenderer(this, 40, 0).setTextureSize(64, 32);
//		;
//		LeftLeg.addBox(0F, 0F, 0F, 1, 3, 1);
//		LeftLeg.setRotationPoint(1F, 21F, 2F);
//		setRotation(LeftLeg, -0.2712166F, 0F, 0F);
//		LeftLeg.mirror = true;
//		RightLeg = new ModelRenderer(this, 40, 4).setTextureSize(64, 32);
//		;
//		RightLeg.addBox(-1F, 0F, 0F, 1, 3, 1);
//		RightLeg.setRotationPoint(-1F, 21F, 2F);
//		setRotation(RightLeg, -0.2712166F, 0F, 0F);
//		RightLeg.mirror = true;
//	}
//
//	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		super.render(entity, f, f1, f2, f3, f4, f5);
//		setRotationAngles(f, f1, f2, f3, f4, f5, false /* ((EntityDinosaurce)entity).isModelized() */);
//		Body.render(f5);
//		Neck1.render(f5);
//		Neck2.render(f5);
//		Head.render(f5);
//		Crown.render(f5);
//		Jaw1.render(f5);
//		Jaw2.render(f5);
//		LeftWing2.render(f5);
//		RightWing2.render(f5);
//		TAil.render(f5);
//		LeftLeg.render(f5);
//		RightLeg.render(f5);
//		LeftWing1.render(f5);
//		RightWing1.render(f5);
//
//	}
//
//	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
//		super.setRotationAngles(f, f1, f2, f3, f4, f5);
//	}
//
//	private void setRotation(ModelRenderer model, float x, float y, float z) {
//		model.rotateAngleX = x;
//		model.rotateAngleY = y;
//		model.rotateAngleZ = z;
//	}
//
//	@Override
//	protected void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean modelized) {
//		// TODO Auto-generated method stub
//
//	}
//}
