package willatendo.fossilslegacy.server.inventory;

import net.minecraft.util.StringRepresentable;

public enum CultivationBookCategory implements StringRepresentable {
    EGG("egg"),
    PLANT("plant"),
    MISC("misc");

    public static final StringRepresentable.EnumCodec<CultivationBookCategory> CODEC = StringRepresentable.fromEnum(CultivationBookCategory::values);
    private final String name;

    CultivationBookCategory(String name) {
        this.name = name;
    }

    public String getSerializedName() {
        return this.name;
    }
}