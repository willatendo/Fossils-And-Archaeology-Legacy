package willatendo.fossilslegacy.server.level;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FANoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> ICE_AGE = FANoiseGeneratorSettings.create("ice_age");
    public static final ResourceKey<NoiseGeneratorSettings> PREHISTORIC = FANoiseGeneratorSettings.create("prehistoric");

    public static ResourceKey<NoiseGeneratorSettings> create(String name) {
        return ResourceKey.create(Registries.NOISE_SETTINGS, FAUtils.resource(name));
    }

    public static void bootstrap(BootstrapContext<NoiseGeneratorSettings> bootstrapContext) {
        bootstrapContext.register(ICE_AGE, new NoiseGeneratorSettings(NoiseSettings.OVERWORLD_NOISE_SETTINGS, Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(), NoiseRouterData.overworld(bootstrapContext.lookup(Registries.DENSITY_FUNCTION), bootstrapContext.lookup(Registries.NOISE), false, false), IceAgeSurfaceRules.iceAge(), new OverworldBiomeBuilder().spawnTarget(), 50, false, true, true, false));
        bootstrapContext.register(PREHISTORIC, new NoiseGeneratorSettings(NoiseSettings.OVERWORLD_NOISE_SETTINGS, Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(), NoiseRouterData.overworld(bootstrapContext.lookup(Registries.DENSITY_FUNCTION), bootstrapContext.lookup(Registries.NOISE), false, false), PrehistoricSurfaceRules.prehistoric(), new OverworldBiomeBuilder().spawnTarget(), 63, false, true, true, false));
    }
}
