package willatendo.fossilslegacy.client.model.dinosaur.legacy;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class MosasaurusModel extends EntityModel<Dinosaur> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart rightFrontFlipper;
    private final ModelPart leftFrontFlipper;
    private final ModelPart rightBackFlipper;
    private final ModelPart leftBackFlipper;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail2Spike;
    private final ModelPart tail3;
    private final ModelPart tail3Spike;

    public MosasaurusModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        this.rightFrontFlipper = root.getChild("right_front_flipper");
        this.leftFrontFlipper = root.getChild("left_front_flipper");
        this.rightBackFlipper = root.getChild("right_back_flipper");
        this.leftBackFlipper = root.getChild("left_back_flipper");
        this.tail1 = root.getChild("tail_1");
        this.tail2 = root.getChild("tail_2");
        this.tail2Spike = root.getChild("tail_2_spike");
        this.tail3 = root.getChild("tail_3");
        this.tail3Spike = root.getChild("tail_3_spike");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(17, 22).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 1.0F, 5.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("upper_teeth", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 2.F, 6.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 6.0F, 8.0F), PartPose.offset(1.0F, 16.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_front_flipper", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-3.0F, 20.0F, 0.0F, -0.34907F, -1.0472F, -0.43633F));
        partDefinition.addOrReplaceChild("left_front_flipper", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 4.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(5.0F, 20.0F, 0.0F, -0.34907F, 1.0472F, 0.43633F));
        partDefinition.addOrReplaceChild("right_back_flipper", CubeListBuilder.create().texOffs(20, 1).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-2.0F, 20.0F, 7.0F, -0.34907F, -0.87266F, -0.43633F));
        partDefinition.addOrReplaceChild("left_back_flipper", CubeListBuilder.create().texOffs(20, 1).addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 20.0F, 7.0F, -0.34907F, 0.87266F, 0.43633F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(35, 14).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 11.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(36, 24).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 16.0F));
        partDefinition.addOrReplaceChild("tail_2_spike", CubeListBuilder.create().texOffs(26, 22).addBox(0.0F, -3.0F, -4.0F, 1.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 16.0F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(16, 8).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 6.0F), PartPose.offset(1.0F, 19.0F, 21.0F));
        partDefinition.addOrReplaceChild("tail_3_spike", CubeListBuilder.create().texOffs(26, 23).addBox(0.0F, -2.0F, -2.0F, 1.0F, 2.0F, 5.0F), PartPose.offset(1.0F, 19.0F, 20.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.body.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.0872664625997165 * limbSwingAmount + 0);
        this.tail1.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0);
        this.tail2.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0);
        this.tail3.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0);
        this.rightFrontFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -1.0471975511966);
        this.leftFrontFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 1.0471975511966);
        this.rightBackFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -0.872664625997165);
        this.leftBackFlipper.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 0.872664625997165);
        this.tail3Spike.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0);
        this.tail2Spike.yRot = (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }
}
