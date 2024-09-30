package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom.ItemAndChance;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.loot.SimpleBlockLootSubProvider;

public class FossilsLegacyBlockLootSubProvider extends SimpleBlockLootSubProvider {

    public FossilsLegacyBlockLootSubProvider(HolderLookup.Provider registries) {
        super(registries, FossilsLegacyUtils.ID);
    }

    @Override
    public void generate() {
        this.add(FossilsLegacyBlocks.FOSSIL_ORE.get(), this::createFossilOreLootTable);
        this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get(), this::createFossilOreLootTable);
        this.dropSelf(FossilsLegacyBlocks.SKULL_BLOCK.get());
        this.dropSelf(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        this.dropSelf(FossilsLegacyBlocks.ANALYZER.get());
        this.dropSelf(FossilsLegacyBlocks.WHITE_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.LIME_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.PINK_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.GRAY_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.CYAN_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.BLUE_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.BROWN_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.GREEN_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.RED_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.BLACK_CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get());
        this.dropSelf(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.add(FossilsLegacyBlocks.JURASSIC_FERN.get(), block -> this.createDoublePlantWithSeedDrops(block, FossilsLegacyBlocks.JURASSIC_FERN.get()));
        this.dropSelf(FossilsLegacyBlocks.DRUM.get());
        this.dropSelf(FossilsLegacyBlocks.FEEDER.get());
        this.add(FossilsLegacyBlocks.PERMAFROST.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0, 4000), new ItemAndChance(FossilsLegacyBlocks.SKULL_BLOCK.get(), 4000, 8000), new ItemAndChance(FossilsLegacyItems.FROZEN_MEAT.get(), 8000, 12000), new ItemAndChance(Items.BEEF, 12000, 16000), new ItemAndChance(Items.PORKCHOP, 16000, 20000)))));
        this.add(FossilsLegacyBlocks.ICED_STONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        this.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), noDrop());
        this.dropSelf(FossilsLegacyBlocks.TIME_MACHINE.get());
        this.dropOther(FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(FossilsLegacyBlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(FossilsLegacyBlocks.COOKED_BERRY_MEDLEY_CAULDRON.get(), Blocks.CAULDRON);
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get());
        this.dropSelf(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get());
        this.dropSelf(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), block -> this.createLeavesDrops(block, FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_SIGN.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get(), this::createDoorTable);
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_HANGING_SIGN.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_PRESSURE_PLATE.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get());
        this.dropPottedContents(FossilsLegacyBlocks.POTTED_LEPIDODENDRON_SAPLING.get());
        this.dropSelf(FossilsLegacyBlocks.LEPIDODENDRON_BUTTON.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_SAPLING.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_LOG.get());
        this.dropSelf(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_WOOD.get());
        this.dropSelf(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get(), block -> this.createLeavesDrops(block, FossilsLegacyBlocks.SIGILLARIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_STAIRS.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_SIGN.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_DOOR.get(), this::createDoorTable);
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_HANGING_SIGN.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_PRESSURE_PLATE.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_FENCE.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_TRAPDOOR.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get());
        this.dropPottedContents(FossilsLegacyBlocks.POTTED_SIGILLARIA_SAPLING.get());
        this.dropSelf(FossilsLegacyBlocks.SIGILLARIA_BUTTON.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_SLAB.get(), this::createSlabItemTable);
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_PLANKS.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_SAPLING.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_LOG.get());
        this.dropSelf(FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_WOOD.get());
        this.dropSelf(FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get());
        this.add(FossilsLegacyBlocks.CALAMITES_LEAVES.get(), block -> this.createLeavesDrops(block, FossilsLegacyBlocks.CALAMITES_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_STAIRS.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_SIGN.get());
        this.add(FossilsLegacyBlocks.CALAMITES_DOOR.get(), this::createDoorTable);
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_HANGING_SIGN.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_PRESSURE_PLATE.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_FENCE.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_TRAPDOOR.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get());
        this.dropPottedContents(FossilsLegacyBlocks.POTTED_CALAMITES_SAPLING.get());
        this.dropSelf(FossilsLegacyBlocks.CALAMITES_BUTTON.get());
        this.add(FossilsLegacyBlocks.CALAMITES_SLAB.get(), this::createSlabItemTable);
    }

    protected LootTable.Builder createFossilOreLootTable(Block block) {
        return createSelfDropDispatchTable(block, this.hasSilkTouch(), this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FossilsLegacyItems.FOSSIL.get(), 10, 4500), new ItemAndChance(FossilsLegacyItems.RELIC_SCRAP.get(), 4500, 9800), new ItemAndChance(Items.BONE, 9800, 17800), new ItemAndChance(FossilsLegacyBlocks.SKULL_BLOCK.get(), 17800, 19800), new ItemAndChance(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), 19800, 19820), new ItemAndChance(FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get(), 19820, 19840), new ItemAndChance(FossilsLegacyItems.ANCIENT_PICKAXE_ARTIFACT.get(), 19840, 19860), new ItemAndChance(FossilsLegacyItems.ANCIENT_AXE_ARTIFACT.get(), 19860, 19880), new ItemAndChance(FossilsLegacyItems.ANCIENT_HOE_ARTIFACT.get(), 19880, 19900), new ItemAndChance(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), 19900, 19925), new ItemAndChance(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 19925, 19950), new ItemAndChance(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 19950, 19975), new ItemAndChance(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), 19975, 20000), new ItemAndChance(FossilsLegacyItems.SCARAB_GEM.get(), 0, 10))));
    }
}
