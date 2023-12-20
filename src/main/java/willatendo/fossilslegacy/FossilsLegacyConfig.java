package willatendo.fossilslegacy;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import willatendo.fossilslegacy.server.FossilsLegacyCommonConfig;

public class FossilsLegacyConfig {
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final FossilsLegacyCommonConfig COMMON_CONFIG;

	static {
		final Pair<FossilsLegacyCommonConfig, ForgeConfigSpec> commonConfig = new ForgeConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
		COMMON_SPEC = commonConfig.getRight();
		COMMON_CONFIG = commonConfig.getLeft();
	}
}
