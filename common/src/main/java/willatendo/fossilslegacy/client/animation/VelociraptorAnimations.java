package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class VelociraptorAnimations {
    public static final JsonAnimation VELOCIRAPTOR_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();

    static void legacyVelociraptorWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.9948377F);
        jsonTypeModel.setXRot("right_foot", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_hook_1", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 0.8726646F);
        jsonTypeModel.setXRot("right_hook_2", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - 2.617994F);
        jsonTypeModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.9948377F);
        jsonTypeModel.setXRot("left_foot", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_hook_1", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 0.8726646F);
        jsonTypeModel.setXRot("left_hook_2", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount - 2.617994F);
        jsonTypeModel.setXRot("right_bicep", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_hand", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount + 0.994461F);
        jsonTypeModel.setXRot("left_bicep", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_hand", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + 0.994461F);

        if (dinosaurRenderState.isMoving) {
            VelociraptorAnimations.tailUpper(jsonTypeModel);
        } else {
            VelociraptorAnimations.tailLower(jsonTypeModel);
        }

        if (dinosaurRenderState.isMoving) {
            VelociraptorAnimations.headLower(jsonTypeModel);
        } else {
            VelociraptorAnimations.headUpper(jsonTypeModel);
        }
    }

    private static void tailUpper(JsonTypeModel jsonTypeModel) {
        if (jsonTypeModel.getXRot("lower_body") < 0.0F) {
            jsonTypeModel.addXRot("lower_body", 0.5235988F / 10.0F);
        } else {
            jsonTypeModel.setXRot("lower_body", 0.0F);
        }

        if (jsonTypeModel.getXRot("tail") < 0.0F) {
            jsonTypeModel.addXRot("tail", 0.6981317F / 10.0F);
        } else {
            jsonTypeModel.setXRot("tail", 0.0F);
        }
    }

    private static void tailLower(JsonTypeModel jsonTypeModel) {
        if (jsonTypeModel.getXRot("lower_body") > -0.5235988F) {
            jsonTypeModel.subtractXRot("lower_body", 0.5235988F / 10.0F);
        } else {
            jsonTypeModel.setXRot("lower_body", -0.5235988F);
        }

        if (jsonTypeModel.getXRot("tail") > -0.6981317F) {
            jsonTypeModel.subtractXRot("tail", 0.6981317F / 10.0F);
        } else {
            jsonTypeModel.setXRot("tail", -0.6981317F);
        }
    }

    private static void headLower(JsonTypeModel jsonTypeModel) {
        if (jsonTypeModel.getZ("upper_body") < -3.0F) {
            jsonTypeModel.addZ("upper_body", 0.1F);
        } else {
            jsonTypeModel.setZ("upper_body", -3.0F);
        }

        if (jsonTypeModel.getXRot("upper_body") < 0.0F) {
            jsonTypeModel.addXRot("upper_body", 0.5235988F / 10.0F);
        } else {
            jsonTypeModel.setXRot("upper_body", 0.0F);
        }

        if (jsonTypeModel.getZ("neck") > -8.0F) {
            jsonTypeModel.subtractZ("neck", 3.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("neck", -8.0F);
        }

        if (jsonTypeModel.getXRot("neck") < 0.0F) {
            jsonTypeModel.addXRot("neck", 2.094395F / 10.0F);
        } else {
            jsonTypeModel.setXRot("neck", 0.0F);
        }

        if (jsonTypeModel.getY("head") < 15.0F) {
            jsonTypeModel.addY("head", 1.0F);
        } else {
            jsonTypeModel.setY("head", 15.0F);
        }

        if (jsonTypeModel.getZ("head") > -12.0F) {
            jsonTypeModel.subtractZ("head", 9.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("head", -12.0F);
        }

        if (jsonTypeModel.getY("snout") < 15.0F) {
            jsonTypeModel.addY("snout", 1.0F);
        } else {
            jsonTypeModel.setY("snout", 15.0F);
        }

        if (jsonTypeModel.getZ("snout") > -20.0F) {
            jsonTypeModel.subtractZ("snout", 9.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("snout", -20.0F);
        }

        if (jsonTypeModel.getY("jaw") < 15.0F) {
            jsonTypeModel.addY("jaw", 1.0F);
        } else {
            jsonTypeModel.setY("jaw", 15.0F);
        }

        if (jsonTypeModel.getZ("jaw") > -19.0F) {
            jsonTypeModel.subtractZ("jaw", 9.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("jaw", -19.0F);
        }
    }

    private static void headUpper(JsonTypeModel jsonTypeModel) {
        if (jsonTypeModel.getZ("upper_body") > -4.0F) {
            jsonTypeModel.subtractZ("upper_body", 0.1F);
        } else {
            jsonTypeModel.setZ("upper_body", -4.0F);
        }

        if (jsonTypeModel.getXRot("upper_body") > -0.5235988F) {
            jsonTypeModel.subtractXRot("upper_body", 0.5235988F / 10.0F);
        } else {
            jsonTypeModel.setXRot("upper_body", -0.5235988F);
        }

        if (jsonTypeModel.getZ("neck") < -5.0F) {
            jsonTypeModel.addZ("neck", 3.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("neck", -5.0F);
        }

        if (jsonTypeModel.getXRot("neck") > -2.094395F) {
            jsonTypeModel.subtractXRot("neck", 2.094395F / 10.0F);
        } else {
            jsonTypeModel.setXRot("neck", -2.094395F);
        }

        if (jsonTypeModel.getY("head") > 5.0F) {
            jsonTypeModel.subtractY("head", 1.0F);
        } else {
            jsonTypeModel.setY("head", 5.0F);
        }

        if (jsonTypeModel.getZ("head") < -3.0F) {
            jsonTypeModel.addZ("head", 9.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("head", -3.0F);
        }

        if (jsonTypeModel.getY("snout") > 5.0F) {
            jsonTypeModel.subtractY("snout", 1.0F);
        } else {
            jsonTypeModel.setY("snout", 5.0F);
        }

        if (jsonTypeModel.getZ("snout") < -11.0F) {
            jsonTypeModel.addZ("snout", 9.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("snout", -11.0F);
        }

        if (jsonTypeModel.getY("jaw") > 5.0F) {
            jsonTypeModel.subtractY("jaw", 1.0F);
        } else {
            jsonTypeModel.setY("jaw", 5.0F);
        }

        if (jsonTypeModel.getZ("jaw") < -10.0F) {
            jsonTypeModel.addZ("jaw", 9.0F / 10.0F);
        } else {
            jsonTypeModel.setZ("jaw", -10.0F);
        }
    }
}
