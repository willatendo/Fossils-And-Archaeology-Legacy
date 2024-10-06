package willatendo.fossilslegacy.server.entity.util.interfaces;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityDimensions;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

import java.util.Optional;

public interface CoatTypeEntity extends SimpleRegistryAccessAccessor {
    MapCodec<Holder<CoatType>> VARIANT_MAP_CODEC = CoatType.CODEC.fieldOf("CoatType");
    Codec<Holder<CoatType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();

    void setCoatType(Holder<CoatType> holder);

    Holder<CoatType> getCoatType();

    default void addCoatType(CompoundTag compoundTag) {
        VARIANT_CODEC.encodeStart(this.getRegistryAccess().createSerializationContext(NbtOps.INSTANCE), this.getCoatType()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
    }

    default void readCoatType(CompoundTag compoundTag) {
        VARIANT_CODEC.parse(this.getRegistryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setCoatType);
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
