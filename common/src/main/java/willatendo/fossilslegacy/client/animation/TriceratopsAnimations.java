package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public final class TriceratopsAnimations {
    public static final AnimationDefinition TRICERATOPS_WALK = AnimationDefinition.Builder.withLength(2.0F).looping().addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(-20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5F, KeyframeAnimations.degreeVec(20.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyTriceratopsWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("lower_body", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("back", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.261799387799149F * limbSwingAmount);
        jsonModel.setYRot("tail", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        jsonModel.setXRot("right_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("right_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("left_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("right_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("right_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonModel.setYRot("left_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonModel.setXRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonModel.setYRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
    }
}
