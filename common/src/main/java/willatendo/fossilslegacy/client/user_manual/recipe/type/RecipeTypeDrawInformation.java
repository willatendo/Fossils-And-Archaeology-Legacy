package willatendo.fossilslegacy.client.user_manual.recipe.type;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.client.user_manual.UserManualData;
import willatendo.fossilslegacy.client.user_manual.recipe.DrawCraftingTableRecipe;
import willatendo.fossilslegacy.client.user_manual.recipe.DrawFurnaceRecipe;
import willatendo.fossilslegacy.client.user_manual.recipe.DrawSmithingTableRecipe;
import willatendo.fossilslegacy.server.utils.FAUtils;

public final class RecipeTypeDrawInformation {
    public static void init() {
        UserManualData.addRecipeTypeDrawInformation(RecipeType.CRAFTING, FAUtils.resource("container/user_manual/crafting"), 116, 54, 29, 16, new DrawCraftingTableRecipe(), Blocks.CRAFTING_TABLE, Blocks.CRAFTER);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.SMELTING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.FURNACE);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.SMOKING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.SMOKER);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.BLASTING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.BLAST_FURNACE);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.SMITHING, FAUtils.resource("container/user_manual/smithing"), 108, 18, 32, 34, new DrawSmithingTableRecipe(), Blocks.SMITHING_TABLE);
    }
}
