package willatendo.fossilslegacy.server.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsExperimentsLevelStems {
	public static final ResourceKey<LevelStem> PREHISTORY = create("prehistory");

	public static ResourceKey<LevelStem> create(String name) {
		return ResourceKey.create(Registries.LEVEL_STEM, FossilsLegacyUtils.resource(name));
	}

	public static void bootstrap(BootstapContext<LevelStem> bootstapContext) {
		HolderGetter<Biome> biomeGetter = bootstapContext.lookup(Registries.BIOME);
		HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettingsGetter = bootstapContext.lookup(Registries.NOISE_SETTINGS);
		HolderGetter<DimensionType> dimensionTypeGetter = bootstapContext.lookup(Registries.DIMENSION_TYPE);
		FixedBiomeSource fixedBiomeSource = new FixedBiomeSource(biomeGetter.getOrThrow(Biomes.SWAMP));
		NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(fixedBiomeSource, noiseGeneratorSettingsGetter.getOrThrow(NoiseGeneratorSettings.OVERWORLD));
		bootstapContext.register(PREHISTORY, new LevelStem(dimensionTypeGetter.getOrThrow(FossilsExperimentsDimensionTypes.PREHISTORY), noiseBasedChunkGenerator));
	}
}
