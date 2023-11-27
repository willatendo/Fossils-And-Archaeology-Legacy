package willatendo.fossilslegacy.client.render;

import willatendo.fossilslegacy.FossilsLegacyConfig;

public interface LegacyModels {
	default boolean useLegacyModels() {
		return FossilsLegacyConfig.CLIENT_CONFIG.useLegacyModels();
	}
}
