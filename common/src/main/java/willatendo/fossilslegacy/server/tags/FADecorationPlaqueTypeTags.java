package willatendo.fossilslegacy.server.tags;

import net.minecraft.tags.TagKey;
import willatendo.fossilslegacy.server.decoration_plaque_type.DecorationPlaqueType;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class FADecorationPlaqueTypeTags {
    public static final TagRegister<DecorationPlaqueType> DECORATION_PLAQUE_TYPE_TAGS = TagRegister.create(FARegistries.DECORATION_PLAQUE_TYPE, FAUtils.ID);

    public static final TagKey<DecorationPlaqueType> PLACEABLE = DECORATION_PLAQUE_TYPE_TAGS.register("placeable");
}
