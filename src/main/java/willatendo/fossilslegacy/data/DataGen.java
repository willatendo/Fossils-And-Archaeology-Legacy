package willatendo.fossilslegacy.data;

import java.util.List;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.DataHelper;

@EventBusSubscriber(bus = Bus.MOD, modid = FossilsLegacyUtils.ID)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataHelper.collectAllData(FossilsLegacyUtils.ID, event, FossilsLegacyLanguageProvider::new).addSoundDefinitionProvider(FossilsLegacySoundDefinitionsProvider::new).addBlockStateProvider(FossilsLegacyBlockStateProvider::new).addItemModelProvider(FossilsLegacyItemModelProvider::new).addBasicTagProviders(FossilsLegacyItemTagProvider::new, FossilsLegacyBlockTagProvider::new).addFluidTagProvider(FossilsLegacyFluidTagProvider::new).addBiomeTagProvider(FossilsLegacyBiomeTagProvider::new).addRecipeProvider(FossilsLegacyRecipeProvider::new).addLootProvider(FossilsLegacyLootProvider::new).addAdvancementProvider(List.of(new FossilsLegacyAdvancementProvider())).addGeneric(FossilsLegacyCustomProviders::new).addGeneric(FossilsLegacyPlacedFeatureProvider::new).addGeneric(FossilsLegacyConfiguredFeatureProvider::new).addTagGeneric((packOutput, provider, id) -> new FossilsLegacyEntityTypeTagProvider(packOutput, provider, id, event.getExistingFileHelper())).addGeneric(FossilsLegacyBiomeModiferProvider::new);
	}
}
