package willatendo.fossilslegacy.server.item;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum FAHeadTypes implements StringRepresentable {
    ANKYLOSAURUS("ankylosaurus"),
    BARYONYX("baryonyx");

    public static final Codec<FAHeadTypes> CODEC = StringRepresentable.fromValues(FAHeadTypes::values);

    private final String name;

    FAHeadTypes(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
