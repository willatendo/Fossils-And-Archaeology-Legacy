package willatendo.fossilslegacy.client.model.pterosaurus;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.server.entity.Pteranodon;

public class BabyPteranodonModel extends AbstractPteranodonModel {
	public BabyPteranodonModel(ModelPart root) {
		super(root, root.getChild("head"));
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 4).addBox(-1.0F, -5.0F, -4.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(8, 29).addBox(0.0F, 8.0F, -4.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(11, 13).addBox(-1.0F, -3.0F, -11.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 12).addBox(-1.0F, -4.0F, -11.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -1.0F));
		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(30, 27).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 12).addBox(-5.0F, -1.0F, -0.25F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 18.0F, 0.5F));
		PartDefinition right_tip = right_wing.addOrReplaceChild("right_tip", CubeListBuilder.create(), PartPose.offset(-1.5F, 6.0F, 0.25F));
		right_tip.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -12.0F, -0.75F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 21).addBox(-1.0F, -12.0F, -0.5F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));
		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -1.0F, -0.25F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(30, 19).addBox(0.0F, -1.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 18.0F, 0.5F));
		PartDefinition left_tip = left_wing.addOrReplaceChild("left_tip", CubeListBuilder.create(), PartPose.offset(-3.0F, 6.0F, -0.5F));
		left_tip.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 21).addBox(-3.0F, -12.0F, -0.5F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(4, 27).addBox(0.0F, -12.0F, -0.75F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.3054F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 12).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 21.0F, 4.5F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(11, 12).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 21.0F, 4.5F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.0F, -1.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 20).addBox(-2.0F, -6.0F, 5.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Pteranodon pteranodon, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(pteranodon, netHeadYaw, headPitch, ageInTicks);
//		float f = (float) pteranodon.getDeltaMovement().horizontalDistanceSqr();
//		float f1 = Mth.clamp(f * 400.0F, 0.3F, 2.0F);
//		this.animate(pteranodon.walkAnimationState, TriceratopsAnimations.TRICERATOPS_WALK, ageInTicks, f1);
	}
}