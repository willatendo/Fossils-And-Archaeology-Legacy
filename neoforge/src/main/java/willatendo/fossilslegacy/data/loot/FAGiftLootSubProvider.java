package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;

import java.util.function.BiConsumer;

public class FAGiftLootSubProvider implements LootTableSubProvider {
    public FAGiftLootSubProvider(HolderLookup.Provider registries) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> giftLoot) {
        giftLoot.accept(FALootTables.ARCHAEOLOGIST_GIFT, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.ANCIENT_HELMET.get())).add(LootItem.lootTableItem(FAItems.RELIC_SCRAP.get())).add(LootItem.lootTableItem(FAItems.JADE.get())).add(LootItem.lootTableItem(FAItems.JADE_VILLAGER.get()))));
        giftLoot.accept(FALootTables.PALAEONTOLOGIST_GIFT, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.MESOZOIC_FOSSIL.get())).add(LootItem.lootTableItem(FAItems.DINOPEDIA.get())).add(LootItem.lootTableItem(FAItems.JURASSIC_FERN_SPORES.get()))));
    }
}
