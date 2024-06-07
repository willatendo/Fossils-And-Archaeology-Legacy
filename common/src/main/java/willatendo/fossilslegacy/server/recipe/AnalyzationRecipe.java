package willatendo.fossilslegacy.server.recipe;

import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyzationRecipe implements Recipe<Container> {
    public final Ingredient ingredient;
    public final List<AnalyzationOutputs> results;
    public final Map<ItemStack, Integer> resultsAndWeight = new HashMap<>();
    public final int time;

    public AnalyzationRecipe(Ingredient ingredient, List<AnalyzationOutputs> results, int time) {
        this.ingredient = ingredient;
        this.results = results;
        for (AnalyzationOutputs analyzationOutputs : results) {
            this.resultsAndWeight.put(analyzationOutputs.getResult(), analyzationOutputs.getWeight());
        }
        this.time = time;
    }

    @Override
    public boolean matches(Container container, Level level) {
        boolean matchesAny = false;
        for (int i = 0; i < 10; i++) {
            if (this.ingredient.test(container.getItem(i))) {
                matchesAny = true;
                break;
            } else {
                continue;
            }
        }
        return matchesAny;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        SimpleWeightedRandomList.Builder<ItemStack> weightedRandomList = SimpleWeightedRandomList.builder();
        for (int i = 0; i < this.results.size(); i++) {
            ItemStack itemStack = this.results.get(i).getResult();
            Integer weight = this.results.get(i).getWeight();
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

    public List<AnalyzationOutputs> getResults() {
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
        return this.results.get(0).getResult();
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

    public Map<ItemStack, Integer> getResultsAndWeight() {
        Map<ItemStack, Integer> map = new HashMap<>();
        this.resultsAndWeight.forEach((result, weight) -> {
            map.put(result, weight);
        });
        return map;
    }

    public static class AnalyzationOutputs {
        public final ItemStack result;
        public final int weight;

        public AnalyzationOutputs(ItemStack result, int weight) {
            this.result = result;
            this.weight = weight;
        }

        public ItemStack getResult() {
            return this.result;
        }

        public int getWeight() {
            return this.weight;
        }
    }
}
