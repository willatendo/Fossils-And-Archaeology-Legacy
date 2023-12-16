package willatendo.fossilslegacy.server.entity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.entity.Egg.EggType;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Mosasaurus extends Animal implements DinopediaInformation, HungryAnimal, PlayerRideable, OwnableEntity, TamesOnBirth, TameAccessor, DaysAlive, GrowingEntity {
	private static final EntityDataAccessor<Integer> HUNGER = SynchedEntityData.defineId(Mosasaurus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> REAL_AGE = SynchedEntityData.defineId(Mosasaurus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DAYS_ALIVE = SynchedEntityData.defineId(Mosasaurus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> GROWTH_STAGE = SynchedEntityData.defineId(Mosasaurus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> COMMAND = SynchedEntityData.defineId(Mosasaurus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> SUB_SPECIES = SynchedEntityData.defineId(Mosasaurus.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Mosasaurus.class, EntityDataSerializers.OPTIONAL_UUID);
	private int timeAlive;

	public Mosasaurus(EntityType<? extends Animal> entityType, Level level) {
		super(entityType, level);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	@Override
	public boolean removeWhenFarAway(double distance) {
		return false;
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public void die(DamageSource damageSource) {
		Component deathMessage = this.getCombatTracker().getDeathMessage();
		super.die(damageSource);

		if (this.dead) {
			if (!this.level().isClientSide && this.level().getGameRules().getBoolean(GameRules.RULE_SHOWDEATHMESSAGES) && this.getOwner() instanceof ServerPlayer) {
				this.getOwner().sendSystemMessage(deathMessage);
			}
		}
	}

	@Override
	public boolean isBaby() {
		return this.getGrowthStage() < 4;
	}

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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 9.0F).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 1.0D).build();
	}

	@Override
	public float getStepHeight() {
		return this.getGrowthStage() < 4 ? 0.5F : this.getGrowthStage() < 8 ? 1.0F : 1.5F;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.isAlive()) {
			this.timeAlive++;
			this.setHunger(this.getHunger() - 1);
		}
		if (this.timeAlive == Level.TICKS_PER_DAY) {
			this.setDaysAlive(this.getDaysAlive() + 1);
			this.timeAlive = 0;
		}
		if (this.getGrowthStage() < this.getGrowthStages().length) {
			for (int i = this.getGrowthStages().length; i > 0; i--) {
				if (this.getRealAge() >= this.getGrowthStages()[i - 1]) {
					this.setGrowthStage(i - 1);
					break;
				}
			}
		}
		if (this.tickCount % 10 == 0) {
			this.setHunger(this.getHunger() - 1);
			if (this.getHealth() < this.getMaxHealth()) {
				if (this.getHunger() > 5000) {
					this.setHunger(this.getHunger() - 1000);
					this.setHealth(this.getHealth() + 1.0F);
				}
				if (this.getHunger() < 0) {
					this.hurt(new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, FossilsLegacyUtils.resource("dinosaur_starve")))), 1.0F);
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

	@Override
	public EntityDimensions getDimensions(Pose pose) {
		return super.getDimensions(pose).scale(0.75F * (float) this.getGrowthStage());
	}

	@Override
	protected void registerGoals() {
//		this.goalSelector.addGoal(0, new FloatGoal(this));
//		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
//		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
//		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, DinoConstants.CARNIVORE_FOOD, false));
//		this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
//		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
//		this.goalSelector.addGoal(6, new DinoWaterAvoidingRandomStrollGoal(this, this, 1.0D));
//		this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, this, this, 1.0D, 10.0F, 2.0F));
//		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
//		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
//		this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this, this, this));
//		this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this, this, this));
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
		ItemStack itemStack = player.getItemInHand(interactionHand);
		if (this.isTame() && itemStack.is(FossilsLegacyItems.SIO_CHIU_LE.get())) {
			int addition = this.getHunger() + 50;
			if (!(addition > this.getMaxHunger())) {
				this.setHunger(addition);
			} else {
				this.setHunger(this.getMaxHunger());
			}
			itemStack.shrink(1);
			return InteractionResult.SUCCESS;
		}
		return super.interactAt(player, vec3, interactionHand);
	}

	public void setRealAge(int realAge) {
		this.entityData.set(REAL_AGE, realAge);
	}

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
		this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8.0D * (growthStage + 1));
		this.getAttribute(Attributes.ARMOR).setBaseValue(1.0D + growthStage);
		this.entityData.set(GROWTH_STAGE, growthStage);
	}

	public void setGrowingProgress(int growingProgress) {
		this.timeAlive = growingProgress;
	}

	public int getGrowingProgress() {
		return this.timeAlive;
	}

	@Override
	public int getGrowthStage() {
		return this.entityData.get(GROWTH_STAGE);
	}

	public int[] getGrowthStages() {
		return new int[] { 10000, 25000, 50000, 75000, 100000, 130000, 250000, 370000 };
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
		return 20000;
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
	}

	@Override
	public List<Component> info(Player player) {
		return List.of(FossilsLegacyUtils.translation("encyclopedia", "mosasaurus"), FossilsLegacyUtils.translation("encyclopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()), FossilsLegacyUtils.translation("encyclopedia", "age", this.getDaysAlive()), FossilsLegacyUtils.translation("encyclopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()), FossilsLegacyUtils.translation("encyclopedia", "hunger", this.getHunger(), this.getMaxHunger()));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		Egg egg = FossilsLegacyEntities.EGG.get().create(serverLevel);
		egg.setEgg(EggType.MOSASAURUS);
		return egg;
	}

	@Override
	public int maxGrowthStage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void decreaseHunger() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getMinHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
