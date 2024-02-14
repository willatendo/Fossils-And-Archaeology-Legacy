package willatendo.fossilslegacy.data;

import java.util.List;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.RegistrySetBuilder.PatchedRegistries;
import net.minecraft.core.RegistrySetBuilder.RegistryBootstrap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import willatendo.fossilslegacy.data.loot.FossilsLegacyBlockLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyChestLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyEntityLootTableProvider;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyConfiguredFeatures;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.entity.FossilsLegacyDamageTypes;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureSets;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructures;
import willatendo.simplelibrary.data.DataHandler;
import willatendo.simplelibrary.data.DatapackEntriesProvider;
import willatendo.simplelibrary.data.SimpleAdvancementProvider;

public class FossilsLegacyData implements DataGeneratorEntrypoint {
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, (RegistryBootstrap) FossilsLegacyConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, (RegistryBootstrap) FossilsLegacyPlacedFeatures::bootstrap).add(Registries.DAMAGE_TYPE, (RegistryBootstrap) FossilsLegacyDamageTypes::bootstrap).add(Registries.STRUCTURE, (RegistryBootstrap) FossilsLegacyStructures::bootstrap).add(Registries.STRUCTURE_SET, (RegistryBootstrap) FossilsLegacyStructureSets::bootstrap);

	public static PatchedRegistries createLookup() {
		return BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), VanillaRegistries.createLookup(), null);
	}

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		DataHandler dataHandler = new DataHandler(fabricDataGenerator);

		dataHandler.addProvider(FossilsLegacyItemModelProvider::new);
		dataHandler.addProvider((fabricDataOutput, provider, modId, existingFileHelper) -> new FossilsLegacyBlockStateProvider(fabricDataOutput, existingFileHelper));
		dataHandler.addProvider(FossilsLegacySoundDefinitionsProvider::new);
		dataHandler.addLanguageProvider("en_us", FossilsLegacyLanguageProvider::new);

		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyRecipeProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, provider, modId, existingFileHelper) -> new SimpleAdvancementProvider(fabricDataOutput, provider, List.of(new FossilsLegacyAdvancementProvider())));
		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyBlockLootTableProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyChestLootTableProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, modId) -> new FossilsLegacyEntityLootTableProvider(fabricDataOutput));
		dataHandler.addProvider((fabricDataOutput, provider, modId, existingFileHelper) -> new DatapackEntriesProvider(fabricDataOutput, provider, BUILDER));
		dataHandler.addTagsProvider(FossilsLegacyItemTagProvider::new, FossilsLegacyBlockTagProvider::new);
		dataHandler.addProvider(FossilsLegacyBiomeTagProvider::new);
		dataHandler.addProvider(FossilsLegacyFluidTagProvider::new);
		dataHandler.addProvider(FossilsLegacyEntityTypeTagProvider::new);
		dataHandler.addProvider(FossilsLegacyDamageTypeTagProvider::new);
		dataHandler.addProvider(FossilsLegacyFossilVariantTagProvider::new);
		dataHandler.addProvider(FossilsLegacyStoneTabletVariantTagProvider::new);
	}
}
