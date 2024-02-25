package willatendo.fossilslegacy.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.RegistrySetBuilder.PatchedRegistries;
import net.minecraft.core.RegistrySetBuilder.RegistryBootstrap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import willatendo.fossilsexperiments.flags.FossilsLegacyFeatureFlags;
import willatendo.fossilslegacy.data.loot.FossilsLegacyBlockLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyChestLootTableProvider;
import willatendo.fossilslegacy.data.loot.FossilsLegacyEntityLootTableProvider;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyConfiguredFeatures;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.entity.FossilsLegacyDamageTypes;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureSets;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructures;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.DataHandler;
import willatendo.simplelibrary.data.DataHandler.SimplePack;
import willatendo.simplelibrary.server.flag.FeatureFlagsMetadataSection;

public class FossilsLegacyData implements DataGeneratorEntrypoint {
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, (RegistryBootstrap) FossilsLegacyConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, (RegistryBootstrap) FossilsLegacyPlacedFeatures::bootstrap).add(Registries.DAMAGE_TYPE, (RegistryBootstrap) FossilsLegacyDamageTypes::bootstrap).add(Registries.STRUCTURE, (RegistryBootstrap) FossilsLegacyStructures::bootstrap).add(Registries.STRUCTURE_SET, (RegistryBootstrap) FossilsLegacyStructureSets::bootstrap);

	public static PatchedRegistries createLookup() {
		return BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), VanillaRegistries.createLookup(), null);
	}

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
		dataHandler.addDataPackEntryProvider(BUILDER);
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

		SimplePack fossilsExperimentsGenerator = dataHandler.createBuiltinDataPack(FossilsLegacyUtils.resource("fossil_experiments"));
		fossilsExperimentsGenerator.addProvider(packOutput -> PackMetadataGenerator.forFeaturePack(packOutput, FossilsLegacyUtils.translation("dataPack", "experiments.description")).add(FeatureFlagsMetadataSection.getType(FossilsLegacyFeatureFlags.CODEC), new FeatureFlagsMetadataSection(FeatureFlagSet.of(FossilsLegacyFeatureFlags.FOSSIL_EXPERIMENTS))));
	}
}
