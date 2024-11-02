package willatendo.fossilslegacy.server.jei.category;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.recipe.FeederRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class FeederCategory extends AbstractRecipeCategory<FeederRecipe> {
    public FeederCategory(FossilsLegacyJEITextures fossilsLegacyJEITextures) {
        super(FossilsLegacyJEIRecipeTypes.FEEDER, FossilsLegacyUtils.translation("jei", "feeder"), fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.FEEDER.get()), 120, 18);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, FeederRecipe feederRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).setStandardSlotBackground().addItemStack(feederRecipe.itemStack());
    }

    @Override
    public void draw(FeederRecipe feederRecipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        int foodColour = feederRecipe.meat() ? 0xFF0000 : 0x3B703;
        guiGraphics.drawString(font, FossilsLegacyUtils.translation("jei", "feeder.food_level", feederRecipe.foodLevel()), 24, 5, foodColour);
    }
}
