package willatendo.fossilslegacy.server.menu.categories;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum CultivationBookCategory implements StringRepresentable {
    EGG(0, "egg"),
    PLANT(1, "plant"),
    MISC(2, "misc");

    private static final IntFunction<CultivationBookCategory> BY_ID = ByIdMap.continuous(CultivationBookCategory -> CultivationBookCategory.id, CultivationBookCategory.values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final Codec<CultivationBookCategory> CODEC = StringRepresentable.fromEnum(CultivationBookCategory::values);
    public static final StreamCodec<ByteBuf, CultivationBookCategory> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, CultivationBookCategory -> CultivationBookCategory.id);
    private final int id;
    private final String name;

    CultivationBookCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}