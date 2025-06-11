package willatendo.fossilslegacy.server.recipe.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.FARecipeBookCategories;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.menu.categories.CultivationBookCategory;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.display.CultivationRecipeDisplay;
import willatendo.fossilslegacy.server.recipe.display.FuelDisplay;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;

import java.util.List;

public class CultivationRecipe implements Recipe<SingleRecipeInput> {
    public final CultivationBookCategory cultivationBookCategory;
    public final Ingredient ingredient;
    public final ItemStack result;
    public final int time;
    public String group;

    public CultivationRecipe(CultivationBookCategory cultivationBookCategory, String group, Ingredient ingredient, ItemStack result, int time) {
        this.cultivationBookCategory = cultivationBookCategory;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public boolean matches(SingleRecipeInput singleRecipeInput, Level level) {
        return this.ingredient.test(singleRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(SingleRecipeInput singleRecipeInput, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleRecipeInput>> getSerializer() {
        return FARecipeSerialisers.CULTIVATION.get();
    }

    @Override
    public RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return FARecipeTypes.CULTIVATION.get();
    }


    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.ingredient);
    }

    @Override
    public List<RecipeDisplay> display() {
        return List.of(new CultivationRecipeDisplay(this.ingredient.display(), new FuelDisplay(FAFuelEntryTags.CULTIVATOR), new SlotDisplay.ItemStackSlotDisplay(this.result), new SlotDisplay.ItemSlotDisplay(FABlocks.LIME_CULTIVATOR.get().asItem()), this.time));
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        RecipeBookCategory recipeBookCategory;
        switch (this.cultivationBookCategory) {
            case EGG -> recipeBookCategory = FARecipeBookCategories.CULTIVATION_EGGS.get();
            case PLANT -> recipeBookCategory = FARecipeBookCategories.CULTIVATION_PLANTS.get();
            case MISC -> recipeBookCategory = FARecipeBookCategories.CULTIVATION_MISC.get();
            default -> throw new MatchException(null, null);
        }
        return recipeBookCategory;
    }
}
