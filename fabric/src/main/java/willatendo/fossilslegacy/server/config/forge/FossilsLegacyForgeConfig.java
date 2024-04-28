package willatendo.fossilslegacy.server.config.forge;

import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyForgeConfig {
    public static final ModConfigSpec CLIENT_SPEC;
    public static final FossilsLegacyClientConfig CLIENT_CONFIG;

    public static final ModConfigSpec COMMON_SPEC;
    public static final FossilsLegacyCommonConfig COMMON_CONFIG;

    static {
        Pair<FossilsLegacyClientConfig, ModConfigSpec> clientConfig = new ModConfigSpec.Builder().configure(FossilsLegacyClientConfig::new);
        CLIENT_SPEC = clientConfig.getRight();
        CLIENT_CONFIG = clientConfig.getLeft();

        Pair<FossilsLegacyCommonConfig, ModConfigSpec> commonConfig = new ModConfigSpec.Builder().configure(FossilsLegacyCommonConfig::new);
        COMMON_SPEC = commonConfig.getRight();
        COMMON_CONFIG = commonConfig.getLeft();
    }

    public static void loadConfig() {
        NeoForgeConfigRegistry.INSTANCE.register(FossilsLegacyUtils.ID, Type.CLIENT, FossilsLegacyForgeConfig.CLIENT_SPEC);
        NeoForgeConfigRegistry.INSTANCE.register(FossilsLegacyUtils.ID, Type.COMMON, FossilsLegacyForgeConfig.COMMON_SPEC);
    }
}
