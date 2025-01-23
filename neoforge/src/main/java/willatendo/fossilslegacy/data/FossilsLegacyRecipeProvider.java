package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.data.recipe.AnalyzationRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.ArchaeologyRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.CultivationRecipeBuilder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.inventory.AnalyzationBookCategory;
import willatendo.fossilslegacy.server.inventory.ArchaeologyBookCategory;
import willatendo.fossilslegacy.server.inventory.CultivationBookCategory;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.recipe.AnalyzerResult;
import willatendo.fossilslegacy.server.recipe.MagicConchRecipe;
import willatendo.fossilslegacy.server.tags.FossilsLegacyAnalyzerResultTags;
import willatendo.fossilslegacy.server.tags.FossilsLegacyItemTags;
import willatendo.simplelibrary.data.SimpleRecipeProvider;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyRecipeProvider extends SimpleRecipeProvider {
    public FossilsLegacyRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId) {
        super(packOutput, registries, modId);
    }

    @Override
    public void addRecipes() {
        this.shaped("cake_from_eggs", RecipeCategory.FOOD, Items.CAKE, PatternBuilder.builder("###", "$%$", "&&&"), IngredientBuilder.build(Items.MILK_BUCKET).symbol('#'), IngredientBuilder.build(Items.SUGAR).symbol('$'), IngredientBuilder.build(FossilsLegacyItemTags.CAKE_EGGS).requires(FossilsLegacyItemTags.CAKE_EGGS, "has_egg").symbol('%'), IngredientBuilder.build(Items.WHEAT).symbol('&'));
        this.shaped(RecipeCategory.FOOD, FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get(), 8, PatternBuilder.builder("###", "#$#", "###"), IngredientBuilder.build(Items.GLASS_BOTTLE).symbol('#'), IngredientBuilder.build(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get()).requires().symbol('$'));
        this.shapeless(RecipeCategory.FOOD, FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), IngredientBuilder.build(Items.BUCKET).requires(), IngredientBuilder.build(Items.SWEET_BERRIES, 4), IngredientBuilder.build(Items.CARROT), IngredientBuilder.build(Items.POTATO), IngredientBuilder.build(Items.BEEF), IngredientBuilder.build(Items.PORKCHOP));
        this.shaped(RecipeCategory.FOOD, FossilsLegacyItems.ROMANTIC_CONCOCTION_BOTTLE.get(), 8, PatternBuilder.builder("###", "#$#", "###"), IngredientBuilder.build(Items.GLASS_BOTTLE).symbol('#'), IngredientBuilder.build(FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get()).symbol('$').requires());
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.SKULL_LANTERN_BLOCK.get(), IngredientBuilder.build(FossilsLegacyBlocks.SKULL_BLOCK.get()).requires(), IngredientBuilder.build(Items.TORCH));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.SKULL_STICK.get(), PatternBuilder.builder("#", "$"), IngredientBuilder.build(FossilsLegacyBlocks.SKULL_BLOCK.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.TOOTH_DAGGER.get(), PatternBuilder.builder("#", "$"), IngredientBuilder.build(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shapeless(RecipeCategory.TOOLS, FossilsLegacyItems.DINOPEDIA.get(), IngredientBuilder.build(Items.BOOK), IngredientBuilder.build(FossilsLegacyItemTags.DNA).requires(FossilsLegacyItemTags.DNA, "has_dna"));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.ANALYZER.get(), PatternBuilder.builder("#%#", "#$#"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#'), IngredientBuilder.build(FossilsLegacyItems.RELIC_SCRAP.get()).symbol('%'), IngredientBuilder.build(FossilsLegacyItems.FOSSIL.get()).symbol('$').requires());
        this.cultivator(FossilsLegacyBlocks.WHITE_CULTIVATOR.get(), Items.WHITE_DYE, Blocks.WHITE_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get(), Items.ORANGE_DYE, Blocks.ORANGE_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get(), Items.MAGENTA_DYE, Blocks.MAGENTA_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get(), Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get(), Items.YELLOW_DYE, Blocks.YELLOW_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.LIME_CULTIVATOR.get(), Items.LIME_DYE, Blocks.LIME_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.PINK_CULTIVATOR.get(), Items.PINK_DYE, Blocks.PINK_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.GRAY_CULTIVATOR.get(), Items.GRAY_DYE, Blocks.GRAY_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get(), Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.CYAN_CULTIVATOR.get(), Items.CYAN_DYE, Blocks.CYAN_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get(), Items.PURPLE_DYE, Blocks.PURPLE_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.BLUE_CULTIVATOR.get(), Items.BLUE_DYE, Blocks.BLUE_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.BROWN_CULTIVATOR.get(), Items.BROWN_DYE, Blocks.BROWN_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.GREEN_CULTIVATOR.get(), Items.GREEN_DYE, Blocks.GREEN_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.RED_CULTIVATOR.get(), Items.RED_DYE, Blocks.RED_STAINED_GLASS);
        this.cultivator(FossilsLegacyBlocks.BLACK_CULTIVATOR.get(), Items.BLACK_DYE, Blocks.BLACK_STAINED_GLASS);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get(), PatternBuilder.builder("#$#", "#&#", "#!#"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#').requires(), IngredientBuilder.build(Blocks.REDSTONE_BLOCK).symbol('$'), IngredientBuilder.build(Items.NETHER_STAR).symbol('&'), IngredientBuilder.build(Items.GOLD_INGOT).symbol('!'));
        this.craftingTable(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), Items.PAPER);
        this.craftingTable(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get(), FossilsLegacyItems.FOSSIL.get());
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.DRUM.get(), PatternBuilder.builder("###", "$%$", "$$$"), IngredientBuilder.build(Items.LEATHER).symbol('#').requires(), IngredientBuilder.build(ItemTags.PLANKS).symbol('$'), IngredientBuilder.build(Items.REDSTONE).symbol('%'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.FEEDER.get(), PatternBuilder.builder("#$#", "%@!", "!!!"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#'), IngredientBuilder.build(Blocks.GLASS).symbol('$'), IngredientBuilder.build(Blocks.STONE_BUTTON).symbol('%'), IngredientBuilder.build(Items.BUCKET).symbol('@'), IngredientBuilder.build(Blocks.STONE).symbol('!').requires());
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), IngredientBuilder.build(Items.CHICKEN), IngredientBuilder.build(Items.BUCKET).requires());
        this.shapeless("skull_bonemeal", RecipeCategory.MISC, Items.BONE_MEAL, 5, IngredientBuilder.build(FossilsLegacyBlocks.SKULL_BLOCK.get()));
        this.shapeless(RecipeCategory.MISC, FossilsLegacyItems.OVERWORLD_COIN.get(), IngredientBuilder.build(FossilsLegacyItems.PREHISTORIC_COIN.get()).requires());
        this.shapeless(RecipeCategory.MISC, FossilsLegacyItems.PREHISTORIC_COIN.get(), IngredientBuilder.build(FossilsLegacyItems.OVERWORLD_COIN.get()).requires());
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get()).symbol('#'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "planks", FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get(), 4, IngredientBuilder.build(FossilsLegacyItemTags.LEPIDODENDRON_LOGS));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_stairs", FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get(), 4, PatternBuilder.builder("#  ", "## ", "###"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_slab", FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get(), 6, PatternBuilder.builder("###"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.DECORATIONS, "wooden_fence", FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get(), 3, PatternBuilder.builder("#$#", "#$#"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_fence_gate", FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get(), PatternBuilder.builder("$#$", "$#$"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_door", FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get(), 3, PatternBuilder.builder("##", "##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_trapdoor", FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get(), 2, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_pressure_plate", FossilsLegacyBlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), PatternBuilder.builder("##"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shapeless(RecipeCategory.REDSTONE, "wooden_button", FossilsLegacyBlocks.LEPIDODENDRON_BUTTON.get(), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()));
        this.shaped(RecipeCategory.DECORATIONS, "sign", FossilsLegacyItems.LEPIDODENDRON_SIGN.get(), 3, PatternBuilder.builder("###", "###", " $ "), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, "hanging_sign", FossilsLegacyItems.LEPIDODENDRON_HANGING_SIGN.get(), 6, PatternBuilder.builder("$ $", "###", "###"), IngredientBuilder.build(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get()).symbol('#').requires(), IngredientBuilder.build(Items.CHAIN).symbol('$'));
        this.boat(RecipeCategory.TRANSPORTATION, "boat", FossilsLegacyItems.LEPIDODENDRON_BOAT.get(), PatternBuilder.builder("# #", "###"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.chestBoat(RecipeCategory.TRANSPORTATION, "chest_boat", FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT.get(), IngredientBuilder.build(FossilsLegacyItems.LEPIDODENDRON_BOAT.get()), IngredientBuilder.build(Items.CHEST));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FossilsLegacyBlocks.SIGILLARIA_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_LOG.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get()).symbol('#'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "planks", FossilsLegacyBlocks.SIGILLARIA_PLANKS.get(), 4, IngredientBuilder.build(FossilsLegacyItemTags.SIGILLARIA_LOGS));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_stairs", FossilsLegacyBlocks.SIGILLARIA_STAIRS.get(), 4, PatternBuilder.builder("#  ", "## ", "###"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_slab", FossilsLegacyBlocks.SIGILLARIA_SLAB.get(), 6, PatternBuilder.builder("###"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.DECORATIONS, "wooden_fence", FossilsLegacyBlocks.SIGILLARIA_FENCE.get(), 3, PatternBuilder.builder("#$#", "#$#"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_fence_gate", FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get(), PatternBuilder.builder("$#$", "$#$"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_door", FossilsLegacyBlocks.SIGILLARIA_DOOR.get(), 3, PatternBuilder.builder("##", "##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_trapdoor", FossilsLegacyBlocks.SIGILLARIA_TRAPDOOR.get(), 2, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_pressure_plate", FossilsLegacyBlocks.SIGILLARIA_PRESSURE_PLATE.get(), PatternBuilder.builder("##"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shapeless(RecipeCategory.REDSTONE, "wooden_button", FossilsLegacyBlocks.SIGILLARIA_BUTTON.get(), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()));
        this.shaped(RecipeCategory.DECORATIONS, "sign", FossilsLegacyItems.SIGILLARIA_SIGN.get(), 3, PatternBuilder.builder("###", "###", " $ "), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, "hanging_sign", FossilsLegacyItems.SIGILLARIA_HANGING_SIGN.get(), 6, PatternBuilder.builder("$ $", "###", "###"), IngredientBuilder.build(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get()).symbol('#').requires(), IngredientBuilder.build(Items.CHAIN).symbol('$'));
        this.boat(RecipeCategory.TRANSPORTATION, "boat", FossilsLegacyItems.SIGILLARIA_BOAT.get(), PatternBuilder.builder("# #", "###"), IngredientBuilder.build(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.chestBoat(RecipeCategory.TRANSPORTATION, "chest_boat", FossilsLegacyItems.SIGILLARIA_CHEST_BOAT.get(), IngredientBuilder.build(FossilsLegacyItems.SIGILLARIA_BOAT.get()), IngredientBuilder.build(Items.CHEST));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FossilsLegacyBlocks.CALAMITES_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_LOG.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get()).symbol('#'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "planks", FossilsLegacyBlocks.CALAMITES_PLANKS.get(), 4, IngredientBuilder.build(FossilsLegacyItemTags.CALAMITES_LOGS));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_stairs", FossilsLegacyBlocks.CALAMITES_STAIRS.get(), 4, PatternBuilder.builder("#  ", "## ", "###"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_slab", FossilsLegacyBlocks.CALAMITES_SLAB.get(), 6, PatternBuilder.builder("###"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.DECORATIONS, "wooden_fence", FossilsLegacyBlocks.CALAMITES_FENCE.get(), 3, PatternBuilder.builder("#$#", "#$#"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_fence_gate", FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get(), PatternBuilder.builder("$#$", "$#$"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_door", FossilsLegacyBlocks.CALAMITES_DOOR.get(), 3, PatternBuilder.builder("##", "##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_trapdoor", FossilsLegacyBlocks.CALAMITES_TRAPDOOR.get(), 2, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_pressure_plate", FossilsLegacyBlocks.CALAMITES_PRESSURE_PLATE.get(), PatternBuilder.builder("##"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shapeless(RecipeCategory.REDSTONE, "wooden_button", FossilsLegacyBlocks.CALAMITES_BUTTON.get(), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()));
        this.shaped(RecipeCategory.DECORATIONS, "sign", FossilsLegacyItems.CALAMITES_SIGN.get(), 3, PatternBuilder.builder("###", "###", " $ "), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, "hanging_sign", FossilsLegacyItems.CALAMITES_HANGING_SIGN.get(), 6, PatternBuilder.builder("$ $", "###", "###"), IngredientBuilder.build(FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get()).symbol('#').requires(), IngredientBuilder.build(Items.CHAIN).symbol('$'));
        this.boat(RecipeCategory.TRANSPORTATION, "boat", FossilsLegacyItems.CALAMITES_BOAT.get(), PatternBuilder.builder("# #", "###"), IngredientBuilder.build(FossilsLegacyBlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.chestBoat(RecipeCategory.TRANSPORTATION, "chest_boat", FossilsLegacyItems.CALAMITES_CHEST_BOAT.get(), IngredientBuilder.build(FossilsLegacyItems.CALAMITES_BOAT.get()), IngredientBuilder.build(Items.CHEST));
        this.shaped(RecipeCategory.DECORATIONS, FossilsLegacyBlocks.MAYAN_VASE.get(), PatternBuilder.builder("###", "# #", "###"), IngredientBuilder.build(Items.BRICK).symbol('#').requires());
        this.shaped(RecipeCategory.DECORATIONS, FossilsLegacyBlocks.MAYAN_JADE_VASE.get(), PatternBuilder.builder("#$#", "$ $", "#$#"), IngredientBuilder.build(Items.BRICK).symbol('#').requires(), IngredientBuilder.build(FossilsLegacyItems.JADE.get()).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, FossilsLegacyBlocks.MAYAN_OCELOT_VASE.get(), PatternBuilder.builder("#$#", "$ $", "#$#"), IngredientBuilder.build(Items.BRICK).symbol('#').requires(), IngredientBuilder.build(FossilsLegacyItems.JADE_OCELOT.get()).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, FossilsLegacyBlocks.MAYAN_VILLAGER_VASE.get(), PatternBuilder.builder("#$#", "$ $", "#$#"), IngredientBuilder.build(Items.BRICK).symbol('#').requires(), IngredientBuilder.build(FossilsLegacyItems.JADE_VILLAGER.get()).symbol('$'));
        this.llama(Items.IRON_INGOT, FossilsLegacyBlocks.IRON_LLAMA_STATUE.get());
        this.llama(Items.COPPER_INGOT, FossilsLegacyBlocks.COPPER_LLAMA_STATUE.get());
        this.waxCopper(FossilsLegacyBlocks.COPPER_LLAMA_STATUE.get(), FossilsLegacyBlocks.WAXED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FossilsLegacyBlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), FossilsLegacyBlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FossilsLegacyBlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), FossilsLegacyBlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FossilsLegacyBlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), FossilsLegacyBlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get());

        this.special("magic_conch", MagicConchRecipe::new);

        this.copySmithingTemplate(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Blocks.STONE_BRICKS);

        this.food(FossilsLegacyItems.COOKED_TRICERATOPS.get(), FossilsLegacyItems.RAW_TRICERATOPS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_VELOCIRAPTOR.get(), FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_TYRANNOSAURUS.get(), FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_PTERANODON.get(), FossilsLegacyItems.RAW_PTERANODON.get(), 0.35F);
        this.food(FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.NAUTILUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_FUTABASAURUS.get(), FossilsLegacyItems.RAW_FUTABASAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_MOSASAURUS.get(), FossilsLegacyItems.RAW_MOSASAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_STEGOSAURUS.get(), FossilsLegacyItems.RAW_STEGOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_DILOPHOSAURUS.get(), FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_BRACHIOSAURUS.get(), FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_SMILODON.get(), FossilsLegacyItems.RAW_SMILODON.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_MAMMOTH.get(), FossilsLegacyItems.RAW_MAMMOTH.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_CARNOTAURUS.get(), FossilsLegacyItems.RAW_CARNOTAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_THERIZINOSAURUS.get(), FossilsLegacyItems.RAW_THERIZINOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_PACHYCEPHALOSAURUS.get(), FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_COMPSOGNATHUS.get(), FossilsLegacyItems.RAW_COMPSOGNATHUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_DODO.get(), FossilsLegacyItems.RAW_DODO.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_MOA.get(), FossilsLegacyItems.RAW_MOA.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_GALLIMIMUS.get(), FossilsLegacyItems.RAW_GALLIMIMUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_SPINOSAURUS.get(), FossilsLegacyItems.RAW_SPINOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_ANKYLOSAURUS.get(), FossilsLegacyItems.RAW_ANKYLOSAURUS.get(), 0.35F);
        this.food(FossilsLegacyItems.COOKED_DIMETRODON.get(), FossilsLegacyItems.RAW_DIMETRODON.get(), 0.35F);

        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_SWORD.get(), RecipeCategory.COMBAT);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), RecipeCategory.TOOLS);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), RecipeCategory.TOOLS);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_AXE.get(), RecipeCategory.TOOLS);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), RecipeCategory.TOOLS);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HELMET, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_HELMET.get(), RecipeCategory.COMBAT);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_CHESTPLATE, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_CHESTPLATE.get(), RecipeCategory.COMBAT);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_LEGGINGS, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_LEGGINGS.get(), RecipeCategory.COMBAT);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_BOOTS, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_BOOTS.get(), RecipeCategory.COMBAT);

        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TRICERATOPS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.PTERANODON_DNA.get(), FossilsLegacyItems.PTERANODON_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.NAUTILUS_EGGS.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.FUTABASAURUS_DNA.get(), FossilsLegacyItems.FUTABASAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.ARMADILLO_DNA.get(), FossilsLegacyItems.ARMADILLO_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyItems.AXOLOTLSPAWN.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.COW_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.FROG_DNA.get(), Blocks.FROGSPAWN, 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.WOLF_DNA.get(), FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.CARNOTAURUS_DNA.get(), FossilsLegacyItems.CARNOTAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), FossilsLegacyItems.THERIZINOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get(), FossilsLegacyItems.PACHYCEPHALOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.COMPSOGNATHUS_DNA.get(), FossilsLegacyItems.COMPSOGNATHUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.DODO_DNA.get(), FossilsLegacyItems.INCUBATED_DODO_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.MOA_DNA.get(), FossilsLegacyItems.MOA_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.GALLIMIMUS_DNA.get(), FossilsLegacyItems.GALLIMIMUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.SPINOSAURUS_DNA.get(), FossilsLegacyItems.SPINOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.ANKYLOSAURUS_DNA.get(), FossilsLegacyItems.ANKYLOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FossilsLegacyItems.DIMETRODON_DNA.get(), FossilsLegacyItems.DIMETRODON_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FossilsLegacyItems.JURASSIC_FERN_DNA.get(), FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FossilsLegacyItems.LEPIDODENDRON_DNA.get(), FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FossilsLegacyItems.SIGILLARIA_DNA.get(), FossilsLegacyBlocks.SIGILLARIA_SAPLING.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FossilsLegacyItems.CALAMITES_DNA.get(), FossilsLegacyBlocks.CALAMITES_SAPLING.get(), 6000);

        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_HELMET.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_LEGGINGS.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_BOOTS.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_SWORD.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_SHOVEL.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_PICKAXE_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_PICKAXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_AXE_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_AXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FossilsLegacyItems.ANCIENT_HOE_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_HOE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_axe_repair", FossilsLegacyItems.SCARAB_GEM_AXE.get(), FossilsLegacyItems.SCARAB_GEM_AXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_hoe_repair", FossilsLegacyItems.SCARAB_GEM_HOE.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_pickaxe_repair", FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_shovel_repair", FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_sword_repair", FossilsLegacyItems.SCARAB_GEM_SWORD.get(), FossilsLegacyItems.SCARAB_GEM_SWORD.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "diamond_javelin_repair", FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyItems.DIAMOND_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "golden_javelin_repair", FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyItems.GOLDEN_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "iron_javelin_repair", FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyItems.IRON_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "netherite_javelin_repair", FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyItems.NETHERITE_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_gem_javelin_repair", FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get(), FossilsLegacyItems.SCARAB_GEM_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "stone_javelin_repair", FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyItems.STONE_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "wooden_javelin_repair", FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyItems.WOODEN_JAVELIN.get(), 3000);

        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.FOSSIL.get(), FossilsLegacyAnalyzerResultTags.FOSSIL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RELIC_SCRAP.get(), FossilsLegacyAnalyzerResultTags.RELIC_SCRAP_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.FROZEN_MEAT.get(), FossilsLegacyAnalyzerResultTags.FROZEN_MEAT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.AXOLOTL_BUCKET, FossilsLegacyAnalyzerResultTags.AXOLOTL_BUCKET_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.TROPICAL_FISH_BUCKET, FossilsLegacyAnalyzerResultTags.TROPICAL_FISH_BUCKET_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.PORKCHOP, FossilsLegacyAnalyzerResultTags.PORKCHOP_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.BEEF, FossilsLegacyAnalyzerResultTags.BEEF_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.CHICKEN, FossilsLegacyAnalyzerResultTags.CHICKEN_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.FEATHER, FossilsLegacyAnalyzerResultTags.FEATHER_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.BAMBOO, FossilsLegacyAnalyzerResultTags.BAMBOO_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.SLIME_BALL, FossilsLegacyAnalyzerResultTags.SLIME_BALL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.MUTTON, FossilsLegacyAnalyzerResultTags.MUTTON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.RABBIT, FossilsLegacyAnalyzerResultTags.RAW_RABBIT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.BONE, FossilsLegacyAnalyzerResultTags.BONE_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.EMERALD, FossilsLegacyAnalyzerResultTags.EMERALD_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.GOAT_HORN, FossilsLegacyAnalyzerResultTags.GOAT_HORN_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItemTags.FROGLIGHTS, "froglights_outputs", FossilsLegacyAnalyzerResultTags.FROGLIGHT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.LEATHER, FossilsLegacyAnalyzerResultTags.LEATHER_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.STRING, FossilsLegacyAnalyzerResultTags.STRING_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.COD, FossilsLegacyAnalyzerResultTags.COD_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.SALMON, FossilsLegacyAnalyzerResultTags.SALMON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, ItemTags.WOOL, "wool_outputs", FossilsLegacyAnalyzerResultTags.WOOL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.ARMADILLO_SCUTE, FossilsLegacyAnalyzerResultTags.ARMADILLO_SCUTE_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_BRACHIOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_DILOPHOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_MAMMOTH.get(), FossilsLegacyAnalyzerResultTags.RAW_MAMMOTH_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_MOSASAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_MOSASAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_FUTABASAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_FUTABASAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_PTERANODON.get(), FossilsLegacyAnalyzerResultTags.RAW_PTERANODON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_SMILODON.get(), FossilsLegacyAnalyzerResultTags.RAW_SMILODON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_STEGOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_STEGOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_TRICERATOPS.get(), FossilsLegacyAnalyzerResultTags.RAW_TRICERATOPS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_TYRANNOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), FossilsLegacyAnalyzerResultTags.RAW_VELOCIRAPTOR_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_CARNOTAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_CARNOTAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_CRYOLOPHOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_THERIZINOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_THERIZINOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_PACHYCEPHALOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_COMPSOGNATHUS.get(), FossilsLegacyAnalyzerResultTags.RAW_COMPSOGNATHUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_DODO.get(), FossilsLegacyAnalyzerResultTags.RAW_DODO_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_MOA.get(), FossilsLegacyAnalyzerResultTags.RAW_MOA_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_GALLIMIMUS.get(), FossilsLegacyAnalyzerResultTags.RAW_GALLIMIMUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_SPINOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_SPINOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_ANKYLOSAURUS.get(), FossilsLegacyAnalyzerResultTags.RAW_ANKYLOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RAW_DIMETRODON.get(), FossilsLegacyAnalyzerResultTags.RAW_DIMETRODON_RESULTS, 100);
    }

    public void boat(RecipeCategory recipeCategory, String group, ItemLike output, PatternBuilder patternBuilder, IngredientBuilder... ingredientBuilders) {
        ShapedRecipeBuilder shapedRecipeBuilder = ShapedRecipeBuilder.shaped(recipeCategory, output);

        if (group != null) {
            shapedRecipeBuilder.group(group);
        }

        String[] patterns = patternBuilder.getPattern();

        for (String pattern : patterns) {
            shapedRecipeBuilder.pattern(pattern);
        }

        for (IngredientBuilder ingredientBuilder : ingredientBuilders) {
            Ingredient ingredient = ingredientBuilder.getIngredient();
            char symbol = ingredientBuilder.getSymbol();
            shapedRecipeBuilder.define(symbol, ingredient);
            shapedRecipeBuilder.unlockedBy("in_water", insideOf(Blocks.WATER));
        }

        this.recipeBuilders.put(this.toName(output), shapedRecipeBuilder);
    }

    public void chestBoat(RecipeCategory recipeCategory, String group, ItemLike output, IngredientBuilder... ingredientBuilders) {
        ShapelessRecipeBuilder shapelessRecipeBuilder = ShapelessRecipeBuilder.shapeless(recipeCategory, output);

        if (group != null) {
            shapelessRecipeBuilder.group(group);
        }

        IngredientBuilder[] ingridentBuilders = ingredientBuilders;
        for (int i = 0; i < ingredientBuilders.length; ++i) {
            IngredientBuilder ingredientBuilder = ingridentBuilders[i];
            Ingredient ingredient = ingredientBuilder.getIngredient();
            int count = ingredientBuilder.getCount();
            shapelessRecipeBuilder.requires(ingredient, count);
            shapelessRecipeBuilder.unlockedBy("has_boat", has(ItemTags.BOATS));
        }

        this.recipeBuilders.put(this.toName(output), shapelessRecipeBuilder);
    }

    public void llama(ItemLike ingredient, ItemLike output) {
        this.shaped(RecipeCategory.DECORATIONS, output, PatternBuilder.builder("#  ", "###", "# #"), IngredientBuilder.build(ingredient).symbol('#').requires());
    }

    public void waxCopper(ItemLike nonWaxed, ItemLike waxed) {
        this.shapeless(UnlockMethod.CRAFT, RecipeCategory.DECORATIONS, waxed, IngredientBuilder.build(nonWaxed), IngredientBuilder.build(Items.HONEYCOMB));
    }

    public void cultivator(ItemLike output, ItemLike dye, ItemLike glass) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "cultivators", output, PatternBuilder.builder("#$#", "#%#", "@@@"), IngredientBuilder.build(Blocks.GLASS).symbol('#').requires(), IngredientBuilder.build(dye).symbol('$'), IngredientBuilder.build(Items.WATER_BUCKET).symbol('%'), IngredientBuilder.build(Items.IRON_INGOT).symbol('@'));
        this.shaped(this.toName(output) + "_from_colored_glass", RecipeCategory.BUILDING_BLOCKS, "cultivators", output, PatternBuilder.builder("# #", "#%#", "@@@"), IngredientBuilder.build(glass).symbol('#').requires(), IngredientBuilder.build(Items.WATER_BUCKET).symbol('%'), IngredientBuilder.build(Items.IRON_INGOT).symbol('@'));
    }

    public void craftingTable(ItemLike output, ItemLike modifier) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, output, PatternBuilder.builder("$$", "##", "##"), IngredientBuilder.build(ItemTags.PLANKS).symbol('#').requires(), IngredientBuilder.build(modifier).symbol('$'));
    }

    public void cultivate(CultivationBookCategory cultivationBookCategory, Item ingredient, ItemLike itemLike, int time) {
        CultivationRecipeBuilder cultivationRecipeBuilder = CultivationRecipeBuilder.recipe(cultivationBookCategory, null, ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient));
        this.recipeBuilders.put(this.toName(itemLike), cultivationRecipeBuilder);
    }

    public void archaeology(ArchaeologyBookCategory archaeologyBookCategory, String name, Item ingredient, ItemLike itemLike, int time) {
        ArchaeologyRecipeBuilder archaeologyRecipeBuilder = ArchaeologyRecipeBuilder.recipe(archaeologyBookCategory, ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient));
        this.recipeBuilders.put(name, archaeologyRecipeBuilder);
    }

    public void archaeology(ArchaeologyBookCategory archaeologyBookCategory, Item ingredient, ItemLike itemLike, int time) {
        ArchaeologyRecipeBuilder archaeologyRecipeBuilder = ArchaeologyRecipeBuilder.recipe(archaeologyBookCategory, ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient));
        this.recipeBuilders.put(this.toName(itemLike), archaeologyRecipeBuilder);
    }

    public void analyzation(AnalyzationBookCategory analyzationBookCategory, ItemLike ingredient, TagKey<AnalyzerResult> results, int time) {
        this.recipeBuilders.put(this.toName(ingredient) + "_outputs", AnalyzationRecipeBuilder.recipe(analyzationBookCategory, Ingredient.of(ingredient), results, time).unlockedBy(getHasName(ingredient), has(ingredient)));
    }

    public void analyzation(AnalyzationBookCategory analyzationBookCategory, TagKey<Item> itemTagKey, String name, TagKey<AnalyzerResult> results, int time) {
        this.recipeBuilders.put(name, AnalyzationRecipeBuilder.recipe(analyzationBookCategory, Ingredient.of(itemTagKey), results, time).unlockedBy("has_" + itemTagKey.location().getPath(), has(itemTagKey)));
    }
}
