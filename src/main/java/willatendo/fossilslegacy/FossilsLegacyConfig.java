package willatendo.fossilslegacy;

import org.apache.commons.lang3.tuple.Pair;

import net.neoforged.neoforge.common.ModConfigSpec;
import willatendo.fossilslegacy.server.FossilsLegacyCommonConfig;

public class FossilsLegacyConfig {
	public static final ModConfigSpec COMMON_SPEC;
	public static final FossilsLegacyCommonConfig COMMON_CONFIG;

	static {
		Pair<FossilsLegacyCommonConfig, ModConfigSpec> commonConfig = new ModConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
		COMMON_SPEC = commonConfig.getRight();
		COMMON_CONFIG = commonConfig.getLeft();
	}
}
