package willatendo.fossilslegacy.server.hologram;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FAHologramTypes {
    private static ResourceKey<HologramType> create(String name) {
        return ResourceKey.create(FARegistries.HOLOGRAM_TYPE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<HologramType> bootstrapContext, ResourceKey<HologramType> resourceKey, HologramType hologramType) {
        bootstrapContext.register(resourceKey, hologramType);
    }

    private static void register(BootstrapContext<HologramType> bootstrapContext, String name, ResourceLocation modelId, ResourceLocation texture) {
        FAHologramTypes.register(bootstrapContext, FAHologramTypes.create(name), new HologramType(modelId, texture));
    }

    public static void bootstrap(BootstrapContext<HologramType> bootstrapContext) {
        FAHologramTypes.register(bootstrapContext, "ankylosaurus", FAUtils.resource("ankylosaurus"), FAUtils.resource("textures/entity/ankylosaurus/ankylosaurus_hologram.png"));
    }
}
