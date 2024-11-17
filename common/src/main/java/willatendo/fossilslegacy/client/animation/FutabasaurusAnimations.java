package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;
import willatendo.fossilslegacy.server.entity.dinosaur.cretaceous.Futabasaurus;

public final class FutabasaurusAnimations {
    public static final AnimationDefinition FUTABASAURUS_SWIM = AnimationDefinition.Builder.withLength(2.5F).looping().addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 25.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition FUTABASAURUS_WALK = AnimationDefinition.Builder.withLength(1.5F).looping().addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 32.5F, -30.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 30.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 30.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 32.5F, -30.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 32.5F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyFutabasaurusSwimAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("front_right_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.785398163397448 * limbSwingAmount + -2.35619449019234));
        jsonModel.setYRot("back_right_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.785398163397448 * limbSwingAmount + -2.0943951023932));
        jsonModel.setYRot("front_left_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.785398163397448 * limbSwingAmount + -0.785398163397448));
        jsonModel.setYRot("back_left_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.785398163397448 * limbSwingAmount + -1.0471975511966));
    }

    static void legacyFutabasaurusDiveModelPrep(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        int steps = 16 + dinosaur.getGrowthStage();
        if (dinosaur instanceof Futabasaurus futabasaurus) {
            if (futabasaurus.divePose() && dinosaur.hasControllingPassenger()) {
                FutabasaurusAnimations.divePose(jsonModel, steps);
            } else {
                FutabasaurusAnimations.surfacePose(jsonModel, steps);
            }
        }
    }

    private static void divePose(JsonModel jsonModel, int steps) {
        if (jsonModel.getXRot("neck_1") < -0.453F) {
            jsonModel.addXRot("neck_1", 0.541F / steps);
        } else {
            jsonModel.setXRot("neck_1", -0.453F);
        }

        if (jsonModel.getXRot("neck_2") < -0.174F) {
            jsonModel.addXRot("neck_2", 0.716F / steps);
        } else {
            jsonModel.setXRot("neck_2", -0.174F);
        }

        if (jsonModel.getY("neck_2") < 18.0F) {
            jsonModel.addY("neck_2", 2.0F / steps);
        } else {
            jsonModel.setY("neck_2", 18.0F);
        }

        if (jsonModel.getZ("neck_2") < -3.0F) {
            jsonModel.addZ("neck_2", 1.0F / steps);
        } else {
            jsonModel.setZ("neck_2", -3.0F);
        }

        if (jsonModel.getXRot("neck_3") < -0.116F) {
            jsonModel.addXRot("neck_3", 0.472F / steps);
        } else {
            jsonModel.setXRot("neck_3", -0.116F);
        }

        if (jsonModel.getY("neck_3") < 17.7F) {
            jsonModel.addY("neck_3", 5.0F / steps);
        } else {
            jsonModel.setY("neck_3", 17.7F);
        }

        if (jsonModel.getZ("neck_3") > -9.0F) {
            jsonModel.subtractZ("neck_3", 1.0F / steps);
        } else {
            jsonModel.setZ("neck_3", -9.0F);
        }

        if (jsonModel.getXRot("neck_4") < -0.013F) {
            jsonModel.addXRot("neck_4", 0.123F / steps);
        } else {
            jsonModel.setXRot("neck_4", -0.013F);
        }

        if (jsonModel.getY("neck_4") < 17.0F) {
            jsonModel.addY("neck_4", 7.0F / steps);
        } else {
            jsonModel.setY("neck_4", 17.0F);
        }

        if (jsonModel.getZ("neck_4") > -13.0F) {
            jsonModel.subtractZ("neck_4", 2.0F / steps);
        } else {
            jsonModel.setZ("neck_4", -13.0F);
        }

        if (jsonModel.getXRot("head") > 0.009F) {
            jsonModel.subtractXRot("head", 0.488F / steps);
        } else {
            jsonModel.setXRot("head", 0.009F);
        }

        if (jsonModel.getY("head") < 16.0F) {
            jsonModel.addY("head", 7.0F / steps);
        } else {
            jsonModel.setY("head", 16.0F);
        }

        if (jsonModel.getZ("head") > -18.0F) {
            jsonModel.subtractZ("head", 3.0F / steps);
        } else {
            jsonModel.subtractZ("head", -18.0F);
        }
    }

    private static void surfacePose(JsonModel jsonModel, int steps) {
        if (jsonModel.getXRot("neck_1") > -0.994F) {
            jsonModel.subtractXRot("neck_1", 0.541F / steps);
        } else {
            jsonModel.setXRot("neck_1", -0.994F);
        }

        if (jsonModel.getXRot("neck_2") > -0.890F) {
            jsonModel.subtractXRot("neck_2", 0.716F / steps);
        } else {
            jsonModel.setXRot("neck_2", -0.890F);
        }

        if (jsonModel.getY("neck_2") > 16.0F) {
            jsonModel.subtractY("neck_2", 2.0F / steps);
        } else {
            jsonModel.setY("neck_2", 16.0F);
        }

        if (jsonModel.getZ("neck_2") > -4.0F) {
            jsonModel.subtractZ("neck_2", 1.0F / steps);
        } else {
            jsonModel.setZ("neck_2", -4.0F);
        }

        if (jsonModel.getXRot("neck_3") > -0.588F) {
            jsonModel.subtractXRot("neck_3", 0.472F / steps);
        } else {
            jsonModel.setXRot("neck_3", -0.588F);
        }

        if (jsonModel.getY("neck_3") > 12.7F) {
            jsonModel.subtractY("neck_3", 5.0F / steps);
        } else {
            jsonModel.setY("neck_3", 12.7F);
        }

        if (jsonModel.getZ("neck_3") < -8.0F) {
            jsonModel.addZ("neck_3", 1.0F / steps);
        } else {
            jsonModel.setZ("neck_3", -8.0F);
        }

        if (jsonModel.getXRot("neck_4") > -0.136F) {
            jsonModel.subtractXRot("neck_4", 0.123F / steps);
        } else {
            jsonModel.setXRot("neck_4", -0.136F);
        }

        if (jsonModel.getY("neck_4") > 10.0F) {
            jsonModel.subtractY("neck_4", 7.0F / steps);
        } else {
            jsonModel.setY("neck_4", 10.0F);
        }

        if (jsonModel.getZ("neck_4") < -11.0F) {
            jsonModel.addZ("neck_4", 2.0F / steps);
        } else {
            jsonModel.setZ("neck_4", -11.0F);
        }

        if (jsonModel.getXRot("head") < 0.497F) {
            jsonModel.addXRot("head", 0.488F / steps);
        } else {
            jsonModel.setXRot("head", 0.497F);
        }

        if (jsonModel.getY("head") > 9.0F) {
            jsonModel.subtractZ("head", 7.0F / steps);
        } else {
            jsonModel.setY("head", 9.0F);
        }

        if (jsonModel.getZ("head") < -15.0F) {
            jsonModel.addZ("head", 3.0F / steps);
        } else {
            jsonModel.setZ("head", -15.0F);
        }
    }
}
