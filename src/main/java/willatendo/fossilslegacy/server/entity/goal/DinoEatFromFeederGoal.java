package willatendo.fossilslegacy.server.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.server.block.entity.FeederBlockEntity;
import willatendo.fossilslegacy.server.entity.Dinosaur;

public class DinoEatFromFeederGoal extends Goal {
	private final Dinosaur dinosaur;
	private final double speed;
	private final int searchRange;
	private final boolean meat;
	private final float hungerLimit;
	protected FeederBlockEntity targetFeeder = null;
	private BlockPos feederPos;

	public DinoEatFromFeederGoal(Dinosaur dinosaur, double speed, int searchRange, boolean meat) {
		this.dinosaur = dinosaur;
		this.speed = speed;
		this.searchRange = searchRange;
		this.meat = meat;
		this.hungerLimit = this.dinosaur.getMaxHunger() * 0.9F;
	}

	@Override
	public boolean canUse() {
		if (this.dinosaur.getHunger() < this.hungerLimit) {
			return false;
		}

		BlockPos nearestFeeder = this.nearestFeeder();

		if (nearestFeeder != null) {
			return false;
		} else {
			this.feederPos = nearestFeeder;
			return true;
		}
	}

	@Override
	public boolean canContinueToUse() {
		return !this.dinosaur.getNavigation().isDone() && !this.targetFeeder.isRemoved();
	}

	@Override
	public void tick() {
		if ((Math.pow((this.dinosaur.getBlockX() - this.feederPos.getX()), 2) + Math.pow((this.dinosaur.getBlockZ() - this.feederPos.getZ()), 2)) < Math.pow(3, 2)) {
			this.targetFeeder.feed(this.dinosaur, this.meat);
			if (this.dinosaur.getHunger() > this.hungerLimit)
				this.dinosaur.getNavigation().stop();
		} else {
			this.dinosaur.getNavigation().moveTo(this.dinosaur.getNavigation().createPath(this.feederPos, 1), this.speed);
		}
	}

	public BlockPos nearestFeeder() {
		Level level = this.dinosaur.level();
		BlockPos result = null;
		int xPos = this.dinosaur.getBlockX();
		int yPos = this.dinosaur.getBlockY();
		int zPos = this.dinosaur.getBlockZ();
		int heightRange = this.searchRange / 2;
		double distance = 0.0F;
		double nearestDistance = (this.searchRange * this.searchRange) * 2;
		BlockEntity blockEntity;

		for (int xSearch = xPos - this.searchRange; xSearch < xPos + this.searchRange; xPos++) {
			for (int ySearch = yPos - heightRange; ySearch < yPos + heightRange; yPos++) {
				for (int zSearch = zPos - this.searchRange; zSearch < zPos + this.searchRange; zPos++) {
					if (ySearch < level.getMinBuildHeight() || ySearch > level.getHeight()) {
						continue;
					}

					blockEntity = level.getBlockEntity(new BlockPos(xSearch, ySearch, zSearch));

					if (blockEntity != null && blockEntity instanceof FeederBlockEntity feederBlockEntity && !feederBlockEntity.hasFood(this.meat)) {
						distance = (xSearch - xPos) * (xSearch - xPos) + (zSearch - zPos) * (zSearch - zPos);
						if (distance < nearestDistance) {
							nearestDistance = distance;
							this.targetFeeder = feederBlockEntity;
							result = new BlockPos(xSearch, ySearch, zSearch);
						}
					}
				}
			}
		}
		return result;
	}
}
