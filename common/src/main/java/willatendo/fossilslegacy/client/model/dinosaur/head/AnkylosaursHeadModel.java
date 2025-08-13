package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class AnkylosaursHeadModel extends HeadModel {
    public AnkylosaursHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F).texOffs(22, 41).addBox(2.0F, -3.0F, 2.0F, 3.0F, 3.0F, 2.0F).texOffs(58, 34).addBox(-5.0F, -3.0F, 2.0F, 3.0F, 3.0F, 2.0F).texOffs(58, 20).addBox(2.0F, -10.0F, 1.0F, 3.0F, 4.0F, 3.0F).texOffs(58, 27).addBox(-5.0F, -10.0F, 1.0F, 3.0F, 4.0F, 3.0F).texOffs(54, 39).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 5.0F, 3.0F), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
