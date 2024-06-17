package willatendo.fossilslegacy.client.model;

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
import willatendo.fossilslegacy.server.entity.Mammoth;

public class MammothModel extends EntityModel<Mammoth> {
    private final ModelPart root;
    private final ModelPart noseTop;
    private final ModelPart noseBottom;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;

    public MammothModel(ModelPart modelPart) {
        this.root = modelPart;
        this.noseTop = modelPart.getChild("nose_top");
        this.noseBottom = modelPart.getChild("nose_bottom");
        this.leftArm = modelPart.getChild("left_arm");
        this.rightArm = modelPart.getChild("right_arm");
        this.leftLeg = modelPart.getChild("left_leg");
        this.rightLeg = modelPart.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(46, 11).addBox(-2.0F, -3.0F, -3.5F, 4.0F, 5.0F, 5.0F).mirror(), PartPose.offset(0.0F, 15.5F, -1.5F));
        partDefinition.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(42, 21).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 5.0F, 6.0F).mirror(), PartPose.offset(0.0F, 15.5F, -1.5F));
        partDefinition.addOrReplaceChild("hair_tuff_1", CubeListBuilder.create().texOffs(8, 24).addBox(0.0F, -7.0F, -2.5F, 0.0F, 3.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.7853982F, 0.0F));
        partDefinition.addOrReplaceChild("hair_tuff_2", CubeListBuilder.create().texOffs(8, 24).addBox(0.0F, -7.0F, -2.5F, 0.0F, 3.0F, 5.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, -0.7853982F, 0.0F));
        partDefinition.addOrReplaceChild("front_hair", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -2.5F, 0.5F, 7.0F, 9.0F, 7.0F).mirror(), PartPose.offset(0.0F, 16.0F, -4.0F));
        partDefinition.addOrReplaceChild("back_hair", CubeListBuilder.create().texOffs(30, 8).addBox(-3.0F, 4.0F, 3.0F, 6.0F, 2.0F, 3.0F).mirror(), PartPose.offset(0.0F, 16.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_tooth", CubeListBuilder.create().texOffs(30, 5).addBox(0.0F, 1.0F, -9.5F, 0.0F, 7.0F, 8.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.0F, 0.5235988F));
        partDefinition.addOrReplaceChild("left_tooth", CubeListBuilder.create().texOffs(30, 5).addBox(0.0F, 1.0F, -9.5F, 0.0F, 7.0F, 8.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, 0.0F, 0.0F, -0.5235988F));
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 20).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 6.0F, 6.0F).mirror(), PartPose.offset(0.0F, 16F, 0.0F));
        partDefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(30, 0).addBox(-3.0F, 0.0F, 3.0F, 6.0F, 4.0F, 3.0F).mirror(), PartPose.offset(0.0F, 16.0F, 0.0F));
        partDefinition.addOrReplaceChild("nose_top", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, 1.0F, -3.5F, 2.0F, 4.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, -0.1897142F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("nose_bottom", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 5.0F, -1.5F, 2.0F, 3.0F, 2.0F).mirror(), PartPose.offsetAndRotation(0.0F, 15.5F, -1.5F, -0.5986789F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(1.5F, 17.0F, -1.0F));
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 17.0F, -1.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(-1.5F, 17.0F, 4.5F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F).mirror(), PartPose.offset(1.5F, 17.0F, 4.5F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(Mammoth mammoth, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        int swing = mammoth.getSwingTick();
        if (swing > 0) {
            this.noseTop.xRot = (-2.0F + 1.5F * this.swingTrunk((float) swing - headPitch, 10.0F) / 3) - 0.1897142F;
            this.noseBottom.xRot = (-2.0F + 1.5F * this.swingTrunk((float) swing - headPitch, 10.0F) / 3) - 0.5986789F;
        } else {
            this.noseTop.xRot = -0.1897142F;
            this.noseBottom.xRot = -0.5986789F;
        }
    }

    private float swingTrunk(float par1, float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int red, int green, int blue) {
        this.root.render(poseStack, vertexConsumer, red, green, blue);
    }
}
