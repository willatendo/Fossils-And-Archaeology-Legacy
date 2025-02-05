package willatendo.fossilslegacy.server.recipe.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.NonNullList;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.crafting.AnalyzerRecipeInput;
import willatendo.fossilslegacy.server.menu.categories.AnalyzationBookCategory;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.registry.FARegistries;

public class AnalyzationRecipe implements Recipe<AnalyzerRecipeInput> {
    public final AnalyzationBookCategory analyzationBookCategory;
    public final Ingredient ingredient;
    public final TagKey<AnalyzerResult> results;
    public final int time;
    public String group;

    public AnalyzationRecipe(AnalyzationBookCategory analyzationBookCategory, String group, Ingredient ingredient, TagKey<AnalyzerResult> results, int time) {
        this.analyzationBookCategory = analyzationBookCategory;
        this.group = group;
        this.ingredient = ingredient;
        this.results = results;
        this.time = time;
    }

    @Override
    public boolean matches(AnalyzerRecipeInput analyzerRecipeInput, Level level) {
        boolean matchesAny = false;
        for (int i = 0; i < 10; i++) {
            if (this.ingredient.test(analyzerRecipeInput.getItem(i))) {
                matchesAny = true;
                break;
            }
        }
        return matchesAny;
    }

    @Override
    public ItemStack assemble(AnalyzerRecipeInput analyzerRecipeInput, HolderLookup.Provider provider) {
        SimpleWeightedRandomList.Builder<ItemStack> weightedRandomList = SimpleWeightedRandomList.builder();
        HolderLookup.RegistryLookup<AnalyzerResult> registryLookup = provider.lookupOrThrow(FARegistries.ANALYZER_RESULT);
        HolderSet.Named<AnalyzerResult> analyzerResults = registryLookup.getOrThrow(this.results);
        for (int i = 0; i < analyzerResults.size(); i++) {
            weightedRandomList.add(analyzerResults.get(i).value().output(), analyzerResults.get(i).value().weight());
        }
        return weightedRandomList.build().getRandom(RandomSource.create()).get().data().copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    @Override
    public boolean canCraftInDimensions(int x, int y) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return provider.lookupOrThrow(FARegistries.ANALYZER_RESULT).getOrThrow(this.results).get(0).value().output();
    }

    @Override
    public ItemStack getToastSymbol() {
        return FABlocks.ANALYZER.get().asItem().getDefaultInstance();
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return FARecipeSerialisers.ANALYZATION.get();
    }

    @Override
    public RecipeType<?> getType() {
        return FARecipeTypes.ANALYZATION.get();
    }
}
