package willatendo.fossilslegacy.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import willatendo.fossilslegacy.server.ConfigHelper;
import willatendo.fossilslegacy.server.config.cloth.FossilsLegacyClothConfig;

public class FossilsLegacyModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ConfigHelper.isForgeConfigAPILoaded() ? screen -> null : ConfigHelper.isClothConfigLoaded() ? parent -> FossilsLegacyClothConfig.loadConfigScreen(parent).get() : screen -> null;
    }
}
