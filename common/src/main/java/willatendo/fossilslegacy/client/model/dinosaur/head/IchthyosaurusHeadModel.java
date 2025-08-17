package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class IchthyosaurusHeadModel extends HeadModel {
    public IchthyosaurusHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -3.0F, -8.0F, 3.0F, 3.0F, 6.0F).texOffs(0, 20).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 6.0F, 6.0F), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
