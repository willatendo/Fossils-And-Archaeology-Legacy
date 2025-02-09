package willatendo.fossilslegacy.server.entity.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.entity.entities.Dinosaur;
import willatendo.fossilslegacy.server.tags.FABlockTags;

import java.util.EnumSet;

public class DinoEatLeavesGoal extends Goal {
    private final Dinosaur dinosaur;
    private final Level level;
    private final float hungerLimit;
    private int eatAnimationTick = 0;

    public DinoEatLeavesGoal(Dinosaur dinosaur) {
        this.dinosaur = dinosaur;
        this.level = dinosaur.level();
        this.hungerLimit = (dinosaur.getMaxHunger() * 4) / 5;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        if (this.dinosaur.getHunger() >= this.hungerLimit) {
            return false;
        } else {
            BlockPos blockPos = this.dinosaur.blockPosition();
            return this.level.getBlockState(blockPos).is(FABlockTags.EATABLE_LEAVES);
        }
    }

    @Override
    public void start() {
        this.eatAnimationTick = 40;
        this.level.broadcastEntityEvent(this.dinosaur, (byte) 4);
        this.dinosaur.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.eatAnimationTick = 0;
    }

    @Override
    public boolean canContinueToUse() {
        return this.eatAnimationTick > 0;
    }

    @Override
    public void tick() {
        this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        if (this.eatAnimationTick != this.adjustedTickDelay(4)) {
            return;
        }
        BlockPos dinosaurPos = this.dinosaur.blockPosition();
        BlockPos eyePos = dinosaurPos.below().above((int) this.dinosaur.getEyeHeight());
        if (this.level.getBlockState(eyePos).is(FABlockTags.EATABLE_LEAVES)) {
            if (this.level instanceof ServerLevel serverLevel && serverLevel.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING)) {
                this.level.levelEvent(2001, eyePos, Block.getId(this.level.getBlockState(eyePos)));
                this.level.setBlock(eyePos, Blocks.AIR.defaultBlockState(), 2);
            }
            this.dinosaur.ate();
        }
    }
}
