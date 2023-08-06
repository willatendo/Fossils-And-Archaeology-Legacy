package fossilslegacy.data.recipe;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

public class AnalyzationRecipeBuilder implements RecipeBuilder {
	private final Ingredient ingredient;
	private final Map<Item, Integer> results = new HashMap<>();
	private final int time;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();

	private AnalyzationRecipeBuilder(Ingredient ingredient, ItemLike result, int weight, int time) {
		this.ingredient = ingredient;
		this.time = time;
		this.results.put(result.asItem(), weight);
	}

	public static AnalyzationRecipeBuilder recipe(Ingredient ingredient, ItemLike result, int weight, int time) {
		return new AnalyzationRecipeBuilder(ingredient, result, weight, time);
	}

	public static AnalyzationRecipeBuilder recipe(ItemLike ingredient, ItemLike result, int weight, int time) {
		return new AnalyzationRecipeBuilder(Ingredient.of(ingredient), result, weight, time);
	}

	public AnalyzationRecipeBuilder addResult(Item result, int weight) {
		this.results.put(result, weight);
		return this;
	}

	@Override
	public AnalyzationRecipeBuilder unlockedBy(String name, CriterionTriggerInstance criterionTriggerInstance) {
		this.advancement.addCriterion(name, criterionTriggerInstance);
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
	public void save(Consumer<FinishedRecipe> finishedRecipe, ResourceLocation recipeId) {
		this.ensureValid(recipeId);
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
		finishedRecipe.accept(new AnalyzationRecipeBuilder.Result(recipeId, this.ingredient, this.results, this.time, this.advancement, recipeId.withPrefix("recipes/archaeology/")));
	}

	private void ensureValid(ResourceLocation recipeId) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + recipeId);
		}
	}

	static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final Ingredient ingredient;
		private final Map<Item, Integer> result;
		private final int time;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation id, Ingredient ingredient, Map<Item, Integer> result, int time, Advancement.Builder advancement, ResourceLocation advancementId) {
			this.id = id;
			this.ingredient = ingredient;
			this.result = result;
			this.time = time;
			this.advancement = advancement;
			this.advancementId = advancementId;
		}

		@Override
		public void serializeRecipeData(JsonObject jsonObject) {
			jsonObject.add("ingredient", this.ingredient.toJson());
			JsonArray results = new JsonArray();
			for (int i = 0; i < this.result.size(); i++) {
				JsonObject result = new JsonObject();
				result.addProperty("result", ForgeRegistries.ITEMS.getKey(this.result.keySet().stream().toList().get(i)).toString());
				result.addProperty("weight", this.result.values().stream().toList().get(i));
				results.add(result);
			}
			jsonObject.add("results", results);
			jsonObject.addProperty("time", this.time);
		}

		@Override
		public RecipeSerializer<?> getType() {
			return FossilsLegacyRecipeSerialisers.ANALYZATION.get();
		}

		@Override
		public ResourceLocation getId() {
			return this.id;
		}

		@Override
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		@Override
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}
	}
}
