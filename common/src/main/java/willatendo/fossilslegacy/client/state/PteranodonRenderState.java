package willatendo.fossilslegacy.client.state;

import net.minecraft.world.entity.AnimationState;

public class PteranodonRenderState extends DinosaurRenderState {
    public boolean shouldFly;
    public boolean shouldLand;
    public float airPitch;
    public float airAngle;
    public AnimationState flyingAnimationState;
    public AnimationState landAnimationState;
}
