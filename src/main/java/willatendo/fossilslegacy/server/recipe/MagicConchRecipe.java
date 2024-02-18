package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.MagicConchItem;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.utils.DinosaurCommand;

public class MagicConchRecipe extends CustomRecipe {
	public MagicConchRecipe(CraftingBookCategory craftingBookCategory) {
		super(craftingBookCategory);
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
	public ItemStack assemble(CraftingContainer craftingContainer, RegistryAccess registryAccess) {
		ItemStack itemstack = FossilsLegacyItems.MAGIC_CONCH.get().getDefaultInstance();
		CompoundTag compoundTag = itemstack.getOrCreateTag();
		String nextOrder = DinosaurCommand.FOLLOW.getOrder();

		for (int slot = 0; slot < craftingContainer.getContainerSize(); ++slot) {
			ItemStack itemStackInSlot = craftingContainer.getItem(slot);
			if (!itemStackInSlot.isEmpty() && itemStackInSlot.getItem() instanceof MagicConchItem) {
				DinosaurCommand dinosaurOrder = MagicConchItem.getOrder(itemStackInSlot);
				if (dinosaurOrder == DinosaurCommand.FOLLOW) {
					nextOrder = DinosaurCommand.STAY.getOrder();
				}
				if (dinosaurOrder == DinosaurCommand.STAY) {
					nextOrder = DinosaurCommand.FREE_MOVE.getOrder();
				}
				if (dinosaurOrder == DinosaurCommand.FREE_MOVE) {
					nextOrder = DinosaurCommand.FOLLOW.getOrder();
				}
			}
		}

		compoundTag.putString("Command", nextOrder);

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
