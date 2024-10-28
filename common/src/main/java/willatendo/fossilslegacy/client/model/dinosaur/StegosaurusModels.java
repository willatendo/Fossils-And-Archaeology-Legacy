package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class StegosaurusModels {
    public static LayerDefinition createStegosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(62, 51).addBox(-2.0F, -5.0F, -4.0F, 4.0F, 11.0F, 7.0F).texOffs(84, 24).addBox(-2.0F, 6.0F, 0.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(6.0F, 12.0F, 3.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(84, 51).addBox(-1.0F, 4.0F, 0.0F, 3.0F, 6.0F, 3.0F).texOffs(0, 67).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 11.0F, 7.0F), PartPose.offset(-6.0F, 14.0F, 3.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(82, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F), PartPose.offset(3.5F, 16.0F, -9.5F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(84, 12).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F), PartPose.offset(-3.5F, 16.0F, -9.5F));
        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 66).addBox(-2.0F, -2.0F, -9.0F, 4.0F, 5.0F, 9.0F), PartPose.offset(0.0F, 12.0F, -13.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 50).addBox(-2.0F, -4.0F, 0.0F, 6.0F, 7.0F, 10.0F).texOffs(50, 0).addBox(-1.0F, -4.0F, 10.0F, 4.0F, 3.0F, 12.0F).texOffs(58, 69).addBox(3.0F, -10.0F, 0.0F, 0.0F, 6.0F, 10.0F).texOffs(60, 15).addBox(2.0F, -10.0F, 10.0F, 0.0F, 6.0F, 12.0F).texOffs(78, 69).addBox(-1.0F, -10.0F, 0.0F, 0.0F, 6.0F, 10.0F).texOffs(62, 33).addBox(0.0F, -10.0F, 10.0F, 0.0F, 6.0F, 12.0F), PartPose.offset(-1.0F, 8.0F, 9.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -20.0F, -6.0F, 10.0F, 13.0F, 15.0F).texOffs(32, 50).addBox(-4.0F, -16.0F, -13.0F, 8.0F, 9.0F, 7.0F).texOffs(0, 28).addBox(3.0F, -27.0F, -6.0F, 0.0F, 7.0F, 15.0F).texOffs(22, 80).addBox(2.0F, -23.0F, -13.0F, 0.0F, 7.0F, 7.0F).texOffs(30, 28).addBox(-3.0F, -27.0F, -6.0F, 0.0F, 7.0F, 15.0F).texOffs(36, 80).addBox(-2.0F, -23.0F, -13.0F, 0.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    public static LayerDefinition createLegacyStegosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("front_body", CubeListBuilder.create().texOffs(46, 14).addBox(-2.0F, 2.0F, -4.0F, 5.0F, 5.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 0).addBox(-3.0F, 0.0F, 0.0F, 7.0F, 8.0F, 8.0F).mirror(), PartPose.offset(0.0F, 14.0F, -6.0F));
        partDefinition.addOrReplaceChild("back_plates_1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, 8.0F, 1.0F, 5.0F, 3.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("back_body", CubeListBuilder.create().texOffs(32, 24).addBox(-0.5F, 3.5F, -8.0F, 2.0F, 3.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("back_plates_2", CubeListBuilder.create().texOffs(12, 13).addBox(-0.5F, -3.5F, 2.0F, 2.0F, 5.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(46, 23).addBox(-2.0F, 1.5F, 2.0F, 5.0F, 5.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("back_plates_3", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, -3.0F, -3.0F, 2.0F, 5.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.2617994F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(32, 16).addBox(-1.0F, 2.0F, 4.5F, 3.0F, 3.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(52, 6).addBox(-0.5F, 2.5F, 7.5F, 2.0F, 2.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("thagomizer", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -5.0F, 0.0F, 2.0F, 5.0F, 8.0F).mirror(), PartPose.offset(0.0F, 14.0F, -6.0F));
        partDefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 3.0F, 3.0F).mirror(), PartPose.offset(4.0F, 20.0F, -6.0F));
        partDefinition.addOrReplaceChild("right_front_foot", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(4.0F, 20.0F, -6.0F, 0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(54, 0).addBox(-2.0F, -1.5F, -2.0F, 2.0F, 3.0F, 3.0F).mirror(), PartPose.offset(-2.0F, 20.0F, -6.0F));
        partDefinition.addOrReplaceChild("left_front_foot", CubeListBuilder.create().texOffs(20, 0).addBox(-1.5F, 0.0F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(-2.0F, 20.0F, -6.0F, 0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(14, 22).addBox(-1.0F, -2.5F, -2.0F, 2.0F, 5.0F, 5.0F).mirror(), PartPose.offset(4.0F, 19.0F, 1.0F));
        partDefinition.addOrReplaceChild("right_back_foot", CubeListBuilder.create().texOffs(24, 16).addBox(-0.5F, 2.5F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(4.0F, 19.0F, 1.0F, 1.22173F, 0F, 0F));
        partDefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -2.5F, -2.0F, 2.0F, 5.0F, 5.0F).mirror(), PartPose.offset(-2.0F, 19.0F, 1.0F));
        partDefinition.addOrReplaceChild("left_back_foot", CubeListBuilder.create().texOffs(24, 21).addBox(-1.5F, 2.5F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(-2.0F, 19.0F, 1.0F, 1.22173F, 0F, 0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
