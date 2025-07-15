package willatendo.fossilslegacy.client.animation;

import willatendo.fossilslegacy.client.animation.json.JsonAnimation;
import willatendo.fossilslegacy.client.animation.json.JsonKeyframe;

public final class DistortusRexAnimations {
    public static final JsonAnimation DISTORTUS_REX_WALK = JsonAnimation.builder(1F).looping().addAnimation("right_front_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, 15F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, -15F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("left_front_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, -15F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, 15F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("left_back_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, 15F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, -15F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).addAnimation("right_back_leg", "rotation", JsonKeyframe.create(0F, 0F, 0F, 0F, "linear"), JsonKeyframe.create(0.25F, -15F, 0F, 0F, "linear"), JsonKeyframe.create(0.75F, 15F, 0F, 0F, "linear"), JsonKeyframe.create(1F, 0F, 0F, 0F, "linear")).build();
}
