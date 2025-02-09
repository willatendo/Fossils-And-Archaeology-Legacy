package willatendo.fossilslegacy.client.screen.recipebook;

import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.GhostSlots;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.network.chat.Component;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.crafting.display.FurnaceRecipeDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import willatendo.fossilslegacy.server.menu.menus.AnalyzerMenu;
import willatendo.fossilslegacy.server.recipe.display.AnalyzationRecipeDisplay;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class AnalyzerRecipeBookComponent extends RecipeBookComponent<AnalyzerMenu> {
    private static final WidgetSprites FILTER_SPRITES = new WidgetSprites(FAUtils.resource("recipe_book/analyzer_filter_enabled"), FAUtils.resource("recipe_book/analyzer_filter_disabled"), FAUtils.resource("recipe_book/analyzer_filter_enabled_highlighted"), FAUtils.resource("recipe_book/analyzer_filter_disabled_highlighted"));
    private final Component recipeFilterName;

    public AnalyzerRecipeBookComponent(AnalyzerMenu analyzerMenu, Component recipeFilterName, List<RecipeBookComponent.TabInfo> tabInfos) {
        super(analyzerMenu, tabInfos);
        this.recipeFilterName = recipeFilterName;
    }

    @Override
    protected void initFilterButtonTextures() {
        this.filterButton.initTextureValues(FILTER_SPRITES);
    }

    @Override
    protected boolean isCraftingSlot(Slot slot) {
        boolean craftingSlot;
        switch (slot.index) {
            case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 -> craftingSlot = true;
            default -> craftingSlot = false;
        }

        return craftingSlot;
    }

    @Override
    protected Component getRecipeFilterName() {
        return this.recipeFilterName;
    }

    @Override
    protected void fillGhostRecipe(GhostSlots ghostSlots, RecipeDisplay recipeDisplay, ContextMap contextMap) {
        ghostSlots.setResult(this.menu.slots.get(10), contextMap, recipeDisplay.result());
        if (recipeDisplay instanceof FurnaceRecipeDisplay furnacerecipedisplay) {
            ghostSlots.setInput(this.menu.slots.get(0), contextMap, furnacerecipedisplay.ingredient());
        }
    }

    @Override
    protected void selectMatchingRecipes(RecipeCollection recipeCollection, StackedItemContents stackedItemContents) {
        recipeCollection.selectRecipes(stackedItemContents, recipeDisplay -> recipeDisplay instanceof AnalyzationRecipeDisplay);
    }
}
