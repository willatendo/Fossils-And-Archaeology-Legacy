package willatendo.fossilslegacy.server.recipe.recipes;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.command_type.CommandType;
import willatendo.fossilslegacy.server.command_type.FACommandTypes;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.items.MagicConchItem;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;

public class MagicConchRecipe extends CustomRecipe {
    public MagicConchRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        ItemStack itemStack = ItemStack.EMPTY;

        for (int slot = 0; slot < craftingInput.size(); ++slot) {
            ItemStack itemStackInSlot = craftingInput.getItem(slot);
            if (itemStackInSlot.is(FAItems.MAGIC_CONCH.get())) {
                itemStack = itemStackInSlot;
            }
        }

        return !itemStack.isEmpty();
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        ItemStack itemStack = FAItems.MAGIC_CONCH.get().getDefaultInstance();
        Holder<CommandType> nextOrder = FACommandTypes.FOLLOW;

        for (int slot = 0; slot < craftingInput.size(); ++slot) {
            ItemStack itemStackInSlot = craftingInput.getItem(slot);
            if (!itemStackInSlot.isEmpty() && itemStackInSlot.getItem() instanceof MagicConchItem) {
                nextOrder = CommandType.getNext(MagicConchItem.getOrder(itemStackInSlot));
            }
        }

        itemStack.set(FADataComponents.COMMAND_TYPE.get(), nextOrder);

        return itemStack;
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return FARecipeSerialisers.MAGIC_CONCH.get();
    }
}
