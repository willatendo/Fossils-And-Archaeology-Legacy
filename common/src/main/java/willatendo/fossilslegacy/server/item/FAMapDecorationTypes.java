package willatendo.fossilslegacy.server.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FAMapDecorationTypes {
    public static final SimpleRegistry<MapDecorationType> MAP_DECORATION_TYPE = SimpleRegistry.create(Registries.MAP_DECORATION_TYPE, FAUtils.ID);

    public static final SimpleHolder<MapDecorationType> ACADEMY = MAP_DECORATION_TYPE.register("academy", () -> new MapDecorationType(FAUtils.resource("academy"), true, 0x7E7E7E, false, true));
    public static final SimpleHolder<MapDecorationType> MACHU_PICCHU = MAP_DECORATION_TYPE.register("machu_picchu", () -> new MapDecorationType(FAUtils.resource("machu_picchu"), true, 0x616161, false, true));
    public static final SimpleHolder<MapDecorationType> MAYAN_TEMPLE = MAP_DECORATION_TYPE.register("mayan_temple", () -> new MapDecorationType(FAUtils.resource("mayan_temple"), true, 0x323232, false, true));
    public static final SimpleHolder<MapDecorationType> WEAPON_SHOP = MAP_DECORATION_TYPE.register("weapon_shop", () -> new MapDecorationType(FAUtils.resource("weapon_shop"), true, 0xB8945F, false, true));
}
