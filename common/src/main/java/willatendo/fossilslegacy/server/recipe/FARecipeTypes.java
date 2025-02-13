package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.ArchaeologyRecipe;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.recipe.SimpleRecipeType;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FARecipeTypes {
    public static final SimpleRegistry<RecipeType<?>> RECIPE_TYPES = SimpleRegistry.create(Registries.RECIPE_TYPE, FAUtils.ID);

    public static final SimpleHolder<SimpleRecipeType<AnalyzationRecipe>> ANALYZATION = RECIPE_TYPES.register("analyzation", SimpleRecipeType::new);
    public static final SimpleHolder<SimpleRecipeType<ArchaeologyRecipe>> ARCHAEOLOGY = RECIPE_TYPES.register("archaeology", SimpleRecipeType::new);
    public static final SimpleHolder<SimpleRecipeType<CultivationRecipe>> CULTIVATION = RECIPE_TYPES.register("cultivation", SimpleRecipeType::new);
}
