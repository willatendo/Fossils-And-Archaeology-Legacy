package willatendo.fossilslegacy.server.jei.recipe;

import net.minecraft.world.item.ItemStack;

public class FeederRecipe {
	private final ItemStack itemStack;
	private final int foodLevel;
	private boolean meat;

	public FeederRecipe(ItemStack itemStack, int foodLevel, boolean meat) {
		this.itemStack = itemStack;
		this.foodLevel = foodLevel;
		this.meat = meat;
	}

	public ItemStack getItemStack() {
		return this.itemStack;
	}

	public int getFoodLevel() {
		return this.foodLevel;
	}

	public boolean isMeat() {
		return this.meat;
	}
}
