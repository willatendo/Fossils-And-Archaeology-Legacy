package willatendo.fossilslegacy.server.jei.recipe;

import java.util.List;

import net.minecraft.world.item.ItemStack;

public class BiomatterRecipe {
	private final List<ItemStack> itemStacks;
	private final int biomatterUseTime;

	public BiomatterRecipe(ItemStack itemStack, int biomatterUseTime) {
		this(List.of(itemStack), biomatterUseTime);
	}

	public BiomatterRecipe(List<ItemStack> itemStacks, int biomatterUseTime) {
		this.itemStacks = itemStacks;
		this.biomatterUseTime = biomatterUseTime;
	}

	public List<ItemStack> getItemStack() {
		return this.itemStacks;
	}

	public int getBiomatterUseTime() {
		return this.biomatterUseTime;
	}
}
