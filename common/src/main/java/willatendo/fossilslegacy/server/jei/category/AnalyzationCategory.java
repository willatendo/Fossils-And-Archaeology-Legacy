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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.jei.FAJEIRecipeTypes;
import willatendo.fossilslegacy.server.jei.FAJEITextures;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AnalyzationCategory extends AbstractRecipeCategory<RecipeHolder<AnalyzationRecipe>> {
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
    private final IDrawable arrowOutline;

    public AnalyzationCategory(IGuiHelper guiHelper, FAJEITextures FAJEITextures) {
        super(FAJEIRecipeTypes.ANALYZATION, FossilsLegacyUtils.translation("jei", "analyzation"), guiHelper.createDrawableItemLike(FABlocks.ANALYZER.get()), 144, 54);
        this.cachedArrows = FAJEITextures.createAnalyzationBar();
        this.arrowOutline = FAJEITextures.getAnalyzationArrow();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, RecipeHolder<AnalyzationRecipe> analyzationRecipeHolder, IFocusGroup iFocusGroup) {
        AnalyzationRecipe analyzationRecipe = analyzationRecipeHolder.value();

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 1, 1).setStandardSlotBackground().addIngredients(analyzationRecipe.getIngredients().getFirst());
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (!(x == 0 && y == 0)) {
                    iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 1 + (x * 18), 1 + (y * 18)).setStandardSlotBackground();
                }
            }
        }

        Registry<AnalyzerResult> analyzerResultRegistry = Minecraft.getInstance().level.registryAccess().registryOrThrow(FARegistries.ANALYZER_RESULT);
        Map<ItemStack, AnalyzerResult> map = new HashMap<>();
        List<AnalyzerResult> analyzerResults = new ArrayList<>();
        List<ItemStack> outputs = new ArrayList<>();
        analyzerResultRegistry.getTag(analyzationRecipe.results).get().forEach(analyzerResultHolder -> analyzerResults.add(analyzerResultHolder.value()));
        analyzerResults.forEach(analyzerResult -> {
            ItemStack outputStack = analyzerResult.output();
            outputs.add(outputStack);
            map.put(outputStack, analyzerResult);
        });
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 95, 5).setOutputSlotBackground().addItemStacks(outputs);
        for (int x = 0; x < 3; x++) {
            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 91 + (x * 18), 37).setStandardSlotBackground();
        }
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder iRecipeExtrasBuilder, RecipeHolder<AnalyzationRecipe> recipeHolder, IRecipeSlotsView iRecipeSlotsView, IFocusGroup iFocusGroup) {
        this.addTime(iRecipeExtrasBuilder, recipeHolder);
    }

    @Override
    public void draw(RecipeHolder<AnalyzationRecipe> analyzationRecipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.arrowOutline.draw(guiGraphics, 62, 23);
        IDrawableAnimated arrow = this.getArrow(analyzationRecipe);
        arrow.draw(guiGraphics, 62, 23);
    }

    private IDrawableAnimated getArrow(RecipeHolder<AnalyzationRecipe> analyzationRecipeHolder) {
        int analyzeTime = analyzationRecipeHolder.value().getTime();
        if (analyzeTime <= 0) {
            analyzeTime = 100;
        }
        return this.cachedArrows.getUnchecked(analyzeTime);
    }

    private void addTime(IRecipeExtrasBuilder builder, RecipeHolder<AnalyzationRecipe> recipeHolder) {
        AnalyzationRecipe recipe = recipeHolder.value();
        int cookTime = recipe.getTime();
        if (cookTime <= 0) {
            cookTime = 100;
        }
        int cookTimeSeconds = cookTime / 20;
        Component timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
        builder.addText(timeString, 20, 10, getWidth() - 20, 10).alignHorizontalRight().alignVerticalBottom().setColor(0xFF808080);
    }
}
