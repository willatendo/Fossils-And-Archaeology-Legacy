package fossilslegacy.data;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.simplelibrary.data.DataHelper;

@EventBusSubscriber(bus = Bus.MOD, modid = FossilsLegacyUtils.ID)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataHelper.collectAllData(FossilsLegacyUtils.ID, event, FossilsLegacyLanguageProvider::new).addSoundDefinitionProvider(FossilsLegacySoundDefinitionsProvider::new).addBlockStateProvider(FossilsLegacyBlockStateProvider::new).addItemModelProvider(FossilsLegacyItemModelProvider::new).addBasicTagProviders(FossilsLegacyItemTagProvider::new, FossilsLegacyBlockTagProvider::new).addFluidTagProvider(FossilsLegacyFluidTagProvider::new).addBiomeTagProvider(FossilsLegacyBiomeTagProvider::new).addRecipeProvider(FossilsLegacyRecipeProvider::new).addLootProvider(FossilsLegacyLootProvider::new).addGeneric(FossilsLegacyCustomProviders::new);
	}
}
