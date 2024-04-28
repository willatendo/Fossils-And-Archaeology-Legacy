package willatendo.fossilslegacy.server.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class TherizinosaurusClawsItem extends DiggerItem {
    public TherizinosaurusClawsItem(float attackDamage, float attackSpeed, Tier tier, Item.Properties properties) {
        super(attackDamage, attackSpeed, tier, BlockTags.MINEABLE_WITH_HOE, properties);
    }
}
