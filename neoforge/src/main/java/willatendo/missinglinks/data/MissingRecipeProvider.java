package willatendo.missinglinks.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.missinglinks.server.block.MissingBlocks;

import java.util.concurrent.CompletableFuture;

public class MissingRecipeProvider extends RecipeProvider {
    protected MissingRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipeOutput) {
        super(registries, recipeOutput);
    }

    @Override
    protected void buildRecipes() {
        this.button(MissingBlocks.ANDESITE_BUTTON.get(), Blocks.ANDESITE);
        this.pressurePlate(MissingBlocks.ANDESITE_PRESSURE_PLATE.get(), Blocks.ANDESITE);
        this.lever(MissingBlocks.ANDESITE_LEVER.get(), Blocks.ANDESITE);
        this.slab(MissingBlocks.CALCITE_SLAB.get(), Blocks.CALCITE);
        this.stair(MissingBlocks.CALCITE_STAIRS.get(), Blocks.CALCITE);
        this.wall(MissingBlocks.CALCITE_WALL.get(), Blocks.CALCITE);
        this.button(MissingBlocks.CALCITE_BUTTON.get(), Blocks.CALCITE);
        this.pressurePlate(MissingBlocks.CALCITE_PRESSURE_PLATE.get(), Blocks.CALCITE);
        this.lever(MissingBlocks.CALCITE_LEVER.get(), Blocks.CALCITE);
        this.button(MissingBlocks.COBBLED_DEEPSLATE_BUTTON.get(), Blocks.COBBLED_DEEPSLATE);
        this.pressurePlate(MissingBlocks.COBBLED_DEEPSLATE_PRESSURE_PLATE.get(), Blocks.COBBLED_DEEPSLATE);
        this.lever(MissingBlocks.COBBLED_DEEPSLATE_LEVER.get(), Blocks.COBBLED_DEEPSLATE);
        this.button(MissingBlocks.COBBLESTONE_BUTTON.get(), Blocks.COBBLESTONE);
        this.pressurePlate(MissingBlocks.COBBLESTONE_PRESSURE_PLATE.get(), Blocks.COBBLESTONE);
        this.button(MissingBlocks.DIORITE_BUTTON.get(), Blocks.DIORITE);
        this.pressurePlate(MissingBlocks.DIORITE_PRESSURE_PLATE.get(), Blocks.DIORITE);
        this.lever(MissingBlocks.DIORITE_LEVER.get(), Blocks.DIORITE);
        this.button(MissingBlocks.GRANITE_BUTTON.get(), Blocks.GRANITE);
        this.pressurePlate(MissingBlocks.GRANITE_PRESSURE_PLATE.get(), Blocks.GRANITE);
        this.lever(MissingBlocks.GRANITE_LEVER.get(), Blocks.GRANITE);
        this.button(MissingBlocks.TUFF_BUTTON.get(), Blocks.TUFF);
        this.pressurePlate(MissingBlocks.TUFF_PRESSURE_PLATE.get(), Blocks.TUFF);
        this.lever(MissingBlocks.TUFF_LEVER.get(), Blocks.TUFF);
        this.lever(MissingBlocks.STONE_LEVER.get(), Blocks.STONE);
        this.wall(MissingBlocks.STONE_WALL.get(), Blocks.STONE);
    }

    private void button(Block button, Block base) {
        this.buttonBuilder(button, Ingredient.of(base)).unlockedBy(RecipeProvider.getHasName(base), this.has(base)).save(this.output);
    }

    private void pressurePlate(Block pressurePlate, Block base) {
        this.pressurePlateBuilder(RecipeCategory.REDSTONE, pressurePlate, Ingredient.of(base)).unlockedBy(RecipeProvider.getHasName(base), this.has(base)).save(this.output);
    }

    private void lever(Block lever, Block base) {
        this.shaped(RecipeCategory.REDSTONE, lever).define('#', base).define('X', Items.STICK).pattern("X").pattern("#").unlockedBy(RecipeProvider.getHasName(base), this.has(base)).save(this.output);
    }

    private void slab(Block slab, Block base) {
        this.slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(base)).unlockedBy(RecipeProvider.getHasName(base), this.has(base)).save(this.output);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, slab, base);
    }

    private void stair(Block stair, Block base) {
        this.stairBuilder(stair, Ingredient.of(base)).unlockedBy(RecipeProvider.getHasName(base), this.has(base)).save(this.output);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, stair, base);
    }

    private void wall(Block wall, Block base) {
        this.wallBuilder(RecipeCategory.BUILDING_BLOCKS, wall, Ingredient.of(base)).unlockedBy(RecipeProvider.getHasName(base), this.has(base)).save(this.output);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, wall, base);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new MissingRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Missing Links 2 Recipes";
        }
    }
}
