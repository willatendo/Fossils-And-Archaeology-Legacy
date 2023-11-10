package willatendo.fossilslegacy;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import willatendo.fossilslegacy.client.FossilsLegacyClientConfig;
import willatendo.fossilslegacy.server.FossilsLegacyCommonConfig;

public class FossilsLegacyConfig {
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final FossilsLegacyCommonConfig COMMON_CONFIG;

	public static final ForgeConfigSpec CLIENT_SPEC;
	public static final FossilsLegacyClientConfig CLIENT_CONFIG;

	static {
		final Pair<FossilsLegacyCommonConfig, ForgeConfigSpec> commonConfig = new ForgeConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
		COMMON_SPEC = commonConfig.getRight();
		COMMON_CONFIG = commonConfig.getLeft();

		final Pair<FossilsLegacyClientConfig, ForgeConfigSpec> clientConfig = new ForgeConfigSpec.Builder().configure(FossilsLegacyClientConfig::new);
		CLIENT_SPEC = clientConfig.getRight();
		CLIENT_CONFIG = clientConfig.getLeft();
	}
}
