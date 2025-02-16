package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class BrachiosaurusAnimations {
    //public static final JsonAnimation BRACHIOSAURUS_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("right_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();

    public static final JsonAnimation BRACHIOSAURUS_WALK = JsonAnimation.builder(1F).looping().addAnimation("right_arm", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("left_arm", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).build();

    static void legacyBrachiosaurusWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setXRot("front_left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("front_left_calf", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("front_right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("front_right_calf", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("back_left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("back_left_calf", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("back_right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("back_right_calf", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    }
}
