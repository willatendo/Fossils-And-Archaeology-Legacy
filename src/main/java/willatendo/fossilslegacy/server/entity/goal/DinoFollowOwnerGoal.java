package willatendo.fossilslegacy.server.entity.goal;

import java.util.EnumSet;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import willatendo.fossilslegacy.server.entity.PlayerCommandable;
import willatendo.fossilslegacy.server.entity.TameAccessor;
import willatendo.fossilslegacy.server.utils.DinosaurOrder;

public class DinoFollowOwnerGoal extends Goal {
	private final Animal creature;
	private final PlayerCommandable playerCommandable;
	private final TameAccessor tameAccessor;
	private LivingEntity owner;
	private final LevelReader level;
	private final double speedModifier;
	private final PathNavigation navigation;
	private int timeToRecalcPath;
	private final float stopDistance;
	private final float startDistance;
	private float oldWaterCost;

	public DinoFollowOwnerGoal(Animal creature, PlayerCommandable playerCommandable, TameAccessor tameAccessor, double speedModifer, float startDistance, float stopDistance) {
		this.creature = creature;
		this.playerCommandable = playerCommandable;
		this.tameAccessor = tameAccessor;
		this.level = creature.level();
		this.speedModifier = speedModifer;
		this.navigation = creature.getNavigation();
		this.startDistance = startDistance;
		this.stopDistance = stopDistance;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	@Override
	public boolean canUse() {
		LivingEntity livingEntity = this.tameAccessor.getOwner();
		if (livingEntity == null) {
			return false;
		} else if (livingEntity.isSpectator()) {
			return false;
		} else if (this.playerCommandable.getCommand() == DinosaurOrder.FREE_MOVE) {
			return false;
		} else if (this.playerCommandable.getCommand() == DinosaurOrder.STAY) {
			return false;
		} else if (this.creature.distanceToSqr(livingEntity) < (double) (this.startDistance * this.startDistance)) {
			return false;
		} else {
			this.owner = livingEntity;
			return true;
		}
	}

	@Override
	public boolean canContinueToUse() {
		if (this.navigation.isDone()) {
			return false;
		} else if (this.playerCommandable.getCommand() == DinosaurOrder.FREE_MOVE) {
			return false;
		} else if (this.playerCommandable.getCommand() == DinosaurOrder.STAY) {
			return false;
		} else {
			return !(this.creature.distanceToSqr(this.owner) <= (double) (this.stopDistance * this.stopDistance));
		}
	}

	@Override
	public void start() {
		this.timeToRecalcPath = 0;
		this.oldWaterCost = this.creature.getPathfindingMalus(BlockPathTypes.WATER);
		this.creature.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	@Override
	public void stop() {
		this.owner = null;
		this.navigation.stop();
		this.creature.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
	}

	@Override
	public void tick() {
		this.creature.getLookControl().setLookAt(this.owner, 10.0F, (float) this.creature.getMaxHeadXRot());
		if (--this.timeToRecalcPath <= 0) {
			this.timeToRecalcPath = this.adjustedTickDelay(10);
			if (!this.creature.isLeashed() && !this.creature.isPassenger()) {
				if (this.creature.distanceToSqr(this.owner) >= 144.0D) {
					this.teleportToOwner();
				} else {
					this.navigation.moveTo(this.owner, this.speedModifier);
				}

			}
		}
	}

	private void teleportToOwner() {
		BlockPos blockPos = this.owner.blockPosition();

		for (int places = 0; places < 10; ++places) {
			int randomX = this.randomIntInclusive(-3, 3);
			int randomY = this.randomIntInclusive(-1, 1);
			int randomZ = this.randomIntInclusive(-3, 3);
			boolean flag = this.maybeTeleportTo(blockPos.getX() + randomX, blockPos.getY() + randomY, blockPos.getZ() + randomZ);
			if (flag) {
				return;
			}
		}
	}

	private boolean maybeTeleportTo(int x, int y, int z) {
		if (Math.abs((double) x - this.owner.getX()) < 2.0D && Math.abs((double) z - this.owner.getZ()) < 2.0D) {
			return false;
		} else if (!this.canTeleportTo(new BlockPos(x, y, z))) {
			return false;
		} else {
			this.creature.moveTo((double) x + 0.5D, (double) y, (double) z + 0.5D, this.creature.getYRot(), this.creature.getXRot());
			this.navigation.stop();
			return true;
		}
	}

	private boolean canTeleportTo(BlockPos blockPos) {
		BlockPathTypes blockPathTypes = WalkNodeEvaluator.getBlockPathTypeStatic(this.level, blockPos.mutable());
		if (blockPathTypes != BlockPathTypes.WALKABLE) {
			return false;
		} else {
			BlockState blockState = this.level.getBlockState(blockPos.below());
			if (blockState.getBlock() instanceof LeavesBlock) {
				return false;
			} else {
				BlockPos newBlockPos = blockPos.subtract(this.creature.blockPosition());
				return this.level.noCollision(this.creature, this.creature.getBoundingBox().move(newBlockPos));
			}
		}
	}

	private int randomIntInclusive(int min, int max) {
		return this.creature.getRandom().nextInt(max - min + 1) + min;
	}
}
