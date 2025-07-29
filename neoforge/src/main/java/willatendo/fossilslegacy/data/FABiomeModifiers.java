package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.feature.FAPlacedFeatures;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FABiomeModifiers {
    public static void bootstrap(BootstrapContext<BiomeModifier> bootstapContext) {
        HolderGetter<Biome> biomes = bootstapContext.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstapContext.lookup(Registries.PLACED_FEATURE);
        HolderSet<PlacedFeature> oreCenozoicFossil = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_CENOZOIC_FOSSIL));
        HolderSet<PlacedFeature> oreMesozoicFossil = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_MESOZOIC_FOSSIL));
        HolderSet<PlacedFeature> orePalaeozoicFossil = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_PALAEOZOIC_FOSSIL));
        HolderSet<PlacedFeature> oreAmber = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_AMBER));
        HolderSet<PlacedFeature> oreRelic = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_RELIC));
        HolderSet<PlacedFeature> orePermafrost = HolderSet.direct(placedFeatures.getOrThrow(FAPlacedFeatures.ORE_PERMAFROST));
        HolderSet<Biome> isOverworld = biomes.getOrThrow(BiomeTags.IS_OVERWORLD);
        bootstapContext.register(FABiomeModifiers.createBiomeModifier("add_ore_cenozoic_fossil"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, oreCenozoicFossil, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(FABiomeModifiers.createBiomeModifier("add_ore_mesozoic_fossil"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, oreMesozoicFossil, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(FABiomeModifiers.createBiomeModifier("add_ore_palaeozoic_fossil"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, orePalaeozoicFossil, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(FABiomeModifiers.createBiomeModifier("add_ore_amber"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, oreAmber, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(FABiomeModifiers.createBiomeModifier("add_ore_relic"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, oreRelic, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(FABiomeModifiers.createBiomeModifier("add_ore_permafrost"), new BiomeModifiers.AddFeaturesBiomeModifier(isOverworld, orePermafrost, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(FABiomeModifiers.createBiomeModifier("add_nautilus_spawn"), BiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(biomes.getOrThrow(BiomeTags.HAS_OCEAN_RUIN_WARM), new MobSpawnSettings.SpawnerData(FAEntityTypes.NAUTILUS.get(), 1, 1, 1)));
    }

    private static ResourceKey<BiomeModifier> createBiomeModifier(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FAUtils.resource(name));
    }
}
