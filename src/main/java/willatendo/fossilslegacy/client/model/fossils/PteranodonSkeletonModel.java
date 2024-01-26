package willatendo.fossilslegacy.client.model.fossils;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class PteranodonSkeletonModel extends AbstractSkeletonModel {
	public PteranodonSkeletonModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 14.0F, -4.0F, 1.571F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(16, 22).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 14.0F, -4.0F, 0.698F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(44, 9).addBox(-1.0F, -1.0F, -12.0F, 2.0F, 1.0F, 8.0F), PartPose.offset(0.0F, 14.0F, -4.0F));
		partDefinition.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -2.0F, -12.0F, 2.0F, 1.0F, 8.0F), PartPose.offset(0.0F, 14.0F, -4.0F));
		partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(8, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, 1.130069F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 14.0F, -3.0F, 1.446489F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 0.587636F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("right_wing_1", CubeListBuilder.create().texOffs(16, 7).addBox(0.0F, 0.0F, -1.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 16.0F, 1.0F, -0.349F, 2.269F, -0.524F));
		partDefinition.addOrReplaceChild("right_wing_2", CubeListBuilder.create().texOffs(46, 18).addBox(-1.0F, -1.0F, -1.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-6.9F, 20.0F, -4.0F, 2.541F, -0.419F, -3.002F));
		partDefinition.addOrReplaceChild("left_wing_1", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(2.0F, 16.0F, 1.0F, 0.349F, 0.873F, 0.542F));
		partDefinition.addOrReplaceChild("left_wing_2", CubeListBuilder.create().texOffs(46, 23).addBox(-1.0F, -1.0F, 0.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(6.9F, 20.0F, -4.0F, 0.583F, -0.419F, -0.140F));
		partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 4).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 22.0F, 2.0F, -0.2712166F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 22.0F, 2.0F, -0.2712166F, 0.0F, 0.0F));
		partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 5.0F, 0.2260139F, 0.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 32);
	}
}
