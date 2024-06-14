package willatendo.fossilslegacy.server.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class TherizinosaurusClawsItem extends DiggerItem {
    public TherizinosaurusClawsItem(Tier tier, Item.Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_HOE, properties);
    }
}
