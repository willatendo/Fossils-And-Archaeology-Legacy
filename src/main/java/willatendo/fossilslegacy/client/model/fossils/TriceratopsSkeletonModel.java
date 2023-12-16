package willatendo.fossilslegacy.client.model.fossils;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TriceratopsSkeletonModel extends AbstractSkeletonModel {
	public TriceratopsSkeletonModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(42, 0).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 5.0F, 5.0F), PartPose.offset(0.0F, 20.0F, -1.0F));
		partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(48, 10).addBox(-2.5F, -0.2F, 0.0F, 5.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.2712F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(54, 17).addBox(-1.5F, 0.0F, 3.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.4519F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(54, 21).addBox(-1.0F, 2.0F, 4.0F, 2.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, -0.1808F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(20, 0).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.4F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("crest_overlay", CubeListBuilder.create().texOffs(20, 8).addBox(-5.0F, -9.0F, 0.0F, 10.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.4F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, 0.1396F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(0, 10).addBox(-1F, -2.5F, -3.0F, 2.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, 0.81364F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("nose_horn", CubeListBuilder.create().texOffs(24, 24).addBox(-0.5F, 2.0F, -3.0F, 1.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -1.13F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_horn_base", CubeListBuilder.create().texOffs(24, 27).addBox(-2.0F, -4.0F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_horn", CubeListBuilder.create().texOffs(33, 27).addBox(-2.0F, -4.0F, -6.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_horn_base", CubeListBuilder.create().texOffs(24, 27).addBox(1.0F, -4.0F, -3.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(33, 27).addBox(1.0F, -4.0F, -6.0F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 21.0F, -5.0F, -0.31642F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_front_thigh", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, 1.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 19.0F, -2.0F));
		partDefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(8, 19).addBox(-3.0F, 1.0F, -6.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.0F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_front_thigh", CubeListBuilder.create().texOffs(0, 16).addBox(2.0F, 2.0F, -2.0F, 2.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 18.0F, -2.0F));
		partDefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(16, 19).addBox(2.0F, 1.0F, -6.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, -2.0F, 1.0F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_back_thigh", CubeListBuilder.create().texOffs(0, 24).addBox(-4.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 18.0F, 2.0F));
		partDefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(24, 19).addBox(-3.0F, 2.0F, -5.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 1.0F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_back_thigh", CubeListBuilder.create().texOffs(12, 24).addBox(2.0F, 0.0F, -2.0F, 2.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 18.0F, 2.0F));
		partDefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(32, 19).addBox(2.0F, 2.0F, -5.0F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 1.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}
}
