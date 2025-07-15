package willatendo.fossilslegacy.server.recipe.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.items.KeyItem;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;
import willatendo.fossilslegacy.server.tags.FAItemTags;

import java.util.UUID;

public class KeyCloningRecipe extends CustomRecipe {
    public KeyCloningRecipe(CraftingBookCategory craftingBookCategory) {
        super(craftingBookCategory);
    }

    @Override
    public boolean matches(CraftingInput craftingInput, Level level) {
        if (craftingInput.ingredientCount() < 2) {
            return false;
        } else {
            boolean hasKeyWithoutCode = false;
            boolean hasKeyWithCode = false;

            for (int i = 0; i < craftingInput.size(); ++i) {
                ItemStack slot = craftingInput.getItem(i);
                if (!slot.isEmpty()) {
                    if (slot.is(FAItemTags.KEY) && slot.has(FADataComponents.LOCK.get())) {
                        if (hasKeyWithCode) {
                            return false;
                        }

                        hasKeyWithCode = true;
                    } else {
                        if (!(slot.is(FAItemTags.KEY) && !slot.has(FADataComponents.LOCK.get()))) {
                            return false;
                        }

                        hasKeyWithoutCode = true;
                    }
                }
            }

            return hasKeyWithCode && hasKeyWithoutCode;
        }
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
        int i = 0;
        ItemStack itemStack = ItemStack.EMPTY;
        Item type = null;

        for (int j = 0; j < craftingInput.size(); ++j) {
            ItemStack slot = craftingInput.getItem(j);
            if (!slot.isEmpty()) {
                if (slot.is(FAItemTags.KEY) && slot.has(FADataComponents.LOCK.get())) {
                    if (!itemStack.isEmpty()) {
                        return ItemStack.EMPTY;
                    }

                    itemStack = slot;
                } else {
                    if (!(slot.is(FAItemTags.KEY) && !slot.has(FADataComponents.LOCK.get()))) {
                        return ItemStack.EMPTY;
                    }

                    if (slot.is(FAItemTags.KEY) && slot.has(FADataComponents.LOCK.get())) {
                        type = slot.getItem();
                    }

                    ++i;
                }
            }
        }

        UUID code = itemStack.get(FADataComponents.LOCK.get());
        if (!itemStack.isEmpty() && i >= 1 && code != null && type != null) {
            ItemStack copy = new ItemStack(type);
            copy.set(FADataComponents.LOCK.get(), code);
            return copy;
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput craftingInput) {
        NonNullList<ItemStack> items = NonNullList.withSize(craftingInput.size(), ItemStack.EMPTY);

        for (int i = 0; i < items.size(); ++i) {
            ItemStack slot = craftingInput.getItem(i);
            ItemStack slotCraftingRemainder = slot.getItem().getCraftingRemainder();
            if (!slotCraftingRemainder.isEmpty()) {
                items.set(i, slotCraftingRemainder);
            } else if (slot.getItem() instanceof KeyItem) {
                items.set(i, slot.copyWithCount(1));
                break;
            }
        }

        return items;
    }

    @Override
    public RecipeSerializer<KeyCloningRecipe> getSerializer() {
        return FARecipeSerialisers.KEY_CLONING.get();
    }
}
