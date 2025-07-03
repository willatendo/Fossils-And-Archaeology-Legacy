package willatendo.fossilslegacy.server.entity.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public final class FossilRotations {
    public static final Codec<FossilRotations> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.unboundedMap(Codec.STRING, FossilRotations.Rotations.CODEC).fieldOf("rotations").forGetter(fossilRotations -> fossilRotations.rotations)).apply(instance, FossilRotations::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, FossilRotations> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, Rotations.STREAM_CODEC), fossilRotations -> fossilRotations.rotations, FossilRotations::new);
    public static final StreamCodec<ByteBuf, FossilRotations> STREAM_CODEC_FROM_CODEC = ByteBufCodecs.fromCodec(CODEC);
    private Map<String, FossilRotations.Rotations> rotations;

    private FossilRotations(Map<String, FossilRotations.Rotations> rotations) {
        this.rotations = new HashMap<>();
        this.rotations.putAll(rotations);
    }

    public FossilRotations() {
        this.rotations = new HashMap<>();
    }

    public FossilRotations.Rotations get(String part) {
        return this.rotations.get(part);
    }

    public boolean contains(String part) {
        return this.rotations.containsKey(part);
    }

    @Override
    public String toString() {
        return "" + this.rotations.size();
    }

    public int size() {
        return this.rotations.size();
    }

    public void setRotation(String part, float xRot, float yRot, float zRot) {
        if (!this.rotations.containsKey(part)) {
            this.rotations.put(part, new Rotations(xRot, yRot, zRot));
        } else {
            this.rotations.replace(part, new Rotations(xRot, yRot, zRot));
        }
    }

    public void forEach(BiConsumer<String, Rotations> consumer) {
        this.rotations.forEach(consumer);
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        int size = this.rotations.size();
        compoundTag.putInt("size", size);
        for (int i = 0; i < size; i++) {
            compoundTag.putString("part_" + i, this.rotations.keySet().stream().toList().get(i));
        }
        this.rotations.forEach((part, rotations) -> {
            CompoundTag partCompoundTag = new CompoundTag();
            rotations.save(partCompoundTag);
            compoundTag.put(part, partCompoundTag);
        });
    }

    public static FossilRotations readAdditionalSaveData(CompoundTag compoundTag) {
        Map<String, FossilRotations.Rotations> rotations = new HashMap<>();
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < compoundTag.getInt("size"); i++) {
            parts.add(compoundTag.getString("part_" + i));
        }
        parts.forEach(part -> rotations.put(part, new Rotations(compoundTag.getCompound(part))));
        return new FossilRotations(rotations);
    }

    public record Rotations(float xRot, float yRot, float zRot) {
        public static final Codec<FossilRotations.Rotations> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.FLOAT.fieldOf("x_rot").forGetter(FossilRotations.Rotations::xRot), Codec.FLOAT.fieldOf("y_rot").forGetter(FossilRotations.Rotations::yRot), Codec.FLOAT.fieldOf("z_rot").forGetter(FossilRotations.Rotations::zRot)).apply(instance, FossilRotations.Rotations::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, FossilRotations.Rotations> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, FossilRotations.Rotations::xRot, ByteBufCodecs.FLOAT, FossilRotations.Rotations::yRot, ByteBufCodecs.FLOAT, FossilRotations.Rotations::zRot, FossilRotations.Rotations::new);

        public Rotations(CompoundTag compoundTag) {
            this(compoundTag.getFloat("x_rot"), compoundTag.getFloat("y_rot"), compoundTag.getFloat("z_rot"));
        }

        public void save(CompoundTag compoundTag) {
            compoundTag.putFloat("x_rot", this.xRot());
            compoundTag.putFloat("y_rot", this.yRot());
            compoundTag.putFloat("z_rot", this.zRot());
        }
    }
}
