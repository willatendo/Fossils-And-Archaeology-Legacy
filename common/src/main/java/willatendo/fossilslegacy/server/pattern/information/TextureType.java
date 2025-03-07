package willatendo.fossilslegacy.server.pattern.information;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum TextureType implements StringRepresentable {
    BASE("base", "adult"),
    BABY("baby"),
    FUR("fur"),
    BABY_FUR("baby_fur"),
    SHEARED("sheared"),
    AGGRESSIVE("aggressive"),
    AGGRESSIVE_BABY("aggressive_baby"),
    KNOCKED_OUT("knocked_out"),
    EYE("eye", "eyes");
    public static final Codec<TextureType> CODEC = StringRepresentable.fromValues(TextureType::values);

    private final String name;
    private final String suffix;

    TextureType(String name, String suffix) {
        this.name = name;
        this.suffix = suffix;
    }

    TextureType(String name) {
        this(name, name);
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
