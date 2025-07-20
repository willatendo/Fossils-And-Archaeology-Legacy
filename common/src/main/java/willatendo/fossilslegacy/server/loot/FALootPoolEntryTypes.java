package willatendo.fossilslegacy.server.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FALootPoolEntryTypes {
    public static final SimpleRegistry<LootPoolEntryType> LOOT_POOL_ENTRY_TYPES = SimpleRegistry.create(Registries.LOOT_POOL_ENTRY_TYPE, FAUtils.ID);

    public static final SimpleHolder<LootPoolEntryType> RANDOM_ITEM = LOOT_POOL_ENTRY_TYPES.register("random_item", () -> new LootPoolEntryType(LootRandomItem.CODEC));
}
