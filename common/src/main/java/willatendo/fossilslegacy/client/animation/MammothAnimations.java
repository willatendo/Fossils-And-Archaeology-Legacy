package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class MammothAnimations {
    public static final AnimationDefinition MAMMOTH_WALK = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(27.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("trunk", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("trunk_end", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyMammothWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setXRot("right_arm", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_arm", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("nose_top", -0.1897142F);
        jsonTypeModel.setXRot("nose_bottom", -0.5986789F);
    }
}
