package willatendo.fossilslegacy.server.biome.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.biome.FABiomes;

public final class IceAgeBiomes {
    public static Biome glacier(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);

        return FABiomes.biome(true, -1.0F, 0.5F, new MobSpawnSettings.Builder(), biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    public static Biome plains(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isCold) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        if (isCold) {
            BiomeDefaultFeatures.addSnowyTrees(biomeGenerationSettings);
            BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
            BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        } else {
            BiomeDefaultFeatures.addPlainVegetation(biomeGenerationSettings);
        }

        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);

        return FABiomes.biome(true, isCold ? 0.0F : 0.8F, isCold ? 0.5F : 0.4F, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }


    public static Biome forest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addForestFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addOtherBirchTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        return FABiomes.biome(true, 0.7F, 0.8F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST));
    }

    public static Biome taiga(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addFerns(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addTaigaTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addTaigaGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addRareBerryBushes(biomeGenerationSettings);

        return FABiomes.biome(true, -0.5F, 0.4F, 4020182, 329011, null, null, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    public static Biome beach(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isCold) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        return FABiomes.biome(true, isCold ? 0.05F : 0.8F, !isCold ? 0.4F : 0.3F, isCold ? 4020182 : 4159204, 329011, null, null, new MobSpawnSettings.Builder(), biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    private static Biome mauritius(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addSparseJungleTrees(biomeGenerationSettings);

        BiomeDefaultFeatures.addWarmFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleVines(biomeGenerationSettings);
        BiomeDefaultFeatures.addSparseJungleMelons(biomeGenerationSettings);

        return FABiomes.biome(true, 0.95F, 0.8F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SPARSE_JUNGLE));
    }

    private static BiomeGenerationSettings.Builder baseOceanGeneration(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addWaterTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        return biomeGenerationSettings;
    }

    public static Biome coldOcean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isDeep) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = baseOceanGeneration(placedFeatures, worldCarvers);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, isDeep ? AquaticPlacements.SEAGRASS_DEEP_COLD : AquaticPlacements.SEAGRASS_COLD);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(biomeGenerationSettings);
        return FABiomes.biome(true, 0.5F, 0.5F, 4020182, 329011, null, null, new MobSpawnSettings.Builder(), biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    public static Biome frozenOcean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isDeep) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addIcebergs(biomeGenerationSettings);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addBlueIce(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addWaterTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        float temperature = isDeep ? 0.5F : 0.0F;
        return new Biome.BiomeBuilder().hasPrecipitation(true).temperature(temperature).temperatureAdjustment(Biome.TemperatureModifier.FROZEN).downfall(0.5F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(3750089).waterFogColor(329011).fogColor(12638463).skyColor(FABiomes.calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(new MobSpawnSettings.Builder().build()).generationSettings(biomeGenerationSettings.build()).build();
    }

    public static void bootstrap(BootstrapContext<Biome> bootstrapContext, HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        bootstrapContext.register(FABiomes.GLACIER, IceAgeBiomes.glacier(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.FROZEN_PLAINS, IceAgeBiomes.plains(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.FROZEN_FOREST, IceAgeBiomes.forest(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.COLD_PLAINS, IceAgeBiomes.plains(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(FABiomes.COLD_FOREST, IceAgeBiomes.taiga(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.COLD_BEACH, IceAgeBiomes.beach(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.ICE_AGE_BEACH, IceAgeBiomes.beach(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(FABiomes.FROZEN_OCEAN, IceAgeBiomes.frozenOcean(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(FABiomes.DEEP_FROZEN_OCEAN, IceAgeBiomes.frozenOcean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.COLD_OCEAN, IceAgeBiomes.coldOcean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.DEEP_COLD_OCEAN, IceAgeBiomes.coldOcean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.MAURITIUS, IceAgeBiomes.mauritius(placedFeatures, configuredWorldCarvers));
    }
}
