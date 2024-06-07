package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom;
import willatendo.fossilslegacy.server.loot.LootOneItemOfManyRandom.ItemAndChance;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Set;
import java.util.stream.Collectors;

public class FossilsLegacyBlockLootSubProvider extends BlockLootSubProvider {
    public FossilsLegacyBlockLootSubProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.add(FossilsLegacyBlocks.FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block));
        this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get(), block -> this.createFossilOreLootTable(block));
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
    }

    protected LootTable.Builder createFossilOreLootTable(Block block) {
        return createSelfDropDispatchTable(block, HAS_SILK_TOUCH, this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FossilsLegacyItems.FOSSIL.get(), 10, 4500), new ItemAndChance(FossilsLegacyItems.RELIC_SCRAP.get(), 4500, 9800), new ItemAndChance(Items.BONE, 9800, 17800), new ItemAndChance(FossilsLegacyBlocks.SKULL_BLOCK.get(), 17800, 19800), new ItemAndChance(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), 19800, 19900), new ItemAndChance(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), 19900, 19925), new ItemAndChance(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 19925, 19950), new ItemAndChance(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 19950, 19975), new ItemAndChance(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), 19975, 20000), new ItemAndChance(FossilsLegacyItems.SCARAB_GEM.get(), 0, 10))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> FossilsLegacyUtils.ID.equals(BuiltInRegistries.BLOCK.getKey(block).getNamespace())).collect(Collectors.toSet());
    }
}
