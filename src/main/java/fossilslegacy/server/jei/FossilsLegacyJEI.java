package fossilslegacy.server.jei;

import fossilslegacy.client.screen.ArchaeologyWorkbenchScreen;
import fossilslegacy.client.screen.CultivatorScreen;
import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.jei.category.ArchaeologyCategory;
import fossilslegacy.server.jei.category.CultivationCategory;
import fossilslegacy.server.menu.ArchaeologyWorkbenchMenu;
import fossilslegacy.server.menu.CultivatorMenu;
import fossilslegacy.server.menu.FossilsLegacyMenus;
import fossilslegacy.server.recipe.ArchaeologyRecipe;
import fossilslegacy.server.recipe.CultivationRecipe;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class FossilsLegacyJEI implements IModPlugin {
	public static final RecipeType<ArchaeologyRecipe> ARCHAEOLOGY = RecipeType.create(FossilsLegacyUtils.ID, "archaeology_category", ArchaeologyRecipe.class);
	public static final RecipeType<CultivationRecipe> CULTIVATION = RecipeType.create(FossilsLegacyUtils.ID, "cultivation_category", CultivationRecipe.class);
	public static final ResourceLocation TEXTURE = FossilsLegacyUtils.resource("textures/gui/fossils_legacy_jei.png");

	private ArchaeologyCategory archaeologyCategory;
	private CultivationCategory cultivationCategory;

	@Override
	public ResourceLocation getPluginUid() {
		return FossilsLegacyUtils.resource("fossils_legacy_jei");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration iRecipeCategoryRegistration) {
		IGuiHelper iGuiHelper = iRecipeCategoryRegistration.getJeiHelpers().getGuiHelper();
		iRecipeCategoryRegistration.addRecipeCategories(this.archaeologyCategory = new ArchaeologyCategory(iGuiHelper), this.cultivationCategory = new CultivationCategory(iGuiHelper));
	}

	@Override
	public void registerRecipes(IRecipeRegistration iRecipeRegistration) {
		IIngredientManager iIngredientManager = iRecipeRegistration.getIngredientManager();

		FossilsLegacyRecipes fossilsLegacyRecipes = new FossilsLegacyRecipes(iIngredientManager);

		iRecipeRegistration.addRecipes(FossilsLegacyJEI.ARCHAEOLOGY, fossilsLegacyRecipes.getArchaeologyRecipes(this.archaeologyCategory));
		iRecipeRegistration.addRecipes(FossilsLegacyJEI.CULTIVATION, fossilsLegacyRecipes.getCultivationRecipes(this.cultivationCategory));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration iRecipeCatalystRegistration) {
		iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()), FossilsLegacyJEI.ARCHAEOLOGY);
		iRecipeCatalystRegistration.addRecipeCatalyst(new ItemStack(FossilsLegacyBlocks.CULTIVATOR.get()), FossilsLegacyJEI.CULTIVATION);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration iGuiHandlerRegistration) {
		iGuiHandlerRegistration.addRecipeClickArea(ArchaeologyWorkbenchScreen.class, 76, 21, 24, 14, FossilsLegacyJEI.ARCHAEOLOGY);
		iGuiHandlerRegistration.addRecipeClickArea(CultivatorScreen.class, 76, 21, 24, 14, FossilsLegacyJEI.CULTIVATION);
	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration iRecipeTransferRegistration) {
		iRecipeTransferRegistration.addRecipeTransferHandler(ArchaeologyWorkbenchMenu.class, FossilsLegacyMenus.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyJEI.ARCHAEOLOGY, 0, 1, 3, 36);
		iRecipeTransferRegistration.addRecipeTransferHandler(CultivatorMenu.class, FossilsLegacyMenus.CULTIVATOR.get(), FossilsLegacyJEI.CULTIVATION, 0, 1, 3, 36);
	}
}
