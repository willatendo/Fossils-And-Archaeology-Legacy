package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import willatendo.fossilslegacy.server.recipe.display.AnalyzationRecipeDisplay;
import willatendo.fossilslegacy.server.recipe.display.ArchaeologyRecipeDisplay;
import willatendo.fossilslegacy.server.recipe.display.CultivationRecipeDisplay;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public class FARecipeDisplays {
    public static final SimpleRegistry<RecipeDisplay.Type<?>> RECIPE_DISPLAY_TYPES = SimpleRegistry.create(Registries.RECIPE_DISPLAY, FAUtils.ID);

    public static final SimpleHolder<RecipeDisplay.Type<AnalyzationRecipeDisplay>> ANALYZER = RECIPE_DISPLAY_TYPES.register("analyzer", () -> AnalyzationRecipeDisplay.TYPE);
    public static final SimpleHolder<RecipeDisplay.Type<ArchaeologyRecipeDisplay>> ARCHAEOLOGY = RECIPE_DISPLAY_TYPES.register("archaeology", () -> ArchaeologyRecipeDisplay.TYPE);
    public static final SimpleHolder<RecipeDisplay.Type<CultivationRecipeDisplay>> CULTIVATION = RECIPE_DISPLAY_TYPES.register("cultivation", () -> CultivationRecipeDisplay.TYPE);
}
