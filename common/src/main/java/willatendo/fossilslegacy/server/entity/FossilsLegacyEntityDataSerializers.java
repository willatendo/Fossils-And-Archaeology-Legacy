package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataSerializer;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.FossilsLegacyBuiltInRegistries;

import java.util.function.Supplier;

public class FossilsLegacyEntityDataSerializers {
    public static final Supplier<EntityDataSerializer<EggVariant>> EGG_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("egg_variants", FossilsLegacyBuiltInRegistries.EGG_VARIANTS);
    public static final Supplier<EntityDataSerializer<PregnancyType>> PREGNANCY_TYPES = FossilsModloaderHelper.INSTANCE.registerDataSerializer("pregnancy_types", FossilsLegacyBuiltInRegistries.PREGNANCY_TYPES);
    public static final Supplier<EntityDataSerializer<FossilVariant>> FOSSIL_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("fossil_variants", FossilsLegacyBuiltInRegistries.FOSSIL_VARIANTS);
    public static final Supplier<EntityDataSerializer<Holder<StoneTabletVariant>>> STONE_TABLET_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("stone_tablet_variants", FossilsLegacyBuiltInRegistries.STONE_TABLET_VARIANTS.asHolderIdMap());

    public static void init() {
    }
}
