package willatendo.fossilslegacy.server;

import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class ConfigHelper {
    public static boolean willAnimalsStarve() {
        return FossilsModloaderHelper.INSTANCE.willAnimalsStarve();
    }

    public static boolean willAnimalsBreakBlocks() {
        return FossilsModloaderHelper.INSTANCE.willAnimalsBreakBlocks();
    }

    public static boolean willAnimalsGrow() {
        return FossilsModloaderHelper.INSTANCE.willAnimalsGrow();
    }

    public static boolean isForgeConfigAPILoaded() {
        return SimpleUtils.isModLoaded("forgeconfigapiport");
    }

    public static boolean isClothConfigLoaded() {
        return SimpleUtils.isModLoaded("cloth-config");
    }
}
