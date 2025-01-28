package willatendo.fossilslegacy.server.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import willatendo.fossilslegacy.server.biome.FAMultiNoiseBiomeSourceParameterLists;
import willatendo.fossilslegacy.server.level.prehistoric.PrehistoricNoiseGeneratorSettings;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FALevelStems {
    public static final ResourceKey<LevelStem> PREHISTORY = create("prehistory");

    public static ResourceKey<LevelStem> create(String name) {
        return ResourceKey.create(Registries.LEVEL_STEM, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<LevelStem> bootstrapContext) {
        HolderGetter<MultiNoiseBiomeSourceParameterList> multiNoiseBiomeSourceParameterListHolderGetter = bootstrapContext.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST);
        HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettingsGetter = bootstrapContext.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<DimensionType> dimensionTypeGetter = bootstrapContext.lookup(Registries.DIMENSION_TYPE);
        MultiNoiseBiomeSource multiNoiseBiomeSource = MultiNoiseBiomeSource.createFromPreset(multiNoiseBiomeSourceParameterListHolderGetter.getOrThrow(FAMultiNoiseBiomeSourceParameterLists.PREHISTORIC));
        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(multiNoiseBiomeSource, noiseGeneratorSettingsGetter.getOrThrow(PrehistoricNoiseGeneratorSettings.PREHISTORIC));
        bootstrapContext.register(PREHISTORY, new LevelStem(dimensionTypeGetter.getOrThrow(FADimensionTypes.PREHISTORY), noiseBasedChunkGenerator));
    }
}
