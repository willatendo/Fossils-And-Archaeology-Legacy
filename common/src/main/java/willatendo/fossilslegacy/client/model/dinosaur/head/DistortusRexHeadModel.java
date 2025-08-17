package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class DistortusRexHeadModel extends HeadModel {
    public DistortusRexHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(74, 27).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 3.0F, 3.0F).texOffs(120, 120).addBox(-2.0F, -8.0F, -8.0F, 4.0F, 5.0F, 2.0F).texOffs(38, 114).addBox(-5.0F, -8.0F, -6.0F, 10.0F, 5.0F, 6.0F).texOffs(0, 71).addBox(-6.0F, -16.0F, -9.0F, 12.0F, 8.0F, 13.0F), PartPose.ZERO);
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(100, 28).addBox(-5.0F, 24.0F, 11.0F, 10.0F, 3.0F, 3.0F).texOffs(50, 89).addBox(-2.0F, 24.0F, 9.0F, 4.0F, 3.0F, 2.0F), PartPose.offset(0.0F, -27.0F, -17.0F));

        return LayerDefinition.create(meshDefinition, 256, 256);
    }
}
