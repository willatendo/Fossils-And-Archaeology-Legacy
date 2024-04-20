package willatendo.fossilslegacy.server.entity.behaviours;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public record PlayerCommandableInfo(TagKey<Item> commandingItems) {
	public boolean isCommandItem(ItemStack input) {
		return input.is(this.commandingItems);
	}
}
