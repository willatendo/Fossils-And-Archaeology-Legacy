package willatendo.fossilslegacy.server.features;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.OptionalInt;

public class FossilsLegacyConfiguredFeatures {
    // Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_FOSSIL = create("ore_fossil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PERMAFROST = create("ore_permafrost");

    // Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_OAK = create("prehistoric_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_BIRCH = create("prehistoric_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_FANCY_OAK = create("prehistoric_fancy_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_PREHISTORIC_PLAINS = create("trees_prehistoric_plains");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_PREHISTORIC_FOREST = create("trees_prehistoric_forest");

    // Ve
    public static ResourceKey<ConfiguredFeature<?, ?>> create(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, FossilsLegacyUtils.resource(name));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPrehistoricOak() {
        return createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 8, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPrehistoricBirch() {
        return createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 8, 2, 0, 2).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createPrehistoricFancyOak() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(11, 11, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves, int baseHeight, int randHeightA, int randHeightB, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new StraightTrunkPlacer(baseHeight, randHeightA, randHeightB), BlockStateProvider.simple(leaves), new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext) {
        HolderGetter<PlacedFeature> placedFeature = bootstapContext.lookup(Registries.PLACED_FEATURE);
        // Ores
        FeatureUtils.register(bootstapContext, ORE_FOSSIL, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.FOSSIL_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get().defaultBlockState())), 8, 0.0F));
        FeatureUtils.register(bootstapContext, ORE_PERMAFROST, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.PERMAFROST.get().defaultBlockState())), 8, 0.0F));

        // Trees
        FeatureUtils.register(bootstapContext, PREHISTORIC_OAK, Feature.TREE, createPrehistoricOak().build());
        FeatureUtils.register(bootstapContext, PREHISTORIC_BIRCH, Feature.TREE, createPrehistoricBirch().build());
        FeatureUtils.register(bootstapContext, PREHISTORIC_FANCY_OAK, Feature.TREE, createPrehistoricFancyOak().build());
        FeatureUtils.register(bootstapContext, TREES_PREHISTORIC_PLAINS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(FossilsLegacyPlacedFeatures.PREHISTORIC_FANCY_OAK_CHECKED), 0.33333334F)), placedFeature.getOrThrow(FossilsLegacyPlacedFeatures.PREHISTORIC_OAK_CHECKED)));
        FeatureUtils.register(bootstapContext, TREES_PREHISTORIC_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(FossilsLegacyPlacedFeatures.PREHISTORIC_BIRCH_CHECKED), 0.2F), new WeightedPlacedFeature(placedFeature.getOrThrow(FossilsLegacyPlacedFeatures.PREHISTORIC_FANCY_OAK_CHECKED), 0.1F)), placedFeature.getOrThrow(FossilsLegacyPlacedFeatures.PREHISTORIC_OAK_CHECKED)));
    }
}
