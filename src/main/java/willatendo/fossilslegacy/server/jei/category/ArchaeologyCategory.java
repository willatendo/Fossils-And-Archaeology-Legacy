package willatendo.fossilslegacy.server.jei.category;

import com.google.common.cache.LoadingCache;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.library.util.RecipeUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEI;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class ArchaeologyCategory implements IRecipeCategory<ArchaeologyRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
	protected final IDrawableStatic hammer;
	protected final IDrawableAnimated animatedHammer;

	public ArchaeologyCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
		this.background = fossilsLegacyJEITextures.getBackground(0, 0, 88, 56);
		this.icon = fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
		this.cachedArrows = fossilsLegacyJEITextures.createProgressBar(25, 88, 14, 24, 14, IDrawableAnimated.StartDirection.LEFT);
		this.hammer = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 88, 0, 14, 14);
		this.animatedHammer = guiHelper.createAnimatedDrawable(this.hammer, 300, IDrawableAnimated.StartDirection.TOP, true);
	}

	protected IDrawableAnimated getArrow(ArchaeologyRecipe archaeologyRecipe) {
		int cookTime = archaeologyRecipe.getTime();
		if (cookTime <= 0) {
			cookTime = 3000;
		}
		return this.cachedArrows.getUnchecked(cookTime);
	}

	@Override
	public RecipeType<ArchaeologyRecipe> getRecipeType() {
		return FossilsLegacyJEI.ARCHAEOLOGY;
	}

	@Override
	public Component getTitle() {
		return FossilsLegacyUtils.translation("jei", "archaeology");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, ArchaeologyRecipe archaeologyRecipe, IFocusGroup iFocusGroup) {
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addIngredients(archaeologyRecipe.getIngredients().get(0));
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 67, 5).addItemStack(RecipeUtil.getResultItem(archaeologyRecipe));
	}

	@Override
	public void draw(ArchaeologyRecipe archaeologyRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.animatedHammer.draw(guiGraphics, 37, 21);

		IDrawableAnimated arrow = this.getArrow(archaeologyRecipe);
		arrow.draw(guiGraphics, 32, 6);
	}
}
