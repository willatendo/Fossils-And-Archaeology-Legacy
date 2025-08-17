package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class VelociraptorHeadModel extends HeadModel {
    public VelociraptorHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(14, 9).addBox(-1.5F, -4.0F, 2.0F, 0.0F, 4.0F, 2.0F).texOffs(12, 20).addBox(1.5F, -4.0F, 2.0F, 0.0F, 4.0F, 2.0F).texOffs(0, 0).addBox(-1.5F, -4.0F, 2.0F, 3.0F, 0.0F, 3.0F).texOffs(26, 17).addBox(-1.0F, -3.0F, -7.0F, 2.0F, 2.0F, 3.0F).texOffs(17, 19).addBox(-1.5F, -4.0F, -4.0F, 3.0F, 4.0F, 3.0F).texOffs(19, 9).addBox(-1.5F, -4.0F, -1.0F, 3.0F, 4.0F, 3.0F), PartPose.ZERO);
        head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(26, 23).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F), PartPose.offset(0.0F, -1.0F, -4.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
