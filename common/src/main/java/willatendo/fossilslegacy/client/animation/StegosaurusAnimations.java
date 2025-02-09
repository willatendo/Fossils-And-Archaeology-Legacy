package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class StegosaurusAnimations {
    public static final AnimationDefinition STEGOSAURUS_WALK = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(32.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyStegosaurusWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setYRot("tail_1", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        jsonTypeModel.setYRot("tail_2", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.436332312998582F * limbSwingAmount);
        jsonTypeModel.setYRot("tail_3", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        jsonTypeModel.setXRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setXRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setXRot("left_front_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        jsonTypeModel.setXRot("right_front_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.872664625997162F);
        jsonTypeModel.setXRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setXRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setXRot("left_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        jsonTypeModel.setYRot("left_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setXRot("right_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 1.22173047639603F);
        jsonTypeModel.setYRot("right_back_foot", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("back_plates_1", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.488692190558412F * limbSwingAmount);
        jsonTypeModel.setYRot("back_plates_2", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        jsonTypeModel.setZRot("back_plates_2", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setZRot("thagomizer", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setZRot("back_plates_3", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
    }
}
