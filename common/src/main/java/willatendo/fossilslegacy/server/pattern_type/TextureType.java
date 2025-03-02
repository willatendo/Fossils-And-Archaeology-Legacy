package willatendo.fossilslegacy.server.pattern_type;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum TextureType implements StringRepresentable {
    BASE("base"),
    BABY("baby"),
    FUR("fur"),
    BABY_FUR("baby_fur"),
    SHEARED("sheared"),
    AGGRESSIVE("aggressive"),
    AGGRESSIVE_BABY("aggressive_baby"),
    KNOCKED_OUT("knocked_out"),
    EYE("eye");
    public static final Codec<TextureType> CODEC = StringRepresentable.fromValues(TextureType::values);

    private final String name;

    TextureType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
