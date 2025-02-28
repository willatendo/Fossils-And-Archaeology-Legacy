package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.goal.JumpGoal;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.jurassic.Ichthyosaurus;

public class IchthyosaurusJumpGoal extends JumpGoal {
    private static final int[] STEPS_TO_CHECK = new int[]{0, 1, 4, 5, 6, 7};
    private final Ichthyosaurus ichthyosaurus;
    private final int interval;
    private boolean breached;

    public IchthyosaurusJumpGoal(Ichthyosaurus ichthyosaurus, int interval) {
        this.ichthyosaurus = ichthyosaurus;
        this.interval = reducedTickDelay(interval);
    }

    @Override
    public boolean canUse() {
        if (this.ichthyosaurus.getRandom().nextInt(this.interval) != 0) {
            return false;
        } else {
            Direction direction = this.ichthyosaurus.getMotionDirection();
            int x = direction.getStepX();
            int z = direction.getStepZ();
            BlockPos blockpos = this.ichthyosaurus.blockPosition();

            for (int step : STEPS_TO_CHECK) {
                if (!this.waterIsClear(blockpos, x, z, step) || !this.surfaceIsClear(blockpos, x, z, step)) {
                    return false;
                }
            }

            return true;
        }
    }

    private boolean waterIsClear(BlockPos blockPos, int x, int z, int scale) {
        BlockPos blockPosAt = blockPos.offset(x * scale, 0, z * scale);
        return this.ichthyosaurus.level().getFluidState(blockPosAt).is(FluidTags.WATER) && !this.ichthyosaurus.level().getBlockState(blockPosAt).blocksMotion();
    }

    private boolean surfaceIsClear(BlockPos blockPos, int x, int z, int scale) {
        return this.ichthyosaurus.level().getBlockState(blockPos.offset(x * scale, 1, z * scale)).isAir() && this.ichthyosaurus.level().getBlockState(blockPos.offset(x * scale, 2, z * scale)).isAir();
    }

    @Override
    public boolean canContinueToUse() {
        double yMovement = this.ichthyosaurus.getDeltaMovement().y;
        return (!(yMovement * yMovement < 0.029999999329447746) || this.ichthyosaurus.getXRot() == 0.0F || !(Math.abs(this.ichthyosaurus.getXRot()) < 10.0F) || !this.ichthyosaurus.isInWater()) && !this.ichthyosaurus.onGround();
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void start() {
        Direction direction = this.ichthyosaurus.getMotionDirection();
        this.ichthyosaurus.setDeltaMovement(this.ichthyosaurus.getDeltaMovement().add((double) direction.getStepX() * 0.6, 0.7, (double) direction.getStepZ() * 0.6));
        this.ichthyosaurus.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.ichthyosaurus.setXRot(0.0F);
    }

    @Override
    public void tick() {
        boolean flag = this.breached;
        if (!flag) {
            FluidState fluidState = this.ichthyosaurus.level().getFluidState(this.ichthyosaurus.blockPosition());
            this.breached = fluidState.is(FluidTags.WATER);
        }

        if (this.breached && !flag) {
            this.ichthyosaurus.playSound(SoundEvents.DOLPHIN_JUMP, 1.0F, 1.0F);
        }

        Vec3 deltaMovement = this.ichthyosaurus.getDeltaMovement();
        if (deltaMovement.y * deltaMovement.y < 0.029999999329447746 && this.ichthyosaurus.getXRot() != 0.0F) {
            this.ichthyosaurus.setXRot(Mth.rotLerp(0.2F, this.ichthyosaurus.getXRot(), 0.0F));
        } else if (deltaMovement.length() > 9.999999747378752E-6) {
            double horizontalDistance = deltaMovement.horizontalDistance();
            double tan = Math.atan2(-deltaMovement.y, horizontalDistance) * 180.0 / 3.1415927410125732;
            this.ichthyosaurus.setXRot((float) tan);
        }

    }
}
