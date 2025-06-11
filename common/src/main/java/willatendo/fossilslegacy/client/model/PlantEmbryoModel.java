package willatendo.fossilslegacy.client.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;

public class PlantEmbryoModel extends Model {
    public PlantEmbryoModel(ModelPart root) {
        super(root, RenderType::entityCutoutNoCull);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("plant_embryo", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F).texOffs(0, 0).addBox(-4.0F, -8.0F, -2.0F, 3.0F, 2.0F, 4.0F).texOffs(0, 6).addBox(1.0F, -8.0F, -2.0F, 3.0F, 2.0F, 4.0F).texOffs(8, 12).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 32, 32);
    }
}
