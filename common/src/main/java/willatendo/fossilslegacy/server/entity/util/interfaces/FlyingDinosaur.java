package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.world.entity.AnimationState;

public interface FlyingDinosaur {
    float getAirPitch();

    float getAirAngle();

    boolean shouldFly();

    boolean shouldLand();

    AnimationState getFlyingAnimationState();

    AnimationState getLandingAnimationState();
}
