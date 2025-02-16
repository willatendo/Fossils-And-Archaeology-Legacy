package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class MosasaurusAnimations {
    public static final JsonAnimation MOSASAURUS_SWIM = JsonAnimation.builder(4.0F).looping().addAnimation("tail", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 17.5F, 0.0F, "linear"), JsonKeyframe.create(3.0F, 0.0F, -17.5F, 0.0F, "linear"), JsonKeyframe.create(4.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_front_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 15.0F, 0.0F, "linear"), JsonKeyframe.create(3.0F, 0.0F, -15.0F, 0.0F, "linear"), JsonKeyframe.create(4.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_front_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, -15.0F, 0.0F, "linear"), JsonKeyframe.create(3.0F, 0.0F, 15.0F, 0.0F, "linear"), JsonKeyframe.create(4.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_back_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 15.0F, 0.0F, "linear"), JsonKeyframe.create(3.0F, 0.0F, -15.0F, 0.0F, "linear"), JsonKeyframe.create(4.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_back_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, -15.0F, 0.0F, "linear"), JsonKeyframe.create(3.0F, 0.0F, 15.0F, 0.0F, "linear"), JsonKeyframe.create(4.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
    public static final JsonAnimation MOSASAURUS_WALK = JsonAnimation.builder(1.0F).addAnimation("left_front_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, 90.0F, -40.0F, "linear"), JsonKeyframe.create(0.625F, 0.0F, 90.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_front_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, -90.0F, 40.0F, "linear"), JsonKeyframe.create(0.625F, 0.0F, -90.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_back_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, 90.0F, -40.0F, "linear"), JsonKeyframe.create(0.625F, 0.0F, 90.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_back_flipper", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 0.0F, -90.0F, 40.0F, "linear"), JsonKeyframe.create(0.625F, 0.0F, -90.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();

    static void legacyMosasaurusSwimAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setYRot("body", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.0872664625997165 * limbSwingAmount + 0));
        jsonTypeModel.setYRot("tail_1", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonTypeModel.setYRot("tail_2", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
        jsonTypeModel.setYRot("tail_3", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonTypeModel.setYRot("right_front_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -1.0471975511966));
        jsonTypeModel.setYRot("left_front_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 1.0471975511966));
        jsonTypeModel.setYRot("right_back_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * -0.174532925199433 * limbSwingAmount + -0.872664625997165));
        jsonTypeModel.setYRot("left_back_flipper", (float) (Mth.cos(limbSwing / (1.919107651F * 3)) * 0.174532925199433 * limbSwingAmount + 0.872664625997165));
        jsonTypeModel.setYRot("tail_3_spike", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * 0.174532925199433 * limbSwingAmount + 0));
        jsonTypeModel.setYRot("tail_2_spike", (float) (Mth.cos(limbSwing / (1.919107651F * 1)) * -0.174532925199433 * limbSwingAmount + 0));
    }
}
