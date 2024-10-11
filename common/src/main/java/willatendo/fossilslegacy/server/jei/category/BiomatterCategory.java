package willatendo.fossilslegacy.server.jei.category;

import com.google.common.cache.LoadingCache;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.jei.recipe.BiomatterRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.text.NumberFormat;

public final class BiomatterCategory extends AbstractRecipeCategory<BiomatterRecipe> {
    private final LoadingCache<Integer, IDrawableAnimated> cachedBiomatter;
    private final IDrawableStatic vatOutline;

    public BiomatterCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
        super(FossilsLegacyJEIRecipeTypes.BIOMATTER, FossilsLegacyUtils.translation("jei", "biomatter"), fossilsLegacyJEITextures.getVatIcon(), BiomatterCategory.getMaxWidth(), 34);
        this.cachedBiomatter = fossilsLegacyJEITextures.createBiomatterBar();
        this.vatOutline = fossilsLegacyJEITextures.getVatOutline();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, BiomatterRecipe analyzationRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 17).setStandardSlotBackground().addItemStacks(analyzationRecipe.itemStacks());
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder iRecipeExtrasBuilder, BiomatterRecipe biomatterRecipe, IRecipeSlotsView iRecipeSlotsView, IFocusGroup iFocusGroup) {
        Component useTimeText = BiomatterCategory.createUseTimeCount(biomatterRecipe.biomatterUseTime());
        iRecipeExtrasBuilder.addText(useTimeText, 20, 0, getWidth() - 20, getHeight()).alignHorizontalCenter().alignVerticalCenter().setColor(0xFF808080);
    }

    @Override
    public void draw(BiomatterRecipe analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.vatOutline.draw(guiGraphics, 2, 0);
        IDrawableAnimated biomatterSlot = this.cachedBiomatter.getUnchecked(analyzationRecipe.biomatterUseTime());
        biomatterSlot.draw(guiGraphics, 2, 0);
    }

    private static int getMaxWidth() {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        Component maxUseTime = BiomatterCategory.createUseTimeCount(10000000 * 200);
        int maxStringWidth = font.width(maxUseTime.getString());
        int textPadding = 20;
        return 18 + textPadding + maxStringWidth;
    }

    private static Component createUseTimeCount(int burnTime) {
        if (burnTime == 6000) {
            return Component.translatable("jei.fossilslegacy.biomatter.biomatterCount.single");
        } else {
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            String smeltCount = numberInstance.format(burnTime / 6000.0F);
            return Component.translatable("jei.fossilslegacy.biomatter.biomatterCount", smeltCount);
        }
    }
}
