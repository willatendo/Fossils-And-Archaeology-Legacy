package willatendo.fossilslegacy.client.model.legacy;

//public class SmilodonLegacyModel extends LegacyModel {
//	// fields
//	protected float field_40331_g = 4F;
//	protected float field_40332_n = 2F;
//	ModelRenderer T1;
//	ModelRenderer T2;
//	ModelRenderer T3;
//	ModelRenderer T4;
//	ModelRenderer T5__R1;
//	ModelRenderer T5__L1;
//	ModelRenderer T5__R2;
//	ModelRenderer T5__L2;
//	ModelRenderer H1;
//	ModelRenderer H2;
//	ModelRenderer H3;
//	ModelRenderer D__R1;
//	ModelRenderer D__L1;
//	ModelRenderer D__R2;
//	ModelRenderer D__L2;
//	ModelRenderer T6__R;
//	ModelRenderer T6__L;
//	ModelRenderer C1;
//	ModelRenderer C2;
//
//	public SmilodonLegacyModel(ModelPart modelPart) {
//		super(modelPart);
//		T1 = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
//		;
//		T1.addBox(-2.5F, -1.5F, -4F, 5, 4, 4);
//		T1.setRotationPoint(0F, 15F, -3F);
//		setRotation(T1, 0F, 0F, 0F);
//		T1.mirror = true;
//		T2 = new ModelRenderer(this, 18, 0).setTextureSize(64, 32);
//		;
//		T2.addBox(-1F, -1F, -7F, 2, 1, 3);
//		T2.setRotationPoint(0F, 15F, -3F);
//		setRotation(T2, 0F, 0F, 0F);
//		T2.mirror = true;
//		T3 = new ModelRenderer(this, 18, 5).setTextureSize(64, 32);
//		;
//		T3.addBox(-2F, 0F, -7F, 4, 2, 3);
//		T3.setRotationPoint(0F, 15F, -3F);
//		setRotation(T3, 0F, 0F, 0F);
//		T3.mirror = true;
//		T4 = new ModelRenderer(this, 48, 7).setTextureSize(64, 32);
//		;
//		T4.addBox(-1F, 0F, -3.5F, 2, 1, 3);
//		T4.setRotationPoint(0F, 16.5F, -6F);
//		setRotation(T4, 0.1745329F, 0F, 0F);
//		T4.mirror = true;
//		T5__R1 = new ModelRenderer(this, 44, 14).setTextureSize(64, 32);
//		;
//		T5__R1.addBox(-1.5F, 2F, -6F, 1, 2, 1);
//		T5__R1.setRotationPoint(0F, 15F, -3F);
//		setRotation(T5__R1, 0F, 0F, 0F);
//		T5__R1.mirror = true;
//		T5__L1 = new ModelRenderer(this, 44, 14).setTextureSize(64, 32);
//		;
//		T5__L1.addBox(0.5F, 2F, -6F, 1, 2, 1);
//		T5__L1.setRotationPoint(0F, 15F, -3F);
//		setRotation(T5__L1, 0F, 0F, 0F);
//		T5__L1.mirror = true;
//		T5__R2 = new ModelRenderer(this, 44, 17).setTextureSize(64, 32);
//		;
//		T5__R2.addBox(-1.5F, 4F, -6F, 1, 2, 1);
//		T5__R2.setRotationPoint(0F, 15F, -3F);
//		setRotation(T5__R2, 0F, 0F, 0F);
//		T5__R2.mirror = true;
//		T5__L2 = new ModelRenderer(this, 44, 17).setTextureSize(64, 32);
//		;
//		T5__L2.addBox(0.5F, 4F, -6F, 1, 2, 1);
//		T5__L2.setRotationPoint(0F, 15F, -3F);
//		setRotation(T5__L2, 0F, 0F, 0F);
//		T5__L2.mirror = true;
//		H1 = new ModelRenderer(this, 0, 11).setTextureSize(64, 32);
//		;
//		H1.addBox(-3.5F, -2.5F, -3F, 7, 6, 4);
//		H1.setRotationPoint(0F, 15F, 0F);
//		setRotation(H1, 0F, 0F, 0F);
//		H1.mirror = true;
//		H2 = new ModelRenderer(this, 0, 21).setTextureSize(64, 32);
//		;
//		H2.addBox(-2.5F, -2.5F, 0F, 5, 5, 6);
//		H2.setRotationPoint(0F, 16F, 1F);
//		setRotation(H2, 0F, 0F, 0F);
//		H2.mirror = true;
//		H3 = new ModelRenderer(this, 44, 7).setTextureSize(64, 32);
//		;
//		H3.addBox(-0.5F, 0F, -0.5F, 1, 6, 1);
//		H3.setRotationPoint(0F, 14F, 6.5F);
//		setRotation(H3, 0.5576792F, 0F, 0F);
//		H3.mirror = true;
//		D__R1 = new ModelRenderer(this, 40, 0).setTextureSize(64, 32);
//		;
//		D__R1.addBox(-1F, -0.5F, -1F, 2, 5, 2);
//		D__R1.setRotationPoint(-1.5F, 19F, -2F);
//		setRotation(D__R1, 0F, 0F, 0F);
//		D__R1.mirror = true;
//		D__L1 = new ModelRenderer(this, 32, 0).setTextureSize(64, 32);
//		;
//		D__L1.addBox(-1F, -0.5F, -1F, 2, 5, 2);
//		D__L1.setRotationPoint(1.5F, 19F, -2F);
//		setRotation(D__L1, 0F, 0F, 0F);
//		D__L1.mirror = true;
//		D__R2 = new ModelRenderer(this, 56, 0).setTextureSize(64, 32);
//		;
//		D__R2.addBox(-1F, -0.5F, -1F, 2, 5, 2);
//		D__R2.setRotationPoint(-1.5F, 19F, 6F);
//		setRotation(D__R2, 0F, 0F, 0F);
//		D__R2.mirror = true;
//		D__L2 = new ModelRenderer(this, 48, 0).setTextureSize(64, 32);
//		;
//		D__L2.addBox(-1F, -0.5F, -1F, 2, 5, 2);
//		D__L2.setRotationPoint(1.5F, 19F, 6F);
//		setRotation(D__L2, 0F, 0F, 0F);
//		D__L2.mirror = true;
//		T6__R = new ModelRenderer(this, 6, 8).setTextureSize(64, 32);
//		;
//		T6__R.addBox(-2.5F, -2.5F, -3F, 1, 1, 2);
//		T6__R.setRotationPoint(0F, 15F, -3F);
//		setRotation(T6__R, 0F, 0F, 0F);
//		T6__R.mirror = true;
//		T6__L = new ModelRenderer(this, 0, 8).setTextureSize(64, 32);
//		;
//		T6__L.addBox(1.5F, -2.5F, -3F, 1, 1, 2);
//		T6__L.setRotationPoint(0F, 15F, -3F);
//		setRotation(T6__L, 0F, 0F, 0F);
//		T6__L.mirror = true;
//		C1 = new ModelRenderer(this, 22, 20).setTextureSize(64, 32);
//		;
//		C1.addBox(-4F, -3F, -3.5F, 8, 7, 5);
//		C1.setRotationPoint(0F, 15F, 0F);
//		setRotation(C1, 0F, 0F, 0F);
//		C1.mirror = true;
//		C2 = new ModelRenderer(this, 22, 10).setTextureSize(64, 32);
//		;
//		C2.addBox(-3F, -2F, -4.5F, 6, 5, 5);
//		C2.setRotationPoint(0F, 15F, -3F);
//		setRotation(C2, 0F, 0F, 0F);
//		C2.mirror = true;
//	}
//
//	public void setLivingAnimations(LivingEntity entityliving, float f, float f1, float f2) {
//
////		EntitySaberCat entitySaberCat = (EntitySaberCat) entityliving;
////		if (entitySaberCat.isAngry()) {
////			H3.rotateAngleY = 0.0F;
////		} else {
////			H3.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
////		}
////		if (entitySaberCat.isSitting()) {
////			H1.setRotationPoint(0F, 17F, 0F);
////			H1.rotateAngleX = -0.314F;
////			H1.rotateAngleY = 0.0F;
////			C1.setRotationPoint(0F, 17F, 0F);
////			C1.rotateAngleX = -0.314F;
////			C1.rotateAngleY = 0.0F;
////			H2.setRotationPoint(0.0F, 20F, -1.0F);
////			H2.rotateAngleX = -0.7853982F;
////			H3.setRotationPoint(0F, 23F, 4.5F);
////			D__R2.setRotationPoint(-1.5F, 25F, 1.0F);
////			D__R2.rotateAngleX = 4.712389F;
////			D__L2.setRotationPoint(1.5F, 25F, 1.0F);
////			D__L2.rotateAngleX = 4.712389F;
////			D__R1.rotateAngleX = 5.811947F;
////			D__R1.setRotationPoint(-1.5F, 20F, -2F);
////			D__L1.rotateAngleX = 5.811947F;
////			D__L1.setRotationPoint(1.5F, 20F, -2F);
////		} else {
////			H1.setRotationPoint(0F, 15F, 0F);
////			H2.setRotationPoint(0.0F, 16F, 1.0F);
////			H2.rotateAngleX = 0.0F;
////			H1.rotateAngleX = H2.rotateAngleX;
////
////			C1.setRotationPoint(0F, 15F, 0F);
////			C1.rotateAngleX = H1.rotateAngleX;
////
////			H3.setRotationPoint(0F, 14F, 6.5F);
////			D__R2.setRotationPoint(-1.5F, 19F, 6F);
////			D__L2.setRotationPoint(1.5F, 19F, 6F);
////			D__R1.setRotationPoint(-1.5F, 19F, -2F);
////			D__L1.setRotationPoint(1.5F, 19F, -2F);
////			D__R2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
////			D__L2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
////			D__R1.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
////			D__L1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
////		}
////		float f3 = entitySaberCat.getInterestedAngle(f2) + entitySaberCat.getShakeAngle(f2, 0.0F);
////
////		T1.rotateAngleZ = T2.rotateAngleZ = T3.rotateAngleZ = T4.rotateAngleZ = T5__R1.rotateAngleZ = T5__L1.rotateAngleZ = T5__R2.rotateAngleZ = T5__L2.rotateAngleZ = T6__R.rotateAngleZ = T6__L.rotateAngleZ = f3;
////
////		H1.rotateAngleZ = entitySaberCat.getShakeAngle(f2, -0.08F);
////		H2.rotateAngleZ = entitySaberCat.getShakeAngle(f2, -0.16F);
////		H3.rotateAngleZ = entitySaberCat.getShakeAngle(f2, -0.2F);
////		if (entitySaberCat.getWolfShaking()) {
////			float f4 = entitySaberCat.getBrightness(f2) * entitySaberCat.getShadingWhileShaking(f2);
////			GL11.glColor3f(f4, f4, f4);
////		}
//	}
//
//	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		super.render(entity, f, f1, f2, f3, f4, f5);
//		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//		final float InitSize = 2.0F;
//		if (this.isChild) {
//			float f6 = 2.0F;
//			GL11.glPushMatrix();
//			GL11.glTranslatef(0.0F, 0.0F, 0.0F);
//			T1.render(f5);
//			T2.render(f5);
//			T3.render(f5);
//			T4.render(f5);
//			T5__R1.render(f5);
//			T5__L1.render(f5);
//			T5__R2.render(f5);
//			T5__L2.render(f5);
//			T6__R.render(f5);
//			T6__L.render(f5);
//			GL11.glPopMatrix();
//			GL11.glPushMatrix();
//			GL11.glScalef(InitSize / f6, InitSize / f6, InitSize / f6);
//			GL11.glTranslatef(0.0F, 0.0F, 0.0F);
//			H1.render(f5);
//			H2.render(f5);
//			H3.render(f5);
//			D__R1.render(f5);
//			D__L1.render(f5);
//			D__R2.render(f5);
//			D__L2.render(f5);
//			C1.render(f5);
//			C2.render(f5);
//			GL11.glPopMatrix();
//		} else {
//			GL11.glPushMatrix();
//			GL11.glScalef(InitSize, InitSize, InitSize);
//			GL11.glTranslatef(0.0F, -0.8F, 0.0F);
//			T1.render(f5);
//			T2.render(f5);
//			T3.render(f5);
//			T4.render(f5);
//			T5__R1.render(f5);
//			T5__L1.render(f5);
//			T5__R2.render(f5);
//			T5__L2.render(f5);
//			H1.render(f5);
//			H2.render(f5);
//			H3.render(f5);
//			D__R1.render(f5);
//			D__L1.render(f5);
//			D__R2.render(f5);
//			D__L2.render(f5);
//			T6__R.render(f5);
//			T6__L.render(f5);
//			C1.render(f5);
//			C2.render(f5);
//			GL11.glPopMatrix();
//		}
//
//	}
//
//	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par7) {
//		super.setRotationAngles(f, f1, f2, f3, f4, f5, par7);
//	}
//
//	private void setRotation(ModelRenderer model, float x, float y, float z) {
//		model.rotateAngleX = x;
//		model.rotateAngleY = y;
//		model.rotateAngleZ = z;
//	}
//}
