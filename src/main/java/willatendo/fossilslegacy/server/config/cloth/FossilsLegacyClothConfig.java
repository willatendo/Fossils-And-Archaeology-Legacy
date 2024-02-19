package willatendo.fossilslegacy.server.config.cloth;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

public class FossilsLegacyClothConfig {
	public static void loadConfig() {
		AutoConfig.register(FossilsLegacyCommonConfig.class, Toml4jConfigSerializer::new);
	}
}
