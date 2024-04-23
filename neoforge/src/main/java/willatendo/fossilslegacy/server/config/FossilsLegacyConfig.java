package willatendo.fossilslegacy.server.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class FossilsLegacyConfig {
    public static final ModConfigSpec COMMON_SPEC;
    public static final FossilsLegacyCommonConfig COMMON_CONFIG;

    public static final ModConfigSpec SERVER_SPEC;
    public static final FossilsLegacyServerConfig SERVER_CONFIG;

    static {
        Pair<FossilsLegacyCommonConfig, ModConfigSpec> commonConfig = new ModConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
        COMMON_SPEC = commonConfig.getRight();
        COMMON_CONFIG = commonConfig.getLeft();

        Pair<FossilsLegacyServerConfig, ModConfigSpec> serverConfig = new ModConfigSpec.Builder().configure(FossilsLegacyServerConfig::new);
        SERVER_SPEC = serverConfig.getRight();
        SERVER_CONFIG = serverConfig.getLeft();
    }
}