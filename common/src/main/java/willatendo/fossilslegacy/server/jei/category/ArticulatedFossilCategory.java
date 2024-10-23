package willatendo.fossilslegacy.server.jei.category;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyDataComponents;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.recipe.ArticulatedFossilRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class ArticulatedFossilCategory extends AbstractRecipeCategory<ArticulatedFossilRecipe> {
    private final IDrawable arrowOutline;

    public ArticulatedFossilCategory(FossilsLegacyJEITextures fossilsLegacyJEITextures) {
        super(FossilsLegacyJEIRecipeTypes.ARTICULATED_FOSSIL, FossilsLegacyUtils.translation("jei", "articulated_fossil"), fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get()), 116, 54);
        this.arrowOutline = fossilsLegacyJEITextures.getArrow();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, ArticulatedFossilRecipe articulatedFossilRecipe, IFocusGroup iFocusGroup) {
        for (int width = 0; width < 3; width++) {
            for (int height = 0; height < 3; height++) {
                int index = width + (height * 3);
                IRecipeSlotBuilder inputIRecipeSlotBuilder = iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1 + (width * 18), 1 + (height * 18)).setStandardSlotBackground();
                if (index < articulatedFossilRecipe.fossilCount()) {
                    inputIRecipeSlotBuilder.addIngredients(Ingredient.of(articulatedFossilRecipe.fossilVariant().value().fossilIngredient()));
                }
            }
        }

        ItemStack output = new ItemStack(FossilsLegacyItems.ARTICULATED_FOSSIL.get());
        output.set(FossilsLegacyDataComponents.FOSSIL_VARIANT.get(), articulatedFossilRecipe.fossilVariant());
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 95, 19).setOutputSlotBackground().addItemStack(output);
    }

    @Override
    public void draw(ArticulatedFossilRecipe articulatedFossilRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.arrowOutline.draw(guiGraphics, 61, 20);
    }
}
