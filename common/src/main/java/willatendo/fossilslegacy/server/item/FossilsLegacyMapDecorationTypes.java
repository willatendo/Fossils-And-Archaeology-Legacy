package willatendo.fossilslegacy.server.item;

import net.minecraft.core.Holder;
import net.minecraft.world.level.saveddata.maps.MapDecorationType;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyMapDecorationTypes {
    public static final Holder<MapDecorationType> MAYAN_TEMPLE = FossilsModloaderHelper.INSTANCE.registerMapDecorationType("mayan_temple", () -> new MapDecorationType(FossilsLegacyUtils.resource("mayan_temple"), true, 0x323232, false, true));

    public static void init() {
    }
}
