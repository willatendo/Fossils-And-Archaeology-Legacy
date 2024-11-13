package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.util.interfaces.FlyingDinosaur;

public final class PteranodonAnimations {
    public static final AnimationDefinition PTERANODON_WALK = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 25f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition PTERANODON_FLY = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, -3f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 60f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, 32.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 87.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 60f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -120f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, -152.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, -87.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -120f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -2f, -4f), AnimationChannel.Interpolations.LINEAR))).addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, -3f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, -60f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 0f, -32.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, -87.5f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, -60f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 120f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(0f, 152.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 87.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 120f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 2f), AnimationChannel.Interpolations.LINEAR))).addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition PTERANODON_LAND = AnimationDefinition.Builder.withLength(0f).looping().addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(52.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-60f, 40f, 80f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, -202.5f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-60f, -40f, -80f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_wing_tip", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 202.5f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    static void pteranodonFlyingAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
            if (flyingDinosaur.shouldFly() && !flyingDinosaur.shouldLand()) {
                float airPitch = (float) -(flyingDinosaur.getAirPitch() * (Math.PI / 180.0F));
                float airAngle = (float) -(flyingDinosaur.getAirAngle() * (Math.PI / 180.0F));

                jsonModel.setPos("root", 0.0F, 2.0F, 1.0F);
                jsonModel.setXRot("root", airPitch);
                jsonModel.setZRot("root", airAngle);
            }
        }
    }

    static void legacyPteranodonFlyingAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaur instanceof FlyingDinosaur flyingDinosaur) {
            float airPitch = (float) -(flyingDinosaur.getAirPitch() * (Math.PI / 180.0F));
            float airAngle = (float) -(flyingDinosaur.getAirAngle() * (Math.PI / 180.0F));

            jsonModel.setXRot("left_wing_1", -1.570796F + airPitch);
            jsonModel.setXRot("left_wing_1", -1.570796F + airPitch);
            jsonModel.setXRot("left_wing_2", 1.570796F + airPitch);
            jsonModel.setXRot("right_wing_1", 1.570796F - airPitch);
            jsonModel.setXRot("right_wing_2", -1.570796F - airPitch);
            jsonModel.setXRot("body", 1.570796F + airPitch);
            jsonModel.setXRot("neck_1", 1.570796F + airPitch);
            jsonModel.setXRot("neck_2", 1.570796F + airPitch);
            jsonModel.setXRot("tail", 1.570796F + airPitch);
            jsonModel.setXRot("crown", 0.4859298F + airPitch);
            jsonModel.setXRot("head", 1.570796F + airPitch);
            jsonModel.setXRot("upper_mouth", airPitch);
            jsonModel.setXRot("lower_mouth", 0.1356083F + airPitch);
            jsonModel.setXRot("left_leg", 1.570796F + airPitch);
            jsonModel.setXRot("right_leg", 1.570796F + airPitch);

            jsonModel.setZRot("body", airAngle);
            jsonModel.setZRot("neck_1", airAngle);
            jsonModel.setZRot("neck_2", airAngle);
            jsonModel.setZRot("left_wing_1", 2.792527F + airAngle);
            jsonModel.setZRot("left_wing_2", airAngle);
            jsonModel.setZRot("right_wing_1", -2.792527F + airAngle);
            jsonModel.setZRot("right_wing_2", airAngle);
            jsonModel.setZRot("tail", airAngle);
            jsonModel.setZRot("crown", airAngle);
            jsonModel.setZRot("head", airAngle);
            jsonModel.setZRot("upper_mouth", airAngle);
            jsonModel.setZRot("lower_mouth", airAngle);
            jsonModel.setZRot("left_leg", airAngle);
            jsonModel.setZRot("right_leg", airAngle);
        }
    }

    static void legacyPteranodonHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("crown", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("upper_mouth", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("lower_mouth", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("head", -netHeadYaw / 57.29578F);
    }

    static void legacyPteranodonWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.271F);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.271F);
    }
}
