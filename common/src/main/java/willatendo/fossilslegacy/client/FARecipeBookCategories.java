package willatendo.fossilslegacy.client;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FARecipeBookCategories {
    public static final SimpleRegistry<RecipeBookCategory> RECIPE_BOOK_CATEGORIES = SimpleRegistry.create(Registries.RECIPE_BOOK_CATEGORY, FAUtils.ID);

    public static final SimpleHolder<RecipeBookCategory> ANALYZATION_PALAEONTOLOGY = RECIPE_BOOK_CATEGORIES.register("analyzation_palaeontology", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> ANALYZATION_ARCHAEOLOGY = RECIPE_BOOK_CATEGORIES.register("analyzation_archaeology", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> ANALYZATION_MISC = RECIPE_BOOK_CATEGORIES.register("analyzation_misc", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> ARCHAEOLOGY_WORKBENCH_RESTORE = RECIPE_BOOK_CATEGORIES.register("archaeology_restore", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> ARCHAEOLOGY_WORKBENCH_REPAIR = RECIPE_BOOK_CATEGORIES.register("archaeology_repair", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> ARCHAEOLOGY_WORKBENCH_MISC = RECIPE_BOOK_CATEGORIES.register("archaeology_misc", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> CULTIVATION_EGGS = RECIPE_BOOK_CATEGORIES.register("cultivation_eggs", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> CULTIVATION_PLANTS = RECIPE_BOOK_CATEGORIES.register("cultivation_plants", RecipeBookCategory::new);
    public static final SimpleHolder<RecipeBookCategory> CULTIVATION_MISC = RECIPE_BOOK_CATEGORIES.register("cultivation_misc", RecipeBookCategory::new);
}
