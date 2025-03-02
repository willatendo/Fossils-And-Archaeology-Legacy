package willatendo.fossilslegacy.server.entity.util.interfaces;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityDimensions;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.Optional;

public interface ModelTypeEntity extends SimpleRegistryAccessAccessor {
    void setModelType(Holder<ModelType> holder);

    Holder<ModelType> getModelType();

    default void addModelType(CompoundTag compoundTag) {
        this.getModelType().unwrapKey().ifPresent(coatTypeResourceKey -> compoundTag.putString("model_type", coatTypeResourceKey.location().toString()));
    }

    default void readModelType(CompoundTag compoundTag) {
        Optional.ofNullable(ResourceLocation.tryParse(compoundTag.getString("model_type"))).map(id -> ResourceKey.create(FARegistries.MODEL_TYPES, id)).flatMap(resourceKey -> this.getRegistryAccess().lookupOrThrow(FARegistries.MODEL_TYPES).get(resourceKey)).ifPresent(this::setModelType);
    }

    default Component getOverridenName(Component defaultName) {
        ModelType modelType = this.getModelType().value();
        Optional<ModelType.OverrideInfo> overrideInfo = modelType.overrideInfo();
        return (overrideInfo.isPresent() && overrideInfo.get().animalName().isPresent()) ? overrideInfo.get().animalName().get() : defaultName;
    }

    default SoundEvent getOverridenSoundEvent(SoundEvent defaultSoundEvent, ModelType.OverrideInfo.OverridenSoundType overridenSoundType) {
        ModelType modelType = this.getModelType().value();
        Optional<ModelType.OverrideInfo> overrideInfoOptional = modelType.overrideInfo();
        if (overrideInfoOptional.isEmpty()) {
            return defaultSoundEvent;
        }
        ModelType.OverrideInfo overrideInfo = overrideInfoOptional.get();
        if (overridenSoundType == ModelType.OverrideInfo.OverridenSoundType.AMBIENT) {
            Optional<SoundEvent> soundEvent = overrideInfo.getAmbientSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        if (overridenSoundType == ModelType.OverrideInfo.OverridenSoundType.HURT) {
            Optional<SoundEvent> soundEvent = overrideInfo.getHurtSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        if (overridenSoundType == ModelType.OverrideInfo.OverridenSoundType.DEATH) {
            Optional<SoundEvent> soundEvent = overrideInfo.getDeathSound();
            return soundEvent.orElse(defaultSoundEvent);
        }
        return defaultSoundEvent;
    }

    default EntityDimensions getEntityDimensions(int growthStage) {
        ModelType modelType = this.getModelType().value();
        ModelType.BoundingBoxInfo boundingBoxInfo = modelType.boundingBoxInfo();
        return EntityDimensions.scalable(boundingBoxInfo.boundingBoxWidth() + (boundingBoxInfo.boundingBoxGrowth() * growthStage), boundingBoxInfo.boundingBoxHeight() + (boundingBoxInfo.boundingBoxGrowth() * growthStage));
    }
}
