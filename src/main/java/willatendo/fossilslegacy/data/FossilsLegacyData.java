package willatendo.fossilslegacy.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.metadata.PackMetadataGenerator;
import willatendo.fossilslegacy.data.loot.FossilsLegacyBlockLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyChestLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyEntityLootTableProvider;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.DataHandler;
import willatendo.simplelibrary.data.DataHandler.SimplePack;

public class FossilsLegacyData implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		DataHandler dataHandler = new DataHandler(fabricDataGenerator);

		dataHandler.addProvider(FossilsLegacyItemModelProvider::new);
		dataHandler.addProvider(FossilsLegacyBlockStateProvider::new);
		dataHandler.addProvider(FossilsLegacySoundDefinitionsProvider::new);
		dataHandler.addLanguageProvider("en_us", FossilsLegacyLanguageProvider::new);

		dataHandler.addProvider(FossilsLegacyRecipeProvider::new);
		dataHandler.generateAdvancements(new FossilsLegacyAdvancementProvider());
		// Loot
		dataHandler.addProvider(FossilsLegacyBlockLootTableProvider::new);
		dataHandler.addProvider(FossilsLegacyChestLootTableProvider::new);
		dataHandler.addProvider(FossilsLegacyEntityLootTableProvider::new);
		// Data-Driven
		dataHandler.addProvider((a, b, c, d) -> new FossilsLegacyBuiltinProvider(a, b));
		dataHandler.addTagsProvider(FossilsLegacyItemTagProvider::new, FossilsLegacyBlockTagProvider::new);
		dataHandler.addProvider(FossilsLegacyBiomeTagProvider::new);
		dataHandler.addProvider(FossilsLegacyFluidTagProvider::new);
		dataHandler.addProvider(FossilsLegacyEntityTypeTagProvider::new);
		dataHandler.addProvider(FossilsLegacyDamageTypeTagProvider::new);
		dataHandler.addProvider(FossilsLegacyFossilVariantTagProvider::new);
		dataHandler.addProvider(FossilsLegacyStoneTabletVariantTagProvider::new);
		dataHandler.addProvider(packOutput -> PackMetadataGenerator.forFeaturePack(packOutput, FossilsLegacyUtils.translation("dataPack", "description")));

		SimplePack legacyPackGenerator = dataHandler.createBuiltinResourcePack(FossilsLegacyUtils.resource("fa_legacy_textures"));
		legacyPackGenerator.addProvider(packOutput -> PackMetadataGenerator.forFeaturePack(packOutput, FossilsLegacyUtils.translation("dataPack", "fa_legacy_textures.description")));
	}
}
