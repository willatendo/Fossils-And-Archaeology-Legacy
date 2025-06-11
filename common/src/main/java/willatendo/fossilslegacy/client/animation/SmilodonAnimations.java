package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class SmilodonAnimations {
    public static final JsonAnimation SMILODON_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("left_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -32.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
    public static final JsonAnimation SMILODON_SIT = JsonAnimation.builder(0.0F).addAnimation("left_leg", "position", JsonKeyframe.create(0.0F, -1.0F, -4.5F, -6.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, -90.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "position", JsonKeyframe.create(0.0F, 1.0F, -4.5F, -6.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, -90.0F, 0.0F, 0.0F, "linear")).addAnimation("tail", "position", JsonKeyframe.create(0.0F, 0.0F, -8.0F, -3.0F, "linear")).addAnimation("tail", "rotation", JsonKeyframe.create(0.0F, 70.0F, 0.0F, 0.0F, "linear")).addAnimation("neck", "position", JsonKeyframe.create(0.0F, 0.0F, 1.0F, 2.0F, "linear")).addAnimation("body", "position", JsonKeyframe.create(0.0F, 0.0F, -3.0F, -1.0F, "linear")).addAnimation("body", "rotation", JsonKeyframe.create(0.0F, -45.0F, 0.0F, 0.0F, "linear")).build();

    static void legacySmilodonShakeModelPrep(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float partialTick) {
        float headAngle = dinosaurRenderState.getHeadRollAngle(partialTick) + dinosaurRenderState.getBodyRollAngle(partialTick, 0.0F);
        jsonTypeModel.setZRot("head", headAngle);
        jsonTypeModel.setZRot("right_ear", headAngle);
        jsonTypeModel.setZRot("left_ear", headAngle);
        jsonTypeModel.setZRot("left_tooth_bottom", headAngle);
        jsonTypeModel.setZRot("left_tooth_top", headAngle);
        jsonTypeModel.setZRot("right_tooth_bottom", headAngle);
        jsonTypeModel.setZRot("right_tooth_top", headAngle);
        jsonTypeModel.setZRot("snout", headAngle);
        jsonTypeModel.setZRot("jaw", headAngle);
        jsonTypeModel.setZRot("nose", headAngle);
        jsonTypeModel.setZRot("body", dinosaurRenderState.getBodyRollAngle(partialTick, -0.08F));
        jsonTypeModel.setZRot("back", dinosaurRenderState.getBodyRollAngle(partialTick, -0.16F));
        jsonTypeModel.setZRot("tail", dinosaurRenderState.getBodyRollAngle(partialTick, -0.2F));
    }

    static void legacySmilodonSitModelPrep(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        if (dinosaurRenderState.isOrderedToSit) {
            jsonTypeModel.setPos("body", 0.0F, 17.0F, 0.0F);
            jsonTypeModel.setXRot("body", -0.314F);
            jsonTypeModel.setYRot("body", 0.0F);
            jsonTypeModel.setPos("back", 0.0F, 20.0F, -1.0F);
            jsonTypeModel.setXRot("back", -0.7853982F);
            jsonTypeModel.setPos("tail", 0.0F, 23.0F, 4.5F);
            jsonTypeModel.setPos("left_front_leg", -1.5F, 25.0F, 1.0F);
            jsonTypeModel.setXRot("left_front_leg", 4.712389F);
            jsonTypeModel.setPos("left_back_leg", 1.5F, 25.0F, 1.0F);
            jsonTypeModel.setXRot("left_back_leg", 4.712389F);
            jsonTypeModel.setXRot("right_front_leg", 5.811947F);
            jsonTypeModel.setPos("right_front_leg", -1.5F, 20.0F, -2.0F);
            jsonTypeModel.setXRot("right_back_leg", 5.811947F);
            jsonTypeModel.setPos("right_back_leg", 1.5F, 20.0F, -2.0F);
        } else {
            jsonTypeModel.setPos("body", 0.0F, 15.0F, 0.0F);
            jsonTypeModel.setPos("back", 0.0F, 16.0F, 1.0F);
            jsonTypeModel.setXRot("back", 0.0F);
            jsonTypeModel.setXRot("body", jsonTypeModel.getXRot("back"));

            jsonTypeModel.setPos("tail", 0.0F, 14.0F, 6.5F);
            jsonTypeModel.setPos("left_front_leg", -1.5F, 19.0F, 6.0F);
            jsonTypeModel.setPos("left_back_leg", 1.5F, 19.0F, 6.0F);
            jsonTypeModel.setPos("right_front_leg", -1.5F, 19.0F, -2.0F);
            jsonTypeModel.setPos("right_back_leg", 1.5F, 19.0F, -2.0F);
        }
    }

    static void legacySmilodonTailAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setYRot("tail", Mth.cos(limbSwing * 0.6662f) * 1.4F * limbSwingAmount);
    }

    static void legacySmilodonWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setPos("body", 0.0F, 15.0F, 0.0F);
        jsonTypeModel.setPos("back", 0.0F, 16.0F, 1.0F);
        jsonTypeModel.setXRot("back", 0.0F);
        jsonTypeModel.setXRot("body", 0.0F);

        jsonTypeModel.setPos("tail", 0.0F, 14.0F, 6.5F);
        jsonTypeModel.setPos("left_front_leg", -1.5F, 19.0F, 6.0F);
        jsonTypeModel.setPos("left_back_leg", 1.5F, 19.0F, 6.0F);
        jsonTypeModel.setPos("right_front_leg", -1.5F, 19.0F, -2.0F);
        jsonTypeModel.setPos("right_back_leg", 1.5F, 19.0F, -2.0F);
        jsonTypeModel.setXRot("left_front_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_back_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_front_leg", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_back_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }
}
