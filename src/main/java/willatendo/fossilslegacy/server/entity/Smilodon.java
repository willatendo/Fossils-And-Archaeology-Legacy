package willatendo.fossilslegacy.server.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.client.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Smilodon extends Animal implements DinopediaInformation, HungryAnimal, OwnableEntity, TamesOnBirth, TameAccessor, DaysAlive, PlayerCommandableAccess {
	private static final EntityDataAccessor<Integer> HUNGER = SynchedEntityData.defineId(Smilodon.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DAYS_ALIVE = SynchedEntityData.defineId(Smilodon.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> COMMAND = SynchedEntityData.defineId(Smilodon.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Smilodon.class, EntityDataSerializers.OPTIONAL_UUID);
	public final AnimationState walkAnimationState = new AnimationState();
	private int timeAlive;
	private boolean isWet;
	private boolean isShaking;
	private float shakeAnim;
	private float shakeAnimO;

	public Smilodon(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	public void aiStep() {
		super.aiStep();

		if (!this.level().isClientSide && this.isWet && !this.isShaking && !this.isPathFinding() && this.onGround()) {
			this.isShaking = true;
			this.shakeAnim = 0.0F;
			this.shakeAnimO = 0.0F;
			this.level().broadcastEntityEvent(this, (byte) 8);
		}
	}

	@Override
	public boolean removeWhenFarAway(double distance) {
		return false;
	}

	@Override
	public void handleEntityEvent(byte event) {
		if (event == 8) {
			this.isShaking = true;
			this.shakeAnim = 0.0F;
			this.shakeAnimO = 0.0F;
		} else if (event == 56) {
			this.cancelShake();
		} else {
			super.handleEntityEvent(event);
		}
	}

	@Override
	public void die(DamageSource damageSource) {
		this.isWet = false;
		this.isShaking = false;
		this.shakeAnimO = 0.0F;
		this.shakeAnim = 0.0F;

		Component deathMessage = this.getCombatTracker().getDeathMessage();
		super.die(damageSource);

		if (this.dead) {
			if (!this.level().isClientSide && this.level().getGameRules().getBoolean(GameRules.RULE_SHOWDEATHMESSAGES) && this.getOwner() instanceof ServerPlayer) {
				this.getOwner().sendSystemMessage(deathMessage);
			}
		}
	}

	public static AttributeSupplier smilodonAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0F).add(Attributes.MOVEMENT_SPEED, 0.23D).build();
	}

	public float getTailAngle() {
		return this.isTame() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float) Math.PI : ((float) Math.PI / 5F);
	}

	private void setupAnimationStates() {
		if (this.onGround() && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
			this.walkAnimationState.startIfStopped(this.tickCount);
		} else {
			this.walkAnimationState.stop();
		}
	}

	@Override
	public void tick() {
		super.tick();
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

		if (this.isAlive()) {

			if (this.isInWaterRainOrBubble()) {
				this.isWet = true;
				if (this.isShaking && !this.level().isClientSide) {
					this.level().broadcastEntityEvent(this, (byte) 56);
					this.cancelShake();
				}
			} else if ((this.isWet || this.isShaking) && this.isShaking) {
				if (this.shakeAnim == 0.0F) {
					this.playSound(SoundEvents.WOLF_SHAKE, this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
					this.gameEvent(GameEvent.ENTITY_SHAKE);
				}

				this.shakeAnimO = this.shakeAnim;
				this.shakeAnim += 0.05F;
				if (this.shakeAnimO >= 2.0F) {
					this.isWet = false;
					this.isShaking = false;
					this.shakeAnimO = 0.0F;
					this.shakeAnim = 0.0F;
				}

				if (this.shakeAnim > 0.4F) {
					float f = (float) this.getY();
					int i = (int) (Mth.sin((this.shakeAnim - 0.4F) * (float) Math.PI) * 7.0F);
					Vec3 vec3 = this.getDeltaMovement();

					for (int j = 0; j < i; ++j) {
						float f1 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
						float f2 = (this.random.nextFloat() * 2.0F - 1.0F) * this.getBbWidth() * 0.5F;
						this.level().addParticle(ParticleTypes.SPLASH, this.getX() + (double) f1, (double) (f + 0.8F), this.getZ() + (double) f2, vec3.x, vec3.y, vec3.z);
					}
				}
			}
		}
	}

	private void cancelShake() {
		this.isShaking = false;
		this.shakeAnim = 0.0F;
		this.shakeAnimO = 0.0F;
	}

	public boolean isWet() {
		return this.isWet;
	}

	public boolean isShaking() {
		return this.isShaking;
	}

	public float getWetShade(float time) {
		return Math.min(0.5F + Mth.lerp(time, this.shakeAnimO, this.shakeAnim) / 2.0F * 0.5F, 1.0F);
	}

	public float getBodyRollAngle(float ageInTicks, float max) {
		float f = (Mth.lerp(ageInTicks, this.shakeAnimO, this.shakeAnim) + max) / 1.8F;
		if (f < 0.0F) {
			f = 0.0F;
		} else if (f > 1.0F) {
			f = 1.0F;
		}

		return Mth.sin(f * (float) Math.PI) * Mth.sin(f * (float) Math.PI * 11.0F) * 0.15F * (float) Math.PI;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D) {
			@Override
			public boolean canUse() {
				if (Smilodon.this.getCommand() == DinosaurCommand.STAY) {
					return false;
				} else {
					return super.canUse();
				}
			}

			@Override
			public boolean canContinueToUse() {
				if (Smilodon.this.getCommand() == DinosaurCommand.STAY) {
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
		this.entityData.define(COMMAND, 0);
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
//		if (this.command(player, vec3, interactionHand, this)) {
//			return InteractionResult.SUCCESS;
//		}
		if (this.TESTING_autotame(player)) {
			return InteractionResult.SUCCESS;
		}
		return super.interactAt(player, vec3, interactionHand);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return FossilsLegacySoundEvents.SMILODON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.SMILODON_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.SMILODON_DEATH.get();
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

	public void setOwnerUUID(UUID uuid) {
		this.entityData.set(OWNER, Optional.ofNullable(uuid));
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
		compoundTag.putInt("Command", this.getCommand().ordinal());
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
		this.setCommand(DinosaurCommand.values()[compoundTag.getInt("Command")]);
	}

	@Override
	public void ate() {
		super.ate();
		if (this.isBaby()) {
			this.ageUp(60);
		}
		this.setHunger(this.getMaxHunger());
	}

	@Override
	public List<Component> info(Player player) {
		return List.of(FossilsLegacyUtils.translation("encyclopedia", "smilodon"), FossilsLegacyUtils.translation("encyclopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()), FossilsLegacyUtils.translation("encyclopedia", "age", this.getDaysAlive()), FossilsLegacyUtils.translation("encyclopedia", "health", (int) this.getHealth()), FossilsLegacyUtils.translation("encyclopedia", "hunger", this.getHunger(), this.getMaxHunger()));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return FossilsLegacyEntities.SMILODON.get().create(serverLevel);
	}

	@Override
	public DinosaurCommand getCommand() {
		return DinosaurCommand.values()[this.entityData.get(COMMAND)];
	}

	@Override
	public void setCommand(DinosaurCommand dinosaurOrder) {
		this.entityData.set(COMMAND, dinosaurOrder.ordinal());
	}

	@Override
	public TagKey<Item> commandItems() {
		return null;
	}

	@Override
	public void decreaseHunger() {
		// TODO Auto-generated method stub

	}
}
