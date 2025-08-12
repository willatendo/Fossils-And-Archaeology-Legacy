package willatendo.fossilslegacy.server.biome.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.biome.FABiomes;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.feature.FAPlacedFeatures;
import willatendo.fossilslegacy.server.feature.PrehistoricBiomeFeatures;

public final class PrehistoricBiomes {
    private static Biome aridPlains(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers, boolean forest) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        FABiomes.globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(forest ? FAPlacedFeatures.TREES_MORRISON_FORMATION_FOREST : FAPlacedFeatures.TREES_MORRISON_FORMATION_PLAINS));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(FAPlacedFeatures.CYCAD_PATCH));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(FAPlacedFeatures.SHORT_HORSETAIL_PATCH));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(FAPlacedFeatures.TALL_HORSETAIL_PATCH));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(FAPlacedFeatures.FERN_PATCH));
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, placedFeatures.getOrThrow(FAPlacedFeatures.JURASSIC_FERN_PATCH));
        return FABiomes.biome(true, 2.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    private static Biome coldDesert(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        FABiomes.globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(VegetationPlacements.PATCH_DEAD_BUSH_BADLANDS));
        return FABiomes.biome(false, 1.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT));
    }

    private static Biome redDesert(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        FABiomes.globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(VegetationPlacements.PATCH_DEAD_BUSH_BADLANDS));
        return FABiomes.biome(false, 1.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    private static Biome river(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers, boolean hasPrecipitation, float temperature, float downfall) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        FABiomes.globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);

        return FABiomes.biome(hasPrecipitation, temperature, downfall, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    private static Biome beach(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers, boolean hasPrecipitation, float temperature, float downfall) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        FABiomes.globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);

        return FABiomes.biome(hasPrecipitation, temperature, downfall, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    public static void bootstrap(BootstrapContext<Biome> bootstrapContext, HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        bootstrapContext.register(FABiomes.ARID_PLAINS, PrehistoricBiomes.aridPlains(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(FABiomes.ARID_FOREST, PrehistoricBiomes.aridPlains(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.COLD_DESERT, PrehistoricBiomes.coldDesert(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.RED_DESERT, PrehistoricBiomes.redDesert(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.COLD_PREHISTORIC_RIVER, PrehistoricBiomes.river(placedFeatures, configuredWorldCarvers, true, 0.0F, 0.5F));
        bootstrapContext.register(FABiomes.PREHISTORIC_RIVER, PrehistoricBiomes.river(placedFeatures, configuredWorldCarvers, true, 0.5F, 0.5F));
        bootstrapContext.register(FABiomes.WARM_PREHISTORIC_RIVER, PrehistoricBiomes.river(placedFeatures, configuredWorldCarvers, false, 1.5F, 0.0F));
        bootstrapContext.register(FABiomes.COLD_PREHISTORIC_BEACH, PrehistoricBiomes.beach(placedFeatures, configuredWorldCarvers, true, 0.25F, 0.5F));
        bootstrapContext.register(FABiomes.PREHISTORIC_BEACH, PrehistoricBiomes.beach(placedFeatures, configuredWorldCarvers, true, 0.5F, 0.5F));
        bootstrapContext.register(FABiomes.WARM_PREHISTORIC_BEACH, PrehistoricBiomes.beach(placedFeatures, configuredWorldCarvers, false, 1.5F, 0.0F));
    }
}
