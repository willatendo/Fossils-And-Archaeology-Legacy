package willatendo.fossilslegacy.server;

import net.minecraft.core.Registry;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.EggVariant;
import willatendo.fossilslegacy.server.entity.FossilVariant;
import willatendo.fossilslegacy.server.entity.StoneTabletVariant;

public class FossilsLegacyBuiltInRegistries {
    public static final Registry<EggVariant> EGG_VARIANTS = FossilsModloaderHelper.INSTANCE.<EggVariant>createRegistry(FossilsLegacyRegistries.EGG_VARIANTS);
    public static final Registry<FossilVariant> FOSSIL_VARIANTS = FossilsModloaderHelper.INSTANCE.<FossilVariant>createRegistry(FossilsLegacyRegistries.FOSSIL_VARIANTS);
    public static final Registry<StoneTabletVariant> STONE_TABLET_VARIANTS = FossilsModloaderHelper.INSTANCE.<StoneTabletVariant>createRegistry(FossilsLegacyRegistries.STONE_TABLET_VARIANTS);

    public static void init() {
    }
}
