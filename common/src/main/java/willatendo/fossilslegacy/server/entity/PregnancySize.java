package willatendo.fossilslegacy.server.entity;

import net.minecraft.network.chat.Component;
import willatendo.fossilslegacy.server.utils.FAUtils;

public enum PregnancySize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String name;

    PregnancySize(String name) {
        this.name = name;
    }

    public Component getToolTip() {
        return FAUtils.translation("item", "pregnancy_size." + this.name);
    }
}
