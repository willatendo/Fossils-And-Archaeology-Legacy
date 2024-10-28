package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class MosasaurusModels {
    public static LayerDefinition createMosasaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 35).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 7.0F).texOffs(38, 0).addBox(-2.0F, 2.0F, 5.0F, 4.0F, 5.0F, 9.0F).texOffs(0, 51).addBox(-2.0F, -6.0F, 5.0F, 4.0F, 8.0F, 5.0F), PartPose.offset(0.0F, 16.0F, 9.0F));
        partDefinition.addOrReplaceChild("left_front_flipper", CubeListBuilder.create().texOffs(52, 49).addBox(0.0F, -2.0F, -1.0F, 2.0F, 5.0F, 7.0F), PartPose.offset(5.0F, 21.0F, -7.0F));
        partDefinition.addOrReplaceChild("right_front_flipper", CubeListBuilder.create().texOffs(18, 58).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 5.0F, 7.0F), PartPose.offset(-5.0F, 21.0F, -7.0F));
        partDefinition.addOrReplaceChild("left_back_flipper", CubeListBuilder.create().texOffs(62, 35).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 6.0F), PartPose.offset(5.0F, 21.0F, 5.0F));
        partDefinition.addOrReplaceChild("right_back_flipper", CubeListBuilder.create().texOffs(0, 64).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 6.0F), PartPose.offset(-5.0F, 21.0F, 5.0F));
        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 20).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 7.0F).texOffs(0, 40).addBox(-3.0F, -3.0F, -14.0F, 6.0F, 4.0F, 7.0F).texOffs(56, 61).addBox(-2.0F, 1.0F, -13.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 18.0F, -10.0F));
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(26, 49).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 2.0F, 7.0F).texOffs(36, 61).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 2.0F, -7.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -11.0F, -10.0F, 10.0F, 11.0F, 9.0F).texOffs(0, 20).addBox(-4.0F, -11.0F, -1.0F, 8.0F, 10.0F, 10.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    public static LayerDefinition createLegacyMosasaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(17, 22).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 1.0F, 5.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_teeth", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 2.F, 6.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 8.0F), PartPose.offset(1.0F, 16.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_front_flipper", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-3.0F, 20.0F, 0.0F, -0.34907F, -1.0472F, -0.43633F));
        partDefinition.addOrReplaceChild("left_front_flipper", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(5.0F, 20.0F, 0.0F, -0.34907F, 1.0472F, 0.43633F));
        partDefinition.addOrReplaceChild("right_back_flipper", CubeListBuilder.create().texOffs(20, 1).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, 20.0F, 7.0F, -0.34907F, -0.87266F, -0.43633F));
        partDefinition.addOrReplaceChild("left_back_flipper", CubeListBuilder.create().texOffs(20, 1).addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 20.0F, 7.0F, -0.34907F, 0.87266F, 0.43633F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(35, 14).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 11.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(36, 24).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 16.0F));
        partDefinition.addOrReplaceChild("tail_2_spike", CubeListBuilder.create().texOffs(26, 22).addBox(0.0F, -3.0F, -4.0F, 1.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 16.0F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(16, 8).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 21.0F));
        partDefinition.addOrReplaceChild("tail_3_spike", CubeListBuilder.create().texOffs(26, 23).addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 5.0F), PartPose.offset(1.0F, 19.0F, 20.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
