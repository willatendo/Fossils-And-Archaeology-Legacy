package willatendo.fossilslegacy.experiments.server.menu;

import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.simplelibrary.server.registry.SimpleHolder;

public class FossilsExperimentsMenus {
	public static final SimpleHolder<MenuType<TimeMachineMenu>> TIME_MACHINE = FossilsLegacyMenus.MENU_TYPES.register("time_machine", () -> FossilsModloaderHelper.INSTANCE.createMenuType(TimeMachineMenu::new));

	public static void init() {
	}
}
