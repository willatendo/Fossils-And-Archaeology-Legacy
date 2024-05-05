package willatendo.fossilslegacy.server.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyMultiNoiseBiomeSourceParameterLists {
    public static final ResourceKey<MultiNoiseBiomeSourceParameterList> PREHISTORIC = create("prehistoric");

    private static ResourceKey<MultiNoiseBiomeSourceParameterList> create(String name) {
        return ResourceKey.create(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstapContext<MultiNoiseBiomeSourceParameterList> bootstapContext) {
        HolderGetter<Biome> biomeGetter = bootstapContext.lookup(Registries.BIOME);
        bootstapContext.register(PREHISTORIC, new MultiNoiseBiomeSourceParameterList(FossilsLegacyBiomeSources.PREHISTORIC, biomeGetter));
    }
}
