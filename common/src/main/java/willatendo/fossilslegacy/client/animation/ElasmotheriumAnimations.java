package willatendo.fossilslegacy.client.animation;

import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;

public final class ElasmotheriumAnimations {
    public static final JsonAnimation ELASMOTHERIUM_WALK = JsonAnimation.builder(1F).looping().addAnimation("back_left_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("front_left_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("front_right_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("back_right_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, -17.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, 17.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).build();
}
