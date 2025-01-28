package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.FALootTables;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom.ItemAndChance;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.loot.SimpleEntityLootSubProvider;

import java.util.Optional;

public class FAEntityLootSubProvider extends SimpleEntityLootSubProvider {
    public FAEntityLootSubProvider(HolderLookup.Provider registries) {
        super(registries, FossilsLegacyUtils.ID);
    }

    @Override
    public void generate() {
        this.add(FAEntityTypes.ANKYLOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_ANKYLOSAURUS.get()));
        this.add(FAEntityTypes.BRACHIOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_BRACHIOSAURUS.get()));
        this.add(FAEntityTypes.CARNOTAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_CARNOTAURUS.get()));
        this.add(FAEntityTypes.COMPSOGNATHUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_COMPSOGNATHUS.get()));
        this.add(FAEntityTypes.CRYOLOPHOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_CRYOLOPHOSAURUS.get()));
        this.add(FAEntityTypes.DILOPHOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_DILOPHOSAURUS.get()));
        this.add(FAEntityTypes.DIMETRODON.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_DIMETRODON.get()));
        this.add(FAEntityTypes.DODO.get(), this.createDinosaurTable(1.0F, 2.0F, FAItems.RAW_DODO.get()));
        this.add(FAEntityTypes.MOA.get(), this.createDinosaurTable(1.0F, 2.0F, FAItems.RAW_MOA.get()));
        this.add(FAEntityTypes.FUTABASAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_FUTABASAURUS.get()));
        this.add(FAEntityTypes.GALLIMIMUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_GALLIMIMUS.get()));
        this.add(FAEntityTypes.MAMMOTH.get(), this.createDinosaurTable(0.0F, 3.0F, Items.LEATHER, 1.0F, 3.0F, FAItems.RAW_MAMMOTH.get()));
        this.add(FAEntityTypes.MOSASAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_MOSASAURUS.get()));
        this.add(FAEntityTypes.NAUTILUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootOneItemOfManyRandom.lootTableItem(5, new ItemAndChance(FAItems.NAUTILUS_SHELL.get(), 0, 3), new ItemAndChance(FAItems.MAGIC_CONCH.get(), 3, 5)))));
        this.add(FAEntityTypes.PACHYCEPHALOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_PACHYCEPHALOSAURUS.get()));
        this.add(FAEntityTypes.PTERANODON.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_PTERANODON.get()));
        this.add(FAEntityTypes.SMILODON.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_SMILODON.get()));
        this.add(FAEntityTypes.SPINOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_STEGOSAURUS.get()));
        this.add(FAEntityTypes.STEGOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_STEGOSAURUS.get()));
        this.add(FAEntityTypes.THERIZINOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_THERIZINOSAURUS.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.FEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))).add(LootItem.lootTableItem(FAItems.THERIZINOSAURUS_CLAWS.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))));
        this.add(FAEntityTypes.TRICERATOPS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_TRICERATOPS.get()));
        this.add(FAEntityTypes.TYRANNOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_TYRANNOSAURUS.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.TYRANNOSAURUS_TOOTH.get()))));
        this.add(FAEntityTypes.VELOCIRAPTOR.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_VELOCIRAPTOR.get()));

        this.add(FAEntityTypes.EGG.get(), LootTable.lootTable());
        this.add(FAEntityTypes.EGG.get(), FALootTables.BRACHIOSAURUS_EGG, this.createEggTable(FAItems.BRACHIOSAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.CARNOTAURUS_EGG, this.createEggTable(FAItems.CARNOTAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.COMPSOGNATHUS_EGG, this.createEggTable(FAItems.COMPSOGNATHUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.CRYOLOPHOSAURUS_EGG, this.createEggTable(FAItems.CRYOLOPHOSAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.DILOPHOSAURUS_EGG, this.createEggTable(FAItems.DILOPHOSAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.FUTABASAURUS_EGG, this.createEggTable(FAItems.FUTABASAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.MOSASAURUS_EGG, this.createEggTable(FAItems.MOSASAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.PACHYCEPHALOSAURUS_EGG, this.createEggTable(FAItems.PACHYCEPHALOSAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.PTERANODON_EGG, this.createEggTable(FAItems.PTERANODON_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.STEGOSAURUS_EGG, this.createEggTable(FAItems.STEGOSAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.THERIZINOSAURUS_EGG, this.createEggTable(FAItems.THERIZINOSAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.TRICERATOPS_EGG, this.createEggTable(FAItems.TRICERATOPS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.TYRANNOSAURUS_EGG, this.createEggTable(FAItems.TYRANNOSAURUS_EGG.get()));
        this.add(FAEntityTypes.EGG.get(), FALootTables.VELOCIRAPTOR_EGG, this.createEggTable(FAItems.VELOCIRAPTOR_EGG.get()));

        this.add(FAEntityTypes.PREGNANT_ARMADILLO.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_CAT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(FAEntityTypes.PREGNANT_COW.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_DOLPHIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))));
        this.add(FAEntityTypes.PREGNANT_DONKEY.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_FOX.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_GOAT.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_HORSE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_LLAMA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_MAMMOTH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(Items.LEATHER))).withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(1.0F, 2.0F)).add(LootItem.lootTableItem(FAItems.RAW_MAMMOTH.get()).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))));
        this.add(FAEntityTypes.PREGNANT_MULE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_OCELOT.get(), LootTable.lootTable());
        this.add(FAEntityTypes.PREGNANT_PANDA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.BAMBOO).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
        this.add(FAEntityTypes.PREGNANT_PIG.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.PORKCHOP).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_POLAR_BEAR.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))).add(LootItem.lootTableItem(Items.SALMON).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_RABBIT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_HIDE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_FOOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.03F))));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.MUTTON).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_BLACK, this.createPregnantSheepTable(Blocks.BLACK_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_BLUE, this.createPregnantSheepTable(Blocks.BLUE_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_BROWN, this.createPregnantSheepTable(Blocks.BROWN_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_CYAN, this.createPregnantSheepTable(Blocks.CYAN_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_GRAY, this.createPregnantSheepTable(Blocks.GRAY_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_GREEN, this.createPregnantSheepTable(Blocks.GREEN_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_LIGHT_BLUE, this.createPregnantSheepTable(Blocks.LIGHT_BLUE_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_LIGHT_GRAY, this.createPregnantSheepTable(Blocks.LIGHT_GRAY_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_LIME, this.createPregnantSheepTable(Blocks.LIME_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_MAGENTA, this.createPregnantSheepTable(Blocks.MAGENTA_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_ORANGE, this.createPregnantSheepTable(Blocks.ORANGE_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_PINK, this.createPregnantSheepTable(Blocks.PINK_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_PURPLE, this.createPregnantSheepTable(Blocks.PURPLE_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_RED, this.createPregnantSheepTable(Blocks.RED_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_WHITE, this.createPregnantSheepTable(Blocks.WHITE_WOOL));
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), FALootTables.PREGNANT_SHEEP_YELLOW, this.createPregnantSheepTable(Blocks.YELLOW_WOOL));
        this.add(FAEntityTypes.PREGNANT_SMILODON.get(), this.createDinosaurTable(1.0F, 3.0F, FAItems.RAW_SMILODON.get()));
        this.add(FAEntityTypes.PREGNANT_WOLF.get(), LootTable.lootTable());

        this.add(FAEntityTypes.ANU.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).add(LootItem.lootTableItem(Items.COOKED_PORKCHOP))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(FABlocks.TIME_MACHINE.get()))));
        this.add(FAEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.GOLD_INGOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.025F, 0.01F))));
        this.add(FAEntityTypes.FAILURESAURUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(FAItems.FOSSIL.get()))));
    }

    protected LootTable.Builder createDinosaurTable(float minAdditional, float maxAdditional, ItemLike additionalDrop, float min, float max, ItemLike rawMeat) {
        return this.createDinosaurTable(Optional.of(minAdditional), Optional.of(maxAdditional), Optional.of(additionalDrop), min, max, rawMeat);
    }

    protected LootTable.Builder createDinosaurTable(float min, float max, ItemLike rawMeat) {
        return this.createDinosaurTable(Optional.empty(), Optional.empty(), Optional.empty(), min, max, rawMeat);
    }

    protected LootTable.Builder createDinosaurTable(Optional<Float> minAdditional, Optional<Float> maxAdditional, Optional<ItemLike> additionalDrop, float min, float max, ItemLike rawMeat) {
        LootTable.Builder builder = LootTable.lootTable();
        if (additionalDrop.isPresent() && minAdditional.isPresent() && maxAdditional.isPresent()) {
            builder.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(minAdditional.get(), maxAdditional.get())).setBonusRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(additionalDrop.get())));
        }
        builder.withPool(LootPool.lootPool().setRolls(UniformGenerator.between(min, max)).setBonusRolls(UniformGenerator.between(1.0F, 2.0F)).add(LootItem.lootTableItem(rawMeat).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))));
        return builder;
    }

    protected LootTable.Builder createPregnantSheepTable(ItemLike itemLike) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(NestedLootTable.lootTableReference(FAEntityTypes.PREGNANT_SHEEP.get().getDefaultLootTable())));
    }

    protected LootTable.Builder createEggTable(ItemLike itemLike) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike)));
    }
}
