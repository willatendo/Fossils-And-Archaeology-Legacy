package fossilslegacy.server.recipe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class AnalyzationRecipe implements Recipe<Container> {
	public final ResourceLocation id;
	public final Ingredient ingredient;
	public final List<ItemStack> results;
	public final List<Integer> weights;
	public final Map<ItemStack, Integer> resultsAndWeight = new HashMap<>();
	public final int time;

	public AnalyzationRecipe(ResourceLocation id, Ingredient ingredient, List<ItemStack> results, List<Integer> weights, int time) {
		this.id = id;
		this.ingredient = ingredient;
		this.results = results;
		this.weights = weights;
		for (int i = 0; i < results.size(); i++) {
			this.resultsAndWeight.put(results.get(i), weights.get(i));
		}
		this.time = time;
	}

	@Override
	public boolean matches(Container container, Level level) {
		return this.ingredient.test(container.getItem(0));
	}

	@Override
	public ItemStack assemble(Container container, RegistryAccess registryAccess) {
		SimpleWeightedRandomList.Builder<ItemStack> weightedRandomList = SimpleWeightedRandomList.builder();
		for (int i = 0; i < this.results.size(); i++) {
			ItemStack itemStack = this.results.get(i);
			Integer weight = this.weights.get(i);
			weightedRandomList.add(itemStack, weight);
		}
		return weightedRandomList.build().getRandom(RandomSource.create()).get().getData().copy();
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> nonnulllist = NonNullList.create();
		nonnulllist.add(this.ingredient);
		return nonnulllist;
	}

	public List<ItemStack> getResults() {
		return this.results;
	}

	public int getWeight(ItemStack itemStack) {
		return this.resultsAndWeight.get(itemStack);
	}

	@Override
	public boolean canCraftInDimensions(int x, int y) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return this.results.get(0);
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public ItemStack getToastSymbol() {
		return FossilsLegacyBlocks.ANALYZER.get().asItem().getDefaultInstance();
	}

	public int getTime() {
		return this.time;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return FossilsLegacyRecipeSerialisers.ANALYZATION.get();
	}

	@Override
	public RecipeType<?> getType() {
		return FossilsLegacyRecipeTypes.ANALYZATION.get();
	}
}
