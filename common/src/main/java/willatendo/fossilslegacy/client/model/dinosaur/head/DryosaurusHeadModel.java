package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class DryosaurusHeadModel extends HeadModel {
    public DryosaurusHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 28).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F).texOffs(32, 36).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 3.0F, 2.0F), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
