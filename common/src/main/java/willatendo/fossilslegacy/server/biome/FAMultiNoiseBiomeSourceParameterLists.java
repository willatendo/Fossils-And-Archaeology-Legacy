package willatendo.fossilslegacy.server.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAMultiNoiseBiomeSourceParameterLists {
    public static final ResourceKey<MultiNoiseBiomeSourceParameterList> ICE_AGE = FAMultiNoiseBiomeSourceParameterLists.create("ice_age");
    public static final ResourceKey<MultiNoiseBiomeSourceParameterList> PREHISTORIC = FAMultiNoiseBiomeSourceParameterLists.create("prehistoric");

    private static ResourceKey<MultiNoiseBiomeSourceParameterList> create(String name) {
        return ResourceKey.create(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST, FAUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<MultiNoiseBiomeSourceParameterList> bootstrapContext) {
        HolderGetter<Biome> biomeGetter = bootstrapContext.lookup(Registries.BIOME);
        bootstrapContext.register(ICE_AGE, new MultiNoiseBiomeSourceParameterList(FABiomeSources.ICE_AGE, biomeGetter));
        bootstrapContext.register(PREHISTORIC, new MultiNoiseBiomeSourceParameterList(FABiomeSources.PREHISTORIC, biomeGetter));
    }
}
