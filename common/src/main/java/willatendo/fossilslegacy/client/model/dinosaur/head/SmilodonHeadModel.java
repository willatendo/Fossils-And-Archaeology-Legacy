package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class SmilodonHeadModel extends HeadModel {
    public SmilodonHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -6.0F, -2.0F, 6.0F, 6.0F, 6.0F).texOffs(34, 9).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 3.0F, 3.0F).texOffs(16, 42).addBox(-3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 2.0F).texOffs(32, 24).addBox(1.0F, -1.0F, -5.0F, 1.0F, 2.0F, 2.0F).texOffs(32, 41).addBox(-2.0F, -1.0F, -5.0F, 1.0F, 2.0F, 2.0F).texOffs(38, 42).addBox(-2.0F, 1.0F, -5.0F, 1.0F, 1.0F, 2.0F).texOffs(44, 15).addBox(1.0F, 1.0F, -5.0F, 1.0F, 1.0F, 2.0F).texOffs(10, 42).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 2.0F), PartPose.ZERO);
        head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, 10.0F, 7.0F, 2.0F, 1.0F, 3.0F), PartPose.offset(0.0F, -11.0F, -12.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
