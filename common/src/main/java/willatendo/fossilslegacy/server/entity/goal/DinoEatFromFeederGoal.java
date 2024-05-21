package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlockTags;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.entity.Dinosaur;

import java.util.EnumSet;

public class DinoEatFromFeederGoal extends MoveToBlockGoal {
	protected final Dinosaur dinosaur;
	protected final boolean meat;
	protected final float hungerLimit;

	public DinoEatFromFeederGoal(Dinosaur dinosaur, double speedModifier, int searchRange, boolean meat) {
		super(dinosaur, speedModifier, searchRange);
		this.dinosaur = dinosaur;
		this.meat = meat;
		this.hungerLimit = (dinosaur.getMaxHunger() * 4) / 5;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
	}

	public DinoEatFromFeederGoal(Dinosaur dinosaur, double speedModifier, int searchRange, int eyeHeight, boolean meat) {
		super(dinosaur, speedModifier, searchRange, eyeHeight);
		this.dinosaur = dinosaur;
		this.meat = meat;
		this.hungerLimit = (dinosaur.getMaxHunger() * 4) / 5;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
	}

	@Override
	public boolean canUse() {
		return this.dinosaur.getHunger() < this.hungerLimit && super.canUse();
	}

	@Override
	public double acceptedDistance() {
		return 3.0D;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.isReachedTarget()) {
			((FeederBlockEntity) this.dinosaur.level().getBlockEntity(this.blockPos)).feed(this.dinosaur, this.meat);
			if (this.dinosaur.getHunger() > this.hungerLimit) {
				this.dinosaur.getNavigation().stop();
			}
		}

	}

	@Override
	protected boolean isValidTarget(LevelReader levelReader, BlockPos blockPos) {
		return levelReader.getBlockState(blockPos).is(FossilsLegacyBlockTags.FEEDER) && levelReader.getBlockEntity(blockPos) != null && levelReader.getBlockEntity(blockPos) instanceof FeederBlockEntity;
	}
}
