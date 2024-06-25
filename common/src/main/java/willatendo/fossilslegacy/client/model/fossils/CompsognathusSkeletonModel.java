package willatendo.fossilslegacy.client.model.fossils;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class CompsognathusSkeletonModel extends AbstractSkeletonModel {
    public CompsognathusSkeletonModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 4.0F, 2.0F, 2.0F, 8.0F).texOffs(12, 0).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 18.0F, 1.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F).texOffs(14, 10).addBox(0.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F).texOffs(5, 0).addBox(0.0F, 6.0F, 0.0F, 1.0F, 0.0F, 1.0F), PartPose.offset(-2.0F, 18.0F, -1.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F).texOffs(5, 1).addBox(-1.0F, 6.0F, 0.0F, 1.0F, 0.0F, 1.0F).texOffs(12, 10).addBox(-1.0F, 3.0F, 1.0F, 1.0F, 3.0F, 0.0F), PartPose.offset(2.0F, 18.0F, -1.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 10).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offset(-1.5F, 18.5F, -4.5F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F), PartPose.offset(1.5F, 18.5F, -4.5F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 13).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 3.0F, 2.0F).texOffs(12, 14).addBox(-1.0F, -3.0F, -5.0F, 2.0F, 3.0F, 4.0F), PartPose.offset(0.0F, 16.0F, -5.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -8.0F, -3.0F, 4.0F, 4.0F, 4.0F).texOffs(17, 7).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }
}
