package willatendo.fossilslegacy.server.menu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyMenus {
	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, FossilsLegacyUtils.ID);

	public static final RegistryObject<MenuType<ArchaeologyWorkbenchMenu>> ARCHAEOLOGY_WORKBENCH = MENU_TYPES.register("archaeology_workbench", () -> IForgeMenuType.create(ArchaeologyWorkbenchMenu::new));
	public static final RegistryObject<MenuType<AnalyzerMenu>> ANALYZER = MENU_TYPES.register("analyzer", () -> IForgeMenuType.create(AnalyzerMenu::new));
	public static final RegistryObject<MenuType<CultivatorMenu>> CULTIVATOR = MENU_TYPES.register("cultivator", () -> IForgeMenuType.create(CultivatorMenu::new));
	public static final RegistryObject<MenuType<FeederMenu>> FEEDER = MENU_TYPES.register("feeder", () -> IForgeMenuType.create(FeederMenu::new));
}
