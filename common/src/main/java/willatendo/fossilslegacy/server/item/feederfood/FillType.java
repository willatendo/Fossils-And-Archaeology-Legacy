package willatendo.fossilslegacy.server.item.feederfood;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum FillType implements StringRepresentable {
    PLANT("plant"),
    MEAT("meat");

    public static final Codec<FillType> CODEC = StringRepresentable.fromEnum(FillType::values);
    private final String name;

    FillType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
