package willatendo.fossilslegacy.server.item;

import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.Tier;
import willatendo.simplelibrary.server.creativemodetab.FillCreativeTab;

public class BrokenJavelinItem extends JavelinItem implements FillCreativeTab {
	public BrokenJavelinItem(Tier tier, Properties properties) {
		super(tier, properties.defaultDurability(tier.getUses() / 2));
	}

	@Override
	public void fillCreativeTab(ItemDisplayParameters itemDisplayParameters, Output output) {
	}
}
