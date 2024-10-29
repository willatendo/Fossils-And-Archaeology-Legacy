package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class DilophosaurusModels {
    public static LayerDefinition createLegacyDilophosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 20).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.offset(0.0F, 4.0F, -10.0F));
        partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, -12.0F, 4.0F, 4.0F, 6.0F).mirror(), PartPose.offset(0.0F, 4.0F, -10.0F));
        partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(1, 10).addBox(-1.5F, 4.0F, -11.0F, 3.0F, 1.0F, 7.0F).mirror(), PartPose.offset(0.0F, 4.0F, -10.0F));
        partDefinition.addOrReplaceChild("crest_right", CubeListBuilder.create().texOffs(18, 11).addBox(-2.0F, -4.0F, -10.0F, 0.0F, 4.0F, 10.0F).mirror(), PartPose.offset(0.0F, 4.0F, -10.0F));
        partDefinition.addOrReplaceChild("crest_left", CubeListBuilder.create().texOffs(18, 11).addBox(2.0F, -4.0F, -10.0F, 0.0F, 4.0F, 10.0F).mirror(), PartPose.offset(0.0F, 4.0F, -10.0F));
        partDefinition.addOrReplaceChild("spike_right", CubeListBuilder.create().texOffs(16, -5).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 5.0F).mirror(), PartPose.offsetAndRotation(-3.0F, 4.0F, -10.0F, 0.0F, -0.5235988F, 0.0F));
        partDefinition.addOrReplaceChild("spike_left", CubeListBuilder.create().texOffs(16, -5).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 5.0F).mirror(), PartPose.offsetAndRotation(3.0F, 4.0F, -10.0F, 0.0F, 0.5235988F, 0.0F));
        partDefinition.addOrReplaceChild("hood_right", CubeListBuilder.create().texOffs(24, 27).addBox(-1.0F, 3.0F, 0.0F, 9.0F, 5.0F, 0.0F).mirror(), PartPose.offsetAndRotation(0.0F, 4.0F, -10.0F, 0.0F, 3.141593F, -1.570796F));
        partDefinition.addOrReplaceChild("hood_left", CubeListBuilder.create().texOffs(24, 27).addBox(-1.0F, 3.0F, 0.0F, 9.0F, 5.0F, 0.0F).mirror(), PartPose.offsetAndRotation(0.0F, 4.0F, -10.0F, 0.0F, 0.0F, 1.570796F));
        partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(42, 21).addBox(-2.0F, -1.5F, -7.0F, 4.0F, 4.0F, 7.0F).mirror(), PartPose.offsetAndRotation(0.0F, 10.0F, -6.0F, -0.7063936F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(40, 0).addBox(-3.0F, -3.0F, -6.5F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.offsetAndRotation(0.0F, 11.5F, -1.0F, -0.2602438F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(32, 5).addBox(-4.0F, -0.5F, -4.5F, 8.0F, 8.0F, 8.0F).mirror(), PartPose.offset(0.0F, 9.0F, 2.0F));
        partDefinition.addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(44, 0).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 4.0F, 6.0F).mirror(), PartPose.offset(0.0F, 9.0F, 5.5F));
        partDefinition.addOrReplaceChild("tail_end", CubeListBuilder.create().texOffs(36, 0).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 2.0F, 12.0F).mirror(), PartPose.offset(0.0F, 10.0F, 11.5F));
        partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(24, 2).addBox(0.0F, -1.5F, -2.5F, 3.0F, 5.0F, 5.0F).mirror(), PartPose.offset(4.0F, 13.0F, 3.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(24, 12).addBox(0.0F, 2.0F, 2.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offsetAndRotation(4.0F, 13.0F, 3.0F, -0.3717861F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(35, 21).addBox(0.0F, 9.0F, -3.0F, 3.0F, 2.0F, 4.0F).mirror(), PartPose.offset(4.0F, 13.0F, 3.0F));
        partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(24, 2).addBox(-3.0F, -1.5F, -2.5F, 3.0F, 5.0F, 5.0F).mirror(), PartPose.offset(-4.0F, 13.0F, 3.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(24, 12).addBox(-2.0F, 2.0F, 2.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offsetAndRotation(-4.0F, 13.0F, 3.0F, -0.3717861F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(35, 21).addBox(-3.0F, 9.0F, -3.0F, 3.0F, 2.0F, 4.0F).mirror(), PartPose.offset(-4.0F, 13.0F, 3.0F));
        partDefinition.addOrReplaceChild("right_biceps", CubeListBuilder.create().texOffs(14, 10).addBox(0.0F, -1.0F, -2.0F, 2.0F, 3.0F, 3.0F).mirror(), PartPose.offset(3.0F, 11.0F, -5.5F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F).mirror(), PartPose.offsetAndRotation(4.0F, 11.5F, -5.5F, -0.2602503F, 0F, 0F));
        partDefinition.addOrReplaceChild("left_biceps", CubeListBuilder.create().texOffs(14, 10).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 3.0F, 3.0F).mirror(), PartPose.offset(-3.0F, 11.0F, -5.5F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F).mirror(), PartPose.offsetAndRotation(-4.0F, 11.5F, -5.5F, -0.2602503F, 0F, 0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}