package willatendo.fossilslegacy.server.dimension;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import willatendo.fossilslegacy.server.biomes.FossilsLegacyBiomes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.List;
import java.util.function.Function;

public class FossilsLegacyBiomeSources {
    protected static final ResourceLocation PREHISTORIC_ID = FossilsLegacyUtils.resource("prehistoric");
    public static final MultiNoiseBiomeSourceParameterList.Preset PREHISTORIC = new MultiNoiseBiomeSourceParameterList.Preset(PREHISTORIC_ID, new MultiNoiseBiomeSourceParameterList.Preset.SourceProvider() {
        @Override
        public <T> Climate.ParameterList<T> apply(Function<ResourceKey<Biome>, T> biome) {
            return new Climate.ParameterList(List.of(Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biome.apply(FossilsLegacyBiomes.PREHISTORIC_PLAINS)), Pair.of(Climate.parameters(0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biome.apply(FossilsLegacyBiomes.PREHISTORIC_FOREST)), Pair.of(Climate.parameters(0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biome.apply(FossilsLegacyBiomes.PREHISTORIC_DESERT))));
        }
    });

    public static void init() {
        MultiNoiseBiomeSourceParameterList.Preset.BY_NAME.put(PREHISTORIC_ID, PREHISTORIC);
    }
}
