package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class ElasmotheriumHeadModel extends HeadModel {
    public ElasmotheriumHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 12).addBox(-2.0F, -5.0F, -3.0F, 4.0F, 5.0F, 3.0F).texOffs(32, 37).addBox(-3.0F, -7.0F, 0.0F, 6.0F, 7.0F, 4.0F).texOffs(50, 12).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 5.0F, 4.0F), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 128, 128);
    }
}
