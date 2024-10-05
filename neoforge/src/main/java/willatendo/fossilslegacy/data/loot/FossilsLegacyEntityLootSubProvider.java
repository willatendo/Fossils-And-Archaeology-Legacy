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
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.FossilsLegacyLootTables;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom.ItemAndChance;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.loot.SimpleEntityLootSubProvider;

import java.util.Optional;

public class FossilsLegacyEntityLootSubProvider extends SimpleEntityLootSubProvider {
    public FossilsLegacyEntityLootSubProvider(HolderLookup.Provider registries) {
        super(registries, FossilsLegacyUtils.ID);
    }

    @Override
    public void generate() {
        this.add(FossilsLegacyEntityTypes.ANKYLOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_ANKYLOSAURUS.get()));
        this.add(FossilsLegacyEntityTypes.BRACHIOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_BRACHIOSAURUS.get()));
        this.add(FossilsLegacyEntityTypes.CARNOTAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_CARNOTAURUS.get()));
        this.add(FossilsLegacyEntityTypes.COMPSOGNATHUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_COMPSOGNATHUS.get()));
        this.add(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get()));
        this.add(FossilsLegacyEntityTypes.DILOPHOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_DILOPHOSAURUS.get()));
        this.add(FossilsLegacyEntityTypes.DODO.get(), this.createDinosaurTable(1.0F, 2.0F, FossilsLegacyItems.RAW_DODO.get()));
        this.add(FossilsLegacyEntityTypes.MOA.get(), this.createDinosaurTable(1.0F, 2.0F, FossilsLegacyItems.RAW_MOA.get()));
        this.add(FossilsLegacyEntityTypes.FUTABASAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_FUTABASAURUS.get()));
        this.add(FossilsLegacyEntityTypes.GALLIMIMUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_GALLIMIMUS.get()));
        this.add(FossilsLegacyEntityTypes.MAMMOTH.get(), this.createDinosaurTable(0.0F, 3.0F, Items.LEATHER, 1.0F, 3.0F, FossilsLegacyItems.RAW_MAMMOTH.get()));
        this.add(FossilsLegacyEntityTypes.MOSASAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_MOSASAURUS.get()));
        this.add(FossilsLegacyEntityTypes.NAUTILUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootOneItemOfManyRandom.lootTableItem(5, new ItemAndChance(FossilsLegacyItems.NAUTILUS_SHELL.get(), 0, 3), new ItemAndChance(FossilsLegacyItems.MAGIC_CONCH.get(), 3, 5)))));
        this.add(FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS.get()));
        this.add(FossilsLegacyEntityTypes.PTERANODON.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_PTERANODON.get()));
        this.add(FossilsLegacyEntityTypes.SMILODON.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_SMILODON.get()));
        this.add(FossilsLegacyEntityTypes.SPINOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_STEGOSAURUS.get()));
        this.add(FossilsLegacyEntityTypes.STEGOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_STEGOSAURUS.get()));
        this.add(FossilsLegacyEntityTypes.THERIZINOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_THERIZINOSAURUS.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.FEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 3.0F)))).add(LootItem.lootTableItem(FossilsLegacyItems.THERIZINOSAURUS_CLAWS.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))));
        this.add(FossilsLegacyEntityTypes.TRICERATOPS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_TRICERATOPS.get()));
        this.add(FossilsLegacyEntityTypes.TYRANNOSAURUS.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_TYRANNOSAURUS.get()).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get()))));
        this.add(FossilsLegacyEntityTypes.VELOCIRAPTOR.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_VELOCIRAPTOR.get()));

        this.add(FossilsLegacyEntityTypes.EGG.get(), LootTable.lootTable());
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.BRACHIOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.BRACHIOSAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.CARNOTAURUS_EGG, this.createEggTable(FossilsLegacyItems.CARNOTAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.COMPSOGNATHUS_EGG, this.createEggTable(FossilsLegacyItems.COMPSOGNATHUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.CRYOLOPHOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.CRYOLOPHOSAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.DILOPHOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.DILOPHOSAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.FUTABASAURUS_EGG, this.createEggTable(FossilsLegacyItems.FUTABASAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.MOSASAURUS_EGG, this.createEggTable(FossilsLegacyItems.MOSASAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.PACHYCEPHALOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.PACHYCEPHALOSAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.PTERANODON_EGG, this.createEggTable(FossilsLegacyItems.PTERANODON_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.STEGOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.STEGOSAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.THERIZINOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.THERIZINOSAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.TRICERATOPS_EGG, this.createEggTable(FossilsLegacyItems.TRICERATOPS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.TYRANNOSAURUS_EGG, this.createEggTable(FossilsLegacyItems.TYRANNOSAURUS_EGG.get()));
        this.add(FossilsLegacyEntityTypes.EGG.get(), FossilsLegacyLootTables.VELOCIRAPTOR_EGG, this.createEggTable(FossilsLegacyItems.VELOCIRAPTOR_EGG.get()));

        this.add(FossilsLegacyEntityTypes.PREGNANT_ARMADILLO.get(), LootTable.lootTable());
        this.add(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.STRING).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_COW.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BEEF).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), LootTable.lootTable());
        this.add(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), LootTable.lootTable());
        this.add(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(Items.LEATHER))).withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).setBonusRolls(UniformGenerator.between(1.0F, 2.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.RAW_MAMMOTH.get()).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.LEATHER).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), LootTable.lootTable());
        this.add(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Blocks.BAMBOO).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.PORKCHOP).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.COD).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))).add(LootItem.lootTableItem(Items.SALMON).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_HIDE).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.RABBIT_FOOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.03F))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.MUTTON).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot())).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_BLACK, this.createPregnantSheepTable(Blocks.BLACK_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_BLUE, this.createPregnantSheepTable(Blocks.BLUE_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_BROWN, this.createPregnantSheepTable(Blocks.BROWN_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_CYAN, this.createPregnantSheepTable(Blocks.CYAN_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_GRAY, this.createPregnantSheepTable(Blocks.GRAY_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_GREEN, this.createPregnantSheepTable(Blocks.GREEN_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_LIGHT_BLUE, this.createPregnantSheepTable(Blocks.LIGHT_BLUE_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_LIGHT_GRAY, this.createPregnantSheepTable(Blocks.LIGHT_GRAY_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_LIME, this.createPregnantSheepTable(Blocks.LIME_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_MAGENTA, this.createPregnantSheepTable(Blocks.MAGENTA_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_ORANGE, this.createPregnantSheepTable(Blocks.ORANGE_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_PINK, this.createPregnantSheepTable(Blocks.PINK_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_PURPLE, this.createPregnantSheepTable(Blocks.PURPLE_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_RED, this.createPregnantSheepTable(Blocks.RED_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_WHITE, this.createPregnantSheepTable(Blocks.WHITE_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), FossilsLegacyLootTables.PREGNANT_SHEEP_YELLOW, this.createPregnantSheepTable(Blocks.YELLOW_WOOL));
        this.add(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), this.createDinosaurTable(1.0F, 3.0F, FossilsLegacyItems.RAW_SMILODON.get()));
        this.add(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), LootTable.lootTable());

        this.add(FossilsLegacyEntityTypes.ANU.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F)).add(LootItem.lootTableItem(Items.COOKED_PORKCHOP))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(FossilsLegacyBlocks.TIME_MACHINE.get()))));
        this.add(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.ROTTEN_FLESH).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0f, 1.0f))))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(Items.GOLD_NUGGET).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))).apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.GOLD_INGOT)).when(LootItemKilledByPlayerCondition.killedByPlayer()).when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.025F, 0.01F))));
        this.add(FossilsLegacyEntityTypes.FAILURESAURUS.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 2.0F)).add(LootItem.lootTableItem(FossilsLegacyItems.FOSSIL.get()))));
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
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(NestedLootTable.lootTableReference(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get().getDefaultLootTable())));
    }

    protected LootTable.Builder createEggTable(ItemLike itemLike) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike)));
    }
}
