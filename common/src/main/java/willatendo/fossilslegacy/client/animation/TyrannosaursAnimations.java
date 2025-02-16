package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class TyrannosaursAnimations {
    public static final JsonAnimation TYRANNOSAURUS_WALK = JsonAnimation.builder(2f).looping().addAnimation("left_leg", "rotation", JsonKeyframe.create(0f, 0f, 0f, 0f, "linear"), JsonKeyframe.create(0.5f, -35f, 0f, 0f, "linear"), JsonKeyframe.create(1.5f, 35f, 0f, 0f, "linear"), JsonKeyframe.create(2f, 0f, 0f, 0f, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0f, 0f, 0f, 0f, "linear"), JsonKeyframe.create(0.5f, 35f, 0f, 0f, "linear"), JsonKeyframe.create(1.5f, -35f, 0f, 0f, "linear"), JsonKeyframe.create(2f, 0f, 0f, 0f, "linear")).build();

    static void legacyTyrannosaurusHeadAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonModel.setYRot("head", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("snout", -netHeadYaw / 57.29578F);
        jsonModel.setYRot("jaw", -netHeadYaw / 57.29578F);
    }

    static void legacyTyrannosaurusWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
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

    private static void legacyTyrannosaurusRunPose(JsonTypeModel jsonTypeModel) {
        TyrannosaursAnimations.legacyTyrannosaurusRunPose(jsonTypeModel, 20.0F);
    }

    private static void legacyTyrannosaurusRunPose(JsonTypeModel jsonTypeModel, float moves) {
        if (jsonTypeModel.getY("body") > 7) {
            jsonTypeModel.subtractY("body", 2.0F / moves);
        } else {
            jsonTypeModel.setY("body", 7);
        }

        if (jsonTypeModel.getZ("body") > -4) {
            jsonTypeModel.subtractZ("body", 3.0F / moves);
        } else {
            jsonTypeModel.setZ("body", -4);
        }

        if (jsonTypeModel.getXRot("body") < 0) {
            jsonTypeModel.addXRot("body", 0.9948377F / moves);
        } else {
            jsonTypeModel.setXRot("body", 0);
        }

        if (jsonTypeModel.getZ("neck") > 0) {
            jsonTypeModel.subtractZ("neck", 2.0F / moves);
        } else {
            jsonTypeModel.setZ("neck", 0);
        }

        if (jsonTypeModel.getXRot("neck") < 0) {
            jsonTypeModel.addXRot("neck", 0.4068249F / moves);
        } else {
            jsonTypeModel.setXRot("neck", 0);
        }

        if (jsonTypeModel.getY("right_arm") < 14) {
            jsonTypeModel.addY("right_arm", 4.0F / moves);
        } else {
            jsonTypeModel.setY("right_arm", 14);
        }

        if (jsonTypeModel.getY("left_arm") < 14) {
            jsonTypeModel.addY("left_arm", 4.0F / moves);
        } else {
            jsonTypeModel.setY("left_arm", 14);
        }

        if (jsonTypeModel.getXRot("tail_base") < -0.2260139F) {
            jsonTypeModel.addXRot("tail_base", (0.7684471F - 0.2260139F) / moves);
        } else {
            jsonTypeModel.setXRot("tail_base", -0.2260139F);
        }

        if (jsonTypeModel.getY("tail_mid") > 11) {
            jsonTypeModel.subtractY("tail_mid", 4.0F / moves);
        } else {
            jsonTypeModel.setY("tail_mid", 11);
        }

        if (jsonTypeModel.getZ("tail_mid") < 14) {
            jsonTypeModel.addZ("tail_mid", 2.0F / moves);
        } else {
            jsonTypeModel.setZ("tail_mid", 14);
        }

        if (jsonTypeModel.getXRot("tail_mid") < -0.1356083F) {
            jsonTypeModel.addXRot("tail_mid", (0.5424333F - 0.1356083F) / moves);
        } else {
            jsonTypeModel.setXRot("tail_mid", -0.1356083F);
        }

        if (jsonTypeModel.getY("tail_end") > 13) {
            jsonTypeModel.subtractY("tail_end", 7.0F / moves);
        } else {
            jsonTypeModel.setY("tail_end", 13);
        }

        if (jsonTypeModel.getZ("tail_end") < 22) {
            jsonTypeModel.addZRot("tail_end", 3.0F / moves);
        } else {
            jsonTypeModel.setZ("tail_end", 22);
        }

        if (jsonTypeModel.getXRot("tail_end") < 0) {
            jsonTypeModel.addXRot("tail_end", 0.3616222F / moves);
        } else {
            jsonTypeModel.setXRot("tail_end", 0);
        }

        if (jsonTypeModel.getY("head") < 7) {
            jsonTypeModel.addY("head", 7.0F / moves);
        } else {
            jsonTypeModel.setY("head", 7);
        }

        if (jsonTypeModel.getZ("head") > -14) {
            jsonTypeModel.subtractZ("head", 6.0F / moves);
        } else {
            jsonTypeModel.setZ("head", -14);
        }

        if (jsonTypeModel.getY("snout") < 7) {
            jsonTypeModel.addY("snout", 7.0F / moves);
        } else {
            jsonTypeModel.setY("snout", 7);
        }

        if (jsonTypeModel.getZ("snout") > -14) {
            jsonTypeModel.subtractZ("snout", 6.0F / moves);
        } else {
            jsonTypeModel.setZ("snout", -14);
        }

        if (jsonTypeModel.getY("jaw") < 7) {
            jsonTypeModel.addY("jaw", 6.0F / moves);
        } else {
            jsonTypeModel.setY("jaw", 7);
        }

        if (jsonTypeModel.getZ("jaw") > -14) {
            jsonTypeModel.subtractZ("jaw", 6.0F / moves);
        } else {
            jsonTypeModel.setZ("jaw", -14);
        }
    }

    private static void legacyTyrannosaurusStandPose(JsonTypeModel jsonTypeModel) {
        TyrannosaursAnimations.legacyTyrannosaurusStandPose(jsonTypeModel, 20.0F);
    }

    private static void legacyTyrannosaurusStandPose(JsonTypeModel jsonTypeModel, float moves) {
        if (jsonTypeModel.getY("body") < 9) {
            jsonTypeModel.addY("body", 2.0F / moves);
        } else {
            jsonTypeModel.setY("body", 9);
        }

        if (jsonTypeModel.getZ("body") < -1) {
            jsonTypeModel.addZ("body", 3.0F / moves);
        } else {
            jsonTypeModel.setZ("body", -1);
        }

        if (jsonTypeModel.getXRot("body") > -0.9948377F) {
            jsonTypeModel.subtractXRot("body", 0.9948377F / moves);
        } else {
            jsonTypeModel.setXRot("body", -0.9948377F);
        }

        if (jsonTypeModel.getZ("neck") < 2) {
            jsonTypeModel.addZ("neck", 2.0F / moves);
        } else {
            jsonTypeModel.setZ("neck", 2);
        }

        if (jsonTypeModel.getXRot("neck") > -0.4068249F) {
            jsonTypeModel.subtractXRot("neck", 0.4068249F / moves);
        } else {
            jsonTypeModel.setXRot("neck", -0.4068249F);
        }

        if (jsonTypeModel.getY("right_arm") > 10) {
            jsonTypeModel.subtractY("right_arm", 4.0F / moves);
        } else {
            jsonTypeModel.setY("right_arm", 10);
        }

        if (jsonTypeModel.getY("left_arm") > 10) {
            jsonTypeModel.subtractY("left_arm", 4.0F / moves);
        } else {
            jsonTypeModel.setY("left_arm", 10);
        }

        if (jsonTypeModel.getXRot("tail_base") > -0.7684471F) {
            jsonTypeModel.subtractXRot("tail_base", (0.7684471F - 0.2260139F) / moves);
        } else {
            jsonTypeModel.setXRot("tail_base", -0.7684471F);
        }

        if (jsonTypeModel.getY("tail_mid") < 15) {
            jsonTypeModel.addY("tail_mid", 4.0F / moves);
        } else {
            jsonTypeModel.setY("tail_mid", 15);
        }

        if (jsonTypeModel.getZ("tail_mid") > 12) {
            jsonTypeModel.subtractZ("tail_mid", 2.0F / moves);
        } else {
            jsonTypeModel.setZ("tail_mid", 12);
        }

        if (jsonTypeModel.getXRot("tail_mid") > -0.5424333F) {
            jsonTypeModel.subtractXRot("tail_mid", (0.5424333F - 0.1356083F) / moves);
        } else {
            jsonTypeModel.setXRot("tail_mid", -0.5424333F);
        }

        if (jsonTypeModel.getY("tail_end") < 20) {
            jsonTypeModel.addY("tail_end", 7.0F / moves);
        } else {
            jsonTypeModel.setY("tail_end", 20);
        }

        if (jsonTypeModel.getZ("tail_end") > 19) {
            jsonTypeModel.addZ("tail_end", 3.0F / moves);
        } else {
            jsonTypeModel.setX("tail_end", 19);
        }

        if (jsonTypeModel.getXRot("tail_end") < -0.3616222F) {
            jsonTypeModel.addXRot("tail_end", (0.3616222F - 2.8368E-15F) / moves);
        } else {
            jsonTypeModel.setXRot("tail_end", -0.3616222F);
        }

        if (jsonTypeModel.getY("head") > 0) {
            jsonTypeModel.subtractY("head", 7.0F / moves);
        } else {
            jsonTypeModel.setY("head", 0);
        }

        if (jsonTypeModel.getZ("head") < -8) {
            jsonTypeModel.addZ("head", 6.0F / moves);
        } else {
            jsonTypeModel.setZ("head", -8);
        }

        if (jsonTypeModel.getY("snout") > 1) {
            jsonTypeModel.subtractY("snout", 7.0F / moves);
        } else {
            jsonTypeModel.setY("snout", 1);
        }

        if (jsonTypeModel.getZ("snout") < -8) {
            jsonTypeModel.addZ("snout", 6.0F / moves);
        } else {
            jsonTypeModel.setZ("snout", -8);
        }

        if (jsonTypeModel.getY("jaw") > 1) {
            jsonTypeModel.subtractY("jaw", 6.0F / moves);
        } else {
            jsonTypeModel.setY("jaw", 1);
        }

        if (jsonTypeModel.getZ("jaw") < -8) {
            jsonTypeModel.addZ("jaw", 6.0F / moves);
        } else {
            jsonTypeModel.setZ("jaw", -8);
        }
    }
}
