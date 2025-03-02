package willatendo.fossilslegacy.server.entity.genetics;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum GeneticType implements StringRepresentable {
    DOMINANT("dominant"),
    RECESSIVE("recessive");

    public static final Codec<GeneticType> CODEC = StringRepresentable.fromEnum(GeneticType::values);
    private final String name;

    GeneticType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
