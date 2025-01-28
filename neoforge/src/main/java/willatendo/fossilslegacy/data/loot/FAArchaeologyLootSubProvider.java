package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;

import java.util.function.BiConsumer;

public class FAArchaeologyLootSubProvider implements LootTableSubProvider {
    public FAArchaeologyLootSubProvider(HolderLookup.Provider registries) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> archaeologyLoot) {
        archaeologyLoot.accept(FALootTables.INCA_LOOT, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.QUIPU.get())).add(LootItem.lootTableItem(FABlocks.IRON_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FABlocks.COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get())).add(LootItem.lootTableItem(Items.FEATHER).setWeight(2)).add(LootItem.lootTableItem(Items.STRING).setWeight(2))));
    }
}
