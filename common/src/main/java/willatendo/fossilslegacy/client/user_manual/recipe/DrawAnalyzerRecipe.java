package willatendo.fossilslegacy.client.user_manual.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.user_manual.draw.SlotPlacer;
import willatendo.fossilslegacy.client.user_manual.draw.SpriteDrawer;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.registry.FARegistries;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.List;

public class DrawAnalyzerRecipe implements DrawRecipe {
    @Override
    public void draw(Level level, Recipe<?> recipe, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
        HolderLookup.Provider registries = level.registryAccess();
        if (recipe instanceof AnalyzationRecipe analyzationRecipe) {
            List<Ingredient> ingredients = recipe.placementInfo().ingredients();
            HolderLookup.RegistryLookup<AnalyzerResult> registryLookup = registries.lookupOrThrow(FARegistries.ANALYZER_RESULT);
            HolderSet.Named<AnalyzerResult> analyzerResults = registryLookup.getOrThrow(analyzationRecipe.getResults());
            List<ItemStack> outputs = analyzerResults.stream().map(analyzerResult -> analyzerResult.value().output()).toList();
            List<Component> weights = analyzerResults.stream().map(analyzerResult -> (Component) FAUtils.translation("item", "user_manual.recipes.description", (analyzerResult.value().weight() + "%"))).toList();

            slotPlacer.place(28, 18, ingredients.getFirst());
            slotPlacer.place(122, 22, outputs);

            spriteDrawer.draw(145, 26, weights, 0);
        }
    }
}
