package willatendo.fossilslegacy.data;

import java.util.function.Consumer;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import willatendo.fossilslegacy.data.recipe.AnalyzationRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.ArchaeologyRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.CultivationRecipeBuilder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.recipe.serialiser.FossilsLegacyRecipeSerialisers;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyRecipeProvider extends RecipeProvider {
	public FossilsLegacyRecipeProvider(PackOutput packedOutput) {
		super(packedOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> finishedRecipe) {
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Items.CAKE).pattern("###").pattern("$%$").pattern("&&&").define('#', Items.MILK_BUCKET).define('$', Items.SUGAR).define('%', FossilsLegacyItemTags.CAKE_EGGS).define('&', Items.WHEAT).unlockedBy("has_item", has(FossilsLegacyItemTags.CAKE_EGGS)).save(finishedRecipe, FossilsLegacyUtils.resource("cake_from_eggs"));
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get(), 8).pattern("###").pattern("#$#").pattern("###").define('#', Items.GLASS_BOTTLE).define('$', FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get()).unlockedBy("has_item", has(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get())).save(finishedRecipe, FossilsLegacyUtils.resource("chicken_essence_bottle"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get()).requires(FossilsLegacyBlocks.SKULL_BLOCK.get()).requires(Items.TORCH).unlockedBy("has_item", has(FossilsLegacyBlocks.SKULL_BLOCK.get())).save(finishedRecipe, FossilsLegacyUtils.resource("skull_lanturn_block"));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.SKULL_STICK.get()).pattern("#").pattern("$").define('#', FossilsLegacyBlocks.SKULL_BLOCK.get()).define('$', Items.STICK).unlockedBy("has_item", has(FossilsLegacyBlocks.SKULL_BLOCK.get())).save(finishedRecipe, FossilsLegacyUtils.resource("skull_stick"));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.TOOTH_DAGGER.get()).pattern("#").pattern("$").define('#', FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get()).define('$', Items.STICK).unlockedBy("has_item", has(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get())).save(finishedRecipe, FossilsLegacyUtils.resource("tooth_dagger"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, FossilsLegacyItems.DINOSAUR_ENCYCLOPEDIA.get()).requires(Items.BOOK).requires(FossilsLegacyItemTags.DNA).unlockedBy("has_item", has(FossilsLegacyItemTags.DNA)).save(finishedRecipe, FossilsLegacyUtils.resource("dinosaur_encyclopedia"));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.ANALYZER.get()).pattern("#%#").pattern("#$#").define('#', Items.IRON_INGOT).define('%', FossilsLegacyItems.RELIC_SCRAP.get()).define('$', FossilsLegacyItems.FOSSIL.get()).unlockedBy("has_item", has(FossilsLegacyItems.FOSSIL.get())).save(finishedRecipe, FossilsLegacyUtils.resource("analyzer"));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.CULTIVATOR.get()).pattern("#$#").pattern("#%#").pattern("@@@").define('#', Tags.Items.GLASS).define('$', Items.GREEN_DYE).define('%', Items.WATER_BUCKET).define('@', Items.IRON_INGOT).unlockedBy("has_item", has(Tags.Items.GLASS)).save(finishedRecipe, FossilsLegacyUtils.resource("cultivator"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get()).requires(Items.PAPER).requires(Blocks.CRAFTING_TABLE).unlockedBy("has_item", has(Blocks.CRAFTING_TABLE)).save(finishedRecipe, FossilsLegacyUtils.resource("archaeology_workbench"));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.DRUM.get()).pattern("###").pattern("$%$").pattern("$$$").define('#', Tags.Items.LEATHER).define('$', ItemTags.PLANKS).define('%', Items.REDSTONE).unlockedBy("has_item", has(Tags.Items.LEATHER)).save(finishedRecipe, FossilsLegacyUtils.resource("drum"));
		ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.FEEDER.get()).pattern("#$#").pattern("%@!").pattern("!!!").define('#', Items.IRON_INGOT).define('$', Tags.Items.GLASS).define('%', Blocks.STONE_BUTTON).define('@', Items.BUCKET).define('!', Blocks.STONE).unlockedBy("has_item", has(Blocks.STONE)).save(finishedRecipe, FossilsLegacyUtils.resource("feeder"));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get()).requires(Items.CHICKEN).requires(Items.BUCKET).unlockedBy("has_item", has(Items.BUCKET)).save(finishedRecipe, FossilsLegacyUtils.resource("raw_chicken_soup_bucket"));
		cookRecipes(finishedRecipe, "smelting", RecipeSerializer.SMELTING_RECIPE, 200);
		cookRecipes(finishedRecipe, "smoking", RecipeSerializer.SMOKING_RECIPE, 100);
		cookRecipes(finishedRecipe, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 600);
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_SWORD), Ingredient.of(FossilsLegacyItems.GEM_ARTIFACT.get()), RecipeCategory.TOOLS, FossilsLegacyItems.GEM_SWORD.get()).unlocks("has_item", has(FossilsLegacyItems.GEM_ARTIFACT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("gem_sword"));
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_SHOVEL), Ingredient.of(FossilsLegacyItems.GEM_ARTIFACT.get()), RecipeCategory.TOOLS, FossilsLegacyItems.GEM_SHOVEL.get()).unlocks("has_item", has(FossilsLegacyItems.GEM_ARTIFACT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("gem_shovel"));
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_PICKAXE), Ingredient.of(FossilsLegacyItems.GEM_ARTIFACT.get()), RecipeCategory.TOOLS, FossilsLegacyItems.GEM_PICKAXE.get()).unlocks("has_item", has(FossilsLegacyItems.GEM_ARTIFACT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("gem_pickaxe"));
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_AXE), Ingredient.of(FossilsLegacyItems.GEM_ARTIFACT.get()), RecipeCategory.TOOLS, FossilsLegacyItems.GEM_AXE.get()).unlocks("has_item", has(FossilsLegacyItems.GEM_ARTIFACT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("gem_axe"));
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(FossilsLegacyItems.GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(Items.NETHERITE_HOE), Ingredient.of(FossilsLegacyItems.GEM_ARTIFACT.get()), RecipeCategory.TOOLS, FossilsLegacyItems.GEM_HOE.get()).unlocks("has_item", has(FossilsLegacyItems.GEM_ARTIFACT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("gem_hoe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TRICERATOPS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.TRICERATOPS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("triceratops_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.UTAHRAPTOR_DNA.get(), FossilsLegacyItems.UTAHRAPTOR_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.UTAHRAPTOR_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("utahraptor_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.TYRANNOSAURUS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("tyrannosaurus_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.PTEROSAURUS_DNA.get(), FossilsLegacyItems.PTEROSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PTEROSAURUS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("pterosaurus_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.NAUTILUS_EGGS.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.NAUTILUS_EGGS.get())).save(finishedRecipe, FossilsLegacyUtils.resource("nautilus_eggs"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.PLESIOSAURUS_DNA.get(), FossilsLegacyItems.PLESIOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PLESIOSAURUS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("plesiosaurus_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.MOSASAURUS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("mosasaurus_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.STEGOSAURUS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("stegosaurus_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.DILOPHOSAURUS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("dilophosaurus_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.BRACHIOSAURUS_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("brachiosaurus_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyItems.AXOLOTL_EGGS.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.AXOLOTL_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("axolotl_eggs"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.CAT_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("cat_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.CHICKEN_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("incubated_chicken_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.COW_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.COW_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("cow_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.DOLPHIN_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("dolphin_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.DONKEY_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("donkey_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FOX_DNA.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.FOX_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("fox_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.FROG_DNA.get(), FossilsLegacyItems.FROG_EGGS.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.FROG_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("frog_eggs"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.GOAT_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("goat_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.HORSE_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("horse_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.LLAMA_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("llama_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.MULE_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("mule_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.OCELOT_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("ocelot_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PANDA_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("panda_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PARROT_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("incubated_parrot_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.PIG_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("pig_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.POLAR_BEAR_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("polar_bear_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.RABBIT_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("rabbit_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.SHEEP_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("sheep_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.TURTLE_DNA.get(), Items.TURTLE_EGG, 6000).unlockedBy("has_item", has(FossilsLegacyItems.TURTLE_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("turtle_egg"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.WOLF_DNA.get(), FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.WOLF_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("wolf_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.SMILODON_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("smilodon_embryo_syringe"));
		CultivationRecipeBuilder.recipe(FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get(), 6000).unlockedBy("has_item", has(FossilsLegacyItems.MAMMOTH_DNA.get())).save(finishedRecipe, FossilsLegacyUtils.resource("mammoth_embryo_syringe"));
		ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.HELMET_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_HELMET.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.HELMET_ARTIFACT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("ancient_helmet"));
		ArchaeologyRecipeBuilder.recipe(FossilsLegacyItems.SWORD_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_SWORD.get(), 3000).unlockedBy("has_item", has(FossilsLegacyItems.SWORD_ARTIFACT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("ancient_sword"));
		SpecialRecipeBuilder.special(FossilsLegacyRecipeSerialisers.MAGIC_CONCH.get()).save(finishedRecipe, FossilsLegacyUtils.resource("magic_conch").toString());

		AnalyzationRecipeBuilder.recipe(FossilsLegacyItems.FOSSIL.get(), Items.BONE_MEAL, 60, 100).addResult(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 20).addResult(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.MOSASAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.NAUTILUS_DNA.get(), 2).addResult(FossilsLegacyItems.PLESIOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.PTEROSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.STEGOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.TRICERATOPS_DNA.get(), 2).addResult(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), 2).addResult(FossilsLegacyItems.UTAHRAPTOR_DNA.get(), 2).unlockedBy(getHasName(FossilsLegacyItems.FOSSIL.get()), has(FossilsLegacyItems.FOSSIL.get())).save(finishedRecipe, FossilsLegacyUtils.resource("fossil_outputs"));
		AnalyzationRecipeBuilder.recipe(FossilsLegacyItems.RELIC_SCRAP.get(), Blocks.GRAVEL, 40, 100).addResult(FossilsLegacyItems.STONE_HIEROGLYPH.get(), 30).addResult(Items.FLINT, 20).addResult(FossilsLegacyItems.SWORD_ARTIFACT.get(), 5).addResult(FossilsLegacyItems.HELMET_ARTIFACT.get(), 5).unlockedBy(getHasName(FossilsLegacyItems.RELIC_SCRAP.get()), has(FossilsLegacyItems.RELIC_SCRAP.get())).save(finishedRecipe, FossilsLegacyUtils.resource("relic_scrap_outputs"));
		AnalyzationRecipeBuilder.recipe(FossilsLegacyItems.FROZEN_MEAT.get(), FossilsLegacyItems.SMILODON_DNA.get(), 33, 100).addResult(FossilsLegacyItems.MAMMOTH_DNA.get(), 33).addResult(Items.BEEF, 34).unlockedBy(getHasName(FossilsLegacyItems.FROZEN_MEAT.get()), has(FossilsLegacyItems.FROZEN_MEAT.get())).save(finishedRecipe, FossilsLegacyUtils.resource("frozen_meat_outputs"));
		meatAnalyzation(Items.PORKCHOP, FossilsLegacyItems.PIG_DNA.get(), finishedRecipe);
		meatAnalyzation(Items.BEEF, FossilsLegacyItems.COW_DNA.get(), finishedRecipe);
		meatAnalyzation(Items.CHICKEN, FossilsLegacyItems.CHICKEN_DNA.get(), finishedRecipe);
		meatAnalyzation(Items.MUTTON, FossilsLegacyItems.SHEEP_DNA.get(), finishedRecipe);
		meatAnalyzation(Items.RABBIT, FossilsLegacyItems.RABBIT_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), FossilsLegacyItems.MAMMOTH_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), FossilsLegacyItems.MOSASAURUS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get(), FossilsLegacyItems.PLESIOSAURUS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_PTEROSAURUS_MEAT.get(), FossilsLegacyItems.PTEROSAURUS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_SMILODON_MEAT.get(), FossilsLegacyItems.SMILODON_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), FossilsLegacyItems.TRICERATOPS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), finishedRecipe);
		meatAnalyzation(FossilsLegacyItems.RAW_UTAHRAPTOR_MEAT.get(), FossilsLegacyItems.UTAHRAPTOR_DNA.get(), finishedRecipe);
	}

	public static void meatAnalyzation(Item meat, Item dna, Consumer<FinishedRecipe> finishedRecipe) {
		AnalyzationRecipeBuilder.recipe(meat, dna, 100, 100).unlockedBy(getHasName(meat), has(meat)).save(finishedRecipe, FossilsLegacyUtils.resource(ForgeRegistries.ITEMS.getKey(meat).getPath() + "_outputs"));
	}

	protected static void cookRecipes(Consumer<FinishedRecipe> finishedRecipe, String type, RecipeSerializer<? extends AbstractCookingRecipe> recipeSerialiser, int time) {
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_UTAHRAPTOR_MEAT.get(), FossilsLegacyItems.COOKED_UTAHRAPTOR_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_PTEROSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_PTEROSAURUS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_PLESIOSAURUS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_SMILODON_MEAT.get(), FossilsLegacyItems.COOKED_SMILODON_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get(), 0.35F);
		simpleCookingRecipe(finishedRecipe, type, recipeSerialiser, time, FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), 0.35F);
	}

	protected static void simpleCookingRecipe(Consumer<FinishedRecipe> finishedRecipe, String type, RecipeSerializer<? extends AbstractCookingRecipe> recipeSerialiser, int time, ItemLike input, ItemLike output, float experience) {
		SimpleCookingRecipeBuilder.generic(Ingredient.of(input), RecipeCategory.FOOD, output, experience, time, recipeSerialiser).unlockedBy("has_item", has(input)).save(finishedRecipe, FossilsLegacyUtils.resource(getItemName(output) + "_from_" + type).toString());
	}
}
