package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataSerializer;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;

public class FossilsLegacyEntityDataSerializers {
    public static final EntityDataSerializer<EggVariant> EGG_VARIANTS = EntityDataSerializer.simpleId(FossilsLegacyBuiltInRegistries.EGG_VARIANTS);
    public static final EntityDataSerializer<FossilVariant> FOSSIL_VARIANTS = EntityDataSerializer.simpleId(FossilsLegacyBuiltInRegistries.FOSSIL_VARIANTS);
    public static final EntityDataSerializer<Holder<StoneTabletVariant>> STONE_TABLET_VARIANTS = EntityDataSerializer.simpleId(FossilsLegacyBuiltInRegistries.STONE_TABLET_VARIANTS.asHolderIdMap());

    public static void init() {
        FossilsModloaderHelper.INSTANCE.registerDataSerializer("egg_variants", EGG_VARIANTS);
        FossilsModloaderHelper.INSTANCE.registerDataSerializer("fossil_variants", FOSSIL_VARIANTS);
        FossilsModloaderHelper.INSTANCE.registerDataSerializer("stone_tablet_variants", STONE_TABLET_VARIANTS);
    }
}
