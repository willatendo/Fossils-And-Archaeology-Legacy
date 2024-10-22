package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class CryolophosaurusModel {
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(46, 13).addBox(-1.0F, 8.0F, -3.0F, 3.0F, 2.0F, 5.0F).texOffs(24, 49).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F).texOffs(34, 33).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 6.0F, 5.0F), PartPose.offset(3.0F, 14.0F, 3.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(34, 44).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 6.0F, 5.0F).texOffs(50, 28).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F).texOffs(0, 45).addBox(-2.0F, 8.0F, -3.0F, 3.0F, 2.0F, 5.0F), PartPose.offset(-3.0F, 14.0F, 3.0F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 7.0F).texOffs(0, 18).addBox(-1.0F, -3.0F, 7.0F, 2.0F, 4.0F, 10.0F), PartPose.offset(0.0F, 10.0F, 6.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(46, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(2.0F, 14.0F, -7.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 49).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F), PartPose.offset(-2.0F, 14.0F, -7.0F));
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(22, 33).addBox(-1.0F, -9.0F, -2.0F, 2.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 10.0F, -9.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 0).addBox(-2.0F, -4.0F, -7.0F, 4.0F, 5.0F, 8.0F).texOffs(30, 13).addBox(-2.0F, -9.0F, -1.0F, 4.0F, 4.0F, 0.0F).texOffs(50, 35).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 1.0F, 1.0F), PartPose.offset(0.0F, -6.0F, -1.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -17.0F, -3.0F, 6.0F, 9.0F, 9.0F).texOffs(24, 18).addBox(-2.0F, -17.0F, -10.0F, 4.0F, 8.0F, 7.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
