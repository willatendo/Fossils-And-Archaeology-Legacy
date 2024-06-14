package willatendo.fossilslegacy.server.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class PrehistoricNoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> PREHISTORIC = create("prehistoric");

    public static ResourceKey<NoiseGeneratorSettings> create(String name) {
        return ResourceKey.create(Registries.NOISE_SETTINGS, FossilsLegacyUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> bootstrapContext) {
        bootstrapContext.register(PREHISTORIC, new NoiseGeneratorSettings(NoiseSettings.OVERWORLD_NOISE_SETTINGS, Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(), NoiseRouterData.overworld(bootstrapContext.lookup(Registries.DENSITY_FUNCTION), bootstrapContext.lookup(Registries.NOISE), false, false), PrehistoricSurfaceRules.prehistoric(), new OverworldBiomeBuilder().spawnTarget(), 63, false, true, true, false));
    }
}
