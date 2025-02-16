package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;
import willatendo.fossilslegacy.client.state.FutabasaurusRenderState;

public final class FutabasaurusAnimations {
    public static final JsonAnimation FUTABASAURUS_SWIM = JsonAnimation.builder(2.5F).looping().addAnimation("left_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, 0.0F, 25.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, -25.0F, "linear"), JsonKeyframe.create(2.5F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, 0.0F, 25.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, -25.0F, "linear"), JsonKeyframe.create(2.5F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, 0.0F, -25.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, 25.0F, "linear"), JsonKeyframe.create(2.5F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, 0.0F, -25.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, 25.0F, "linear"), JsonKeyframe.create(2.5F, 0.0F, 0.0F, 0.0F, "linear")).build();
    public static final JsonAnimation FUTABASAURUS_WALK = JsonAnimation.builder(1.5F).looping().addAnimation("left_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, 32.5F, -30.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 32.5F, 0.0F, "linear"), JsonKeyframe.create(1.25F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, -32.5F, 30.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, -32.5F, 0.0F, "linear"), JsonKeyframe.create(1.25F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.25F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, -32.5F, 30.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, -32.5F, 0.0F, "linear"), JsonKeyframe.create(1.5F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.25F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 32.5F, -30.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 32.5F, 0.0F, "linear"), JsonKeyframe.create(1.5F, 0.0F, 0.0F, 0.0F, "linear")).build();

    static void legacyFutabasaurusSwimAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaurRenderState instanceof FutabasaurusRenderState futabasaurusRenderState) {
            jsonTypeModel.setYRot("front_right_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.785398163397448 * limbSwingAmount + -2.35619449019234));
            jsonTypeModel.setYRot("back_right_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.785398163397448 * limbSwingAmount + -2.0943951023932));
            jsonTypeModel.setYRot("front_left_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.785398163397448 * limbSwingAmount + -0.785398163397448));
            jsonTypeModel.setYRot("back_left_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.785398163397448 * limbSwingAmount + -1.0471975511966));

            int steps = 16 + dinosaurRenderState.growthStage;
            if (futabasaurusRenderState.divePose) {
                FutabasaurusAnimations.divePose(jsonTypeModel, steps);
            } else {
                FutabasaurusAnimations.surfacePose(jsonTypeModel, steps);
            }
        }
    }


    static void divePose(JsonTypeModel jsonTypeModel, int steps) {
        if (jsonTypeModel.getXRot("neck_1") < -0.453F) {
            jsonTypeModel.addXRot("neck_1", 0.541F / steps);
        } else {
            jsonTypeModel.setXRot("neck_1", -0.453F);
        }

        if (jsonTypeModel.getXRot("neck_2") < -0.174F) {
            jsonTypeModel.addXRot("neck_2", 0.716F / steps);
        } else {
            jsonTypeModel.setXRot("neck_2", -0.174F);
        }

        if (jsonTypeModel.getXRot("neck_3") < -0.116F) {
            jsonTypeModel.addXRot("neck_3", 0.472F / steps);
        } else {
            jsonTypeModel.setXRot("neck_3", -0.116F);
        }

        if (jsonTypeModel.getXRot("neck_4") < -0.013F) {
            jsonTypeModel.addXRot("neck_4", 0.123F / steps);
        } else {
            jsonTypeModel.setXRot("neck_4", -0.013F);
        }

        if (jsonTypeModel.getXRot("head") > 0.009F) {
            jsonTypeModel.subtractXRot("head", 0.488F / steps);
        } else {
            jsonTypeModel.setXRot("head", 0.009F);
        }

        if (jsonTypeModel.getY("neck_2") < 18.0F) {
            jsonTypeModel.addY("neck_2", 2.0F / steps);
        } else {
            jsonTypeModel.setY("neck_2", 18.0F);
        }

        if (jsonTypeModel.getY("neck_3") < 17.7F) {
            jsonTypeModel.addY("neck_3", 5.0F / steps);
        } else {
            jsonTypeModel.setY("neck_3", 17.7F);
        }

        if (jsonTypeModel.getY("neck_4") < 17.0F) {
            jsonTypeModel.addY("neck_4", 7.0F / steps);
        } else {
            jsonTypeModel.setY("neck_4", 17.0F);
        }

        if (jsonTypeModel.getY("head") < 16.0F) {
            jsonTypeModel.addY("head", 7.0F / steps);
        } else {
            jsonTypeModel.setY("head", 16.0F);
        }

        if (jsonTypeModel.getZ("neck_2") < -3.0F) {
            jsonTypeModel.addZ("neck_2", 1.0F / steps);
        } else {
            jsonTypeModel.setZ("neck_2", -3.0F);
        }

        if (jsonTypeModel.getZ("neck_3") > -9.0F) {
            jsonTypeModel.subtractZ("neck_3", 1.0F / steps);
        } else {
            jsonTypeModel.setZ("neck_3", -9.0F);
        }

        if (jsonTypeModel.getZ("neck_4") > -13.0F) {
            jsonTypeModel.subtractZ("neck_4", 2.0F / steps);
        } else {
            jsonTypeModel.setZ("neck_4", -13.0F);
        }

        if (jsonTypeModel.getZ("head") > -18.0F) {
            jsonTypeModel.subtractZ("head", 3.0F / steps);
        } else {
            jsonTypeModel.setZ("head", -18.0F);
        }
    }

    static void surfacePose(JsonTypeModel jsonTypeModel, int steps) {
        if (jsonTypeModel.getXRot("neck_1") > -0.994F) {
            jsonTypeModel.subtractXRot("neck_1", 0.541F / steps);
        } else {
            jsonTypeModel.setXRot("neck_1", -0.994F);
        }

        if (jsonTypeModel.getXRot("neck_2") > -0.890F) {
            jsonTypeModel.subtractXRot("neck_2", 0.716F / steps);
        } else {
            jsonTypeModel.setXRot("neck_2", -0.890F);
        }

        if (jsonTypeModel.getXRot("neck_3") > -0.588F) {
            jsonTypeModel.subtractXRot("neck_3", 0.472F / steps);
        } else {
            jsonTypeModel.setXRot("neck_3", -0.588F);
        }

        if (jsonTypeModel.getXRot("neck_4") > -0.136F) {
            jsonTypeModel.subtractXRot("neck_4", 0.123F / steps);
        } else {
            jsonTypeModel.setXRot("neck_4", -0.136F);
        }

        if (jsonTypeModel.getXRot("head") < 0.497F) {
            jsonTypeModel.addXRot("head", 0.488F / steps);
        } else {
            jsonTypeModel.setXRot("head", 0.497F);
        }

        if (jsonTypeModel.getY("neck_2") > 16.0F) {
            jsonTypeModel.subtractY("neck_2", 2.0F / steps);
        } else {
            jsonTypeModel.setY("neck_2", 16.0F);
        }

        if (jsonTypeModel.getY("neck_3") > 12.7F) {
            jsonTypeModel.subtractY("neck_3", 5.0F / steps);
        } else {
            jsonTypeModel.setY("neck_3", 12.7F);
        }

        if (jsonTypeModel.getY("neck_4") > 10.0F) {
            jsonTypeModel.subtractY("neck_4", 7.0F / steps);
        } else {
            jsonTypeModel.setY("neck_4", 10.0F);
        }

        if (jsonTypeModel.getY("head") > 9.0F) {
            jsonTypeModel.subtractY("head", 7.0F / steps);
        } else {
            jsonTypeModel.setY("head", 9.0F);
        }

        if (jsonTypeModel.getZ("neck_2") > -4.0F) {
            jsonTypeModel.subtractZ("neck_2", 1.0F / steps);
        } else {
            jsonTypeModel.setZ("neck_2", -4.0F);
        }

        if (jsonTypeModel.getZ("neck_3") < -8.0F) {
            jsonTypeModel.addZ("neck_3", 1.0F / steps);
        } else {
            jsonTypeModel.setZ("neck_3", -8.0F);
        }

        if (jsonTypeModel.getZ("neck_4") < -11.0F) {
            jsonTypeModel.addZ("neck_4", 2.0F / steps);
        } else {
            jsonTypeModel.setZ("neck_4", -11.0F);
        }

        if (jsonTypeModel.getZ("head") < -15.0F) {
            jsonTypeModel.addZ("head", 3.0F / steps);
        } else {
            jsonTypeModel.setZ("head", -15.0F);
        }
    }
}
