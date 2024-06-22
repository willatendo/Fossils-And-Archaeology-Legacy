package willatendo.fossilslegacy.server.config.cloth;

import me.shedaniel.autoconfig.AutoConfig;

public class FossilsLegacyClothConfigSettings {
    public static final FossilsLegacyConfig CONFIG = AutoConfig.getConfigHolder(FossilsLegacyConfig.class).getConfig();

    public static boolean featheredDinosaurs() {
        return CONFIG.client.featheredDinosaurs();
    }

    public static boolean willAnimalsStarve() {
        return CONFIG.common.willAnimalsStarve();
    }

    public static boolean willAnimalsBreakBlocks() {
        return CONFIG.common.willAnimalsBreakBlocks();
    }

    public static boolean willAnimalsGrow() {
        return CONFIG.common.willAnimalsGrow();
    }
}
