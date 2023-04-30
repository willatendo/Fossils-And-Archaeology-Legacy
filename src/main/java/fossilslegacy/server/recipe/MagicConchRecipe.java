package fossilslegacy.server.recipe;

import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.item.MagicConchItem;
import fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import fossilslegacy.server.utils.DinosaurOrder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class MagicConchRecipe extends CustomRecipe {
	public MagicConchRecipe(ResourceLocation id, CraftingBookCategory craftingBookCategory) {
		super(id, craftingBookCategory);
	}

	@Override
	public boolean matches(CraftingContainer craftingContainer, Level level) {
		ItemStack itemStack = ItemStack.EMPTY;

		for (int slot = 0; slot < craftingContainer.getContainerSize(); ++slot) {
			ItemStack itemStackInSlot = craftingContainer.getItem(slot);
			if (itemStackInSlot.is(FossilsLegacyItems.MAGIC_CONCH.get())) {
				itemStack = itemStackInSlot;
			}
		}

		return !itemStack.isEmpty();
	}

	@Override
	public ItemStack assemble(CraftingContainer craftingContainer) {
		ItemStack itemstack = FossilsLegacyItems.MAGIC_CONCH.get().getDefaultInstance();
		CompoundTag compoundTag = itemstack.getOrCreateTag();
		int nextOrder = 0;

		for (int slot = 0; slot < craftingContainer.getContainerSize(); ++slot) {
			ItemStack itemStackInSlot = craftingContainer.getItem(slot);
			if (!itemStackInSlot.isEmpty() && itemStackInSlot.getItem() instanceof MagicConchItem) {
				DinosaurOrder dinosaurOrder = MagicConchItem.getOrder(itemStackInSlot);
				if (dinosaurOrder == DinosaurOrder.FOLLOW) {
					nextOrder = DinosaurOrder.STAY.ordinal();
				}
				if (dinosaurOrder == DinosaurOrder.STAY) {
					nextOrder = DinosaurOrder.FREE_MOVE.ordinal();
				}
				if (dinosaurOrder == DinosaurOrder.FREE_MOVE) {
					nextOrder = DinosaurOrder.FOLLOW.ordinal();
				}
			}
		}

		compoundTag.putInt("Order", nextOrder);

		return itemstack;
	}

	@Override
	public boolean canCraftInDimensions(int x, int y) {
		return x * y == 1;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return FossilsLegacyRecipeSerialisers.MAGIC_CONCH.get();
	}
}
