package willatendo.fossilslegacy.server;

import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.entity.EggVariant;
import willatendo.fossilslegacy.server.entity.FossilVariant;
import willatendo.fossilslegacy.server.entity.PregnancyType;
import willatendo.fossilslegacy.server.entity.StoneTabletVariant;

public class FossilsLegacyBuiltInRegistries {
    public static final RegistryHolder<EggVariant> EGG_VARIANTS = FossilsModloaderHelper.INSTANCE.createRegistry(FossilsLegacyRegistries.EGG_VARIANTS);
    public static final RegistryHolder<PregnancyType> PREGNANCY_TYPES = FossilsModloaderHelper.INSTANCE.createRegistry(FossilsLegacyRegistries.PREGNANCY_TYPES);
    public static final RegistryHolder<FossilVariant> FOSSIL_VARIANTS = FossilsModloaderHelper.INSTANCE.createRegistry(FossilsLegacyRegistries.FOSSIL_VARIANTS);
    public static final RegistryHolder<StoneTabletVariant> STONE_TABLET_VARIANTS = FossilsModloaderHelper.INSTANCE.<StoneTabletVariant>createRegistry(FossilsLegacyRegistries.STONE_TABLET_VARIANTS);

    public static void init() {
    }
}
