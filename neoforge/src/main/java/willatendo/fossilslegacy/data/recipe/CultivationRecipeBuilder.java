package willatendo.fossilslegacy.data.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.menu.categories.CultivationBookCategory;
import willatendo.fossilslegacy.server.recipe.recipes.CultivationRecipe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class CultivationRecipeBuilder implements RecipeBuilder {
    private final CultivationBookCategory cultivationBookCategory;
    private final Item result;
    private final Ingredient ingredient;
    private final int time;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    private String group;

    private CultivationRecipeBuilder(CultivationBookCategory cultivationBookCategory, String group, ItemLike itemLike, Ingredient ingredient, int time) {
        this.cultivationBookCategory = cultivationBookCategory;
        this.group = group;
        this.result = itemLike.asItem();
        this.ingredient = ingredient;
        this.time = time;
    }

    public static <T extends AbstractCookingRecipe> CultivationRecipeBuilder recipe(CultivationBookCategory cultivationBookCategory, String group, Item ingredient, ItemLike itemLike, int time) {
        return new CultivationRecipeBuilder(cultivationBookCategory, group, itemLike, Ingredient.of(ingredient), time);
    }

    @Override
    public CultivationRecipeBuilder unlockedBy(String string, Criterion<?> criterion) {
        this.criteria.put(string, criterion);
        return this;
    }

    @Override
    public CultivationRecipeBuilder group(String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> recipeId) {
        this.ensureValid(recipeId);
        Advancement.Builder builder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        recipeOutput.accept(recipeId, new CultivationRecipe(this.cultivationBookCategory, Objects.requireNonNullElse(this.group, ""), this.ingredient, new ItemStack(this.result), this.time), builder.build(recipeId.location().withPrefix("recipes/misc/")));
    }

    private void ensureValid(ResourceKey<Recipe<?>> recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
}
