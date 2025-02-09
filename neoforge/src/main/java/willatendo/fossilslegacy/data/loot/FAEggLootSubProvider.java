package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;

import java.util.function.BiConsumer;

public class FAEggLootSubProvider implements LootTableSubProvider {
    public FAEggLootSubProvider(HolderLookup.Provider provider) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(FALootTables.ANKYLOSAURUS_EGG, this.createEggTable(FAItems.ANKYLOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.BRACHIOSAURUS_EGG, this.createEggTable(FAItems.BRACHIOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.CARNOTAURUS_EGG, this.createEggTable(FAItems.CARNOTAURUS_EGG.get()));
        biConsumer.accept(FALootTables.COMPSOGNATHUS_EGG, this.createEggTable(FAItems.COMPSOGNATHUS_EGG.get()));
        biConsumer.accept(FALootTables.CRYOLOPHOSAURUS_EGG, this.createEggTable(FAItems.CRYOLOPHOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.DILOPHOSAURUS_EGG, this.createEggTable(FAItems.DILOPHOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.DIMETRODON_EGG, this.createEggTable(FAItems.DIMETRODON_EGG.get()));
        biConsumer.accept(FALootTables.FUTABASAURUS_EGG, this.createEggTable(FAItems.FUTABASAURUS_EGG.get()));
        biConsumer.accept(FALootTables.GALLIMIMUS_EGG, this.createEggTable(FAItems.GALLIMIMUS_EGG.get()));
        biConsumer.accept(FALootTables.MOSASAURUS_EGG, this.createEggTable(FAItems.MOSASAURUS_EGG.get()));
        biConsumer.accept(FALootTables.PACHYCEPHALOSAURUS_EGG, this.createEggTable(FAItems.PACHYCEPHALOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.PTERANODON_EGG, this.createEggTable(FAItems.PTERANODON_EGG.get()));
        biConsumer.accept(FALootTables.SPINOSAURUS_EGG, this.createEggTable(FAItems.SPINOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.STEGOSAURUS_EGG, this.createEggTable(FAItems.STEGOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.THERIZINOSAURUS_EGG, this.createEggTable(FAItems.THERIZINOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.TRICERATOPS_EGG, this.createEggTable(FAItems.TRICERATOPS_EGG.get()));
        biConsumer.accept(FALootTables.TYRANNOSAURUS_EGG, this.createEggTable(FAItems.TYRANNOSAURUS_EGG.get()));
        biConsumer.accept(FALootTables.VELOCIRAPTOR_EGG, this.createEggTable(FAItems.VELOCIRAPTOR_EGG.get()));
    }

    private LootTable.Builder createEggTable(ItemLike itemLike) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike)));
    }
}
