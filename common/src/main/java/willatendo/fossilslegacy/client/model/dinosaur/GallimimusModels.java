package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class GallimimusModels {
    public static LayerDefinition createGallimimusBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(36, 49).addBox(-2.0F, 11.0F, -1.0F, 3.0F, 2.0F, 4.0F).texOffs(28, 41).addBox(-2.0F, 1.0F, 1.0F, 2.0F, 10.0F, 2.0F).texOffs(40, 0).addBox(-3.0F, -3.0F, -3.0F, 4.0F, 7.0F, 5.0F), PartPose.offset(6.0F, 11.0F, 1.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 41).addBox(-1.0F, -3.0F, -3.0F, 4.0F, 7.0F, 5.0F).texOffs(50, 49).addBox(0.0F, 1.0F, 1.0F, 2.0F, 10.0F, 2.0F).texOffs(0, 53).addBox(-1.0F, 11.0F, -1.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(-6.0F, 11.0F, 1.0F));
        PartDefinition neck = partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(18, 41).addBox(-1.0F, -11.0F, -2.0F, 2.0F, 14.0F, 3.0F), PartPose.offset(0.0F, 6.0F, -10.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 55).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 3.0F, 4.0F).texOffs(40, 12).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 5.0F, 5.0F), PartPose.offset(0.0F, -9.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 36).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 7.0F, 6.0F).texOffs(0, 0).addBox(-1.0F, -2.0F, 6.0F, 2.0F, 4.0F, 18.0F), PartPose.offset(0.0F, 7.0F, 5.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(56, 36).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(-3.0F, 10.0F, -9.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 55).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F), PartPose.offset(3.0F, 10.0F, -9.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(36, 22).addBox(-2.5F, -19.0F, -11.0F, 5.0F, 8.0F, 6.0F).texOffs(0, 22).addBox(-4.0F, -19.0F, -5.0F, 8.0F, 9.0F, 10.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
