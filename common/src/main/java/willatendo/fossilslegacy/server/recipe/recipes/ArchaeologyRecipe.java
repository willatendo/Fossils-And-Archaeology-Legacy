package willatendo.fossilslegacy.server.recipe.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.FARecipeBookCategories;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.menu.categories.ArchaeologyBookCategory;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.display.AnalyzationRecipeDisplay;
import willatendo.fossilslegacy.server.recipe.display.ArchaeologyRecipeDisplay;
import willatendo.fossilslegacy.server.recipe.display.FuelDisplay;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;

import java.util.List;

public class ArchaeologyRecipe implements Recipe<SingleRecipeInput> {
    public final ArchaeologyBookCategory archaeologyBookCategory;
    public final Ingredient ingredient;
    public final ItemStack result;
    public final int time;
    public String group;

    public ArchaeologyRecipe(ArchaeologyBookCategory archaeologyBookCategory, String group, Ingredient ingredient, ItemStack result, int time) {
        this.archaeologyBookCategory = archaeologyBookCategory;
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
        return FARecipeSerialisers.ARCHAEOLOGY.get();
    }

    @Override
    public RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return FARecipeTypes.ARCHAEOLOGY.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.ingredient);
    }

    @Override
    public List<RecipeDisplay> display() {
        return List.of(new ArchaeologyRecipeDisplay(this.ingredient.display(), new FuelDisplay(FAFuelEntryTags.ARCHAEOLOGY_WORKBENCH), new SlotDisplay.ItemStackSlotDisplay(this.result), new SlotDisplay.ItemSlotDisplay(FABlocks.ARCHAEOLOGY_WORKBENCH.get().asItem()), this.time));
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        RecipeBookCategory recipeBookCategory;
        switch (this.archaeologyBookCategory) {
            case REPAIR -> recipeBookCategory = FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR.get();
            case RESTORE -> recipeBookCategory = FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE.get();
            case MISC -> recipeBookCategory = FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC.get();
            default -> throw new MatchException(null, null);
        }
        return recipeBookCategory;
    }
}
