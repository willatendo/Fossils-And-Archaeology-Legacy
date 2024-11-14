package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;

import java.util.function.BiConsumer;

public class FossilsLegacyGiftLootSubProvider implements LootTableSubProvider {
    public FossilsLegacyGiftLootSubProvider(HolderLookup.Provider registries) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> giftLoot) {
        giftLoot.accept(FossilsLegacyLootTables.ARCHAEOLOGIST_GIFT, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.ANCIENT_HELMET.get())).add(LootItem.lootTableItem(FossilsLegacyItems.RELIC_SCRAP.get())).add(LootItem.lootTableItem(FossilsLegacyItems.JADE.get())).add(LootItem.lootTableItem(FossilsLegacyItems.JADE_VILLAGER.get()))));
        giftLoot.accept(FossilsLegacyLootTables.PALAEONTOLOGIST_GIFT, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.FOSSIL.get())).add(LootItem.lootTableItem(FossilsLegacyItems.DINOPEDIA.get())).add(LootItem.lootTableItem(FossilsLegacyItems.JURASSIC_FERN_SPORES.get()))));
    }
}
