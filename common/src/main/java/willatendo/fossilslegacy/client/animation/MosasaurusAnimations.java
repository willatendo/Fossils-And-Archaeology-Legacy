package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;

public final class MosasaurusAnimations {
    public static final AnimationDefinition MOSASAURUS_SWIM = AnimationDefinition.Builder.withLength(4f).looping().addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 17.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -17.5f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_front_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_front_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_back_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.degreeVec(0f, -15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_back_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, -15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(3f, KeyframeAnimations.degreeVec(0f, 15f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(4f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition MOSASAURUS_WALK = AnimationDefinition.Builder.withLength(1f).addAnimation("left_front_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 90f, -40f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 90f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_front_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -90f, 40f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, -90f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_back_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, 90f, -40f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, 90f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_back_flipper", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5f, KeyframeAnimations.degreeVec(0f, -90f, 40f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.625f, KeyframeAnimations.degreeVec(0f, -90f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyMosasaurusSwimAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("body", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.0872664625997165 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_1", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_2", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_3", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("right_front_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -1.0471975511966));
        jsonModel.setYRot("left_front_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 1.0471975511966));
        jsonModel.setYRot("right_back_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -0.872664625997165));
        jsonModel.setYRot("left_back_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 0.872664625997165));
        jsonModel.setYRot("tail_3_spike", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonModel.setYRot("tail_2_spike", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
    }
}
