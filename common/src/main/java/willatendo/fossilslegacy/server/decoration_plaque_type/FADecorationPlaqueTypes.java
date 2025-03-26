package willatendo.fossilslegacy.server.decoration_plaque_type;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

public class FADecorationPlaqueTypes {
    public static final ResourceKey<DecorationPlaqueType> CARNIVORE = FADecorationPlaqueTypes.create("carnivore");
    public static final ResourceKey<DecorationPlaqueType> DOWN = FADecorationPlaqueTypes.create("down");
    public static final ResourceKey<DecorationPlaqueType> HERBIVORE = FADecorationPlaqueTypes.create("herbivore");
    public static final ResourceKey<DecorationPlaqueType> LEFT = FADecorationPlaqueTypes.create("left");
    public static final ResourceKey<DecorationPlaqueType> LEFT_AND_RIGHT = FADecorationPlaqueTypes.create("left_and_right");
    public static final ResourceKey<DecorationPlaqueType> RIGHT = FADecorationPlaqueTypes.create("right");
    public static final ResourceKey<DecorationPlaqueType> RIGHT_AND_LEFT = FADecorationPlaqueTypes.create("right_and_left");
    public static final ResourceKey<DecorationPlaqueType> UP = FADecorationPlaqueTypes.create("up");

    private static ResourceKey<DecorationPlaqueType> create(String name) {
        return ResourceKey.create(FARegistries.DECORATION_PLAQUE_TYPE, FAUtils.resource(name));
    }

    private static void register(BootstrapContext<DecorationPlaqueType> bootstrapContext, ResourceKey<DecorationPlaqueType> resourceKey, int width, int height) {
        bootstrapContext.register(resourceKey, new DecorationPlaqueType(width, height, resourceKey.location()));
    }

    public static void bootstrap(BootstrapContext<DecorationPlaqueType> bootstrapContext) {
        FADecorationPlaqueTypes.register(bootstrapContext, CARNIVORE, 2, 2);
        FADecorationPlaqueTypes.register(bootstrapContext, DOWN, 1, 1);
        FADecorationPlaqueTypes.register(bootstrapContext, HERBIVORE, 2, 2);
        FADecorationPlaqueTypes.register(bootstrapContext, LEFT, 1, 1);
        FADecorationPlaqueTypes.register(bootstrapContext, LEFT_AND_RIGHT, 1, 1);
        FADecorationPlaqueTypes.register(bootstrapContext, RIGHT, 1, 1);
        FADecorationPlaqueTypes.register(bootstrapContext, RIGHT_AND_LEFT, 1, 1);
        FADecorationPlaqueTypes.register(bootstrapContext, UP, 1, 1);
    }
}
