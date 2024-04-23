package willatendo.fossilslegacy.server.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.data.loading.DatagenModLoader;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.ENABLE_EXPERIMENTS;

public class FossilsLegacyServerConfig {
    private final ModConfigSpec.BooleanValue enableExperiments;

    public FossilsLegacyServerConfig(ModConfigSpec.Builder builder) {
        this.enableExperiments = builder.comment("Enables the experimental items/blocks that were never implemented into the original mod").define("enableExperiments", ENABLE_EXPERIMENTS);
    }

    public boolean shouldEnableExperiments() {
        return DatagenModLoader.isRunningDataGen() ? true : this.enableExperiments.get();
    }
}
