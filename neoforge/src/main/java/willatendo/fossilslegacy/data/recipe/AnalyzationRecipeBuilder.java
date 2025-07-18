package willatendo.fossilslegacy.data.recipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.menu.categories.AnalyzationBookCategory;
import willatendo.fossilslegacy.server.recipe.recipes.AnalyzationRecipe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class AnalyzationRecipeBuilder implements RecipeBuilder {
    private final AnalyzationBookCategory analyzationBookCategory;
    private final Ingredient ingredient;
    private final TagKey<AnalyzerResult> results;
    private final int time;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    private boolean createsPureDNA = true;
    private String group;

    private AnalyzationRecipeBuilder(AnalyzationBookCategory analyzationBookCategory, Ingredient ingredient, TagKey<AnalyzerResult> results, int time) {
        this.analyzationBookCategory = analyzationBookCategory;
        this.ingredient = ingredient;
        this.time = time;
        this.results = results;
    }

    public static AnalyzationRecipeBuilder recipe(AnalyzationBookCategory analyzationBookCategory, Ingredient ingredient, TagKey<AnalyzerResult> results, int time) {
        return new AnalyzationRecipeBuilder(analyzationBookCategory, ingredient, results, time);
    }

    @Override
    public AnalyzationRecipeBuilder unlockedBy(String name, Criterion criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public AnalyzationRecipeBuilder group(String group) {
        this.group = group;
        return this;
    }

    public AnalyzationRecipeBuilder doesNotCreatePureDNA() {
        this.createsPureDNA = false;
        return this;
    }

    @Override
    public Item getResult() {
        return null;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> recipeId) {
        this.ensureValid(recipeId);
        Advancement.Builder builder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        recipeOutput.accept(recipeId, new AnalyzationRecipe(this.analyzationBookCategory, Objects.requireNonNullElse(this.group, ""), this.createsPureDNA, this.ingredient, this.results, this.time), builder.build(recipeId.location().withPrefix("recipes/misc/")));
    }

    private void ensureValid(ResourceKey<Recipe<?>> recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId.location());
        }
    }
}
