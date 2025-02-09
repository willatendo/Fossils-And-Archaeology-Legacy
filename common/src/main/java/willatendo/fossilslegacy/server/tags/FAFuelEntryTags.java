package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAFuelEntryTags {
    private static final TagRegister<FuelEntry> FUEL_ENTRY_TAGS = TagRegister.create(FARegistries.FUEL_ENTRY, FAUtils.ID);

    public static final TagKey<FuelEntry> ARCHAEOLOGY_WORKBENCH = FUEL_ENTRY_TAGS.register("archaeology_workbench");
    public static final TagKey<FuelEntry> CULTIVATOR = FUEL_ENTRY_TAGS.register("cultivator");
}
