package willatendo.fossilslegacy.server.biome;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import willatendo.fossilslegacy.server.biome.builder.IceAgeBiomeBuilder;
import willatendo.fossilslegacy.server.biome.builder.PrehistoricBiomeBuilder;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.function.Function;

public final class FABiomeSources {
    private static final ResourceLocation ICE_AGE_ID = FAUtils.resource("ice_age");
    private static final ResourceLocation PREHISTORIC_ID = FAUtils.resource("prehistoric");
    public static final MultiNoiseBiomeSourceParameterList.Preset ICE_AGE = new MultiNoiseBiomeSourceParameterList.Preset(ICE_AGE_ID, FABiomeSources::generateIceAgeBiomes);
    public static final MultiNoiseBiomeSourceParameterList.Preset PREHISTORIC = new MultiNoiseBiomeSourceParameterList.Preset(PREHISTORIC_ID, FABiomeSources::generatePrehistoricBiomes);

    private static <T> Climate.ParameterList<T> generateIceAgeBiomes(Function<ResourceKey<Biome>, T> biome) {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, T>> builder = ImmutableList.builder();
        new IceAgeBiomeBuilder().addBiomes(point -> builder.add(point.mapSecond(biome)));
        return new Climate.ParameterList<>(builder.build());
    }

    private static <T> Climate.ParameterList<T> generatePrehistoricBiomes(Function<ResourceKey<Biome>, T> biome) {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, T>> builder = ImmutableList.builder();
        new PrehistoricBiomeBuilder().addBiomes(point -> builder.add(point.mapSecond(biome)));
        return new Climate.ParameterList<>(builder.build());
    }

    public static void init() {
        MultiNoiseBiomeSourceParameterList.Preset.BY_NAME.put(ICE_AGE_ID, ICE_AGE);
        MultiNoiseBiomeSourceParameterList.Preset.BY_NAME.put(PREHISTORIC_ID, PREHISTORIC);
    }
}
