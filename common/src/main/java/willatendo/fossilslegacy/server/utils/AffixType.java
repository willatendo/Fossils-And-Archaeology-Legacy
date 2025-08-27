package willatendo.fossilslegacy.server.utils;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum AffixType implements StringRepresentable {
    PREFIX("prefix"),
    SUFFIX("suffix"),
    NONE("none");

    public static final Codec<AffixType> CODEC = StringRepresentable.fromValues(AffixType::values);
    private final String name;

    AffixType(String name) {
        this.name = name;
    }

    public String apply(String applyTo, String affix) {
        return switch (this) {
            case PREFIX -> affix + applyTo;
            case SUFFIX -> applyTo + affix;
            default -> applyTo;
        };
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
