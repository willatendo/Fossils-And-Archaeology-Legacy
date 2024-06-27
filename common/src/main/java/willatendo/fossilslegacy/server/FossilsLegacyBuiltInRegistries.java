package willatendo.fossilslegacy.server;

import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.entity.variants.*;
import willatendo.simplelibrary.server.util.SimpleRegistryBuilder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyBuiltInRegistries {
    public static final Registry<BoatType> BOAT_TYPES = SimpleUtils.createRegistry(FossilsLegacyRegistries.BOAT_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<EggVariant> EGG_VARIANTS = SimpleUtils.createRegistry(FossilsLegacyRegistries.EGG_VARIANTS, SimpleRegistryBuilder.of().sync());
    public static final Registry<PregnancyType> PREGNANCY_TYPES = SimpleUtils.createRegistry(FossilsLegacyRegistries.PREGNANCY_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<FossilVariant> FOSSIL_VARIANTS = SimpleUtils.createRegistry(FossilsLegacyRegistries.FOSSIL_VARIANTS, SimpleRegistryBuilder.of().sync());
    public static final Registry<StoneTabletVariant> STONE_TABLET_VARIANTS = SimpleUtils.<StoneTabletVariant>createRegistry(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, SimpleRegistryBuilder.of().sync());

    public static void init() {
    }
}
