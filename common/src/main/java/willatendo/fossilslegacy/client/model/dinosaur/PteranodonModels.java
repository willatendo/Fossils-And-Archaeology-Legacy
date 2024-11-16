package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class PteranodonModels {
    public static LayerDefinition createPteranodonBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition whole = partDefinition.addOrReplaceChild("whole", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));

        whole.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.7854F, 0.0F, 0.0F));
        whole.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 41).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(1.5F, 2.0F, 0.0F));
        whole.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(8, 41).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-1.5F, 2.0F, 0.0F));
        PartDefinition neck = whole.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(40, 36).addBox(-1.0F, -7.0F, -2.0F, 2.0F, 8.0F, 4.0F), PartPose.offset(0.0F, -3.0F, -5.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 5.0F).texOffs(0, 14).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 1.0F, 9.0F).texOffs(22, 0).addBox(-1.0F, 0.0F, -13.0F, 2.0F, 1.0F, 9.0F).texOffs(18, 26).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 2.0F, 7.0F), PartPose.offset(0.0F, -6.0F, -1.0F));
        PartDefinition right_wing = whole.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(22, 10).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(0, 35).addBox(-10.0F, 1.0F, 0.0F, 10.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-3.0F, -3.0F, -4.0F, 1.5708F, 0.0F, -1.0472F));
        right_wing.addOrReplaceChild("right_wing_tip", CubeListBuilder.create().texOffs(22, 18).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(36, 26).addBox(-10.0F, 1.0F, 0.0F, 10.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(-10.0F, 1.0F, 0.0F, 0.0F, 2.0944F, 0.0F));
        PartDefinition left_wing = whole.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(22, 14).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(20, 35).addBox(0.0F, 1.0F, 0.0F, 10.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(3.0F, -3.0F, -4.0F, 1.5708F, 0.0F, 1.0472F));
        left_wing.addOrReplaceChild("left_wing_tip", CubeListBuilder.create().texOffs(22, 22).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(40, 31).addBox(0.0F, 1.0F, 0.0F, 10.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(10.0F, 1.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createLegacyPteranodonBodyLayer() {
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

    public static LayerDefinition createLegacyLandingPteranodonBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -5.0F, 2.12453F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(16, 22).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -6.0F, 1.084867F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(44, 9).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -8.0F, 0.7684471F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 17.0F, -9.0F, 0.5235988F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(8, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 1.130069F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 15.0F, -3.0F, 1.446489F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -2.0F, 4, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 17.0F, 2.0F, 0.587636F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_wing_1", CubeListBuilder.create().texOffs(16, 7).addBox(0.0F, 0.0F, -1.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 14.0F, 1.0F, 2.617994F, -0.4363323F, -2.792527F));
        partDefinition.addOrReplaceChild("right_wing_2", CubeListBuilder.create().texOffs(46, 18).addBox(0.0F, 0.0F, 0.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-8.0F, 11.0F, 5.0F, -0.6108652F, 3.141593F, 0.0F));
        partDefinition.addOrReplaceChild("left_wing_1", CubeListBuilder.create().texOffs(16, 0).addBox(0.0F, 0.0F, 0.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(2.0F, 14.0F, 1.0F, -2.617994F, -2.740167F, 2.792527F));
        partDefinition.addOrReplaceChild("left_wing_2", CubeListBuilder.create().texOffs(46, 23).addBox(0.0F, 0.0F, -1.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 11.0F, 5.0F, 0.6108652F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 4).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 21.0F, 2.0F, 0.2712166F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 21.0F, 2.0F, -0.2712166F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 11).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 19.0F, 5.0F, 0.2260139F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    public static LayerDefinition createLegacyFlyingPteranodonBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 23).addBox(-2.0F, -13.0F, -1.0F, 4.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(16, 22).addBox(-1.0F, -10.0F, -9.0F, 2.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.4859298F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(44, 9).addBox(-1.0F, -2.0F, -20.0F, 2.0F, 1.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.1356083F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -1.0F, -21.0F, 2.0F, 1.0F, 8.0F), PartPose.offset(0.0F, 23.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_1", CubeListBuilder.create().texOffs(8, 16).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("neck_2", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.5F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_wing_1", CubeListBuilder.create().texOffs(16, 7).addBox(2.0F, -3.0F, -1.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, -2.792527F));
        partDefinition.addOrReplaceChild("right_wing_2", CubeListBuilder.create().texOffs(46, 18).addBox(9.0F, -3.0F, -4.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, -1.570796F, 3.141593F, 0.0F));
        partDefinition.addOrReplaceChild("left_wing_1", CubeListBuilder.create().texOffs(16, 0).addBox(2.0F, -3.0F, 0.0F, 8.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, -1.570796F, 3.141593F, 2.792527F));
        partDefinition.addOrReplaceChild("left_wing_2", CubeListBuilder.create().texOffs(46, 23).addBox(9.0F, -3.0F, 3.0F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 4).addBox(-2.0F, 3.0F, -2.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 0).addBox(1.0F, 3.0F, -2.0F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, 2.0F, 0.0F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 1.570796F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
