package willatendo.fossilslegacy.server.entity;

import java.util.Optional;
import java.util.UUID;

import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.ConfigHelper;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public abstract class Dinosaur extends Animal implements OwnableEntity, TamesOnBirth, TameAccessor, PlayerCommandableAccess, HungryAnimal, DaysAlive, GrowingEntity, TamedSpeakingEntity {
    private static final EntityDataAccessor<Integer> COMMAND = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DAYS_ALIVE = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROWTH_STAGE = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> HUNGER = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.OPTIONAL_UUID);
    protected int internalClock = 0;

    public Dinosaur(EntityType<? extends Dinosaur> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, SpawnGroupData spawnGroupData, CompoundTag compoundTag) {
        this.setHunger(this.getMaxHunger());
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    @Override
    public boolean killedEntity(ServerLevel serverLevel, LivingEntity livingEntity) {
        if (this.getDiet().getsFoodFromKill()) {
            this.increaseHunger(this.getDiet().getEntityFoodValue(livingEntity));
        }
        return super.killedEntity(serverLevel, livingEntity);
    }

    public EggVariant getEggVariant() {
        return null;
    }

    public abstract float getBoundingBoxGrowth();

    public abstract Diet getDiet();

    public boolean hasSpace() {
        EntityDimensions entityDimensions = this.getDimensions(this.getPose());
        EntityDimensions updatedDimensions = entityDimensions.scale(1.0F + (((float) this.getBoundingBoxGrowth()) * ((float) this.getGrowthStage() + 1.0F)));
        return !this.level().getBlockCollisions(this, updatedDimensions.makeBoundingBox(this.position())).iterator().hasNext();
    }

    @Override
    public int getAmbientSoundInterval() {
        return 360;
    }

    @Override
    public float getVoicePitch() {
        return 0.5F + (0.1F * this.getGrowthStage());
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return this.getDiet().getItemStackFoodValue(itemStack) > 0;
    }

    @Override
    public boolean removeWhenFarAway(double distance) {
        return false;
    }

    @Override
    public boolean isBaby() {
        return this.getGrowthStage() < this.getMaxGrowthStage() / 2;
    }

    @Override
    public void tick() {
        if (this.internalClock == Level.TICKS_PER_DAY) {
            this.internalClock = 0;
        }

        this.internalClock++;

        super.tick();

        if (!this.isNoAi()) {
            if (ConfigHelper.willAnimalsGrow()) {
                if (this.getGrowthStage() < this.getMaxGrowthStage()) {
                    if (this.internalClock % Level.TICKS_PER_DAY == 0) {
                        if (this.hasSpace()) {
                            this.setGrowthStage(this.getGrowthStage() + 1);
                            this.setHealth((float) (this.getHealth() + this.getMinHealth()));
                        } else {
                            this.sendMessageToOwnerOrElseAll(DinoSituation.NO_SPACE);
                        }
                    }
                }
            }

            if (this.internalClock % Level.TICKS_PER_DAY == 0) {
                this.setDaysAlive(this.getDaysAlive() + 1);
            }

            if (ConfigHelper.willAnimalsStarve()) {
                if (this.level().getDifficulty() != Difficulty.PEACEFUL) {
                    if (this.internalClock % 300 == 0) {
                        this.decreaseHunger();

                        if (this.getHunger() == (this.getMaxHunger() / 2)) {
                            this.sendMessageToOwnerOrElseAll(DinoSituation.HUNGRY);
                        }
                    }

                    if (this.getHunger() < 0) {
                        if (this.isTame()) {
                            this.sendMessageToOwnerOrElseAll(DinoSituation.STARVE_ESCAPE);
                            this.setCommand(DinosaurCommand.FREE_MOVE);
                            this.setOwnerUUID(null);
                        }
                        if (this.internalClock % 100 == 0) {
                            this.sendMessageToOwnerOrElseAll(DinoSituation.STARVE);
                        }
                        this.hurt(new DamageSource(this.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(FossilsLegacyDamageTypes.ANIMAL_STARVE)), 20.0F);
                    }
                }
            }

            if (!this.isDeadOrDying()) {
                if (this.internalClock % 10 == 0) {
                    if (this.getHealth() < this.getMaxHealth()) {
                        if (this.getHunger() > this.getMaxHunger() / 2) {
                            this.setHunger(this.getHunger() - 5);
                            this.setHealth(this.getHealth() + 1.0F);
                        }
                    }
                }
            }
        }
    }

    @Override
    public float getScale() {
        return 1.0F + (((float) this.getBoundingBoxGrowth()) * ((float) this.getGrowthStage()));
    }

    @Override
    public void die(DamageSource damageSource) {
        if (!this.level().isClientSide && this.level().getGameRules().getBoolean(GameRules.RULE_SHOWDEATHMESSAGES) && this.getOwner() instanceof ServerPlayer) {
            this.getOwner().sendSystemMessage(this.getCombatTracker().getDeathMessage());
        }
        super.die(damageSource);
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!this.isTame()) {
            return false;
        } else if (!(animal instanceof Dinosaur)) {
            return false;
        } else {
            Dinosaur dinosaur = (Dinosaur) animal;
            if (!dinosaur.isTame()) {
                return false;
            } else if (dinosaur.getCommand() == DinosaurCommand.STAY) {
                return false;
            } else {
                return this.isInLove() && dinosaur.isInLove();
            }
        }
    }

    public InteractionResult additionalInteractions(Player player, Vec3 vec3, InteractionHand interactionHand) {
        return super.interactAt(player, vec3, interactionHand);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec3, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        if (this.isTame() && this.isOwnedBy(player)) {
            if (this.commandItems().canCommand(player, interactionHand)) {
                DinosaurCommand dinosaurCommand = DinosaurCommand.getNext(this.getCommand());
                this.setCommand(dinosaurCommand);
                player.displayClientMessage(FossilsLegacyUtils.translation("command", "command.use", dinosaurCommand.getComponent().getString()), true);
                return InteractionResult.SUCCESS;
            }
        }

        if (this.getDiet().getItemStackFoodValue(itemStack) > 0) {
            int addition = this.getHunger() + this.getDiet().getItemStackFoodValue(itemStack);
            if (!(addition > this.getMaxHunger())) {
                this.setHunger(addition);
            } else {
                this.setHunger(this.getMaxHunger());
                if (!this.level().isClientSide && !this.isBaby() && this.canFallInLove()) {
                    this.usePlayerItem(player, interactionHand, itemStack);
                    this.setInLove(player);
                    return InteractionResult.SUCCESS;
                } else {
                    this.sendMessageToPlayer(DinoSituation.FULL, player);
                }
            }
            itemStack.shrink(1);
            return InteractionResult.SUCCESS;
        }


        return this.additionalInteractions(player, vec3, interactionHand);
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

    public boolean feed() {
        if (this.getHunger() < this.getMaxHunger()) {
            this.setHunger(this.getHunger() + 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(COMMAND, 0);
        this.entityData.define(GROWTH_STAGE, 0);
        this.entityData.define(DAYS_ALIVE, 0);
        this.entityData.define(HUNGER, this.getMaxHunger());
        this.entityData.define(OWNER, Optional.empty());
    }

    @Override
    public void setGrowthStage(int growthStage) {
        this.entityData.set(GROWTH_STAGE, growthStage);
    }

    @Override
    public int getGrowthStage() {
        return this.entityData.get(GROWTH_STAGE);
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

    public boolean isOwnedBy(LivingEntity livingEntity) {
        return livingEntity == this.getOwner();
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

    @Override
    public boolean canAttack(LivingEntity livingEntity) {
        if (this.isOwnedBy(livingEntity)) {
            return false;
        }
        return super.canAttack(livingEntity);
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
    public DinosaurCommand getCommand() {
        return DinosaurCommand.values()[this.entityData.get(COMMAND)];
    }

    @Override
    public void setCommand(DinosaurCommand dinosaurOrder) {
        this.entityData.set(COMMAND, dinosaurOrder.ordinal());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);

        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }

        DinosaurCommand.save(compoundTag, this.getCommand());
        compoundTag.putInt("DaysAlive", this.getDaysAlive());
        compoundTag.putInt("Hunger", this.getHunger());
        compoundTag.putInt("GrowthStage", this.getGrowthStage());
        compoundTag.putInt("InternalClock", this.internalClock);
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
            } catch (Throwable throwable) {
            }
        }

        DinosaurCommand.load(compoundTag);
        this.setDaysAlive(compoundTag.getInt("DaysAlive"));
        this.setHunger(compoundTag.getInt("Hunger"));
        this.setGrowthStage(compoundTag.getInt("GrowthStage"));
        this.internalClock = compoundTag.getInt("InternalClock");
    }

    @Override
    public void ate() {
        this.setHunger(this.getMaxHunger());
        super.ate();
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        if (this.getEggVariant() != null) {
            Egg egg = FossilsLegacyEntityTypes.EGG.get().create(serverLevel);
            egg.setEggVariant(this.getEggVariant());
            if (egg != null) {
                UUID uuid = this.getOwnerUUID();
                if (uuid != null) {
                    egg.setOwnerUUID(uuid);
                }
            }
            return egg;
        } else {
            return null;
        }
    }
}
