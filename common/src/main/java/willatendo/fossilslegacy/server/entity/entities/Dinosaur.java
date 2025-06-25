package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.command_type.FACommandTypes;
import willatendo.fossilslegacy.server.entity.FADamageTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.Diet;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.interfaces.*;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
import willatendo.fossilslegacy.server.pattern.pattern.Pattern;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAPatternTags;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;
import java.util.UUID;

public abstract class Dinosaur extends Animal implements DataDrivenCosmetics, CommandableEntity, DaysAliveAccessor, GrowingEntity, HungerAccessor, OwnableEntity, TamesOnBirth, TameAccessor, TamedSpeakingEntity, TranquilizableEntity {
    private static final EntityDataAccessor<Holder<ModelType>> MODEL_TYPE = SynchedEntityData.defineId(Dinosaur.class, FAEntityDataSerializers.MODEL_TYPES.get());
    private static final EntityDataAccessor<Holder<Pattern>> SKIN = SynchedEntityData.defineId(Dinosaur.class, FAEntityDataSerializers.PATTERN.get());
    private static final EntityDataAccessor<Holder<Pattern>> PATTERN = SynchedEntityData.defineId(Dinosaur.class, FAEntityDataSerializers.PATTERN.get());
    private static final EntityDataAccessor<Holder<CommandType>> COMMAND = SynchedEntityData.defineId(Dinosaur.class, FAEntityDataSerializers.COMMAND_TYPES.get());
    private static final EntityDataAccessor<Integer> DAYS_ALIVE = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> GROWTH_STAGE = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> HUNGER = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TRANQUILIZE_TIME = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> TRANQUILIZED = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Dinosaur.class, EntityDataSerializers.OPTIONAL_UUID);
    protected int internalClock = 0;

    public Dinosaur(EntityType<? extends Dinosaur> entityType, Level level) {
        super(entityType, level);
    }

    public static boolean checkDinosaurSpawnRules(EntityType<? extends Dinosaur> dinosaur, LevelAccessor levelAccessor, EntitySpawnReason entitySpawnReason, BlockPos blockPos, RandomSource randomSource, TagKey<Block> spawnableBlocks) {
        boolean flag = EntitySpawnReason.ignoresLightRequirements(entitySpawnReason) || Animal.isBrightEnoughToSpawn(levelAccessor, blockPos);
        return levelAccessor.getBlockState(blockPos.below()).is(spawnableBlocks) && flag;
    }

    public abstract TagKey<ModelType> getModelTypes();

    public abstract Diet getDiet();

    public EntityType<Egg> getEggEntityType() {
        return null;
    }

    @Override
    public Level getLevel() {
        return this.level();
    }

    @Override
    protected Component getTypeName() {
        return this.getOverridenName(super.getTypeName());
    }

    public float getBoundingBoxGrowth() {
        ModelType modelType = this.getModelType().value();
        return modelType.boundingBoxInfo().boundingBoxGrowth();
    }

    @Override
    protected EntityDimensions getDefaultDimensions(Pose pose) {
        return this.dimensions = this.getEntityDimensions(this.getGrowthStage());
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, EntitySpawnReason entitySpawnReason, SpawnGroupData spawnGroupData) {
        HolderLookup<ModelType> modelTypes = serverLevelAccessor.holderLookup(FARegistries.MODEL_TYPES);
        Holder<ModelType> modelType = modelTypes.getOrThrow(this.getModelTypes()).getRandomElement(this.getRandom()).get();
        this.setModelType(modelType);
        HolderLookup<Pattern> patterns = serverLevelAccessor.holderLookup(FARegistries.PATTERN);
        Holder<Pattern> skin = patterns.getOrThrow(modelType.value().skins()).getRandomElement(this.getRandom()).get();
        this.setSkin(skin);
        if (skin.is(FAPatternTags.HAS_PATTERNS) && serverLevelAccessor.getRandom().nextInt(4) == 1) {
            Holder<Pattern> pattern = patterns.getOrThrow(modelType.value().patterns()).getRandomElement(this.getRandom()).get();
            this.setPattern(pattern);
        } else {
            this.setPattern(patterns.getOrThrow(FAPatterns.BLANK));
        }

        this.setHunger(this.getMaxHunger());
        if (EntitySpawnReason.isSpawner(entitySpawnReason) || entitySpawnReason == EntitySpawnReason.COMMAND || entitySpawnReason == EntitySpawnReason.MOB_SUMMONED || entitySpawnReason == EntitySpawnReason.NATURAL || entitySpawnReason == EntitySpawnReason.CHUNK_GENERATION) {
            this.setGrowthStage(this.getMaxGrowthStage());
        }
        this.refreshDimensions();
        this.setCommand(FACommandTypes.FREE_MOVE);
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, entitySpawnReason, spawnGroupData);
    }

    @Override
    public boolean killedEntity(ServerLevel serverLevel, LivingEntity livingEntity) {
        if (this.getDiet().getsFoodFromKill()) {
            this.increaseHunger(this.getDiet().getEntityFoodValue(livingEntity));
        }
        return super.killedEntity(serverLevel, livingEntity);
    }

    public boolean hasSpace() {
        EntityDimensions entityDimensions = this.getDimensions(this.getPose());
        EntityDimensions updatedDimensions = entityDimensions.scale(1.0F + (this.getBoundingBoxGrowth() * ((float) this.getGrowthStage() + 1.0F)));
        return !this.level().getBlockCollisions(this, updatedDimensions.makeBoundingBox(this.position())).iterator().hasNext();
    }

    @Override
    public int getAmbientSoundInterval() {
        return 360;
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
        if (!this.isNoAi()) {
            this.tranquilizedTick();

            if (this.dimensions.width() != this.getEntityDimensions(this.getGrowthStage()).width() || this.dimensions.height() != this.getEntityDimensions(this.getGrowthStage()).height()) {
                this.refreshDimensions();
            }

            if (this.internalClock == Level.TICKS_PER_DAY) {
                this.internalClock = 0;
            }

            this.internalClock++;
        }

        super.tick();

        if (!this.isNoAi()) {
            if (this.level() instanceof ServerLevel serverLevel && serverLevel.getGameRules().getBoolean(FAGameRules.RULE_DOANIMALGROWTH)) {
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

            if (this.level() instanceof ServerLevel serverLevel && serverLevel.getGameRules().getBoolean(FAGameRules.RULE_DOANIMALHUNGER)) {
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
                            this.setCommand(FACommandTypes.FREE_MOVE);
                            this.setOwnerUUID(null);
                        }
                        if (this.internalClock % 100 == 0) {
                            this.sendMessageToOwnerOrElseAll(DinoSituation.STARVE);
                        }
                        this.hurt(new DamageSource(this.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(FADamageTypes.ANIMAL_STARVE)), 20.0F);
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

    public float renderScaleWidth() {
        ModelType modelType = this.getModelType().value();
        return modelType.ageScaleInfo().baseScaleWidth() + (modelType.ageScaleInfo().ageScale() * (float) this.getGrowthStage());
    }

    public float renderScaleHeight() {
        ModelType modelType = this.getModelType().value();
        return modelType.ageScaleInfo().baseScaleHeight() + (modelType.ageScaleInfo().ageScale() * (float) this.getGrowthStage());
    }

    @Override
    public void die(DamageSource damageSource) {
        if (this.level() instanceof ServerLevel serverLevel && serverLevel.getGameRules().getBoolean(GameRules.RULE_SHOWDEATHMESSAGES) && this.getOwner() instanceof ServerPlayer serverPlayer) {
            serverPlayer.sendSystemMessage(this.getCombatTracker().getDeathMessage());
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
                Holder<CommandType> nextCommandType = CommandType.getNext(this.getCommand());
                this.setCommand(nextCommandType);
                player.displayClientMessage(FAUtils.translation("command_type", "command.use", nextCommandType.value().getDescription().getString()), true);
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
                    if (player instanceof ServerPlayer serverPlayer) {
                        this.sendMessageToPlayer(DinoSituation.FULL, serverPlayer);
                    }
                }
            }
            itemStack.shrink(1);
            return InteractionResult.SUCCESS;
        }

        if (itemStack.is(FAItems.ROMANTIC_CONCOCTION_BOTTLE.get())) {
            if (!this.level().isClientSide() && this.isTame() && !this.isBaby() && this.canFallInLove()) {
                this.usePlayerItem(player, interactionHand, itemStack);
                this.setInLove(player);
                return InteractionResult.SUCCESS;
            }
        }

        return this.additionalInteractions(player, vec3, interactionHand);
    }

    @Override
    public void refreshDimensions() {
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        super.refreshDimensions();
        this.setPos(x, y, z);
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
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(MODEL_TYPE, this.registryAccess().lookupOrThrow(FARegistries.MODEL_TYPES).getAny().orElseThrow());
        builder.define(SKIN, this.registryAccess().lookupOrThrow(FARegistries.PATTERN).getAny().orElseThrow());
        builder.define(PATTERN, this.registryAccess().lookupOrThrow(FARegistries.PATTERN).getAny().orElse(this.level().holderLookup(FARegistries.PATTERN).getOrThrow(FAPatterns.BLANK)));
        builder.define(COMMAND, this.registryAccess().lookupOrThrow(FARegistries.COMMAND_TYPES).getAny().orElseThrow());
        builder.define(GROWTH_STAGE, 0);
        builder.define(DAYS_ALIVE, 0);
        builder.define(HUNGER, this.getMaxHunger());
        builder.define(TRANQUILIZE_TIME, 0);
        builder.define(TRANQUILIZED, false);
        builder.define(OWNER, Optional.empty());
    }

    @Override
    public void setGrowthStage(int growthStage) {
        this.entityData.set(GROWTH_STAGE, growthStage);
        this.reapplyPosition();
        this.refreshDimensions();

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

    @Override
    public void setTranquilizeTime(int tranquilizeTime) {
        this.entityData.set(TRANQUILIZE_TIME, tranquilizeTime);
    }

    @Override
    public int getTranquilizeTime() {
        return this.entityData.get(TRANQUILIZE_TIME);
    }

    @Override
    public void setTranquilized(boolean tranquilized) {
        this.entityData.set(TRANQUILIZED, tranquilized);
    }

    @Override
    public boolean isTranquilized() {
        return this.entityData.get(TRANQUILIZED);
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
    public Holder<CommandType> getCommand() {
        return this.entityData.get(COMMAND);
    }

    @Override
    public void setCommand(Holder<CommandType> commandType) {
        this.entityData.set(COMMAND, commandType);
    }

    @Override
    public Holder<ModelType> getModelType() {
        return this.entityData.get(MODEL_TYPE);
    }

    @Override
    public void setModelType(Holder<ModelType> modelType) {
        this.entityData.set(MODEL_TYPE, modelType);
    }

    @Override
    public Holder<Pattern> getSkin() {
        return this.entityData.get(SKIN);
    }

    @Override
    public void setSkin(Holder<Pattern> pattern) {
        this.entityData.set(SKIN, pattern);
    }

    @Override
    public Holder<Pattern> getPattern() {
        return this.entityData.get(PATTERN);
    }

    @Override
    public void setPattern(Holder<Pattern> pattern) {
        this.entityData.set(PATTERN, pattern);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);

        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }

        this.addCosmeticsData(compoundTag, this.registryAccess());
        this.addCommandType(compoundTag, this.registryAccess());
        this.addTranquilizeData(compoundTag, this.registryAccess());
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

        this.readCosmeticsData(compoundTag, this.registryAccess());
        this.readCommandType(compoundTag, this.registryAccess());
        this.readTranquilizeData(compoundTag, this.registryAccess());
        super.readAdditionalSaveData(compoundTag);
        this.setDaysAlive(compoundTag.getInt("DaysAlive"));
        this.setHunger(compoundTag.getInt("Hunger"));
        this.setGrowthStage(compoundTag.getInt("GrowthStage"));
        this.internalClock = compoundTag.getInt("InternalClock");
    }

    @Override
    public CompoundTag saveWithoutId(CompoundTag compoundTag) {
        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }

        this.addCosmeticsData(compoundTag, this.registryAccess());
        this.addCommandType(compoundTag, this.registryAccess());
        this.addTranquilizeData(compoundTag, this.registryAccess());
        compoundTag.putInt("DaysAlive", this.getDaysAlive());
        compoundTag.putInt("Hunger", this.getHunger());
        compoundTag.putInt("GrowthStage", this.getGrowthStage());
        compoundTag.putInt("InternalClock", this.internalClock);

        return super.saveWithoutId(compoundTag);
    }

    @Override
    public boolean save(CompoundTag compoundTag) {
        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }

        this.addCosmeticsData(compoundTag, this.registryAccess());
        this.addCommandType(compoundTag, this.registryAccess());
        this.addTranquilizeData(compoundTag, this.registryAccess());
        compoundTag.putInt("DaysAlive", this.getDaysAlive());
        compoundTag.putInt("Hunger", this.getHunger());
        compoundTag.putInt("GrowthStage", this.getGrowthStage());
        compoundTag.putInt("InternalClock", this.internalClock);

        return super.save(compoundTag);
    }

    @Override
    public void ate() {
        this.setHunger(this.getMaxHunger());
        super.ate();
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        if (this.getEggEntityType() != null) {
            Egg egg = this.getEggEntityType().create(serverLevel, EntitySpawnReason.BREEDING);
            if (this.getModelType() != null) {
                egg.setModelType(this.getModelType());
            }
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

    @Override
    public void makeSound(SoundEvent soundEvent) {
        if (!this.isTranquilized()) {
            super.makeSound(soundEvent);
        }
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.NEUTRAL;
    }
}
