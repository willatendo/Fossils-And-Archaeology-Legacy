package willatendo.fossilslegacy.server.dimension;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.function.Function;

public class FossilsLegacyBiomeSources {
    protected static final ResourceLocation PREHISTORIC_ID = FossilsLegacyUtils.resource("prehistoric");
    public static final MultiNoiseBiomeSourceParameterList.Preset PREHISTORIC = new MultiNoiseBiomeSourceParameterList.Preset(PREHISTORIC_ID, new MultiNoiseBiomeSourceParameterList.Preset.SourceProvider() {
        @Override
        public <T> Climate.ParameterList<T> apply(Function<ResourceKey<Biome>, T> biome) {
            return FossilsLegacyBiomeSources.generateOverworldBiomes(biome);
        }
    });

    protected static <T> Climate.ParameterList<T> generateOverworldBiomes(Function<ResourceKey<Biome>, T> biome) {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, T>> builder = ImmutableList.builder();
        (new PrehistoricBiomeBuilder()).addBiomes((point) -> {
            builder.add(point.mapSecond(biome));
        });
        return new Climate.ParameterList(builder.build());
    }

    public static void init() {
        MultiNoiseBiomeSourceParameterList.Preset.BY_NAME.put(PREHISTORIC_ID, PREHISTORIC);
    }
}
