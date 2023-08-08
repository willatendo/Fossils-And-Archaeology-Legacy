package willatendo.fossilslegacy.server.jei.category;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEI;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class AnalyzationCategory implements IRecipeCategory<AnalyzationRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

	public AnalyzationCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 0, 112, 144, 54);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(FossilsLegacyBlocks.ANALYZER.get()));
		this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<>() {
			@Override
			public IDrawableAnimated load(Integer cookTime) {
				return guiHelper.drawableBuilder(FossilsLegacyJEI.TEXTURE, 144, 122, 21, 10).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});
	}

	protected IDrawableAnimated getArrow(AnalyzationRecipe analyzationRecipe) {
		int cookTime = analyzationRecipe.getTime();
		if (cookTime <= 0) {
			cookTime = 100;
		}
		return this.cachedArrows.getUnchecked(cookTime);
	}

	@Override
	public RecipeType<AnalyzationRecipe> getRecipeType() {
		return FossilsLegacyJEI.ANALYZATION;
	}

	@Override
	public Component getTitle() {
		return FossilsLegacyUtils.translation("jei", "analyzation");
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
	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, AnalyzationRecipe analyzationRecipe, IFocusGroup iFocusGroup) {
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(analyzationRecipe.getIngredients().get(0));
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 95, 5).addItemStacks(analyzationRecipe.getResults()).addTooltipCallback((iRecipeSlotView, tooltip) -> {
			tooltip.add(Component.literal(analyzationRecipe.getWeight(iRecipeSlotView.getDisplayedItemStack().get()) + "%").withStyle(ChatFormatting.GRAY));
		});
	}

	@Override
	public void draw(AnalyzationRecipe analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		IDrawableAnimated arrow = this.getArrow(analyzationRecipe);
		arrow.draw(guiGraphics, 61, 21);
	}
}
