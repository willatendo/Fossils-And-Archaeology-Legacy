package fossilslegacy.client.model.triceratops;

import fossilslegacy.client.animation.TriceratopsAnimations;
import fossilslegacy.server.entity.Triceratops;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class TriceratopsModel extends AbstractTriceratopsModel {
	public TriceratopsModel(ModelPart root) {
		super(root, root.getChild("head"));
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-6.0F, -12.0F, -2.0F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 26).addBox(-8.0F, -14.0F, -2.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(55, 7).addBox(-3.0F, -4.0F, -7.0F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(67, 66).addBox(-2.0F, -3.0F, -10.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -8.0F));
		head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-0.5F, 0.5F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, -7.5F, -0.8727F, 0.0F, 0.0F));
		head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(19, 42).addBox(-4.5F, -2.0F, -12.5F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 44).addBox(0.5F, -2.0F, -12.5F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.0F, -2.0F, -0.48F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(17, 44).addBox(-2.0F, 6.0F, -1.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(57, 35).addBox(-3.0F, -3.0F, -4.0F, 4.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 13.0F, -3.0F));
		partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(64, 57).addBox(-1.0F, 6.0F, -1.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(23, 57).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 13.0F, -3.0F));
		partdefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(45, 61).addBox(-3.0F, -3.0F, -3.0F, 4.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-2.0F, 5.0F, 0.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 14.0F, 7.0F));
		partdefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(64, 20).addBox(-1.0F, 5.0F, 0.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 59).addBox(-1.0F, -3.0F, -3.0F, 4.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 14.0F, 7.0F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(38, 46).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 14.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -18.0F, -8.0F, 10.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 26).addBox(-4.0F, -16.0F, 6.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Triceratops triceratops, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(triceratops, netHeadYaw, headPitch, ageInTicks);
		float f = (float) triceratops.getDeltaMovement().horizontalDistanceSqr();
		float f1 = Mth.clamp(f * 400.0F, 0.3F, 2.0F);
		this.animate(triceratops.walkAnimationState, TriceratopsAnimations.TRICERATOPS_WALK, ageInTicks, f1);
	}
}