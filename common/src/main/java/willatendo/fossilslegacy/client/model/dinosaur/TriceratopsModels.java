package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class TriceratopsModels {
    public static LayerDefinition createTriceratopsBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 62).addBox(-1.0F, 4.0F, -2.0F, 3.0F, 6.0F, 4.0F).texOffs(50, 49).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 6.0F), PartPose.offset(-5.0F, 14.0F, 4.0F));
        partdefinition.addOrReplaceChild("legt_leg", CubeListBuilder.create().texOffs(50, 62).mirror().addBox(-2.0F, 4.0F, -2.0F, 3.0F, 6.0F, 4.0F).mirror(false).texOffs(50, 49).mirror().addBox(-1.0F, -3.0F, -3.0F, 3.0F, 7.0F, 6.0F).mirror(false), PartPose.offset(5.0F, 14.0F, 4.0F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 50).addBox(-2.5F, -4.0F, 0.0F, 5.0F, 9.0F, 5.0F).texOffs(0, 36).addBox(-2.0F, 0.0F, 5.0F, 4.0F, 5.0F, 9.0F).texOffs(38, 0).addBox(-2.0F, -5.0F, 6.0F, 4.0F, 5.0F, 9.0F), PartPose.offset(0.0F, 14.0F, 7.0F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 35).addBox(-3.5F, -3.6667F, -6.2111F, 7.0F, 7.0F, 7.0F).texOffs(0, 22).addBox(-6.5F, -9.6667F, -1.2111F, 13.0F, 12.0F, 2.0F).texOffs(30, 22).addBox(-7.5F, -10.6667F, -1.3111F, 15.0F, 13.0F, 0.0F).texOffs(38, 14).addBox(-1.5F, -0.6667F, -9.2111F, 3.0F, 4.0F, 3.0F).texOffs(26, 36).addBox(0.0F, -2.6667F, -9.2111F, 0.0F, 2.0F, 2.0F).texOffs(60, 28).addBox(-3.5F, -6.6667F, -6.2111F, 1.0F, 2.0F, 5.0F).texOffs(20, 63).addBox(-3.5F, -6.6667F, -11.2111F, 1.0F, 2.0F, 5.0F).texOffs(60, 28).mirror().addBox(2.5F, -6.6667F, -6.2111F, 1.0F, 2.0F, 5.0F).mirror(false).texOffs(20, 63).mirror().addBox(2.5F, -6.6667F, -11.2111F, 1.0F, 2.0F, 5.0F).mirror(false), PartPose.offset(0.0F, 14.6667F, -8.7889F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(58, 35).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 11.0F, 3.0F), PartPose.offset(-4.5F, 16.0F, -5.5F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(60, 14).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 11.0F, 3.0F), PartPose.offset(4.5F, 16.0F, -5.5F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -16.0F, -4.0F, 8.0F, 11.0F, 11.0F).texOffs(26, 49).addBox(-4.0F, -15.0F, -8.0F, 8.0F, 10.0F, 4.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public static LayerDefinition createLegacyTriceratopsBodyLayer() {
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