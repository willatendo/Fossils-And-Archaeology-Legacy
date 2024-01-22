package willatendo.fossilslegacy.server.biomes;

import java.util.List;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyPlacedFeatures {
	public static final ResourceKey<PlacedFeature> ORE_FOSSIL = create("ore_fossil");
	public static final ResourceKey<PlacedFeature> ORE_PERMAFROST = create("ore_permafrost");

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
		bootstapContext.register(ORE_FOSSIL, new PlacedFeature(configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.ORE_FOSSIL), FossilsLegacyPlacedFeatures.commonOrePlacement(25, HeightRangePlacement.triangle(VerticalAnchor.absolute(10), VerticalAnchor.absolute(128)))));
		bootstapContext.register(ORE_PERMAFROST, new PlacedFeature(configuredFeatures.getOrThrow(FossilsLegacyConfiguredFeatures.ORE_PERMAFROST), FossilsLegacyPlacedFeatures.commonOrePlacement(25, HeightRangePlacement.triangle(VerticalAnchor.absolute(25), VerticalAnchor.absolute(256)))));
	}
}
