package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class PachycephalosaurusModels {
    public static LayerDefinition createPachycephalosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(21, 9).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.0F, 7.0F).texOffs(0, 16).addBox(-1.0F, -2.0F, 7.0F, 2.0F, 3.0F, 11.0F), PartPose.offset(0.0F, 12.0F, 4.0F));
        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(21, 25).addBox(-2.0F, -5.0F, -7.0F, 4.0F, 6.0F, 5.0F).texOffs(14, 36).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 8.0F, 2.0F).texOffs(0, 23).addBox(-1.5F, -2.0F, -8.0F, 3.0F, 3.0F, 1.0F).texOffs(0, 30).addBox(-2.0F, -6.0F, -5.0F, 4.0F, 1.0F, 5.0F).texOffs(20, 0).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 1.0F, 5.0F), PartPose.offset(0.0F, 12.0F, -7.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(36, 6).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F).texOffs(0, 0).addBox(-1.0F, 3.0F, 1.0F, 2.0F, 4.0F, 2.0F).texOffs(34, 21).addBox(-1.0F, 7.0F, -1.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(3.0F, 15.0F, 1.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(42, 0).addBox(-2.0F, 7.0F, -1.0F, 3.0F, 2.0F, 4.0F).texOffs(35, 32).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F).texOffs(15, 19).addBox(-1.0F, 3.0F, 1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-3.0F, 15.0F, 1.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(39, 27).addBox(0.0F, 3.0F, -1.0F, 2.0F, 3.0F, 2.0F).texOffs(26, 39).addBox(0.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F), PartPose.offset(2.0F, 15.0F, -5.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(13, 30).addBox(-2.0F, 3.0F, -1.0F, 2.0F, 3.0F, 2.0F).texOffs(0, 16).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 4.0F, 3.0F), PartPose.offset(-2.0F, 15.0F, -5.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -14.0F, -4.0F, 6.0F, 8.0F, 8.0F).texOffs(0, 36).addBox(-2.0F, -14.0F, -7.0F, 4.0F, 7.0F, 3.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}