package willatendo.fossilslegacy.server.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.HitResult;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class Egg extends Animal implements TicksToBirth, DinopediaInformation {
	private static final EntityDataAccessor<Integer> REMAINING_TIME = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> EGG = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> WARM = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.BOOLEAN);

	public Egg(EntityType<? extends Egg> egg, Level level) {
		super(egg, level);
	}

	public static AttributeSupplier eggAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0F).build();
	}

	@Override
	protected void dropExperience() {
	}

	@Override
	public void knockback(double xVelc, double yVelc, double zVelc) {
	}

	@Override
	protected ResourceLocation getDefaultLootTable() {
		return this.getEgg().getLoot();
	}

	@Override
	public boolean doHurtTarget(Entity entity) {
		this.discard();
		this.dropAllDeathLoot(this.damageSources().generic());
		return false;
	}

	@Override
	public void die(DamageSource damageSource) {
		this.discard();
		this.dropAllDeathLoot(damageSource);
	}

	@Override
	public ItemStack getPickedResult(HitResult hitResult) {
		return this.getEgg().getPick().get().getDefaultInstance();
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getEgg() == EggType.MOSASAURUS) {
			this.setWarm(this.isInWaterOrBubble());
		} else {
			this.setWarm(this.level().getBrightness(LightLayer.BLOCK, new BlockPos(this.getBlockX(), this.getBlockY(), this.getBlockZ())) > 10.0F || this.level().isDay());
		}

		if (this.getRemainingTime() < -500) {
			this.discard();
			Player player = this.level().getNearestPlayer(this, 25.0D);
			if (player != null) {
				if (this.getEgg() == EggType.MOSASAURUS) {
					player.sendSystemMessage(FossilsLegacyUtils.translation("entity", "egg.died.dry"));
				} else {
					player.sendSystemMessage(FossilsLegacyUtils.translation("entity", "egg.died"));
				}
			}
		}

		if (!this.isWarm()) {
			this.setRemainingTime(this.getRemainingTime() - 1);
		}

		if (this.isWarm()) {
			this.birthTick(this, this.level());
		}
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(REMAINING_TIME, 0);
		this.entityData.define(EGG, 0);
		this.entityData.define(WARM, false);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putInt("RemainingTime", this.getRemainingTime());
		compoundTag.putInt("Egg", this.getEgg().ordinal());
		compoundTag.putBoolean("Warm", this.isWarm());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.setRemainingTime(compoundTag.getInt("RemainingTime"));
		this.setEgg(EggType.values()[compoundTag.getInt("Egg")]);
		this.setWarm(compoundTag.getBoolean("Warm"));
	}

	@Override
	public Entity getOffspring(Level level) {
		return this.getEgg().getEntityType().get().create(level);
	}

	@Override
	public int getRemainingTime() {
		return this.entityData.get(REMAINING_TIME);
	}

	@Override
	public void setRemainingTime(int remainingPregnancyTime) {
		this.entityData.set(REMAINING_TIME, remainingPregnancyTime);
	}

	public boolean isWarm() {
		return this.entityData.get(WARM);
	}

	public void setWarm(boolean warm) {
		this.entityData.set(WARM, warm);
	}

	public EggType getEgg() {
		return EggType.values()[this.entityData.get(EGG)];
	}

	public void setEgg(EggType eggs) {
		this.entityData.set(EGG, eggs.ordinal());
	}

	@Override
	public List<Component> info(Player player) {
		ArrayList<Component> information = Lists.newArrayList();
		information.add(FossilsLegacyUtils.translation("dinopedia", "egg", this.getEgg().getEntityType().get().getDescription().getString()));
		information.add(FossilsLegacyUtils.translation("dinopedia", "remaining_time", (int) Mth.floor((this.getRemainingTime() / this.maxTime()) * 100) + "%"));
		information.add(FossilsLegacyUtils.translation("dinopedia", "temperature", this.getTemperature()));
		return information;
	}

	private Component getTemperature() {
		if (this.getEgg() == EggType.MOSASAURUS) {
			return this.isInWaterOrBubble() ? FossilsLegacyUtils.translation("dinopedia", "wet") : FossilsLegacyUtils.translation("dinopedia", "dry");
		} else {
			return this.isWarm() ? FossilsLegacyUtils.translation("dinopedia", "warm") : FossilsLegacyUtils.translation("dinopedia", "cold");
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return null;
	}

	public static enum EggType {
		TRICERATOPS("triceratops", FossilsLegacyLootTables.TRICERATOPS_EGG, () -> FossilsLegacyEntities.TRICERATOPS.get(), () -> FossilsLegacyItems.TRICERATOPS_EGG.get()),
		VELOCIRAPTOR("velociraptor", FossilsLegacyLootTables.VELOCIRAPTOR_EGG, () -> FossilsLegacyEntities.VELOCIRAPTOR.get(), () -> FossilsLegacyItems.VELOCIRAPTOR_EGG.get()),
		TYRANNOSAURUS("tyrannosaurus", FossilsLegacyLootTables.TYRANNOSAURUS_EGG, () -> EntityType.COW, () -> FossilsLegacyItems.TYRANNOSAURUS_EGG.get()),
		PTEROSAURUS("pterosaurus", FossilsLegacyLootTables.PTEROSAURUS_EGG, () -> FossilsLegacyEntities.PTERANODON.get(), () -> FossilsLegacyItems.PTEROSAURUS_EGG.get()),
		PLESIOSAURUS("plesiosaurus", FossilsLegacyLootTables.PLESIOSAURUS_EGG, () -> EntityType.COW, () -> FossilsLegacyItems.PLESIOSAURUS_EGG.get()),
		MOSASAURUS("mosasaurus", FossilsLegacyLootTables.MOSASAURUS_EGG, () -> FossilsLegacyEntities.MOSASAURUS.get(), () -> FossilsLegacyItems.MOSASAURUS_EGG.get()),
		STEGOSAURUS("stegosaurus", FossilsLegacyLootTables.STEGOSAURUS_EGG, () -> FossilsLegacyEntities.BRACHIOSAURUS.get(), () -> FossilsLegacyItems.STEGOSAURUS_EGG.get()),
		DILOPHOSAURUS("dilophosaurus", FossilsLegacyLootTables.DILOPHOSAURUS_EGG, () -> EntityType.COW, () -> FossilsLegacyItems.DILOPHOSAURUS_EGG.get()),
		BRACHIOSAURUS("brachiosaurus", FossilsLegacyLootTables.BRACHIOSAURUS_EGG, () -> FossilsLegacyEntities.BRACHIOSAURUS.get(), () -> FossilsLegacyItems.BRACHIOSAURUS_EGG.get());

		private final String texture;
		private final ResourceLocation loot;
		private final Supplier<EntityType> entityType;
		private final Supplier<Item> pick;

		private EggType(String texture, ResourceLocation loot, Supplier<EntityType> entityType, Supplier<Item> pick) {
			this.texture = texture;
			this.loot = loot;
			this.entityType = entityType;
			this.pick = pick;
		}

		public String getTexture() {
			return this.texture;
		}

		public ResourceLocation getLoot() {
			return this.loot;
		}

		public Supplier<EntityType> getEntityType() {
			return this.entityType;
		}

		public Supplier<Item> getPick() {
			return this.pick;
		}
	}
}
