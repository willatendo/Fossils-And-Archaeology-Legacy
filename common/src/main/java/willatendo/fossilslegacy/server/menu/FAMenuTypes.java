package willatendo.fossilslegacy.server.menu;

import net.minecraft.world.inventory.MenuType;
import willatendo.fossilslegacy.server.menu.menus.*;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.MenuTypeRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAMenuTypes {
    public static final MenuTypeRegistry MENU_TYPES = SimpleRegistry.createMenuType(FAUtils.ID);

    public static final SimpleHolder<MenuType<ArchaeologyWorkbenchMenu>> ARCHAEOLOGY_WORKBENCH = MENU_TYPES.registerSimple("archaeology_workbench", ArchaeologyWorkbenchMenu::new, ArchaeologyWorkbenchMenu::new);
    public static final SimpleHolder<MenuType<PalaeontologyTableMenu>> PALAEONTOLOGY_TABLE = MENU_TYPES.registerSimple("palaeontology_table", PalaeontologyTableMenu::new);
    public static final SimpleHolder<MenuType<AnalyzerMenu>> ANALYZER = MENU_TYPES.registerSimple("analyzer", AnalyzerMenu::new, AnalyzerMenu::new);
    public static final SimpleHolder<MenuType<CultivatorMenu>> CULTIVATOR = MENU_TYPES.registerSimple("cultivator", CultivatorMenu::new, CultivatorMenu::new);
    public static final SimpleHolder<MenuType<FeederMenu>> FEEDER = MENU_TYPES.registerSimple("feeder", FeederMenu::new, FeederMenu::new);
    public static final SimpleHolder<MenuType<TimeMachineMenu>> TIME_MACHINE = MENU_TYPES.registerSimple("time_machine", TimeMachineMenu::new, TimeMachineMenu::new);
    public static final SimpleHolder<MenuType<DNARecombinatorMenu>> GENE_MODIFICATION = MENU_TYPES.registerSimple("gene_modification", DNARecombinatorMenu::new, DNARecombinatorMenu::new);
    public static final SimpleHolder<MenuType<DNACoderMenu>> DNA_CODER = MENU_TYPES.registerSimple("dna_coder", DNACoderMenu::new, DNACoderMenu::new);
    public static final SimpleHolder<MenuType<DNAHybridizerMenu>> DNA_HYBRIDIZER = MENU_TYPES.registerSimple("dna_hybridizer", DNAHybridizerMenu::new, DNAHybridizerMenu::new);
    public static final SimpleHolder<MenuType<UserManualMenu>> USER_MANUEL = MENU_TYPES.registerSimple("user_manuel", UserManualMenu::new);
}
