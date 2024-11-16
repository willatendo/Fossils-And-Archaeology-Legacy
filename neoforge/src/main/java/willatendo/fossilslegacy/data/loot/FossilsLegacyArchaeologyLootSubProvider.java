package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;

import java.util.function.BiConsumer;

public class FossilsLegacyArchaeologyLootSubProvider implements LootTableSubProvider {
    public FossilsLegacyArchaeologyLootSubProvider(HolderLookup.Provider registries) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> archaeologyLoot) {
        archaeologyLoot.accept(FossilsLegacyLootTables.INCA_LOOT, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.QUIPU.get())).add(LootItem.lootTableItem(FossilsLegacyBlocks.IRON_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FossilsLegacyBlocks.COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FossilsLegacyBlocks.EXPOSED_COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FossilsLegacyBlocks.WEATHERED_COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FossilsLegacyBlocks.OXIDIZED_COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(Items.FEATHER).setWeight(2)).add(LootItem.lootTableItem(Items.STRING).setWeight(2))));
    }
}
