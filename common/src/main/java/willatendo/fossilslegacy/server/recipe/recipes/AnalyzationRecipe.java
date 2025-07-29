package willatendo.fossilslegacy.server.recipe.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.client.FARecipeBookCategories;
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.entity.crafting.AnalyzerRecipeInput;
import willatendo.fossilslegacy.server.menu.categories.AnalyzationBookCategory;
import willatendo.fossilslegacy.server.recipe.FARecipeSerialisers;
import willatendo.fossilslegacy.server.recipe.FARecipeTypes;
import willatendo.fossilslegacy.server.recipe.display.AnalyzationRecipeDisplay;
import willatendo.fossilslegacy.server.recipe.display.ItemStacksSlotDisplay;
import willatendo.fossilslegacy.server.registry.FARegistries;

import java.util.List;

public class AnalyzationRecipe implements Recipe<AnalyzerRecipeInput> {
    public final AnalyzationBookCategory analyzationBookCategory;
    public final Ingredient ingredient;
    public final TagKey<AnalyzerResult> results;
    public final int time;
    public final boolean createsPureDNA;
    public String group;

    public AnalyzationRecipe(AnalyzationBookCategory analyzationBookCategory, String group, boolean createsPureDNA, Ingredient ingredient, TagKey<AnalyzerResult> results, int time) {
        this.analyzationBookCategory = analyzationBookCategory;
        this.group = group;
        this.createsPureDNA = createsPureDNA;
        this.ingredient = ingredient;
        this.results = results;
        this.time = time;
    }

    public TagKey<AnalyzerResult> getResults() {
        return this.results;
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

    public int getTime() {
        return this.time;
    }

    @Override
    public RecipeSerializer<? extends Recipe<AnalyzerRecipeInput>> getSerializer() {
        return FARecipeSerialisers.ANALYZATION.get();
    }

    @Override
    public RecipeType<? extends Recipe<AnalyzerRecipeInput>> getType() {
        return FARecipeTypes.ANALYZATION.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.ingredient);
    }

    @Override
    public List<RecipeDisplay> display() {
        return List.of(new AnalyzationRecipeDisplay(this.ingredient.display(), new ItemStacksSlotDisplay(this.results), new SlotDisplay.ItemSlotDisplay(FABlocks.DNA_ANALYZER.get().asItem()), this.time));
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        RecipeBookCategory recipeBookCategory;
        switch (this.analyzationBookCategory) {
            case PALAEONTOLOGY -> recipeBookCategory = FARecipeBookCategories.ANALYZATION_PALAEONTOLOGY.get();
            case PALAEOBOTANY -> recipeBookCategory = FARecipeBookCategories.ANALYZATION_PALAEOBOTANY.get();
            case MISC -> recipeBookCategory = FARecipeBookCategories.ANALYZATION_MISC.get();
            default -> throw new MatchException(null, null);
        }
        return recipeBookCategory;
    }
}
