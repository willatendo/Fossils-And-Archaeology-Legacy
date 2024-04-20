package willatendo.fossilslegacy.server.config;

import net.minecraftforge.common.ForgeConfigSpec;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.ENABLE_EXPERIMENTS;

public class FossilsLegacyServerConfig {
    private final ForgeConfigSpec.BooleanValue enableExperiments;

    public FossilsLegacyServerConfig(ForgeConfigSpec.Builder builder) {
        this.enableExperiments = builder.comment("Enables the experimental items/blocks that were never implemented into the original mod").define("enableExperiments", ENABLE_EXPERIMENTS);
    }

    public boolean shouldEnableExperiments() {
        return this.enableExperiments.get();
    }
}
