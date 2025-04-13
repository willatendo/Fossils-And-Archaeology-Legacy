package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class TriceratopsAnimations {
    public static final JsonAnimation TRICERATOPS_WALK = JsonAnimation.builder(2.0F).looping().addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, -10.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.5F, 10.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 10.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.5F, -10.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, 20.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.5F, -20.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.5F, -20.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.5F, 20.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(2.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
    public static final JsonAnimation TRICERATOPS_SLEEP = JsonAnimation.builder(0F).addAnimation("right_leg", "position", JsonKeyframe.create(0F, 0F, -7F, 0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0F, 90F, 0F, 0F, "linear")).addAnimation("left_leg", "position", JsonKeyframe.create(0F, 0F, -7F, 0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0F, 90F, 0F, 0F, "linear")).addAnimation("tail", "position", JsonKeyframe.create(0F, 0F, -3F, 0F, "linear")).addAnimation("tail", "rotation", JsonKeyframe.create(0F, -17.5F, 0F, 0F, "linear")).addAnimation("head", "position", JsonKeyframe.create(0F, 0F, -3F, 0F, "linear")).addAnimation("head", "rotation", JsonKeyframe.create(0F, 27.5F, 0F, 0F, "linear")).addAnimation("right_arm", "position", JsonKeyframe.create(0F, 0F, -5F, 0F, "linear")).addAnimation("right_arm", "rotation", JsonKeyframe.create(0F, -75F, 0F, 0F, "linear")).addAnimation("left_arm", "position", JsonKeyframe.create(0F, 0F, -5F, 0F, "linear")).addAnimation("left_arm", "rotation", JsonKeyframe.create(0F, -75F, 0F, 0F, "linear")).addAnimation("body", "position", JsonKeyframe.create(0F, 0F, -3F, 0F, "linear")).build();

    static void legacyTriceratopsWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setYRot("lower_body", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("back", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.261799387799149F * limbSwingAmount);
        jsonTypeModel.setYRot("tail", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.349065850398866F * limbSwingAmount);
        jsonTypeModel.setXRot("right_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("right_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonTypeModel.setXRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonTypeModel.setYRot("right_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonTypeModel.setXRot("left_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("left_front_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonTypeModel.setXRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonTypeModel.setYRot("left_front_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonTypeModel.setXRot("right_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("right_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonTypeModel.setXRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonTypeModel.setYRot("right_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonTypeModel.setXRot("left_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount);
        jsonTypeModel.setYRot("left_back_thigh", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
        jsonTypeModel.setXRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * -0.174532925199433F * limbSwingAmount + 0.994460983870151F);
        jsonTypeModel.setYRot("left_back_leg", Mth.cos(limbSwing / (1.919107651F * 0.5F)) * 0.0872664625997165F * limbSwingAmount);
    }
}
