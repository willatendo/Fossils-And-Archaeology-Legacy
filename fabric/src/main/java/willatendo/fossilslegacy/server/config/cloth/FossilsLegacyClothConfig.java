package willatendo.fossilslegacy.server.config.cloth;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.client.gui.screens.Screen;

import java.util.function.Supplier;

public class FossilsLegacyClothConfig {
	public static void loadConfig() {
		AutoConfig.register(FossilsLegacyConfig.class, Toml4jConfigSerializer::new);
	}

	public static Supplier<Screen> loadConfigScreen(Screen parent) {
		return AutoConfig.getConfigScreen(FossilsLegacyConfig.class, parent);
	}
}
