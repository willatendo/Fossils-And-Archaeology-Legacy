package willatendo.fossilslegacy.client.model.dinosaur;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class TyrannosaurusModels {
    public static LayerDefinition baby() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -7.0F, 8.0F, 4.0F, 9.0F, 5.0F).texOffs(0, 16).addBox(-2.0F, -7.0F, -1.0F, 4.0F, 6.0F, 9.0F), PartPose.offset(0.0F, 12.0F, -18.0F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 31).addBox(-1.0F, -8.0F, 8.0F, 2.0F, 4.0F, 8.0F).texOffs(26, 16).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 6.0F, 8.0F), PartPose.offset(0.0F, 18.0F, 6.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -7.0F, -1.0F, 3.0F, 5.0F, 4.0F).texOffs(44, 49).addBox(-2.0F, -2.0F, 1.0F, 2.0F, 3.0F, 2.0F).texOffs(42, 43).addBox(-2.0F, 1.0F, -1.0F, 3.0F, 2.0F, 4.0F), PartPose.offset(4.0F, 21.0F, 2.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(14, 43).addBox(-3.0F, -5.0F, -1.0F, 3.0F, 5.0F, 4.0F).texOffs(28, 43).addBox(-3.0F, 3.0F, -1.0F, 3.0F, 2.0F, 4.0F).texOffs(50, 0).addBox(-2.0F, 0.0F, 1.0F, 2.0F, 3.0F, 2.0F), PartPose.offset(-2.0F, 19.0F, 2.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(28, 49).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(3.0F, 17.0F, -5.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(36, 49).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(-3.0F, 17.0F, -5.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -14.0F, -2.0F, 8.0F, 8.0F, 8.0F).texOffs(26, 30).addBox(-3.0F, -14.0F, -8.0F, 6.0F, 7.0F, 6.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public static LayerDefinition adult() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(82, 0).addBox(-4.0F, -13.0F, -10.0F, 8.0F, 18.0F, 14.0F), PartPose.offset(0.0F, -3.0F, -16.0F));
        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 107).addBox(-3.0F, -8.0F, -21.0F, 6.0F, 8.0F, 12.0F).texOffs(82, 32).addBox(-2.0F, 0.0F, -20.0F, 4.0F, 1.0F, 11.0F).texOffs(0, 83).addBox(-5.0F, -8.0F, -9.0F, 10.0F, 12.0F, 12.0F), PartPose.offset(0.0F, -6.0F, -8.0F));
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(122, 64).addBox(-2.0F, -3.0F, -11.0F, 4.0F, 1.0F, 11.0F).texOffs(122, 48).addBox(-3.0F, -2.0F, -12.0F, 6.0F, 4.0F, 12.0F), PartPose.offset(0.0F, 2.0F, -9.0F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 45).addBox(-6.0F, -8.0F, 0.0F, 12.0F, 16.0F, 22.0F).texOffs(68, 45).addBox(-2.0F, -8.0F, 22.0F, 5.0F, 10.0F, 22.0F), PartPose.offset(0.0F, -1.0F, 16.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(44, 104).addBox(-2.0F, -7.0F, -6.0F, 7.0F, 15.0F, 13.0F).texOffs(118, 77).addBox(-2.0F, 17.0F, -5.0F, 6.0F, 3.0F, 13.0F).texOffs(44, 83).addBox(-2.0F, 4.0F, 2.0F, 5.0F, 13.0F, 6.0F), PartPose.offset(7.0F, 4.0F, 5.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(124, 93).addBox(-3.0F, 4.0F, 2.0F, 5.0F, 13.0F, 6.0F).texOffs(122, 32).addBox(-4.0F, 17.0F, -5.0F, 6.0F, 3.0F, 13.0F).texOffs(84, 104).addBox(-5.0F, -7.0F, -6.0F, 7.0F, 15.0F, 13.0F), PartPose.offset(-7.0F, 4.0F, 5.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(124, 123).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 7.0F, 4.0F), PartPose.offset(-7.5F, 7.0F, -13.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(124, 112).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 7.0F, 4.0F), PartPose.offset(7.5F, 7.0F, -13.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(68, 77).addBox(-7.0F, -33.0F, -20.0F, 14.0F, 16.0F, 11.0F).texOffs(0, 0).addBox(-8.0F, -34.0F, -9.0F, 16.0F, 20.0F, 25.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }
    
    public static LayerDefinition knockedOut() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition neck = partdefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(82, 0).addBox(-4.0F, -6.0F, -10.0F, 8.0F, 18.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 4.0F, -16.0F, 0.6981F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 107).addBox(-3.0F, 6.0F, -21.0F, 6.0F, 8.0F, 12.0F).texOffs(82, 32).addBox(-2.0F, 14.0F, -20.0F, 4.0F, 1.0F, 11.0F).texOffs(0, 83).addBox(-5.0F, 6.0F, -9.0F, 10.0F, 12.0F, 12.0F), PartPose.offset(0.0F, -13.0F, -8.0F));
        head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(122, 64).addBox(-2.0F, 11.0F, -11.0F, 4.0F, 1.0F, 11.0F).texOffs(122, 48).addBox(-3.0F, 12.0F, -12.0F, 6.0F, 4.0F, 12.0F), PartPose.offset(0.0F, 2.0F, -9.0F));
        partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 45).addBox(-6.0F, 6.0F, 0.0F, 12.0F, 16.0F, 22.0F).texOffs(68, 45).addBox(-2.0F, 6.0F, 22.0F, 5.0F, 10.0F, 22.0F), PartPose.offset(0.0F, -1.0F, 16.0F));
        partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(44, 104).addBox(-2.0F, -7.0F, -6.0F, 7.0F, 15.0F, 13.0F).texOffs(118, 77).addBox(-2.0F, 17.0F, -5.0F, 6.0F, 3.0F, 13.0F).texOffs(44, 83).addBox(-2.0F, 4.0F, 2.0F, 5.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(7.0F, 17.0F, 5.0F, -1.5708F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(124, 93).addBox(-3.0F, 4.0F, 2.0F, 5.0F, 13.0F, 6.0F).texOffs(122, 32).addBox(-4.0F, 17.0F, -5.0F, 6.0F, 3.0F, 13.0F).texOffs(84, 104).addBox(-5.0F, -7.0F, -6.0F, 7.0F, 15.0F, 13.0F), PartPose.offsetAndRotation(-7.0F, 17.0F, 5.0F, -1.5708F, 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(124, 123).addBox(-1.5F, 12.0F, -2.0F, 3.0F, 7.0F, 4.0F), PartPose.offset(-7.5F, 7.0F, -13.0F));
        partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(124, 112).addBox(-1.5F, 12.0F, -2.0F, 3.0F, 7.0F, 4.0F), PartPose.offset(7.5F, 7.0F, -13.0F));
        partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(68, 77).addBox(-7.0F, -19.0F, -20.0F, 14.0F, 16.0F, 11.0F).texOffs(0, 0).addBox(-8.0F, -20.0F, -9.0F, 16.0F, 20.0F, 25.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }
}
