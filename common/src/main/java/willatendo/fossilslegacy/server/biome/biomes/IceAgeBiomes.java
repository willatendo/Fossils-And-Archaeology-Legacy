package willatendo.fossilslegacy.server.biome.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.resources.ResourceKey;
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
    public static final ResourceKey<Biome> GLACIER = FABiomes.create("ice_age/glacier");

    public static final ResourceKey<Biome> FROZEN_PLAINS = FABiomes.create("ice_age/frozen_plains");
    public static final ResourceKey<Biome> COLD_PLAINS = FABiomes.create("ice_age/cold_plains");
    public static final ResourceKey<Biome> SAVANNA = FABiomes.create("ice_age/savanna");
    public static final ResourceKey<Biome> DESERT = FABiomes.create("ice_age/desert");

    public static final ResourceKey<Biome> FROZEN_FOREST = FABiomes.create("ice_age/frozen_forest");
    public static final ResourceKey<Biome> COLD_FOREST = FABiomes.create("ice_age/cold_forest");
    public static final ResourceKey<Biome> JUNGLE = FABiomes.create("ice_age/jungle");

    public static final ResourceKey<Biome> COLD_BEACH = FABiomes.create("ice_age/cold_beach");
    public static final ResourceKey<Biome> BEACH = FABiomes.create("ice_age/beach");
    public static final ResourceKey<Biome> STONY_BEACH = FABiomes.create("ice_age/stony_beach");

    public static final ResourceKey<Biome> COLD_RIVER = FABiomes.create("ice_age/cold_river");
    public static final ResourceKey<Biome> RIVER = FABiomes.create("ice_age/river");

    public static final ResourceKey<Biome> FROZEN_OCEAN = FABiomes.create("ice_age/frozen_ocean");
    public static final ResourceKey<Biome> DEEP_FROZEN_OCEAN = FABiomes.create("ice_age/deep_frozen_ocean");
    public static final ResourceKey<Biome> COLD_OCEAN = FABiomes.create("ice_age/cold_ocean");
    public static final ResourceKey<Biome> DEEP_COLD_OCEAN = FABiomes.create("ice_age/deep_cold_ocean");
    public static final ResourceKey<Biome> OCEAN = FABiomes.create("ice_age/ocean");
    public static final ResourceKey<Biome> DEEP_OCEAN = FABiomes.create("ice_age/deep_ocean");
    public static final ResourceKey<Biome> LUKEWARM_OCEAN = FABiomes.create("ice_age/lukewarm_ocean");
    public static final ResourceKey<Biome> DEEP_LUKEWARM_OCEAN = FABiomes.create("ice_age/deep_lukewarm_ocean");
    public static final ResourceKey<Biome> WARM_OCEAN = FABiomes.create("ice_age/warm_ocean");

    public static final ResourceKey<Biome> MAURITIUS = FABiomes.create("ice_age/mauritius");
    public static final ResourceKey<Biome> SWAMP = FABiomes.create("ice_age/swamp");

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

    public static Biome savanna(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addSavannaGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addSavannaTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addWarmFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);

        return FABiomes.biome(false, 2.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    public static Biome desert(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDesertVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenerationSettings);

        return FABiomes.biome(false, 2.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT));
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


    private static Biome jungle(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addWarmFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleVines(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleMelons(biomeGenerationSettings);

        return FABiomes.biome(true, 0.95F, 0.9F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE));
    }

    public static Biome river(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isCold) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addWaterTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        if (!isCold) {
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        }

        return FABiomes.biome(true, isCold ? 0.0F : 0.5F, 0.5F, isCold ? 3750089 : 4159204, 329011, null, null, mobSpawnSettings, biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
    }

    public static Biome beach(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isCold, boolean isStony) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        boolean flag = !isStony && !isCold;
        return FABiomes.biome(true, isCold ? 0.05F : isStony ? 0.2F : 0.8F, flag ? 0.4F : 0.3F, isCold ? 4020182 : 4159204, 329011, null, null, new MobSpawnSettings.Builder(), biomeGenerationSettings, FABiomes.NORMAL_MUSIC);
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


    private static Biome baseOcean(MobSpawnSettings.Builder mobSpawnSettings, int waterColor, int waterFogColor, BiomeGenerationSettings.Builder generationSettings) {
        return FABiomes.biome(true, 0.5F, 0.5F, waterColor, waterFogColor, null, null, mobSpawnSettings, generationSettings, FABiomes.NORMAL_MUSIC);
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
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.oceanSpawns(mobSpawnSettings, 3, 4, 15);
        mobSpawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 15, 1, 5));
        BiomeGenerationSettings.Builder biomeGenerationSettings = IceAgeBiomes.baseOceanGeneration(placedFeatures, worldCarvers);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, isDeep ? AquaticPlacements.SEAGRASS_DEEP_COLD : AquaticPlacements.SEAGRASS_COLD);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(biomeGenerationSettings);
        return IceAgeBiomes.baseOcean(mobSpawnSettings, 4020182, 329011, biomeGenerationSettings);
    }

    public static Biome ocean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isDeep) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.oceanSpawns(mobSpawnSettings, 1, 4, 10);
        mobSpawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 1, 1, 2));
        BiomeGenerationSettings.Builder biomeGenerationSettings = IceAgeBiomes.baseOceanGeneration(placedFeatures, worldCarvers);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, isDeep ? AquaticPlacements.SEAGRASS_DEEP : AquaticPlacements.SEAGRASS_NORMAL);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(biomeGenerationSettings);
        return IceAgeBiomes.baseOcean(mobSpawnSettings, 4159204, 329011, biomeGenerationSettings);
    }

    public static Biome lukeWarmOcean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers, boolean isDeep) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        if (isDeep) {
            BiomeDefaultFeatures.oceanSpawns(mobSpawnSettings, 8, 4, 8);
        } else {
            BiomeDefaultFeatures.oceanSpawns(mobSpawnSettings, 10, 2, 15);
        }
        mobSpawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 5, 1, 3)).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8)).addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 2, 1, 2));
        BiomeGenerationSettings.Builder biomeGenerationSettings = IceAgeBiomes.baseOceanGeneration(placedFeatures, worldCarvers);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, isDeep ? AquaticPlacements.SEAGRASS_DEEP_WARM : AquaticPlacements.SEAGRASS_WARM);
        BiomeDefaultFeatures.addLukeWarmKelp(biomeGenerationSettings);
        return baseOcean(mobSpawnSettings, 4566514, 267827, biomeGenerationSettings);
    }

    public static Biome warmOcean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = (new MobSpawnSettings.Builder()).addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 15, 1, 3));
        BiomeDefaultFeatures.warmOceanSpawns(mobSpawnSettings, 10, 4);
        BiomeGenerationSettings.Builder biomeGenerationSettings = IceAgeBiomes.baseOceanGeneration(placedFeatures, worldCarvers).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.WARM_OCEAN_VEGETATION).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM).addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);
        return baseOcean(mobSpawnSettings, 4445678, 270131, biomeGenerationSettings);
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

    public static Biome swamp(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
        mobSpawnSettings.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        FABiomes.globalIceAgeGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addMangroveSwampDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addMangroveSwampVegetation(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        return new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.9F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(3832426).waterFogColor(5077600).fogColor(12638463).skyColor(FABiomes.calculateSkyColor(0.8F)).foliageColorOverride(9285927).grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP)).build()).mobSpawnSettings(mobSpawnSettings.build()).generationSettings(biomeGenerationSettings.build()).build();
    }

    public static void bootstrap(BootstrapContext<Biome> bootstrapContext, HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        bootstrapContext.register(GLACIER, IceAgeBiomes.glacier(placedFeatures, configuredWorldCarvers));

        bootstrapContext.register(FROZEN_PLAINS, IceAgeBiomes.plains(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(COLD_PLAINS, IceAgeBiomes.plains(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(SAVANNA, IceAgeBiomes.savanna(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(DESERT, IceAgeBiomes.desert(placedFeatures, configuredWorldCarvers));

        bootstrapContext.register(FROZEN_FOREST, IceAgeBiomes.forest(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(COLD_FOREST, IceAgeBiomes.taiga(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(JUNGLE, IceAgeBiomes.jungle(placedFeatures, configuredWorldCarvers));

        bootstrapContext.register(COLD_BEACH, IceAgeBiomes.beach(placedFeatures, configuredWorldCarvers, true, false));
        bootstrapContext.register(BEACH, IceAgeBiomes.beach(placedFeatures, configuredWorldCarvers, false, false));
        bootstrapContext.register(STONY_BEACH, IceAgeBiomes.beach(placedFeatures, configuredWorldCarvers, false, true));

        bootstrapContext.register(COLD_RIVER, IceAgeBiomes.river(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(RIVER, IceAgeBiomes.river(placedFeatures, configuredWorldCarvers, false));

        bootstrapContext.register(FROZEN_OCEAN, IceAgeBiomes.frozenOcean(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(DEEP_FROZEN_OCEAN, IceAgeBiomes.frozenOcean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(COLD_OCEAN, IceAgeBiomes.coldOcean(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(DEEP_COLD_OCEAN, IceAgeBiomes.coldOcean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(OCEAN, IceAgeBiomes.ocean(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(DEEP_OCEAN, IceAgeBiomes.ocean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(LUKEWARM_OCEAN, IceAgeBiomes.lukeWarmOcean(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(DEEP_LUKEWARM_OCEAN, IceAgeBiomes.lukeWarmOcean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(WARM_OCEAN, IceAgeBiomes.warmOcean(placedFeatures, configuredWorldCarvers));

        bootstrapContext.register(MAURITIUS, IceAgeBiomes.mauritius(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(SWAMP, IceAgeBiomes.swamp(placedFeatures, configuredWorldCarvers));
    }
}
