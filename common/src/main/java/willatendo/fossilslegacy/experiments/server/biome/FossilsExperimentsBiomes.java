package willatendo.fossilslegacy.experiments.server.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsExperimentsBiomes {
    public static final ResourceKey<Biome> PREHISTORIC_PLAINS = register("prehistoric_plains");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstapContext<Biome> bootstapContext) {

    }
}
