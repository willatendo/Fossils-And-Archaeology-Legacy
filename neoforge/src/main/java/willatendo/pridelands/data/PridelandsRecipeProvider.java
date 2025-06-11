package willatendo.pridelands.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import willatendo.pridelands.server.block.PridelandsBlocks;
import willatendo.pridelands.server.item.PridelandsItems;
import willatendo.pridelands.server.utils.PridelandsUtils;

import java.util.concurrent.CompletableFuture;

public class PridelandsRecipeProvider extends RecipeProvider {
    protected PridelandsRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipeOutput) {
        super(registries, recipeOutput);
    }

    @Override
    protected void buildRecipes() {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_SLAB.get(), 6).pattern("###").define('#', PridelandsBlocks.OUTSTONE.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE.get()), has(PridelandsBlocks.OUTSTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_STAIRS.get(), 4).pattern("#  ").pattern("## ").pattern("###").define('#', PridelandsBlocks.OUTSTONE.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE.get()), has(PridelandsBlocks.OUTSTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_PRESSURE_PLATE.get()).pattern("##").define('#', PridelandsBlocks.OUTSTONE.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE.get()), has(PridelandsBlocks.OUTSTONE.get())).save(this.output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BUTTON.get()).requires(PridelandsBlocks.OUTSTONE.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE.get()), has(PridelandsBlocks.OUTSTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICKS.get(), 6).pattern("##").pattern("##").define('#', PridelandsBlocks.OUTSTONE.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE.get()), has(PridelandsBlocks.OUTSTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_SLAB.get(), 6).pattern("###").define('#', PridelandsBlocks.OUTSTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE_BRICKS.get()), has(PridelandsBlocks.OUTSTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get(), 4).pattern("#  ").pattern("## ").pattern("###").define('#', PridelandsBlocks.OUTSTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE_BRICKS.get()), has(PridelandsBlocks.OUTSTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_WALL.get(), 6).pattern("###").pattern("###").define('#', PridelandsBlocks.OUTSTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.OUTSTONE_BRICKS.get()), has(PridelandsBlocks.OUTSTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_SLAB.get(), 6).pattern("###").define('#', PridelandsBlocks.PRIDESTONE.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE.get()), has(PridelandsBlocks.PRIDESTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_STAIRS.get(), 4).pattern("#  ").pattern("## ").pattern("###").define('#', PridelandsBlocks.PRIDESTONE.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE.get()), has(PridelandsBlocks.PRIDESTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_PRESSURE_PLATE.get()).pattern("##").define('#', PridelandsBlocks.PRIDESTONE.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE.get()), has(PridelandsBlocks.PRIDESTONE.get())).save(this.output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BUTTON.get()).requires(PridelandsBlocks.PRIDESTONE.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE.get()), has(PridelandsBlocks.PRIDESTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICKS.get(), 6).pattern("##").pattern("##").define('#', PridelandsBlocks.PRIDESTONE.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE.get()), has(PridelandsBlocks.PRIDESTONE.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get(), 6).pattern("###").define('#', PridelandsBlocks.PRIDESTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.PRIDESTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get(), 4).pattern("#  ").pattern("## ").pattern("###").define('#', PridelandsBlocks.PRIDESTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.PRIDESTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_WALL.get(), 6).pattern("###").pattern("###").define('#', PridelandsBlocks.PRIDESTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.PRIDESTONE_BRICKS.get())).save(this.output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get(), 6).requires(PridelandsBlocks.PRIDESTONE_BRICKS.get()).requires(Blocks.VINE).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.PRIDESTONE_BRICKS.get())).save(this.output, PridelandsUtils.ID + ":mossy_pridestone_bricks_from_vine");
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get(), 6).requires(PridelandsBlocks.PRIDESTONE_BRICKS.get()).requires(Blocks.MOSS_BLOCK).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.PRIDESTONE_BRICKS.get())).save(this.output, PridelandsUtils.ID + ":mossy_pridestone_bricks_from_moss_block");
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_SLAB.get(), 6).pattern("###").define('#', PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_STAIRS.get(), 4).pattern("#  ").pattern("## ").pattern("###").define('#', PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_WALL.get(), 6).pattern("###").pattern("###").define('#', PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get()).unlockedBy(getHasName(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get()), has(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get())).save(this.output);
        this.shaped(RecipeCategory.DECORATIONS, PridelandsBlocks.FUR_RUG.get(), 4).pattern("##").pattern("##").define('#', PridelandsItems.LION_FUR.get()).unlockedBy(getHasName(PridelandsItems.LION_FUR.get()), this.has(PridelandsItems.LION_FUR.get())).save(this.output);
        // Bugs and Jaw this.shapeless(RecipeCategory.FOOD, PridelandsItems.BUG_STEW.get()).requires(Items.BOWL).save(this.output);
        this.shaped(RecipeCategory.FOOD, PridelandsItems.BANANA_BREAD.get()).pattern("#$#").define('#', Items.WHEAT).define('$', PridelandsItems.BANANA.get()).unlockedBy(getHasName(PridelandsItems.BANANA.get()), this.has(PridelandsItems.BANANA.get())).save(this.output);
        this.shapeless(RecipeCategory.FOOD, PridelandsItems.MANGO_JUICE_PRIDESTONE_JAR.get()).requires(PridelandsItems.MANGO.get(), 2).requires(PridelandsItems.WATER_PRIDESTONE_JAR.get()).unlockedBy(getHasName(PridelandsItems.MANGO.get()), this.has(PridelandsItems.MANGO.get())).save(this.output);
        this.shaped(RecipeCategory.TOOLS, PridelandsItems.PRIDESTONE_JAR.get()).pattern("# #").pattern(" # ").define('#', PridelandsBlocks.PRIDESTONE.get()).unlockedBy(getHasName(PridelandsBlocks.PRIDESTONE.get()), this.has(PridelandsBlocks.PRIDESTONE.get())).save(this.output);
        this.tools(PridelandsBlocks.PRIDESTONE.get(), PridelandsItems.PRIDESTONE_SWORD.get(), PridelandsItems.PRIDESTONE_SHOVEL.get(), PridelandsItems.PRIDESTONE_PICKAXE.get(), PridelandsItems.PRIDESTONE_AXE.get(), PridelandsItems.PRIDESTONE_HOE.get());
        this.tools(PridelandsItems.SILVER_INGOT.get(), PridelandsItems.SILVER_SWORD.get(), PridelandsItems.SILVER_SHOVEL.get(), PridelandsItems.SILVER_PICKAXE.get(), PridelandsItems.SILVER_AXE.get(), PridelandsItems.SILVER_HOE.get());
        this.tools(PridelandsItems.PEACOCK_GEM.get(), PridelandsItems.PEACOCK_SWORD.get(), PridelandsItems.PEACOCK_SHOVEL.get(), PridelandsItems.PEACOCK_PICKAXE.get(), PridelandsItems.PEACOCK_AXE.get(), PridelandsItems.PEACOCK_HOE.get());

        this.smeltingResultFromBase(PridelandsBlocks.CRACKED_PRIDESTONE_BRICKS.get(), PridelandsBlocks.PRIDESTONE_BRICKS.get());
        this.food(PridelandsItems.COOKED_LION.get(), PridelandsItems.LION.get());
        this.food(PridelandsItems.COOKED_ZEBRA.get(), PridelandsItems.ZEBRA.get());
        this.food(PridelandsItems.COOKED_RHINO.get(), PridelandsItems.RHINO.get());
        this.food(PridelandsItems.POPCORN.get(), PridelandsItems.CORN.get());
        this.food(PridelandsItems.ROASTED_YAM.get(), PridelandsItems.YAM.get());

        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_SLAB.get(), PridelandsBlocks.OUTSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_STAIRS.get(), PridelandsBlocks.OUTSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICKS.get(), PridelandsBlocks.OUTSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_SLAB.get(), PridelandsBlocks.OUTSTONE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get(), PridelandsBlocks.OUTSTONE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_WALL.get(), PridelandsBlocks.OUTSTONE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_SLAB.get(), PridelandsBlocks.OUTSTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get(), PridelandsBlocks.OUTSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.OUTSTONE_BRICK_WALL.get(), PridelandsBlocks.OUTSTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_SLAB.get(), PridelandsBlocks.PRIDESTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_STAIRS.get(), PridelandsBlocks.PRIDESTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICKS.get(), PridelandsBlocks.PRIDESTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get(), PridelandsBlocks.PRIDESTONE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get(), PridelandsBlocks.PRIDESTONE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_WALL.get(), PridelandsBlocks.PRIDESTONE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get(), PridelandsBlocks.PRIDESTONE.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get(), PridelandsBlocks.PRIDESTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.PRIDESTONE_BRICK_WALL.get(), PridelandsBlocks.PRIDESTONE.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_SLAB.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get(), 2);
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_STAIRS.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get());
        this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_WALL.get(), PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get());
    }

    protected void food(Item cooked, Item raw) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw), RecipeCategory.FOOD, cooked, 0.35F, 200).unlockedBy(getHasName(raw), has(raw)).save(this.output);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(raw), RecipeCategory.FOOD, cooked, 0.35F, 100).unlockedBy(getHasName(raw), has(raw)).save(this.output, PridelandsUtils.ID + ":" + getItemName(cooked) + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(raw), RecipeCategory.FOOD, cooked, 0.35F, 600).unlockedBy(getHasName(raw), has(raw)).save(this.output, PridelandsUtils.ID + ":" + getItemName(cooked) + "_from_campfire_cooking");
    }

    protected void tools(ItemLike material, ItemLike sword, ItemLike shovel, ItemLike pickaxe, ItemLike axe, ItemLike hoe) {
        this.shaped(RecipeCategory.COMBAT, sword).pattern("#").pattern("#").pattern("$").define('#', material).define('$', Items.STICK).unlockedBy(getHasName(material), this.has(material)).save(this.output);
        this.shaped(RecipeCategory.TOOLS, shovel).pattern("#").pattern("$").pattern("$").define('#', material).define('$', Items.STICK).unlockedBy(getHasName(material), this.has(material)).save(this.output);
        this.shaped(RecipeCategory.TOOLS, pickaxe).pattern("###").pattern(" $ ").pattern(" $ ").define('#', material).define('$', Items.STICK).unlockedBy(getHasName(material), this.has(material)).save(this.output);
        this.shaped(RecipeCategory.TOOLS, axe).pattern("##").pattern("#$").pattern(" $").define('#', material).define('$', Items.STICK).unlockedBy(getHasName(material), this.has(material)).save(this.output);
        this.shaped(RecipeCategory.TOOLS, hoe).pattern("##").pattern(" $").pattern(" $").define('#', material).define('$', Items.STICK).unlockedBy(getHasName(material), this.has(material)).save(this.output);
    }

    @Override
    protected void stonecutterResultFromBase(RecipeCategory recipeCategory, ItemLike result, ItemLike material, int resultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(material), recipeCategory, result, resultCount).unlockedBy(RecipeProvider.getHasName(material), this.has(material)).save(this.output, PridelandsUtils.ID + ":" + RecipeProvider.getConversionRecipeName(result, material) + "_stonecutting");
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new PridelandsRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Pridelands Recipes";
        }
    }
}
