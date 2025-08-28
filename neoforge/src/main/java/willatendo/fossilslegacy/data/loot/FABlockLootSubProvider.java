package willatendo.fossilslegacy.data.loot;

import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.*;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.loot.LootRandomItem;
import willatendo.fossilslegacy.server.loot.LootRandomItem.RandomItemEntry;
import willatendo.fossilslegacy.server.registry.FABlockRegistry;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.loot.SimpleBlockLootSubProvider;

import java.util.stream.IntStream;

public class FABlockLootSubProvider extends SimpleBlockLootSubProvider {
    public FABlockLootSubProvider(HolderLookup.Provider registries) {
        super(registries, FAUtils.ID);
    }

    @Override
    public void generate() {
        this.add(FABlocks.CENOZOIC_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.CENOZOIC_FOSSIL.get(), 0, 3), new RandomItemEntry(Items.BONE, 3, 9), new RandomItemEntry(FABlocks.SKULL_BLOCK.get(), 9, 10)));
        this.add(FABlocks.MESOZOIC_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.MESOZOIC_FOSSIL.get(), 0, 3), new RandomItemEntry(Items.BONE, 3, 9), new RandomItemEntry(FABlocks.SKULL_BLOCK.get(), 9, 10)));
        this.add(FABlocks.PALAEOZOIC_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.PALAEOZOIC_FOSSIL.get(), 0, 3), new RandomItemEntry(Items.BONE, 3, 9), new RandomItemEntry(FABlocks.SKULL_BLOCK.get(), 90, 100)));
        this.add(FABlocks.DEEPSLATE_CENOZOIC_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.CENOZOIC_FOSSIL.get(), 0, 3), new RandomItemEntry(Items.BONE, 3, 9), new RandomItemEntry(FABlocks.SKULL_BLOCK.get(), 90, 100)));
        this.add(FABlocks.DEEPSLATE_MESOZOIC_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.MESOZOIC_FOSSIL.get(), 0, 3), new RandomItemEntry(Items.BONE, 3, 9), new RandomItemEntry(FABlocks.SKULL_BLOCK.get(), 90, 100)));
        this.add(FABlocks.DEEPSLATE_PALAEOZOIC_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.PALAEOZOIC_FOSSIL.get(), 0, 3), new RandomItemEntry(Items.BONE, 3, 9), new RandomItemEntry(FABlocks.SKULL_BLOCK.get(), 90, 100)));
        this.add(FABlocks.AMBER_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.AMBER.get(), 0, 9), new RandomItemEntry(FAItems.MOSQUITO_IN_AMBER.get(), 9, 10)));
        this.add(FABlocks.DEEPSLATE_AMBER_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.AMBER.get(), 0, 9), new RandomItemEntry(FAItems.MOSQUITO_IN_AMBER.get(), 9, 10)));
        this.add(FABlocks.PLANT_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.PLANT_FOSSIL.get(), 0, 4), new RandomItemEntry(Items.COAL, 6, 10)));
        this.add(FABlocks.DEEPSLATE_PLANT_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block, 10, new RandomItemEntry(FAItems.PLANT_FOSSIL.get(), 0, 4), new RandomItemEntry(Items.COAL, 6, 10)));
        this.add(FABlocks.RELIC_IN_STONE.get(), block -> this.createFossilOreLootTable(block, 2000, new RandomItemEntry(FAItems.SCARAB_GEM.get(), 0, 1), new RandomItemEntry(FAItems.PREHISTORIC_COIN.get(), 1, 2), new RandomItemEntry(FAItems.RELIC_SCRAP.get(), 2, 1550), new RandomItemEntry(FAItems.ANCIENT_SWORD_ARTIFACT.get(), 1550, 1600), new RandomItemEntry(FAItems.ANCIENT_SHOVEL_ARTIFACT.get(), 1600, 1650), new RandomItemEntry(FAItems.ANCIENT_PICKAXE_ARTIFACT.get(), 1650, 1700), new RandomItemEntry(FAItems.ANCIENT_AXE_ARTIFACT.get(), 1700, 1750), new RandomItemEntry(FAItems.ANCIENT_HOE_ARTIFACT.get(), 1750, 1800), new RandomItemEntry(FAItems.ANCIENT_HELMET_ARTIFACT.get(), 1800, 1850), new RandomItemEntry(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 1850, 1900), new RandomItemEntry(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 1900, 1950), new RandomItemEntry(FAItems.ANCIENT_BOOTS_ARTIFACT.get(), 1950, 2000)));
        this.add(FABlocks.RELIC_IN_DEEPSLATE.get(), block -> this.createFossilOreLootTable(block, 2000, new RandomItemEntry(FAItems.SCARAB_GEM.get(), 0, 1), new RandomItemEntry(FAItems.PREHISTORIC_COIN.get(), 1, 2), new RandomItemEntry(FAItems.RELIC_SCRAP.get(), 2, 1550), new RandomItemEntry(FAItems.ANCIENT_SWORD_ARTIFACT.get(), 1550, 1600), new RandomItemEntry(FAItems.ANCIENT_SHOVEL_ARTIFACT.get(), 1600, 1650), new RandomItemEntry(FAItems.ANCIENT_PICKAXE_ARTIFACT.get(), 1650, 1700), new RandomItemEntry(FAItems.ANCIENT_AXE_ARTIFACT.get(), 1700, 1750), new RandomItemEntry(FAItems.ANCIENT_HOE_ARTIFACT.get(), 1750, 1800), new RandomItemEntry(FAItems.ANCIENT_HELMET_ARTIFACT.get(), 1800, 1850), new RandomItemEntry(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 1850, 1900), new RandomItemEntry(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 1900, 1950), new RandomItemEntry(FAItems.ANCIENT_BOOTS_ARTIFACT.get(), 1950, 2000)));
        this.dropWhenSilkTouch(FABlocks.FROZEN_LEECH.get());
        this.add(FABlocks.LEECH_IN_ICE.get(), block -> this.createSingleItemTableWithSilkTouch(block, FAItems.FROZEN_LEECH.get()));
        this.dropSelf(FABlocks.SKULL_BLOCK.get());
        this.dropSelf(FABlocks.SKULL_LANTERN_BLOCK.get());
        this.dropSelf(FABlocks.DNA_ANALYZER.get());
        this.dropSelf(FABlocks.DNA_CODER.get());
        this.dropSelf(FABlocks.DNA_HYBRIDIZER.get());
        this.dropSelf(FABlocks.WHITE_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.WHITE_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.ORANGE_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.ORANGE_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.MAGENTA_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.MAGENTA_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.LIGHT_BLUE_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.LIGHT_BLUE_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.YELLOW_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.YELLOW_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.LIME_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.LIME_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.PINK_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.PINK_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.GRAY_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.GRAY_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.LIGHT_GRAY_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.LIGHT_GRAY_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.CYAN_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.CYAN_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.PURPLE_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.PURPLE_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.BLUE_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.BLUE_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.BROWN_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.BROWN_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.GREEN_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.GREEN_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.RED_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.RED_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.BLACK_CULTIVATOR.get());
        this.createOtherWhenSilkTouch(FABlocks.BLACK_SHATTERED_CULTIVATOR.get(), Items.IRON_INGOT, 3);
        this.dropSelf(FABlocks.DNA_RECOMBINATOR.get());
        this.dropSelf(FABlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.dropSelf(FABlocks.PALAEONTOLOGY_TABLE.get());
        this.add(FABlocks.JURASSIC_FERN.get(), block -> this.createDoublePlantWithSeedDrops(block, FAItems.JURASSIC_FERN_SPORES.get(), FABlocks.JURASSIC_FERN.get()));
        this.add(FABlocks.SHORT_HORSETAIL.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(IntStream.rangeClosed(1, 3).boxed().toList(), integer -> SetItemCountFunction.setCount(ConstantValue.exactly(integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HorsetailBlock.AMOUNT, integer))))))));
        this.add(FABlocks.TALL_HORSETAIL.get(), block -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).apply(IntStream.rangeClosed(1, 3).boxed().toList(), integer -> SetItemCountFunction.setCount(ConstantValue.exactly(integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HorsetailBlock.AMOUNT, integer)))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))))));
        this.dropSelf(FABlocks.DRUM.get());
        this.dropSelf(FABlocks.FEEDER.get());
        this.add(FABlocks.PERMAFROST.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootRandomItem.randomItem(10, new RandomItemEntry(FABlocks.SKULL_BLOCK.get(), 0, 3), new RandomItemEntry(FAItems.FROZEN_MEAT.get(), 3, 6), new RandomItemEntry(Items.BEEF, 6, 8), new RandomItemEntry(Items.PORKCHOP, 8, 10)))));
        this.add(FABlocks.ICED_STONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        this.add(FABlocks.AXOLOTLSPAWN.get(), noDrop());
        this.dropSelf(FABlocks.TIME_MACHINE.get());
        this.dropOther(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get(), Blocks.CAULDRON);
        this.add(FABlocks.MAYAN_VASE.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BRICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MayanVaseBlock.CRACKED, true))).otherwise(LootItem.lootTableItem(block)))));
        this.add(FABlocks.MAYAN_JADE_VASE.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BRICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MayanVaseBlock.CRACKED, true))).otherwise(LootItem.lootTableItem(block)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.JADE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MayanVaseBlock.CRACKED, true))))));
        this.add(FABlocks.MAYAN_OCELOT_VASE.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BRICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MayanVaseBlock.CRACKED, true))).otherwise(LootItem.lootTableItem(block)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.JADE_OCELOT.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MayanVaseBlock.CRACKED, true))))));
        this.add(FABlocks.MAYAN_VILLAGER_VASE.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(Items.BRICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MayanVaseBlock.CRACKED, true))).otherwise(LootItem.lootTableItem(block)))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(FAItems.JADE_VILLAGER.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MayanVaseBlock.CRACKED, true))))));
        this.dropSelf(FABlocks.IRON_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.COPPER_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.WAXED_COPPER_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        this.dropSelf(FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get());
        this.dropOther(FABlocks.WHITE_DECORATION_POST.get(), FAItems.WHITE_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.ORANGE_DECORATION_POST.get(), FAItems.ORANGE_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.MAGENTA_DECORATION_POST.get(), FAItems.MAGENTA_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.LIGHT_BLUE_DECORATION_POST.get(), FAItems.LIGHT_BLUE_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.YELLOW_DECORATION_POST.get(), FAItems.YELLOW_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.LIME_DECORATION_POST.get(), FAItems.LIME_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.PINK_DECORATION_POST.get(), FAItems.PINK_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.GRAY_DECORATION_POST.get(), FAItems.GRAY_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.LIGHT_GRAY_DECORATION_POST.get(), FAItems.LIGHT_GRAY_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.CYAN_DECORATION_POST.get(), FAItems.CYAN_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.PURPLE_DECORATION_POST.get(), FAItems.PURPLE_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.BLUE_DECORATION_POST.get(), FAItems.BLUE_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.BROWN_DECORATION_POST.get(), FAItems.BROWN_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.GREEN_DECORATION_POST.get(), FAItems.GREEN_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.RED_DECORATION_POST.get(), FAItems.RED_DECORATION_PLAQUE.get());
        this.dropOther(FABlocks.BLACK_DECORATION_POST.get(), FAItems.BLACK_DECORATION_PLAQUE.get());
        this.dropSelf(FABlocks.SMALL_CAGE.get());
        this.add(FABlocks.MEDIUM_CAGE.get(), block -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MediumCageBlock.HALF, DoubleBlockHalf.LOWER).hasProperty(MediumCageBlock.PART, 1)))))));
        this.dropSelf(FABlocks.STRAIGHT_TRACK.get());
        this.add(FABlocks.CORNER_TRACK.get(), block -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornerTrackBlock.PART, 1)))))));
        this.add(FABlocks.RAMP_TRACK.get(), block -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RampTrackBlock.PART, 1)))))));
        this.dropSelf(FABlocks.CYCAD_HEAD.get());
        this.dropSelf(FABlocks.CYCAD_LOG.get());
        this.add(FABlocks.COOKSONIA.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(IntStream.rangeClosed(1, 4).boxed().toList(), integer -> SetItemCountFunction.setCount(ConstantValue.exactly(integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CooksoniaBlock.AMOUNT, integer))))))));
        this.dropSelf(FABlocks.CLAYTOSMUNDA.get());
        this.dropSelf(FABlocks.CYCADEOIDEA.get());
        this.dropSelf(FABlocks.NIPA.get());
        this.add(FABlocks.ONYCHIOPSIS.get(), block -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(IntStream.rangeClosed(1, 4).boxed().toList(), integer -> SetItemCountFunction.setCount(ConstantValue.exactly(integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnychiopsisBlock.AMOUNT, integer))))))));
        this.dropSelf(FABlocks.PACHYPTERIS.get());
        this.dropSelf(FABlocks.PACHYPODIUM.get());
        this.dropSelf(FABlocks.WILLIAMSONIA.get());
        this.add(FABlocks.MACROTAENIOPTERIS.get(), block -> LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).apply(IntStream.rangeClosed(1, 5).boxed().toList(), integer -> SetItemCountFunction.setCount(ConstantValue.exactly(integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MacrotaeniopterisBlock.AMOUNT, integer)))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))))));
        this.dropSelf(FABlocks.DIPTERIS.get());
        this.dropSelf(FABlocks.ZAMITES_HEAD.get());
        this.dropSelf(FABlocks.ZAMITES_LOG.get());
        this.dropSelf(FABlocks.ZAMITES_BRANCH.get());
        this.dropSelf(FABlocks.SALVINIA.get());
        this.dropSelf(FABlocks.LOTUS.get());
        this.dropSelf(FABlocks.SARCANDRA.get());
        for (int i = 0; i < FABlockRegistry.woodSize(); i++) {
            this.dropSelf(FABlockRegistry.getPlanks(i).get());
            SaplingBlock sapling = FABlockRegistry.getSapling(i).get();
            this.dropSelf(sapling);
            this.dropSelf(FABlockRegistry.getLog(i).get());
            this.dropSelf(FABlockRegistry.getStrippedLog(i).get());
            this.dropSelf(FABlockRegistry.getWood(i).get());
            this.dropSelf(FABlockRegistry.getStrippedWood(i).get());
            this.add(FABlockRegistry.getLeaves(i).get(), block -> this.createLeavesDrops(block, sapling, NORMAL_LEAVES_SAPLING_CHANCES));
            this.dropSelf(FABlockRegistry.getStairs(i).get());
            this.dropSelf(FABlockRegistry.getSign(i).get());
            this.add(FABlockRegistry.getDoor(i).get(), this::createDoorTable);
            this.dropSelf(FABlockRegistry.getHangingSign(i).get());
            this.dropSelf(FABlockRegistry.getPressurePlate(i).get());
            this.dropSelf(FABlockRegistry.getFence(i).get());
            this.dropSelf(FABlockRegistry.getTrapdoor(i).get());
            this.dropSelf(FABlockRegistry.getFenceGate(i).get());
            this.dropPottedContents(FABlockRegistry.getPottedSapling(i).get());
            this.dropSelf(FABlockRegistry.getButton(i).get());
            this.add(FABlockRegistry.getSlab(i).get(), this::createSlabItemTable);
        }
        for (Block headBlock : FABlockRegistry.getAllHeads()) {
            this.dropSelf(headBlock);
        }
        this.dropSelf(FABlocks.ASPHALT.get());
        this.dropSelf(FABlocks.ASPHALT_STAIRS.get());
        this.dropSelfSlab(FABlocks.ASPHALT_SLAB.get());
        this.dropSelf(FABlocks.ASPHALT_WALL.get());
        this.dropSelf(FABlocks.POLISHED_ASPHALT.get());
        this.dropSelf(FABlocks.POLISHED_ASPHALT_STAIRS.get());
        this.dropSelfSlab(FABlocks.POLISHED_ASPHALT_SLAB.get());
        this.dropSelf(FABlocks.POLISHED_ASPHALT_WALL.get());
        this.dropSelf(FABlocks.POLISHED_ASPHALT_BRICKS.get());
        this.dropSelf(FABlocks.POLISHED_ASPHALT_BRICK_STAIRS.get());
        this.dropSelfSlab(FABlocks.POLISHED_ASPHALT_BRICK_SLAB.get());
        this.dropSelf(FABlocks.POLISHED_ASPHALT_BRICK_WALL.get());
        this.dropSelf(FABlocks.SOLID_WHITE_MARKING.get());
        this.dropSelf(FABlocks.DOUBLE_SOLID_WHITE_MARKING.get());
        this.dropSelf(FABlocks.HARDENED_TAR_BLOCK.get());
        this.dropSelf(FABlocks.HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.WHITE_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.ORANGE_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.MAGENTA_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.LIGHT_BLUE_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.YELLOW_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.LIME_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.PINK_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.GRAY_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.LIGHT_GRAY_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.CYAN_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.PURPLE_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.BLUE_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.BROWN_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.GREEN_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.RED_HOLOGRAM_PROJECTOR.get());
        this.dropSelf(FABlocks.BLACK_HOLOGRAM_PROJECTOR.get());
    }

    protected LootTable.Builder createFossilOreLootTable(Block block, int randomRange, RandomItemEntry... randomItemEntries) {
        return BlockLootSubProvider.createSelfDropDispatchTable(block, this.hasSilkTouch(), this.applyExplosionCondition(block, LootRandomItem.randomItem(randomRange, randomItemEntries)));
    }

    protected void createOtherWhenSilkTouch(Block block, ItemLike other, int amount) {
        this.add(block, this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(other).apply(SetItemCountFunction.setCount(ConstantValue.exactly(amount))))));
    }

    protected LootTable.Builder createDoublePlantWithSeedDrops(Block block, ItemLike seeds, Block sheared) {
        HolderLookup.RegistryLookup<Block> blocks = this.registries.lookupOrThrow(Registries.BLOCK);
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(sheared).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).when(this.hasShears()).otherwise(this.applyExplosionCondition(block, LootItem.lootTableItem(seeds)).when(LootItemRandomChanceCondition.randomChance(0.125F)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blocks, block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blocks, block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }


}
