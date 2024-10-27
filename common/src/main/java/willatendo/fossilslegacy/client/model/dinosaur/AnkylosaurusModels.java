package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class AnkylosaurusModels {
    public static LayerDefinition createAnkylosaurusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 7.0F, 8.0F).texOffs(22, 41).addBox(2.0F, 1.0F, -2.0F, 3.0F, 3.0F, 2.0F).texOffs(58, 34).addBox(-5.0F, 1.0F, -2.0F, 3.0F, 3.0F, 2.0F).texOffs(58, 20).addBox(2.0F, -6.0F, -3.0F, 3.0F, 4.0F, 3.0F).texOffs(58, 27).addBox(-5.0F, -6.0F, -3.0F, 3.0F, 4.0F, 3.0F).texOffs(54, 39).addBox(-2.0F, -1.0F, -10.0F, 4.0F, 5.0F, 3.0F), PartPose.offset(0.0F, 16.0F, -9.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 41).addBox(-3.0F, -1.0F, 13.0F, 6.0F, 4.0F, 5.0F).texOffs(32, 39).addBox(-2.0F, -2.0F, 7.0F, 4.0F, 4.0F, 7.0F).texOffs(32, 26).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 7.0F), PartPose.offset(0.0F, 15.0F, 7.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(52, 50).addBox(-2.0F, 2.0F, -2.0F, 3.0F, 5.0F, 4.0F).texOffs(0, 50).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 5.0F, 5.0F), PartPose.offset(6.0F, 17.0F, 4.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(52, 11).addBox(-1.0F, 2.0F, -2.0F, 3.0F, 5.0F, 4.0F).texOffs(18, 50).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 5.0F, 5.0F), PartPose.offset(-6.0F, 17.0F, 4.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(36, 50).addBox(8.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(-5.0F, 19.0F, -5.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(52, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F), PartPose.offset(-5.0F, 19.0F, -5.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -13.0F, -9.0F, 10.0F, 10.0F, 16.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
