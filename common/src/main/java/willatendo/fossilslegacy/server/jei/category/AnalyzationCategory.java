package willatendo.fossilslegacy.server.jei.category;

import com.google.common.cache.LoadingCache;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FossilsLegacyJEITextures;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.List;

public class AnalyzationCategory implements IRecipeCategory<RecipeHolder<AnalyzationRecipe>> {
    private final IDrawable background;
    private final IDrawable icon;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

    public AnalyzationCategory(IGuiHelper guiHelper, FossilsLegacyJEITextures fossilsLegacyJEITextures) {
        this.background = fossilsLegacyJEITextures.getBackground(0, 112, 144, 54);
        this.icon = fossilsLegacyJEITextures.getIconFromItemLike(FossilsLegacyBlocks.ANALYZER.get());
        this.cachedArrows = fossilsLegacyJEITextures.createProgressBar(25, 144, 112, 21, 10, IDrawableAnimated.StartDirection.LEFT);
    }

    protected IDrawableAnimated getArrow(RecipeHolder<AnalyzationRecipe> analyzationRecipeHolder) {
        int analyzeTime = analyzationRecipeHolder.value().getTime();
        if (analyzeTime <= 0) {
            analyzeTime = 100;
        }
        return this.cachedArrows.getUnchecked(analyzeTime);
    }

    @Override
    public RecipeType<RecipeHolder<AnalyzationRecipe>> getRecipeType() {
        return FossilsLegacyJEIRecipeTypes.ANALYZATION;
    }

    @Override
    public Component getTitle() {
        return FossilsLegacyUtils.translation("jei", "analyzation");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, RecipeHolder<AnalyzationRecipe> analyzationRecipeHolder, IFocusGroup iFocusGroup) {
        AnalyzationRecipe analyzationRecipe = analyzationRecipeHolder.value();

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(analyzationRecipe.getIngredients().get(0));
        List<ItemStack> outputs = new ArrayList<>();
        analyzationRecipe.getResults().forEach(analyzationOutputs -> outputs.add(analyzationOutputs.getResult()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 95, 5).addItemStacks(outputs).addRichTooltipCallback((iRecipeSlotView, tooltip) -> {
            int weight = analyzationRecipe.getWeight(iRecipeSlotView.getDisplayedItemStack().get());
            if (weight > 0) {
                tooltip.add(Component.literal(weight + "%").withStyle(ChatFormatting.GRAY));
            }
        });
    }

    @Override
    public void draw(RecipeHolder<AnalyzationRecipe> analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IDrawableAnimated arrow = this.getArrow(analyzationRecipe);
        arrow.draw(guiGraphics, 61, 22);
    }
}
