package willatendo.fossilslegacy.server.config.forge;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.ENABLE_EXPERIMENTS;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;

public class FossilsLegacyServerConfig {
	private final BooleanValue enableExperiments;

	public FossilsLegacyServerConfig(ModConfigSpec.Builder builder) {
		this.enableExperiments = builder.comment("Enables the experimental items/blocks that were never implemented into the original mod").define("enableExperiments", ENABLE_EXPERIMENTS);
	}

	public boolean enableExperiments() {
		return this.enableExperiments.get();
	}
}
