package willatendo.fossilslegacy.server.entity;

import java.util.Optional;
import java.util.UUID;

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
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.Team;
import willatendo.fossilslegacy.server.criteria.FossilsLegacyCriteriaTriggers;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class ZombifiedPigman extends ZombifiedPiglin implements OwnableEntity {
	protected static final EntityDataAccessor<Byte> FLAGS = SynchedEntityData.defineId(ZombifiedPigman.class, EntityDataSerializers.BYTE);
	protected static final EntityDataAccessor<Optional<UUID>> OWNER_UUID = SynchedEntityData.defineId(ZombifiedPigman.class, EntityDataSerializers.OPTIONAL_UUID);
	private boolean orderedToSit;

	public ZombifiedPigman(EntityType<? extends ZombifiedPigman> zombiePigman, Level level) {
		super(zombiePigman, level);
		this.reassessTameGoals();
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

		compoundTag.putBoolean("Sitting", this.orderedToSit);
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

		this.orderedToSit = compoundTag.getBoolean("Sitting");
		this.setInSittingPose(this.orderedToSit);
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

	public Team getTeam() {
		if (this.isTame()) {
			LivingEntity livingEntity = this.getOwner();
			if (livingEntity != null) {
				return livingEntity.getTeam();
			}
		}

		return super.getTeam();
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

		if (this.dead)
			if (!this.level().isClientSide() && this.level().getGameRules().getBoolean(GameRules.RULE_SHOWDEATHMESSAGES) && this.getOwner() instanceof ServerPlayer) {
				this.getOwner().sendSystemMessage(deathMessage);
			}

	}

	public boolean isOrderedToSit() {
		return this.orderedToSit;
	}

	public void setOrderedToSit(boolean orderedToSit) {
		this.orderedToSit = orderedToSit;
	}

	@Override
	protected boolean isSunBurnTick() {
		return false;
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
		if (this.isTame()) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(FossilsLegacyItems.ANCIENT_SWORD.get()));
		} else {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
		}
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(FossilsLegacyItems.ANCIENT_HELMET.get()));
	}
}
