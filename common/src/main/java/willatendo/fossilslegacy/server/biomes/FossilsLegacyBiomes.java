package willatendo.fossilslegacy.server.biomes;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyBiomes {
    private static final Music NORMAL_MUSIC = null;

    public static final ResourceKey<Biome> PREHISTORIC_OCEAN = register("prehistoric_ocean");
    public static final ResourceKey<Biome> PREHISTORIC_PLAINS = register("prehistoric_plains");
    public static final ResourceKey<Biome> PREHISTORIC_DESERT = register("prehistoric_desert");
    public static final ResourceKey<Biome> PREHISTORIC_EXTREME_HILLS = register("prehistoric_extreme_hills");
    public static final ResourceKey<Biome> PREHISTORIC_FOREST = register("prehistoric_forest");
    public static final ResourceKey<Biome> PREHISTORIC_TAIGA = register("prehistoric_taiga");
    public static final ResourceKey<Biome> PREHISTORIC_SWAMPLAND = register("prehistoric_swampland");
    public static final ResourceKey<Biome> PREHISTORIC_RIVER = register("prehistoric_river");
    public static final ResourceKey<Biome> PREHISTORIC_FROZEN_OCEAN = register("prehistoric_frozen_ocean");
    public static final ResourceKey<Biome> PREHISTORIC_FROZEN_RIVER = register("prehistoric_frozen_river");
    public static final ResourceKey<Biome> PREHISTORIC_ICE_PLAINS = register("prehistoric_ice_plains");
    public static final ResourceKey<Biome> PREHISTORIC_ICE_MOUNTAINS = register("prehistoric_ice_mountains");
    public static final ResourceKey<Biome> PREHISTORIC_MUSHROOM_ISLANDS = register("prehistoric_mushroom_islands");
    public static final ResourceKey<Biome> PREHISTORIC_MUSHROOM_ISLANDS_SHORE = register("prehistoric_mushroom_islands_shore");
    public static final ResourceKey<Biome> PREHISTORIC_BEACH = register("prehistoric_beach");
    public static final ResourceKey<Biome> PREHISTORIC_DESERT_HILLS = register("prehistoric_desert_hills");
    public static final ResourceKey<Biome> PREHISTORIC_FOREST_HILLS = register("prehistoric_forest_hills");
    public static final ResourceKey<Biome> PREHISTORIC_TAIGA_HILLS = register("prehistoric_taiga_hills");
    public static final ResourceKey<Biome> PREHISTORIC_EXTREME_HILLS_EDGE = register("prehistoric_extreme_hills_edge");
    public static final ResourceKey<Biome> PREHISTORIC_JUNGLE = register("prehistoric_jungle");
    public static final ResourceKey<Biome> PREHISTORIC_JUNGLE_HILLS = register("prehistoric_jungle_hills");

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

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder biomeGenerationSettings) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSprings(biomeGenerationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
    }

    private static BiomeGenerationSettings.Builder baseOceanGeneration(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers) {
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalOverworldGeneration(biomeGenerationSettings);
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

    public static Biome plains(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers, boolean snowyPlains) {
        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(placedFeatures, configuredWorldCarvers);
        globalOverworldGeneration(biomeGenerationSettings);
        if (snowyPlains) {
            mobSpawnSettings.creatureGenerationProbability(0.07F);
            BiomeDefaultFeatures.snowySpawns(mobSpawnSettings);
        } else {
            BiomeDefaultFeatures.plainsSpawns(mobSpawnSettings);
            BiomeDefaultFeatures.addPlainGrass(biomeGenerationSettings);
        }

        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeGenerationSettings);
        if (snowyPlains) {
            BiomeDefaultFeatures.addSnowyTrees(biomeGenerationSettings);
            BiomeDefaultFeatures.addDefaultFlowers(biomeGenerationSettings);
            BiomeDefaultFeatures.addDefaultGrass(biomeGenerationSettings);
        } else {
            BiomeDefaultFeatures.addPlainVegetation(biomeGenerationSettings);
        }

        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings);

        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeGenerationSettings);

        return biome(true, snowyPlains ? 0.0F : 0.8F, snowyPlains ? 0.5F : 0.4F, mobSpawnSettings, biomeGenerationSettings, NORMAL_MUSIC);
    }

    public static void bootstrap(BootstapContext<Biome> bootstapContext) {
        HolderGetter<PlacedFeature> placedFeatures = bootstapContext.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredWorldCarvers = bootstapContext.lookup(Registries.CONFIGURED_CARVER);
        bootstapContext.register(PREHISTORIC_OCEAN, ocean(placedFeatures, configuredWorldCarvers));
        bootstapContext.register(PREHISTORIC_PLAINS, plains(placedFeatures, configuredWorldCarvers, false));
    }
}
