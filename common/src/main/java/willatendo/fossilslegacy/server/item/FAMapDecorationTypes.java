package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class FAMapDecorationTypes {
    public static final Holder<MapDecorationType> ACADEMY = FossilsModloaderHelper.INSTANCE.registerMapDecorationType("academy", () -> new MapDecorationType(FAUtils.resource("academy"), true, 0x7E7E7E, false, true));
    public static final Holder<MapDecorationType> MACHU_PICCHU = FossilsModloaderHelper.INSTANCE.registerMapDecorationType("machu_picchu", () -> new MapDecorationType(FAUtils.resource("machu_picchu"), true, 0x616161, false, true));
    public static final Holder<MapDecorationType> MAYAN_TEMPLE = FossilsModloaderHelper.INSTANCE.registerMapDecorationType("mayan_temple", () -> new MapDecorationType(FAUtils.resource("mayan_temple"), true, 0x323232, false, true));
    public static final Holder<MapDecorationType> WEAPON_SHOP = FossilsModloaderHelper.INSTANCE.registerMapDecorationType("weapon_shop", () -> new MapDecorationType(FAUtils.resource("weapon_shop"), true, 0xB8945F, false, true));

    public static void init() {
    }
}
