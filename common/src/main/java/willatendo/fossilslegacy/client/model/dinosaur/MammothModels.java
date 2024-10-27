package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class MammothModels {
    public static LayerDefinition createMammothBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(12, 48).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(2.5F, 17.0F, -2.5F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 48).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F), PartPose.offset(-2.5F, 17.0F, -2.5F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(52, 15).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(2.0F, 18.0F, 9.5F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(24, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-2.0F, 18.0F, 9.5F));
        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(38, 0).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 8.0F, 7.0F).texOffs(38, 25).addBox(3.0F, -5.0F, -1.0F, 5.0F, 7.0F, 0.0F).texOffs(48, 25).addBox(-8.0F, -5.0F, -1.0F, 5.0F, 7.0F, 0.0F).texOffs(48, 54).addBox(2.0F, 1.0F, -5.0F, 2.0F, 7.0F, 2.0F).texOffs(24, 48).addBox(2.0F, 6.0F, -7.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 58).addBox(2.0F, 4.0F, -9.0F, 2.0F, 4.0F, 2.0F).texOffs(56, 54).addBox(-4.0F, 1.0F, -5.0F, 2.0F, 7.0F, 2.0F).texOffs(16, 58).addBox(-4.0F, 6.0F, -7.0F, 2.0F, 2.0F, 2.0F).texOffs(8, 58).addBox(-4.0F, 4.0F, -9.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 10.0F, -5.0F));
        head.addOrReplaceChild("tuff_1", CubeListBuilder.create().texOffs(32, 43).addBox(0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -6.5F, -2.5F, 0.0F, 0.7854F, 0.0F));
        head.addOrReplaceChild("tuff_2", CubeListBuilder.create().texOffs(38, 15).addBox(0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -6.5F, -2.5F, 0.0F, -0.7854F, 0.0F));
        PartDefinition trunk = head.addOrReplaceChild("trunk", CubeListBuilder.create().texOffs(36, 54).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -0.5F, -6.0F));
        trunk.addOrReplaceChild("trunk_end", CubeListBuilder.create().texOffs(46, 43).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 4.5F, -1.5F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -14.0F, 4.0F, 8.0F, 8.0F, 8.0F).texOffs(0, 0).addBox(-5.0F, -17.0F, -5.0F, 10.0F, 10.0F, 9.0F).texOffs(0, 19).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 4.0F, 9.0F).texOffs(32, 32).addBox(-4.0F, -6.0F, 4.0F, 8.0F, 3.0F, 8.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createLegacyMammothBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 11).addBox(-2.0F, -3.0F, -3.5F, 4.0F, 5.0F, 5.0F).mirror(), PartPose.offset(0.0F, 15.5F, -1.5F));
        partDefinition.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(42, 21).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 5.0F, 6.0F).mirror(), PartPose.offset(0.0F, 15.5F, -1.5F));
        partDefinition.addOrReplaceChild("hair_tuff_1", CubeListBuilder.create().texOffs(8, 24).addBox(0.0F, -7.0F, -2.5F, 0.0F, 3.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.7853982F, 0.0F));
        partDefinition.addOrReplaceChild("hair_tuff_2", CubeListBuilder.create().texOffs(8, 24).addBox(0.0F, -7.0F, -2.5F, 0.0F, 3.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, -0.7853982F, 0.0F));
        partDefinition.addOrReplaceChild("front_hair", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.5F, 0.5F, 7.0F, 9.0F, 7.0F).mirror(), PartPose.offset(0.0F, 16.0F, -4.0F));
        partDefinition.addOrReplaceChild("back_hair", CubeListBuilder.create().texOffs(30, 8).addBox(-3.0F, 4.0F, 3.0F, 6.0F, 2.0F, 3.0F).mirror(), PartPose.offset(0.0F, 16.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_tooth", CubeListBuilder.create().texOffs(30, 5).addBox(0.0F, 1.0F, -9.5F, 0.0F, 7.0F, 8.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.0F, 0.5235988F));
        partDefinition.addOrReplaceChild("left_tooth", CubeListBuilder.create().texOffs(30, 5).addBox(0.0F, 1.0F, -9.5F, 0.0F, 7.0F, 8.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.0F, -0.5235988F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 20).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.offset(0.0F, 16F, 0.0F));
        partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(30, 0).addBox(-3.0F, 0.0F, 3.0F, 6.0F, 4.0F, 3.0F).mirror(), PartPose.offset(0.0F, 16.0F, 0.0F));
        partDefinition.addOrReplaceChild("nose_top", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 1.0F, -3.5F, 2.0F, 4.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, -0.1897142F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("nose_bottom", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 5.0F, -1.5F, 2.0F, 3.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, -0.5986789F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(1.5F, 17.0F, -1.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 17.0F, -1.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 17.0F, 4.5F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(1.5F, 17.0F, 4.5F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
