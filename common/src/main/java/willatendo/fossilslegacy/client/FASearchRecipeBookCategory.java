package willatendo.fossilslegacy.client;

import net.minecraft.world.item.crafting.ExtendedRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategory;

import java.util.List;

public enum FASearchRecipeBookCategory implements ExtendedRecipeBookCategory {
    ANALYZATION(FARecipeBookCategories.ANALYZATION_PALAEONTOLOGY.get(), FARecipeBookCategories.ANALYZATION_ARCHAEOLOGY.get(), FARecipeBookCategories.ANALYZATION_PALAEOBOTANY.get(), FARecipeBookCategories.ANALYZATION_MISC.get()),
    ARCHAEOLOGY_WORKBENCH(FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_RESTORE.get(), FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_REPAIR.get(), FARecipeBookCategories.ARCHAEOLOGY_WORKBENCH_MISC.get()),
    CULTIVATION(FARecipeBookCategories.CULTIVATION_EGGS.get(), FARecipeBookCategories.CULTIVATION_PLANTS.get(), FARecipeBookCategories.CULTIVATION_MISC.get());

    private final List<RecipeBookCategory> includedCategories;

    FASearchRecipeBookCategory(RecipeBookCategory... includedCategories) {
        this.includedCategories = List.of(includedCategories);
    }

    public List<RecipeBookCategory> includedCategories() {
        return this.includedCategories;
    }
}
