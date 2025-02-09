package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class CrolophosaurusAnimations {
    public static final AnimationDefinition CRYOLOPHOSAURUS_WALK = AnimationDefinition.Builder.withLength(1.0F).looping().addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyCryolophosaurusWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }
}
