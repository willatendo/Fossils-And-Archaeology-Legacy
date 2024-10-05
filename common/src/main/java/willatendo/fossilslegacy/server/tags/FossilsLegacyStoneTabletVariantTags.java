package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyStoneTabletVariantTags {
    public static final TagRegister<StoneTabletVariant> STONE_TABLET_VARIANT_TAGS = TagRegister.create(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, FossilsLegacyUtils.ID);

    public static final TagKey<StoneTabletVariant> PLACEABLE = STONE_TABLET_VARIANT_TAGS.register("placeable");
}
