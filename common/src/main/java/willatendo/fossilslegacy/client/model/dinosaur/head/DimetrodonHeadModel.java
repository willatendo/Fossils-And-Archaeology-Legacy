package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class DimetrodonHeadModel extends HeadModel {
    public DimetrodonHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 11).addBox(-1.5F, -5.0F, -6.0F, 3.0F, 4.0F, 6.0F).texOffs(44, 54).addBox(-0.5F, -1.0F, -5.0F, 1.0F, 1.0F, 4.0F).texOffs(18, 46).addBox(-1.5F, -5.0F, 0.0F, 3.0F, 5.0F, 4.0F), PartPose.ZERO);
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 46).addBox(-1.5F, 5.0F, 5.0F, 3.0F, 1.0F, 6.0F), PartPose.offset(0.0F, -6.0F, -11.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
