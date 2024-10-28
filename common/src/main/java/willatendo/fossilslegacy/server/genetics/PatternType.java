package willatendo.fossilslegacy.server.genetics;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum PatternType implements StringRepresentable {
    DOMINANT("dominant"),
    RECESSIVE("recessive");

    public static final Codec<PatternType> CODEC = StringRepresentable.fromEnum(PatternType::values);
    private final String name;

    PatternType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
