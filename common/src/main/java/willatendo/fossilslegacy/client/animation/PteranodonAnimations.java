package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.client.state.PteranodonRenderState;

public final class PteranodonAnimations {
    public static final JsonAnimation PTERANODON_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("right_wing", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 0.0F, -25.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 25.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_wing", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 0.0F, -25F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 25F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
    public static final JsonAnimation PTERANODON_FLY = JsonAnimation.builder(1.0F).looping().addAnimation("right_wing", "position", JsonKeyframe.create(0.0F, 0.0F, -1.0F, -3.0F, "linear")).addAnimation("right_wing", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 60.0F, "linear"), JsonKeyframe.create(0.25F, 0.0F, 0.0F, 32.5F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 0.0F, 87.5F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 60.0F, "linear")).addAnimation("right_wing_tip", "rotation", JsonKeyframe.create(0.0F, 0.0F, -120.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 0.0F, -152.5F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, -87.5F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, -120.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 90.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 90.0F, 0.0F, 0.0F, "linear")).addAnimation("body", "rotation", JsonKeyframe.create(0.0F, 45.0F, 0.0F, 0.0F, "linear")).addAnimation("neck", "position", JsonKeyframe.create(0.0F, 0.0F, -2.0F, -4.0F, "linear")).addAnimation("neck", "rotation", JsonKeyframe.create(0.0F, 90.0F, 0.0F, 0.0F, "linear")).addAnimation("left_wing", "position", JsonKeyframe.create(0.0F, 0.0F, -1.0F, -3.0F, "linear")).addAnimation("left_wing", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, -60.0F, "linear"), JsonKeyframe.create(0.25F, 0.0F, 0.0F, -32.5F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 0.0F, -87.5F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, -60.0F, "linear")).addAnimation("left_wing_tip", "rotation", JsonKeyframe.create(0.0F, 0.0F, 120.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 0.0F, 152.5F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 87.5F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 120.0F, 0.0F, "linear")).addAnimation("head", "position", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 2.0F, "linear")).addAnimation("head", "rotation", JsonKeyframe.create(0.0F, -90.0F, 0.0F, 0.0F, "linear")).addAnimation("whole", "position", JsonKeyframe.create(0.0F, 0.0F, -2.0F, 2.0F, "linear")).build();
    public static final JsonAnimation PTERANODON_LAND = JsonAnimation.builder(0.0F).looping().addAnimation("neck", "rotation", JsonKeyframe.create(0.0F, 52.5F, 0.0F, 0.0F, "linear")).addAnimation("right_wing", "rotation", JsonKeyframe.create(0.0F, -60.0F, 40.0F, 80.0F, "linear")).addAnimation("right_wing_tip", "rotation", JsonKeyframe.create(0.0F, 0.0F, -202.5F, 0.0F, "linear")).addAnimation("left_wing", "rotation", JsonKeyframe.create(0.0F, -60.0F, -40.0F, -80.0F, "linear")).addAnimation("left_wing_tip", "rotation", JsonKeyframe.create(0.0F, 0.0F, 202.5F, 0.0F, "linear")).build();

    static void pteranodonFlyingAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaurRenderState instanceof PteranodonRenderState pteranodonRenderState) {
            if (pteranodonRenderState.shouldFly && !pteranodonRenderState.shouldLand) {
                float airPitch = (float) -(pteranodonRenderState.airPitch * (Math.PI / 180.0F));
                float airAngle = (float) -(pteranodonRenderState.airAngle * (Math.PI / 180.0F));
                jsonTypeModel.setXRot("whole", airPitch);
                jsonTypeModel.setZRot("whole", airAngle);
            }
        }
    }

    static void legacyPteranodonFlyingAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaurRenderState instanceof PteranodonRenderState pteranodonRenderState) {
            float airPitch = (float) -(pteranodonRenderState.airPitch * (Math.PI / 180.0F));
            float airAngle = (float) -(pteranodonRenderState.airAngle * (Math.PI / 180.0F));

            jsonTypeModel.setXRot("left_wing_1", -1.570796F + airPitch);
            jsonTypeModel.setXRot("left_wing_1", -1.570796F + airPitch);
            jsonTypeModel.setXRot("left_wing_2", 1.570796F + airPitch);
            jsonTypeModel.setXRot("right_wing_1", 1.570796F - airPitch);
            jsonTypeModel.setXRot("right_wing_2", -1.570796F - airPitch);
            jsonTypeModel.setXRot("body", 1.570796F + airPitch);
            jsonTypeModel.setXRot("neck_1", 1.570796F + airPitch);
            jsonTypeModel.setXRot("neck_2", 1.570796F + airPitch);
            jsonTypeModel.setXRot("tail", 1.570796F + airPitch);
            jsonTypeModel.setXRot("crown", 0.4859298F + airPitch);
            jsonTypeModel.setXRot("head", 1.570796F + airPitch);
            jsonTypeModel.setXRot("upper_mouth", airPitch);
            jsonTypeModel.setXRot("lower_mouth", 0.1356083F + airPitch);
            jsonTypeModel.setXRot("left_leg", 1.570796F + airPitch);
            jsonTypeModel.setXRot("right_leg", 1.570796F + airPitch);

            jsonTypeModel.setZRot("body", airAngle);
            jsonTypeModel.setZRot("neck_1", airAngle);
            jsonTypeModel.setZRot("neck_2", airAngle);
            jsonTypeModel.setZRot("left_wing_1", 2.792527F + airAngle);
            jsonTypeModel.setZRot("left_wing_2", airAngle);
            jsonTypeModel.setZRot("right_wing_1", -2.792527F + airAngle);
            jsonTypeModel.setZRot("right_wing_2", airAngle);
            jsonTypeModel.setZRot("tail", airAngle);
            jsonTypeModel.setZRot("crown", airAngle);
            jsonTypeModel.setZRot("head", airAngle);
            jsonTypeModel.setZRot("upper_mouth", airAngle);
            jsonTypeModel.setZRot("lower_mouth", airAngle);
            jsonTypeModel.setZRot("left_leg", airAngle);
            jsonTypeModel.setZRot("right_leg", airAngle);
        }
    }

    static void legacyPteranodonHeadAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setYRot("crown", -netHeadYaw / 57.29578F);
        jsonTypeModel.setYRot("upper_mouth", -netHeadYaw / 57.29578F);
        jsonTypeModel.setYRot("lower_mouth", -netHeadYaw / 57.29578F);
        jsonTypeModel.setYRot("head", -netHeadYaw / 57.29578F);
    }

    static void legacyPteranodonWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.271F);
        jsonTypeModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.271F);
    }
}
