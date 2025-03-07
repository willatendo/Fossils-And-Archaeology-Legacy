package willatendo.fossilslegacy.server.entity.util.interfaces;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Mammoth;
import willatendo.fossilslegacy.server.entity.entities.dinosaur.quaternary.Smilodon;
import willatendo.fossilslegacy.server.entity.entities.pregnant.PregnantSheep;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.pregnancy_types.FAPregnancyTypes;
import willatendo.fossilslegacy.server.pregnancy_types.PregnancyType;
import willatendo.fossilslegacy.server.registry.FABuiltInRegistries;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Objects;
import java.util.Optional;

public interface PregnantAnimal<T extends Entity> extends TicksToBirth, SimpleLevelAccessor {
    MapCodec<Holder<ModelType>> VARIANT_MAP_CODEC = ModelType.CODEC.fieldOf("OffspringCoatType");
    Codec<Holder<ModelType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();

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

    Holder<ModelType> getOffspringCoatType();

    void setOffspringCoatType(Holder<ModelType> coatTypeHolder);

    T getBaseEntity(Level level);

    Component getPregnantDisplayName();

    float getPregnantHealth();

    float getPregnantMaxHealth();

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
            finalEntity = (T) EntityType.ARMADILLO.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Cat) {
            finalEntity = (T) EntityType.CAT.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Cow) {
            finalEntity = (T) EntityType.COW.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Dolphin) {
            finalEntity = (T) EntityType.DOLPHIN.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Donkey) {
            finalEntity = (T) EntityType.DONKEY.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Fox) {
            finalEntity = (T) EntityType.FOX.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Goat) {
            finalEntity = (T) EntityType.GOAT.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Horse) {
            finalEntity = (T) EntityType.HORSE.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Llama) {
            finalEntity = (T) EntityType.LLAMA.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Mule) {
            finalEntity = (T) EntityType.MULE.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Ocelot) {
            finalEntity = (T) EntityType.OCELOT.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Panda) {
            finalEntity = (T) EntityType.PANDA.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Pig) {
            finalEntity = (T) EntityType.PIG.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof PolarBear) {
            finalEntity = (T) EntityType.POLAR_BEAR.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Rabbit) {
            finalEntity = (T) EntityType.RABBIT.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Sheep) {
            finalEntity = (T) EntityType.SHEEP.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Wolf) {
            finalEntity = (T) EntityType.WOLF.create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Mammoth) {
            finalEntity = (T) FAEntityTypes.MAMMOTH.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Smilodon) {
            finalEntity = (T) FAEntityTypes.SMILODON.get().create(level, EntitySpawnReason.BREEDING);
        }
        return finalEntity;
    }

    static PregnantAnimal createFromLiving(LivingEntity livingEntity, Level level) {
        livingEntity.remove(RemovalReason.DISCARDED);
        Entity toCreate = null;
        if (livingEntity instanceof Armadillo) {
            toCreate = FAEntityTypes.PREGNANT_ARMADILLO.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Cat) {
            toCreate = FAEntityTypes.PREGNANT_CAT.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Cow) {
            toCreate = FAEntityTypes.PREGNANT_COW.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Dolphin) {
            toCreate = FAEntityTypes.PREGNANT_DOLPHIN.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Donkey) {
            toCreate = FAEntityTypes.PREGNANT_DONKEY.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Fox) {
            toCreate = FAEntityTypes.PREGNANT_FOX.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Goat) {
            toCreate = FAEntityTypes.PREGNANT_GOAT.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Horse) {
            toCreate = FAEntityTypes.PREGNANT_HORSE.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Llama) {
            toCreate = FAEntityTypes.PREGNANT_LLAMA.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Mule) {
            toCreate = FAEntityTypes.PREGNANT_MULE.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Ocelot) {
            toCreate = FAEntityTypes.PREGNANT_OCELOT.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Panda) {
            toCreate = FAEntityTypes.PREGNANT_PANDA.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Pig) {
            toCreate = FAEntityTypes.PREGNANT_PIG.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof PolarBear) {
            toCreate = FAEntityTypes.PREGNANT_POLAR_BEAR.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Rabbit) {
            toCreate = FAEntityTypes.PREGNANT_RABBIT.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Sheep sheep) {
            toCreate = FAEntityTypes.PREGNANT_SHEEP.get().create(level, EntitySpawnReason.BREEDING);
            ((PregnantSheep) toCreate).setColor(sheep.getColor());
        }
        if (livingEntity instanceof Wolf) {
            toCreate = FAEntityTypes.PREGNANT_WOLF.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Mammoth) {
            toCreate = FAEntityTypes.PREGNANT_MAMMOTH.get().create(level, EntitySpawnReason.BREEDING);
        }
        if (livingEntity instanceof Smilodon) {
            toCreate = FAEntityTypes.PREGNANT_SMILODON.get().create(level, EntitySpawnReason.BREEDING);
        }
        toCreate.moveTo(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.getYRot(), livingEntity.getXRot());
        level.addFreshEntity(toCreate);
        return (PregnantAnimal) toCreate;
    }

    default void onRemove(Mob original, Entity replaced) {
    }

    @Override
    default void onEntityTicksComplete(Mob mob, Entity offspring, Level level) {
        TicksToBirth.super.onEntityTicksComplete(mob, offspring, level);
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
        builder.define(pregnancy, FABuiltInRegistries.PREGNANCY_TYPES.getOrThrow(FAPregnancyTypes.CAT.getKey()));
    }

    default void defineCoatTypeData(EntityDataAccessor<Holder<ModelType>> pregnancy, SynchedEntityData.Builder builder) {
        builder.define(pregnancy, this.getLevel().registryAccess().lookupOrThrow(FARegistries.MODEL_TYPES).getAny().orElseThrow());
    }

    default void addRemainingPregnancyTime(CompoundTag compoundTag) {
        compoundTag.putInt("PregnancyTime", this.getRemainingTime());
    }

    default void readRemainingPregnancyTime(CompoundTag compoundTag) {
        this.setRemainingPregnancyTime(compoundTag.getInt("PregnancyTime"));
    }

    default void addPregnancyData(CompoundTag compoundTag) {
        compoundTag.putString("Variant", this.getPregnancyType().unwrapKey().orElse(FAPregnancyTypes.CAT.getKey()).location().toString());
    }

    default void readPregnancyData(CompoundTag compoundTag) {
        Optional<ResourceKey<PregnancyType>> eggVariant = Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("Variant"))).map((resourceLocation) -> ResourceKey.create(FARegistries.PREGNANCY_TYPES, resourceLocation));
        Registry<PregnancyType> registry = FABuiltInRegistries.PREGNANCY_TYPES;
        Objects.requireNonNull(registry);
        eggVariant.flatMap(registry::get).ifPresent(this::setPregnancyType);
    }

    default void addCoatTypeData(CompoundTag compoundTag) {
        VARIANT_CODEC.encodeStart(this.getLevel().registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getOffspringCoatType()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
    }

    default void readCoatTypeData(CompoundTag compoundTag) {
        VARIANT_CODEC.parse(this.getLevel().registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setOffspringCoatType);
    }
}
