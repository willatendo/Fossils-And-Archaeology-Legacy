package willatendo.fossilslegacy.data;

import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.data.advancement.LegacyAdvancementGenerator;
import willatendo.fossilslegacy.data.legacy.FALegacyModelProvider;
import willatendo.fossilslegacy.data.loot.*;
import willatendo.fossilslegacy.data.model.FABlockModelGenerator;
import willatendo.fossilslegacy.data.model.FAItemModelGenerator;
import willatendo.fossilslegacy.data.tag.*;
import willatendo.fossilslegacy.server.analyzer_result.FAAnalyzerResults;
import willatendo.fossilslegacy.server.ancient_axe_bonus.FAAncientAxeBonuses;
import willatendo.fossilslegacy.server.biome.FABiomes;
import willatendo.fossilslegacy.server.biome.FAMultiNoiseBiomeSourceParameterLists;
import willatendo.fossilslegacy.server.decoration_plaque_type.FADecorationPlaqueTypes;
import willatendo.fossilslegacy.server.dimension.FADimensionTypes;
import willatendo.fossilslegacy.server.dimension.FALevelStems;
import willatendo.fossilslegacy.server.dinopedia_entry.FADinopediaEntries;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FADamageTypes;
import willatendo.fossilslegacy.server.event.ModEvents;
import willatendo.fossilslegacy.server.feature.FAConfiguredFeatures;
import willatendo.fossilslegacy.server.feature.FAPlacedFeatures;
import willatendo.fossilslegacy.server.feeder_food.FAFeederFoods;
import willatendo.fossilslegacy.server.fossil_variant.FAFossilVariants;
import willatendo.fossilslegacy.server.fuel.FAFuelEntries;
import willatendo.fossilslegacy.server.jewel_recovery.FAJewelRecoveries;
import willatendo.fossilslegacy.server.level.prehistoric.PrehistoricNoiseGeneratorSettings;
import willatendo.fossilslegacy.server.model_type.FAModelTypes;
import willatendo.fossilslegacy.server.pattern.FAPatterns;
import willatendo.fossilslegacy.server.pattern.FATextures;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.FAStoneTabletVariants;
import willatendo.fossilslegacy.server.structure.FAPools;
import willatendo.fossilslegacy.server.structure.FAProcessorLists;
import willatendo.fossilslegacy.server.structure.FAStructureSets;
import willatendo.fossilslegacy.server.structure.FAStructures;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.ResourcePackGenerator;
import willatendo.simplelibrary.data.SimpleDataMapProvider;
import willatendo.simplelibrary.data.SimpleLootTableProvider;
import willatendo.simplelibrary.data.SimpleModelProvider;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = FAUtils.ID)
public class FossilsLegacyData {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.BIOME, FABiomes::bootstrap).add(Registries.CONFIGURED_FEATURE, FAConfiguredFeatures::bootstrap).add(Registries.DAMAGE_TYPE, FADamageTypes::bootstrap).add(Registries.DIMENSION_TYPE, FADimensionTypes::bootstrap).add(Registries.LEVEL_STEM, FALevelStems::bootstrap).add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, FAMultiNoiseBiomeSourceParameterLists::bootstrap).add(Registries.NOISE_SETTINGS, PrehistoricNoiseGeneratorSettings::bootstrap).add(Registries.PLACED_FEATURE, FAPlacedFeatures::bootstrap).add(Registries.PROCESSOR_LIST, FAProcessorLists::bootstrap).add(Registries.STRUCTURE, FAStructures::bootstrap).add(Registries.STRUCTURE_SET, FAStructureSets::bootstrap).add(Registries.TEMPLATE_POOL, FAPools::bootstrap).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FABiomeModifiers::bootstrap).add(FARegistries.ANALYZER_RESULT, FAAnalyzerResults::bootstrap).add(FARegistries.ANCIENT_AXE_BONUS, FAAncientAxeBonuses::bootstrap).add(FARegistries.MODEL_TYPES, FAModelTypes::bootstrap).add(FARegistries.PATTERN, FAPatterns::bootstrap).add(FARegistries.DECORATION_PLAQUE_TYPE, FADecorationPlaqueTypes::bootstrap).add(FARegistries.DINOPEDIA_ENTRY, FADinopediaEntries::bootstrap).add(FARegistries.DINOPEDIA_TYPE, FADinopediaTypes::bootstrap).add(FARegistries.FEEDER_FOOD, FAFeederFoods::bootstrap).add(FARegistries.FOSSIL_VARIANTS, FAFossilVariants::bootstrap).add(FARegistries.FUEL_ENTRY, FAFuelEntries::bootstrap).add(FARegistries.JEWEL_RECOVERY, FAJewelRecoveries::bootstrap).add(FARegistries.STONE_TABLET_VARIANT, FAStoneTabletVariants::bootstrap).add(FARegistries.TEXTURE, FATextures::bootstrap);

    @SubscribeEvent
    public static void gatherDataEvent(GatherDataEvent.Client event) {
        ModEvents.setupDataMaps();

        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        event.addProvider(new SimpleModelProvider(FAItemModelGenerator::new, FABlockModelGenerator::new, packOutput, FAUtils.ID));
        event.addProvider(new FASoundDefinitionsProvider(packOutput, FAUtils.ID));
        event.addProvider(new FALanguageProvider(packOutput, FAUtils.ID, "en_us"));
        event.addProvider(new FAEntityModelProvider(packOutput, FAUtils.ID));
        event.addProvider(new FAAnimationProvider(packOutput, FAUtils.ID));
        event.addProvider(new FAEquipmentAssetProvider(packOutput));

        event.createDatapackRegistryObjects(BUILDER);

        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        event.addProvider(new FARecipeProvider.Runner(packOutput, registries));
        event.addProvider(new AdvancementProvider(packOutput, registries, List.of(new LegacyAdvancementGenerator())));
        event.addProvider(new SimpleLootTableProvider(packOutput, registries, new LootTableProvider.SubProviderEntry(FABlockLootSubProvider::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(FAEntityLootSubProvider::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(FAChestLootSubProvider::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(FAGiftLootSubProvider::new, LootContextParamSets.GIFT), new LootTableProvider.SubProviderEntry(FAArchaeologyLootSubProvider::new, LootContextParamSets.ARCHAEOLOGY), new LootTableProvider.SubProviderEntry(FAShearingLootSubProvider::new, LootContextParamSets.SHEARING)));
        event.addProvider(new SimpleDataMapProvider(packOutput, registries, ModEvents.NEOFORGE_COMPOSTABLES_MODIFICATION, ModEvents.NEOFORGE_HERO_OF_THE_VILLAGE_GIFT_MODIFICATION, ModEvents.NEOFORGE_OXIDATION_MODIFICATION, ModEvents.NEOFORGE_WAXABLE_MODIFICATION));
        FABlockTagProvider FABlockTagProvider = new FABlockTagProvider(packOutput, registries, FAUtils.ID);
        event.addProvider(FABlockTagProvider);
        event.addProvider(new FAItemTagProvider(packOutput, registries, FABlockTagProvider.contentsGetter(), FAUtils.ID));
        event.addProvider(new FABiomeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAFluidTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAEntityTypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FADamageTypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAFossilVariantTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAStoneTabletVariantTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FADecorationPlaqueTypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAModelTypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAPOITypeTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAStructureTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAAnalyzerResultTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAFuelEntryTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new FAPatternTagProvider(packOutput, registries, FAUtils.ID));
        event.addProvider(new PackMetadataGenerator(packOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FAUtils.translation("resourcePack", "description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));

        ResourceLocation legacyPack = FAUtils.resource("fa_legacy_textures");
        ResourcePackGenerator legacyPackGenerator = new ResourcePackGenerator(dataGenerator, true, legacyPack.toString(), new PackOutput(dataGenerator.getPackOutput().getOutputFolder().resolve("resourcepacks").resolve(legacyPack.getPath())));
        legacyPackGenerator.addProvider(legacyPackOutput -> new PackMetadataGenerator(legacyPackOutput).add(PackMetadataSection.TYPE, new PackMetadataSection(FAUtils.translation("resourcePack", "fa_legacy_textures.description"), DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES), Optional.empty())));
        legacyPackGenerator.addProvider(legacyPackOutput -> new FALegacyModelProvider(legacyPackOutput, FAUtils.ID));
    }
}
