package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class DodoModels {
    public static LayerDefinition createDodoBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -12.0F, 8.0F, 8.0F, 8.0F).texOffs(24, 0).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 5.0F, 3.0F), PartPose.offset(0.0F, 17.0F, 8.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(2, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F).texOffs(22, 16).addBox(-1.0F, 3.0F, -3.0F, 3.0F, 0.0F, 3.0F), PartPose.offset(1.0F, 21.0F, 1.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(9, 16).addBox(-2.0F, 3.0F, -3.0F, 3.0F, 0.0F, 3.0F).texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F), PartPose.offset(-1.0F, 21.0F, 1.0F));
        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(16, 16).addBox(-1.0F, -5.0F, -7.0F, 2.0F, 3.0F, 5.0F), PartPose.offset(0.0F, 15.0F, -4.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(22, 24).addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 4.0F), PartPose.offset(4.0F, 15.0F, -2.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(12, 24).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 4.0F), PartPose.offset(-4.0F, 15.0F, -2.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}