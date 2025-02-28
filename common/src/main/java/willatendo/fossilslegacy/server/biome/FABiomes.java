package willatendo.fossilslegacy.server.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.feature.PrehistoricBiomeFeatures;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FABiomes {
    private static final Music NORMAL_MUSIC = null;

    public static final ResourceKey<Biome> PREHISTORIC_OCEAN = register("prehistoric_ocean");
    public static final ResourceKey<Biome> DEEP_PREHISTORIC_OCEAN = register("deep_prehistoric_ocean");
    public static final ResourceKey<Biome> PREHISTORIC_PLAINS = register("prehistoric_plains");
    public static final ResourceKey<Biome> PREHISTORIC_FOREST = register("prehistoric_forest");
    public static final ResourceKey<Biome> PREHISTORIC_DESERT = register("prehistoric_desert");
    public static final ResourceKey<Biome> PREHISTORIC_JUNGLE = register("prehistoric_jungle");
    public static final ResourceKey<Biome> PREHISTORIC_TAIGA = register("prehistoric_taiga");
    public static final ResourceKey<Biome> PREHISTORIC_RIVER = register("prehistoric_river");
    public static final ResourceKey<Biome> PREHISTORIC_SWAMP = register("prehistoric_swamp");
    public static final ResourceKey<Biome> PREHISTORIC_BEACH = register("prehistoric_beach");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, FAUtils.resource(name));
    }

    static int calculateSkyColor(float temperature) {
        float color = temperature / 3.0F;
        color = Mth.clamp(color, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - color * 0.05F, 0.5F + color * 0.1F, 1.0F);
    }

    private static Biome biome(boolean hasPrecipitation, float temperature, float downfall, MobSpawnSettings.Builder mobSpawnSettings, BiomeGenerationSettings.Builder biomeGenerationSettings, Music music) {
        return biome(hasPrecipitation, temperature, downfall, 4159204, 329011, null, null, mobSpawnSettings, biomeGenerationSettings, music);
    }

    private static Biome biome(boolean hasPrecipitation, float temperature, float downfall, int waterColor, int waterFogColour, Integer grassColorOverride, Integer foliageColorOverride, MobSpawnSettings.Builder mobSpwanSettings, BiomeGenerationSettings.Builder biomeGenerationSettings, Music music) {
        BiomeSpecialEffects.Builder biomespecialeffects$builder = new BiomeSpecialEffects.Builder().waterColor(waterColor).waterFogColor(waterFogColour).fogColor(12638463).skyColor(calculateSkyColor(temperature)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music);
        if (grassColorOverride != null) {
            biomespecialeffects$builder.grassColorOverride(grassColorOverride);
        }

        if (foliageColorOverride != null) {
            biomespecialeffects$builder.foliageColorOverride(foliageColorOverride);
        }

        return new Biome.BiomeBuilder().hasPrecipitation(hasPrecipitation).temperature(temperature).downfall(downfall).specialEffects(biomespecialeffects$builder.build()).mobSpawnSettings(mobSpwanSettings.build()).generationSettings(biomeGenerationSettings.build()).build();
    }

    static void globalPrehistoricGeneration(BiomeGenerationSettings.Builder biomeGenerationSettings) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSprings(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
    }

    static BiomeGenerationSettings.Builder baseOceanGeneration(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers, boolean deep) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        PrehistoricBiomeFeatures.addPrehistoricWaterTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, deep ? AquaticPlacements.SEAGRASS_DEEP : AquaticPlacements.SEAGRASS_NORMAL);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(biomeGenerationSettings);
        return biomeGenerationSettings;
    }

    private static Biome ocean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers, boolean deep) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.MOSASAURUS.get(), 1, 1, 1));
        mobSpawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.ICHTHYOSAURUS.get(), 2, 2, 5));
        return biome(true, 0.5F, 0.5F, 4159204, 329011, null, null, mobSpawnSettings, baseOceanGeneration(placedFeatures, configuredWorldCarvers, deep), NORMAL_MUSIC);
    }

    private static Biome plains(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.ANKYLOSAURUS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.BRACHIOSAURUS.get(), 1, 1, 2));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.PACHYCEPHALOSAURUS.get(), 1, 1, 2));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.STEGOSAURUS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.TRICERATOPS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.TYRANNOSAURUS.get(), 1, 1, 1));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addPlainGrass(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        PrehistoricBiomeFeatures.addPrehistoricPlainVegetation(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);

        return biome(true, 0.8F, 0.4F, mobSpawnSettings, biomeGenerationSettings, NORMAL_MUSIC);
    }

    private static Biome forest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.CARNOTAURUS.get(), 1, 1, 2));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.PACHYCEPHALOSAURUS.get(), 1, 1, 2));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.STEGOSAURUS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.THERIZINOSAURUS.get(), 1, 1, 2));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addForestFlowers(biomeGenerationSettings);

        PrehistoricBiomeFeatures.addPrehistoricOtherBirchTrees(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);

        return biome(true, 0.7F, 0.8F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST));
    }

    private static Biome desert(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.GALLIMIMUS.get(), 1, 4, 7));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.TRICERATOPS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.VELOCIRAPTOR.get(), 1, 4, 7));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDesertVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeGenerationSettings);
        return biome(false, 2.0F, 0.0F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT));
    }

    private static Biome jungle(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.STEGOSAURUS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.TRICERATOPS.get(), 1, 2, 6));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);

        BiomeDefaultFeatures.addLightBambooVegetation(biomeGenerationSettings);
        PrehistoricBiomeFeatures.addPrehistoricJungleTrees(biomeGenerationSettings);

        BiomeDefaultFeatures.addWarmFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleVines(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleMelons(biomeGenerationSettings);


        return biome(true, 0.95F, 0.9F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE));
    }

    private static Biome river(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.FUTABASAURUS.get(), 1, 1, 3));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        PrehistoricBiomeFeatures.addPrehistoricWaterTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);

        return biome(true, 0.5F, 0.5F, 4159204, 329011, (Integer) null, (Integer) null, mobSpawnSettings, biomeGenerationSettings, NORMAL_MUSIC);
    }

    private static Biome taiga(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.CRYOLOPHOSAURUS.get(), 1, 2, 2));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.STEGOSAURUS.get(), 1, 2, 6));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addFerns(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        PrehistoricBiomeFeatures.addPrehistoricTaigaTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addTaigaGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeGenerationSettings);

        return biome(true, 0.25F, 0.8F, 4159204, 329011, (Integer) null, (Integer) null, mobSpawnSettings, biomeGenerationSettings, NORMAL_MUSIC);
    }

    private static Biome swamp(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.STEGOSAURUS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.TRICERATOPS.get(), 1, 2, 6));
        mobSpawnSettings.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(FAEntityTypes.SPINOSAURUS.get(), 1, 1, 1));
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(biomeGenerationSettings);
        PrehistoricBiomeFeatures.addPrehistoricSwampVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        return new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.9F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(6388580).waterFogColor(2302743).fogColor(12638463).skyColor(calculateSkyColor(0.8F)).foliageColorOverride(6975545).grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP)).build()).mobSpawnSettings(mobSpawnSettings.build()).generationSettings(biomeGenerationSettings.build()).build();
    }

    private static Biome beach(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);

        return biome(true, 0.8F, 0.4F, 4159204, 329011, (Integer) null, (Integer) null, mobSpawnSettings, biomeGenerationSettings, NORMAL_MUSIC);
    }

    public static void bootstrap(BootstrapContext<Biome> bootstrapContext) {
        HolderGetter<PlacedFeature> placedFeatures = bootstrapContext.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers = bootstrapContext.lookup(Registries.CONFIGURED_CARVER);
        bootstrapContext.register(FABiomes.PREHISTORIC_OCEAN, FABiomes.ocean(placedFeatures, configuredWorldCarvers, true));
        bootstrapContext.register(FABiomes.DEEP_PREHISTORIC_OCEAN, FABiomes.ocean(placedFeatures, configuredWorldCarvers, false));
        bootstrapContext.register(FABiomes.PREHISTORIC_PLAINS, FABiomes.plains(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.PREHISTORIC_FOREST, FABiomes.forest(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.PREHISTORIC_DESERT, FABiomes.desert(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.PREHISTORIC_JUNGLE, FABiomes.jungle(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.PREHISTORIC_RIVER, FABiomes.river(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.PREHISTORIC_TAIGA, FABiomes.taiga(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.PREHISTORIC_SWAMP, FABiomes.swamp(placedFeatures, configuredWorldCarvers));
        bootstrapContext.register(FABiomes.PREHISTORIC_BEACH, FABiomes.beach(placedFeatures, configuredWorldCarvers));
    }
}
