package willatendo.fossilslegacy.server;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.creativemodetab.CreativeModeTabUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyCreativeModeTabs {
	public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(Registries.CREATIVE_MODE_TAB, FossilsLegacyUtils.ID);

	public static final SimpleHolder<CreativeModeTab> FOSSILS_LEGACY = CREATIVE_MODE_TABS.register("fossils_legacy", () -> CreativeModeTabUtils.create(FossilsLegacyUtils.ID, FossilsLegacyUtils.ID, () -> FossilsLegacyItems.FOSSIL.get(), CreativeModeTabUtils.fillCreativeTab(FossilsLegacyItems.ITEMS)).build());

	public static void init() {
		CREATIVE_MODE_TABS.register();
	}
}
