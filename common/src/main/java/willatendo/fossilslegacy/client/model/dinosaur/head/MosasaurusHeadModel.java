package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class MosasaurusHeadModel extends HeadModel {
    public MosasaurusHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 20).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 7.0F).texOffs(0, 40).addBox(-3.0F, -7.0F, -10.0F, 6.0F, 4.0F, 7.0F).texOffs(56, 61).addBox(-2.0F, -3.0F, -9.0F, 4.0F, 1.0F, 6.0F), PartPose.ZERO);
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(26, 49).addBox(-3.0F, 1.0F, 7.0F, 6.0F, 2.0F, 7.0F).texOffs(36, 61).addBox(-2.0F, 0.0F, 8.0F, 4.0F, 1.0F, 6.0F), PartPose.offset(0.0F, -4.0F, -17.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
