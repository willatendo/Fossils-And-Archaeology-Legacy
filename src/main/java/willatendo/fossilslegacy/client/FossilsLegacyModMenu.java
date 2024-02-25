package willatendo.fossilslegacy.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import willatendo.fossilslegacy.server.ConfigHelper;
import willatendo.fossilslegacy.server.config.cloth.FossilsLegacyClothConfig;

public class FossilsLegacyModMenu implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return ConfigHelper.isForgeConfigAPILoaded() ? ModMenuApi.super.getModConfigScreenFactory() : ConfigHelper.isClothConfigLoaded() ? parent -> {
			return FossilsLegacyClothConfig.loadConfigScreen(parent).get();
		} : ModMenuApi.super.getModConfigScreenFactory();
	}
}
