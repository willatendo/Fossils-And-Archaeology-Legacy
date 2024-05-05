package willatendo.fossilslegacy.server.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.features.PrehistoricBiomeFeatures;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyBiomes {
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
        return ResourceKey.create(Registries.BIOME, FossilsLegacyUtils.resource(name));
    }

    protected static int calculateSkyColor(float temperature) {
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

    private static void globalPrehistoricGeneration(BiomeGenerationSettings.Builder biomeGenerationSettings) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSprings(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
    }

    private static BiomeGenerationSettings.Builder baseOceanGeneration(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addWaterTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        return biomeGenerationSettings;
    }

    public static Biome ocean(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        return biome(true, 0.5F, 0.5F, 4159204, 329011, null, null, new MobSpawnSettings.Builder(), baseOceanGeneration(placedFeatures, configuredWorldCarvers), NORMAL_MUSIC);
    }

    public static Biome plains(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
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

    public static Biome forest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addForestFlowers(biomeGenerationSettings);

        PrehistoricBiomeFeatures.addOtherBirchTrees(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addForestGrass(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);

        return biome(true, 0.7F, 0.8F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST));
    }

    public static Biome desert(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
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
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);

        BiomeDefaultFeatures.addLightBambooVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleTrees(biomeGenerationSettings);

        BiomeDefaultFeatures.addWarmFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleVines(biomeGenerationSettings);
        BiomeDefaultFeatures.addJungleMelons(biomeGenerationSettings);


        return biome(true, 0.95F, 0.9F, mobSpawnSettings, biomeGenerationSettings, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE));
    }

    public static Biome river(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addWaterTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);

        return biome(true, 0.5F, 0.5F, 4159204, 329011, (Integer) null, (Integer) null, mobSpawnSettings, biomeGenerationSettings, NORMAL_MUSIC);
    }

    public static Biome taiga(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addFerns(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        BiomeDefaultFeatures.addTaigaTrees(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
        BiomeDefaultFeatures.addTaigaGrass(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeGenerationSettings);

        return biome(true, 0.25F, 0.8F, 4159204, 329011, (Integer) null, (Integer) null, mobSpawnSettings, biomeGenerationSettings, NORMAL_MUSIC);
    }

    public static Biome swamp(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings);
        globalPrehistoricGeneration(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addSwampClayDisk(biomeGenerationSettings);
        BiomeDefaultFeatures.addSwampVegetation(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeGenerationSettings);
        biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        return new Biome.BiomeBuilder().hasPrecipitation(true).temperature(0.8F).downfall(0.9F).specialEffects(new BiomeSpecialEffects.Builder().waterColor(6388580).waterFogColor(2302743).fogColor(12638463).skyColor(calculateSkyColor(0.8F)).foliageColorOverride(6975545).grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP)).build()).mobSpawnSettings(mobSpawnSettings.build()).generationSettings(biomeGenerationSettings.build()).build();
    }

    public static Biome beach(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
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

    public static void bootstrap(BootstapContext<Biome> bootstapContext) {
        HolderGetter<PlacedFeature> placedFeatures = bootstapContext.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers = bootstapContext.lookup(Registries.CONFIGURED_CARVER);
        bootstapContext.register(PREHISTORIC_OCEAN, ocean(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(DEEP_PREHISTORIC_OCEAN, ocean(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_PLAINS, plains(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_FOREST, forest(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_DESERT, desert(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_JUNGLE, jungle(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_RIVER, river(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_TAIGA, taiga(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_SWAMP, swamp(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_BEACH, beach(placedFeatures, configuredWorldCarvers));
    }
}
