package fossilslegacy.data.loot;

import java.util.List;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class FossilsLegacyLootTableProvider {
	public static LootTableProvider create(PackOutput packedOutpit) {
		return new LootTableProvider(packedOutpit, BuiltInLootTables.all(), List.of(new SubProviderEntry(FossilsLegacyBlockLoot::new, LootContextParamSets.BLOCK), new SubProviderEntry(FossilsLegacyEntityLoot::new, LootContextParamSets.ENTITY), new SubProviderEntry(FossilsLegacyChestLoot::new, LootContextParamSets.CHEST)));
	}
}
