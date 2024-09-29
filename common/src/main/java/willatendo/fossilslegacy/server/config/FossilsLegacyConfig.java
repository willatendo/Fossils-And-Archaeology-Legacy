package willatendo.fossilslegacy.server.config;

import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.common.config.SimpleConfig;
import willatendo.simplelibrary.server.CommonConfigRegister;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.*;

public class FossilsLegacyConfig {
    private static final SimpleConfig COMMON = CommonConfigRegister.createCommonConfig(FossilsLegacyUtils.ID);

    public static boolean willAnimalsStarve() {
        return COMMON.getValue("animalsStarve");
    }

    public static boolean willAnimalsBreakBlocks() {
        return COMMON.getValue("animalsBreakBlocks");
    }

    public static boolean willAnimalsGrow() {
        return COMMON.getValue("animalsGrow");
    }

    public static void init() {
        COMMON.addBooleanValue("animalsStarve", WILL_ANIMALS_STARVE, "If true, animals will starve");
        COMMON.addBooleanValue("animalsBreakBlocks", WILL_ANIMALS_BREAK_BLOCKS, "If true, some animals will be able to break blocks");
        COMMON.addBooleanValue("animalsGrow", WILL_ANIMALS_GROW, "If true, animals will grow");
    }
}
