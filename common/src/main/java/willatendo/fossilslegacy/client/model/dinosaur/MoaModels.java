package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class MoaModels {
    public static LayerDefinition createMoaBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(18, 43).addBox(-2.0F, 3.0F, -0.5F, 2.0F, 5.0F, 2.0F).texOffs(34, 36).addBox(-2.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F), PartPose.offset(-1.0F, 16.0F, 1.5F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(24, 36).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 4.0F, 3.0F).texOffs(10, 42).addBox(-1.0F, 3.0F, -0.5F, 2.0F, 5.0F, 2.0F), PartPose.offset(2.0F, 16.0F, 1.5F));
        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -13.0F, -2.5F, 2.0F, 15.0F, 3.0F), PartPose.offset(0.0F, 9.0F, -4.5F));
        neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 18).addBox(-2.0F, -3.0F, -3.25F, 4.0F, 4.0F, 4.0F).texOffs(0, 42).addBox(-1.0F, -2.0F, -6.25F, 2.0F, 2.0F, 3.0F), PartPose.offset(0.0F, -12.0F, -1.25F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -9.0F, -5.0F, 8.0F, 2.0F, 9.0F).texOffs(0, 28).addBox(-3.0F, -16.0F, 3.0F, 6.0F, 8.0F, 6.0F).texOffs(0, 0).addBox(-4.0F, -17.0F, -5.0F, 8.0F, 8.0F, 9.0F).texOffs(24, 28).addBox(-3.0F, -8.0F, 3.0F, 6.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}