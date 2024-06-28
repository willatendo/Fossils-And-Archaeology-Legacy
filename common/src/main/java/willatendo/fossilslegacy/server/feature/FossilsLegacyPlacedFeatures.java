package willatendo.fossilslegacy.server.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class FossilsLegacyPlacedFeatures {
    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    //Ores
    public static final ResourceKey<PlacedFeature> ORE_FOSSIL = create("ore_fossil");
    public static final ResourceKey<PlacedFeature> ORE_PERMAFROST = create("ore_permafrost");

    //Trees
    public static final ResourceKey<PlacedFeature> LEPIDODENDRON_CHECKED = create("lepidodendron_checked");

    public static final ResourceKey<PlacedFeature> PREHISTORIC_OAK_CHECKED = create("prehistoric_oak_checked");
    public static final ResourceKey<PlacedFeature> PREHISTORIC_BIRCH_CHECKED = create("prehistoric_birch_checked");
    public static final ResourceKey<PlacedFeature> PREHISTORIC_FANCY_OAK_CHECKED = create("prehistoric_fancy_oak_checked");
    public static final ResourceKey<PlacedFeature> PREHISTORIC_SPRUCE_CHECKED = create("prehistoric_spruce_checked");
    public static final ResourceKey<PlacedFeature> PREHISTORIC_PINE_CHECKED = create("prehistoric_pine_checked");
    public static final ResourceKey<PlacedFeature> PREHISTORIC_JUNGLE_TREE_CHECKED = create("prehistoric_jungle_tree");
    public static final ResourceKey<PlacedFeature> MEGA_PREHISTORIC_JUNGLE_TREE_CHECKED = create("mega_prehistoric_jungle_tree_checked");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_PLAINS = create("trees_prehistoric_plains");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_FOREST = create("trees_prehistoric_forest");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_SWAMP = create("trees_prehistoric_swamp");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_WATER = create("trees_prehistoric_water");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_TAIGA = create("trees_prehistoric_taiga");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_JUNGLE = create("trees_prehistoric_jungle");

    public static ResourceKey<PlacedFeature> create(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, FossilsLegacyUtils.resource(name));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier placementModifier) {
        return FossilsLegacyPlacedFeatures.orePlacement(CountPlacement.of(count), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier placementModifier) {
        return FossilsLegacyPlacedFeatures.orePlacement(RarityFilter.onAverageOnceEvery(rarity), placementModifier);
    }

    private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier placementModifier) {
        return ImmutableList.<PlacementModifier>builder().add(placementModifier).add(InSquarePlacement.spread()).add(TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
    }

    public static List<PlacementModifier> treePlacement(PlacementModifier placementModifier) {
        return treePlacementBase(placementModifier).build();
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> bootstrapContext) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = bootstrapContext.lookup(Registries.CONFIGURED_FEATURE);
        PlacementModifier placementmodifier = SurfaceWaterDepthFilter.forMaxDepth(0);

        // Ores
        PlacementUtils.register(bootstrapContext, ORE_FOSSIL, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.ORE_FOSSIL), FossilsLegacyPlacedFeatures.commonOrePlacement(25, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(128))));
        PlacementUtils.register(bootstrapContext, ORE_PERMAFROST, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.ORE_PERMAFROST), FossilsLegacyPlacedFeatures.commonOrePlacement(25, HeightRangePlacement.triangle(VerticalAnchor.absolute(25), VerticalAnchor.absolute(256))));

        // Trees
        PlacementUtils.register(bootstrapContext, LEPIDODENDRON_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.LEPIDODENDRON), List.of(PlacementUtils.filteredByBlockSurvival(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get())));

        PlacementUtils.register(bootstrapContext, PREHISTORIC_OAK_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_OAK), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_BIRCH_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_BIRCH), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_FANCY_OAK_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_FANCY_OAK), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_SPRUCE_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_SPRUCE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_PINE_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_PINE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_JUNGLE_TREE_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
        PlacementUtils.register(bootstrapContext, MEGA_PREHISTORIC_JUNGLE_TREE_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.MEGA_PREHISTORIC_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));

        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_PLAINS, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.TREES_PREHISTORIC_PLAINS), PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_FOREST, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.TREES_PREHISTORIC_FOREST), PlacementUtils.countExtra(10, 0.1F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_SWAMP, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_SWAMP_OAK), PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_WATER, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.TREES_PREHISTORIC_WATER), treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_TAIGA, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.TREES_PREHISTORIC_TAIGA), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_JUNGLE, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.TREES_PREHISTORIC_JUNGLE), treePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));
    }
}
