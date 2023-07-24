package fossilslegacy.server.jei.category;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.jei.FossilsLegacyJEI;
import fossilslegacy.server.recipe.ArchaeologyRecipe;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import mezz.jei.api.constants.VanillaTypes;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class ArchaeologyCategory implements IRecipeCategory<ArchaeologyRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedHammer;

	public ArchaeologyCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 0, 0, 88, 56);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()));
		this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<>() {
			@Override
			public IDrawableAnimated load(Integer cookTime) {
				return guiHelper.drawableBuilder(FossilsLegacyJEI.TEXTURE, 88, 14, 24, 14).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});
		;
		this.staticFlame = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 88, 0, 14, 14);
		this.animatedHammer = guiHelper.createAnimatedDrawable(this.staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
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
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 36, 39).addIngredients(Ingredient.of(FossilsLegacyItems.RELIC_SCRAP.get()));
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 67, 5).addItemStack(RecipeUtil.getResultItem(archaeologyRecipe));
	}

	@Override
	public void draw(ArchaeologyRecipe archaeologyRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.animatedHammer.draw(guiGraphics, 37, 21);

		IDrawableAnimated arrow = this.getArrow(archaeologyRecipe);
		arrow.draw(guiGraphics, 32, 6);
	}
}
