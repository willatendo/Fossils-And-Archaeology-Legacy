package willatendo.fossilslegacy.server.entity.entities;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
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
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.dinopedia_type.DinopediaType;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FAEntityDataSerializers;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.TicksToBirth;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

public abstract class Egg extends Animal implements TicksToBirth, DinopediaInformation {
    private static final EntityDataAccessor<Holder<CoatType>> COAT_TYPE = SynchedEntityData.defineId(Egg.class, FAEntityDataSerializers.COAT_TYPES.get());
    public static final MapCodec<Holder<CoatType>> VARIANT_MAP_CODEC = CoatType.CODEC.fieldOf("CoatType");
    public static final Codec<Holder<CoatType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();
    private static final EntityDataAccessor<Integer> REMAINING_TIME = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> WARM = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.OPTIONAL_UUID);

    public Egg(EntityType<? extends Egg> entityType, Level level) {
        super(entityType, level);
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
            Player player = this.level().getNearestPlayer(this, 25.0D);
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
        builder.define(COAT_TYPE, this.registryAccess().lookupOrThrow(FARegistries.COAT_TYPES).getAny().orElseThrow());
        builder.define(REMAINING_TIME, 0);
        builder.define(WARM, false);
        builder.define(OWNER, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);

        if (this.getOwnerUUID() != null) {
            compoundTag.putUUID("Owner", this.getOwnerUUID());
        }

        VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getCoatType()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
        compoundTag.putInt("RemainingTime", this.getRemainingTime());
        compoundTag.putBoolean("Warm", this.isWarm());
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

        VARIANT_CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setCoatType);
        this.setRemainingTime(compoundTag.getInt("RemainingTime"));
        this.setWarm(compoundTag.getBoolean("Warm"));
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

    public Holder<CoatType> getCoatType() {
        return this.entityData.get(COAT_TYPE);
    }

    public void setCoatType(Holder<CoatType> coatTypeHolder) {
        this.entityData.set(COAT_TYPE, coatTypeHolder);
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
        return this.entityData.get(OWNER).orElse((UUID) null);
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
