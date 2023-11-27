package willatendo.fossilslegacy.client.model.legacy;

//public class StegosaurusLegacyModel extends DinosaurLegacyModel {
//	// fields
//	ModelRenderer H1;
//	ModelRenderer H2;
//	ModelRenderer H3;
//	ModelRenderer H4;
//	ModelRenderer H5;
//	ModelRenderer H6;
//	ModelRenderer D_L_1;
//	ModelRenderer D_R_1;
//	ModelRenderer D_L_2;
//	ModelRenderer D_R_2;
//	ModelRenderer DD_L_1;
//	ModelRenderer D_D_R_1;
//	ModelRenderer DD_L_2;
//	ModelRenderer DD_R_2;
//	ModelRenderer T1;
//	ModelRenderer T2;
//	ModelRenderer T3;
//	ModelRenderer T4;
//
//	public StegosaurusLegacyModel(ModelPart modelPart) {
//		super(modelPart);
//		H1 = new ModelRenderer(this, 20, 0).setTextureSize(64, 32);
//		;
//		H1.addBox(-3F, 0F, 0F, 7, 8, 8);
//		H1.setRotationPoint(0F, 14F, -6F);
//		setRotation(H1, 0F, 0F, 0F);
//		H1.mirror = true;
//		H2 = new ModelRenderer(this, 46, 14).setTextureSize(64, 32);
//		;
//		H2.addBox(-2F, 2F, -4F, 5, 5, 4);
//		H2.setRotationPoint(0F, 14F, -6F);
//		setRotation(H2, 0.2094395F, 0F, 0F);
//		H2.mirror = true;
//		H3 = new ModelRenderer(this, 32, 24).setTextureSize(64, 32);
//		;
//		H3.addBox(-0.5F, 3.5F, -8F, 2, 3, 5);
//		H3.setRotationPoint(0F, 14F, -6F);
//		setRotation(H3, 0.1745329F, 0F, 0F);
//		H3.mirror = true;
//		H4 = new ModelRenderer(this, 46, 23).setTextureSize(64, 32);
//		;
//		H4.addBox(-2F, 1.5F, 2F, 5, 5, 4);
//		H4.setRotationPoint(0F, 14F, -1F);
//		setRotation(H4, 0F, 0F, 0F);
//		H4.mirror = true;
//		H5 = new ModelRenderer(this, 32, 16).setTextureSize(64, 32);
//		;
//		H5.addBox(-1F, 2F, 4.5F, 3, 3, 4);
//		H5.setRotationPoint(0F, 14F, -1F);
//		setRotation(H5, 0F, 0F, 0F);
//		H5.mirror = true;
//		H6 = new ModelRenderer(this, 52, 6).setTextureSize(64, 32);
//		;
//		H6.addBox(-0.5F, 2.5F, 7.5F, 2, 2, 4);
//		H6.setRotationPoint(0F, 14F, -1F);
//		setRotation(H6, 0F, 0F, 0F);
//		H6.mirror = true;
//		D_L_1 = new ModelRenderer(this, 54, 0).setTextureSize(64, 32);
//		;
//		D_L_1.addBox(-2F, -1.5F, -2F, 2, 3, 3);
//		D_L_1.setRotationPoint(-2F, 20F, -6F);
//		setRotation(D_L_1, 0F, 0F, 0F);
//		D_L_1.mirror = true;
//		D_R_1 = new ModelRenderer(this, 44, 0).setTextureSize(64, 32);
//		;
//		D_R_1.addBox(-1F, -1.5F, -2F, 2, 3, 3);
//		D_R_1.setRotationPoint(4F, 20F, -6F);
//		setRotation(D_R_1, 0F, 0F, 0F);
//		D_R_1.mirror = true;
//		D_L_2 = new ModelRenderer(this, 20, 0).setTextureSize(64, 32);
//		;
//		D_L_2.addBox(-1.5F, 0F, -4F, 1, 2, 3);
//		D_L_2.setRotationPoint(-2F, 20F, -6F);
//		setRotation(D_L_2, 0.8726646F, 0F, 0F);
//		D_L_2.mirror = true;
//		D_R_2 = new ModelRenderer(this, 12, 0).setTextureSize(64, 32);
//		;
//		D_R_2.addBox(-0.5F, 0F, -4F, 1, 2, 3);
//		D_R_2.setRotationPoint(4F, 20F, -6F);
//		setRotation(D_R_2, 0.8726646F, 0F, 0F);
//		D_R_2.mirror = true;
//		DD_L_1 = new ModelRenderer(this, 0, 22).setTextureSize(64, 32);
//		;
//		DD_L_1.addBox(-2F, -2.5F, -2F, 2, 5, 5);
//		DD_L_1.setRotationPoint(-2F, 19F, 1F);
//		setRotation(DD_L_1, 0F, 0F, 0F);
//		DD_L_1.mirror = true;
//		D_D_R_1 = new ModelRenderer(this, 14, 22).setTextureSize(64, 32);
//		;
//		D_D_R_1.addBox(-1F, -2.5F, -2F, 2, 5, 5);
//		D_D_R_1.setRotationPoint(4F, 19F, 1F);
//		setRotation(D_D_R_1, 0F, 0F, 0F);
//		D_D_R_1.mirror = true;
//		DD_L_2 = new ModelRenderer(this, 24, 21).setTextureSize(64, 32);
//		;
//		DD_L_2.addBox(-1.5F, 2.5F, -4F, 1, 2, 3);
//		DD_L_2.setRotationPoint(-2F, 19F, 1F);
//		setRotation(DD_L_2, 1.22173F, 0F, 0F);
//		DD_L_2.mirror = true;
//		DD_R_2 = new ModelRenderer(this, 24, 16).setTextureSize(64, 32);
//		;
//		DD_R_2.addBox(-0.5F, 2.533333F, -4F, 1, 2, 3);
//		DD_R_2.setRotationPoint(4F, 19F, 1F);
//		setRotation(DD_R_2, 1.22173F, 0F, 0F);
//		DD_R_2.mirror = true;
//		T1 = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
//		;
//		T1.addBox(0F, -2.5F, 8F, 1, 5, 3);
//		T1.setRotationPoint(0F, 14F, -1F);
//		setRotation(T1, 0F, 0F, 0F);
//		T1.mirror = true;
//		T2 = new ModelRenderer(this, 12, 13).setTextureSize(64, 32);
//		;
//		T2.addBox(-0.5F, -3.5F, 2F, 2, 5, 4);
//		T2.setRotationPoint(0F, 14F, -1F);
//		setRotation(T2, 0F, 0F, 0F);
//		T2.mirror = true;
//		T3 = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
//		;
//		T3.addBox(-0.5F, -5F, 0F, 2, 5, 8);
//		T3.setRotationPoint(0F, 14F, -6F);
//		setRotation(T3, 0F, 0F, 0F);
//		T3.mirror = true;
//		T4 = new ModelRenderer(this, 0, 13).setTextureSize(64, 32);
//		;
//		T4.addBox(-0.5F, -3F, -3F, 2, 5, 4);
//		T4.setRotationPoint(0F, 14F, -6F);
//		setRotation(T4, 0.2617994F, 0F, 0F);
//		T4.mirror = true;
//	}
//
//	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		super.render(entity, f, f1, f2, f3, f4, f5);
//		setRotationAngles(f, f1, f2, f3, f4, f5, false /* ((EntityDinosaurce) entity).isModelized() */);
//		H1.render(f5);
//		H2.render(f5);
//		H3.render(f5);
//		H4.render(f5);
//		H5.render(f5);
//		H6.render(f5);
//		D_L_1.render(f5);
//		D_R_1.render(f5);
//		D_L_2.render(f5);
//		D_R_2.render(f5);
//		DD_L_1.render(f5);
//		D_D_R_1.render(f5);
//		DD_L_2.render(f5);
//		DD_R_2.render(f5);
//		T1.render(f5);
//		T2.render(f5);
//		T3.render(f5);
//		T4.render(f5);
//	}
//
//	private void setRotation(ModelRenderer model, float x, float y, float z) {
//		model.rotateAngleX = x;
//		model.rotateAngleY = y;
//		model.rotateAngleZ = z;
//	}
//
//	@Override
//	protected void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, boolean b) {
//		if (b)
//			return;
//		H4.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.349065850398866F * f1 + 0F;
//		H5.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.436332312998582F * f1 + 0F;
//		H6.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.488692190558412F * f1 + 0F;
//		D_L_1.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * -0.174532925199433F * f1 + 0F;
//		D_R_1.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		D_L_2.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * -0.174532925199433F * f1 + 0.872664625997162F;
//		D_R_2.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0.872664625997162F;
//		DD_L_1.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		DD_L_1.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		D_D_R_1.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * -0.174532925199433F * f1 + 0F;
//		D_D_R_1.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		DD_L_2.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 1.22173047639603F;
//		DD_L_2.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		DD_R_2.rotateAngleX = Mth.cos(f / (1.919107651F * 0.5F)) * -0.174532925199433F * f1 + 1.22173047639603F;
//		DD_R_2.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		T1.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.488692190558412F * f1 + 0F;
//		T2.rotateAngleY = Mth.cos(f / (1.919107651F * 0.5F)) * 0.349065850398866F * f1 + 0F;
//		T2.rotateAngleZ = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		T3.rotateAngleZ = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//		T4.rotateAngleZ = Mth.cos(f / (1.919107651F * 0.5F)) * 0.174532925199433F * f1 + 0F;
//
//	}
//}
