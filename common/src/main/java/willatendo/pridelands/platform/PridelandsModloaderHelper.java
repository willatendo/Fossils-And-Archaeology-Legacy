package willatendo.pridelands.platform;

import willatendo.simplelibrary.server.util.SimpleUtils;

public interface PridelandsModloaderHelper {
    PridelandsModloaderHelper INSTANCE = SimpleUtils.loadModloaderHelper(PridelandsModloaderHelper.class);
}
