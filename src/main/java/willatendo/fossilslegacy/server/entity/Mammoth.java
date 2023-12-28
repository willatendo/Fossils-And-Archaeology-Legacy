package willatendo.fossilslegacy.server.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Mammoth extends Animal implements DinopediaInformation, HungryAnimal, PlayerRideable, OwnableEntity, TamesOnBirth, TameAccessor, DaysAlive, Shearable {
	private static final EntityDataAccessor<Integer> HUNGER = SynchedEntityData.defineId(Mammoth.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DAYS_ALIVE = SynchedEntityData.defineId(Mammoth.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> IS_SHEARED = SynchedEntityData.defineId(Mammoth.class, EntityDataSerializers.BOOLEAN);
	protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Mammoth.class, EntityDataSerializers.OPTIONAL_UUID);
	public final AnimationState walkAnimationState = new AnimationState();
	public final AnimationState eatGrassAnimationState = new AnimationState();
	public final AnimationState attackAnimationState = new AnimationState();
	private int timeAlive;
	private int eatAnimationTick;
	@SuppressWarnings("unused")
	private int swingTick;
	private EatBlockGoal eatBlockGoal;

	public Mammoth(EntityType<? extends Mammoth> entityType, Level level) {
		super(entityType, level);

		this.setMaxUpStep(1.5F);
	}

	public static AttributeSupplier mammothAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 24.0F).add(Attributes.MOVEMENT_SPEED, 0.23D).build();
	}

	private void setupAnimationStates() {
		if (this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
			this.walkAnimationState.startIfStopped(this.tickCount);
		} else {
			this.walkAnimationState.stop();
		}
		if (this.eatAnimationTick > 0) {
			this.eatGrassAnimationState.startIfStopped(this.tickCount);
		} else {
			this.eatGrassAnimationState.stop();
		}
	}

	@Override
	protected void customServerAiStep() {
		this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
		super.customServerAiStep();
	}

	@Override
	public void handleEntityEvent(byte event) {
		if (event == 10) {
			this.eatAnimationTick = 40;
		} else if (event == 4) {
			this.attackAnimationState.start(this.tickCount);
		} else {
			super.handleEntityEvent(event);
		}
	}

	@Override
	public void aiStep() {
		if (this.level().isClientSide()) {
			this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
		}
		super.aiStep();
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.hasEffect(MobEffects.WEAKNESS) && this.isInWeaknessBiome()) {
			this.addEffect(new MobEffectInstance(MobEffects.WEAKNESS));
		}
		if (this.isAlive()) {
			this.timeAlive++;
			this.setHunger(this.getHunger() - 1);
		}
		if (this.timeAlive == 24000) {
			this.setDaysAlive(this.getDaysAlive() + 1);
			this.timeAlive = 0;
		}
		if (this.level().isClientSide()) {
			this.setupAnimationStates();
		}
	}

	public boolean isInWeaknessBiome() {
		Holder<Biome> biome = this.level().getBiome(this.blockPosition());
		return biome.value().getBaseTemperature() > 1.0F;
	}

	@Override
	protected void registerGoals() {
		this.eatBlockGoal = new EatBlockGoal(this);
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, this.eatBlockGoal);
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
//		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
//		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_SHEARED, false);
		this.entityData.define(DAYS_ALIVE, 0);
		this.entityData.define(HUNGER, this.getMaxHunger());
		this.entityData.define(OWNER, Optional.empty());
	}

	@Override
	public LivingEntity getOwner() {
		try {
			UUID uuid = this.getOwnerUUID();
			return uuid == null ? null : this.level().getPlayerByUUID(uuid);
		} catch (IllegalArgumentException illegalargumentexception) {
			return null;
		}
	}

	public boolean isOwnedBy(LivingEntity livingEntity) {
		return livingEntity == this.getOwner();
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
		if (this.TESTING_autotame(player)) {
			return InteractionResult.SUCCESS;
		}
		if (!this.hasPassenger(this) && player.getItemInHand(interactionHand).isEmpty() && !this.isBaby()) {
			player.startRiding(this);
			return InteractionResult.SUCCESS;
		}
		return super.interactAt(player, vec3, interactionHand);
	}

	@Override
	public LivingEntity getControllingPassenger() {
		Entity entity = this.getFirstPassenger();
		if (entity instanceof LivingEntity livingEntity) {
			return livingEntity;
		}

		return null;
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity livingEntity) {
		Direction direction = this.getMotionDirection();
		if (direction.getAxis() == Direction.Axis.Y) {
			return super.getDismountLocationForPassenger(livingEntity);
		} else {
			int[][] offsets = DismountHelper.offsetsForDirection(direction);
			BlockPos blockPos = this.blockPosition();
			BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

			for (Pose pose : livingEntity.getDismountPoses()) {
				AABB aabb = livingEntity.getLocalBoundsForPose(pose);

				for (int[] offset : offsets) {
					mutableBlockPos.set(blockPos.getX() + offset[0], blockPos.getY(), blockPos.getZ() + offset[1]);
					double floor = this.level().getBlockFloorHeight(mutableBlockPos);
					if (DismountHelper.isBlockFloorValid(floor)) {
						Vec3 vec3 = Vec3.upFromBottomCenterOf(mutableBlockPos, floor);
						if (DismountHelper.canDismountTo(this.level(), livingEntity, aabb.move(vec3))) {
							livingEntity.setPose(pose);
							return vec3;
						}
					}
				}
			}

			return super.getDismountLocationForPassenger(livingEntity);
		}
	}

	@Override
	public void travel(Vec3 vec3) {
		if (this.isAlive()) {
			LivingEntity livingEntity = this.getControllingPassenger();
			if (this.isVehicle() && livingEntity != null) {
				this.setRot(livingEntity.getYRot(), livingEntity.getXRot() * 0.5F);
				this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
				float f = livingEntity.xxa * 0.5F;
				float f1 = livingEntity.zza;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;
				}

//				this.getFlyingSpeed() = this.getSpeed() * 0.1F;
				if (this.isControlledByLocalInstance()) {
					this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vec3((double) f, vec3.y, (double) f1));
				} else if (livingEntity instanceof Player) {
					this.setDeltaMovement(this.getX() - this.xOld, this.getY() - this.yOld, this.getZ() - this.zOld);
				}

				this.calculateEntityAnimation(false);
				this.tryCheckInsideBlocks();
			} else {
//				this.flyingSpeed = 0.02F;
				super.travel(vec3);
			}
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return FossilsLegacySoundEvents.MAMMOTH_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.MAMMOTH_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.MAMMOTH_DEATH.get();
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return new Vec3(0.0D, 3.0D, 0.0D);
	}

	public void setSheared(boolean sheared) {
		this.entityData.set(IS_SHEARED, sheared);
	}

	public boolean isSheared() {
		return this.entityData.get(IS_SHEARED);
	}

	@Override
	public void setDaysAlive(int daysAlive) {
		this.entityData.set(DAYS_ALIVE, daysAlive);
	}

	@Override
	public int getDaysAlive() {
		return this.entityData.get(DAYS_ALIVE);
	}

	@Override
	public void setHunger(int hunger) {
		this.entityData.set(HUNGER, hunger);
	}

	@Override
	public int getHunger() {
		return this.entityData.get(HUNGER);
	}

	@Override
	public int getMaxHunger() {
		return 5000;
	}

	@Override
	public UUID getOwnerUUID() {
		return this.entityData.get(OWNER).orElse((UUID) null);
	}

	@Override
	public void setOwnerUUID(UUID uuid) {
		this.entityData.set(OWNER, Optional.ofNullable(uuid));
	}

	public boolean isTame() {
		return this.getOwnerUUID() != null;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putBoolean("IsSheared", this.isSheared());
		compoundTag.putInt("DaysAlive", this.getDaysAlive());
		compoundTag.putInt("Hunger", this.getHunger());
		compoundTag.putInt("TicksAlive", this.timeAlive);
		if (this.getOwnerUUID() != null) {
			compoundTag.putUUID("Owner", this.getOwnerUUID());
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.setSheared(compoundTag.getBoolean("IsSheared"));
		this.setDaysAlive(compoundTag.getInt("DaysAlive"));
		this.setHunger(compoundTag.getInt("Hunger"));
		this.timeAlive = compoundTag.getInt("TicksAlive");
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
			} catch (Throwable throwable) {
			}
		}
	}

	private float getAttackDamage() {
		return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
	}

	@Override
	public boolean doHurtTarget(Entity entity) {
		this.level().broadcastEntityEvent(this, (byte) 4);
		float attackDamage = this.getAttackDamage();
		float variableDamage = (int) attackDamage > 0 ? attackDamage / 2.0F + (float) this.random.nextInt((int) attackDamage) : attackDamage;
		boolean canHurt = entity.hurt(this.damageSources().mobAttack(this), variableDamage);
		if (canHurt) {
			double knockbackResistance;
			if (entity instanceof LivingEntity livingEntity) {
				knockbackResistance = livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
			} else {
				knockbackResistance = 0.0D;
			}

			double variableKnockbackResistance = Math.max(0.0D, 1.0D - knockbackResistance);
			entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, (double) 0.4F * variableKnockbackResistance, 0.0D));
			this.doEnchantDamageEffects(this, entity);
		}

		this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
		return canHurt;
	}

	@Override
	public void ate() {
		super.ate();
		this.setSheared(false);
		if (this.isBaby()) {
			this.ageUp(60);
		}
		this.setHunger(this.getMaxHunger());
	}

	@Override
	public boolean readyForShearing() {
		return this.isAlive() && !this.isSheared() && !this.isBaby();
	}

	@Override
	public void shear(SoundSource soundSource) {
		this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, soundSource, 1.0f, 1.0f);
		if (!this.level().isClientSide()) {
			this.setSheared(true);
			int amount = 1 + this.random.nextInt(20);

			for (int i = 0; i < amount; ++i) {
				this.spawnAtLocation(new ItemStack(Items.BROWN_WOOL), 1);
			}
		}
	}

	@Override
	public List<Component> info(Player player) {
		return List.of(FossilsLegacyUtils.translation("encyclopedia", "mammoth"), FossilsLegacyUtils.translation("encyclopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()), FossilsLegacyUtils.translation("encyclopedia", "age", this.getDaysAlive()), FossilsLegacyUtils.translation("encyclopedia", "health", (int) this.getHealth()), FossilsLegacyUtils.translation("encyclopedia", "hunger", this.getHunger(), this.getMaxHunger()));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return FossilsLegacyEntities.MAMMOTH.get().create(serverLevel);
	}

	@Override
	public void decreaseHunger() {
	}
}
