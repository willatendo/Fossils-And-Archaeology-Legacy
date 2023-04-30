package fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, modid = FossilsLegacyUtils.ID)
public class DataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		PackOutput packOutput = dataGenerator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

		// Client
		dataGenerator.addProvider(event.includeClient(), new FossilsLegacySoundDefinitionsProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
		dataGenerator.addProvider(event.includeClient(), new FossilsLegacyLanguageProvider(packOutput, FossilsLegacyUtils.ID, "en_us"));
		dataGenerator.addProvider(event.includeClient(), new FossilsLegacyBlockStateProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));
		dataGenerator.addProvider(event.includeClient(), new FossilsLegacyItemModelProvider(packOutput, FossilsLegacyUtils.ID, existingFileHelper));

		// Server
		FossilsLegacyBlockTagProvider fossilsLegacyBlockTagProvider = new FossilsLegacyBlockTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper);
		dataGenerator.addProvider(event.includeServer(), new FossilsLegacyItemTagProvider(packOutput, provider, fossilsLegacyBlockTagProvider, FossilsLegacyUtils.ID, existingFileHelper));
		dataGenerator.addProvider(event.includeServer(), fossilsLegacyBlockTagProvider);
		dataGenerator.addProvider(event.includeServer(), new FossilsLegacyFluidTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
		dataGenerator.addProvider(event.includeServer(), new FossilsLegacyBiomeTagProvider(packOutput, provider, FossilsLegacyUtils.ID, existingFileHelper));
		dataGenerator.addProvider(event.includeServer(), new FossilsLegacyRecipeProvider(packOutput));
		dataGenerator.addProvider(event.includeServer(), new FossilsLegacyLootProvider(packOutput));
		dataGenerator.addProvider(event.includeServer(), new FossilsLegacyCustomProviders(packOutput, FossilsLegacyUtils.ID));
		dataGenerator.addProvider(event.includeServer(), new FossilsLegacyAdvancementProvider(packOutput, provider, existingFileHelper));
	}
}
