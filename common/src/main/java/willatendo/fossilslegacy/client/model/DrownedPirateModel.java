package willatendo.fossilslegacy.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class DrownedPirateModel<S extends SkeletonRenderState> extends HumanoidModel<S> {
    public DrownedPirateModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer(CubeDeformation cubeDeformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(cubeDeformation, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        DrownedPirateModel.createDefaultDrownedPirateMesh(partDefinition);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    protected static void createDefaultDrownedPirateMesh(PartDefinition partDefinition) {
        partDefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(-5.0F, 2.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(5.0F, 2.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(-2.0F, 12.0F, 0.0F));
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(2.0F, 12.0F, 0.0F));
    }

    @Override
    public void setupAnim(S skeletonRenderState) {
        super.setupAnim(skeletonRenderState);
        if (skeletonRenderState.isAggressive && !skeletonRenderState.isHoldingBow) {
            float attackTime = skeletonRenderState.attackTime;
            float rightArm = Mth.sin(attackTime * 3.1415927F);
            float leftArm = Mth.sin((1.0F - (1.0F - attackTime) * (1.0F - attackTime)) * 3.1415927F);
            this.rightArm.zRot = 0.0F;
            this.leftArm.zRot = 0.0F;
            this.rightArm.yRot = -(0.1F - rightArm * 0.6F);
            this.leftArm.yRot = 0.1F - rightArm * 0.6F;
            this.rightArm.xRot = -1.5707964F;
            this.leftArm.xRot = -1.5707964F;
            ModelPart rightArmPart = this.rightArm;
            rightArmPart.xRot -= rightArm * 1.2F - leftArm * 0.4F;
            rightArmPart = this.leftArm;
            rightArmPart.xRot -= rightArm * 1.2F - leftArm * 0.4F;
            AnimationUtils.bobArms(this.rightArm, this.leftArm, skeletonRenderState.ageInTicks);
        }
    }

    @Override
    public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {
        this.root().translateAndRotate(poseStack);
        float arm = humanoidArm == HumanoidArm.RIGHT ? 1.0F : -1.0F;
        ModelPart modelpart = this.getArm(humanoidArm);
        modelpart.x += arm;
        modelpart.translateAndRotate(poseStack);
        modelpart.x -= arm;
    }
}
