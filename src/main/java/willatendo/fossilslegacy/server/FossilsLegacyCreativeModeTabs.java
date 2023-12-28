package willatendo.fossilslegacy.server;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.RegistryHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyCreativeModeTabs {
	public static final SimpleRegistry<CreativeModeTab> CREATIVE_MODE_TABS = SimpleRegistry.create(BuiltInRegistries.CREATIVE_MODE_TAB, FossilsLegacyUtils.ID);

	public static final RegistryHolder<CreativeModeTab> FOSSILS_LEGACY = CREATIVE_MODE_TABS.register("fossils_legacy", () -> SimpleUtils.create(FossilsLegacyUtils.ID, FossilsLegacyUtils.ID, () -> FossilsLegacyItems.FOSSIL.get(), (itemDisplayParameters, output) -> {
		SimpleUtils.fillCreativeTab(FossilsLegacyItems.ITEMS, itemDisplayParameters, output);
	}).build());

	public static void init() {
	}
}
