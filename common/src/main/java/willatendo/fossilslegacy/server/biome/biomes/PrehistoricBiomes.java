package willatendo.fossilslegacy.server.biome.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.biome.FABiomes;
import willatendo.fossilslegacy.server.feature.FAPlacedFeatures;

public final class PrehistoricBiomes {
    private static Biome morrisonFormation(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers, boolean forest) {
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

    private static Biome djadochtaFormation(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        FABiomes.globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(VegetationPlacements.PATCH_DEAD_BUSH_BADLANDS));
        return FABiomes.biome(false, 2.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT));
    }

    private static Biome flamingCliffs(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        FABiomes.globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(VegetationPlacements.PATCH_DEAD_BUSH_BADLANDS));
        return FABiomes.biome(false, 2.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    public static void bootstrap(BootstrapContext<Biome> bootstrapContext, HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        bootstrapContext.register(FABiomes.MORRISON_FORMATION_PLAINS, PrehistoricBiomes.morrisonFormation(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(FABiomes.MORRISON_FORMATION_FOREST, PrehistoricBiomes.morrisonFormation(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.DJADOCHTA_FORMATION, PrehistoricBiomes.djadochtaFormation(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.FLAMING_CLIFFS, PrehistoricBiomes.flamingCliffs(placedFeatures, configuredWorldCarvers));
    }
}
