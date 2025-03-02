package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.server.analyzer_result.FAAnalyzerResults;
import willatendo.fossilslegacy.server.ancient_axe_bonus.FAAncientAxeBonuses;
import willatendo.fossilslegacy.server.biome.FABiomes;
import willatendo.fossilslegacy.server.biome.FAMultiNoiseBiomeSourceParameterLists;
import willatendo.fossilslegacy.server.model_type.FAModelTypes;
import willatendo.fossilslegacy.server.dimension.FADimensionTypes;
import willatendo.fossilslegacy.server.dimension.FALevelStems;
import willatendo.fossilslegacy.server.dinopedia_entry.FADinopediaEntries;
import willatendo.fossilslegacy.server.dinopedia_type.FADinopediaTypes;
import willatendo.fossilslegacy.server.entity.FADamageTypes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.feature.FAConfiguredFeatures;
import willatendo.fossilslegacy.server.feature.FAPlacedFeatures;
import willatendo.fossilslegacy.server.feeder_food.FAFeederFoods;
import willatendo.fossilslegacy.server.fossil_variant.FAFossilVariants;
import willatendo.fossilslegacy.server.fuel.FAFuelEntries;
import willatendo.fossilslegacy.server.jewel_recovery.FAJewelRecoveries;
import willatendo.fossilslegacy.server.level.prehistoric.PrehistoricNoiseGeneratorSettings;
import willatendo.fossilslegacy.server.pattern_type.FAPatternTypes;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.FAStoneTabletVariants;
import willatendo.fossilslegacy.server.structure.FAPools;
import willatendo.fossilslegacy.server.structure.FAProcessorLists;
import willatendo.fossilslegacy.server.structure.FAStructureSets;
import willatendo.fossilslegacy.server.structure.FAStructures;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class FABuiltinProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.BIOME, FABiomes::bootstrap).add(Registries.CONFIGURED_FEATURE, FAConfiguredFeatures::bootstrap).add(Registries.DAMAGE_TYPE, FADamageTypes::bootstrap).add(Registries.DIMENSION_TYPE, FADimensionTypes::bootstrap).add(Registries.LEVEL_STEM, FALevelStems::bootstrap).add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, FAMultiNoiseBiomeSourceParameterLists::bootstrap).add(Registries.NOISE_SETTINGS, PrehistoricNoiseGeneratorSettings::bootstrap).add(Registries.PLACED_FEATURE, FAPlacedFeatures::bootstrap).add(Registries.PROCESSOR_LIST, FAProcessorLists::bootstrap).add(Registries.STRUCTURE, FAStructures::bootstrap).add(Registries.STRUCTURE_SET, FAStructureSets::bootstrap).add(Registries.TEMPLATE_POOL, FAPools::bootstrap).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FABuiltinProvider::bootstrap).add(FARegistries.ANALYZER_RESULT, FAAnalyzerResults::bootstrap).add(FARegistries.ANCIENT_AXE_BONUS, FAAncientAxeBonuses::bootstrap).add(FARegistries.MODEL_TYPES, FAModelTypes::bootstrap).add(FARegistries.PATTERN_TYPES, FAPatternTypes::bootstrap).add(FARegistries.DINOPEDIA_ENTRY, FADinopediaEntries::bootstrap).add(FARegistries.DINOPEDIA_TYPE, FADinopediaTypes::bootstrap).add(FARegistries.FEEDER_FOOD, FAFeederFoods::bootstrap).add(FARegistries.FOSSIL_VARIANTS, FAFossilVariants::bootstrap).add(FARegistries.FUEL_ENTRY, FAFuelEntries::bootstrap).add(FARegistries.JEWEL_RECOVERY, FAJewelRecoveries::bootstrap).add(FARegistries.STONE_TABLET_VARIANTS, FAStoneTabletVariants::bootstrap);

    public FABuiltinProvider(PackOutput packOutput, CompletableFuture<Provider> registries, String modId) {
        super(packOutput, registries, BUILDER, Collections.singleton(modId));
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> bootstapContext) {
        HolderGetter<Biome> biomes = bootstapContext.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstapContext.lookup(Registries.PLACED_FEATURE);
        HolderSet<PlacedFeature> oreFossil = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_FOSSIL));
        HolderSet<PlacedFeature> orePermafrost = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_PERMAFROST));
        HolderSet<Biome> isOverworld = biomes.getOrThrow(BiomeTags.IS_OVERWORLD);
        bootstapContext.register(createBiomeModifier("add_ore_fossil"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, oreFossil, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(createBiomeModifier("add_ore_permafrost"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, orePermafrost, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(createBiomeModifier("add_nautilus_spawn"), BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(biomes.getOrThrow(BiomeTags.HAS_OCEAN_RUIN_WARM), new MobSpawnSettings.SpawnerData(FAEntityTypes.NAUTILUS.get(), 1, 1, 1)));
    }

    public static ResourceKey<BiomeModifier> createBiomeModifier(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FAUtils.resource(name));
    }
}
