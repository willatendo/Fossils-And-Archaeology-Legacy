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
import willatendo.fossilslegacy.server.level.FALevels;
import willatendo.fossilslegacy.server.level.prehistoric.PrehistoricNoiseGeneratorSettings;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FALevelStems {
    public static final ResourceKey<LevelStem> ICE_AGE = FALevelStems.create("ice_age");
    public static final ResourceKey<LevelStem> PREHISTORY = FALevelStems.create("prehistory");

    public static ResourceKey<LevelStem> create(String name) {
        return ResourceKey.create(Registries.LEVEL_STEM, FAUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<LevelStem> bootstrapContext) {
        HolderGetter<MultiNoiseBiomeSourceParameterList> multiNoiseBiomeSourceParameterListRegistry = bootstrapContext.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST);
        HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettingsRegistry = bootstrapContext.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<DimensionType> dimensionTypeRegistry = bootstrapContext.lookup(Registries.DIMENSION_TYPE);

        bootstrapContext.register(PREHISTORY, new LevelStem(dimensionTypeRegistry.getOrThrow(FADimensionTypes.PREHISTORY), new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromPreset(multiNoiseBiomeSourceParameterListRegistry.getOrThrow(FAMultiNoiseBiomeSourceParameterLists.PREHISTORIC)), noiseGeneratorSettingsRegistry.getOrThrow(PrehistoricNoiseGeneratorSettings.PREHISTORIC))));
    }
}
