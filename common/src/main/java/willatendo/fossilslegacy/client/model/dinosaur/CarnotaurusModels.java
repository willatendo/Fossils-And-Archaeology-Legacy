package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class CarnotaurusModels {
    public static LayerDefinition createCarnotaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition neck = partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(24, 37).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 9.0F, 4.0F), PartPose.offset(0.0F, 12.0F, -7.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 29).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 5.0F, 6.0F).texOffs(24, 29).addBox(-3.0F, 2.0F, -6.0F, 6.0F, 2.0F, 6.0F).texOffs(14, 40).addBox(-4.0F, -4.0F, -2.0F, 3.0F, 2.0F, 2.0F).texOffs(14, 44).addBox(1.0F, -4.0F, -2.0F, 3.0F, 2.0F, 2.0F), PartPose.offset(0.0F, -3.0F, -3.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(30, 0).addBox(-1.0F, -3.0F, 8.0F, 2.0F, 4.0F, 8.0F).texOffs(26, 15).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 13.0F, 6.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 37).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F).texOffs(0, 50).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 3.0F, 2.0F).texOffs(48, 29).addBox(-2.0F, 6.0F, -2.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(-4.0F, 16.0F, 3.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 6.0F, 4.0F).texOffs(14, 48).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 3.0F, 2.0F).texOffs(40, 47).addBox(-1.0F, 6.0F, -2.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 16.0F, 3.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(50, 5).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 3.0F), PartPose.offset(3.0F, 15.0F, -6.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(50, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 3.0F), PartPose.offset(-3.0F, 15.0F, -6.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -14.0F, -1.0F, 8.0F, 8.0F, 7.0F).texOffs(0, 15).addBox(-3.0F, -14.0F, -8.0F, 6.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createLegacyCarnotaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 7.0F, 8.0F), PartPose.offset(-4.5F, 2.5F, -27.0F));
        partDefinition.addOrReplaceChild("horn_1", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-6.5F, 1.5F, -23.0F, 0.0F, -0.0F, 0.3490658503988659F));
        partDefinition.addOrReplaceChild("horn_2", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(2.5F, 2.5F, -23.0F, 0.0F, -0.0F, -0.3490658503988659F));
        partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 7.0F), PartPose.offset(-3.5F, 9.0F, -26.0F));
        partDefinition.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(34, 59).addBox(0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-4.5F, 10.4F, -27.0F, 1.5707963267948966F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(20, 4).addBox(0.0F, 0.0F, 0.0F, 5.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(-3.0F, 2.5F, -20.0F, -0.4363323129985824F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, 0.0F, 0.0F, 7.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(-4.0F, 5.5F, -13.0F, -0.001549108791234052F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(0, 43).addBox(0.0F, 0.0F, 0.0F, 9.0F, 10.0F, 8.0F), PartPose.offsetAndRotation(-5.0F, 5.5F, -6.0F, -0.03490658503988659F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-6.0F, 11.5F, -13.0F, 0.8726646259971648F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(3.0F, 11.5F, -13.0F, 0.8726646259971648F, -0.0F, 0.0F));
        PartDefinition rightThigh = partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-9.0F, 9.5F, -4.0F, -0.17453292519943295F, -0.0F, 0.0F));
        PartDefinition rightLeg = rightThigh.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(52, 51).addBox(0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(2.0F, 6.5F, 4.0F, -0.2617993877991494F, -0.0F, 0.0F));
        rightLeg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(34, 51).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-1.0F, 6.5F, -3.0F, 0.2617993877991494F, -0.0F, 0.0F));
        PartDefinition leftThigh = partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(44, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(4.0F, 9.5F, -4.0F, -0.17453292519943295F, -0.0F, 0.0F));
        PartDefinition leftLeg = leftThigh.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(52, 51).addBox(0.0F, 0.0F, 0.0F, 2.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 6.5F, 4.0F, -0.2617993877991494F, -0.0F, 0.0F));
        leftLeg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(34, 51).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 6.5F, -3.0F, 0.2617993877991494F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(26, 36).addBox(0.0F, 0.0F, -1.0F, 7.0F, 6.0F, 9.0F), PartPose.offsetAndRotation(-4.0F, 6.0F, 1.0F, -0.03717861098961725F, -0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(34, 22).addBox(0.0F, 0.0F, -1.0F, 5.0F, 5.0F, 9.0F), PartPose.offset(-3.0F, 6.5F, 9.5F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(25, 22).addBox(0.0F, 0.0F, -1.0F, 3.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, 7.0F, 18.5F, -0.03717861098961725F, -0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
