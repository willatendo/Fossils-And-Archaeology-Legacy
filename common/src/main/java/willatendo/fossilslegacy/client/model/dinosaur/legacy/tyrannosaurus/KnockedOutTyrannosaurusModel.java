package willatendo.fossilslegacy.client.model.dinosaur.legacy.tyrannosaurus;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class KnockedOutTyrannosaurusModel extends AbstractTyrannosaurusModel {

    private final ModelPart root;

    public KnockedOutTyrannosaurusModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 8.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 16.0F, -8.0F, -7.905835E-16F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("snout", CubeListBuilder.create().texOffs(34, 18).addBox(-4.0F, 1.0F, -11.0F, 6.0F, 6.0F, 8.0F), PartPose.offset(1.0F, 16.0F, -8.0F));
        partDefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(12, 23).addBox(-4.0F, 6.0F, -10.0F, 4.0F, 2.0F, 7.0F), PartPose.offset(2.0F, 16.0F, -8.0F));
        partDefinition.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(1, 0).addBox(-5.0F, 0.0F, -6.0F, 8.0F, 11.0F, 12.0F), PartPose.offset(1.0F, 13.0F, 4.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(4, 2).addBox(-3.0F, 0.0F, -10.0F, 6.0F, 8.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 13.0F, -1.0F, 0.3164194F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(4, 4).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 14.0F, 9.0F, -0.3616222F, 0.4972305F, 0.0F));
        partDefinition.addOrReplaceChild("tail_mid", CubeListBuilder.create().texOffs(5, 2).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(2.0F, 17.0F, 16.0F, -0.4520277F, 1.6273F, 0.0F));
        partDefinition.addOrReplaceChild("tail_end", CubeListBuilder.create().texOffs(10, 6).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(12.0F, 22.0F, 11.0F, 0.0F, -0.4520277F, 0.0F));
        partDefinition.addOrReplaceChild("right_thigh", CubeListBuilder.create().texOffs(40, 2).addBox(-4.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F), PartPose.offset(-2.0F, 19.0F, 5.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-4.0F, 25.0F, 4.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, 0.0F, -6.0F, 3.0F, 2.0F, 8.0F), PartPose.offset(-6.0F, 23.0F, 4.0F));
        partDefinition.addOrReplaceChild("left_thigh", CubeListBuilder.create().texOffs(40, 2).addBox(0.0F, -4.0F, -4.0F, 4.0F, 8.0F, 8.0F), PartPose.offset(2.0F, 19.0F, 5.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(4.0F, 25.0F, 4.0F, 1.570796F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(36, 0).addBox(-1.0F, 0.0F, -6.0F, 3.0F, 2.0F, 8.0F), PartPose.offset(6.0F, 23.0F, 4.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(34, 0).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 22.0F, -4.0F, 0.994461F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(34, 0).addBox(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(2.0F, 22.0F, -4.0F, 1.039664F, 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }
}
