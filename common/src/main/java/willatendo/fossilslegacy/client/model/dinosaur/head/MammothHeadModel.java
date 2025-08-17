package willatendo.fossilslegacy.client.model.dinosaur.head;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class MammothHeadModel extends HeadModel {
    public MammothHeadModel(ModelPart root) {
        super(root, "head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(38, 0).addBox(-3.0F, -13.0F, -3.0F, 6.0F, 8.0F, 7.0F).texOffs(38, 25).addBox(3.0F, -13.0F, 2.0F, 5.0F, 7.0F, 0.0F).texOffs(48, 25).addBox(-8.0F, -13.0F, 2.0F, 5.0F, 7.0F, 0.0F).texOffs(48, 54).addBox(2.0F, -7.0F, -2.0F, 2.0F, 7.0F, 2.0F).texOffs(24, 48).addBox(2.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 58).addBox(2.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F).texOffs(56, 54).addBox(-4.0F, -7.0F, -2.0F, 2.0F, 7.0F, 2.0F).texOffs(16, 58).addBox(-4.0F, -2.0F, -4.0F, 2.0F, 2.0F, 2.0F).texOffs(8, 58).addBox(-4.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F), PartPose.ZERO);
        head.addOrReplaceChild("tuff_1", CubeListBuilder.create().texOffs(32, 43).addBox(0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -14.5F, 0.5F, 0.0F, 0.7854F, 0.0F));
        head.addOrReplaceChild("tuff_2", CubeListBuilder.create().texOffs(38, 15).addBox(0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(0.0F, -14.5F, 0.5F, 0.0F, -0.7854F, 0.0F));
        PartDefinition trunk = head.addOrReplaceChild("trunk", CubeListBuilder.create().texOffs(36, 54).addBox(-1.5F, 4.5F, 5.0F, 3.0F, 6.0F, 3.0F), PartPose.offset(0.0F, -14.5F, -11.0F));
        trunk.addOrReplaceChild("trunk_end", CubeListBuilder.create().texOffs(46, 43).addBox(-1.5F, 6.0F, 6.5F, 3.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 4.5F, -1.5F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
