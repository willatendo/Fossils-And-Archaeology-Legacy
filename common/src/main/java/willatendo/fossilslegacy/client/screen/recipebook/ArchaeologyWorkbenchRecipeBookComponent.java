package willatendo.fossilslegacy.client.screen.recipebook;

import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.GhostSlots;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.network.chat.Component;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import willatendo.fossilslegacy.server.menu.menus.ArchaeologyWorkbenchMenu;
import willatendo.fossilslegacy.server.recipe.display.ArchaeologyRecipeDisplay;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class ArchaeologyWorkbenchRecipeBookComponent extends RecipeBookComponent<ArchaeologyWorkbenchMenu> {
    private static final WidgetSprites FILTER_SPRITES = new WidgetSprites(FAUtils.resource("recipe_book/archaeology_filter_enabled"), FAUtils.resource("recipe_book/archaeology_filter_disabled"), FAUtils.resource("recipe_book/archaeology_filter_enabled_highlighted"), FAUtils.resource("recipe_book/archaeology_filter_disabled_highlighted"));
    private final Component recipeFilterName;

    public ArchaeologyWorkbenchRecipeBookComponent(ArchaeologyWorkbenchMenu archaeologyWorkbenchMenu, Component recipeFilterName, List<RecipeBookComponent.TabInfo> tabInfos) {
        super(archaeologyWorkbenchMenu, tabInfos);
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
            case 0, 1, 2 -> craftingSlot = true;
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
        ghostSlots.setResult(this.menu.slots.get(2), contextMap, recipeDisplay.result());
        if (recipeDisplay instanceof ArchaeologyRecipeDisplay archaeologyRecipeDisplay) {
            ghostSlots.setInput(this.menu.slots.get(0), contextMap, archaeologyRecipeDisplay.ingredient());
            Slot slot = this.menu.slots.get(1);
            if (slot.getItem().isEmpty()) {
                ghostSlots.setInput(slot, contextMap, archaeologyRecipeDisplay.fuel());
            }
        }
    }

    @Override
    protected void selectMatchingRecipes(RecipeCollection recipeCollection, StackedItemContents stackedItemContents) {
        recipeCollection.selectRecipes(stackedItemContents, recipeDisplay -> recipeDisplay instanceof ArchaeologyRecipeDisplay);
    }
}
