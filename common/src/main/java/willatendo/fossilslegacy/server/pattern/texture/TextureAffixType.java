package willatendo.fossilslegacy.server.pattern.texture;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum TextureAffixType implements StringRepresentable {
    PREFIX("prefix"),
    SUFFIX("suffix");

    public static final Codec<TextureAffixType> CODEC = StringRepresentable.fromValues(TextureAffixType::values);

    private final String name;

    TextureAffixType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
