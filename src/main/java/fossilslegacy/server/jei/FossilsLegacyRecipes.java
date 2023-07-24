package fossilslegacy.server.jei;

import java.util.List;

import fossilslegacy.server.recipe.ArchaeologyRecipe;
import fossilslegacy.server.recipe.CultivationRecipe;
import fossilslegacy.server.recipe.FossilsLegacyRecipeTypes;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.library.plugins.vanilla.crafting.CategoryRecipeValidator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeManager;

public class FossilsLegacyRecipes {
	private final RecipeManager recipeManager;
	private final IIngredientManager iIngredientManager;

	public FossilsLegacyRecipes(IIngredientManager iIngredientManager) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel clientLevel = minecraft.level;
		this.recipeManager = clientLevel.getRecipeManager();
		this.iIngredientManager = iIngredientManager;
	}

	public List<ArchaeologyRecipe> getArchaeologyRecipes(IRecipeCategory<ArchaeologyRecipe> archaeologyCategory) {
		CategoryRecipeValidator<ArchaeologyRecipe> validator = new CategoryRecipeValidator<>(archaeologyCategory, this.iIngredientManager, 1);
		return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get()).stream().filter(recipe -> validator.isRecipeValid(recipe) && validator.isRecipeHandled(recipe)).toList();
	}

	public List<CultivationRecipe> getCultivationRecipes(IRecipeCategory<CultivationRecipe> cultivationCategory) {
		CategoryRecipeValidator<CultivationRecipe> validator = new CategoryRecipeValidator<>(cultivationCategory, this.iIngredientManager, 1);
		return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.CULTIVATION.get()).stream().filter(recipe -> validator.isRecipeValid(recipe) && validator.isRecipeHandled(recipe)).toList();
	}
}
