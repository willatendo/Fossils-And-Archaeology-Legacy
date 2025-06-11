package willatendo.fossilslegacy.client.animation;

import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;

public final class SpinosaurusAnimations {
    public static final JsonAnimation SPINOSAURUS_WALK = JsonAnimation.builder(1.0F).looping().addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, -17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, -17.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
    public static final JsonAnimation SPINOSAURUS_SWIM = JsonAnimation.builder(1.0F).addAnimation("left_leg", "rotation", JsonKeyframe.create(0.0F, 62.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 50.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 75.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 62.5F, 0.0F, 0.0F, "linear")).addAnimation("right_leg", "rotation", JsonKeyframe.create(0.0F, 62.5F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 75.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 50.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 62.5F, 0.0F, 0.0F, "linear")).addAnimation("tail", "rotation", JsonKeyframe.create(0.0F, 0.0F, 0.0F, 0.0F, "linear"), JsonKeyframe.create(0.25F, 0.0F, -12.5F, 0.0F, "linear"), JsonKeyframe.create(0.75F, 0.0F, 12.5F, 0.0F, "linear"), JsonKeyframe.create(1.0F, 0.0F, 0.0F, 0.0F, "linear")).build();
}
