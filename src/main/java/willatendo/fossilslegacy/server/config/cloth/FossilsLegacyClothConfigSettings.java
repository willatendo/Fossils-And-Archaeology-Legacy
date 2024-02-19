package willatendo.fossilslegacy.server.config.cloth;

import me.shedaniel.autoconfig.AutoConfig;

public class FossilsLegacyClothConfigSettings {
	public static final FossilsLegacyCommonConfig CONFIG = AutoConfig.getConfigHolder(FossilsLegacyCommonConfig.class).getConfig();

	public static boolean willAnimalsStarve() {
		return CONFIG.common.willAnimalsStarve();
	}

	public static boolean willAnimalsBreakBlocks() {
		return CONFIG.common.willAnimalsBreakBlocks();
	}

	public static boolean willAnimalsGrow() {
		return CONFIG.common.willAnimalsGrow();
	}

	public static boolean shouldAnuSpawn() {
		return CONFIG.common.shouldAnuSpawn();
	}
}
