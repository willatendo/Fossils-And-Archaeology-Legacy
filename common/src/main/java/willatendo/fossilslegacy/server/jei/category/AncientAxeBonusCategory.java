package willatendo.fossilslegacy.server.jei.category;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.ancient_axe_bonus.AncientAxeBonus;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.jei.FAJEIRecipeTypes;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class AncientAxeBonusCategory extends AbstractRecipeCategory<AncientAxeBonus> {
    public AncientAxeBonusCategory(IGuiHelper guiHelper) {
        super(FAJEIRecipeTypes.ANCIENT_AXE_BONUS, FossilsLegacyUtils.translation("jei", "ancient_axe_bonus"), guiHelper.createDrawableItemLike(Blocks.OAK_PLANKS), 120, 38);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, AncientAxeBonus ancientAxeBonus, IFocusGroup focuses) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).setStandardSlotBackground().addIngredients(Ingredient.of(ancientAxeBonus.getInput()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 30, 11).setOutputSlotBackground().addIngredients(Ingredient.of(ancientAxeBonus.output()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.CATALYST, 1, 21).setStandardSlotBackground().addItemStack(new ItemStack(FAItems.ANCIENT_AXE.get()));
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder iRecipeExtrasBuilder, AncientAxeBonus jewelRecoveryRecipe, IRecipeSlotsView iRecipeSlotsView, IFocusGroup iFocusGroup) {
        Component timeString = Component.translatable("jei.fossilslegacy.ancient_axe_bonus.count", jewelRecoveryRecipe.minDrop(), jewelRecoveryRecipe.maxDrop());
        iRecipeExtrasBuilder.addText(timeString, 15, 13, getWidth() - 20, 10).alignHorizontalRight().alignVerticalBottom().setColor(0xFF808080);
    }
}
