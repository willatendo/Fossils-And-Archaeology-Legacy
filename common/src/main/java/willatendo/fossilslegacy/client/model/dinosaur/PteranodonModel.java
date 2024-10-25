package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class PteranodonModel {
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 18.0F, -4.0F, 0.7854F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 41).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(1.5F, 20.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(8, 41).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-1.5F, 20.0F, 0.0F));
        PartDefinition neck = partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(40, 36).addBox(-1.0F, -7.0F, -2.0F, 2.0F, 8.0F, 4.0F), PartPose.offset(0.0F, 15.0F, -5.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 5.0F).texOffs(0, 14).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 1.0F, 9.0F).texOffs(22, 0).addBox(-1.0F, 0.0F, -13.0F, 2.0F, 1.0F, 9.0F).texOffs(18, 26).addBox(-1.0F, -4.0F, -4.0F, 2.0F, 2.0F, 7.0F), PartPose.offset(0.0F, -6.0F, -1.0F));
        PartDefinition right_wing = partDefinition.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(22, 10).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(0, 35).addBox(-10.0F, 1.0F, 0.0F, 10.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(-3.0F, 15.0F, -4.0F, 1.5708F, 0.0F, -1.0472F));
        right_wing.addOrReplaceChild("right_wing_tip", CubeListBuilder.create().texOffs(22, 18).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(36, 26).addBox(-10.0F, 1.0F, 0.0F, 10.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(-10.0F, 1.0F, 0.0F, 0.0F, 2.0944F, 0.0F));
        PartDefinition left_wing = partDefinition.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(22, 14).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(20, 35).addBox(0.0F, 1.0F, 0.0F, 10.0F, 6.0F, 0.0F), PartPose.offsetAndRotation(3.0F, 15.0F, -4.0F, 1.5708F, 0.0F, 1.0472F));
        left_wing.addOrReplaceChild("left_wing_tip", CubeListBuilder.create().texOffs(22, 22).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F).texOffs(40, 31).addBox(0.0F, 1.0F, 0.0F, 10.0F, 5.0F, 0.0F), PartPose.offsetAndRotation(10.0F, 1.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
