package willatendo.fossilslegacy.server.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyLootPoolEntryTypes {
	public static final SimpleRegistry<LootPoolEntryType> LOOT_POOL_ENTRY_TYPES = SimpleRegistry.create(Registries.LOOT_POOL_ENTRY_TYPE, FossilsLegacyUtils.ID);

	public static final SimpleHolder<LootPoolEntryType> LOOT_ONE_ITEM_OF_MANY_RANDOM = LOOT_POOL_ENTRY_TYPES.register("loot_one_item_of_many_random", () -> new LootPoolEntryType(LootOneItemOfManyRandom.CODEC));

	public static void init() {
		FabricRegister.register(LOOT_POOL_ENTRY_TYPES);
	}
}
