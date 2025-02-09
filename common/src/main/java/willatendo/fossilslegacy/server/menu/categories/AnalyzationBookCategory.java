package willatendo.fossilslegacy.server.menu.categories;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum AnalyzationBookCategory implements StringRepresentable {
    MISC(0, "misc");

    private static final IntFunction<AnalyzationBookCategory> BY_ID = ByIdMap.continuous(archaeologybookcategory -> archaeologybookcategory.id, AnalyzationBookCategory.values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final Codec<AnalyzationBookCategory> CODEC = StringRepresentable.fromEnum(AnalyzationBookCategory::values);
    public static final StreamCodec<ByteBuf, AnalyzationBookCategory> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, analyzationBookCategory -> analyzationBookCategory.id);
    private final int id;
    private final String name;

    AnalyzationBookCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
