package willatendo.fossilslegacy.server.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class FossilsLegacyConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final FossilsLegacyCommonConfig COMMON_CONFIG;

    public static final ForgeConfigSpec SERVER_SPEC;
    public static final FossilsLegacyServerConfig SERVER_CONFIG;

    static {
        Pair<FossilsLegacyCommonConfig, ForgeConfigSpec> commonConfig = new ForgeConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
        COMMON_SPEC = commonConfig.getRight();
        COMMON_CONFIG = commonConfig.getLeft();

        Pair<FossilsLegacyServerConfig, ForgeConfigSpec> serverConfig = new ForgeConfigSpec.Builder().configure(FossilsLegacyServerConfig::new);
        SERVER_SPEC = serverConfig.getRight();
        SERVER_CONFIG = serverConfig.getLeft();
    }
}
