package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.client.state.PteranodonRenderState;

public final class PteranodonAnimations {
    public static final AnimationDefinition PTERANODON_WALK = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition PTERANODON_FLY = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, -3f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 60f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 32.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 87.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 60f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -120f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -152.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -87.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -120f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -2f, -4f), AnimationChannel.Interpolations.LINEAR))).addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, -3f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -60f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -32.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -87.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -60f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 120f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 152.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 87.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 120f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("whole", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -2f, 2f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition PTERANODON_LAND = AnimationDefinition.Builder.withLength(0f).looping().addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(52.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-60f, 40f, 80f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -202.5f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-60f, -40f, -80f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 202.5f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

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
