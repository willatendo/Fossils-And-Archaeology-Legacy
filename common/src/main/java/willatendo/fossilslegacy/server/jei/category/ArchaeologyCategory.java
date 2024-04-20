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
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEI;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.RecipeUtil;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class ArchaeologyCategory implements IRecipeCategory<RecipeHolder<ArchaeologyRecipe>> {
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

	protected IDrawableAnimated getArrow(RecipeHolder<ArchaeologyRecipe> archaeologyRecipeHolder) {
		int cookTime = archaeologyRecipeHolder.value().getTime();
		if (cookTime <= 0) {
			cookTime = 3000;
		}
		return this.cachedArrows.getUnchecked(cookTime);
	}

	@Override
	public RecipeType<RecipeHolder<ArchaeologyRecipe>> getRecipeType() {
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
	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, RecipeHolder<ArchaeologyRecipe> archaeologyRecipeHolder, IFocusGroup iFocusGroup) {
		ArchaeologyRecipe archaeologyRecipe = archaeologyRecipeHolder.value();
		ItemStack[] inputs = archaeologyRecipe.getIngredients().get(0).getItems();
		for (int i = 0; i < inputs.length; i++) {
			ItemStack input = inputs[i];
			if (input.isDamageableItem()) {
				input.setDamageValue(input.getMaxDamage() * 3 / 4);
			}
			inputs[i] = input;
		}
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addIngredients(Ingredient.of(inputs));
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 67, 5).addItemStack(RecipeUtil.getResultItem(archaeologyRecipe));
	}

	@Override
	public void draw(RecipeHolder<ArchaeologyRecipe> archaeologyRecipeHolder, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.animatedHammer.draw(guiGraphics, 37, 21);

		IDrawableAnimated arrow = this.getArrow(archaeologyRecipeHolder);
		arrow.draw(guiGraphics, 32, 6);
	}
}
