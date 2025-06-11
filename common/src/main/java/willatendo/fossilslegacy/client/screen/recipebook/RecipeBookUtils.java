package willatendo.fossilslegacy.client.screen.recipebook;

import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import willatendo.fossilslegacy.client.FASearchRecipeBookCategory;

import java.util.Optional;

public class RecipeBookUtils {
    public static RecipeBookComponent.TabInfo createSearch(FASearchRecipeBookCategory faSearchRecipeBookCategory) {
        return new RecipeBookComponent.TabInfo(new ItemStack(Items.COMPASS), Optional.empty(), faSearchRecipeBookCategory);
    }
}
