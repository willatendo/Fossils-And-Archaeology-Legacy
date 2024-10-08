package willatendo.fossilslegacy.server.jei.category;

import com.google.common.cache.LoadingCache;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEI;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.RecipeUtil;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.CultivationRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class ArchaeologyCategory extends AbstractRecipeCategory<RecipeHolder<ArchaeologyRecipe>> {
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
    private final IDrawable arrowOutline;
    private final IDrawableAnimated animatedHammer;
    private final IDrawable hammerOutline;

    public ArchaeologyCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
        super(FossilsLegacyJEIRecipeTypes.ARCHAEOLOGY, FossilsLegacyUtils.translation("jei", "archaeology"), guiHelper.createDrawableItemLike(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()), 88, 56);
        this.cachedArrows = fossilsLegacyJEITextures.createArchaeologyBar();
        this.arrowOutline = fossilsLegacyJEITextures.getArchaeologyArrow();
        this.animatedHammer = fossilsLegacyJEITextures.createHammer();
        this.hammerOutline = fossilsLegacyJEITextures.getHammerOutline();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, RecipeHolder<ArchaeologyRecipe> recipeHolder, IFocusGroup iFocusGroup) {
        ArchaeologyRecipe archaeologyRecipe = recipeHolder.value();
        ItemStack[] inputs = archaeologyRecipe.getIngredients().get(0).getItems();
        for (int i = 0; i < inputs.length; i++) {
            ItemStack input = inputs[i];
            if (input.isDamageableItem()) {
                input.setDamageValue(input.getMaxDamage() * 3 / 4);
            }
            inputs[i] = input;
        }
        iRecipeLayoutBuilder.addInputSlot(5, 5).setOutputSlotBackground().addIngredients(Ingredient.of(inputs));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 35, 38).setStandardSlotBackground();
        iRecipeLayoutBuilder.addOutputSlot(67, 5).setOutputSlotBackground().addItemStack(RecipeUtil.getResultItem(archaeologyRecipe));
    }

    @Override
    public void draw(RecipeHolder<ArchaeologyRecipe> recipeHolder, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.hammerOutline.draw(guiGraphics, 36, 21);
        this.animatedHammer.draw(guiGraphics, 36, 21);

        this.arrowOutline.draw(guiGraphics, 32, 6);
        IDrawableAnimated arrow = this.getArrow(recipeHolder);
        arrow.draw(guiGraphics, 32, 6);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder iRecipeExtrasBuilder, RecipeHolder<ArchaeologyRecipe> recipeHolder, IRecipeSlotsView iRecipeSlotsView, IFocusGroup iFocusGroup) {
        this.addTime(iRecipeExtrasBuilder, recipeHolder);
    }

    private IDrawableAnimated getArrow(RecipeHolder<ArchaeologyRecipe> archaeologyRecipeHolder) {
        int cookTime = archaeologyRecipeHolder.value().getTime();
        if (cookTime <= 0) {
            cookTime = 3000;
        }
        return this.cachedArrows.getUnchecked(cookTime);
    }

    private void addTime(IRecipeExtrasBuilder builder, RecipeHolder<ArchaeologyRecipe> recipeHolder) {
        ArchaeologyRecipe recipe = recipeHolder.value();
        int cookTime = recipe.getTime();
        if (cookTime <= 0) {
            cookTime = 3000;
        }
        int cookTimeSeconds = cookTime / 20;
        Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
        builder.addText(timeString, 20, getHeight() - 10, getWidth() - 20, 10).alignHorizontalRight().alignVerticalBottom().setColor(0xFF808080);
    }
}
