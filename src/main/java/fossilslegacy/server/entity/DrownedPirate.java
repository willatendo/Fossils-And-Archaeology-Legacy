package fossilslegacy.server.entity;

import java.util.EnumSet;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

public class DrownedPirate extends Skeleton {
	public boolean searchingForLand;
	protected final WaterBoundPathNavigation waterNavigation;
	protected final GroundPathNavigation groundNavigation;

	public DrownedPirate(EntityType<? extends DrownedPirate> entityType, Level level) {
		super(entityType, level);
		this.setMaxUpStep(1.0F);
		this.moveControl = new DrownedPirate.DrownedPirateMoveControl(this);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		this.waterNavigation = new WaterBoundPathNavigation(this, level);
		this.groundNavigation = new GroundPathNavigation(this, level);
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
		super.populateDefaultEquipmentSlots(randomSource, difficultyInstance);
		this.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new DrownedPirate.DrownedPirateGoToWaterGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new DrownedPirate.DrownedPirateAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new DrownedPirate.DrownedPirateGoToBeachGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new DrownedPirate.DrownedPirateSwimUpGoal(this, 1.0D, this.level().getSeaLevel()));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::okTarget));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Axolotl.class, true, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return this.isInWater() ? SoundEvents.DROWNED_AMBIENT_WATER : SoundEvents.DROWNED_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource p_32386_) {
		return this.isInWater() ? SoundEvents.DROWNED_HURT_WATER : SoundEvents.DROWNED_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return this.isInWater() ? SoundEvents.DROWNED_DEATH_WATER : SoundEvents.DROWNED_DEATH;
	}

	@Override
	protected SoundEvent getStepSound() {
		return SoundEvents.DROWNED_STEP;
	}

	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.DROWNED_SWIM;
	}

	@Override
	public boolean isPushedByFluid() {
		return !this.isSwimming();
	}

	@Override
	public void travel(Vec3 vec3) {
		if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
			this.moveRelative(0.01F, vec3);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
		} else {
			super.travel(vec3);
		}
	}

	@Override
	public void updateSwimming() {
		if (!this.level().isClientSide) {
			if (this.isEffectiveAi() && this.isInWater() && this.wantsToSwim()) {
				this.navigation = this.waterNavigation;
				this.setSwimming(true);
			} else {
				this.navigation = this.groundNavigation;
				this.setSwimming(false);
			}
		}
	}

	protected boolean closeToNextPos() {
		Path path = this.getNavigation().getPath();
		if (path != null) {
			BlockPos blockPos = path.getTarget();
			if (blockPos != null) {
				double distance = this.distanceToSqr((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ());
				if (distance < 4.0D) {
					return true;
				}
			}
		}
		return false;
	}

	public void setSearchingForLand(boolean searchingForLand) {
		this.searchingForLand = searchingForLand;
	}

	public boolean wantsToSwim() {
		if (this.searchingForLand) {
			return true;
		} else {
			LivingEntity livingentity = this.getTarget();
			return livingentity != null && livingentity.isInWater();
		}
	}

	public boolean okTarget(LivingEntity livingEntity) {
		if (livingEntity != null) {
			return !this.level().isDay() || livingEntity.isInWater();
		} else {
			return false;
		}
	}

	public static class DrownedPirateAttackGoal extends MeleeAttackGoal {
		private final DrownedPirate drownedPirate;

		public DrownedPirateAttackGoal(DrownedPirate drownedPirate, double speedModifier, boolean followingTargetEvenIfNotSeen) {
			super(drownedPirate, speedModifier, followingTargetEvenIfNotSeen);
			this.drownedPirate = drownedPirate;
		}

		@Override
		public boolean canUse() {
			return super.canUse() && this.drownedPirate.okTarget(this.drownedPirate.getTarget());
		}

		@Override
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.drownedPirate.okTarget(this.drownedPirate.getTarget());
		}
	}

	public static class DrownedPirateGoToBeachGoal extends MoveToBlockGoal {
		private final DrownedPirate drownedPirate;

		public DrownedPirateGoToBeachGoal(DrownedPirate drownedPirate, double speedModifer) {
			super(drownedPirate, speedModifer, 8, 2);
			this.drownedPirate = drownedPirate;
		}

		@Override
		public boolean canUse() {
			return super.canUse() && !this.drownedPirate.level().isDay() && this.drownedPirate.isInWater() && this.drownedPirate.getY() >= (double) (this.drownedPirate.level().getSeaLevel() - 3);
		}

		@Override
		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		@Override
		protected boolean isValidTarget(LevelReader levelReader, BlockPos blockPos) {
			BlockPos above = blockPos.above();
			return levelReader.isEmptyBlock(above) && levelReader.isEmptyBlock(above.above()) ? levelReader.getBlockState(blockPos).entityCanStandOn(levelReader, blockPos, this.drownedPirate) : false;
		}

		@Override
		public void start() {
			this.drownedPirate.setSearchingForLand(false);
			this.drownedPirate.navigation = this.drownedPirate.groundNavigation;
			super.start();
		}

		@Override
		public void stop() {
			super.stop();
		}
	}

	public static class DrownedPirateGoToWaterGoal extends Goal {
		private final PathfinderMob mob;
		private double wantedX;
		private double wantedY;
		private double wantedZ;
		private final double speedModifier;
		private final Level level;

		public DrownedPirateGoToWaterGoal(PathfinderMob pathfinderMob, double sppedModifer) {
			this.mob = pathfinderMob;
			this.speedModifier = sppedModifer;
			this.level = pathfinderMob.level();
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean canUse() {
			if (!this.level.isDay()) {
				return false;
			} else if (this.mob.isInWater()) {
				return false;
			} else {
				Vec3 vec3 = this.getWaterPos();
				if (vec3 == null) {
					return false;
				} else {
					this.wantedX = vec3.x;
					this.wantedY = vec3.y;
					this.wantedZ = vec3.z;
					return true;
				}
			}
		}

		@Override
		public boolean canContinueToUse() {
			return !this.mob.getNavigation().isDone();
		}

		@Override
		public void start() {
			this.mob.getNavigation().moveTo(this.wantedX, this.wantedY, this.wantedZ, this.speedModifier);
		}

		private Vec3 getWaterPos() {
			RandomSource randomSource = this.mob.getRandom();
			BlockPos blockPos = this.mob.blockPosition();

			for (int places = 0; places < 10; ++places) {
				BlockPos blockpos1 = blockPos.offset(randomSource.nextInt(20) - 10, 2 - randomSource.nextInt(8), randomSource.nextInt(20) - 10);
				if (this.level.getBlockState(blockpos1).is(Blocks.WATER)) {
					return Vec3.atBottomCenterOf(blockpos1);
				}
			}

			return null;
		}
	}

	public static class DrownedPirateSwimUpGoal extends Goal {
		private final DrownedPirate drownedPirate;
		private final double speedModifier;
		private final int seaLevel;
		private boolean stuck;

		public DrownedPirateSwimUpGoal(DrownedPirate drownedPirate, double speedModifer, int seaLevel) {
			this.drownedPirate = drownedPirate;
			this.speedModifier = speedModifer;
			this.seaLevel = seaLevel;
		}

		@Override
		public boolean canUse() {
			return !this.drownedPirate.level().isDay() && this.drownedPirate.isInWater() && this.drownedPirate.getY() < (double) (this.seaLevel - 2);
		}

		@Override
		public boolean canContinueToUse() {
			return this.canUse() && !this.stuck;
		}

		@Override
		public void tick() {
			if (this.drownedPirate.getY() < (double) (this.seaLevel - 1) && (this.drownedPirate.getNavigation().isDone() || this.drownedPirate.closeToNextPos())) {
				Vec3 vec3 = DefaultRandomPos.getPosTowards(this.drownedPirate, 4, 8, new Vec3(this.drownedPirate.getX(), (double) (this.seaLevel - 1), this.drownedPirate.getZ()), (double) ((float) Math.PI / 2F));
				if (vec3 == null) {
					this.stuck = true;
					return;
				}
				this.drownedPirate.getNavigation().moveTo(vec3.x, vec3.y, vec3.z, this.speedModifier);
			}
		}

		@Override
		public void start() {
			this.drownedPirate.setSearchingForLand(true);
			this.stuck = false;
		}

		@Override
		public void stop() {
			this.drownedPirate.setSearchingForLand(false);
		}
	}

	public static class DrownedPirateMoveControl extends MoveControl {
		private final DrownedPirate drownedPirate;

		public DrownedPirateMoveControl(DrownedPirate drownedPirate) {
			super(drownedPirate);
			this.drownedPirate = drownedPirate;
		}

		@Override
		public void tick() {
			LivingEntity livingentity = this.drownedPirate.getTarget();
			if (this.drownedPirate.wantsToSwim() && this.drownedPirate.isInWater()) {
				if (livingentity != null && livingentity.getY() > this.drownedPirate.getY() || this.drownedPirate.searchingForLand) {
					this.drownedPirate.setDeltaMovement(this.drownedPirate.getDeltaMovement().add(0.0D, 0.002D, 0.0D));
				}

				if (this.operation != MoveControl.Operation.MOVE_TO || this.drownedPirate.getNavigation().isDone()) {
					this.drownedPirate.setSpeed(0.0F);
					return;
				}

				double d0 = this.wantedX - this.drownedPirate.getX();
				double d1 = this.wantedY - this.drownedPirate.getY();
				double d2 = this.wantedZ - this.drownedPirate.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
				d1 /= d3;
				float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
				this.drownedPirate.setYRot(this.rotlerp(this.drownedPirate.getYRot(), f, 90.0F));
				this.drownedPirate.yBodyRot = this.drownedPirate.getYRot();
				float f1 = (float) (this.speedModifier * this.drownedPirate.getAttributeValue(Attributes.MOVEMENT_SPEED));
				float f2 = Mth.lerp(0.125F, this.drownedPirate.getSpeed(), f1);
				this.drownedPirate.setSpeed(f2);
				this.drownedPirate.setDeltaMovement(this.drownedPirate.getDeltaMovement().add((double) f2 * d0 * 0.005D, (double) f2 * d1 * 0.1D, (double) f2 * d2 * 0.005D));
			} else {
				if (!this.drownedPirate.onGround()) {
					this.drownedPirate.setDeltaMovement(this.drownedPirate.getDeltaMovement().add(0.0D, -0.008D, 0.0D));
				}

				super.tick();
			}
		}
	}
}
