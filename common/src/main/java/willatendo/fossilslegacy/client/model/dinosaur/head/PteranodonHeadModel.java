package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class PteranodonHeadModel extends HeadModel {
    public PteranodonHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 5.0F).texOffs(0, 14).addBox(-1.0F, -3.0F, -12.0F, 2.0F, 1.0F, 9.0F).texOffs(18, 26).addBox(-1.0F, -6.0F, -3.0F, 2.0F, 2.0F, 7.0F), PartPose.ZERO);
        head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, 0.0F, -9.0F, 2.0F, 1.0F, 9.0F), PartPose.offset(0.0F, -2.0F, -3.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
