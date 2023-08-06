package fossilslegacy.server.jei.category;

import java.util.List;

import org.apache.commons.compress.utils.Lists;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.block.entity.CultivatorBlockEntity;
import fossilslegacy.server.jei.FossilsLegacyJEI;
import fossilslegacy.server.recipe.CultivationRecipe;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CultivationCategory implements IRecipeCategory<CultivationRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedHammer;

	public CultivationCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 0, 56, 88, 56);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(FossilsLegacyBlocks.CULTIVATOR.get()));
		this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25).build(new CacheLoader<>() {
			@Override
			public IDrawableAnimated load(Integer cookTime) {
				return guiHelper.drawableBuilder(FossilsLegacyJEI.TEXTURE, 88, 70, 24, 14).buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
			}
		});
		;
		this.staticFlame = guiHelper.createDrawable(FossilsLegacyJEI.TEXTURE, 88, 56, 14, 14);
		this.animatedHammer = guiHelper.createAnimatedDrawable(this.staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
	}

	protected IDrawableAnimated getArrow(CultivationRecipe cultivationRecipe) {
		int cookTime = cultivationRecipe.getTime();
		if (cookTime <= 0) {
			cookTime = 3000;
		}
		return this.cachedArrows.getUnchecked(cookTime);
	}

	@Override
	public RecipeType<CultivationRecipe> getRecipeType() {
		return FossilsLegacyJEI.CULTIVATION;
	}

	@Override
	public Component getTitle() {
		return FossilsLegacyUtils.translation("jei", "cultivation");
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
	public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, CultivationRecipe cultivationRecipe, IFocusGroup iFocusGroup) {
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addIngredients(cultivationRecipe.getIngredients().get(0));
		List<ItemStack> fuels = Lists.newArrayList();
		for (Item item : CultivatorBlockEntity.getOnTimeMap().keySet()) {
			fuels.add(item.getDefaultInstance());
		}
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 36, 39).addItemStacks(fuels);
		iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 67, 5).addItemStack(RecipeUtil.getResultItem(cultivationRecipe));
	}

	@Override
	public void draw(CultivationRecipe cultivationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.animatedHammer.draw(guiGraphics, 37, 21);

		IDrawableAnimated arrow = this.getArrow(cultivationRecipe);
		arrow.draw(guiGraphics, 33, 8);
	}
}
