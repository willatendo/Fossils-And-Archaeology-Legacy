package willatendo.fossilslegacy.server.feature;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.feature.foliageplacer.NoLeavesFoliagePlacer;
import willatendo.fossilslegacy.server.feature.foliageplacer.BranchedFoliagePlacer;
import willatendo.fossilslegacy.server.feature.foliageplacer.LepidodendronFoliagePlacer;
import willatendo.fossilslegacy.server.feature.foliageplacer.SigillariaFoliagePlacer;
import willatendo.fossilslegacy.server.feature.trunkplacer.ArchaeopterisTrunkPlacer;
import willatendo.fossilslegacy.server.feature.trunkplacer.ForkedThickTrunkPlacer;
import willatendo.fossilslegacy.server.feature.trunkplacer.SigillariaTrunkPlacer;
import willatendo.fossilslegacy.server.feature.trunkplacer.StraightBranchingTrunkPlacer;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;
import java.util.OptionalInt;

public final class FAConfiguredFeatures {
    // Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_FOSSIL = create("ore_fossil");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PERMAFROST = create("ore_permafrost");

    // Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARCHAEOPTERIS = create("archaeopteris");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALAMITES = create("calamites");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEPIDODENDRON = create("lepidodendron");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIGILLARIA = create("sigillaria");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_OAK = create("prehistoric_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_BIRCH = create("prehistoric_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_FANCY_OAK = create("prehistoric_fancy_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_SWAMP_OAK = create("prehistoric_swamp_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_SPRUCE = create("prehistoric_spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_PINE = create("prehistoric_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PREHISTORIC_JUNGLE_TREE = create("prehistoric_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEGA_PREHISTORIC_JUNGLE_TREE = create("mega_prehistoric_jungle_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_PREHISTORIC_PLAINS = create("trees_prehistoric_plains");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_PREHISTORIC_FOREST = create("trees_prehistoric_forest");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_PREHISTORIC_WATER = create("trees_prehistoric_water");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_PREHISTORIC_TAIGA = create("trees_prehistoric_taiga");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_PREHISTORIC_JUNGLE = create("trees_prehistoric_jungle");

    public static ResourceKey<ConfiguredFeature<?, ?>> create(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, FAUtils.resource(name));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createArchaeopteris() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(FABlocks.ARCHAEOPTERIS_LOG.get()), new ArchaeopterisTrunkPlacer(10, 4, 0), BlockStateProvider.simple(FABlocks.ARCHAEOPTERIS_LEAVES.get()), new NoLeavesFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createCalamites() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(FABlocks.CALAMITES_LOG.get()), new StraightBranchingTrunkPlacer(9, 3, 6), BlockStateProvider.simple(FABlocks.CALAMITES_LEAVES.get()), new BranchedFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createLepidodendron() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(FABlocks.LEPIDODENDRON_LOG.get()), new ForkedThickTrunkPlacer(8, 2, 0), BlockStateProvider.simple(FABlocks.LEPIDODENDRON_LEAVES.get()), new LepidodendronFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
    }

    private static TreeConfiguration.TreeConfigurationBuilder createSigillaria() {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(FABlocks.SIGILLARIA_LOG.get()), new SigillariaTrunkPlacer(9, 3, 5), BlockStateProvider.simple(FABlocks.SIGILLARIA_LEAVES.get()), new SigillariaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
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

    private static TreeConfiguration.TreeConfigurationBuilder createPrehistoricJungleTree() {
        return createStraightBlobTree(Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, 11, 8, 0, 2);
    }

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block log, Block leaves, int baseHeight, int randHeightA, int randHeightB, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(log), new StraightTrunkPlacer(baseHeight, randHeightA, randHeightB), BlockStateProvider.simple(leaves), new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> bootstrapContext) {
        HolderGetter<PlacedFeature> placedFeature = bootstrapContext.lookup(Registries.PLACED_FEATURE);
        // Ores
        FeatureUtils.register(bootstrapContext, ORE_FOSSIL, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FABlocks.FOSSIL_ORE.get().defaultBlockState()), OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), FABlocks.DEEPSLATE_FOSSIL_ORE.get().defaultBlockState())), 8, 0.0F));
        FeatureUtils.register(bootstrapContext, ORE_PERMAFROST, Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FABlocks.PERMAFROST.get().defaultBlockState())), 8, 0.0F));

        // Trees
        FeatureUtils.register(bootstrapContext, ARCHAEOPTERIS, Feature.TREE, FAConfiguredFeatures.createArchaeopteris().build());
        FeatureUtils.register(bootstrapContext, CALAMITES, Feature.TREE, FAConfiguredFeatures.createCalamites().build());
        FeatureUtils.register(bootstrapContext, LEPIDODENDRON, Feature.TREE, FAConfiguredFeatures.createLepidodendron().build());
        FeatureUtils.register(bootstrapContext, SIGILLARIA, Feature.TREE, FAConfiguredFeatures.createSigillaria().build());

        FeatureUtils.register(bootstrapContext, PREHISTORIC_OAK, Feature.TREE, createPrehistoricOak().build());
        FeatureUtils.register(bootstrapContext, PREHISTORIC_BIRCH, Feature.TREE, createPrehistoricBirch().build());
        FeatureUtils.register(bootstrapContext, PREHISTORIC_FANCY_OAK, Feature.TREE, createPrehistoricFancyOak().build());
        FeatureUtils.register(bootstrapContext, PREHISTORIC_SWAMP_OAK, Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 11, 3, 0, 3).decorators(ImmutableList.of(new LeaveVineDecorator(0.25F))).build());
        FeatureUtils.register(bootstrapContext, PREHISTORIC_SPRUCE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(11, 2, 1), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        FeatureUtils.register(bootstrapContext, PREHISTORIC_PINE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(12, 4, 0), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

        FeatureUtils.register(bootstrapContext, PREHISTORIC_JUNGLE_TREE, Feature.TREE, createPrehistoricJungleTree().decorators(ImmutableList.of(new CocoaDecorator(0.2F), TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).ignoreVines().build());
        FeatureUtils.register(bootstrapContext, MEGA_PREHISTORIC_JUNGLE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.JUNGLE_LOG), new MegaJungleTrunkPlacer(20, 2, 19), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).build());
        FeatureUtils.register(bootstrapContext, TREES_PREHISTORIC_PLAINS, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_FANCY_OAK_CHECKED), 0.33333334F)), placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_OAK_CHECKED)));
        FeatureUtils.register(bootstrapContext, TREES_PREHISTORIC_FOREST, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_BIRCH_CHECKED), 0.2F), new WeightedPlacedFeature(placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_FANCY_OAK_CHECKED), 0.1F)), placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_OAK_CHECKED)));
        FeatureUtils.register(bootstrapContext, TREES_PREHISTORIC_WATER, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_FANCY_OAK_CHECKED), 0.1F)), placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_OAK_CHECKED)));
        FeatureUtils.register(bootstrapContext, TREES_PREHISTORIC_TAIGA, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_PINE_CHECKED), 0.33333334F)), placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_SPRUCE_CHECKED)));
        FeatureUtils.register(bootstrapContext, TREES_PREHISTORIC_JUNGLE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_FANCY_OAK_CHECKED), 0.1F), new WeightedPlacedFeature(placedFeature.getOrThrow(TreePlacements.JUNGLE_BUSH), 0.5F), new WeightedPlacedFeature(placedFeature.getOrThrow(FAPlacedFeatures.MEGA_PREHISTORIC_JUNGLE_TREE_CHECKED), 0.33333334F)), placedFeature.getOrThrow(FAPlacedFeatures.PREHISTORIC_JUNGLE_TREE_CHECKED)));
    }
}
