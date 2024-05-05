package willatendo.fossilslegacy.server.entity;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyFossilVariantTags {
    public static final TagRegister<FossilVariant> FOSSIL_VARIANT_TAGS = TagRegister.create(FossilsLegacyRegistries.FOSSIL_VARIANTS, FossilsLegacyUtils.ID);

    public static final TagKey<FossilVariant> PLACEABLE_FROM_FOSSIL = FOSSIL_VARIANT_TAGS.register("placeable_from_fossil");
}
