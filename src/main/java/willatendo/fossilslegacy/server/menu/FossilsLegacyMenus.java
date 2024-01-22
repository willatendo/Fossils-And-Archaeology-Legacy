package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyMenus {
	public static final SimpleRegistry<MenuType<?>> MENU_TYPES = SimpleRegistry.create(Registries.MENU, FossilsLegacyUtils.ID);

	public static final SimpleHolder<MenuType<ArchaeologyWorkbenchMenu>> ARCHAEOLOGY_WORKBENCH = MENU_TYPES.register("archaeology_workbench", () -> SimpleUtils.createMenuType(ArchaeologyWorkbenchMenu::new));
	public static final SimpleHolder<MenuType<AnalyzerMenu>> ANALYZER = MENU_TYPES.register("analyzer", () -> SimpleUtils.createMenuType(AnalyzerMenu::new));
	public static final SimpleHolder<MenuType<CultivatorMenu>> CULTIVATOR = MENU_TYPES.register("cultivator", () -> SimpleUtils.createMenuType(CultivatorMenu::new));
	public static final SimpleHolder<MenuType<FeederMenu>> FEEDER = MENU_TYPES.register("feeder", () -> SimpleUtils.createMenuType(FeederMenu::new));

	public static void init() {
		MENU_TYPES.register();
	}
}
