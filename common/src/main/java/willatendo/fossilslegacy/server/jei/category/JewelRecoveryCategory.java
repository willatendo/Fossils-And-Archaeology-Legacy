package willatendo.fossilslegacy.server.jei.category;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.jei.FAJEIRecipeTypes;
import willatendo.fossilslegacy.server.jewel_recovery.JewelRecovery;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public final class JewelRecoveryCategory extends AbstractRecipeCategory<JewelRecovery> {
    public JewelRecoveryCategory(IGuiHelper guiHelper) {
        super(FAJEIRecipeTypes.JEWEL_RECOVERY, FossilsLegacyUtils.translation("jei", "jewel_recovery"), guiHelper.createDrawableItemLike(Items.DIAMOND), 50, 38);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, JewelRecovery jewelRecovery, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).setStandardSlotBackground().addIngredients(Ingredient.of(jewelRecovery.getBlock()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 30, 11).setOutputSlotBackground().addIngredients(Ingredient.of(jewelRecovery.outputs().toArray(ItemStack[]::new)));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.CATALYST, 1, 21).setStandardSlotBackground().addItemStack(new ItemStack(FAItems.ANCIENT_PICKAXE.get()));
    }
}
