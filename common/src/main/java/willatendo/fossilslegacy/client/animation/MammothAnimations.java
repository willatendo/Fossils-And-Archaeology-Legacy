package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class MammothAnimations {
    public static final JsonAnimation MAMMOTH_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 27.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("trunk", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 2.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -2.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("trunk_end", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 5.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -5.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();

    static void legacyMammothWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setXRot("right_arm", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_arm", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("right_leg", Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_leg", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("nose_top", -0.1897142F);
        jsonTypeModel.setXRot("nose_bottom", -0.5986789F);
    }
}
