package fossilslegacy.server.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import fossilslegacy.client.sound.FossilsLegacySoundEvents;
import fossilslegacy.server.entity.goal.BabyFollowParentGoal;
import fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import fossilslegacy.server.item.FossilsLegacyItemTags;
import fossilslegacy.server.utils.DinosaurOrder;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Triceratops extends Animal implements DinosaurEncyclopediaInfo, HungryAnimal, PlayerRideable, OwnableEntity, TamesOnBirth, TameAccessor, DaysAlive, GrowingEntity, PlayerCommandable, SubSpecies {
	private static final EntityDataAccessor<Integer> HUNGER = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> REAL_AGE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DAYS_ALIVE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> GROWTH_STAGE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> COMMAND = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> SUB_SPECIES = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.OPTIONAL_UUID);
	private int timeAlive;
	public final AnimationState walkAnimationState = new AnimationState();

	public Triceratops(EntityType<? extends Triceratops> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public boolean isBaby() {
		return this.getGrowthStage() < 4;
	}

	@Override
	public int getAdultAge() {
		return this.getGrowthStages()[9];
	}

	@Override
	public void setBaby(boolean baby) {
		this.setRealAge(baby ? 0 : this.getAdultAge());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAlive()) {
			this.setRealAge(this.getRealAge() + 1);
		}
	}

	public static AttributeSupplier triceratopsAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).build();
	}

	private void setupAnimationStates() {
		if (this.onGround && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
			this.walkAnimationState.startIfStopped(this.tickCount);
		} else {
			this.walkAnimationState.stop();
		}
	}

	@Override
	public float getStepHeight() {
		return this.getGrowthStage() < 4 ? 0.5F : this.getGrowthStage() < 8 ? 1.0F : 1.5F;
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
		if (this.level.isClientSide()) {
			this.setupAnimationStates();
		}
		if (this.getGrowthStage() < this.getGrowthStages().length) {
			for (int i = this.getGrowthStages().length; i > 0; i--) {
				if (this.getRealAge() >= this.getGrowthStages()[i - 1]) {
					this.setGrowthStage(i - 1);
					break;
				}
			}
		}
	}

	@Override
	public void refreshDimensions() {
		double d0 = this.getX();
		double d1 = this.getY();
		double d2 = this.getZ();
		super.refreshDimensions();
		this.setPos(d0, d1, d2);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> entityDataAccessor) {
		if (GROWTH_STAGE.equals(entityDataAccessor)) {
			this.refreshDimensions();
		}

		super.onSyncedDataUpdated(entityDataAccessor);
	}

	public EntityDimensions getDimensions(Pose pose) {
		return super.getDimensions(pose).scale(0.75F * (float) this.getGrowthStage());
	}

	public boolean isInWeaknessBiome() {
		Holder<Biome> biome = this.level.getBiome(this.blockPosition());
		return biome.get().getBaseTemperature() > 1.0F;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new BabyFollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D) {
			@Override
			public boolean canUse() {
				if (Triceratops.this.getCommand() == DinosaurOrder.STAY) {
					return false;
				} else {
					return super.canUse();
				}
			}

			@Override
			public boolean canContinueToUse() {
				if (Triceratops.this.getCommand() == DinosaurOrder.STAY) {
					return false;
				} else {
					return super.canContinueToUse();
				}
			}
		});
		this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, this, this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
//		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
//		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DAYS_ALIVE, 0);
		this.entityData.define(HUNGER, this.getMaxHunger());
		this.entityData.define(OWNER, Optional.empty());
		this.entityData.define(GROWTH_STAGE, 0);
		this.entityData.define(REAL_AGE, 0);
		this.entityData.define(COMMAND, 0);
		this.entityData.define(SUB_SPECIES, 0);
	}

	@Override
	public LivingEntity getOwner() {
		try {
			UUID uuid = this.getOwnerUUID();
			return uuid == null ? null : this.level.getPlayerByUUID(uuid);
		} catch (IllegalArgumentException illegalargumentexception) {
			return null;
		}
	}

	public boolean isOwnedBy(LivingEntity livingEntity) {
		return livingEntity == this.getOwner();
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
		if (this.command(player, vec3, interactionHand)) {
			return InteractionResult.SUCCESS;
		}
		if (!this.isTame()) {
			this.setOwnerUUID(player.getUUID());
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
					double floor = this.level.getBlockFloorHeight(mutableBlockPos);
					if (DismountHelper.isBlockFloorValid(floor)) {
						Vec3 vec3 = Vec3.upFromBottomCenterOf(mutableBlockPos, floor);
						if (DismountHelper.canDismountTo(this.level, livingEntity, aabb.move(vec3))) {
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

//				this.flyingSpeed = this.getSpeed() * 0.1F;
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
		return FossilsLegacySoundEvents.TRICERATOPS_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.TRICERATOPS_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.TRICERATOPS_DEATH.get();
	}

	@Override
	public double getPassengersRidingOffset() {
		return 0.3D * this.getGrowthStage();
	}

	@Override
	public void setRealAge(int realAge) {
		this.entityData.set(REAL_AGE, realAge);
	}

	@Override
	public int getRealAge() {
		return this.entityData.get(REAL_AGE);
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
	public void setGrowthStage(int growthStage) {
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8.0D * growthStage);
		this.entityData.set(GROWTH_STAGE, growthStage);
	}

	@Override
	public int getGrowthStage() {
		return this.entityData.get(GROWTH_STAGE);
	}

	@Override
	public int[] getGrowthStages() {
		return new int[] { 10000, 25000, 50000, 75000, 100000, 130000, 250000, 370000, 500000 };
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

	@Override
	public int getSubSpecies() {
		return this.entityData.get(SUB_SPECIES);
	}

	@Override
	public void setSubSpecies(int subSpecies) {
		if (subSpecies > 2) {
			subSpecies = 2;
		}
		this.entityData.set(SUB_SPECIES, subSpecies);
	}

	@Override
	public ResourceLocation[][] textures() {
		return new ResourceLocation[][] { { FossilsLegacyUtils.resource("textures/entities/triceratops/green_adult_triceratops.png"), FossilsLegacyUtils.resource("textures/entities/triceratops/green_baby_triceratops.png") }, { FossilsLegacyUtils.resource("textures/entities/triceratops/brown_adult_triceratops.png"), FossilsLegacyUtils.resource("textures/entities/triceratops/brown_baby_triceratops.png") }, { FossilsLegacyUtils.resource("textures/entities/triceratops/yellow_adult_triceratops.png"), FossilsLegacyUtils.resource("textures/entities/triceratops/yellow_baby_triceratops.png") } };
	}

	public boolean isTame() {
		return this.getOwnerUUID() != null;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putInt("DaysAlive", this.getDaysAlive());
		compoundTag.putInt("Hunger", this.getHunger());
		compoundTag.putInt("TicksAlive", this.timeAlive);
		if (this.getOwnerUUID() != null) {
			compoundTag.putUUID("Owner", this.getOwnerUUID());
		}
		compoundTag.putInt("GrowthStage", this.getGrowthStage());
		compoundTag.putInt("RealAge", this.getRealAge());
		compoundTag.putInt("Command", this.getCommand().ordinal());
		compoundTag.putInt("SubSpecies", this.getSubSpecies());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
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
		this.setGrowthStage(compoundTag.getInt("GrowthStage"));
		this.setRealAge(compoundTag.getInt("RealAge"));
		this.setCommand(DinosaurOrder.values()[compoundTag.getInt("Command")]);
		this.setSubSpecies(compoundTag.getInt("SubSpecies"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag) {
		this.setSubSpecies(this.random.nextInt(this.textures().length));
		return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
	}

//	private float getAttackDamage() {
//		return (float) this.getAttributeValue(Attributes.ATTACK_DAMAGE);
//	}

//	@Override
//	public boolean doHurtTarget(Entity entity) {
//		this.level.broadcastEntityEvent(this, (byte) 4);
//		float attackDamage = this.getAttackDamage();
//		float variableDamage = (int) attackDamage > 0 ? attackDamage / 2.0F + (float) this.random.nextInt((int) attackDamage) : attackDamage;
//		boolean canHurt = entity.hurt(DamageSource.mobAttack(this), variableDamage);
//		if (canHurt) {
//			double knockbackResistance;
//			if (entity instanceof LivingEntity livingEntity) {
//				knockbackResistance = livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
//			} else {
//				knockbackResistance = 0.0D;
//			}
//
//			double variableKnockbackResistance = Math.max(0.0D, 1.0D - knockbackResistance);
//			entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, (double) 0.4F * variableKnockbackResistance, 0.0D));
//			this.doEnchantDamageEffects(this, entity);
//		}
//
//		this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
//		return canHurt;
//	}

	@Override
	public List<Component> info() {
		return List.of(FossilsLegacyUtils.translation("encyclopedia", "triceratops"), FossilsLegacyUtils.translation("encyclopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()), FossilsLegacyUtils.translation("encyclopedia", "age", this.getDaysAlive()), FossilsLegacyUtils.translation("encyclopedia", "health", (int) this.getHealth()), FossilsLegacyUtils.translation("encyclopedia", "hunger", this.getHunger(), this.getMaxHunger()));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return FossilsLegacyEntities.TRICERATOPS.get().create(serverLevel);
	}

	@Override
	public DinosaurOrder getCommand() {
		return DinosaurOrder.values()[this.entityData.get(COMMAND)];
	}

	@Override
	public void setCommand(DinosaurOrder commands) {
		this.entityData.set(COMMAND, commands.ordinal());
	}

	@Override
	public TagKey<Item> commandItems() {
		return FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES;
	}
}
