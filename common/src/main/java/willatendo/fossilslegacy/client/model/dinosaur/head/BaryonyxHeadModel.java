package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class BaryonyxHeadModel extends HeadModel {
    public BaryonyxHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 5.0F).texOffs(0, 44).addBox(-1.0F, -4.0F, -8.0F, 2.0F, 2.0F, 7.0F), PartPose.ZERO);
        head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(36, 10).addBox(-1.0F, 16.0F, 7.0F, 2.0F, 2.0F, 7.0F).texOffs(46, 31).addBox(-0.5F, 16.0F, 8.0F, 1.0F, 1.0F, 6.0F).texOffs(46, 31).addBox(-0.5F, 15.0F, 8.0F, 1.0F, 1.0F, 6.0F), PartPose.offset(0.0F, -18.0F, -15.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
