package willatendo.fossilslegacy.server.jei.category;

import com.google.common.cache.LoadingCache;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.RecipeUtil;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class CultivationCategory extends AbstractRecipeCategory<RecipeHolder<CultivationRecipe>> {
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
    private final IDrawable arrowOutline;
    private final IDrawableAnimated animatedVat;
    private final IDrawable vatOutline;

    public CultivationCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
        super(FossilsLegacyJEIRecipeTypes.CULTIVATION, FossilsLegacyUtils.translation("jei", "cultivation"), guiHelper.createDrawableItemLike(FossilsLegacyBlocks.LIME_CULTIVATOR.get()), 88, 56);
        this.cachedArrows = fossilsLegacyJEITextures.createCultivationBar();
        this.arrowOutline = fossilsLegacyJEITextures.getCultivationArrow();
        this.animatedVat = fossilsLegacyJEITextures.createVat();
        this.vatOutline = fossilsLegacyJEITextures.getVatOutline();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, RecipeHolder<CultivationRecipe> cultivationRecipeHolder, IFocusGroup iFocusGroup) {
        CultivationRecipe cultivationRecipe = cultivationRecipeHolder.value();
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 5, 5).setOutputSlotBackground().addIngredients(cultivationRecipe.getIngredients().get(0));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 35, 38).setStandardSlotBackground();
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 67, 5).setOutputSlotBackground().addItemStack(RecipeUtil.getResultItem(cultivationRecipe));
    }

    @Override
    public void draw(RecipeHolder<CultivationRecipe> cultivationRecipeHolder, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.vatOutline.draw(guiGraphics, 36, 20);
        this.animatedVat.draw(guiGraphics, 36, 20);

        this.arrowOutline.draw(guiGraphics, 32, 6);
        IDrawableAnimated arrow = this.getArrow(cultivationRecipeHolder);
        arrow.draw(guiGraphics, 32, 6);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder iRecipeExtrasBuilder, RecipeHolder<CultivationRecipe> recipeHolder, IRecipeSlotsView iRecipeSlotsView, IFocusGroup iFocusGroup) {
        this.addTime(iRecipeExtrasBuilder, recipeHolder);
    }

    private IDrawableAnimated getArrow(RecipeHolder<CultivationRecipe> cultivationRecipeHolder) {
        int cookTime = cultivationRecipeHolder.value().getTime();
        if (cookTime <= 0) {
            cookTime = 3000;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    private void addTime(IRecipeExtrasBuilder builder, RecipeHolder<CultivationRecipe> recipeHolder) {
        CultivationRecipe recipe = recipeHolder.value();
        int cookTime = recipe.getTime();
        if (cookTime <= 0) {
            cookTime = 6000;
        }
        int cookTimeSeconds = cookTime / 20;
        Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
        builder.addText(timeString, 20, getHeight() - 10, getWidth() - 20, 10).alignHorizontalRight().alignVerticalBottom().setColor(0xFF808080);
    }
}
