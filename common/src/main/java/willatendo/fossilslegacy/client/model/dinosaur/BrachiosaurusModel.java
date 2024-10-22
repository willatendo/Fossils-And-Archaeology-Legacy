package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class BrachiosaurusModel {
    public static LayerDefinition createBodyLayer() {
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
}