package willatendo.fossilslegacy.server.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class FossilsLegacyConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final FossilsLegacyCommonConfig COMMON_CONFIG;

    static {
        Pair<FossilsLegacyCommonConfig, ForgeConfigSpec> commonConfig = new ForgeConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
        COMMON_SPEC = commonConfig.getRight();
        COMMON_CONFIG = commonConfig.getLeft();
    }
}
