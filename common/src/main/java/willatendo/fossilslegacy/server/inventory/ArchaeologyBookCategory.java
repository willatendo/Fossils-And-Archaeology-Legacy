package willatendo.fossilslegacy.server.inventory;

import net.minecraft.util.StringRepresentable;

public enum ArchaeologyBookCategory implements StringRepresentable {
    RESTORE("restore"),
    REPAIR("repair"),
    MISC("misc");

    public static final StringRepresentable.EnumCodec<ArchaeologyBookCategory> CODEC = StringRepresentable.fromEnum(ArchaeologyBookCategory::values);
    private final String name;

    private ArchaeologyBookCategory(String name) {
        this.name = name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
