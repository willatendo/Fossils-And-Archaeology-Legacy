package willatendo.fossilslegacy.client.screen.recipebook;

import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.core.registry.FossilsLegacyRegistries;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.AnalyzerResult;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Iterator;
import java.util.List;

public class AnalyzerRecipeBookComponent extends RecipeBookComponent {
    private static final WidgetSprites FILTER_SPRITES = new WidgetSprites(FossilsLegacyUtils.resource("recipe_book/analyzer_filter_enabled"), FossilsLegacyUtils.resource("recipe_book/analyzer_filter_disabled"), FossilsLegacyUtils.resource("recipe_book/analyzer_filter_enabled_highlighted"), FossilsLegacyUtils.resource("recipe_book/analyzer_filter_disabled_highlighted"));

    @Override
    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(FILTER_SPRITES);
    }

    @Override
    public void slotClicked(Slot slot) {
        super.slotClicked(slot);
        if (slot != null && slot.index < this.menu.getSize()) {
            this.ghostRecipe.clear();
        }
    }

    @Override
    public void setupGhostRecipe(RecipeHolder<?> recipeHolder, List<Slot> slots) {
        Ingredient results = Ingredient.of(this.minecraft.level.registryAccess().registryOrThrow(FossilsLegacyRegistries.ANALYZER_RESULT).getTag(((AnalyzationRecipe) recipeHolder.value()).results).get().stream().map(Holder::value).map(AnalyzerResult::output).toList().toArray(ItemStack[]::new));
        this.ghostRecipe.setRecipe(recipeHolder);
        this.ghostRecipe.addIngredient(results, slots.get(9).x, slots.get(9).y);
        NonNullList<Ingredient> ingredients = recipeHolder.value().getIngredients();
        Iterator<Ingredient> ingredientIterator = ingredients.iterator();
        for (int i = 0; i < 2; ++i) {
            if (!ingredientIterator.hasNext()) {
                return;
            }
            Ingredient ingredient = ingredientIterator.next();
            if (!ingredient.isEmpty()) {
                Slot slot = slots.get(i);
                this.ghostRecipe.addIngredient(ingredient, slot.x, slot.y);
            }
        }
    }
}
