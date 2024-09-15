package willatendo.fossilslegacy.server.entity;

import net.minecraft.core.Holder;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.syncher.EntityDataSerializer;
import willatendo.fossilslegacy.platform.FossilsModloaderHelper;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;

import java.util.function.Supplier;

public class FossilsLegacyEntityDataSerializers {
    public static final Supplier<EntityDataSerializer<Holder<EggVariant>>> EGG_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("egg_variants", ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.EGG_VARIANTS));
    public static final Supplier<EntityDataSerializer<Holder<PregnancyType>>> PREGNANCY_TYPES = FossilsModloaderHelper.INSTANCE.registerDataSerializer("pregnancy_types", ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.PREGNANCY_TYPES));
    public static final Supplier<EntityDataSerializer<Holder<FossilVariant>>> FOSSIL_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("fossil_variants", ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.FOSSIL_VARIANTS));
    public static final Supplier<EntityDataSerializer<Holder<StoneTabletVariant>>> STONE_TABLET_VARIANTS = FossilsModloaderHelper.INSTANCE.registerDataSerializer("stone_tablet_variants", ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.STONE_TABLET_VARIANTS));
    public static final Supplier<EntityDataSerializer<Holder<CoatType>>> COAT_TYPES = FossilsModloaderHelper.INSTANCE.registerDataSerializer("coat_types", ByteBufCodecs.holderRegistry(FossilsLegacyRegistries.COAT_TYPES));

    public static void init() {
    }
}
