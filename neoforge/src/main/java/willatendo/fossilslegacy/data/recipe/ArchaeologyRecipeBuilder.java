package willatendo.fossilslegacy.data.recipe;

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
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import willatendo.fossilslegacy.server.inventory.ArchaeologyBookCategory;
import willatendo.fossilslegacy.server.recipe.ArchaeologyRecipe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ArchaeologyRecipeBuilder implements RecipeBuilder {
    private final ArchaeologyBookCategory archaeologyBookCategory;
    private final Item result;
    private final Ingredient ingredient;
    private final int time;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    private String group;

    private ArchaeologyRecipeBuilder(ArchaeologyBookCategory archaeologyBookCategory, ItemLike itemLike, Ingredient ingredient, int time) {
        this.archaeologyBookCategory = archaeologyBookCategory;
        this.result = itemLike.asItem();
        this.ingredient = ingredient;
        this.time = time;
    }

    public static <T extends AbstractCookingRecipe> ArchaeologyRecipeBuilder recipe(ArchaeologyBookCategory archaeologyBookCategory, Item ingredient, ItemLike itemLike, int time) {
        return new ArchaeologyRecipeBuilder(archaeologyBookCategory, itemLike, Ingredient.of(ingredient), time);
    }

    @Override
    public ArchaeologyRecipeBuilder unlockedBy(String string, Criterion<?> criterion) {
        this.criteria.put(string, criterion);
        return this;
    }

    @Override
    public ArchaeologyRecipeBuilder group(String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        Advancement.Builder builder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        recipeOutput.accept(recipeId, new ArchaeologyRecipe(this.archaeologyBookCategory, Objects.requireNonNullElse(this.group, ""), this.ingredient, new ItemStack(this.result), this.time), builder.build(recipeId.withPrefix("recipes/misc/")));
    }

    private void ensureValid(ResourceLocation recipeId) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
}
