package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class SmilodonAnimations {
    public static final AnimationDefinition SMILODON_WALK = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition SMILODON_SIT = AnimationDefinition.Builder.withLength(0f).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(-1f, -4.5f, -6f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(1f, -4.5f, -6f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -8f, -3f), AnimationChannel.Interpolations.LINEAR))).addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(70f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, 1f, 2f), AnimationChannel.Interpolations.LINEAR))).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION, new Keyframe(0f, KeyframeAnimations.posVec(0f, -3f, -1f), AnimationChannel.Interpolations.LINEAR))).addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(-45f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacySmilodonShakeModelPrep(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float partialTick) {
        float headAngle = dinosaurRenderState.getHeadRollAngle(partialTick) + dinosaurRenderState.getBodyRollAngle(partialTick, 0.0F);
        jsonTypeModel.setZRot("head", headAngle);
        jsonTypeModel.setZRot("right_ear", headAngle);
        jsonTypeModel.setZRot("left_ear", headAngle);
        jsonTypeModel.setZRot("left_tooth_bottom", headAngle);
        jsonTypeModel.setZRot("left_tooth_top", headAngle);
        jsonTypeModel.setZRot("right_tooth_bottom", headAngle);
        jsonTypeModel.setZRot("right_tooth_top", headAngle);
        jsonTypeModel.setZRot("snout", headAngle);
        jsonTypeModel.setZRot("jaw", headAngle);
        jsonTypeModel.setZRot("nose", headAngle);
        jsonTypeModel.setZRot("body", dinosaurRenderState.getBodyRollAngle(partialTick, -0.08F));
        jsonTypeModel.setZRot("back", dinosaurRenderState.getBodyRollAngle(partialTick, -0.16F));
        jsonTypeModel.setZRot("tail", dinosaurRenderState.getBodyRollAngle(partialTick, -0.2F));
    }


    static void legacySmilodonSitModelPrep(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaurRenderState.isOrderedToSit) {
            jsonTypeModel.setPos("body", 0.0F, 17.0F, 0.0F);
            jsonTypeModel.setXRot("body", -0.314F);
            jsonTypeModel.setYRot("body", 0.0F);
            jsonTypeModel.setPos("back", 0.0F, 20.0F, -1.0F);
            jsonTypeModel.setXRot("back", -0.7853982F);
            jsonTypeModel.setPos("tail", 0.0F, 23.0F, 4.5F);
            jsonTypeModel.setPos("left_front_leg", -1.5F, 25.0F, 1.0F);
            jsonTypeModel.setXRot("left_front_leg", 4.712389F);
            jsonTypeModel.setPos("left_back_leg", 1.5F, 25.0F, 1.0F);
            jsonTypeModel.setXRot("left_back_leg", 4.712389F);
            jsonTypeModel.setXRot("right_front_leg", 5.811947F);
            jsonTypeModel.setPos("right_front_leg", -1.5F, 20.0F, -2.0F);
            jsonTypeModel.setXRot("right_back_leg", 5.811947F);
            jsonTypeModel.setPos("right_back_leg", 1.5F, 20.0F, -2.0F);
        } else {
            jsonTypeModel.setPos("body", 0.0F, 15.0F, 0.0F);
            jsonTypeModel.setPos("back", 0.0F, 16.0F, 1.0F);
            jsonTypeModel.setXRot("back", 0.0F);
            jsonTypeModel.setXRot("body", jsonTypeModel.getXRot("back"));

            jsonTypeModel.setPos("tail", 0.0F, 14.0F, 6.5F);
            jsonTypeModel.setPos("left_front_leg", -1.5F, 19.0F, 6.0F);
            jsonTypeModel.setPos("left_back_leg", 1.5F, 19.0F, 6.0F);
            jsonTypeModel.setPos("right_front_leg", -1.5F, 19.0F, -2.0F);
            jsonTypeModel.setPos("right_back_leg", 1.5F, 19.0F, -2.0F);
        }
    }

    static void legacySmilodonTailAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setYRot("tail", Mth.cos(limbSwing * 0.6662f) * 1.4F * limbSwingAmount);
    }

    static void legacySmilodonWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setPos("body", 0.0F, 15.0F, 0.0F);
        jsonTypeModel.setPos("back", 0.0F, 16.0F, 1.0F);
        jsonTypeModel.setXRot("back", 0.0F);
        jsonTypeModel.setXRot("body", 0.0F);

        jsonTypeModel.setPos("tail", 0.0F, 14.0F, 6.5F);
        jsonTypeModel.setPos("left_front_leg", -1.5F, 19.0F, 6.0F);
        jsonTypeModel.setPos("left_back_leg", 1.5F, 19.0F, 6.0F);
        jsonTypeModel.setPos("right_front_leg", -1.5F, 19.0F, -2.0F);
        jsonTypeModel.setPos("right_back_leg", 1.5F, 19.0F, -2.0F);
        jsonTypeModel.setXRot("left_front_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_back_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_front_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_back_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }
}
