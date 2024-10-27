package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class VelociraptorModels {
    public static LayerDefinition createVelociraptorBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 6).addBox(-1.375F, 8.625F, -1.75F, 2.0F, 0.0F, 3.0F).texOffs(31, 4).addBox(-0.375F, 3.625F, 0.25F, 1.0F, 5.0F, 1.0F).texOffs(9, 26).addBox(-1.375F, -0.375F, -1.75F, 2.0F, 4.0F, 3.0F).texOffs(0, 8).addBox(0.625F, 6.625F, -1.75F, 0.0F, 2.0F, 3.0F), PartPose.offset(-2.625F, 15.375F, -2.25F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(19, 26).addBox(-0.625F, -0.375F, -1.75F, 2.0F, 4.0F, 3.0F).texOffs(0, 10).addBox(-0.625F, 6.625F, -1.75F, 0.0F, 2.0F, 3.0F).texOffs(0, 3).addBox(-0.625F, 8.625F, -1.75F, 2.0F, 0.0F, 3.0F).texOffs(29, 27).addBox(-0.625F, 3.625F, 0.25F, 1.0F, 5.0F, 1.0F), PartPose.offset(2.625F, 15.375F, -2.25F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 29).addBox(-0.5F, 0.0F, -1.25F, 1.0F, 2.0F, 2.0F).texOffs(13, 6).addBox(-0.5F, 2.0F, -0.25F, 1.0F, 2.0F, 1.0F), PartPose.offset(2.0F, 16.0F, -6.75F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 26).addBox(-0.5F, 2.0F, -0.25F, 1.0F, 2.0F, 1.0F).texOffs(27, 0).addBox(-0.5F, 0.0F, -1.25F, 1.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 16.0F, -6.75F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(19, 9).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F).texOffs(17, 19).addBox(-1.5F, -5.0F, -4.5F, 3.0F, 4.0F, 3.0F).texOffs(26, 17).addBox(-1.0F, -4.0F, -7.5F, 2.0F, 2.0F, 3.0F).texOffs(26, 23).addBox(-1.0F, -2.0F, -7.5F, 2.0F, 1.0F, 3.0F).texOffs(0, 0).addBox(-1.5F, -5.0F, 1.5F, 3.0F, 0.0F, 3.0F).texOffs(12, 20).addBox(1.5F, -5.0F, 1.5F, 0.0F, 4.0F, 2.0F).texOffs(14, 9).addBox(-1.5F, -5.0F, 1.5F, 0.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 14.0F, -7.5F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(17, 2).addBox(-1.5F, 0.1667F, 0.1667F, 3.0F, 3.0F, 4.0F).texOffs(0, 0).addBox(-1.0F, 0.1667F, 4.1667F, 2.0F, 2.0F, 9.0F).texOffs(7, 0).addBox(-2.0F, 0.1667F, 10.1667F, 4.0F, 0.0F, 6.0F), PartPose.offset(0.0F, 13.8333F, -0.1667F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -10.0F, -6.0F, 4.0F, 5.0F, 6.0F).texOffs(0, 22).addBox(-1.5F, -10.0F, -9.0F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition createLegacyVelociraptorBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(-3.0F, -7.0F, -8.0F, 6.0F, 7.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 5.0F, -3.0F, 0.08726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(44, 22).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 5.0F, -11.0F, 0.08726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(23, 0).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 5.0F, -10.0F));
        partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(3, 1).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 10.0F, -5.0F, -2.094395F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_body", CubeListBuilder.create().texOffs(3, 2).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -4.0F, -0.5235988F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -6.0F, 8.0F, 6.0F, 7.0F), PartPose.offset(-1.0F, 13.0F, 3.0F));
        partDefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(3, 1).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, -0.5235988F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(20, 11).addBox(-1.0F, 0.0F, 6.0F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 10.0F, 4.0F, -0.6981317F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(48, 12).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 5.0F, 5.0F), PartPose.offset(-4.0F, 14.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(14, 8).addBox(-2.0F, 4.0F, -7.0F, 2.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, 0.994461F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(30, 26).addBox(-3.0F, 8.0F, -3.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(-4.0F, 14.0F, 1.0F));
        partDefinition.addOrReplaceChild("right_hook_1", CubeListBuilder.create().texOffs(32, 7).addBox(-1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, -0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_hook_2", CubeListBuilder.create().texOffs(32, 7).addBox(-1.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-4.0F, 14.0F, 0.0F, -2.6529F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_bicep", CubeListBuilder.create().texOffs(43, 11).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(-3.0F, 12.0F, -6.0F));
        partDefinition.addOrReplaceChild("right_hand", CubeListBuilder.create().texOffs(20, 18).addBox(-2.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-3.0F, 12.0F, -6.0F, 0.994461F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(48, 1).addBox(0.0F, -1.0F, -2.0F, 3.0F, 5.0F, 5.0F), PartPose.offset(4.0F, 14.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(14, 8).addBox(0.0F, 4.0F, -7.0F, 2.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, 0.994461F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(30, 26).addBox(0.0F, 8.0F, -3.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 14.0F, 1.0F));
        partDefinition.addOrReplaceChild("left_hook_1", CubeListBuilder.create().texOffs(32, 7).addBox(0.0F, 5.0F, 3.0F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, -0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_hook_2", CubeListBuilder.create().texOffs(32, 7).addBox(0.0F, -5.0F, 5.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(4.0F, 14.0F, 0.0F, -2.6529F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_bicep", CubeListBuilder.create().texOffs(43, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(3.0F, 12.0F, -6.0F));
        partDefinition.addOrReplaceChild("left_hand", CubeListBuilder.create().texOffs(20, 18).addBox(0.0F, 2.0F, -4.0F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(3.0F, 12.0F, -6.0F, 0.994461F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}