package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class FutabasaurusModels {
    public static LayerDefinition createFutabasaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(35, 33).addBox(-3.0F, -6.0F, -11.0F, 6.0F, 5.0F, 5.0F).texOffs(0, 0).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 24.0F, 17.0F));
        PartDefinition neck = partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -2.5F, -10.0F, 6.0F, 5.0F, 10.0F), PartPose.offset(0.0F, 20.5F, -6.0F));
        PartDefinition middle_neck = neck.addOrReplaceChild("middle_neck", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.5F, -16.0F, 4.0F, 3.0F, 16.0F), PartPose.offset(0.0F, 0.0F, -10.0F));
        middle_neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 15).addBox(-3.0F, -2.5F, -8.0F, 6.0F, 5.0F, 8.0F), PartPose.offset(0.0F, 0.0F, -16.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(-4.0F, 23.0F, -3.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 43).addBox(0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 23.0F, -3.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(18, 39).addBox(-5.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(-4.0F, 23.0F, 3.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 44).addBox(0.0F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 23.0F, 3.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 12.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createLegacyFutabasaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 9.0F, -15.0F, 0.49723F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(20, 23).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, -0.99446F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(47, 23).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -4.0F, -0.88974F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_3", CubeListBuilder.create().texOffs(35, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 12.73333F, -8.0F, -0.58764F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_4", CubeListBuilder.create().texOffs(35, 3).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 10.0F, -11.0F, -0.13561F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 20.0F, 0.0F));
        partDefinition.addOrReplaceChild("front_right_flipper", CubeListBuilder.create().texOffs(44, 13).addBox(0.0F, 0.0F, 0.0F, 6.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, 21.0F, -3.0F, -0.5236F, -2.35619F, 0.0F));
        partDefinition.addOrReplaceChild("front_left_flipper", CubeListBuilder.create().texOffs(44, 18).addBox(0.0F, 0.0F, -4.0F, 6.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.0F, 21.0F, -3.0F, 0.5236F, -0.7854F, 0.0F));
        partDefinition.addOrReplaceChild("back_right_flipper", CubeListBuilder.create().texOffs(48, 0).addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-3.0F, 21.0F, 4.0F, -0.5236F, -2.0944F, 0.0F));
        partDefinition.addOrReplaceChild("back_left_flipper", CubeListBuilder.create().texOffs(48, 4).addBox(0.0F, 0.0F, -3.0F, 5.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(3.0F, 21.0F, 4.0F, 0.5236F, -1.0472F, 0.0F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -5.0F, 2.0F, 6.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, -0.45203F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(18, 14).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 20.0F, 5.0F, -0.27122F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 21.0F, 11.0F, -0.18081F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}