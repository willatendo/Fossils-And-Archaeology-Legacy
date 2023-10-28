package willatendo.fossilslegacy.server.jei.category;

import java.text.NumberFormat;

import com.google.common.cache.LoadingCache;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.common.Constants;
import mezz.jei.common.util.ImmutableRect2i;
import mezz.jei.common.util.MathUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEI;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.recipe.BiomatterRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class BiomatterCategory implements IRecipeCategory<BiomatterRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final LoadingCache<Integer, IDrawableAnimated> cachedFlames;
	private final ImmutableRect2i textArea;

	public BiomatterCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
		Minecraft minecraft = Minecraft.getInstance();
		Font fontRenderer = minecraft.font;
		Component maxSmeltCountText = createSmeltCountText(10000000 * 200);
		int maxStringWidth = fontRenderer.width(maxSmeltCountText.getString());
		this.background = guiHelper.drawableBuilder(Constants.RECIPE_GUI_VANILLA, 0, 134, 18, 34).addPadding(0, 0, 0, 20 + maxStringWidth).build();
		this.icon = fossilsLegacyJEITextures.getBiomatterTexture();
		this.cachedFlames = fossilsLegacyJEITextures.createProgressBar(25, 82, 114, 14, 14, IDrawableAnimated.StartDirection.TOP, true);
		this.textArea = new ImmutableRect2i(20, 0, 20 + maxStringWidth, 34);
	}

	@Override
	public RecipeType<BiomatterRecipe> getRecipeType() {
		return FossilsLegacyJEI.BIOMATTER;
	}

	@Override
	public Component getTitle() {
		return FossilsLegacyUtils.translation("jei", "biomatter");
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
	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, BiomatterRecipe analyzationRecipe, IFocusGroup iFocusGroup) {
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 17).addItemStacks(analyzationRecipe.getItemStack());
	}

	@Override
	public void draw(BiomatterRecipe analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		int biomatterUseTime = analyzationRecipe.getBiomatterUseTime();
		IDrawableAnimated biomatter = this.cachedFlames.getUnchecked(biomatterUseTime);
		biomatter.draw(guiGraphics, 1, 0);
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		Component smeltCountText = createSmeltCountText(biomatterUseTime);
		ImmutableRect2i centerArea = MathUtil.centerTextArea(this.textArea, font, smeltCountText);
		guiGraphics.drawString(font, smeltCountText, centerArea.getX(), centerArea.getY(), 0xFF808080, false);
	}

	private static Component createSmeltCountText(int burnTime) {
		if (burnTime == 200) {
			return Component.translatable("gui.jei.category.fuel.smeltCount.single");
		} else {
			NumberFormat numberInstance = NumberFormat.getNumberInstance();
			numberInstance.setMaximumFractionDigits(2);
			String smeltCount = numberInstance.format(burnTime / 200f);
			return Component.translatable("gui.jei.category.fuel.smeltCount", smeltCount);
		}
	}
}
