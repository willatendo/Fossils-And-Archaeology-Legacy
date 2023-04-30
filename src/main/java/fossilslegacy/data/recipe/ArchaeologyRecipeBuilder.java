package fossilslegacy.data.recipe;

import java.util.function.Consumer;

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

public class ArchaeologyRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final Ingredient ingredient;
	private final int time;
	private final Advancement.Builder advancement = Advancement.Builder.advancement();

	private ArchaeologyRecipeBuilder(ItemLike result, Ingredient ingredient, int time) {
		this.result = result.asItem();
		this.ingredient = ingredient;
		this.time = time;
	}

	public static ArchaeologyRecipeBuilder recipe(Ingredient ingredient, ItemLike result, int time) {
		return new ArchaeologyRecipeBuilder(result, ingredient, time);
	}

	public static ArchaeologyRecipeBuilder recipe(ItemLike ingredient, ItemLike result, int time) {
		return new ArchaeologyRecipeBuilder(result, Ingredient.of(ingredient), time);
	}

	@Override
	public ArchaeologyRecipeBuilder unlockedBy(String name, CriterionTriggerInstance criterionTriggerInstance) {
		this.advancement.addCriterion(name, criterionTriggerInstance);
		return this;
	}

	@Override
	public Item getResult() {
		return this.result;
	}

	@Override
	public RecipeBuilder group(String group) {
		return null;
	}

	@Override
	public void save(Consumer<FinishedRecipe> finishedRecipe, ResourceLocation recipeId) {
		this.ensureValid(recipeId);
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
		finishedRecipe.accept(new ArchaeologyRecipeBuilder.Result(recipeId, this.ingredient, this.result, this.time, this.advancement, recipeId.withPrefix("recipes/archaeology/")));
	}

	private void ensureValid(ResourceLocation recipeId) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + recipeId);
		}
	}

	static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final Ingredient ingredient;
		private final Item result;
		private final int time;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation id, Ingredient ingredient, Item result, int time, Advancement.Builder advancement, ResourceLocation advancementId) {
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
			jsonObject.addProperty("result", ForgeRegistries.ITEMS.getKey(this.result).toString());
			jsonObject.addProperty("time", this.time);
		}

		@Override
		public RecipeSerializer<?> getType() {
			return FossilsLegacyRecipeSerialisers.ARCHAEOLOGY.get();
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
