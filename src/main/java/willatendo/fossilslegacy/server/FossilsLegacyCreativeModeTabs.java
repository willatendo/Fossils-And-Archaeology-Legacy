package willatendo.fossilslegacy.server;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.FabricRegister;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyCreativeModeTabs {
	public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(Registries.CREATIVE_MODE_TAB, FossilsLegacyUtils.ID);

	public static final SimpleHolder<CreativeModeTab> FOSSILS_LEGACY = CREATIVE_MODE_TABS.register("fossils_legacy", () -> SimpleUtils.create(FossilsLegacyUtils.ID, FossilsLegacyUtils.ID, () -> FossilsLegacyItems.FOSSIL.get(), SimpleUtils.fillCreativeTab(FossilsLegacyItems.ITEMS, FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN, FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN, FossilsLegacyItems.BROKEN_IRON_JAVELIN, FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN, FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN, FossilsLegacyItems.BROKEN_STONE_JAVELIN, FossilsLegacyItems.BROKEN_WOODEN_JAVELIN, FossilsLegacyItems.BROKEN_FROZEN_MEAT)).build());

	public static void init() {
		FabricRegister.register(CREATIVE_MODE_TABS);
	}
}
