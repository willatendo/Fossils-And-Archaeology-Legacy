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
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.feature.FossilsLegacyPlacedFeatures;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class FossilsLegacyForgeBuiltinProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(ForgeRegistries.Keys.BIOME_MODIFIERS, FossilsLegacyForgeBuiltinProvider::bootstrap);

    public FossilsLegacyForgeBuiltinProvider(PackOutput packOutput, CompletableFuture<Provider> registries, String modId) {
        super(packOutput, registries, BUILDER, Collections.singleton(modId));
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> bootstapContext) {
        HolderGetter<Biome> biomes = bootstapContext.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = bootstapContext.lookup(Registries.PLACED_FEATURE);
        HolderSet<PlacedFeature> oreFossil = HolderSet.direct(placedFeatures.getOrThrow(FossilsLegacyPlacedFeatures.ORE_FOSSIL));
        HolderSet<PlacedFeature> orePermafrost = HolderSet.direct(placedFeatures.getOrThrow(FossilsLegacyPlacedFeatures.ORE_PERMAFROST));
        HolderSet<Biome> isOverworld = biomes.getOrThrow(BiomeTags.IS_OVERWORLD);
        bootstapContext.register(createBiomeModifier("add_ore_fossil"), new ForgeBiomeModifiers.AddFeaturesBiomeModifier(isOverworld, oreFossil, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(createBiomeModifier("add_ore_permafrost"), new ForgeBiomeModifiers.AddFeaturesBiomeModifier(isOverworld, orePermafrost, GenerationStep.Decoration.UNDERGROUND_ORES));
        bootstapContext.register(createBiomeModifier("add_nautilus_spawn"), ForgeBiomeModifiers.AddSpawnsBiomeModifier.singleSpawn(biomes.getOrThrow(BiomeTags.HAS_OCEAN_RUIN_WARM), new MobSpawnSettings.SpawnerData(FossilsLegacyEntityTypes.NAUTILUS.get(), 1, 1, 1)));
    }

    public static ResourceKey<BiomeModifier> createBiomeModifier(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, FossilsLegacyUtils.resource(name));
    }
}
