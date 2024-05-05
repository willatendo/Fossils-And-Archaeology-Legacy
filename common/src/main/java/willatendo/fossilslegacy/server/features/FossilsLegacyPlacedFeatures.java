package willatendo.fossilslegacy.server.features;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;

public class FossilsLegacyPlacedFeatures {
    //Ores
    public static final ResourceKey<PlacedFeature> ORE_FOSSIL = create("ore_fossil");
    public static final ResourceKey<PlacedFeature> ORE_PERMAFROST = create("ore_permafrost");

    //Trees
    public static final ResourceKey<PlacedFeature> PREHISTORIC_OAK_CHECKED = create("prehistoric_oak_checked");
    public static final ResourceKey<PlacedFeature> PREHISTORIC_BIRCH_CHECKED = create("prehistoric_birch_checked");
    public static final ResourceKey<PlacedFeature> PREHISTORIC_FANCY_OAK_CHECKED = create("prehistoric_fancy_oak_checked");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_PLAINS = create("trees_prehistoric_plains");
    public static final ResourceKey<PlacedFeature> TREES_PREHISTORIC_FOREST = create("trees_prehistoric_forest");

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

    public static void bootstrap(BootstapContext<PlacedFeature> bootstapContext) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = bootstapContext.lookup(Registries.CONFIGURED_FEATURE);
        PlacementModifier placementmodifier = SurfaceWaterDepthFilter.forMaxDepth(0);

        // Ores
        PlacementUtils.register(bootstapContext, ORE_FOSSIL, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.ORE_FOSSIL), FossilsLegacyPlacedFeatures.commonOrePlacement(25, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(128))));
        PlacementUtils.register(bootstapContext, ORE_PERMAFROST, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.ORE_PERMAFROST), FossilsLegacyPlacedFeatures.commonOrePlacement(25, HeightRangePlacement.triangle(VerticalAnchor.absolute(25), VerticalAnchor.absolute(256))));

        // Trees
        PlacementUtils.register(bootstapContext, PREHISTORIC_OAK_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_OAK), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
        PlacementUtils.register(bootstapContext, PREHISTORIC_BIRCH_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_BIRCH), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)));
        PlacementUtils.register(bootstapContext, PREHISTORIC_FANCY_OAK_CHECKED, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.PREHISTORIC_FANCY_OAK), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));

        PlacementUtils.register(bootstapContext, TREES_PREHISTORIC_PLAINS, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.TREES_PREHISTORIC_PLAINS), PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
        PlacementUtils.register(bootstapContext, TREES_PREHISTORIC_FOREST, configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.TREES_PREHISTORIC_FOREST), PlacementUtils.countExtra(10, 0.1F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
    }
}
