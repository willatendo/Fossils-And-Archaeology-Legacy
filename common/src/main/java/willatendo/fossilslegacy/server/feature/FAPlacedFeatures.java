package willatendo.fossilslegacy.server.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public final class FAPlacedFeatures {
    private static final PlacementModifier TREE_THRESHOLD = SurfaceWaterDepthFilter.forMaxDepth(0);

    //Ores
    public static final ResourceKey<PlacedFeature> ORE_CENOZOIC_FOSSIL = create("ore_cenozoic_fossil");
    public static final ResourceKey<PlacedFeature> ORE_MESOZOIC_FOSSIL = create("ore_mesozoic_fossil");
    public static final ResourceKey<PlacedFeature> ORE_PALAEOZOIC_FOSSIL = create("ore_palaeozoic_fossil");
    public static final ResourceKey<PlacedFeature> ORE_AMBER = create("ore_amber");
    public static final ResourceKey<PlacedFeature> ORE_PLANT_FOSSIL = create("ore_plant_fossil");
    public static final ResourceKey<PlacedFeature> ORE_RELIC = create("ore_relic");
    public static final ResourceKey<PlacedFeature> ORE_PERMAFROST = create("ore_permafrost");

    public static final ResourceKey<PlacedFeature> CYCAD_CHECKED = create("cycad");
    public static final ResourceKey<PlacedFeature> CYCAD_PATCH = create("cycad_patch");
    public static final ResourceKey<PlacedFeature> FERN_PATCH = create("fern_patch");
    public static final ResourceKey<PlacedFeature> SHORT_HORSETAIL_PATCH = create("short_horsetail_patch");
    public static final ResourceKey<PlacedFeature> TALL_HORSETAIL_PATCH = create("tall_horsetail_patch");
    public static final ResourceKey<PlacedFeature> JURASSIC_FERN_PATCH = create("jurassic_fern_patch");

    //Trees
    public static final ResourceKey<PlacedFeature> ARAUCARIA_CHECKED = create("araucaria_checked");
    public static final ResourceKey<PlacedFeature> ARAUCARIOXYLON_CHECKED = create("araucarioxylon_checked");
    public static final ResourceKey<PlacedFeature> ARCHAEOPTERIS_CHECKED = create("archaeopteris_checked");
    public static final ResourceKey<PlacedFeature> CALAMITES_CHECKED = create("calamites_checked");
    public static final ResourceKey<PlacedFeature> CORDAITES_CHECKED = create("cordaites_checked");
    public static final ResourceKey<PlacedFeature> MEGA_CORDAITES_CHECKED = create("mega_cordaites");
    public static final ResourceKey<PlacedFeature> GINKGO_CHECKED = create("ginkgo_checked");
    public static final ResourceKey<PlacedFeature> LEPIDODENDRON_CHECKED = create("lepidodendron_checked");
    public static final ResourceKey<PlacedFeature> SIGILLARIA_CHECKED = create("sigillaria_checked");
    public static final ResourceKey<PlacedFeature> WOLLEMIA_CHECKED = create("wollemia_checked");
    public static final ResourceKey<PlacedFeature> TREES_MORRISON_FORMATION_PLAINS = create("trees_morrison_formation_plains");
    public static final ResourceKey<PlacedFeature> TREES_MORRISON_FORMATION_FOREST = create("trees_morrison_formation_forest");

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
        return ResourceKey.create(Registries.PLACED_FEATURE, FAUtils.resource(name));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier placementModifier) {
        return FAPlacedFeatures.orePlacement(CountPlacement.of(count), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier placementModifier) {
        return FAPlacedFeatures.orePlacement(RarityFilter.onAverageOnceEvery(rarity), placementModifier);
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
        PlacementUtils.register(bootstrapContext, ORE_CENOZOIC_FOSSIL, configuredFeatures.getOrThrow(FAConfiguredFeatures.ORE_CENOZOIC_FOSSIL), FAPlacedFeatures.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(50), VerticalAnchor.absolute(128))));
        PlacementUtils.register(bootstrapContext, ORE_MESOZOIC_FOSSIL, configuredFeatures.getOrThrow(FAConfiguredFeatures.ORE_MESOZOIC_FOSSIL), FAPlacedFeatures.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(50))));
        PlacementUtils.register(bootstrapContext, ORE_PALAEOZOIC_FOSSIL, configuredFeatures.getOrThrow(FAConfiguredFeatures.ORE_PALAEOZOIC_FOSSIL), FAPlacedFeatures.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(20))));
        PlacementUtils.register(bootstrapContext, ORE_AMBER, configuredFeatures.getOrThrow(FAConfiguredFeatures.ORE_AMBER), FAPlacedFeatures.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(-25), VerticalAnchor.absolute(25))));
        PlacementUtils.register(bootstrapContext, ORE_PLANT_FOSSIL, configuredFeatures.getOrThrow(FAConfiguredFeatures.ORE_PLANT_FOSSIL), FAPlacedFeatures.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(90))));
        PlacementUtils.register(bootstrapContext, ORE_RELIC, configuredFeatures.getOrThrow(FAConfiguredFeatures.ORE_RELIC), FAPlacedFeatures.commonOrePlacement(15, HeightRangePlacement.triangle(VerticalAnchor.absolute(50), VerticalAnchor.absolute(256))));
        PlacementUtils.register(bootstrapContext, ORE_PERMAFROST, configuredFeatures.getOrThrow(FAConfiguredFeatures.ORE_PERMAFROST), FAPlacedFeatures.commonOrePlacement(25, HeightRangePlacement.triangle(VerticalAnchor.absolute(25), VerticalAnchor.absolute(256))));

        PlacementUtils.register(bootstrapContext, CYCAD_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.CYCAD), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.CYCAD_HEAD.get())));
        PlacementUtils.register(bootstrapContext, CYCAD_PATCH, configuredFeatures.getOrThrow(FAConfiguredFeatures.CYCAD_PATCH), VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1)));
        PlacementUtils.register(bootstrapContext, FERN_PATCH, configuredFeatures.getOrThrow(FAConfiguredFeatures.FERN_PATCH), NoiseThresholdCountPlacement.of(-0.8, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, SHORT_HORSETAIL_PATCH, configuredFeatures.getOrThrow(FAConfiguredFeatures.SHORT_HORSETAIL_PATCH), NoiseThresholdCountPlacement.of(-0.8, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, TALL_HORSETAIL_PATCH, configuredFeatures.getOrThrow(FAConfiguredFeatures.TALL_HORSETAIL_PATCH), NoiseThresholdCountPlacement.of(-0.8, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, JURASSIC_FERN_PATCH, configuredFeatures.getOrThrow(FAConfiguredFeatures.JURASSIC_FERN_PATCH));

        // Trees
        PlacementUtils.register(bootstrapContext, ARAUCARIA_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.ARAUCARIA), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.ARAUCARIA_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, ARAUCARIOXYLON_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.ARAUCARIOXYLON), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.ARAUCARIOXYLON_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, ARCHAEOPTERIS_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.ARCHAEOPTERIS), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.ARCHAEOPTERIS_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, CALAMITES_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.CALAMITES), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.CALAMITES_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, CORDAITES_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.CORDAITES), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.CORDAITES_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, MEGA_CORDAITES_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.MEGA_CORDAITES), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.CORDAITES_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, GINKGO_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.GINKGO), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.GINKGO_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, LEPIDODENDRON_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.LEPIDODENDRON), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.LEPIDODENDRON_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, SIGILLARIA_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.SIGILLARIA), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.SIGILLARIA_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, WOLLEMIA_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.WOLLEMIA), List.of(PlacementUtils.filteredByBlockSurvival(FABlocks.WOLLEMIA_SAPLING.get())));
        PlacementUtils.register(bootstrapContext, TREES_MORRISON_FORMATION_PLAINS, configuredFeatures.getOrThrow(FAConfiguredFeatures.TREES_MORRISON_FORMATION), FAPlacedFeatures.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
        PlacementUtils.register(bootstrapContext, TREES_MORRISON_FORMATION_FOREST, configuredFeatures.getOrThrow(FAConfiguredFeatures.TREES_MORRISON_FORMATION), FAPlacedFeatures.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));

        PlacementUtils.register(bootstrapContext, PREHISTORIC_OAK_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.PREHISTORIC_OAK), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_BIRCH_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.PREHISTORIC_BIRCH), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_FANCY_OAK_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.PREHISTORIC_FANCY_OAK), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_SPRUCE_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.PREHISTORIC_SPRUCE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_PINE_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.PREHISTORIC_PINE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        PlacementUtils.register(bootstrapContext, PREHISTORIC_JUNGLE_TREE_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.PREHISTORIC_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
        PlacementUtils.register(bootstrapContext, MEGA_PREHISTORIC_JUNGLE_TREE_CHECKED, configuredFeatures.getOrThrow(FAConfiguredFeatures.MEGA_PREHISTORIC_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));

        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_PLAINS, configuredFeatures.getOrThrow(FAConfiguredFeatures.TREES_PREHISTORIC_PLAINS), PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_FOREST, configuredFeatures.getOrThrow(FAConfiguredFeatures.TREES_PREHISTORIC_FOREST), PlacementUtils.countExtra(10, 0.1F, 1), InSquarePlacement.spread(), placementmodifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_SWAMP, configuredFeatures.getOrThrow(FAConfiguredFeatures.PREHISTORIC_SWAMP_OAK), PlacementUtils.countExtra(2, 0.1F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(2), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_WATER, configuredFeatures.getOrThrow(FAConfiguredFeatures.TREES_PREHISTORIC_WATER), treePlacement(PlacementUtils.countExtra(0, 0.1F, 1)));
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_TAIGA, configuredFeatures.getOrThrow(FAConfiguredFeatures.TREES_PREHISTORIC_TAIGA), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
        PlacementUtils.register(bootstrapContext, TREES_PREHISTORIC_JUNGLE, configuredFeatures.getOrThrow(FAConfiguredFeatures.TREES_PREHISTORIC_JUNGLE), treePlacement(PlacementUtils.countExtra(50, 0.1F, 1)));
    }
}
