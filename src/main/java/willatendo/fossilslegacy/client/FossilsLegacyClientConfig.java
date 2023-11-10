package willatendo.fossilslegacy.client;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class FossilsLegacyClientConfig {
	private final BooleanValue useLegacyModels;

	public FossilsLegacyClientConfig(ForgeConfigSpec.Builder builder) {
		this.useLegacyModels = builder.comment("If true, legacy models will be used instead of the improved/revamped ones").define("useLegacyModels", false);
	}

	public BooleanValue useLegacyModels() {
		return this.useLegacyModels;
	}
}
