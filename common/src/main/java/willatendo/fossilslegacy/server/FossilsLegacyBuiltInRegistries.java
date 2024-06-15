package willatendo.fossilslegacy.server;

import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.simplelibrary.server.util.RegistryHolder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyBuiltInRegistries {
    public static final RegistryHolder<EggVariant> EGG_VARIANTS = SimpleUtils.createRegistry(FossilsLegacyRegistries.EGG_VARIANTS);
    public static final RegistryHolder<PregnancyType> PREGNANCY_TYPES = SimpleUtils.createRegistry(FossilsLegacyRegistries.PREGNANCY_TYPES);
    public static final RegistryHolder<FossilVariant> FOSSIL_VARIANTS = SimpleUtils.createRegistry(FossilsLegacyRegistries.FOSSIL_VARIANTS);
    public static final RegistryHolder<StoneTabletVariant> STONE_TABLET_VARIANTS = SimpleUtils.<StoneTabletVariant>createRegistry(FossilsLegacyRegistries.STONE_TABLET_VARIANTS);

    public static void init() {
    }
}
