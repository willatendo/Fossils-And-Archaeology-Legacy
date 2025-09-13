package willatendo.fossilslegacy.server.entity.entities;

import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.ChromosomedEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.TicksToBirth;
import willatendo.fossilslegacy.server.gene.Chromosome;
import willatendo.fossilslegacy.server.gene.cosmetics.model.ModelGene;
import willatendo.fossilslegacy.server.gene.cosmetics.pattern.PatternGene;
import willatendo.fossilslegacy.server.gene.cosmetics.skin.SkinGene;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public abstract class Egg extends Animal implements TicksToBirth, DinopediaInformation, ChromosomedEntity {
    private static final EntityDataAccessor<Chromosome> CHROMOSOME_1 = SynchedEntityData.defineId(Egg.class, FAEntityDataSerializers.CHROMOSOME.get());
    private static final EntityDataAccessor<Chromosome> CHROMOSOME_2 = SynchedEntityData.defineId(Egg.class, FAEntityDataSerializers.CHROMOSOME.get());
    private static final EntityDataAccessor<Integer> REMAINING_TIME = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> WARM = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.OPTIONAL_UUID);
    public final Registry<ModelGene> modelGeneRegistry;
    public final Registry<PatternGene> patternGeneRegistry;
    public final Registry<SkinGene> skinGeneRegistry;

    public Egg(EntityType<? extends Egg> entityType, Level level) {
        super(entityType, level);
        this.modelGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.MODEL_GENE);
        this.patternGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.PATTERN_GENE);
        this.skinGeneRegistry = level.registryAccess().lookupOrThrow(FARegistries.SKIN_GENE);
    }

    public static <I extends Item, E extends Entity> Egg createLand(EntityType<? extends Egg> entityType, Level level, Supplier<I> item, Supplier<EntityType<E>> offspring) {
        return new Egg(entityType, level) {
            @Override
            public boolean shouldIncubate() {
                return this.level().getBrightness(LightLayer.BLOCK, this.blockPosition()) > 10.0F;
            }

            @Override
            public boolean isWet() {
                return false;
            }

            @Override
            public ItemStack getPick() {
                return new ItemStack(item.get());
            }

            @Override
            public EntityType<E> getOffspringType() {
                return offspring.get();
            }
        };
    }

    public static <I extends Item, E extends Entity> Egg createWater(EntityType<? extends Egg> entityType, Level level, Supplier<I> item, Supplier<EntityType<E>> offspring) {
        return new Egg(entityType, level) {
            @Override
            public boolean shouldIncubate() {
                return this.isInWaterOrBubble();
            }

            @Override
            public boolean isWet() {
                return true;
            }

            @Override
            public ItemStack getPick() {
                return new ItemStack(item.get());
            }

            @Override
            public EntityType<E> getOffspringType() {
                return offspring.get();
            }
        };
    }

    public static AttributeSupplier eggAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0F).build();
    }

    public abstract boolean shouldIncubate();

    public abstract boolean isWet();

    public abstract ItemStack getPick();

    public abstract <T extends Entity> EntityType<T> getOffspringType();

    @Override
    public Registry<ModelGene> getModelGeneRegistry() {
        return this.modelGeneRegistry;
    }

    @Override
    public Registry<SkinGene> getSkinGeneRegistry() {
        return this.skinGeneRegistry;
    }

    @Override
    public Registry<PatternGene> getPatternGeneRegistry() {
        return this.patternGeneRegistry;
    }

    @Override
    public void onEntityTicksComplete(Mob mob, Entity offspring, Level level) {
        TicksToBirth.super.onEntityTicksComplete(mob, offspring, level);
        if (offspring instanceof ChromosomedEntity chromosomedEntity) {
            chromosomedEntity.setChromosome1(this.getChromosome1());
            chromosomedEntity.setChromosome2(this.getChromosome2());
        }
    }

    public Component getTemperature() {
        if (this.isWet()) {
            return this.shouldIncubate() ? FAUtils.translation("dinopedia", "wet") : FAUtils.translation("dinopedia", "dry");
        } else {
            return this.shouldIncubate() ? FAUtils.translation("dinopedia", "warm") : FAUtils.translation("dinopedia", "cold");
        }
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getOffspringType().create(level, EntitySpawnReason.BREEDING);
    }

    @Override
    protected void dropExperience(ServerLevel serverLevel, Entity entity) {
    }

    @Override
    public void knockback(double xVelc, double yVelc, double zVelc) {
    }

    @Override
    public void die(DamageSource damageSource) {
        Level level = this.level();
        if (level instanceof ServerLevel serverLevel) {
            this.dropAllDeathLoot(serverLevel, damageSource);
        }
        this.discard();
    }


    @Override
    public ItemStack getPickResult() {
        return this.getPick();
    }

    @Override
    public void tick() {
        super.tick();

        this.setWarm(this.shouldIncubate());

        if (this.getRemainingTime() < -500) {
            if (this.level() instanceof ServerLevel serverLevel) {
                Player player = serverLevel.getNearestPlayer(this, serverLevel.getGameRules().getInt(FAGameRules.RULE_NOTIFICATION_DISTANCE));
                if (player != null) {
                    if (player instanceof ServerPlayer serverPlayer) {
                        if (this.isWet()) {
                            serverPlayer.sendSystemMessage(FAUtils.translation("entity", "egg.died.dry"));
                        } else {
                            serverPlayer.sendSystemMessage(FAUtils.translation("entity", "egg.died"));
                        }
                    }
                    this.discard();
                }
            }
        }

        if (!this.isWarm()) {
            this.setRemainingTime(this.getRemainingTime() - 1);
        }

        if (this.shouldIncubate()) {
            this.birthTick(this, this.level(), this.getOwnerUUID() != null ? Optional.of(this.getOwnerUUID()) : Optional.empty());
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(CHROMOSOME_1, Chromosome.BLANK);
        builder.define(CHROMOSOME_2, Chromosome.BLANK);
        builder.define(REMAINING_TIME, 0);
        builder.define(WARM, false);
        builder.define(OWNER, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);

        this.saveChromosomes(compoundTag);

        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }

        compoundTag.putInt("RemainingTime", this.getRemainingTime());
        compoundTag.putBoolean("Warm", this.isWarm());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);

        this.loadChromosomes(compoundTag);

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

        this.setRemainingTime(compoundTag.getInt("RemainingTime"));
        this.setWarm(compoundTag.getBoolean("Warm"));
    }

    @Override
    public CompoundTag saveWithoutId(CompoundTag compound) {
        this.saveChromosomes(compound);

        if (this.getOwnerUUID() != null) {
            compound.putUUID("Owner", this.getOwnerUUID());
        }

        compound.putInt("RemainingTime", this.getRemainingTime());
        compound.putBoolean("Warm", this.isWarm());

        return super.saveWithoutId(compound);
    }

    @Override
    public boolean save(CompoundTag compound) {
        this.saveChromosomes(compound);

        if (this.getOwnerUUID() != null) {
            compound.putUUID("Owner", this.getOwnerUUID());
        }

        compound.putInt("RemainingTime", this.getRemainingTime());
        compound.putBoolean("Warm", this.isWarm());

        return super.save(compound);
    }

    @Override
    public void setChromosome1(Chromosome chromosome) {
        this.entityData.set(CHROMOSOME_1, chromosome);
    }

    @Override
    public Chromosome getChromosome1() {
        return this.entityData.get(CHROMOSOME_1);
    }

    @Override
    public void setChromosome2(Chromosome chromosome) {
        this.entityData.set(CHROMOSOME_2, chromosome);
    }

    @Override
    public Chromosome getChromosome2() {
        return this.entityData.get(CHROMOSOME_2);
    }


    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
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

    public boolean isOwnedBy(LivingEntity livingEntity) {
        return livingEntity == this.getOwner();
    }

    public LivingEntity getOwner() {
        try {
            UUID uuid = this.getOwnerUUID();
            return uuid == null ? null : this.level().getPlayerByUUID(uuid);
        } catch (IllegalArgumentException illegalargumentexception) {
            return null;
        }
    }

    public UUID getOwnerUUID() {
        return this.entityData.get(OWNER).orElse(null);
    }

    public void setOwnerUUID(UUID uuid) {
        this.entityData.set(OWNER, Optional.ofNullable(uuid));
    }

    @Override
    public Optional<ResourceKey<DinopediaType>> getDinopediaType() {
        return Optional.of(FADinopediaTypes.EGG);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
