package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.item.FALootTables;

import java.util.function.BiConsumer;

public record FAShearingLootSubProvider(HolderLookup.Provider provider) implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(FALootTables.SHEAR_MAMMOTH, LootTable.lootTable().withPool(FAEntityLootSubProvider.createMammothDispatchPool(FALootTables.SHEAR_MAMMOTH_BY_DYE)));
    }
}
