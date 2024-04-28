package willatendo.fossilslegacy.data.loot;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        this.add(FossilsLegacyBlocks.FOSSIL_ORE.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FossilsLegacyItems.FOSSIL.get(), 10, 4500), new ItemAndChance(FossilsLegacyItems.RELIC_SCRAP.get(), 4500, 9800), new ItemAndChance(Items.BONE, 9800, 17800), new ItemAndChance(FossilsLegacyBlocks.SKULL_BLOCK.get(), 17800, 19800), new ItemAndChance(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), 19800, 19900), new ItemAndChance(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), 19900, 20000), new ItemAndChance(FossilsLegacyItems.SCARAB_GEM.get(), 0, 10)))));
        this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FossilsLegacyItems.FOSSIL.get(), 10, 4500), new ItemAndChance(FossilsLegacyItems.RELIC_SCRAP.get(), 4500, 9800), new ItemAndChance(Items.BONE, 9800, 17800), new ItemAndChance(FossilsLegacyBlocks.SKULL_BLOCK.get(), 17800, 19800), new ItemAndChance(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), 19800, 19900), new ItemAndChance(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), 19900, 20000), new ItemAndChance(FossilsLegacyItems.SCARAB_GEM.get(), 0, 10)))));
        this.dropSelf(FossilsLegacyBlocks.SKULL_BLOCK.get());
        this.dropSelf(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        this.dropSelf(FossilsLegacyBlocks.ANALYZER.get());
        this.dropSelf(FossilsLegacyBlocks.CULTIVATOR.get());
        this.dropSelf(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.add(FossilsLegacyBlocks.JURASSIC_FERN.get(), block -> this.createDoublePlantWithSeedDrops(block, FossilsLegacyBlocks.JURASSIC_FERN.get()));
        this.dropSelf(FossilsLegacyBlocks.DRUM.get());
        this.dropSelf(FossilsLegacyBlocks.FEEDER.get());
        this.add(FossilsLegacyBlocks.PERMAFROST.get(), block -> this.createSilkTouchDispatchTable(block, this.applyExplosionCondition(block, LootOneItemOfManyRandom.lootTableItem(20000, new ItemAndChance(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 0, 4000), new ItemAndChance(FossilsLegacyBlocks.SKULL_BLOCK.get(), 4000, 8000), new ItemAndChance(FossilsLegacyItems.FROZEN_MEAT.get(), 8000, 12000), new ItemAndChance(Items.BEEF, 12000, 16000), new ItemAndChance(Items.PORKCHOP, 16000, 20000)))));
        this.add(FossilsLegacyBlocks.ICED_STONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        this.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), noDrop());
        this.dropSelf(FossilsLegacyBlocks.TIME_MACHINE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream().filter(block -> FossilsLegacyUtils.ID.equals(BuiltInRegistries.BLOCK.getKey(block).getNamespace())).collect(Collectors.toSet());
    }
}
