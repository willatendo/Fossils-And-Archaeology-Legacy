package willatendo.fossilslegacy.server.entity;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.players.OldUsersConverter;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;
import org.apache.commons.compress.utils.Lists;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.util.interfaces.CoatTypeEntity;
import willatendo.fossilslegacy.server.entity.util.interfaces.DinopediaInformation;
import willatendo.fossilslegacy.server.entity.util.interfaces.TicksToBirth;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.*;

public class Egg extends Animal implements TicksToBirth, DinopediaInformation {
    private static final EntityDataAccessor<Holder<EggVariant>> EGG_VARIANT = SynchedEntityData.defineId(Egg.class, FossilsLegacyEntityDataSerializers.EGG_VARIANTS.get());
    private static final EntityDataAccessor<Holder<CoatType>> COAT_TYPE = SynchedEntityData.defineId(Egg.class, FossilsLegacyEntityDataSerializers.COAT_TYPES.get());
    public static final MapCodec<Holder<CoatType>> VARIANT_MAP_CODEC = CoatType.CODEC.fieldOf("CoatType");
    public static final Codec<Holder<CoatType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();
    private static final EntityDataAccessor<Integer> REMAINING_TIME = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> WARM = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Optional<UUID>> OWNER = SynchedEntityData.defineId(Egg.class, EntityDataSerializers.OPTIONAL_UUID);

    public Egg(EntityType<? extends Egg> egg, Level level) {
        super(egg, level);
    }

    public static AttributeSupplier eggAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0F).build();
    }

    @Override
    protected void dropExperience(Entity entity) {
    }

    @Override
    public void knockback(double xVelc, double yVelc, double zVelc) {
    }

    @Override
    protected ResourceKey<LootTable> getDefaultLootTable() {
        return this.getEggVariant().value().lootTable();
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
        return this.getEggVariant().value().pick().get().getDefaultInstance();
    }

    @Override
    public void onEntityTicksComplete(Mob mob, Entity offspring, Level level) {
        if (offspring instanceof CoatTypeEntity coatTypeEntity) {
            coatTypeEntity.setCoatType(this.getCoatType());
        }
    }

    @Override
    public void tick() {
        super.tick();

        this.setWarm(this.getEggVariant().value().shouldIncubate(this));

        if (this.getRemainingTime() < -500) {
            Player player = this.level().getNearestPlayer(this, 25.0D);
            if (player != null) {
                if (this.getEggVariant().value().wet()) {
                    player.sendSystemMessage(FossilsLegacyUtils.translation("entity", "egg.died.dry"));
                } else {
                    player.sendSystemMessage(FossilsLegacyUtils.translation("entity", "egg.died"));
                }
                this.discard();
            }
        }

        if (!this.isWarm()) {
            this.setRemainingTime(this.getRemainingTime() - 1);
        }

        if (this.getEggVariant().value().shouldIncubate(this)) {
            this.birthTick(this, this.level(), this.getOwnerUUID() != null ? Optional.of(this.getOwnerUUID()) : Optional.empty());
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(EGG_VARIANT, FossilsLegacyBuiltInRegistries.EGG_VARIANTS.getHolderOrThrow(FossilsLegacyEggVariants.TRICERATOPS.getKey()));
        builder.define(COAT_TYPE, this.registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES).getAny().orElseThrow());
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

        compoundTag.putString("Variant", this.getEggVariant().unwrapKey().orElse(FossilsLegacyEggVariants.TRICERATOPS.getKey()).location().toString());
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

        Optional<ResourceKey<EggVariant>> eggVariant = Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("Variant"))).map(resourceLocation -> ResourceKey.create(FossilsLegacyRegistries.EGG_VARIANTS, resourceLocation));
        Registry<EggVariant> registry = FossilsLegacyBuiltInRegistries.EGG_VARIANTS;
        Objects.requireNonNull(registry);
        eggVariant.flatMap(registry::getHolder).ifPresent(this::setEggVariant);
        VARIANT_CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setCoatType);
        this.setRemainingTime(compoundTag.getInt("RemainingTime"));
        this.setWarm(compoundTag.getBoolean("Warm"));
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public Entity getOffspring(Level level) {
        return this.getEggVariant().value().entityType().get().create(level);
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

    public Holder<EggVariant> getEggVariant() {
        return this.entityData.get(EGG_VARIANT);
    }

    public void setEggVariant(Holder<EggVariant> eggVariant) {
        this.entityData.set(EGG_VARIANT, eggVariant);
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
    public List<Component> info(Player player) {
        ArrayList<Component> information = Lists.newArrayList();
        information.add(FossilsLegacyUtils.translation("dinopedia", "egg", this.getEggVariant().value().entityType().get().getDescription().getString()));
        information.add(FossilsLegacyUtils.translation("dinopedia", "remaining_time", (int) Math.floor((((float) this.getRemainingTime()) / this.maxTime()) * 100) + "%"));
        information.add(FossilsLegacyUtils.translation("dinopedia", "status", this.getEggVariant().value().getTemperature(this)));
        return information;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
}
