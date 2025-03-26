package willatendo.fossilslegacy.client.animation;

import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;

public final class DryosaurusAnimations {
    public static final JsonAnimation DRYOSAURUS_WALK = JsonAnimation.builder(1F).looping().addAnimation("right_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, 22.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, -22.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("left_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, -22.5F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, 22.5F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).build();
}
