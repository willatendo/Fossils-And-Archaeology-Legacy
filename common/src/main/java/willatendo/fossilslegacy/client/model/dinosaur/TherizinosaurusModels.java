package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class TherizinosaurusModels {
    public static LayerDefinition createLegacyTherizinosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition lowerBody = partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 8.2F, 1.0F, -0.4993387096482221F, -0.0F, 0.0F));
        PartDefinition upperBody = lowerBody.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 2.1F, 0.2F, 0.05305800859483734F, -0.0F, 0.0F));
        PartDefinition neck = upperBody.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -12.0F, -1.5F, 2.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.5F, -4.5F, 0.888547119527152F, -0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -7.0F, 4.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -11.0F, 0.5F, -0.32707469782899573F, -0.0F, 0.0F));
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, 0.0F, -6.0F, 3.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.9F, -0.5F, -0.08272860254978959F, -0.0F, 0.0F));
        PartDefinition rightUpperArm = upperBody.addOrReplaceChild("right_upper_arm", CubeListBuilder.create().texOffs(38, 16).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-3.0F, -0.1F, -5.1F, 0.5235987755982988F, -0.0F, 0.0F));
        PartDefinition rightLowerArm = rightUpperArm.addOrReplaceChild("right_lower_arm", CubeListBuilder.create().texOffs(30, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-0.9F, 3.0F, 0.5F, -0.8552113334772213F, -0.0F, 0.0F));
        PartDefinition rightLowerFeather = rightLowerArm.addOrReplaceChild("right_lower_feather", CubeListBuilder.create().texOffs(46, 50).addBox(0.0F, -0.5F, 2.0F, 1.0F, 5.0F, 3.0F), PartPose.offset(-0.99F, 0.2F, -0.15F));
        rightLowerFeather.addOrReplaceChild("right_front_claw", CubeListBuilder.create().texOffs(18, 10).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 2.9F, 0.2F, 0.33161255787892263F, 0.0F, 0.0F));
        rightLowerFeather.addOrReplaceChild("right_middle_claw", CubeListBuilder.create().texOffs(18, 10).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.9F, 3.2F, 0.2F, 0.767944870877505F, -0.0F, 0.0F));
        rightLowerArm.addOrReplaceChild("right_back_claw", CubeListBuilder.create().texOffs(18, 10).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(-0.2F, 3.4F, 0.0F, 1.0995574287564276F, 0.0F, 0.0F));
        PartDefinition leftUpperArm = upperBody.addOrReplaceChild("left_upper_arm", CubeListBuilder.create().texOffs(38, 16).addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(3.0F, 0.1F, -5.1F, 0.5235987755982988F, -0.0F, 0.0F));
        PartDefinition leftLowerArm = leftUpperArm.addOrReplaceChild("left_lower_arm", CubeListBuilder.create().texOffs(30, 16).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.9F, 3.0F, 0.5F, -0.8552113334772213F, -0.0F, 0.0F));
        PartDefinition leftLowerFeather = leftLowerArm.addOrReplaceChild("left_lower_feather", CubeListBuilder.create().texOffs(46, 50).addBox(1.0F, -0.5F, 2.0F, 1.0F, 5.0F, 3.0F).mirror(), PartPose.offset(-0.99F, 0.2F, -0.15F));
        leftLowerFeather.addOrReplaceChild("left_front_claw", CubeListBuilder.create().texOffs(18, 10).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 2.9F, 0.2F, 0.33161255787892263F, 0.0F, 0.0F));
        leftLowerFeather.addOrReplaceChild("left_middle_claw", CubeListBuilder.create().texOffs(18, 10).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(1.1F, 3.2F, 0.2F, 0.767944870877505F, -0.0F, 0.0F));
        leftLowerArm.addOrReplaceChild("left_back_claw", CubeListBuilder.create().texOffs(18, 10).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F), PartPose.offsetAndRotation(0.2F, 3.4F, 0.0F, 1.0995574287564276F, 0.0F, 0.0F));
        PartDefinition rightThigh = partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(1, 18).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-4.0F, 13.9F, 4.0F, -0.08726646259971647F, -0.0F, 0.0F));
        PartDefinition rightLeg = rightThigh.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-1.1F, 3.8F, 1.3F, -0.05235987755982988F, -0.0F, 0.0F));
        rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(10, 28).addBox(-2.0F, 0.0F, -5.0F, 3.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.1F, 4.0F, 1.2F, 0.13962634015954636F, -0.0F, 0.0F));
        PartDefinition leftThigh = partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(1, 18).addBox(0.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(4.0F, 13.9F, 4.0F, -0.08726646259971647F, -0.0F, 0.0F));
        PartDefinition leftLeg = leftThigh.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(1.1F, 3.8F, 1.3F, -0.05235987755982988F, -0.0F, 0.0F));
        leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(10, 28).addBox(-1.0F, 0.0F, -5.0F, 3.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-0.1F, 4.0F, 1.2F, 0.13962634015954636F, -0.0F, 0.0F));
        PartDefinition tail1 = lowerBody.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(44, 28).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 0.8F, 7.5F, 0.162315623764424F, -0.0F, 0.0F));
        tail1.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(44, 38).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 1.6F, 5.5F, -0.09791297336714784F, -0.0F, 0.0F));
        rightUpperArm.addOrReplaceChild("right_upper_feather", CubeListBuilder.create().texOffs(46, 49).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 6.0F, 3.0F), PartPose.offset(-1.3F, 2.4F, 0.9F));
        leftUpperArm.addOrReplaceChild("left_upper_feather", CubeListBuilder.create().texOffs(46, 49).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 6.0F, 3.0F).mirror(), PartPose.offset(1.3F, 2.4F, 0.9F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}