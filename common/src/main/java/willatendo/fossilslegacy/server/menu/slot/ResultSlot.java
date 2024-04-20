package willatendo.fossilslegacy.server.menu.slot;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ResultSlot extends Slot {
	private final Player player;
	private int removeCount;

	public ResultSlot(Player player, Container container, int slot, int x, int y) {
		super(container, slot, x, y);
		this.player = player;
	}

	@Override
	public boolean mayPlace(ItemStack itemStack) {
		return false;
	}

	@Override
	public ItemStack remove(int slot) {
		if (this.hasItem()) {
			this.removeCount += Math.min(slot, this.getItem().getCount());
		}

		return super.remove(slot);
	}

	@Override
	public void onTake(Player player, ItemStack itemStack) {
		this.checkTakeAchievements(itemStack);
		super.onTake(player, itemStack);
	}

	@Override
	protected void onQuickCraft(ItemStack itemStack, int slot) {
		this.removeCount += slot;
		this.checkTakeAchievements(itemStack);
	}

	@Override
	protected void checkTakeAchievements(ItemStack itemStack) {
		itemStack.onCraftedBy(this.player.level(), this.player, this.removeCount);
		this.removeCount = 0;
	}
}
