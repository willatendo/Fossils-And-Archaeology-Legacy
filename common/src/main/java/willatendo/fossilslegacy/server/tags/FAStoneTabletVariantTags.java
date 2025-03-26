package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.stone_tablet_variant.StoneTabletVariant;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FAStoneTabletVariantTags {
    public static final TagRegister<StoneTabletVariant> STONE_TABLET_VARIANT_TAGS = TagRegister.create(FARegistries.STONE_TABLET_VARIANT, FAUtils.ID);

    public static final TagKey<StoneTabletVariant> PLACEABLE = STONE_TABLET_VARIANT_TAGS.register("placeable");
}
