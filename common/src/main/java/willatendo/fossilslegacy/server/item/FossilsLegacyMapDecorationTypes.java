package willatendo.fossilslegacy.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FossilsLegacyMapDecorationTypes {
    public static final SimpleRegistry<MapDecorationType> MAP_DECORATION_TYPES = SimpleRegistry.create(Registries.MAP_DECORATION_TYPE, FossilsLegacyUtils.ID);

    public static final SimpleHolder<MapDecorationType> MAYAN_TEMPLE = MAP_DECORATION_TYPES.register("mayan_temple", () -> new MapDecorationType(FossilsLegacyUtils.resource("mayan_temple"), true, 0x323232, false, true));
}
