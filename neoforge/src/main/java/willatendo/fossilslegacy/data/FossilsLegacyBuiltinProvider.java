package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.RegistrySetBuilder.RegistryBootstrap;
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
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyBiomes;
import willatendo.fossilslegacy.server.dimension.FossilsLegacyDimensionTypes;
import willatendo.fossilslegacy.server.dimension.FossilsLegacyLevelStems;
import willatendo.fossilslegacy.server.dimension.FossilsLegacyMultiNoiseBiomeSourceParameterLists;
import willatendo.fossilslegacy.server.dimension.PrehistoricNoiseGeneratorSettings;
import willatendo.fossilslegacy.server.entity.FossilsLegacyDamageTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyStoneTabletVariants;
import willatendo.fossilslegacy.server.entity.genetics.FossilsLegacyCoatTypes;
import willatendo.fossilslegacy.server.feature.FossilsLegacyConfiguredFeatures;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructureSets;
import willatendo.fossilslegacy.server.structure.FossilsLegacyStructures;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class FossilsLegacyBuiltinProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, (RegistryBootstrap) FossilsLegacyConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, (RegistryBootstrap) FossilsLegacyPlacedFeatures::bootstrap).add(Registries.DAMAGE_TYPE, (RegistryBootstrap) FossilsLegacyDamageTypes::bootstrap).add(Registries.STRUCTURE, (RegistryBootstrap) FossilsLegacyStructures::bootstrap).add(Registries.STRUCTURE_SET, (RegistryBootstrap) FossilsLegacyStructureSets::bootstrap).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FossilsLegacyBuiltinProvider::bootstrap).add(Registries.BIOME, FossilsLegacyBiomes::bootstrap).add(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, FossilsLegacyMultiNoiseBiomeSourceParameterLists::bootstrap).add(Registries.NOISE_SETTINGS, PrehistoricNoiseGeneratorSettings::bootstrap).add(Registries.DIMENSION_TYPE, FossilsLegacyDimensionTypes::bootstrap).add(Registries.LEVEL_STEM, FossilsLegacyLevelStems::bootstrap).add(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, FossilsLegacyStoneTabletVariants::bootstrap).add(FossilsLegacyRegistries.COAT_TYPES, FossilsLegacyCoatTypes::bootstrap);

    public FossilsLegacyBuiltinProvider(PackOutput packOutput, CompletableFuture<Provider> registries, String modId) {
        super(packOutput, registries, BUILDER, Collections.singleton(modId));
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> bootstapContext) {
        HolderGetter<Biome> biomes = bootstapContext.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstapContext.lookup(Registries.PLACED_FEATURE);
        HolderSet<PlacedFeature> oreFossil = HolderSet.direct(placedFeatures.getOrThrow(FossilsLegacyPlacedFeatures.ORE_FOSSIL));
        HolderSet<PlacedFeature> orePermafrost = HolderSet.direct(placedFeatures.getOrThrow(FossilsLegacyPlacedFeatures.ORE_PERMAFROST));
        HolderSet<Biome> isOverworld = biomes.getOrThrow(BiomeTags.IS_OVERWORLD);
        bootstapContext.register(createBiomeModifier("add_ore_fossil"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, oreFossil, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(createBiomeModifier("add_ore_permafrost"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, orePermafrost, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(createBiomeModifier("add_nautilus_spawn"), BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(biomes.getOrThrow(BiomeTags.HAS_OCEAN_RUIN_WARM), new MobSpawnSettings.SpawnerData(FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1)));
    }

    public static ResourceKey<BiomeModifier> createBiomeModifier(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FossilsLegacyUtils.resource(name));
    }
}
