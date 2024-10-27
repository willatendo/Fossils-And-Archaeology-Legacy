package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class SmilodonModels {
    public static LayerDefinition createSmilodonBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 15).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(2.5F, 18.0F, -2.5F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(34, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-2.5F, 18.0F, -2.5F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(40, 24).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(2.5F, 18.0F, 8.5F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(40, 33).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-2.5F, 18.0F, 8.5F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(24, 41).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F), PartPose.offset(0.0F, 14.0F, 11.0F));
        PartDefinition neck = partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(24, 30).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(1.0F, 13.0F, -5.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 30).addBox(-5.0F, -3.0F, -5.0F, 6.0F, 6.0F, 6.0F).texOffs(34, 9).addBox(-4.0F, -1.0F, -8.0F, 4.0F, 3.0F, 3.0F).texOffs(0, 42).addBox(-3.0F, 2.0F, -8.0F, 2.0F, 1.0F, 3.0F).texOffs(16, 42).addBox(-5.0F, -4.0F, -2.0F, 1.0F, 1.0F, 2.0F).texOffs(32, 24).addBox(-1.0F, 2.0F, -8.0F, 1.0F, 2.0F, 2.0F).texOffs(32, 41).addBox(-4.0F, 2.0F, -8.0F, 1.0F, 2.0F, 2.0F).texOffs(38, 42).addBox(-4.0F, 4.0F, -8.0F, 1.0F, 1.0F, 2.0F).texOffs(44, 15).addBox(-1.0F, 4.0F, -8.0F, 1.0F, 1.0F, 2.0F).texOffs(10, 42).addBox(0.0F, -4.0F, -2.0F, 1.0F, 1.0F, 2.0F), PartPose.offset(1.0F, -2.0F, -2.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -14.0F, -5.0F, 10.0F, 8.0F, 7.0F).texOffs(0, 15).addBox(-4.0F, -13.0F, 2.0F, 8.0F, 7.0F, 8.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createLegacySmilodonBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.5F, -4.0F, 5.0F, 4.0F, 4.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(6, 8).addBox(-2.5F, -2.5F, -3.0F, 1.0F, 1.0F, 2.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(6, 8).addBox(1.5F, -2.5F, -3.0F, 1.0F, 1.0F, 2.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(18, 5).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 3.0F), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(48, 7).addBox(-1.0F, 0.0F, -3.5F, 2.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 16.5F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_tooth_top", CubeListBuilder.create().texOffs(44, 14).addBox(-1.5F, 2.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("right_tooth_bottom", CubeListBuilder.create().texOffs(44, 17).addBox(-1.5F, 4.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("left_tooth_top", CubeListBuilder.create().texOffs(44, 14).addBox(0.5F, 2.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("left_tooth_bottom", CubeListBuilder.create().texOffs(44, 17).addBox(0.5F, 4.0F, -6.0F, 1.0F, 2.0F, 1.0F).mirror(), PartPose.offset(0.0F, 15.0F, -3.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 6.0F, 4.0F).mirror(), PartPose.offset(0.0F, 15.0F, 0.0F));
        partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 21).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F).mirror(), PartPose.offset(0.0F, 16.0F, 1.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(44, 7).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 6.0F, 1.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, 6.5F, 0.5576792F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 19.0F, -2.0F));
        partDefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 19.0F, 6.0F));
        partDefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(1.5F, 19.0F, -2.0F));
        partDefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F).mirror(), PartPose.offset(1.5F, 19.0F, 6.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
