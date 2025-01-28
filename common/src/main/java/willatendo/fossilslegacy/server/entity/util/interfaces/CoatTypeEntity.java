package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityDimensions;
import willatendo.fossilslegacy.server.coat_type.CoatType;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public interface CoatTypeEntity extends SimpleRegistryAccessAccessor {
    void setCoatType(Holder<CoatType> holder);

    Holder<CoatType> getCoatType();

    default void addCoatType(CompoundTag compoundTag) {
        this.getCoatType().unwrapKey().ifPresent(coatTypeResourceKey -> compoundTag.putString("CoatType", coatTypeResourceKey.location().toString()));
    }

    default void readCoatType(CompoundTag compoundTag) {
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("CoatType"))).map(id -> ResourceKey.create(FARegistries.COAT_TYPES, id)).flatMap(resourceKey -> this.getRegistryAccess().registryOrThrow(FARegistries.COAT_TYPES).getHolder(resourceKey)).ifPresent(this::setCoatType);
    }

    default Component getOverridenName(Component defaultName) {
        CoatType coatType = this.getCoatType().value();
        Optional<CoatType.OverrideInfo> overrideInfo = coatType.overrideInfo();
        return (overrideInfo.isPresent() && overrideInfo.get().animalName().isPresent()) ? overrideInfo.get().animalName().get() : defaultName;
    }

    default SoundEvent getOverridenSoundEvent(SoundEvent defaultSoundEvent, CoatType.OverrideInfo.OverridenSoundType overridenSoundType) {
        CoatType coatType = this.getCoatType().value();
        Optional<CoatType.OverrideInfo> overrideInfoOptional = coatType.overrideInfo();
        if (overrideInfoOptional.isEmpty()) {
            return defaultSoundEvent;
        }
        CoatType.OverrideInfo overrideInfo = overrideInfoOptional.get();
        if (overridenSoundType == CoatType.OverrideInfo.OverridenSoundType.AMBIENT) {
            Optional<SoundEvent> soundEvent = overrideInfo.getAmbientSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        if (overridenSoundType == CoatType.OverrideInfo.OverridenSoundType.HURT) {
            Optional<SoundEvent> soundEvent = overrideInfo.getHurtSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        if (overridenSoundType == CoatType.OverrideInfo.OverridenSoundType.DEATH) {
            Optional<SoundEvent> soundEvent = overrideInfo.getDeathSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        return defaultSoundEvent;
    }

    default EntityDimensions getEntityDimensions(int growthStage) {
        CoatType coatType = this.getCoatType().value();
        CoatType.BoundingBoxInfo boundingBoxInfo = coatType.boundingBoxInfo();
        return EntityDimensions.scalable(boundingBoxInfo.boundingBoxWidth() + (boundingBoxInfo.boundingBoxGrowth() * growthStage), boundingBoxInfo.boundingBoxHeight() + (boundingBoxInfo.boundingBoxGrowth() * growthStage));
    }
}
