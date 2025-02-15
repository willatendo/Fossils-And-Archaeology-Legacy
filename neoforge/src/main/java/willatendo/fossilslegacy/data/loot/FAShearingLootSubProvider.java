package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.data.loot.packs.LootData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import willatendo.fossilslegacy.server.item.FALootTables;

import java.util.function.BiConsumer;

public record FAShearingLootSubProvider(HolderLookup.Provider provider) implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        LootData.WOOL_ITEM_BY_DYE.forEach((dyeColor, itemLike) -> {
            biConsumer.accept(FALootTables.SHEAR_MAMMOTH_BY_DYE.get(dyeColor), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(7.0F, 15.0F)).add(LootItem.lootTableItem(itemLike))));
            biConsumer.accept(FALootTables.SHEAR_PREGNANT_SHEEP_BY_DYE.get(dyeColor), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).add(LootItem.lootTableItem(itemLike))));
        });
        biConsumer.accept(FALootTables.SHEAR_MAMMOTH, LootTable.lootTable().withPool(FAEntityLootSubProvider.createMammothDispatchPool(FALootTables.SHEAR_MAMMOTH_BY_DYE)));
        biConsumer.accept(FALootTables.SHEAR_PREGNANT_SHEEP, LootTable.lootTable().withPool(FAEntityLootSubProvider.createSheepDispatchPool(FALootTables.SHEAR_PREGNANT_SHEEP_BY_DYE)));
    }
}
