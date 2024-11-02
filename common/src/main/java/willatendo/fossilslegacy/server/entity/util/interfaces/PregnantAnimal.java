package willatendo.fossilslegacy.server.entity.util.interfaces;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyBuiltInRegistries;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyPregnancyTypes;
import willatendo.fossilslegacy.server.entity.dinosaur.quaternary.Mammoth;
import willatendo.fossilslegacy.server.entity.dinosaur.quaternary.Smilodon;
import willatendo.fossilslegacy.server.entity.pregnant.PregnantSheep;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.Objects;
import java.util.Optional;

public interface PregnantAnimal<T extends Entity> extends TicksToBirth<T>, SimpleLevelAccessor {
    MapCodec<Holder<CoatType>> VARIANT_MAP_CODEC = CoatType.CODEC.fieldOf("OffspringCoatType");
    Codec<Holder<CoatType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();

    int getRemainingPregnancyTime();

    void setRemainingPregnancyTime(int remainingPregnancyTime);

    @Override
    default int getRemainingTime() {
        return this.getRemainingPregnancyTime();
    }

    @Override
    default void setRemainingTime(int remainingPregnancyTime) {
        this.setRemainingPregnancyTime(remainingPregnancyTime);
    }

    Holder<PregnancyType> getPregnancyType();

    void setPregnancyType(Holder<PregnancyType> pregnancyType);

    Holder<CoatType> getOffspringCoatType();

    void setOffspringCoatType(Holder<CoatType> coatTypeHolder);

    T getBaseEntity(Level level);

    @Override
    default int maxTime() {
        return 6000;
    }

    static <T extends Entity> T getFromLivingEntity(LivingEntity livingEntity, Level level) {
        T finalEntity = null;
        if (livingEntity instanceof PregnantAnimal) {
            return null;
        }
        if (livingEntity instanceof Armadillo) {
            finalEntity = (T) EntityType.ARMADILLO.create(level);
        }
        if (livingEntity instanceof Cat) {
            finalEntity = (T) EntityType.CAT.create(level);
        }
        if (livingEntity instanceof Cow) {
            finalEntity = (T) EntityType.COW.create(level);
        }
        if (livingEntity instanceof Dolphin) {
            finalEntity = (T) EntityType.DOLPHIN.create(level);
        }
        if (livingEntity instanceof Donkey) {
            finalEntity = (T) EntityType.DONKEY.create(level);
        }
        if (livingEntity instanceof Fox) {
            finalEntity = (T) EntityType.FOX.create(level);
        }
        if (livingEntity instanceof Goat) {
            finalEntity = (T) EntityType.GOAT.create(level);
        }
        if (livingEntity instanceof Horse) {
            finalEntity = (T) EntityType.HORSE.create(level);
        }
        if (livingEntity instanceof Llama) {
            finalEntity = (T) EntityType.LLAMA.create(level);
        }
        if (livingEntity instanceof Mule) {
            finalEntity = (T) EntityType.MULE.create(level);
        }
        if (livingEntity instanceof Ocelot) {
            finalEntity = (T) EntityType.OCELOT.create(level);
        }
        if (livingEntity instanceof Panda) {
            finalEntity = (T) EntityType.PANDA.create(level);
        }
        if (livingEntity instanceof Pig) {
            finalEntity = (T) EntityType.PIG.create(level);
        }
        if (livingEntity instanceof PolarBear) {
            finalEntity = (T) EntityType.POLAR_BEAR.create(level);
        }
        if (livingEntity instanceof Rabbit) {
            finalEntity = (T) EntityType.RABBIT.create(level);
        }
        if (livingEntity instanceof Sheep) {
            finalEntity = (T) EntityType.SHEEP.create(level);
        }
        if (livingEntity instanceof Wolf) {
            finalEntity = (T) EntityType.WOLF.create(level);
        }
        if (livingEntity instanceof Mammoth) {
            finalEntity = (T) FossilsLegacyEntityTypes.MAMMOTH.get().create(level);
        }
        if (livingEntity instanceof Smilodon) {
            finalEntity = (T) FossilsLegacyEntityTypes.SMILODON.get().create(level);
        }
        return finalEntity;
    }

    static PregnantAnimal createFromLiving(LivingEntity livingEntity, Level level) {
        livingEntity.remove(RemovalReason.DISCARDED);
        Entity toCreate = null;
        if (livingEntity instanceof Armadillo) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_ARMADILLO.get().create(level);
        }
        if (livingEntity instanceof Cat) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_CAT.get().create(level);
        }
        if (livingEntity instanceof Cow) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_COW.get().create(level);
        }
        if (livingEntity instanceof Dolphin) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get().create(level);
        }
        if (livingEntity instanceof Donkey) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_DONKEY.get().create(level);
        }
        if (livingEntity instanceof Fox) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_FOX.get().create(level);
        }
        if (livingEntity instanceof Goat) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_GOAT.get().create(level);
        }
        if (livingEntity instanceof Horse) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_HORSE.get().create(level);
        }
        if (livingEntity instanceof Llama) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_LLAMA.get().create(level);
        }
        if (livingEntity instanceof Mule) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_MULE.get().create(level);
        }
        if (livingEntity instanceof Ocelot) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_OCELOT.get().create(level);
        }
        if (livingEntity instanceof Panda) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_PANDA.get().create(level);
        }
        if (livingEntity instanceof Pig) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_PIG.get().create(level);
        }
        if (livingEntity instanceof PolarBear) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get().create(level);
        }
        if (livingEntity instanceof Rabbit) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_RABBIT.get().create(level);
        }
        if (livingEntity instanceof Sheep sheep) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_SHEEP.get().create(level);
            ((PregnantSheep) toCreate).setColor(sheep.getColor());
        }
        if (livingEntity instanceof Wolf) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_WOLF.get().create(level);
        }
        if (livingEntity instanceof Mammoth) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get().create(level);
        }
        if (livingEntity instanceof Smilodon) {
            toCreate = FossilsLegacyEntityTypes.PREGNANT_SMILODON.get().create(level);
        }
        toCreate.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.getYRot(), livingEntity.getXRot());
        level.addFreshEntity(toCreate);
        return (PregnantAnimal) toCreate;
    }

    default void onRemove(Mob original, Entity replaced) {
    }

    @Override
    default void onEntityTicksComplete(Mob mob, Entity offspring, Level level) {
        Entity replaced = this.getBaseEntity(level);
        replaced.moveTo(mob.getX(), mob.getY(), mob.getZ(), mob.getYRot(), mob.getXRot());
        level.addFreshEntity(replaced);
        if (replaced instanceof TameAccessor tameAccessor) {
            tameAccessor.setOwnerUUID(((TameAccessor) mob).getOwnerUUID());
        }
        if (replaced instanceof HungerAccessor hungerAccessor) {
            hungerAccessor.setHunger(((HungerAccessor) mob).getHunger());
        }
        this.onRemove(mob, replaced);
    }

    default void definePregnancyData(EntityDataAccessor<Holder<PregnancyType>> pregnancy, SynchedEntityData.Builder builder) {
        builder.define(pregnancy, FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES.getHolderOrThrow(FossilsLegacyPregnancyTypes.CAT.getKey()));
    }

    default void defineCoatTypeData(EntityDataAccessor<Holder<CoatType>> pregnancy, SynchedEntityData.Builder builder) {
        builder.define(pregnancy, this.getLevel().registryAccess().registryOrThrow(FossilsLegacyRegistries.COAT_TYPES).getAny().orElseThrow());
    }

    default void addRemainingPregnancyTime(CompoundTag compoundTag) {
        compoundTag.putInt("PregnancyTime", this.getRemainingTime());
    }

    default void readRemainingPregnancyTime(CompoundTag compoundTag) {
        this.setRemainingPregnancyTime(compoundTag.getInt("PregnancyTime"));
    }

    default void addPregnancyData(CompoundTag compoundTag) {
        compoundTag.putString("Variant", this.getPregnancyType().unwrapKey().orElse(FossilsLegacyPregnancyTypes.CAT.getKey()).location().toString());
    }

    default void readPregnancyData(CompoundTag compoundTag) {
        Optional<ResourceKey<PregnancyType>> eggVariant = Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("Variant"))).map((resourceLocation) -> ResourceKey.create(FossilsLegacyRegistries.PREGNANCY_TYPES, resourceLocation));
        Registry<PregnancyType> registry = FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES;
        Objects.requireNonNull(registry);
        eggVariant.flatMap(registry::getHolder).ifPresent(this::setPregnancyType);
    }

    default void addCoatTypeData(CompoundTag compoundTag) {
        VARIANT_CODEC.encodeStart(this.getLevel().registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getOffspringCoatType()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
    }

    default void readCoatTypeData(CompoundTag compoundTag) {
        VARIANT_CODEC.parse(this.getLevel().registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setOffspringCoatType);
    }
}
