package willatendo.fossilslegacy.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.model.json.JsonModel;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public final class TyrannosaursAnimations {
    public static final AnimationDefinition TYRANNOSAURUS_WALK = AnimationDefinition.Builder.withLength(1f).looping().addAnimation("left_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).addAnimation("right_leg", new AnimationChannel(AnimationChannel.Targets.ROTATION, new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.25f, KeyframeAnimations.degreeVec(25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(0.75f, KeyframeAnimations.degreeVec(-25f, 0f, 0f), AnimationChannel.Interpolations.LINEAR), new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

    static void legacyTyrannosaurusHeadAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("head", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("snout", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("jaw", -netHeadYaw / 57.29578F);
    }

    static void legacyTyrannosaurusWalkAnimation(Dinosaur dinosaur, JsonModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.6108652F);
        jsonModel.setXRot("right_foot", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.6108652F);
        jsonModel.setXRot("left_foot", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);

        if (Math.abs(jsonModel.getXRot("right_thigh")) >= 0.174532F) {
            TyrannosaursAnimations.legacyTyrannosaurusRunPose(jsonModel);
        } else {
            TyrannosaursAnimations.legacyTyrannosaurusStandPose(jsonModel);
        }
    }

    private static void legacyTyrannosaurusRunPose(JsonModel jsonModel) {
        TyrannosaursAnimations.legacyTyrannosaurusRunPose(jsonModel, 20.0F);
    }

    private static void legacyTyrannosaurusRunPose(JsonModel jsonModel, float moves) {
        if (jsonModel.getY("body") > 7) {
            jsonModel.subtractY("body", 2.0F / moves);
        } else {
            jsonModel.setY("body", 7);
        }

        if (jsonModel.getZ("body") > -4) {
            jsonModel.subtractZ("body", 3.0F / moves);
        } else {
            jsonModel.setZ("body", -4);
        }

        if (jsonModel.getXRot("body") < 0) {
            jsonModel.addXRot("body", 0.9948377F / moves);
        } else {
            jsonModel.setXRot("body", 0);
        }

        if (jsonModel.getZ("neck") > 0) {
            jsonModel.subtractZ("neck", 2.0F / moves);
        } else {
            jsonModel.setZ("neck", 0);
        }

        if (jsonModel.getXRot("neck") < 0) {
            jsonModel.addXRot("neck", 0.4068249F / moves);
        } else {
            jsonModel.setXRot("neck", 0);
        }

        if (jsonModel.getY("right_arm") < 14) {
            jsonModel.addY("right_arm", 4.0F / moves);
        } else {
            jsonModel.setY("right_arm", 14);
        }

        if (jsonModel.getY("left_arm") < 14) {
            jsonModel.addY("left_arm", 4.0F / moves);
        } else {
            jsonModel.setY("left_arm", 14);
        }

        if (jsonModel.getXRot("tail_base") < -0.2260139F) {
            jsonModel.addXRot("tail_base", (0.7684471F - 0.2260139F) / moves);
        } else {
            jsonModel.setXRot("tail_base", -0.2260139F);
        }

        if (jsonModel.getY("tail_mid") > 11) {
            jsonModel.subtractY("tail_mid", 4.0F / moves);
        } else {
            jsonModel.setY("tail_mid", 11);
        }

        if (jsonModel.getZ("tail_mid") < 14) {
            jsonModel.addZ("tail_mid", 2.0F / moves);
        } else {
            jsonModel.setZ("tail_mid", 14);
        }

        if (jsonModel.getXRot("tail_mid") < -0.1356083F) {
            jsonModel.addXRot("tail_mid", (0.5424333F - 0.1356083F) / moves);
        } else {
            jsonModel.setXRot("tail_mid", -0.1356083F);
        }

        if (jsonModel.getY("tail_end") > 13) {
            jsonModel.subtractY("tail_end", 7.0F / moves);
        } else {
            jsonModel.setY("tail_end", 13);
        }

        if (jsonModel.getZ("tail_end") < 22) {
            jsonModel.addZRot("tail_end", 3.0F / moves);
        } else {
            jsonModel.setZ("tail_end", 22);
        }

        if (jsonModel.getXRot("tail_end") < 0) {
            jsonModel.addXRot("tail_end", 0.3616222F / moves);
        } else {
            jsonModel.setXRot("tail_end", 0);
        }

        if (jsonModel.getY("head") < 7) {
            jsonModel.addY("head", 7.0F / moves);
        } else {
            jsonModel.setY("head", 7);
        }

        if (jsonModel.getZ("head") > -14) {
            jsonModel.subtractZ("head", 6.0F / moves);
        } else {
            jsonModel.setZ("head", -14);
        }

        if (jsonModel.getY("snout") < 7) {
            jsonModel.addY("snout", 7.0F / moves);
        } else {
            jsonModel.setY("snout", 7);
        }

        if (jsonModel.getZ("snout") > -14) {
            jsonModel.subtractZ("snout", 6.0F / moves);
        } else {
            jsonModel.setZ("snout", -14);
        }

        if (jsonModel.getY("jaw") < 7) {
            jsonModel.addY("jaw", 6.0F / moves);
        } else {
            jsonModel.setY("jaw", 7);
        }

        if (jsonModel.getZ("jaw") > -14) {
            jsonModel.subtractZ("jaw", 6.0F / moves);
        } else {
            jsonModel.setZ("jaw", -14);
        }
    }

    private static void legacyTyrannosaurusStandPose(JsonModel jsonModel) {
        TyrannosaursAnimations.legacyTyrannosaurusStandPose(jsonModel, 20.0F);
    }

    private static void legacyTyrannosaurusStandPose(JsonModel jsonModel, float moves) {
        if (jsonModel.getY("body") < 9) {
            jsonModel.addY("body", 2.0F / moves);
        } else {
            jsonModel.setY("body", 9);
        }

        if (jsonModel.getZ("body") < -1) {
            jsonModel.addZ("body", 3.0F / moves);
        } else {
            jsonModel.setZ("body", -1);
        }

        if (jsonModel.getXRot("body") > -0.9948377F) {
            jsonModel.subtractXRot("body", 0.9948377F / moves);
        } else {
            jsonModel.setXRot("body", -0.9948377F);
        }

        if (jsonModel.getZ("neck") < 2) {
            jsonModel.addZ("neck", 2.0F / moves);
        } else {
            jsonModel.setZ("neck", 2);
        }

        if (jsonModel.getXRot("neck") > -0.4068249F) {
            jsonModel.subtractXRot("neck", 0.4068249F / moves);
        } else {
            jsonModel.setXRot("neck", -0.4068249F);
        }

        if (jsonModel.getY("right_arm") > 10) {
            jsonModel.subtractY("right_arm", 4.0F / moves);
        } else {
            jsonModel.setY("right_arm", 10);
        }

        if (jsonModel.getY("left_arm") > 10) {
            jsonModel.subtractY("left_arm", 4.0F / moves);
        } else {
            jsonModel.setY("left_arm", 10);
        }

        if (jsonModel.getXRot("tail_base") > -0.7684471F) {
            jsonModel.subtractXRot("tail_base", (0.7684471F - 0.2260139F) / moves);
        } else {
            jsonModel.setXRot("tail_base", -0.7684471F);
        }

        if (jsonModel.getY("tail_mid") < 15) {
            jsonModel.addY("tail_mid", 4.0F / moves);
        } else {
            jsonModel.setY("tail_mid", 15);
        }

        if (jsonModel.getZ("tail_mid") > 12) {
            jsonModel.subtractZ("tail_mid", 2.0F / moves);
        } else {
            jsonModel.setZ("tail_mid", 12);
        }

        if (jsonModel.getXRot("tail_mid") > -0.5424333F) {
            jsonModel.subtractXRot("tail_mid", (0.5424333F - 0.1356083F) / moves);
        } else {
            jsonModel.setXRot("tail_mid", -0.5424333F);
        }

        if (jsonModel.getY("tail_end") < 20) {
            jsonModel.addY("tail_end", 7.0F / moves);
        } else {
            jsonModel.setY("tail_end", 20);
        }

        if (jsonModel.getZ("tail_end") > 19) {
            jsonModel.addZ("tail_end", 3.0F / moves);
        } else {
            jsonModel.setX("tail_end", 19);
        }

        if (jsonModel.getXRot("tail_end") < -0.3616222F) {
            jsonModel.addXRot("tail_end", (0.3616222F - 2.8368E-15F) / moves);
        } else {
            jsonModel.setXRot("tail_end", -0.3616222F);
        }

        if (jsonModel.getY("head") > 0) {
            jsonModel.subtractY("head", 7.0F / moves);
        } else {
            jsonModel.setY("head", 0);
        }

        if (jsonModel.getZ("head") < -8) {
            jsonModel.addZ("head", 6.0F / moves);
        } else {
            jsonModel.setZ("head", -8);
        }

        if (jsonModel.getY("snout") > 1) {
            jsonModel.subtractY("snout", 7.0F / moves);
        } else {
            jsonModel.setY("snout", 1);
        }

        if (jsonModel.getZ("snout") < -8) {
            jsonModel.addZ("snout", 6.0F / moves);
        } else {
            jsonModel.setZ("snout", -8);
        }

        if (jsonModel.getY("jaw") > 1) {
            jsonModel.subtractY("jaw", 6.0F / moves);
        } else {
            jsonModel.setY("jaw", 1);
        }

        if (jsonModel.getZ("jaw") < -8) {
            jsonModel.addZ("jaw", 6.0F / moves);
        } else {
            jsonModel.setZ("jaw", -8);
        }
    }
}
