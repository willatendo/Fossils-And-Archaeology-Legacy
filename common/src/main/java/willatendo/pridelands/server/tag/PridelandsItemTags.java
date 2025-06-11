package willatendo.pridelands.server.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import willatendo.pridelands.server.utils.PridelandsUtils;
import willatendo.simplelibrary.server.util.TagRegister;

public class PridelandsItemTags {
    private static final TagRegister<Item> ITEM_TAGS = TagRegister.create(Registries.ITEM, PridelandsUtils.ID);

    public static final TagKey<Item> OPENS_BONGO = ITEM_TAGS.register("opens_bongo");
}
