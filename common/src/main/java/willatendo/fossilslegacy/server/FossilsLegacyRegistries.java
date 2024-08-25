package willatendo.fossilslegacy.server;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.entity.genetics.CoatType;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRegistries {
    public static final ResourceKey<Registry<EggVariant>> EGG_VARIANTS = FossilsLegacyRegistries.createRegistryKey("egg_variants");
    public static final ResourceKey<Registry<PregnancyType>> PREGNANCY_TYPES = FossilsLegacyRegistries.createRegistryKey("pregnancy_types");
    public static final ResourceKey<Registry<FossilVariant>> FOSSIL_VARIANTS = FossilsLegacyRegistries.createRegistryKey("fossil_variants");
    public static final ResourceKey<Registry<StoneTabletVariant>> STONE_TABLET_VARIANTS = FossilsLegacyRegistries.createRegistryKey("stone_tablet_variants");
    public static final ResourceKey<Registry<CoatType>> COAT_TYPES = FossilsLegacyRegistries.createRegistryKey("coat_types");

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String id) {
        return ResourceKey.createRegistryKey(FossilsLegacyUtils.resource(id));
    }
}
