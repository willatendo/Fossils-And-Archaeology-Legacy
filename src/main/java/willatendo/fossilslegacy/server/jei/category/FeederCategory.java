package willatendo.fossilslegacy.server.jei.category;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEI;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.recipe.FeederRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FeederCategory implements IRecipeCategory<FeederRecipe> {
	private final IDrawable background;
	private final IDrawable slot;
	private final IDrawable icon;

	public FeederCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
		this.background = guiHelper.createBlankDrawable(120, 18);
		this.slot = guiHelper.getSlotDrawable();
		this.icon = fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.FEEDER.get());
	}

	@Override
	public RecipeType<FeederRecipe> getRecipeType() {
		return FossilsLegacyJEI.FEEDER;
	}

	@Override
	public Component getTitle() {
		return FossilsLegacyUtils.translation("jei", "feeder");
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
	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, FeederRecipe feederRecipe, IFocusGroup iFocusGroup) {
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addItemStack(feederRecipe.getItemStack());
	}

	@Override
	public void draw(FeederRecipe feederRecipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.slot.draw(guiGraphics);

		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		int foodColour = feederRecipe.isMeat() ? 0xFF0000 : 0x3B703;
		guiGraphics.drawString(font, FossilsLegacyUtils.translation("jei", "feeder.food_level", feederRecipe.getFoodLevel()), 24, 5, foodColour);
	}
}
