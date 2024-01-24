package willatendo.fossilslegacy;

import org.apache.commons.lang3.tuple.Pair;

import willatendo.fossilslegacy.server.FossilsLegacyCommonConfig;
import willatendo.simplelibrary.config.ModConfigSpec;

public class FossilsLegacyConfig {
	public static final ModConfigSpec COMMON_SPEC;
	public static final FossilsLegacyCommonConfig COMMON_CONFIG;

	static {
		final Pair<FossilsLegacyCommonConfig, ModConfigSpec> commonConfig = new ModConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
		COMMON_SPEC = commonConfig.getRight();
		COMMON_CONFIG = commonConfig.getLeft();
	}
}
