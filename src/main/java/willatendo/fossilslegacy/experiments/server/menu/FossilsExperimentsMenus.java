package willatendo.fossilslegacy.experiments.server.menu;

import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.server.menu.FossilsLegacyMenus;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.util.FabricUtils;

public class FossilsExperimentsMenus {
	public static final SimpleHolder<MenuType<TimeMachineMenu>> TIME_MACHINE = FossilsLegacyMenus.MENU_TYPES.register("time_machine", () -> FabricUtils.createMenuType(TimeMachineMenu::new));

	public static void init() {
	}
}
