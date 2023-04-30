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

public class BabyTriceratopsModel extends AbstractTriceratopsModel {
	public BabyTriceratopsModel(ModelPart root) {
		super(root, root.getChild("head"));
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 14).addBox(-5.0F, -7.0F, -1.0F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 14).addBox(-6.0F, -8.0F, -1.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(21, 0).addBox(-3.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(30, 8).addBox(-2.0F, -1.0F, -5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 19.0F, -3.0F));
		head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.5F, -3.5F, -0.8727F, 0.0F, 0.0F));
		head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 28).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(28, 22).addBox(1.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.5F, -1.0F, -0.9163F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(20, 28).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 21.0F, -1.0F));
		partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 21.0F, -1.0F));
		partdefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(10, 22).addBox(-2.0F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 19.0F, 3.5F));
		partdefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -1.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 19.0F, 3.5F));
		partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(20, 22).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 18.0F, 6.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
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