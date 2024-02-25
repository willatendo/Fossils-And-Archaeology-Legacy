package willatendo.fossilsexperiments.flags;

import com.mojang.serialization.Codec;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagRegistry;
import net.minecraft.world.flag.FeatureFlagSet;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyFeatureFlags {
	public static final FeatureFlag FOSSIL_EXPERIMENTS;
	public static final FeatureFlagRegistry REGISTRY;
	public static final Codec<FeatureFlagSet> CODEC;

	static {
		FeatureFlagRegistry.Builder builder = new FeatureFlagRegistry.Builder(FossilsLegacyUtils.ID);
		FOSSIL_EXPERIMENTS = builder.create(FossilsLegacyUtils.resource("fossil_experiments"));
		REGISTRY = builder.build();
		CODEC = REGISTRY.codec();
	}

	public static void init() {
	}
}
