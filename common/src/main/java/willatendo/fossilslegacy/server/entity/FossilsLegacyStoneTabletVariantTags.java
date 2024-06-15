package willatendo.fossilslegacy.server.entity;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.entity.variants.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FossilsLegacyStoneTabletVariantTags {
    public static final TagRegister<StoneTabletVariant> STONE_TABLET_VARIANT_TAGS = TagRegister.create(FossilsLegacyRegistries.STONE_TABLET_VARIANTS, FossilsLegacyUtils.ID);

    public static final TagKey<StoneTabletVariant> PLACEABLE = STONE_TABLET_VARIANT_TAGS.register("placeable");
}
