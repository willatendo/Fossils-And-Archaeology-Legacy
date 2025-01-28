package willatendo.fossilslegacy.server.item.items;

import net.minecraft.world.item.Tier;

public class BrokenJavelinItem extends JavelinItem {
    public BrokenJavelinItem(Tier tier, Properties properties) {
        super(tier, properties.durability(tier.getUses() / 2));
    }
}
