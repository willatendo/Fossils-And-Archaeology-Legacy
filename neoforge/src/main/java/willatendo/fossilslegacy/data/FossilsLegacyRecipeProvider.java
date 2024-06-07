package willatendo.fossilslegacy.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.data.recipe.AnalyzationRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.ArchaeologyRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.CultivationRecipeBuilder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.recipe.MagicConchRecipe;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRecipeProvider extends RecipeProvider {
    public FossilsLegacyRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Items.CAKE).pattern("###").pattern("$%$").pattern("&&&").define('#', Items.MILK_BUCKET).define('$', Items.SUGAR).define('%', FossilsLegacyItemTags.CAKE_EGGS).define('&', Items.WHEAT).unlockedBy("has_item", has(FossilsLegacyItemTags.CAKE_EGGS)).save(recipeOutput, FossilsLegacyUtils.resource("cake_from_eggs"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get(), 8).pattern("###").pattern("#$#").pattern("###").define('#', Items.GLASS_BOTTLE).define('$', FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get()).unlockedBy("has_item", has(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get())).save(recipeOutput, FossilsLegacyUtils.resource("chicken_essence_bottle"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get()).requires(Items.BUCKET).requires(Items.SWEET_BERRIES, 4).requires(Items.CARROT).requires(Items.POTATO).requires(Items.BEEF).requires(Items.PORKCHOP).unlockedBy("has_item", has(Items.BUCKET)).save(recipeOutput, FossilsLegacyUtils.resource("raw_berry_medley_bucket"));
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FossilsLegacyItems.ROMANTIC_CONCOCTION_BOTTLE.get(), 8).pattern("###").pattern("#$#").pattern("###").define('#', Items.GLASS_BOTTLE).define('$', FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get()).unlockedBy("has_item", has(FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get())).save(recipeOutput, FossilsLegacyUtils.resource("romantic_concoction_bottle"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get()).requires(FossilsLegacyBlocks.SKULL_BLOCK.get()).requires(Items.TORCH).unlockedBy("has_item", has(FossilsLegacyBlocks.SKULL_BLOCK.get())).save(recipeOutput, FossilsLegacyUtils.resource("skull_lanturn_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.SKULL_STICK.get()).pattern("#").pattern("$").define('#', FossilsLegacyBlocks.SKULL_BLOCK.get()).define('$', Items.STICK).unlockedBy("has_item", has(FossilsLegacyBlocks.SKULL_BLOCK.get())).save(recipeOutput, FossilsLegacyUtils.resource("skull_stick"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.TOOTH_DAGGER.get()).pattern("#").pattern("$").define('#', FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get()).define('$', Items.STICK).unlockedBy("has_item", has(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get())).save(recipeOutput, FossilsLegacyUtils.resource("tooth_dagger"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, FossilsLegacyItems.DINOPEDIA.get()).requires(Items.BOOK).requires(FossilsLegacyItemTags.DNA).unlockedBy("has_item", has(FossilsLegacyItemTags.DNA)).save(recipeOutput, FossilsLegacyUtils.resource("dinopedia"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.ANALYZER.get()).pattern("#%#").pattern("#$#").define('#', Items.IRON_INGOT).define('%', FossilsLegacyItems.RELIC_SCRAP.get()).define('$', FossilsLegacyItems.FOSSIL.get()).unlockedBy("has_item", has(FossilsLegacyItems.FOSSIL.get())).save(recipeOutput, FossilsLegacyUtils.resource("analyzer"));
        cultivator(FossilsLegacyBlocks.WHITE_CULTIVATOR.get(), Items.WHITE_DYE, Blocks.WHITE_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get(), Items.ORANGE_DYE, Blocks.ORANGE_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get(), Items.MAGENTA_DYE, Blocks.MAGENTA_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get(), Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get(), Items.YELLOW_DYE, Blocks.YELLOW_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.LIME_CULTIVATOR.get(), Items.LIME_DYE, Blocks.LIME_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.PINK_CULTIVATOR.get(), Items.PINK_DYE, Blocks.PINK_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.GRAY_CULTIVATOR.get(), Items.GRAY_DYE, Blocks.GRAY_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get(), Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.CYAN_CULTIVATOR.get(), Items.CYAN_DYE, Blocks.CYAN_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get(), Items.PURPLE_DYE, Blocks.PURPLE_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.BLUE_CULTIVATOR.get(), Items.BLUE_DYE, Blocks.BLUE_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.BROWN_CULTIVATOR.get(), Items.BROWN_DYE, Blocks.BROWN_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.GREEN_CULTIVATOR.get(), Items.GREEN_DYE, Blocks.GREEN_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.RED_CULTIVATOR.get(), Items.RED_DYE, Blocks.RED_STAINED_GLASS, recipeOutput);
        cultivator(FossilsLegacyBlocks.BLACK_CULTIVATOR.get(), Items.BLACK_DYE, Blocks.BLACK_STAINED_GLASS, recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()).requires(Items.PAPER).requires(Blocks.CRAFTING_TABLE).unlockedBy("has_item", has(Blocks.CRAFTING_TABLE)).save(recipeOutput, FossilsLegacyUtils.resource("archaeology_workbench"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.DRUM.get()).pattern("###").pattern("$%$").pattern("$$$").define('#', Items.LEATHER).define('$', ItemTags.PLANKS).define('%', Items.REDSTONE).unlockedBy("has_item", has(Items.LEATHER)).save(recipeOutput, FossilsLegacyUtils.resource("drum"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.FEEDER.get()).pattern("#$#").pattern("%@!").pattern("!!!").define('#', Items.IRON_INGOT).define('$', Blocks.GLASS).define('%', Blocks.STONE_BUTTON).define('@', Items.BUCKET).define('!', Blocks.STONE).unlockedBy("has_item", has(Blocks.STONE)).save(recipeOutput, FossilsLegacyUtils.resource("feeder"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get()).requires(Items.CHICKEN).requires(Items.BUCKET).unlockedBy("has_item", has(Items.BUCKET)).save(recipeOutput, FossilsLegacyUtils.resource("raw_chicken_soup_bucket"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 5).requires(FossilsLegacyBlocks.SKULL_BLOCK.get()).unlockedBy("has_item", has(FossilsLegacyBlocks.SKULL_BLOCK.get())).save(recipeOutput, FossilsLegacyUtils.resource("skull_bonemeal"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FossilsLegacyItems.OVERWORLD_COIN.get()).requires(FossilsLegacyItems.PREHISTORIC_COIN.get()).unlockedBy("has_item", has(FossilsLegacyItems.PREHISTORIC_COIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("overworld_coin"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FossilsLegacyItems.PREHISTORIC_COIN.get()).requires(FossilsLegacyItems.OVERWORLD_COIN.get()).unlockedBy("has_item", has(FossilsLegacyItems.OVERWORLD_COIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("prehistoric_coin"));
        faCookRecipes(recipeOutput, "smelting", RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, 200);
        faCookRecipes(recipeOutput, "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100);
        faCookRecipes(recipeOutput, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 600);
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_SWORD), Ingredient.of(FossilsLegacyItems.SCARAB_GEM.get()), RecipeCategory.TOOLS, FossilsLegacyItems.SCARAB_GEM_SWORD.get()).unlocks("has_item", has(FossilsLegacyItems.SCARAB_GEM.get())).save(recipeOutput, FossilsLegacyUtils.resource("gem_sword"));
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_SHOVEL), Ingredient.of(FossilsLegacyItems.SCARAB_GEM.get()), RecipeCategory.TOOLS, FossilsLegacyItems.SCARAB_GEM_SHOVEL.get()).unlocks("has_item", has(FossilsLegacyItems.SCARAB_GEM.get())).save(recipeOutput, FossilsLegacyUtils.resource("gem_shovel"));
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_PICKAXE), Ingredient.of(FossilsLegacyItems.SCARAB_GEM.get()), RecipeCategory.TOOLS, FossilsLegacyItems.SCARAB_GEM_PICKAXE.get()).unlocks("has_item", has(FossilsLegacyItems.SCARAB_GEM.get())).save(recipeOutput, FossilsLegacyUtils.resource("gem_pickaxe"));
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_AXE), Ingredient.of(FossilsLegacyItems.SCARAB_GEM.get()), RecipeCategory.TOOLS, FossilsLegacyItems.SCARAB_GEM_AXE.get()).unlocks("has_item", has(FossilsLegacyItems.SCARAB_GEM.get())).save(recipeOutput, FossilsLegacyUtils.resource("gem_axe"));
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_HOE), Ingredient.of(FossilsLegacyItems.SCARAB_GEM.get()), RecipeCategory.TOOLS, FossilsLegacyItems.SCARAB_GEM_HOE.get()).unlocks("has_item", has(FossilsLegacyItems.SCARAB_GEM.get())).save(recipeOutput, FossilsLegacyUtils.resource("gem_hoe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TRICERATOPS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.TRICERATOPS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("triceratops_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.VELOCIRAPTOR_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("velociraptor_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.TYRANNOSAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("tyrannosaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.PTERANODON_DNA.get(), FossilsLegacyItems.PTERANODON_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PTERANODON_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("pterosaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.NAUTILUS_EGGS.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.NAUTILUS_EGGS.get())).save(recipeOutput, FossilsLegacyUtils.resource("nautilus_eggs"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.FUTABASAURUS_DNA.get(), FossilsLegacyItems.FUTABASAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.FUTABASAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("futabasaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.MOSASAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("mosasaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.STEGOSAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("stegosaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.DILOPHOSAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("dilophosaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.BRACHIOSAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("brachiosaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyBlocks.AXOLOTLSPAWN.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.AXOLOTL_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("axolotl_eggs"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.CAT_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("cat_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.CHICKEN_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("incubated_chicken_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.COW_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.COW_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("cow_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.DOLPHIN_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("dolphin_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.DONKEY_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("donkey_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.FOX_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("fox_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.FROG_DNA.get(), Blocks.FROGSPAWN, 6000).unlockedBy("has_item", has(FossilsLegacyItems.FROG_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("frog_eggs"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.GOAT_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("goat_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.HORSE_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("horse_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.LLAMA_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("llama_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.MULE_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("mule_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.OCELOT_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("ocelot_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PANDA_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("panda_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PARROT_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("incubated_parrot_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PIG_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("pig_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.POLAR_BEAR_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("polar_bear_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.RABBIT_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("rabbit_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.SHEEP_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("sheep_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.WOLF_DNA.get(), FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.WOLF_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("wolf_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.SMILODON_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("smilodon_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.MAMMOTH_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("mammoth_embryo_syringe"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.CARNOTAURUS_DNA.get(), FossilsLegacyItems.CARNOTAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.CARNOTAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("carnotaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("cryolophosaurus_egg"));
        CultivationRecipeBuilder.recipe(FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), FossilsLegacyItems.THERIZINOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.THERIZINOSAURUS_DNA.get())).save(recipeOutput, FossilsLegacyUtils.resource("therizinosaurus_egg"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_HELMET.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get())).save(recipeOutput, FossilsLegacyUtils.resource("ancient_helmet"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get())).save(recipeOutput, FossilsLegacyUtils.resource("ancient_chestplate"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_LEGGINGS.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get())).save(recipeOutput, FossilsLegacyUtils.resource("ancient_leggings"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_BOOTS.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get())).save(recipeOutput, FossilsLegacyUtils.resource("ancient_boots"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_SWORD.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get())).save(recipeOutput, FossilsLegacyUtils.resource("ancient_sword"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.SCARAB_GEM_AXE.get(), FossilsLegacyItems.SCARAB_GEM_AXE.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.SCARAB_GEM_AXE.get())).save(recipeOutput, FossilsLegacyUtils.resource("scarab_gem_axe_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.SCARAB_GEM_HOE.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.SCARAB_GEM_HOE.get())).save(recipeOutput, FossilsLegacyUtils.resource("scarab_gem_hoe_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get())).save(recipeOutput, FossilsLegacyUtils.resource("scarab_gem_pickaxe_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get())).save(recipeOutput, FossilsLegacyUtils.resource("scarab_gem_shovel_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.SCARAB_GEM_SWORD.get(), FossilsLegacyItems.SCARAB_GEM_SWORD.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.SCARAB_GEM_SWORD.get())).save(recipeOutput, FossilsLegacyUtils.resource("scarab_gem_sword_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyItems.DIAMOND_JAVELIN.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("diamond_javelin_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyItems.GOLDEN_JAVELIN.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("golden_javelin_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyItems.IRON_JAVELIN.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.BROKEN_IRON_JAVELIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("iron_javelin_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyItems.NETHERITE_JAVELIN.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("netherite_javelin_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get(), FossilsLegacyItems.SCARAB_GEM_JAVELIN.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("scarab_gem_javelin_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyItems.STONE_JAVELIN.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.BROKEN_STONE_JAVELIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("stone_javelin_repair"));
        ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyItems.WOODEN_JAVELIN.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get())).save(recipeOutput, FossilsLegacyUtils.resource("wooden_javelin_repair"));
        SpecialRecipeBuilder.special(MagicConchRecipe::new).save(recipeOutput, FossilsLegacyUtils.resource("magic_conch"));
        copySmithingTemplate(recipeOutput, FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Blocks.STONE_BRICKS);

        AnalyzationRecipeBuilder.recipe(FossilsLegacyItems.FOSSIL.get(), Items.BONE_MEAL, 60, 100).addResult(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 20).addResult(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.MOSASAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.NAUTILUS_DNA.get(), 2).addResult(FossilsLegacyItems.FUTABASAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.PTERANODON_DNA.get(), 2).addResult(FossilsLegacyItems.STEGOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.TRICERATOPS_DNA.get(), 2).addResult(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), 2).addResult(FossilsLegacyItems.CARNOTAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), 2).unlockedBy(getHasName(FossilsLegacyItems.FOSSIL.get()), has(FossilsLegacyItems.FOSSIL.get())).save(recipeOutput, FossilsLegacyUtils.resource("fossil_outputs"));
        AnalyzationRecipeBuilder.recipe(FossilsLegacyItems.RELIC_SCRAP.get(), Blocks.GRAVEL, 40, 100).addResult(FossilsLegacyItems.STONE_TABLET.get(), 30).addResult(Items.FLINT, 20).addResult(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), 5).addResult(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), 5).addResult(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 5).addResult(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 5).addResult(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), 5).addResult(FossilsLegacyItems.PREHISTORIC_COIN.get(), 1).unlockedBy(getHasName(FossilsLegacyItems.RELIC_SCRAP.get()), has(FossilsLegacyItems.RELIC_SCRAP.get())).save(recipeOutput, FossilsLegacyUtils.resource("relic_scrap_outputs"));
        AnalyzationRecipeBuilder.recipe(FossilsLegacyItems.FROZEN_MEAT.get(), FossilsLegacyItems.SMILODON_DNA.get(), 33, 100).addResult(FossilsLegacyItems.MAMMOTH_DNA.get(), 33).addResult(Items.BEEF, 34).unlockedBy(getHasName(FossilsLegacyItems.FROZEN_MEAT.get()), has(FossilsLegacyItems.FROZEN_MEAT.get())).save(recipeOutput, FossilsLegacyUtils.resource("frozen_meat_outputs"));
        simpleAnalyzation(Items.PORKCHOP, FossilsLegacyItems.PIG_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.BEEF, FossilsLegacyItems.COW_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.CHICKEN, FossilsLegacyItems.CHICKEN_DNA.get(), recipeOutput);
        simpleAnalyzation(recipeOutput, Items.FEATHER, FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.PARROT_DNA.get());
        simpleAnalyzation(Items.BAMBOO, FossilsLegacyItems.PANDA_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.SLIME_BALL, FossilsLegacyItems.PANDA_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.MUTTON, FossilsLegacyItems.SHEEP_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.RABBIT, FossilsLegacyItems.RABBIT_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.BONE, FossilsLegacyItems.WOLF_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.EMERALD, FossilsLegacyItems.FOX_DNA.get(), recipeOutput);
        simpleAnalyzation(Items.GOAT_HORN, FossilsLegacyItems.GOAT_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItemTags.FROGLIGHTS, FossilsLegacyItems.FROG_DNA.get(), recipeOutput);
        simpleAnalyzation(recipeOutput, Items.LEATHER, FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.MULE_DNA.get());
        simpleAnalyzation(recipeOutput, Items.STRING, FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.FOX_DNA.get());
        simpleAnalyzation(recipeOutput, Items.COD, FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get());
        simpleAnalyzation(Items.SALMON, FossilsLegacyItems.POLAR_BEAR_DNA.get(), recipeOutput);
        simpleAnalyzation(ItemTags.WOOL, FossilsLegacyItems.SHEEP_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), FossilsLegacyItems.MAMMOTH_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), FossilsLegacyItems.MOSASAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get(), FossilsLegacyItems.FUTABASAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_PTERANODON_MEAT.get(), FossilsLegacyItems.PTERANODON_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_SMILODON_MEAT.get(), FossilsLegacyItems.SMILODON_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), FossilsLegacyItems.TRICERATOPS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get(), FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_CARNOTAURUS_MEAT.get(), FossilsLegacyItems.CARNOTAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS_MEAT.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), recipeOutput);
        simpleAnalyzation(FossilsLegacyItems.RAW_THERIZINOSAURUS_MEAT.get(), FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), recipeOutput);
    }

    public static void cultivator(ItemLike input, ItemLike dye, ItemLike glass, RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, input).group("cultivators").pattern("#$#").pattern("#%#").pattern("@@@").define('#', Blocks.GLASS).define('$', dye).define('%', Items.WATER_BUCKET).define('@', Items.IRON_INGOT).unlockedBy("has_item", has(Items.GLASS)).save(recipeOutput, FossilsLegacyUtils.resource(BuiltInRegistries.ITEM.getKey(input.asItem()).getPath()));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, input).group("cultivators").pattern("# #").pattern("#%#").pattern("@@@").define('#', glass).define('%', Items.WATER_BUCKET).define('@', Items.IRON_INGOT).unlockedBy("has_item", has(Items.GLASS)).save(recipeOutput, FossilsLegacyUtils.resource(BuiltInRegistries.ITEM.getKey(input.asItem()).getPath() + "_from_colored_glass"));
    }

    public static void simpleAnalyzation(ItemLike input, Item dna, RecipeOutput recipeOutput) {
        AnalyzationRecipeBuilder.recipe(input, dna, 100, 100).unlockedBy(getHasName(input), has(input)).save(recipeOutput, FossilsLegacyUtils.resource(BuiltInRegistries.ITEM.getKey(input.asItem()).getPath() + "_outputs"));
    }

    public static void simpleAnalyzation(TagKey<Item> input, Item dna, RecipeOutput recipeOutput) {
        AnalyzationRecipeBuilder.recipe(input, dna, 100, 100).unlockedBy("has_" + input.location().getPath(), has(input)).save(recipeOutput, input.location().getPath() + "_outputs");
    }

    public static void simpleAnalyzation(RecipeOutput recipeOutput, TagKey<Item> input, Item... dnas) {
        AnalyzationRecipeBuilder analyzationRecipeBuilder = AnalyzationRecipeBuilder.recipe(input, dnas[0], 100 / dnas.length, 100).unlockedBy("has_" + input.location().getPath(), has(input));
        for (int i = 1; i < dnas.length; i++) {
            analyzationRecipeBuilder.addResult(dnas[i], 100 / dnas.length);
        }
        analyzationRecipeBuilder.save(recipeOutput, FossilsLegacyUtils.resource(input.location().getPath() + "_outputs"));
    }

    public static void simpleAnalyzation(RecipeOutput recipeOutput, ItemLike input, Item... dnas) {
        AnalyzationRecipeBuilder analyzationRecipeBuilder = AnalyzationRecipeBuilder.recipe(input, dnas[0], 100 / dnas.length, 100).unlockedBy(getHasName(input), has(input));
        for (int i = 1; i < dnas.length; i++) {
            analyzationRecipeBuilder.addResult(dnas[i], 100 / dnas.length);
        }
        analyzationRecipeBuilder.save(recipeOutput, FossilsLegacyUtils.resource(BuiltInRegistries.ITEM.getKey(input.asItem()).getPath() + "_outputs"));
    }

    protected static <T extends AbstractCookingRecipe> void faCookRecipes(RecipeOutput recipeOutput, String type, RecipeSerializer<T> recipeSerialiser, AbstractCookingRecipe.Factory<T> factory, int time) {
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get(), FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_PTERANODON_MEAT.get(), FossilsLegacyItems.COOKED_PTERANODON_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get(), FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_SMILODON_MEAT.get(), FossilsLegacyItems.COOKED_SMILODON_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_CARNOTAURUS_MEAT.get(), FossilsLegacyItems.COOKED_CARNOTAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_CRYOLOPHOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS_MEAT.get(), 0.35F);
        faCookingRecipe(recipeOutput, type, recipeSerialiser, factory, time, FossilsLegacyItems.RAW_THERIZINOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_THERIZINOSAURUS_MEAT.get(), 0.35F);
    }

    public static <T extends AbstractCookingRecipe> void faCookingRecipe(RecipeOutput recipeOutput, String type, RecipeSerializer<T> recipeSerialiser, AbstractCookingRecipe.Factory<T> factory, int time, ItemLike input, ItemLike output, float experience) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(input), RecipeCategory.FOOD, output, experience, time, recipeSerialiser, factory).unlockedBy("has_item", has(input)).save(recipeOutput, FossilsLegacyUtils.resource(getItemName(output) + "_from_" + type).toString());
    }
}
