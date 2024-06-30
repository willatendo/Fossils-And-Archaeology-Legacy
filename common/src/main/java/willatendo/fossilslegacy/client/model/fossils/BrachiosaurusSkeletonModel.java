package willatendo.fossilslegacy.client.model.fossils;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BrachiosaurusSkeletonModel extends AbstractSkeletonModel {
    public BrachiosaurusSkeletonModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(52, 45).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 5.0F, 3.0F).texOffs(0, 47).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 9.0F, 5.0F), PartPose.offset(4.0F, 13.0F, -5.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(50, 0).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 5.0F, 3.0F).texOffs(34, 43).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 9.0F, 5.0F), PartPose.offset(-4.0F, 13.0F, -5.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(52, 53).addBox(-1.0F, 4.0F, -1.0F, 3.0F, 6.0F, 3.0F).texOffs(48, 35).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(2.0F, 14.0F, 4.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(56, 9).addBox(-2.0F, 4.0F, -1.0F, 3.0F, 6.0F, 3.0F).texOffs(48, 25).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F), PartPose.offset(-2.0F, 14.0F, 4.0F));
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(18, 43).addBox(-2.0F, -15.0F, -3.0F, 4.0F, 12.0F, 4.0F).texOffs(24, 30).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(0.0F, 7.0F, -8.0F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, -1.0F, -8.0F, 4.0F, 4.0F, 8.0F).texOffs(25, 0).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 3.0F, 4.0F), PartPose.offset(0.0F, -13.0F, -3.0F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 36).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 6.0F, 5.0F).texOffs(46, 12).addBox(-1.0F, 0.0F, 16.0F, 2.0F, 3.0F, 6.0F).texOffs(0, 21).addBox(-2.0F, -1.0F, 5.0F, 4.0F, 4.0F, 11.0F), PartPose.offset(0.0F, 12.0F, 7.0F));
        partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -19.0F, -8.0F, 8.0F, 12.0F, 9.0F).texOffs(28, 15).addBox(-3.0F, -16.0F, 1.0F, 6.0F, 8.0F, 6.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
}
