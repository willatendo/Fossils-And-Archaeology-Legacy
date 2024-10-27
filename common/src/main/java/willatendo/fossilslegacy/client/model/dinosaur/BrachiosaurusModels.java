package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class BrachiosaurusModels {
    public static LayerDefinition createBrachiosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 5.0F, 6.0F).texOffs(30, 21).addBox(-2.0F, -2.0F, 6.0F, 4.0F, 4.0F, 10.0F), PartPose.offset(0.0F, 17.0F, 8.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(62, 49).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 6.0F, 3.0F).texOffs(58, 21).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(-5.0F, 14.0F, -3.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(46, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(-4.0F, 16.0F, 4.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(62, 58).addBox(-2.0F, 4.0F, -2.0F, 4.0F, 6.0F, 3.0F).texOffs(58, 10).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(5.0F, 14.0F, -3.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(54, 35).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 4.0F), PartPose.offset(4.0F, 16.0F, 4.0F));
        PartDefinition neck = partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 11.0F, 7.0F).texOffs(30, 35).addBox(-3.0F, -12.0F, -7.0F, 6.0F, 12.0F, 6.0F).texOffs(40, 0).addBox(-2.0F, -23.0F, -8.0F, 4.0F, 13.0F, 5.0F), PartPose.offset(0.0F, 12.0F, -4.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 53).addBox(-3.0F, -2.0F, 3.0F, 6.0F, 6.0F, 5.0F).texOffs(58, 0).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 6.0F).texOffs(0, 62).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 5.0F), PartPose.offset(0.0F, -22.0F, -12.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -13.0F, 4.0F, 8.0F, 8.0F, 4.0F).texOffs(0, 0).addBox(-5.0F, -16.0F, -6.0F, 10.0F, 11.0F, 10.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    public static LayerDefinition createLegacyBrachiosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 14).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 3.0F, 4.0F).mirror(), PartPose.offset(0.0F, -6.0F, -10.5F));
        partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(50, 8).addBox(-1.5F, -1.0F, -6.5F, 3.0F, 2.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, -6.0F, -11.0F, 0.2617994F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(52, 0).addBox(-1.0F, -3.0F, -5.0F, 2.0F, 4.0F, 4.0F).mirror(), PartPose.offset(0.0F, -6.0F, -11.0F));
        partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -6.0F, -10.5F, -0.7853982F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -4.5F, -9.0F, -0.9599311F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_3", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -1.23464F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_4", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_5", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 2.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_6", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 4.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_7", CubeListBuilder.create().texOffs(22, 0).addBox(-1.5F, 0.0F, 6.0F, 3.0F, 2.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, -1.5F, -7.5F, -1.343904F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_8", CubeListBuilder.create().texOffs(34, 11).addBox(-2.0F, -1.0F, -0.5F, 4.0F, 3.0F, 3.0F).mirror(), PartPose.offsetAndRotation(0.0F, 6.0F, -6.5F, -0.9637522F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_neck_1", CubeListBuilder.create().texOffs(32, 24).addBox(-2.5F, -0.5F, -0.5F, 5.0F, 4.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 7.0F, -5.0F, -0.8377581F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_neck_2", CubeListBuilder.create().texOffs(10, 21).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 6.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 7.0F, -5.0F, -0.3907885F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 7.0F, 6.0F).mirror(), PartPose.offsetAndRotation(0.0F, 8.0F, -3.0F, -0.1115358F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(28, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 6.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 9.0F, 2.0F, -0.3346075F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("front_right_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(0.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F).mirror(), PartPose.offset(3.0F, 12.0F, -3.5F));
        partDefinition.addOrReplaceChild("front_right_calf", CubeListBuilder.create().texOffs(0, 24).addBox(0.5F, 7.0F, -2.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(3.0F, 12.0F, -3.5F));
        partDefinition.addOrReplaceChild("front_left_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(-3.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F).mirror(), PartPose.offset(-3.0F, 12.0F, -3.5F));
        partDefinition.addOrReplaceChild("front_left_calf", CubeListBuilder.create().texOffs(0, 24).addBox(-2.5F, 7.0F, -2.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(-3.0F, 12.0F, -3.5F));
        partDefinition.addOrReplaceChild("back_right_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F).mirror(), PartPose.offset(3.0F, 14.0F, 4.5F));
        partDefinition.addOrReplaceChild("back_right_calf", CubeListBuilder.create().texOffs(0, 24).addBox(-0.5F, 5.0F, -1.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(3.0F, 14.0F, 4.5F));
        partDefinition.addOrReplaceChild("back_left_thigh", CubeListBuilder.create().texOffs(50, 21).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 5.0F, 4.0F).mirror(), PartPose.offset(-3.0F, 14.0F, 4.5F));
        partDefinition.addOrReplaceChild("back_left_calf", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, 5.0F, -1.0F, 2.0F, 5.0F, 3.0F).mirror(), PartPose.offset(-3.0F, 14.0F, 4.5F));
        partDefinition.addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(0, 13).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 11.0F, 6.0F, -0.7064018F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_mid", CubeListBuilder.create().texOffs(18, 13).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, 8.0F, -0.5576873F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_end", CubeListBuilder.create().texOffs(34, 17).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 16.5F, 10.5F, -0.3717943F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}