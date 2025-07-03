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

public final class FossilPositions {
    public static final Codec<FossilPositions> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.unboundedMap(Codec.STRING, FossilPositions.Positions.CODEC).fieldOf("rotations").forGetter(fossilRotations -> fossilRotations.positions)).apply(instance, FossilPositions::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, FossilPositions> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, FossilPositions.Positions.STREAM_CODEC), fossilRotations -> fossilRotations.positions, FossilPositions::new);
    public static final StreamCodec<ByteBuf, FossilPositions> STREAM_CODEC_FROM_CODEC = ByteBufCodecs.fromCodec(CODEC);
    private Map<String, FossilPositions.Positions> positions;

    private FossilPositions(Map<String, FossilPositions.Positions> positions) {
        this.positions = new HashMap<>();
        this.positions.putAll(positions);
    }

    public FossilPositions() {
        this.positions = new HashMap<>();
    }

    public FossilPositions.Positions get(String part) {
        return this.positions.get(part);
    }

    public boolean contains(String part) {
        return this.positions.containsKey(part);
    }

    @Override
    public String toString() {
        return "" + this.positions.size();
    }

    public int size() {
        return this.positions.size();
    }

    public void setPosition(String part, float x, float y, float z) {
        if (!this.positions.containsKey(part)) {
            this.positions.put(part, new FossilPositions.Positions(x, y, z));
        } else {
            this.positions.replace(part, new FossilPositions.Positions(x, y, z));
        }
    }

    public void forEach(BiConsumer<String, FossilPositions.Positions> consumer) {
        this.positions.forEach(consumer);
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        int size = this.positions.size();
        compoundTag.putInt("size", size);
        for (int i = 0; i < size; i++) {
            compoundTag.putString("part_" + i, this.positions.keySet().stream().toList().get(i));
        }
        this.positions.forEach((part, rotations) -> {
            CompoundTag partCompoundTag = new CompoundTag();
            rotations.save(partCompoundTag);
            compoundTag.put(part, partCompoundTag);
        });
    }

    public static FossilPositions readAdditionalSaveData(CompoundTag compoundTag) {
        Map<String, FossilPositions.Positions> positions = new HashMap<>();
        List<String> parts = new ArrayList<>();
        for (int i = 0; i < compoundTag.getInt("size"); i++) {
            parts.add(compoundTag.getString("part_" + i));
        }
        parts.forEach(part -> positions.put(part, new FossilPositions.Positions(compoundTag.getCompound(part))));
        return new FossilPositions(positions);
    }

    public record Positions(float x, float y, float z) {
        public static final Codec<FossilPositions.Positions> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.FLOAT.fieldOf("x").forGetter(FossilPositions.Positions::x), Codec.FLOAT.fieldOf("y").forGetter(FossilPositions.Positions::y), Codec.FLOAT.fieldOf("z").forGetter(FossilPositions.Positions::z)).apply(instance, FossilPositions.Positions::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, FossilPositions.Positions> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.FLOAT, FossilPositions.Positions::x, ByteBufCodecs.FLOAT, FossilPositions.Positions::y, ByteBufCodecs.FLOAT, FossilPositions.Positions::z, FossilPositions.Positions::new);

        public Positions(CompoundTag compoundTag) {
            this(compoundTag.getFloat("x"), compoundTag.getFloat("y"), compoundTag.getFloat("z"));
        }

        public void save(CompoundTag compoundTag) {
            compoundTag.putFloat("x", this.x());
            compoundTag.putFloat("y", this.y());
            compoundTag.putFloat("z", this.z());
        }
    }
}
