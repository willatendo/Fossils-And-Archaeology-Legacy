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
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FADataComponents;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.jei.FAJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FAJEITextures;
import willatendo.fossilslegacy.server.jei.recipe.ArticulatedFossilRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class ArticulatedFossilCategory extends AbstractRecipeCategory<ArticulatedFossilRecipe> {
    private final IDrawable arrowOutline;

    public ArticulatedFossilCategory(FAJEITextures FAJEITextures) {
        super(FAJEIRecipeTypes.ARTICULATED_FOSSIL, FossilsLegacyUtils.translation("jei", "articulated_fossil"), FAJEITextures.getIconFromItemLike(FABlocks.PALAEONTOLOGY_TABLE.get()), 116, 54);
        this.arrowOutline = FAJEITextures.getArrow();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, ArticulatedFossilRecipe articulatedFossilRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.setShapeless();
        for (int width = 0; width < 3; width++) {
            for (int height = 0; height < 3; height++) {
                int index = width + (height * 3);
                IRecipeSlotBuilder inputIRecipeSlotBuilder = iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1 + (width * 18), 1 + (height * 18)).setStandardSlotBackground();
                if (index < articulatedFossilRecipe.fossilCount()) {
                    inputIRecipeSlotBuilder.addIngredients(Ingredient.of(articulatedFossilRecipe.fossilVariant().value().fossilIngredient()));
                }
            }
        }

        ItemStack output = new ItemStack(FAItems.ARTICULATED_FOSSIL.get());
        output.set(FADataComponents.FOSSIL_VARIANT.get(), articulatedFossilRecipe.fossilVariant());
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 95, 19).setOutputSlotBackground().addItemStack(output);
    }

    @Override
    public void draw(ArticulatedFossilRecipe articulatedFossilRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.arrowOutline.draw(guiGraphics, 61, 20);
    }
}
