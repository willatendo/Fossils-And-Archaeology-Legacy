package willatendo.fossilslegacy.server.jei.category;

import com.google.common.cache.LoadingCache;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import willatendo.fossilslegacy.server.jei.FAJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FAJEITextures;
import willatendo.fossilslegacy.server.jei.recipe.FuelRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.text.NumberFormat;

public final class InformationCategory extends AbstractRecipeCategory<FuelRecipe> {
    private final LoadingCache<Integer, IDrawableAnimated> cachedInformation;
    private final IDrawableStatic hammerOutline;

    public InformationCategory(FAJEITextures FAJEITextures) {
        super(FAJEIRecipeTypes.INFORMATION, FossilsLegacyUtils.translation("jei", "information"), FAJEITextures.getHammerIcon(), InformationCategory.getMaxWidth(), 34);
        this.cachedInformation = FAJEITextures.createHammerBar();
        this.hammerOutline = FAJEITextures.getHammerOutline();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, FuelRecipe analyzationRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 17).setStandardSlotBackground().addItemStacks(analyzationRecipe.itemStacks());
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder iRecipeExtrasBuilder, FuelRecipe fuelRecipe, IRecipeSlotsView iRecipeSlotsView, IFocusGroup iFocusGroup) {
        Component useTimeText = InformationCategory.createUseTimeCount(fuelRecipe.time());
        iRecipeExtrasBuilder.addText(useTimeText, 20, 0, getWidth() - 20, getHeight()).alignHorizontalCenter().alignVerticalCenter().setColor(0xFF808080);
    }

    @Override
    public void draw(FuelRecipe analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.hammerOutline.draw(guiGraphics, 2, 0);
        IDrawableAnimated biomatterSlot = this.cachedInformation.getUnchecked(analyzationRecipe.time());
        biomatterSlot.draw(guiGraphics, 2, 0);
    }

    private static int getMaxWidth() {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        Component maxUseTime = InformationCategory.createUseTimeCount(10000000 * 200);
        int maxStringWidth = font.width(maxUseTime.getString());
        int textPadding = 20;
        return 18 + textPadding + maxStringWidth;
    }

    private static Component createUseTimeCount(int burnTime) {
        if (burnTime == 3000) {
            return Component.translatable("jei.fossilslegacy.information.informationCount.single");
        } else {
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            String smeltCount = numberInstance.format(burnTime / 3000.0F);
            return Component.translatable("jei.fossilslegacy.information.informationCount", smeltCount);
        }
    }
}
