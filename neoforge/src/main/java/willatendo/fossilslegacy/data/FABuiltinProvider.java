package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
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

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class FABuiltinProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.BIOME, FABiomes::bootstrap).add(Registries.CONFIGURED_FEATURE, FAConfiguredFeatures::bootstrap).add(Registries.DAMAGE_TYPE, FADamageTypes::bootstrap).add(Registries.DIMENSION_TYPE, FADimensionTypes::bootstrap).add(Registries.LEVEL_STEM, FALevelStems::bootstrap).add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, FAMultiNoiseBiomeSourceParameterLists::bootstrap).add(Registries.NOISE_SETTINGS, PrehistoricNoiseGeneratorSettings::bootstrap).add(Registries.PLACED_FEATURE, FAPlacedFeatures::bootstrap).add(Registries.PROCESSOR_LIST, FAProcessorLists::bootstrap).add(Registries.STRUCTURE, FAStructures::bootstrap).add(Registries.STRUCTURE_SET, FAStructureSets::bootstrap).add(Registries.TEMPLATE_POOL, FAPools::bootstrap).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FABiomeModifiers::bootstrap).add(FARegistries.ANALYZER_RESULT, FAAnalyzerResults::bootstrap).add(FARegistries.ANCIENT_AXE_BONUS, FAAncientAxeBonuses::bootstrap).add(FARegistries.MODEL_TYPES, FAModelTypes::bootstrap).add(FARegistries.PATTERN, FAPatterns::bootstrap).add(FARegistries.DECORATION_PLAQUE_TYPE, FADecorationPlaqueTypes::bootstrap).add(FARegistries.DINOPEDIA_ENTRY, FADinopediaEntries::bootstrap).add(FARegistries.DINOPEDIA_TYPE, FADinopediaTypes::bootstrap).add(FARegistries.FEEDER_FOOD, FAFeederFoods::bootstrap).add(FARegistries.FOSSIL_VARIANTS, FAFossilVariants::bootstrap).add(FARegistries.FUEL_ENTRY, FAFuelEntries::bootstrap).add(FARegistries.JEWEL_RECOVERY, FAJewelRecoveries::bootstrap).add(FARegistries.STONE_TABLET_VARIANT, FAStoneTabletVariants::bootstrap).add(FARegistries.TEXTURE, FATextures::bootstrap);

    public FABuiltinProvider(PackOutput packOutput, CompletableFuture<Provider> registries, String modId) {
        super(packOutput, registries, BUILDER, Collections.singleton(modId));
    }
}
