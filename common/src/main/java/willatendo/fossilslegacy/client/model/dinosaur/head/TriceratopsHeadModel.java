package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TriceratopsHeadModel extends HeadModel {
    public TriceratopsHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 35).addBox(-3.5F, -7.0F, -3.0F, 7.0F, 7.0F, 7.0F).texOffs(0, 22).addBox(-6.5F, -13.0F, 2.0F, 13.0F, 12.0F, 2.0F).texOffs(30, 22).addBox(-7.5F, -14.0F, 1.9F, 15.0F, 13.0F, 0.0F).texOffs(38, 14).addBox(-1.5F, -4.0F, -6.0F, 3.0F, 4.0F, 3.0F).texOffs(26, 36).addBox(0.0F, -6.0F, -6.0F, 0.0F, 2.0F, 2.0F).texOffs(60, 28).addBox(-3.5F, -10.0F, -3.0F, 1.0F, 2.0F, 5.0F).texOffs(60, 28).mirror().addBox(2.5F, -10.0F, -3.0F, 1.0F, 2.0F, 5.0F).texOffs(20, 63).mirror().addBox(2.5F, -10.0F, -8.0F, 1.0F, 2.0F, 5.0F).texOffs(20, 63).addBox(-3.5F, -10.0F, -8.0F, 1.0F, 2.0F, 5.0F), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
