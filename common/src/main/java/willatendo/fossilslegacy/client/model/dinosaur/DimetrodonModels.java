package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class DimetrodonModels {
    public static LayerDefinition createDimetrodonBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("leg", CubeListBuilder.create().texOffs(32, 21).addBox(1.0F, -2.0F, 0.0F, 4.0F, 5.0F, 8.0F).texOffs(44, 0).addBox(2.0F, 0.0F, 8.0F, 2.0F, 3.0F, 8.0F), PartPose.offset(-3.0F, 19.0F, 7.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 11.0F, -7.0F, 8.0F, 7.0F, 14.0F).texOffs(0, 21).addBox(2.0F, 0.0F, -7.0F, 2.0F, 11.0F, 14.0F).texOffs(32, 34).addBox(2.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(-3.0F, 4.0F, 0.0F));
        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 11).addBox(-1.5F, -2.0F, -10.0F, 3.0F, 4.0F, 6.0F).texOffs(44, 54).addBox(-0.5F, 2.0F, -9.0F, 1.0F, 1.0F, 4.0F).texOffs(18, 46).addBox(-1.5F, -2.0F, -4.0F, 3.0F, 5.0F, 4.0F), PartPose.offset(0.0F, 16.0F, -7.0F));
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 46).addBox(-1.5F, 0.0F, -6.0F, 3.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 2.0F, -4.0F));
        partDefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(32, 46).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F), PartPose.offset(4.0F, 21.0F, -5.0F));
        partDefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 53).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F), PartPose.offset(-4.0F, 21.0F, -5.0F));
        partDefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(44, 46).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F), PartPose.offset(4.0F, 21.0F, 4.0F));
        partDefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(32, 54).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 5.0F, 3.0F), PartPose.offset(-4.0F, 21.0F, 4.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
