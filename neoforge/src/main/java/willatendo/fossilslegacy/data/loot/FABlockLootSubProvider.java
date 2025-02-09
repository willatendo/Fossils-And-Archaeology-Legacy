package willatendo.fossilslegacy.data.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.MayanVaseBlock;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom.ItemAndChance;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.loot.SimpleBlockLootSubProvider;

public class FABlockLootSubProvider extends SimpleBlockLootSubProvider {
    public FABlockLootSubProvider(HolderLookup.Provider registries) {
        super(registries, FAUtils.ID);
    }

    @Override
    public void generate() {
        this.add(FABlocks.FOSSIL_ORE.get(), this::createFossilOreLootTable);
        this.add(FABlocks.DEEPSLATE_FOSSIL_ORE.get(), this::createFossilOreLootTable);
        this.dropSelf(FABlocks.SKULL_BLOCK.get());
        this.dropSelf(FABlocks.SKULL_LANTERN_BLOCK.get());
        this.dropSelf(FABlocks.ANALYZER.get());
        this.dropSelf(FABlocks.WHITE_CULTIVATOR.get());
        this.dropSelf(FABlocks.ORANGE_CULTIVATOR.get());
        this.dropSelf(FABlocks.MAGENTA_CULTIVATOR.get());
        this.dropSelf(FABlocks.LIGHT_BLUE_CULTIVATOR.get());
        this.dropSelf(FABlocks.YELLOW_CULTIVATOR.get());
        this.dropSelf(FABlocks.LIME_CULTIVATOR.get());
        this.dropSelf(FABlocks.PINK_CULTIVATOR.get());
        this.dropSelf(FABlocks.GRAY_CULTIVATOR.get());
        this.dropSelf(FABlocks.LIGHT_GRAY_CULTIVATOR.get());
        this.dropSelf(FABlocks.CYAN_CULTIVATOR.get());
        this.dropSelf(FABlocks.PURPLE_CULTIVATOR.get());
        this.dropSelf(FABlocks.BLUE_CULTIVATOR.get());
        this.dropSelf(FABlocks.BROWN_CULTIVATOR.get());
        this.dropSelf(FABlocks.GREEN_CULTIVATOR.get());
        this.dropSelf(FABlocks.RED_CULTIVATOR.get());
        this.dropSelf(FABlocks.BLACK_CULTIVATOR.get());
        this.dropSelf(FABlocks.GENE_MODIFICATION_TABLE.get());
        this.dropSelf(FABlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.dropSelf(FABlocks.PALAEONTOLOGY_TABLE.get());
        this.add(FABlocks.JURASSIC_FERN.get(), block -> this.createDoublePlantWithSeedDrops(block, FABlocks.JURASSIC_FERN.get()));
        this.dropSelf(FABlocks.DRUM.get());
        this.dropSelf(FABlocks.FEEDER.get());
        this.add(FABlocks.PERMAFROST.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FAItems.JURASSIC_FERN_SPORES.get(), 0, 4000), new ItemAndChance(FABlocks.SKULL_BLOCK.get(), 4000, 8000), new ItemAndChance(FAItems.FROZEN_MEAT.get(), 8000, 12000), new ItemAndChance(Items.BEEF, 12000, 16000), new ItemAndChance(Items.PORKCHOP, 16000, 20000)))));
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
        this.dropSelf(FABlocks.LEPIDODENDRON_PLANKS.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_SAPLING.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_LOG.get());
        this.dropSelf(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_WOOD.get());
        this.dropSelf(FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.add(FABlocks.LEPIDODENDRON_LEAVES.get(), block -> this.createLeavesDrops(block, FABlocks.LEPIDODENDRON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(FABlocks.LEPIDODENDRON_STAIRS.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_SIGN.get());
        this.add(FABlocks.LEPIDODENDRON_DOOR.get(), this::createDoorTable);
        this.dropSelf(FABlocks.LEPIDODENDRON_HANGING_SIGN.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_FENCE.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_TRAPDOOR.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_FENCE_GATE.get());
        this.dropPottedContents(FABlocks.POTTED_LEPIDODENDRON_SAPLING.get());
        this.dropSelf(FABlocks.LEPIDODENDRON_BUTTON.get());
        this.add(FABlocks.LEPIDODENDRON_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(FABlocks.SIGILLARIA_PLANKS.get());
        this.dropSelf(FABlocks.SIGILLARIA_SAPLING.get());
        this.dropSelf(FABlocks.SIGILLARIA_LOG.get());
        this.dropSelf(FABlocks.STRIPPED_SIGILLARIA_LOG.get());
        this.dropSelf(FABlocks.SIGILLARIA_WOOD.get());
        this.dropSelf(FABlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.add(FABlocks.SIGILLARIA_LEAVES.get(), block -> this.createLeavesDrops(block, FABlocks.SIGILLARIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(FABlocks.SIGILLARIA_STAIRS.get());
        this.dropSelf(FABlocks.SIGILLARIA_SIGN.get());
        this.add(FABlocks.SIGILLARIA_DOOR.get(), this::createDoorTable);
        this.dropSelf(FABlocks.SIGILLARIA_HANGING_SIGN.get());
        this.dropSelf(FABlocks.SIGILLARIA_PRESSURE_PLATE.get());
        this.dropSelf(FABlocks.SIGILLARIA_FENCE.get());
        this.dropSelf(FABlocks.SIGILLARIA_TRAPDOOR.get());
        this.dropSelf(FABlocks.SIGILLARIA_FENCE_GATE.get());
        this.dropPottedContents(FABlocks.POTTED_SIGILLARIA_SAPLING.get());
        this.dropSelf(FABlocks.SIGILLARIA_BUTTON.get());
        this.add(FABlocks.SIGILLARIA_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(FABlocks.CALAMITES_PLANKS.get());
        this.dropSelf(FABlocks.CALAMITES_SAPLING.get());
        this.dropSelf(FABlocks.CALAMITES_LOG.get());
        this.dropSelf(FABlocks.STRIPPED_CALAMITES_LOG.get());
        this.dropSelf(FABlocks.CALAMITES_WOOD.get());
        this.dropSelf(FABlocks.STRIPPED_CALAMITES_WOOD.get());
        this.add(FABlocks.CALAMITES_LEAVES.get(), block -> this.createLeavesDrops(block, FABlocks.CALAMITES_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(FABlocks.CALAMITES_STAIRS.get());
        this.dropSelf(FABlocks.CALAMITES_SIGN.get());
        this.add(FABlocks.CALAMITES_DOOR.get(), this::createDoorTable);
        this.dropSelf(FABlocks.CALAMITES_HANGING_SIGN.get());
        this.dropSelf(FABlocks.CALAMITES_PRESSURE_PLATE.get());
        this.dropSelf(FABlocks.CALAMITES_FENCE.get());
        this.dropSelf(FABlocks.CALAMITES_TRAPDOOR.get());
        this.dropSelf(FABlocks.CALAMITES_FENCE_GATE.get());
        this.dropPottedContents(FABlocks.POTTED_CALAMITES_SAPLING.get());
        this.dropSelf(FABlocks.CALAMITES_BUTTON.get());
        this.add(FABlocks.CALAMITES_SLAB.get(), this::createSlabItemTable);
    }

    protected LootTable.Builder createFossilOreLootTable(Block block) {
        return createSelfDropDispatchTable(block, this.hasSilkTouch(), this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FAItems.FOSSIL.get(), 10, 4500), new ItemAndChance(FAItems.RELIC_SCRAP.get(), 4500, 9800), new ItemAndChance(Items.BONE, 9800, 17800), new ItemAndChance(FABlocks.SKULL_BLOCK.get(), 17800, 19800), new ItemAndChance(FAItems.ANCIENT_SWORD_ARTIFACT.get(), 19800, 19820), new ItemAndChance(FAItems.ANCIENT_SHOVEL_ARTIFACT.get(), 19820, 19840), new ItemAndChance(FAItems.ANCIENT_PICKAXE_ARTIFACT.get(), 19840, 19860), new ItemAndChance(FAItems.ANCIENT_AXE_ARTIFACT.get(), 19860, 19880), new ItemAndChance(FAItems.ANCIENT_HOE_ARTIFACT.get(), 19880, 19900), new ItemAndChance(FAItems.ANCIENT_HELMET_ARTIFACT.get(), 19900, 19925), new ItemAndChance(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 19925, 19950), new ItemAndChance(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 19950, 19975), new ItemAndChance(FAItems.ANCIENT_BOOTS_ARTIFACT.get(), 19975, 20000), new ItemAndChance(FAItems.SCARAB_GEM.get(), 0, 10))));
    }
}
