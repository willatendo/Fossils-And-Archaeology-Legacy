package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public final class VelociraptorAnimations {
    public static final AnimationDefinition VELOCIRAPTOR_WALK = AnimationDefinition.Builder.withLength(1.0F).looping().addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25F, KeyframeAnimations.degreeVec(-32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR), new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyVelociraptorWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.9948377F);
        jsonModel.setXRot("right_foot", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_hook_1", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.8726646F);
        jsonModel.setXRot("right_hook_2", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 2.617994F);
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.9948377F);
        jsonModel.setXRot("left_foot", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_hook_1", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.8726646F);
        jsonModel.setXRot("left_hook_2", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 2.617994F);
        jsonModel.setXRot("right_bicep", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_hand", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.994461F);
        jsonModel.setXRot("left_bicep", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_hand", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.994461F);

        if (Math.abs(jsonModel.getXRot("left_thigh")) >= 0.174532F) {
            VelociraptorAnimations.tailUpper(jsonModel);
        } else {
            VelociraptorAnimations.tailLower(jsonModel);
        }

        if (Math.abs(jsonModel.getXRot("left_thigh")) >= 0.174532F) {
            VelociraptorAnimations.headLower(jsonModel);
        } else {
            VelociraptorAnimations.headUpper(jsonModel);
        }
    }

    private static void tailUpper(JsonModel jsonModel) {
        if (jsonModel.getXRot("lower_body") < 0.0F) {
            jsonModel.addXRot("lower_body", 0.5235988F / 10.0F);
        } else {
            jsonModel.setXRot("lower_body", 0.0F);
        }

        if (jsonModel.getXRot("tail") < 0.0F) {
            jsonModel.addXRot("tail", 0.6981317F / 10.0F);
        } else {
            jsonModel.setXRot("tail", 0.0F);
        }
    }

    private static void tailLower(JsonModel jsonModel) {
        if (jsonModel.getXRot("lower_body") > -0.5235988F) {
            jsonModel.subtractXRot("lower_body", 0.5235988F / 10.0F);
        } else {
            jsonModel.setXRot("lower_body", -0.5235988F);
        }

        if (jsonModel.getXRot("tail") > -0.6981317F) {
            jsonModel.subtractXRot("tail", 0.6981317F / 10.0F);
        } else {
            jsonModel.setXRot("tail", -0.6981317F);
        }
    }

    private static void headLower(JsonModel jsonModel) {
        if (jsonModel.getZ("upper_body") < -3.0F) {
            jsonModel.addZ("upper_body", 0.1F);
        } else {
            jsonModel.setZ("upper_body", -3.0F);
        }

        if (jsonModel.getXRot("upper_body") < 0.0F) {
            jsonModel.addXRot("upper_body", 0.5235988F / 10.0F);
        } else {
            jsonModel.setXRot("upper_body", 0.0F);
        }

        if (jsonModel.getZ("neck") > -8.0F) {
            jsonModel.subtractZ("neck", 3.0F / 10.0F);
        } else {
            jsonModel.setZ("neck", -8.0F);
        }

        if (jsonModel.getXRot("neck") < 0.0F) {
            jsonModel.addXRot("neck", 2.094395F / 10.0F);
        } else {
            jsonModel.setXRot("neck", 0.0F);
        }

        if (jsonModel.getY("head") < 15.0F) {
            jsonModel.addY("head", 1.0F);
        } else {
            jsonModel.setY("head", 15.0F);
        }

        if (jsonModel.getZ("head") > -12.0F) {
            jsonModel.subtractZ("head", 9.0F / 10.0F);
        } else {
            jsonModel.setZ("head", -12.0F);
        }

        if (jsonModel.getY("snout") < 15.0F) {
            jsonModel.addY("snout", 1.0F);
        } else {
            jsonModel.setY("snout", 15.0F);
        }

        if (jsonModel.getZ("snout") > -20.0F) {
            jsonModel.subtractZ("snout", 9.0F / 10.0F);
        } else {
            jsonModel.setZ("snout", -20.0F);
        }

        if (jsonModel.getY("jaw") < 15.0F) {
            jsonModel.addY("jaw", 1.0F);
        } else {
            jsonModel.setY("jaw", 15.0F);
        }

        if (jsonModel.getZ("jaw") > -19.0F) {
            jsonModel.subtractZ("jaw", 9.0F / 10.0F);
        } else {
            jsonModel.setZ("jaw", -19.0F);
        }
    }

    private static void headUpper(JsonModel jsonModel) {
        if (jsonModel.getZ("upper_body") > -4.0F) {
            jsonModel.subtractZ("upper_body", 0.1F);
        } else {
            jsonModel.setZ("upper_body", -4.0F);
        }

        if (jsonModel.getXRot("upper_body") > -0.5235988F) {
            jsonModel.subtractXRot("upper_body", 0.5235988F / 10.0F);
        } else {
            jsonModel.setXRot("upper_body", -0.5235988F);
        }

        if (jsonModel.getZ("neck") < -5.0F) {
            jsonModel.addZ("neck", 3.0F / 10.0F);
        } else {
            jsonModel.setZ("neck", -5.0F);
        }

        if (jsonModel.getXRot("neck") > -2.094395F) {
            jsonModel.subtractXRot("neck", 2.094395F / 10.0F);
        } else {
            jsonModel.setXRot("neck", -2.094395F);
        }

        if (jsonModel.getY("head") > 5.0F) {
            jsonModel.subtractY("head", 1.0F);
        } else {
            jsonModel.setY("head", 5.0F);
        }

        if (jsonModel.getZ("head") < -3.0F) {
            jsonModel.addZ("head", 9.0F / 10.0F);
        } else {
            jsonModel.setZ("head", -3.0F);
        }

        if (jsonModel.getY("snout") > 5.0F) {
            jsonModel.subtractY("snout", 1.0F);
        } else {
            jsonModel.setY("snout", 5.0F);
        }

        if (jsonModel.getZ("snout") < -11.0F) {
            jsonModel.addZ("snout", 9.0F / 10.0F);
        } else {
            jsonModel.setZ("snout", -11.0F);
        }

        if (jsonModel.getY("jaw") > 5.0F) {
            jsonModel.subtractY("jaw", 1.0F);
        } else {
            jsonModel.setY("jaw", 5.0F);
        }

        if (jsonModel.getZ("jaw") < -10.0F) {
            jsonModel.addZ("jaw", 9.0F / 10.0F);
        } else {
            jsonModel.setZ("jaw", -10.0F);
        }
    }
}
