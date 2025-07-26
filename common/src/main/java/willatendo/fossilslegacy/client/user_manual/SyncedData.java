package willatendo.fossilslegacy.client.user_manual;

import net.minecraft.world.item.crafting.RecipeMap;

public final class SyncedData {
    private static RecipeMap RECIPES = RecipeMap.EMPTY;

    private SyncedData() {
    }

    public static void addRecipes(RecipeMap recipes) {
        SyncedData.RECIPES = recipes;
    }

    public static RecipeMap getRecipes() {
        return RECIPES;
    }
}
