package willatendo.fossilslegacy.server;

import net.minecraft.core.Registry;
import willatendo.fossilslegacy.server.entity.variants.EggVariant;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.entity.variants.PregnancyType;
import willatendo.simplelibrary.server.util.SimpleRegistryBuilder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyBuiltInRegistries {
    public static final Registry<EggVariant> EGG_VARIANTS = SimpleUtils.createRegistry(FossilsLegacyRegistries.EGG_VARIANTS, SimpleRegistryBuilder.of().sync());
    public static final Registry<PregnancyType> PREGNANCY_TYPES = SimpleUtils.createRegistry(FossilsLegacyRegistries.PREGNANCY_TYPES, SimpleRegistryBuilder.of().sync());
    public static final Registry<FossilVariant> FOSSIL_VARIANTS = SimpleUtils.createRegistry(FossilsLegacyRegistries.FOSSIL_VARIANTS, SimpleRegistryBuilder.of().sync());

    public static void init() {
    }
}
