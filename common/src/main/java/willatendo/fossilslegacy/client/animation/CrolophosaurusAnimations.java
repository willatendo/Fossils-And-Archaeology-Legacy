package willatendo.fossilslegacy.client.animation;

import net.minecraft.util.Mth;
import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;
import willatendo.fossilslegacy.client.model.json.JsonTypeModel;
import willatendo.fossilslegacy.client.state.DinosaurRenderState;

public final class CrolophosaurusAnimations {
    public static final JsonAnimation CRYOLOPHOSAURUS_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -25.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 25.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 25.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -25.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();

    static void legacyCryolophosaurusWalkAnimation(DinosaurRenderState dinosaurRenderState, JsonTypeModel jsonTypeModel, float limbSwing, float limbSwingAmount, float netHeadYaw) {
        jsonTypeModel.setXRot("right_thigh", Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
        jsonTypeModel.setXRot("left_thigh", Mth.cos(limbSwing * 0.6662F + 3.141593F) * 1.4F * limbSwingAmount);
    }
}
