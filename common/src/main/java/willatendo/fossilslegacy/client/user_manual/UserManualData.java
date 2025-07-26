package willatendo.fossilslegacy.client.user_manual;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.client.user_manual.recipe.DrawRecipe;
import willatendo.fossilslegacy.client.user_manual.recipe.type.RecipeTypeDrawInformation;
import willatendo.fossilslegacy.client.user_manual.recipe.type.RecipeTypeDrawInformationHolder;

import java.util.HashMap;
import java.util.Map;

public final class UserManualData {
    public static final Map<Item, UserManualItemDisplayData> ITEM_DISPLAY_DATA = new HashMap<>();
    private static final Map<RecipeType<?>, RecipeTypeDrawInformationHolder> RECIPE_TYPE_DRAW_INFORMATION = new HashMap<>();

    public static void init() {
        RecipeTypeDrawInformation.init();
    }

    public static UserManualItemDisplayData getItemDisplayData(ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (!ITEM_DISPLAY_DATA.containsKey(item)) {
            return UserManualItemDisplayData.EMPTY;
        }
        return ITEM_DISPLAY_DATA.get(item);
    }

    public static void addRecipeTypeDrawInformation(RecipeType<?> recipeType, ResourceLocation texture, int width, int height, int xOffset, int yOffset, DrawRecipe drawRecipe, Block... containers) {
        RECIPE_TYPE_DRAW_INFORMATION.put(recipeType, new RecipeTypeDrawInformationHolder(texture, width, height, xOffset, yOffset, drawRecipe, containers));
    }

    public static RecipeTypeDrawInformationHolder getRecipeTypeDrawInformation(RecipeType<?> recipeType) {
        return RECIPE_TYPE_DRAW_INFORMATION.get(recipeType);
    }
}
