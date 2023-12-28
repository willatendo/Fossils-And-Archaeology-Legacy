package willatendo.fossilslegacy.data;

import java.util.List;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import willatendo.fossilslegacy.data.loot.FossilsLegacyBlockLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyChestLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyEntityLootTableProvider;
import willatendo.simplelibrary.data.DataHandler;
import willatendo.simplelibrary.data.SimpleAdvancementProvider;

public class FossilsLegacyData implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		DataHandler dataHandler = new DataHandler(fabricDataGenerator);

		dataHandler.addProvider(FossilsLegacyItemModelProvider::new);
		dataHandler.addProvider(FossilsLegacyBlockStateProvider::new);
		dataHandler.addProvider(FossilsLegacySoundDefinitionsProvider::new);
		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyLanguageProvider(fabricDataOutput, modId, "en_us"));

		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyRecipeProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, provider, modId, existingFileHelper) -> new SimpleAdvancementProvider(fabricDataOutput, provider, List.of(new FossilsLegacyAdvancementProvider())));
		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyBlockLootTableProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyChestLootTableProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyEntityLootTableProvider(fabricDataOutput));
		dataHandler.addProvider(FossilsLegacyConfiguredFeatureProvider::new);
		dataHandler.addProvider(FossilsLegacyPlacedFeatureProvider::new);
		dataHandler.addProvider(FossilsLegacyCustomProviders::new);
		dataHandler.addTagsProvider(FossilsLegacyItemTagProvider::new, FossilsLegacyBlockTagProvider::new);
		dataHandler.addProvider(FossilsLegacyBiomeTagProvider::new);
		dataHandler.addProvider(FossilsLegacyFluidTagProvider::new);
		dataHandler.addProvider(FossilsLegacyEntityTypeTagProvider::new);
	}
}
