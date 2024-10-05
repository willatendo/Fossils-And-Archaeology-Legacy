package willatendo.fossilslegacy.server.entity.util.interfaces;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;

public interface CoatTypeEntity {
    MapCodec<Holder<CoatType>> VARIANT_MAP_CODEC = CoatType.CODEC.fieldOf("CoatType");
    Codec<Holder<CoatType>> VARIANT_CODEC = VARIANT_MAP_CODEC.codec();

    default void addCoatType(CompoundTag compoundTag) {
        VARIANT_CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.getCoatType()).ifSuccess(tag -> compoundTag.merge((CompoundTag) tag));
    }

    default void readCoatType(CompoundTag compoundTag) {
        VARIANT_CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compoundTag).ifSuccess(this::setCoatType);
    }

    RegistryAccess registryAccess();

    void setCoatType(Holder<CoatType> holder);

    Holder<CoatType> getCoatType();
}
