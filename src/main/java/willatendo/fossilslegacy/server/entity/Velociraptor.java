package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.entity.goal.DinoBabyFollowParentGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoEatFromFeederGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoFollowOwnerGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoNearestAttackableTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtByTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoOwnerHurtTargetGoal;
import willatendo.fossilslegacy.server.entity.goal.DinoWaterAvoidingRandomStrollGoal;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Velociraptor extends Dinosaur implements DinopediaInformation, SubSpecies, HighlyIntelligent {
	private static final EntityDataAccessor<Integer> SUB_SPECIES = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> LEARNED_CHESTS = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);

	public Velociraptor(EntityType<? extends Velociraptor> entityType, Level level) {
		super(entityType, level);
		((GroundPathNavigation) this.navigation).setCanOpenDoors(true);
	}

	public static AttributeSupplier velociraptorAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0F).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 1.0D).build();
	}

	@Override
	public float maxUpStep() {
		return DinoUtils.getStepHeights(8, 1.0F)[this.getGrowthStage()];
	}

	@Override
	public int getMaxHunger() {
		return 100;
	}

	@Override
	public EggVariant getEggVariant() {
		return FossilsLegacyEggVariants.VELOCIRAPTOR.get();
	}

	@Override
	public int getMaxGrowthStage() {
		return 8;
	}

	@Override
	public float getBoundingBoxGrowth() {
		return 0.15F;
	}

	@Override
	public double getMinHealth() {
		return 5.0F;
	}

	@Override
	public Diet getDiet() {
		return Diet.carnivore();
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, DinoUtils.CARNIVORE_FOOD, false));
		this.goalSelector.addGoal(4, new DinoBabyFollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(6, new DinoWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new DinoFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F));
		this.goalSelector.addGoal(6, new DinoEatFromFeederGoal(this, 1.0D, 24, true));
		this.goalSelector.addGoal(6, new OpenDoorGoal(this, false) {
			@Override
			public void stop() {
			}
		});
//		this.goalSelector.addGoal(6, new LearnChestsGoal(this));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DinoOwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinoOwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(4, new DinoNearestAttackableTargetGoal<>(this, LivingEntity.class, true));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SUB_SPECIES, 0);
		this.entityData.define(LEARNED_CHESTS, false);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return this.isTame() ? FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_TAME.get() : FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_WILD.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return FossilsLegacySoundEvents.VELOCIRAPTOR_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return FossilsLegacySoundEvents.VELOCIRAPTOR_DEATH.get();
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
	public void setLearnedChests(boolean learnedChests) {
		this.entityData.set(LEARNED_CHESTS, learnedChests);
	}

	@Override
	public boolean hasLearnedChests() {
		return this.entityData.get(LEARNED_CHESTS);
	}

	@Override
	public ResourceLocation[][] textures() {
		return new ResourceLocation[][] { { FossilsLegacyUtils.resource("textures/entities/animals/velociraptor/sandy_velociraptor.png"), FossilsLegacyUtils.resource("textures/entities/animals/velociraptor/sandy_baby_velociraptor.png") }, { FossilsLegacyUtils.resource("textures/entities/animals/velociraptor/green_velociraptor.png"), FossilsLegacyUtils.resource("textures/entities/animals/velociraptor/green_baby_velociraptor.png") }, { FossilsLegacyUtils.resource("textures/entities/animals/velociraptor/white_velociraptor.png"), FossilsLegacyUtils.resource("textures/entities/animals/velociraptor/white_baby_velociraptor.png") } };
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putInt("SubSpecies", this.getSubSpecies());
		compoundTag.putBoolean("LearnedChests", this.hasLearnedChests());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.setSubSpecies(compoundTag.getInt("SubSpecies"));
		this.setLearnedChests(compoundTag.getBoolean("LearnedChests"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag) {
		Biome biome = serverLevelAccessor.getBiome(this.blockPosition()).value();

		if (biome.coldEnoughToSnow(this.blockPosition())) {
			this.setSubSpecies(2);
		} else if (biome.getBaseTemperature() > 1.75F) {
			this.setSubSpecies(0);
		} else {
			this.setSubSpecies(1);
		}

		return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
	}

	@Override
	public List<Component> info(Player player) {
		ArrayList<Component> information = Lists.newArrayList();
		if (this.isTame() && this.isOwnedBy(player)) {
			information.add(this.getDisplayName());
			information.add(FossilsLegacyUtils.translation("dinopedia", "owner", this.getOwner() != null ? this.getOwner().getDisplayName().getString() : FossilsLegacyUtils.translation("encyclopedia", "wild").getString()));
			information.add(FossilsLegacyUtils.translation("dinopedia", "age", this.getDaysAlive()));
			information.add(FossilsLegacyUtils.translation("dinopedia", "health", (int) this.getHealth(), (int) this.getMaxHealth()));
			information.add(FossilsLegacyUtils.translation("dinopedia", "hunger", this.getHunger(), this.getMaxHunger()));
		} else {
			information.add(this.getDisplayName());
			if (this.isTame()) {
				information.add(FossilsLegacyUtils.translation("dinopedia", "not_owner"));
			} else {
				information.add(FossilsLegacyUtils.translation("dinopedia", "wild"));
			}
		}
		return information;
	}

	@Override
	public CommandType commandItems() {
		return CommandType.hand();
	}
}
