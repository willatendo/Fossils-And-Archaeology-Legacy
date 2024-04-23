package willatendo.fossilslegacy.server.config;

import willatendo.fossilslegacy.server.config.cloth.FossilsLegacyClothConfig;
import willatendo.fossilslegacy.server.config.cloth.FossilsLegacyClothConfigSettings;
import willatendo.fossilslegacy.server.config.forge.FossilsLegacyForgeConfig;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

import static willatendo.fossilslegacy.server.config.FossilsLegacyBaseConfigSettings.*;

public class FabricConfigHelper {

    public static boolean featheredDinosaurs() {
        return isForgeConfigAPILoaded() ? FossilsLegacyForgeConfig.CLIENT_CONFIG.featheredDinosaurs() : isClothConfigLoaded() ? FossilsLegacyClothConfigSettings.featheredDinosaurs() : FEATHERED_DINOSAURUS;
    }

    public static boolean willAnimalsStarve() {
        return isForgeConfigAPILoaded() ? FossilsLegacyForgeConfig.COMMON_CONFIG.willAnimalsStarve() : isClothConfigLoaded() ? FossilsLegacyClothConfigSettings.willAnimalsStarve() : WILL_ANIMALS_STARVE;
    }

    public static boolean willAnimalsBreakBlocks() {
        return isForgeConfigAPILoaded() ? FossilsLegacyForgeConfig.COMMON_CONFIG.willAnimalsBreakBlocks() : isClothConfigLoaded() ? FossilsLegacyClothConfigSettings.willAnimalsBreakBlocks() : WILL_ANIMALS_BREAK_BLOCKS;
    }

    public static boolean willAnimalsGrow() {
        return isForgeConfigAPILoaded() ? FossilsLegacyForgeConfig.COMMON_CONFIG.willAnimalsGrow() : isClothConfigLoaded() ? FossilsLegacyClothConfigSettings.willAnimalsGrow() : WILL_ANIMALS_GROW;
    }

    public static boolean shouldAnuSpawn() {
        return isForgeConfigAPILoaded() ? FossilsLegacyForgeConfig.COMMON_CONFIG.shouldAnuSpawn() : isClothConfigLoaded() ? FossilsLegacyClothConfigSettings.willAnimalsStarve() : SHOULD_ANU_SPAWN;
    }

    public static boolean shouldEnableExperiments() {
        return isForgeConfigAPILoaded() ? FossilsLegacyForgeConfig.SERVER_CONFIG.enableExperiments() : isClothConfigLoaded() ? FossilsLegacyClothConfigSettings.enableExperiments() : ENABLE_EXPERIMENTS;
    }

    public static void loadConfig() {
        if (FabricConfigHelper.isForgeConfigAPILoaded()) {
            FossilsLegacyUtils.LOGGER.info("ForgeAPIConfigPort Detected: Using");
            FossilsLegacyForgeConfig.loadConfig();
        } else if (FabricConfigHelper.isClothConfigLoaded()) {
            FossilsLegacyUtils.LOGGER.info("Cloth Config Detected: Using");
            FossilsLegacyClothConfig.loadConfig();
        } else {
            FossilsLegacyUtils.LOGGER.warn("No Config Mod Detected: Using Base Config Settings");
        }
    }

    public static boolean isForgeConfigAPILoaded() {
        return SimpleUtils.isModLoaded("forgeconfigapiport");
    }

    public static boolean isForgeConfigScreensLoaded() {
        return SimpleUtils.isModLoaded("forgeconfigscreens");
    }

    public static boolean isClothConfigLoaded() {
        return SimpleUtils.isModLoaded("cloth-config");
    }
}
