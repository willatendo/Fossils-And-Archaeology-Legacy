package willatendo.fossilslegacy.data.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe;
import willatendo.fossilslegacy.server.recipe.AnalyzationRecipe.AnalyzationOutputs;

public class AnalyzationRecipeBuilder implements RecipeBuilder {
	private final Ingredient ingredient;
	private final List<AnalyzationOutputs> analyzationOutputs = new ArrayList<>();
	private final Map<Item, Integer> results = new HashMap<>();
	private final int time;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap();

	private AnalyzationRecipeBuilder(Ingredient ingredient, ItemLike result, int weight, int time) {
		this.ingredient = ingredient;
		this.time = time;
		this.results.put(result.asItem(), weight);
		this.analyzationOutputs.add(new AnalyzationOutputs(new ItemStack(result), weight));
	}

	public static AnalyzationRecipeBuilder recipe(Ingredient ingredient, ItemLike result, int weight, int time) {
		return new AnalyzationRecipeBuilder(ingredient, result, weight, time);
	}

	public static AnalyzationRecipeBuilder recipe(ItemLike ingredient, ItemLike result, int weight, int time) {
		return new AnalyzationRecipeBuilder(Ingredient.of(ingredient), result, weight, time);
	}

	public AnalyzationRecipeBuilder addResult(Item result, int weight) {
		this.results.put(result, weight);
		this.analyzationOutputs.add(new AnalyzationOutputs(new ItemStack(result), weight));
		return this;
	}

	@Override
	public AnalyzationRecipeBuilder unlockedBy(String name, Criterion criterion) {
		this.criteria.put(name, criterion);
		return this;
	}

	@Override
	public Item getResult() {
		return this.results.keySet().stream().toList().get(0);
	}

	@Override
	public RecipeBuilder group(String group) {
		return null;
	}

	@Override
	public void save(RecipeOutput recipeOutput, ResourceLocation recipeId) {
		this.ensureValid(recipeId);
		Advancement.Builder builder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
		this.criteria.forEach(builder::addCriterion);
		recipeOutput.accept(recipeId, new AnalyzationRecipe(this.ingredient, this.analyzationOutputs, this.time), builder.build(recipeId.withPrefix("recipes/misc/")));
	}

	private void ensureValid(ResourceLocation recipeId) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + recipeId);
		}
	}
}
