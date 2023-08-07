package willatendo.fossilslegacy.server.item;

import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters;
import net.minecraft.world.item.CreativeModeTab.Output;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import willatendo.simplelibrary.server.util.FillCreativeTab;

public class BrokenFrozenMeatItem extends SwordItem implements FillCreativeTab {
	public BrokenFrozenMeatItem(Tier tier, int baseAttackDamage, float attackSpeed, Properties properties) {
		super(tier, baseAttackDamage, attackSpeed, properties);
	}

	@Override
	public void fillCreativeTab(ItemDisplayParameters itemDisplayParameters, Output output) {		
	}
}
