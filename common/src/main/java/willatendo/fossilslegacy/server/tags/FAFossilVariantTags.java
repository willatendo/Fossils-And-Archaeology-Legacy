package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAFossilVariantTags {
    private static final TagRegister<FossilVariant> FOSSIL_VARIANT_TAGS = TagRegister.create(FARegistries.FOSSIL_VARIANTS, FossilsLegacyUtils.ID);

    public static final TagKey<FossilVariant> PLACEABLE_FROM_FOSSIL = FOSSIL_VARIANT_TAGS.register("placeable_from_fossil");
}
