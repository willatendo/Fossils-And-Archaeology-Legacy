package willatendo.fossilslegacy.server.biomes;

import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_FOSSIL = create("ore_fossil");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_PERMAFROST = create("ore_permafrost");

	public static ResourceKey<ConfiguredFeature<?, ?>> create(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, FossilsLegacyUtils.resource(name));
	}

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> bootstapContext) {
		bootstapContext.register(ORE_FOSSIL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.FOSSIL_ORE.get().defaultBlockState())), 8, 0.0F)));
		bootstapContext.register(ORE_PERMAFROST, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), FossilsLegacyBlocks.PERMAFROST.get().defaultBlockState())), 8, 0.0F)));
	}
}
