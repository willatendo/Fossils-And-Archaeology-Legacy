package willatendo.fossilslegacy.server;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FossilsLegacyUtils.ID);

	public static final RegistryObject<CreativeModeTab> FOSSILS_LEGACY = CREATIVE_MODE_TABS.register("fossils_legacy", () -> CreativeModeTab.builder().title(FossilsLegacyUtils.translation("itemGroup", FossilsLegacyUtils.ID)).icon(() -> FossilsLegacyItems.FOSSIL.get().getDefaultInstance()).displayItems((itemDisplayParameters, output) -> {
		SimpleUtils.fillCreativeTab(FossilsLegacyItems.ITEMS, itemDisplayParameters, output);
	}).build());
}
