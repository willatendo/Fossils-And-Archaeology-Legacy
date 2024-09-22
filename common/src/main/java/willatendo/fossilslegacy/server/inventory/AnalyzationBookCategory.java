package willatendo.fossilslegacy.server.inventory;

import net.minecraft.util.StringRepresentable;

public enum AnalyzationBookCategory implements StringRepresentable {
    MISC("misc");

    public static final StringRepresentable.EnumCodec<AnalyzationBookCategory> CODEC = StringRepresentable.fromEnum(AnalyzationBookCategory::values);
    private final String name;

    AnalyzationBookCategory(String name) {
        this.name = name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
