package willatendo.fossilslegacy.server.entity;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;

public class ZombifiedPigman extends ZombifiedPiglin implements OwnableEntity {
	protected static final EntityDataAccessor<Byte> FLAGS = SynchedEntityData.defineId(ZombifiedPigman.class, EntityDataSerializers.BYTE);
	protected static final EntityDataAccessor<Optional<UUID>> OWNER_UUID = SynchedEntityData.defineId(ZombifiedPigman.class, EntityDataSerializers.OPTIONAL_UUID);

	public ZombifiedPigman(EntityType<? extends ZombifiedPigman> zombiePigman, Level level) {
		super(zombiePigman, level);
		this.reassessTameGoals();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(6, new ZombifiedPigman.FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.targetSelector.addGoal(1, new ZombifiedPigman.OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ZombifiedPigman.OwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(FLAGS, (byte) 0);
		this.entityData.define(OWNER_UUID, Optional.empty());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		if (this.getOwnerUUID() != null) {
			compoundTag.putUUID("Owner", this.getOwnerUUID());
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		UUID uuid;
		if (compoundTag.hasUUID("Owner")) {
			uuid = compoundTag.getUUID("Owner");
		} else {
			String s = compoundTag.getString("Owner");
			uuid = OldUsersConverter.convertMobOwnerIfNecessary(this.getServer(), s);
		}

		if (uuid != null) {
			try {
				this.setOwnerUUID(uuid);
				this.setTame(true);
			} catch (Throwable throwable) {
				this.setTame(false);
			}
		}
	}

	@Override
	public boolean canBeLeashed(Player player) {
		return !this.isLeashed();
	}

	protected void spawnTamingParticles(boolean susceeds) {
		ParticleOptions particleoptions = ParticleTypes.HEART;
		if (!susceeds) {
			particleoptions = ParticleTypes.SMOKE;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = this.random.nextGaussian() * 0.02D;
			double d1 = this.random.nextGaussian() * 0.02D;
			double d2 = this.random.nextGaussian() * 0.02D;
			this.level().addParticle(particleoptions, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), d0, d1, d2);
		}

	}

	@Override
	public void handleEntityEvent(byte event) {
		if (event == 7) {
			this.spawnTamingParticles(true);
		} else if (event == 6) {
			this.spawnTamingParticles(false);
		} else {
			super.handleEntityEvent(event);
		}

	}

	public boolean isTame() {
		return (this.entityData.get(FLAGS) & 4) != 0;
	}

	public void setTame(boolean tame) {
		byte b0 = this.entityData.get(FLAGS);
		if (tame) {
			this.entityData.set(FLAGS, (byte) (b0 | 4));
		} else {
			this.entityData.set(FLAGS, (byte) (b0 & -5));
		}

		this.reassessTameGoals();
	}

	protected void reassessTameGoals() {
	}

	public boolean isInSittingPose() {
		return (this.entityData.get(FLAGS) & 1) != 0;
	}

	public void setInSittingPose(boolean p_21838_) {
		byte b0 = this.entityData.get(FLAGS);
		if (p_21838_) {
			this.entityData.set(FLAGS, (byte) (b0 | 1));
		} else {
			this.entityData.set(FLAGS, (byte) (b0 & -2));
		}

	}

	@Override
	public UUID getOwnerUUID() {
		return this.entityData.get(OWNER_UUID).orElse((UUID) null);
	}

	public void setOwnerUUID(UUID uuid) {
		this.entityData.set(OWNER_UUID, Optional.ofNullable(uuid));
	}

	public void tame(Player player) {
		this.setTame(true);
		this.setOwnerUUID(player.getUUID());
		if (player instanceof ServerPlayer) {
			FossilsLegacyCriteriaTriggers.TAME_ZOMBIFIED_PIGMAN_TRIGGER.trigger((ServerPlayer) player, this);
		}
	}

	@Override
	public boolean canAttack(LivingEntity livingEntity) {
		return this.isOwnedBy(livingEntity) ? false : super.canAttack(livingEntity);
	}

	public boolean isOwnedBy(LivingEntity livingEntity) {
		return livingEntity == this.getOwner();
	}

	public boolean wantsToAttack(LivingEntity target, LivingEntity owner) {
		return true;
	}

	@Override
	public boolean isAlliedTo(Entity entity) {
		if (this.isTame()) {
			LivingEntity owner = this.getOwner();
			if (entity == owner) {
				return true;
			}

			if (owner != null) {
				return owner.isAlliedTo(entity);
			}
		}

		return super.isAlliedTo(entity);
	}

	@Override
	public void die(DamageSource damageSource) {
		Component deathMessage = this.getCombatTracker().getDeathMessage();
		super.die(damageSource);

		if (this.dead) {
			if (!this.level().isClientSide() && this.level().getGameRules().getBoolean(GameRules.RULE_SHOWDEATHMESSAGES) && this.getOwner() instanceof ServerPlayer) {
				this.getOwner().sendSystemMessage(deathMessage);
			}
		}
	}

	@Override
	protected boolean isSunBurnTick() {
		return false;
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
	}

	class FollowOwnerGoal extends Goal {
		private final ZombifiedPigman tamable;
		private LivingEntity owner;
		private final LevelReader level;
		private final double speedModifier;
		private final PathNavigation navigation;
		private int timeToRecalcPath;
		private final float stopDistance;
		private final float startDistance;
		private float oldWaterCost;
		private final boolean canFly;

		public FollowOwnerGoal(ZombifiedPigman zombifiedPigman, double speedModifier, float startDistance, float stopDistance, boolean canFly) {
			this.tamable = zombifiedPigman;
			this.level = zombifiedPigman.level();
			this.speedModifier = speedModifier;
			this.navigation = zombifiedPigman.getNavigation();
			this.startDistance = startDistance;
			this.stopDistance = stopDistance;
			this.canFly = canFly;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
			if (!(zombifiedPigman.getNavigation() instanceof GroundPathNavigation) && !(zombifiedPigman.getNavigation() instanceof FlyingPathNavigation)) {
				throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
			}
		}

		@Override
		public boolean canUse() {
			LivingEntity livingEntity = this.tamable.getOwner();
			if (livingEntity == null) {
				return false;
			} else if (livingEntity.isSpectator()) {
				return false;
			} else if (this.unableToMove()) {
				return false;
			} else if (this.tamable.distanceToSqr(livingEntity) < (double) (this.startDistance * this.startDistance)) {
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
			} else if (this.unableToMove()) {
				return false;
			} else {
				return !(this.tamable.distanceToSqr(this.owner) <= (double) (this.stopDistance * this.stopDistance));
			}
		}

		private boolean unableToMove() {
			return this.tamable.isPassenger() || this.tamable.isLeashed();
		}

		@Override
		public void start() {
			this.timeToRecalcPath = 0;
			this.oldWaterCost = this.tamable.getPathfindingMalus(BlockPathTypes.WATER);
			this.tamable.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		}

		@Override
		public void stop() {
			this.owner = null;
			this.navigation.stop();
			this.tamable.setPathfindingMalus(BlockPathTypes.WATER, this.oldWaterCost);
		}

		@Override
		public void tick() {
			this.tamable.getLookControl().setLookAt(this.owner, 10.0F, (float) this.tamable.getMaxHeadXRot());
			if (--this.timeToRecalcPath <= 0) {
				this.timeToRecalcPath = this.adjustedTickDelay(10);
				if (this.tamable.distanceToSqr(this.owner) >= 144.0D) {
					this.teleportToOwner();
				} else {
					this.navigation.moveTo(this.owner, this.speedModifier);
				}

			}
		}

		private void teleportToOwner() {
			BlockPos blockPos = this.owner.blockPosition();

			for (int i = 0; i < 10; ++i) {
				int xOffset = this.randomIntInclusive(-3, 3);
				int yOffset = this.randomIntInclusive(-1, 1);
				int zOffset = this.randomIntInclusive(-3, 3);
				boolean flag = this.maybeTeleportTo(blockPos.getX() + xOffset, blockPos.getY() + yOffset, blockPos.getZ() + zOffset);
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
				this.tamable.moveTo((double) x + 0.5D, (double) y, (double) z + 0.5D, this.tamable.getYRot(), this.tamable.getXRot());
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
				if (!this.canFly && blockState.getBlock() instanceof LeavesBlock) {
					return false;
				} else {
					BlockPos animalPos = blockPos.subtract(this.tamable.blockPosition());
					return this.level.noCollision(this.tamable, this.tamable.getBoundingBox().move(animalPos));
				}
			}
		}

		private int randomIntInclusive(int low, int high) {
			return this.tamable.getRandom().nextInt(high - low + 1) + low;
		}
	}

	class OwnerHurtByTargetGoal extends TargetGoal {
		private final ZombifiedPigman zombifiedPigman;
		private LivingEntity ownerLastHurtBy;
		private int timestamp;

		public OwnerHurtByTargetGoal(ZombifiedPigman zombifiedPigman) {
			super(zombifiedPigman, false);
			this.zombifiedPigman = zombifiedPigman;
			this.setFlags(EnumSet.of(Goal.Flag.TARGET));
		}

		@Override
		public boolean canUse() {
			if (this.zombifiedPigman.isTame()) {
				LivingEntity livingentity = this.zombifiedPigman.getOwner();
				if (livingentity == null) {
					return false;
				} else {
					this.ownerLastHurtBy = livingentity.getLastHurtByMob();
					int i = livingentity.getLastHurtByMobTimestamp();
					return i != this.timestamp && this.canAttack(this.ownerLastHurtBy, TargetingConditions.DEFAULT) && this.zombifiedPigman.wantsToAttack(this.ownerLastHurtBy, livingentity);
				}
			} else {
				return false;
			}
		}

		@Override
		public void start() {
			this.mob.setTarget(this.ownerLastHurtBy);
			LivingEntity livingentity = this.zombifiedPigman.getOwner();
			if (livingentity != null) {
				this.timestamp = livingentity.getLastHurtByMobTimestamp();
			}

			super.start();
		}
	}

	class OwnerHurtTargetGoal extends TargetGoal {
		private final ZombifiedPigman zombifiedPigman;
		private LivingEntity ownerLastHurt;
		private int timestamp;

		public OwnerHurtTargetGoal(ZombifiedPigman zombifiedPigman) {
			super(zombifiedPigman, false);
			this.zombifiedPigman = zombifiedPigman;
			this.setFlags(EnumSet.of(Goal.Flag.TARGET));
		}

		@Override
		public boolean canUse() {
			if (this.zombifiedPigman.isTame()) {
				LivingEntity livingentity = this.zombifiedPigman.getOwner();
				if (livingentity == null) {
					return false;
				} else {
					this.ownerLastHurt = livingentity.getLastHurtMob();
					int i = livingentity.getLastHurtMobTimestamp();
					return i != this.timestamp && this.canAttack(this.ownerLastHurt, TargetingConditions.DEFAULT) && this.zombifiedPigman.wantsToAttack(this.ownerLastHurt, livingentity);
				}
			} else {
				return false;
			}
		}

		@Override
		public void start() {
			this.mob.setTarget(this.ownerLastHurt);
			LivingEntity livingentity = this.zombifiedPigman.getOwner();
			if (livingentity != null) {
				this.timestamp = livingentity.getLastHurtMobTimestamp();
			}

			super.start();
		}
	}
}
