package willatendo.fossilslegacy.client.animation;

import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;

public final class DodoAnimations {
    public static final JsonAnimation DODO_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -35.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 35.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 35.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -35.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
    public static final JsonAnimation DODO_FALL = JsonAnimation.builder(0.1667F).looping().addAnimation("left_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, -90.0F, "linear"), JsonKeyframe.create(0.0417F, 0.0F, 0.0F, -137.5F, "linear"), JsonKeyframe.create(0.125F, 0.0F, 0.0F, -47.5F, "linear"), JsonKeyframe.create(0.1667F, 0.0F, 0.0F, -90.0F, "linear")).addAnimation("right_arm", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 90.0F, "linear"), JsonKeyframe.create(0.0417F, 0.0F, 0.0F, 137.5F, "linear"), JsonKeyframe.create(0.125F, 0.0F, 0.0F, 47.5F, "linear"), JsonKeyframe.create(0.1667F, 0.0F, 0.0F, 90.0F, "linear")).build();
}
