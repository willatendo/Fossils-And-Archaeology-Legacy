package fossilslegacy.server.jei.category;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.jei.FossilsLegacyJEI;
import fossilslegacy.server.recipe.AnalyzationRecipe;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class AnalyzationCategory implements IRecipeCategory<AnalyzationRecipe> {
	private final IDrawable background;
	private final IDrawable icon;

	public AnalyzationCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 0, 112, 144, 54);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(FossilsLegacyBlocks.ANALYZER.get()));
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
}
