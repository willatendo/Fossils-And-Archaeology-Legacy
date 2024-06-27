package willatendo.fossilslegacy.server;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.variants.*;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRegistries {
    public static final ResourceKey<Registry<BoatType>> BOAT_TYPES = createRegistryKey("boat_types");
    public static final ResourceKey<Registry<EggVariant>> EGG_VARIANTS = createRegistryKey("egg_variants");
    public static final ResourceKey<Registry<PregnancyType>> PREGNANCY_TYPES = createRegistryKey("pregnancy_types");
    public static final ResourceKey<Registry<FossilVariant>> FOSSIL_VARIANTS = createRegistryKey("fossil_variants");
    public static final ResourceKey<Registry<StoneTabletVariant>> STONE_TABLET_VARIANTS = createRegistryKey("stone_tablet_variants");

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String id) {
        return ResourceKey.createRegistryKey(FossilsLegacyUtils.resource(id));
    }
}
