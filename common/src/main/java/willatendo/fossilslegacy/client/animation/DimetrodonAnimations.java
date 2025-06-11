package willatendo.fossilslegacy.client.animation;

import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;

public final class DimetrodonAnimations {
    public static final JsonAnimation DIMETRODON_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("left_back_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_back_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("left_front_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_front_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -30.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
}
