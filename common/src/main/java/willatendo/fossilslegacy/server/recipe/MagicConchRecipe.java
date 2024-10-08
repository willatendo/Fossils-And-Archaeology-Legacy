package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.entity.commands.CommandType;
import willatendo.fossilslegacy.server.entity.commands.FossilsLegacyCommandTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.item.MagicConchItem;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;

public class MagicConchRecipe extends CustomRecipe {
    public MagicConchRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        ItemStack itemStack = ItemStack.EMPTY;

        for (int slot = 0; slot < craftingInput.size(); ++slot) {
            ItemStack itemStackInSlot = craftingInput.getItem(slot);
            if (itemStackInSlot.is(FossilsLegacyItems.MAGIC_CONCH.get())) {
                itemStack = itemStackInSlot;
            }
        }

        return !itemStack.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        ItemStack itemStack = FossilsLegacyItems.MAGIC_CONCH.get().getDefaultInstance();
        Holder<CommandType> nextOrder = FossilsLegacyCommandTypes.FOLLOW;

        for (int slot = 0; slot < craftingInput.size(); ++slot) {
            ItemStack itemStackInSlot = craftingInput.getItem(slot);
            if (!itemStackInSlot.isEmpty() && itemStackInSlot.getItem() instanceof MagicConchItem) {
                nextOrder = CommandType.getNext(MagicConchItem.getOrder(itemStackInSlot));
            }
        }

        itemStack.set(FossilsLegacyDataComponents.COMMAND_TYPE.get(), nextOrder);

        return itemStack;
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
