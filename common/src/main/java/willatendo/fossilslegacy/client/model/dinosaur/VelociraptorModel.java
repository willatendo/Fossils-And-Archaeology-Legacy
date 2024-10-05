package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class VelociraptorModel {
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 6).addBox(-1.375F, 8.625F, -1.75F, 2.0F, 0.0F, 3.0F).texOffs(31, 4).addBox(-0.375F, 3.625F, 0.25F, 1.0F, 5.0F, 1.0F).texOffs(9, 26).addBox(-1.375F, -0.375F, -1.75F, 2.0F, 4.0F, 3.0F).texOffs(0, 8).addBox(0.625F, 6.625F, -1.75F, 0.0F, 2.0F, 3.0F), PartPose.offset(-2.625F, 15.375F, -2.25F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(19, 26).addBox(-0.625F, -0.375F, -1.75F, 2.0F, 4.0F, 3.0F).texOffs(0, 10).addBox(-0.625F, 6.625F, -1.75F, 0.0F, 2.0F, 3.0F).texOffs(0, 3).addBox(-0.625F, 8.625F, -1.75F, 2.0F, 0.0F, 3.0F).texOffs(29, 27).addBox(-0.625F, 3.625F, 0.25F, 1.0F, 5.0F, 1.0F), PartPose.offset(2.625F, 15.375F, -2.25F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 29).addBox(-0.5F, 0.0F, -1.25F, 1.0F, 2.0F, 2.0F).texOffs(13, 6).addBox(-0.5F, 2.0F, -0.25F, 1.0F, 2.0F, 1.0F), PartPose.offset(2.0F, 16.0F, -6.75F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(16, 26).addBox(-0.5F, 2.0F, -0.25F, 1.0F, 2.0F, 1.0F).texOffs(27, 0).addBox(-0.5F, 0.0F, -1.25F, 1.0F, 2.0F, 2.0F), PartPose.offset(-2.0F, 16.0F, -6.75F));
        partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(19, 9).addBox(-1.5F, -5.0F, -1.5F, 3.0F, 5.0F, 3.0F).texOffs(17, 19).addBox(-1.5F, -5.0F, -4.5F, 3.0F, 4.0F, 3.0F).texOffs(26, 17).addBox(-1.0F, -4.0F, -7.5F, 2.0F, 2.0F, 3.0F).texOffs(26, 23).addBox(-1.0F, -2.0F, -7.5F, 2.0F, 1.0F, 3.0F).texOffs(0, 0).addBox(-1.5F, -5.0F, 1.5F, 3.0F, 0.0F, 3.0F).texOffs(12, 20).addBox(1.5F, -5.0F, 1.5F, 0.0F, 4.0F, 2.0F).texOffs(14, 9).addBox(-1.5F, -5.0F, 1.5F, 0.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 14.0F, -7.5F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(17, 2).addBox(-1.5F, 0.1667F, 0.1667F, 3.0F, 3.0F, 4.0F).texOffs(0, 0).addBox(-1.0F, 0.1667F, 4.1667F, 2.0F, 2.0F, 9.0F).texOffs(7, 0).addBox(-2.0F, 0.1667F, 10.1667F, 4.0F, 0.0F, 6.0F), PartPose.offset(0.0F, 13.8333F, -0.1667F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-2.0F, -10.0F, -6.0F, 4.0F, 5.0F, 6.0F).texOffs(0, 22).addBox(-1.5F, -10.0F, -9.0F, 3.0F, 4.0F, 3.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}