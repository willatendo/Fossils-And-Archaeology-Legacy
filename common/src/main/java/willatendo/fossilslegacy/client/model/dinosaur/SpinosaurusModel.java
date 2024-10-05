package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class SpinosaurusModel {
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(74, 34).addBox(-1.0F, 2.0F, 0.0F, 1.0F, 6.0F, 2.0F).texOffs(56, 69).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 3.0F), PartPose.offset(3.0F, 13.0F, -8.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(66, 69).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 3.0F).texOffs(74, 42).addBox(0.0F, 2.0F, 0.0F, 1.0F, 6.0F, 2.0F), PartPose.offset(-3.0F, 13.0F, -8.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(62, 15).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 7.0F, 5.0F).texOffs(38, 72).addBox(-1.0F, 2.0F, 1.0F, 2.0F, 6.0F, 2.0F).texOffs(22, 65).addBox(-1.0F, 8.0F, -1.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(3.0F, 14.0F, 3.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 69).addBox(-2.0F, 8.0F, -1.0F, 3.0F, 2.0F, 4.0F).texOffs(46, 72).addBox(-1.0F, 2.0F, 1.0F, 2.0F, 6.0F, 2.0F).texOffs(62, 50).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 7.0F, 5.0F), PartPose.offset(-3.0F, 14.0F, 3.0F));
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(60, 0).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 11.0F, 4.0F), PartPose.offset(0.0F, 12.0F, -11.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(42, 64).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 3.0F).texOffs(0, 59).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 3.0F, 7.0F).texOffs(22, 46).addBox(-0.5F, -3.0F, -5.0F, 1.0F, 1.0F, 4.0F).texOffs(62, 62).addBox(-1.0F, 1.0F, -9.0F, 2.0F, 1.0F, 6.0F), PartPose.offset(0.0F, -5.0F, -4.0F));
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(62, 27).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 1.0F, 6.0F).texOffs(36, 12).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 2.0F, -3.0F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F).texOffs(32, 21).addBox(-1.0F, -2.0F, 8.0F, 2.0F, 3.0F, 13.0F).texOffs(22, 51).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 5.0F, 9.0F).texOffs(42, 51).addBox(-0.5F, 1.0F, 0.0F, 1.0F, 4.0F, 9.0F).texOffs(0, 46).addBox(-0.5F, 1.0F, 9.0F, 1.0F, 3.0F, 10.0F).texOffs(32, 37).addBox(-0.5F, -6.0F, 9.0F, 1.0F, 4.0F, 10.0F), PartPose.offset(0.0F, 12.0F, 7.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -16.0F, -5.0F, 6.0F, 9.0F, 12.0F).texOffs(56, 64).addBox(-0.5F, -18.0F, 5.0F, 1.0F, 2.0F, 2.0F).texOffs(0, 21).addBox(-0.5F, -25.0F, -10.0F, 1.0F, 10.0F, 15.0F).texOffs(14, 71).addBox(-0.5F, -27.0F, -1.0F, 1.0F, 2.0F, 5.0F).texOffs(26, 71).addBox(-0.5F, -26.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(54, 37).addBox(-2.0F, -15.0F, -11.0F, 4.0F, 7.0F, 6.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
}
