package willatendo.fossilslegacy.client.screen.recipebook;

import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.core.NonNullList;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.fuel.FuelEntry;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.tags.FAFuelEntryTags;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.Iterator;
import java.util.List;

public class CultivatorRecipeBookComponent extends RecipeBookComponent {
    private static final WidgetSprites FILTER_SPRITES = new WidgetSprites(FossilsLegacyUtils.resource("recipe_book/cultivator_filter_enabled"), FossilsLegacyUtils.resource("recipe_book/cultivator_filter_disabled"), FossilsLegacyUtils.resource("recipe_book/cultivator_filter_enabled_highlighted"), FossilsLegacyUtils.resource("recipe_book/cultivator_filter_disabled_highlighted"));
    private Ingredient fuels;

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
        ItemStack resultItemStack = recipeHolder.value().getResultItem(this.minecraft.level.registryAccess());
        this.ghostRecipe.setRecipe(recipeHolder);
        this.ghostRecipe.addIngredient(Ingredient.of(resultItemStack), slots.get(2).x, slots.get(2).y);
        NonNullList<Ingredient> ingredients = recipeHolder.value().getIngredients();
        Slot fuelSlot = slots.get(1);
        if (fuelSlot.getItem().isEmpty()) {
            if (this.fuels == null) {
                this.fuels = Ingredient.of(FuelEntry.getFuel(this.minecraft.level.holderLookup(FARegistries.FUEL_ENTRY), FAFuelEntryTags.CULTIVATOR).keySet().stream().filter(item -> item.isEnabled(this.minecraft.level.enabledFeatures())).map(ItemStack::new));
            }

            this.ghostRecipe.addIngredient(this.fuels, fuelSlot.x, fuelSlot.y);
        }

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
