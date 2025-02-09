package willatendo.fossilslegacy.server.menu.categories;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public enum ArchaeologyBookCategory implements StringRepresentable {
    RESTORE(0, "restore"),
    REPAIR(1, "repair"),
    MISC(2, "misc");

    private static final IntFunction<ArchaeologyBookCategory> BY_ID = ByIdMap.continuous(archaeologyBookCategory -> archaeologyBookCategory.id, ArchaeologyBookCategory.values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final Codec<ArchaeologyBookCategory> CODEC = StringRepresentable.fromEnum(ArchaeologyBookCategory::values);
    public static final StreamCodec<ByteBuf, ArchaeologyBookCategory> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, archaeologyBookCategory -> archaeologyBookCategory.id);
    private final int id;
    private final String name;

    ArchaeologyBookCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
