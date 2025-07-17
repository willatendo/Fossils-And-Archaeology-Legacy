package willatendo.fossilslegacy.client;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.server.registry.RecipeBookCategoryRegistry;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.registry.SimpleRegistry;

public final class FARecipeBookCategories {
    public static final RecipeBookCategoryRegistry RECIPE_BOOK_CATEGORIES = SimpleRegistry.createRecipeBookCategory(FAUtils.ID);

    public static final SimpleHolder<RecipeBookCategory> ANALYZATION_PALAEONTOLOGY = RECIPE_BOOK_CATEGORIES.registerSimple("analyzation_palaeontology");
    public static final SimpleHolder<RecipeBookCategory> ANALYZATION_ARCHAEOLOGY = RECIPE_BOOK_CATEGORIES.registerSimple("analyzation_archaeology");
    public static final SimpleHolder<RecipeBookCategory> ANALYZATION_PALAEOBOTANY = RECIPE_BOOK_CATEGORIES.registerSimple("analyzation_palaeobotany");
    public static final SimpleHolder<RecipeBookCategory> ANALYZATION_MISC = RECIPE_BOOK_CATEGORIES.registerSimple("analyzation_misc");
    public static final SimpleHolder<RecipeBookCategory> ARCHAEOLOGY_WORKBENCH_RESTORE = RECIPE_BOOK_CATEGORIES.registerSimple("archaeology_restore");
    public static final SimpleHolder<RecipeBookCategory> ARCHAEOLOGY_WORKBENCH_REPAIR = RECIPE_BOOK_CATEGORIES.registerSimple("archaeology_repair");
    public static final SimpleHolder<RecipeBookCategory> ARCHAEOLOGY_WORKBENCH_MISC = RECIPE_BOOK_CATEGORIES.registerSimple("archaeology_misc");
    public static final SimpleHolder<RecipeBookCategory> CULTIVATION_EGGS = RECIPE_BOOK_CATEGORIES.registerSimple("cultivation_eggs");
    public static final SimpleHolder<RecipeBookCategory> CULTIVATION_PLANTS = RECIPE_BOOK_CATEGORIES.registerSimple("cultivation_plants");
    public static final SimpleHolder<RecipeBookCategory> CULTIVATION_MISC = RECIPE_BOOK_CATEGORIES.registerSimple("cultivation_misc");
}
