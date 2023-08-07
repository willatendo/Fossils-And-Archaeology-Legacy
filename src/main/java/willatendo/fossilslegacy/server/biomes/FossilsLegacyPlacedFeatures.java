package willatendo.fossilslegacy.server.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyPlacedFeatures {
	public static final ResourceKey<PlacedFeature> ORE_FOSSIL = create("ore_fossil");
	public static final ResourceKey<PlacedFeature> ORE_PERMAFROST = create("ore_permafrost");

	public static ResourceKey<PlacedFeature> create(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, FossilsLegacyUtils.resource(name));
	}
}
