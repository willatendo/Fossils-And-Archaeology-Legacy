package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class DilophosaurusHeadModel extends HeadModel {
    public DilophosaurusHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(42, 29).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 3.0F, 6.0F).texOffs(0, 52).addBox(-2.0F, -5.0F, 1.0F, 4.0F, 5.0F, 3.0F).texOffs(30, 52).addBox(-6.0F, -6.0F, 4.0F, 4.0F, 7.0F, 0.0F).texOffs(38, 52).addBox(2.0F, -6.0F, 4.0F, 4.0F, 7.0F, 0.0F).texOffs(18, 40).addBox(1.0F, -8.0F, -5.0F, 0.0F, 3.0F, 9.0F).texOffs(36, 40).addBox(-1.0F, -8.0F, -5.0F, 0.0F, 3.0F, 9.0F), PartPose.ZERO);
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(44, 13).addBox(-2.0F, 15.0F, 9.0F, 4.0F, 2.0F, 6.0F), PartPose.offset(0.0F, -17.0F, -14.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
