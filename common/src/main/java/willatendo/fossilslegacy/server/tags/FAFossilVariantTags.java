package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAFossilVariantTags {
    private static final TagRegister<FossilVariant> FOSSIL_VARIANT_TAGS = TagRegister.create(FARegistries.FOSSIL_VARIANTS, FAUtils.ID);

    public static final TagKey<FossilVariant> CENOZOIC = FOSSIL_VARIANT_TAGS.register("cenozoic");
    public static final TagKey<FossilVariant> MESOZOIC = FOSSIL_VARIANT_TAGS.register("mesozoic");
    public static final TagKey<FossilVariant> PALAEOZOIC = FOSSIL_VARIANT_TAGS.register("palaeozoic");
}
