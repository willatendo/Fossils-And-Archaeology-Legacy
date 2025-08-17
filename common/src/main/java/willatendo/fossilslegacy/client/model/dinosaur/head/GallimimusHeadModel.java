package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class GallimimusHeadModel extends HeadModel {
    public GallimimusHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 12).addBox(-2.0F, -5.0F, -1.0F, 4.0F, 5.0F, 5.0F).texOffs(28, 55).addBox(-1.0F, -3.0F, -5.0F, 2.0F, 3.0F, 4.0F), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
