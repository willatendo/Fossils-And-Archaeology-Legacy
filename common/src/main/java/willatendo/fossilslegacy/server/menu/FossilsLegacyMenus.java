package willatendo.fossilslegacy.server.menu;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

import java.util.List;

public class FossilsLegacyMenus {
    public static final SimpleRegistry<MenuType<?>> MENU_TYPES = SimpleRegistry.create(Registries.MENU, FossilsLegacyUtils.ID);

    public static final SimpleHolder<MenuType<ArchaeologyWorkbenchMenu>> ARCHAEOLOGY_WORKBENCH = MENU_TYPES.register("archaeology_workbench", () -> FossilsModloaderHelper.INSTANCE.createMenuType(ArchaeologyWorkbenchMenu::new));
    public static final SimpleHolder<MenuType<AnalyzerMenu>> ANALYZER = MENU_TYPES.register("analyzer", () -> FossilsModloaderHelper.INSTANCE.createMenuType(AnalyzerMenu::new));
    public static final SimpleHolder<MenuType<CultivatorMenu>> CULTIVATOR = MENU_TYPES.register("cultivator", () -> FossilsModloaderHelper.INSTANCE.createMenuType(CultivatorMenu::new));
    public static final SimpleHolder<MenuType<FeederMenu>> FEEDER = MENU_TYPES.register("feeder", () -> FossilsModloaderHelper.INSTANCE.createMenuType(FeederMenu::new));
    public static final SimpleHolder<MenuType<TimeMachineMenu>> TIME_MACHINE = MENU_TYPES.register("time_machine", () -> FossilsModloaderHelper.INSTANCE.createMenuType(TimeMachineMenu::new));

    public static void init(List<SimpleRegistry<?>> simpleRegistries) {
        simpleRegistries.add(MENU_TYPES);
    }
}
