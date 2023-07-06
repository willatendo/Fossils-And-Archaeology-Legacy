package fossilslegacy.server.item;

import net.minecraft.world.item.Tier;

public class BrokenJavelinItem extends JavelinItem {
	public BrokenJavelinItem(Tier tier, Properties properties) {
		super(tier, properties.defaultDurability(tier.getUses() / 2));
	}
}
