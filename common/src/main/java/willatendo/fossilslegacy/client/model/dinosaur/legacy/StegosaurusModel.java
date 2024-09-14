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
import willatendo.fossilslegacy.server.entity.Stegosaurus;

public class StegosaurusModel extends EntityModel<Dinosaur> {
    private final ModelPart root;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftFrontFoot;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightFrontFoot;
    private final ModelPart leftBackLeg;
    private final ModelPart leftBackFoot;
    private final ModelPart rightBackLeg;
    private final ModelPart rightBackFoot;
    private final ModelPart backPlates1;
    private final ModelPart backPlates2;
    private final ModelPart backPlates3;
    private final ModelPart thagomizer;

    public StegosaurusModel(ModelPart root) {
        this.root = root;
        this.tail1 = root.getChild("tail_1");
        this.tail2 = root.getChild("tail_2");
        this.tail3 = root.getChild("tail_3");
        this.leftFrontLeg = root.getChild("left_front_leg");
        this.leftFrontFoot = root.getChild("left_front_foot");
        this.rightFrontLeg = root.getChild("right_front_leg");
        this.rightFrontFoot = root.getChild("right_front_foot");
        this.leftBackLeg = root.getChild("left_back_leg");
        this.leftBackFoot = root.getChild("left_back_foot");
        this.rightBackLeg = root.getChild("right_back_leg");
        this.rightBackFoot = root.getChild("right_back_foot");
        this.backPlates1 = root.getChild("back_plates_1");
        this.backPlates2 = root.getChild("back_plates_2");
        this.backPlates3 = root.getChild("back_plates_3");
        this.thagomizer = root.getChild("thagomizer");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("front_body", CubeListBuilder.create().texOffs(46, 14).addBox(-2.0F, 2.0F, -4.0F, 5.0F, 5.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 0).addBox(-3.0F, 0.0F, 0.0F, 7.0F, 8.0F, 8.0F).mirror(), PartPose.offset(0.0F, 14.0F, -6.0F));
        partDefinition.addOrReplaceChild("back_plates_1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, 8.0F, 1.0F, 5.0F, 3.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("back_body", CubeListBuilder.create().texOffs(32, 24).addBox(-0.5F, 3.5F, -8.0F, 2.0F, 3.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.1745329F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("back_plates_2", CubeListBuilder.create().texOffs(12, 13).addBox(-0.5F, -3.5F, 2.0F, 2.0F, 5.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("tail_1", CubeListBuilder.create().texOffs(46, 23).addBox(-2.0F, 1.5F, 2.0F, 5.0F, 5.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("back_plates_3", CubeListBuilder.create().texOffs(0, 13).addBox(-0.5F, -3.0F, -3.0F, 2.0F, 5.0F, 4.0F).mirror(), PartPose.offsetAndRotation(0.0F, 14.0F, -6.0F, 0.2617994F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(32, 16).addBox(-1.0F, 2.0F, 4.5F, 3.0F, 3.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(52, 6).addBox(-0.5F, 2.5F, 7.5F, 2.0F, 2.0F, 4.0F).mirror(), PartPose.offset(0.0F, 14.0F, -1.0F));
        partDefinition.addOrReplaceChild("thagomizer", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -5.0F, 0.0F, 2.0F, 5.0F, 8.0F).mirror(), PartPose.offset(0.0F, 14.0F, -6.0F));
        partDefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 3.0F, 3.0F).mirror(), PartPose.offset(4.0F, 20.0F, -6.0F));
        partDefinition.addOrReplaceChild("right_front_foot", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, 0.0F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(4.0F, 20.0F, -6.0F, 0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(54, 0).addBox(-2.0F, -1.5F, -2.0F, 2.0F, 3.0F, 3.0F).mirror(), PartPose.offset(-2.0F, 20.0F, -6.0F));
        partDefinition.addOrReplaceChild("left_front_foot", CubeListBuilder.create().texOffs(20, 0).addBox(-1.5F, 0.0F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(-2.0F, 20.0F, -6.0F, 0.8726646F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(14, 22).addBox(-1.0F, -2.5F, -2.0F, 2.0F, 5.0F, 5.0F).mirror(), PartPose.offset(4.0F, 19.0F, 1.0F));
        partDefinition.addOrReplaceChild("right_back_foot", CubeListBuilder.create().texOffs(24, 16).addBox(-0.5F, 2.5F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(4.0F, 19.0F, 1.0F, 1.22173F, 0F, 0F));
        partDefinition.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -2.5F, -2.0F, 2.0F, 5.0F, 5.0F).mirror(), PartPose.offset(-2.0F, 19.0F, 1.0F));
        partDefinition.addOrReplaceChild("left_back_foot", CubeListBuilder.create().texOffs(24, 21).addBox(-1.5F, 2.5F, -4.0F, 1.0F, 2.0F, 3.0F).mirror(), PartPose.offsetAndRotation(-2.0F, 19.0F, 1.0F, 1.22173F, 0F, 0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Dinosaur dinosaur, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.tail1.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount + 0F;
        this.tail2.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.436332312998582F * limbSwingAmount + 0F;
        this.tail3.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount + 0F;
        this.leftFrontLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0F;
        this.rightFrontLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.leftFrontFoot.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.872664625997162F;
        this.rightFrontFoot.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.872664625997162F;
        this.leftBackLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.leftBackLeg.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.rightBackLeg.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0F;
        this.rightBackLeg.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.leftBackFoot.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 1.22173047639603F;
        this.leftBackFoot.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.rightBackFoot.xRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 1.22173047639603F;
        this.rightBackFoot.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.backPlates1.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount + 0F;
        //this.backPlates2.yRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount + 0F;
        // this.backPlates2.zRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.thagomizer.zRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
        this.backPlates3.zRot = Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }
}
