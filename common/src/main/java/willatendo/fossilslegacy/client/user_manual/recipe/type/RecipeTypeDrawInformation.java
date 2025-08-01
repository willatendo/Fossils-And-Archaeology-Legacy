package willatendo.fossilslegacy.client.user_manual.recipe.type;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.client.user_manual.UserManualData;
import willatendo.fossilslegacy.client.user_manual.recipe.*;
import willatendo.fossilslegacy.client.user_manual.recipe.special.DrawArticulatedFossilRecipe;
import willatendo.fossilslegacy.client.user_manual.recipe.special.DrawSpecialRecipe;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.HashMap;
import java.util.Map;

public final class RecipeTypeDrawInformation {
    public static final Map<ResourceLocation, DrawSpecialRecipe> BUILT_IN_RECIPES = new HashMap<>();

    public static void init() {
        BUILT_IN_RECIPES.put(FAUtils.resource("articulated_fossil"), new DrawArticulatedFossilRecipe());

        UserManualData.addRecipeTypeDrawInformation(RecipeType.CRAFTING, FAUtils.resource("container/user_manual/crafting"), 116, 54, 29, 16, new DrawCraftingTableRecipe(), Blocks.CRAFTING_TABLE, Blocks.CRAFTER);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.SMELTING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.FURNACE);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.SMOKING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.SMOKER);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.BLASTING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.BLAST_FURNACE);
        UserManualData.addRecipeTypeDrawInformation(RecipeType.SMITHING, FAUtils.resource("container/user_manual/smithing"), 108, 18, 32, 34, new DrawSmithingTableRecipe(), Blocks.SMITHING_TABLE);
        UserManualData.addRecipeTypeDrawInformation(FARecipeTypes.ANALYZATION.get(), FAUtils.resource("container/user_manual/analyzer"), 144, 54, 27, 17, new DrawAnalyzerRecipe(), FABlocks.DNA_ANALYZER.get());
        UserManualData.addRecipeTypeDrawInformation(FARecipeTypes.ARCHAEOLOGY.get(), FAUtils.resource("container/user_manual/archaeology"), 88, 56, 44, 15, new DrawArchaeologyRecipe(), FABlocks.ARCHAEOLOGY_WORKBENCH.get());
    }
}
