package willatendo.fossilslegacy.server.jei;

//public class FossilsLegacyRecipes {
//	private final RecipeManager recipeManager;
//	private final IIngredientManager iIngredientManager;
//
//	public FossilsLegacyRecipes(IIngredientManager iIngredientManager) {
//		Minecraft minecraft = Minecraft.getInstance();
//		ClientLevel clientLevel = minecraft.level;
//		this.recipeManager = clientLevel.getRecipeManager();
//		this.iIngredientManager = iIngredientManager;
//	}
//
//	public List<ArchaeologyRecipe> getArchaeologyRecipes(IRecipeCategory<ArchaeologyRecipe> archaeologyCategory) {
//		CategoryRecipeValidator<ArchaeologyRecipe> validator = new CategoryRecipeValidator<>(archaeologyCategory, this.iIngredientManager, 1);
//		return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.ARCHAEOLOGY.get()).stream().filter(recipe -> validator.isRecipeValid(recipe) && validator.isRecipeHandled(recipe)).toList();
//	}
//
//	public List<CultivationRecipe> getCultivationRecipes(IRecipeCategory<CultivationRecipe> cultivationCategory) {
//		CategoryRecipeValidator<CultivationRecipe> validator = new CategoryRecipeValidator<>(cultivationCategory, this.iIngredientManager, 1);
//		return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.CULTIVATION.get()).stream().filter(recipe -> validator.isRecipeValid(recipe) && validator.isRecipeHandled(recipe)).toList();
//	}
//
//	public List<AnalyzationRecipe> getAnalyzationRecipes(IRecipeCategory<AnalyzationRecipe> analyzationCategory) {
//		CategoryRecipeValidator<AnalyzationRecipe> validator = new CategoryRecipeValidator<>(analyzationCategory, this.iIngredientManager, 1);
//		return recipeManager.getAllRecipesFor(FossilsLegacyRecipeTypes.ANALYZATION.get()).stream().filter(recipe -> validator.isRecipeValid(recipe) && validator.isRecipeHandled(recipe)).toList();
//	}
//}
