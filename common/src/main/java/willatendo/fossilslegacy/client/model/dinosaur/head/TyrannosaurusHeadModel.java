package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TyrannosaurusHeadModel extends HeadModel {
    public TyrannosaurusHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 0).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 7.0F, 7.0F).texOffs(46, 49).addBox(-2.0F, -6.0F, -10.0F, 4.0F, 4.0F, 7.0F), PartPose.ZERO);
        head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(20, 52).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 7.0F), PartPose.offset(0.0F, -2.0F, -3.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
