package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class CryolophosaurusModels {
    public static LayerDefinition createCryolophosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(46, 13).addBox(-1.0F, 8.0F, -3.0F, 3.0F, 2.0F, 5.0F).texOffs(24, 49).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F).texOffs(34, 33).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 6.0F, 5.0F), PartPose.offset(3.0F, 14.0F, 3.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(34, 44).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 6.0F, 5.0F).texOffs(50, 28).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F).texOffs(0, 45).addBox(-2.0F, 8.0F, -3.0F, 3.0F, 2.0F, 5.0F), PartPose.offset(-3.0F, 14.0F, 3.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 7.0F).texOffs(0, 18).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 10.0F), PartPose.offset(0.0F, 10.0F, 6.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(46, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(2.0F, 14.0F, -7.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 49).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-2.0F, 14.0F, -7.0F));
        PartDefinition neck = partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(22, 33).addBox(-1.0F, -9.0F, -2.0F, 2.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 10.0F, -9.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, -4.0F, -7.0F, 4.0F, 5.0F, 8.0F).texOffs(30, 13).addBox(-2.0F, -9.0F, -1.0F, 4.0F, 4.0F, 0.0F).texOffs(50, 35).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -6.0F, -1.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 9.0F, 9.0F).texOffs(24, 18).addBox(-2.0F, -17.0F, -10.0F, 4.0F, 8.0F, 7.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createLegacyCryolophosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition lowerBody = partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(0, 29).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 9.3F, -0.5F, -0.037175515064850034F, -0.0F, 0.0F));
        PartDefinition upperBody = lowerBody.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, -3.0F, -6.0F, 5.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 0.5F, 0.05235987755982988F, -0.0F, 0.0F));
        PartDefinition neck = upperBody.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, -0.5F, -4.5F, -0.4780456714686025F, -0.0F, 0.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 0).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(0.0F, -0.6F, -4.5F, 0.5585053606381855F, -0.0F, 0.0F));
        PartDefinition upperJaw = head.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -3.8F, 0.08726646259971647F, -0.0F, 0.0F));
        upperJaw.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(14, 0).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F), PartPose.offsetAndRotation(0.0F, -1.3F, -0.2F, -0.19198621771937624F, 0.0F, 0.0F));
        head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, 0.0F, -6.0F, 2.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 1.9F, -1.9F));
        upperJaw.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(0, 44).addBox(-1.5F, 0.0F, -6.0F, 3.0F, 1.0F, 4.0F), PartPose.offset(0.0F, 2.0F, 1.1F));
        PartDefinition rightUpperArm = upperBody.addOrReplaceChild("right_upper_arm", CubeListBuilder.create().texOffs(10, 9).addBox(-2.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F), PartPose.offset(-2.5F, 0.5F, -5.0F));
        rightUpperArm.addOrReplaceChild("right_lower_arm", CubeListBuilder.create().texOffs(20, 8).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-0.9F, 2.0F, 0.5F, -0.4363323129985824F, -0.0F, 0.0F));
        PartDefinition leftUpperArm = upperBody.addOrReplaceChild("left_upper_arm", CubeListBuilder.create().texOffs(10, 9).addBox(0.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F), PartPose.offset(2.5F, 0.5F, -5.0F));
        leftUpperArm.addOrReplaceChild("left_lower_arm", CubeListBuilder.create().texOffs(20, 8).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.9F, 2.0F, 0.5F, -0.4363323129985824F, -0.0F, 0.0F));
        PartDefinition rightThigh = partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(21, 26).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F), PartPose.offset(-3.5F, 13.0F, 4.5F));
        PartDefinition rightLeg = rightThigh.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(35, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(-1.3F, 3.5F, 2.0F, -0.20943951023931953F, 0.0F, 0.0F));
        rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(50, 23).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.2F, 5.6F, 0.0F, 0.20943951023931953F, -0.0F, 0.0F));
        PartDefinition leftThigh = partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(21, 26).addBox(0.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F), PartPose.offset(3.5F, 13.0F, 4.5F));
        PartDefinition leftLeg = leftThigh.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(35, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(1.3F, 3.5F, 2.0F, -0.20943951023931953F, 0.0F, 0.0F));
        leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(50, 23).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-0.2F, 5.6F, 0.0F, 0.20943951023931953F, -0.0F, 0.0F));
        PartDefinition tail1 = lowerBody.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(38, 10).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.2F, 7.0F, -0.024260076353049827F, -0.0F, 0.0F));
        PartDefinition tail2 = tail1.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(36, 33).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.4F, 7.0F, 0.06754424005480975F, -0.0F, 0.0F));
        tail2.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(22, 14).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 0.5F, 6.5F, -0.06981317007977318F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
