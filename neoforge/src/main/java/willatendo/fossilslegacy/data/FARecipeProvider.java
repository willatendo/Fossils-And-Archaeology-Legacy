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
import willatendo.fossilslegacy.server.analyzer_result.AnalyzerResult;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.menu.categories.AnalyzationBookCategory;
import willatendo.fossilslegacy.server.menu.categories.ArchaeologyBookCategory;
import willatendo.fossilslegacy.server.menu.categories.CultivationBookCategory;
import willatendo.fossilslegacy.server.recipe.recipes.MagicConchRecipe;
import willatendo.fossilslegacy.server.tags.FAAnalyzerResultTags;
import willatendo.fossilslegacy.server.tags.FAItemTags;
import willatendo.simplelibrary.data.SimpleRecipeProvider;

import java.util.concurrent.CompletableFuture;

public class FARecipeProvider extends SimpleRecipeProvider {
    public FARecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries, String modId) {
        super(packOutput, registries, modId);
    }

    @Override
    public void addRecipes() {
        this.shaped("cake_from_eggs", RecipeCategory.FOOD, Items.CAKE, PatternBuilder.builder("###", "$%$", "&&&"), IngredientBuilder.build(Items.MILK_BUCKET).symbol('#'), IngredientBuilder.build(Items.SUGAR).symbol('$'), IngredientBuilder.build(FAItemTags.CAKE_EGGS).requires(FAItemTags.CAKE_EGGS, "has_egg").symbol('%'), IngredientBuilder.build(Items.WHEAT).symbol('&'));
        this.shaped(RecipeCategory.FOOD, FAItems.CHICKEN_ESSENCE_BOTTLE.get(), 8, PatternBuilder.builder("###", "#$#", "###"), IngredientBuilder.build(Items.GLASS_BOTTLE).symbol('#'), IngredientBuilder.build(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get()).requires().symbol('$'));
        this.shapeless(RecipeCategory.FOOD, FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), IngredientBuilder.build(Items.BUCKET).requires(), IngredientBuilder.build(Items.SWEET_BERRIES, 4), IngredientBuilder.build(Items.CARROT), IngredientBuilder.build(Items.POTATO), IngredientBuilder.build(Items.BEEF), IngredientBuilder.build(Items.PORKCHOP));
        this.shaped(RecipeCategory.FOOD, FAItems.ROMANTIC_CONCOCTION_BOTTLE.get(), 8, PatternBuilder.builder("###", "#$#", "###"), IngredientBuilder.build(Items.GLASS_BOTTLE).symbol('#'), IngredientBuilder.build(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get()).symbol('$').requires());
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FABlocks.SKULL_LANTERN_BLOCK.get(), IngredientBuilder.build(FABlocks.SKULL_BLOCK.get()).requires(), IngredientBuilder.build(Items.TORCH));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FAItems.SKULL_STICK.get(), PatternBuilder.builder("#", "$"), IngredientBuilder.build(FABlocks.SKULL_BLOCK.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FAItems.TOOTH_DAGGER.get(), PatternBuilder.builder("#", "$"), IngredientBuilder.build(FAItems.TYRANNOSAURUS_TOOTH.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shapeless(RecipeCategory.TOOLS, FAItems.DINOPEDIA.get(), IngredientBuilder.build(Items.BOOK), IngredientBuilder.build(FAItemTags.DNA).requires(FAItemTags.DNA, "has_dna"));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.ANALYZER.get(), PatternBuilder.builder("#%#", "#$#"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#'), IngredientBuilder.build(FAItems.RELIC_SCRAP.get()).symbol('%'), IngredientBuilder.build(FAItems.FOSSIL.get()).symbol('$').requires());
        this.cultivator(FABlocks.WHITE_CULTIVATOR.get(), Items.WHITE_DYE, Blocks.WHITE_STAINED_GLASS);
        this.cultivator(FABlocks.ORANGE_CULTIVATOR.get(), Items.ORANGE_DYE, Blocks.ORANGE_STAINED_GLASS);
        this.cultivator(FABlocks.MAGENTA_CULTIVATOR.get(), Items.MAGENTA_DYE, Blocks.MAGENTA_STAINED_GLASS);
        this.cultivator(FABlocks.LIGHT_BLUE_CULTIVATOR.get(), Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_STAINED_GLASS);
        this.cultivator(FABlocks.YELLOW_CULTIVATOR.get(), Items.YELLOW_DYE, Blocks.YELLOW_STAINED_GLASS);
        this.cultivator(FABlocks.LIME_CULTIVATOR.get(), Items.LIME_DYE, Blocks.LIME_STAINED_GLASS);
        this.cultivator(FABlocks.PINK_CULTIVATOR.get(), Items.PINK_DYE, Blocks.PINK_STAINED_GLASS);
        this.cultivator(FABlocks.GRAY_CULTIVATOR.get(), Items.GRAY_DYE, Blocks.GRAY_STAINED_GLASS);
        this.cultivator(FABlocks.LIGHT_GRAY_CULTIVATOR.get(), Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_STAINED_GLASS);
        this.cultivator(FABlocks.CYAN_CULTIVATOR.get(), Items.CYAN_DYE, Blocks.CYAN_STAINED_GLASS);
        this.cultivator(FABlocks.PURPLE_CULTIVATOR.get(), Items.PURPLE_DYE, Blocks.PURPLE_STAINED_GLASS);
        this.cultivator(FABlocks.BLUE_CULTIVATOR.get(), Items.BLUE_DYE, Blocks.BLUE_STAINED_GLASS);
        this.cultivator(FABlocks.BROWN_CULTIVATOR.get(), Items.BROWN_DYE, Blocks.BROWN_STAINED_GLASS);
        this.cultivator(FABlocks.GREEN_CULTIVATOR.get(), Items.GREEN_DYE, Blocks.GREEN_STAINED_GLASS);
        this.cultivator(FABlocks.RED_CULTIVATOR.get(), Items.RED_DYE, Blocks.RED_STAINED_GLASS);
        this.cultivator(FABlocks.BLACK_CULTIVATOR.get(), Items.BLACK_DYE, Blocks.BLACK_STAINED_GLASS);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.GENE_MODIFICATION_TABLE.get(), PatternBuilder.builder("#$#", "#&#", "#!#"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#').requires(), IngredientBuilder.build(Blocks.REDSTONE_BLOCK).symbol('$'), IngredientBuilder.build(Items.NETHER_STAR).symbol('&'), IngredientBuilder.build(Items.GOLD_INGOT).symbol('!'));
        this.craftingTable(FABlocks.ARCHAEOLOGY_WORKBENCH.get(), Items.PAPER);
        this.craftingTable(FABlocks.PALAEONTOLOGY_TABLE.get(), FAItems.FOSSIL.get());
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.DRUM.get(), PatternBuilder.builder("###", "$%$", "$$$"), IngredientBuilder.build(Items.LEATHER).symbol('#').requires(), IngredientBuilder.build(ItemTags.PLANKS).symbol('$'), IngredientBuilder.build(Items.REDSTONE).symbol('%'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.FEEDER.get(), PatternBuilder.builder("#$#", "%@!", "!!!"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#'), IngredientBuilder.build(Blocks.GLASS).symbol('$'), IngredientBuilder.build(Blocks.STONE_BUTTON).symbol('%'), IngredientBuilder.build(Items.BUCKET).symbol('@'), IngredientBuilder.build(Blocks.STONE).symbol('!').requires());
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), IngredientBuilder.build(Items.CHICKEN), IngredientBuilder.build(Items.BUCKET).requires());
        this.shapeless("skull_bonemeal", RecipeCategory.MISC, Items.BONE_MEAL, 5, IngredientBuilder.build(FABlocks.SKULL_BLOCK.get()));
        this.shapeless(RecipeCategory.MISC, FAItems.OVERWORLD_COIN.get(), IngredientBuilder.build(FAItems.PREHISTORIC_COIN.get()).requires());
        this.shapeless(RecipeCategory.MISC, FAItems.PREHISTORIC_COIN.get(), IngredientBuilder.build(FAItems.OVERWORLD_COIN.get()).requires());
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FABlocks.LEPIDODENDRON_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_LOG.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get()).symbol('#'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "planks", FABlocks.LEPIDODENDRON_PLANKS.get(), 4, IngredientBuilder.build(FAItemTags.LEPIDODENDRON_LOGS));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_stairs", FABlocks.LEPIDODENDRON_STAIRS.get(), 4, PatternBuilder.builder("#  ", "## ", "###"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_slab", FABlocks.LEPIDODENDRON_SLAB.get(), 6, PatternBuilder.builder("###"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.DECORATIONS, "wooden_fence", FABlocks.LEPIDODENDRON_FENCE.get(), 3, PatternBuilder.builder("#$#", "#$#"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_fence_gate", FABlocks.LEPIDODENDRON_FENCE_GATE.get(), PatternBuilder.builder("$#$", "$#$"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_door", FABlocks.LEPIDODENDRON_DOOR.get(), 3, PatternBuilder.builder("##", "##", "##"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_trapdoor", FABlocks.LEPIDODENDRON_TRAPDOOR.get(), 2, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_pressure_plate", FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), PatternBuilder.builder("##"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.shapeless(RecipeCategory.REDSTONE, "wooden_button", FABlocks.LEPIDODENDRON_BUTTON.get(), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()));
        this.shaped(RecipeCategory.DECORATIONS, "sign", FAItems.LEPIDODENDRON_SIGN.get(), 3, PatternBuilder.builder("###", "###", " $ "), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, "hanging_sign", FAItems.LEPIDODENDRON_HANGING_SIGN.get(), 6, PatternBuilder.builder("$ $", "###", "###"), IngredientBuilder.build(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get()).symbol('#').requires(), IngredientBuilder.build(Items.CHAIN).symbol('$'));
        this.boat(RecipeCategory.TRANSPORTATION, "boat", FAItems.LEPIDODENDRON_BOAT.get(), PatternBuilder.builder("# #", "###"), IngredientBuilder.build(FABlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.chestBoat(RecipeCategory.TRANSPORTATION, "chest_boat", FAItems.LEPIDODENDRON_CHEST_BOAT.get(), IngredientBuilder.build(FAItems.LEPIDODENDRON_BOAT.get()), IngredientBuilder.build(Items.CHEST));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FABlocks.SIGILLARIA_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.SIGILLARIA_LOG.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FABlocks.STRIPPED_SIGILLARIA_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.STRIPPED_SIGILLARIA_LOG.get()).symbol('#'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "planks", FABlocks.SIGILLARIA_PLANKS.get(), 4, IngredientBuilder.build(FAItemTags.SIGILLARIA_LOGS));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_stairs", FABlocks.SIGILLARIA_STAIRS.get(), 4, PatternBuilder.builder("#  ", "## ", "###"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_slab", FABlocks.SIGILLARIA_SLAB.get(), 6, PatternBuilder.builder("###"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.DECORATIONS, "wooden_fence", FABlocks.SIGILLARIA_FENCE.get(), 3, PatternBuilder.builder("#$#", "#$#"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_fence_gate", FABlocks.SIGILLARIA_FENCE_GATE.get(), PatternBuilder.builder("$#$", "$#$"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_door", FABlocks.SIGILLARIA_DOOR.get(), 3, PatternBuilder.builder("##", "##", "##"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_trapdoor", FABlocks.SIGILLARIA_TRAPDOOR.get(), 2, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_pressure_plate", FABlocks.SIGILLARIA_PRESSURE_PLATE.get(), PatternBuilder.builder("##"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.shapeless(RecipeCategory.REDSTONE, "wooden_button", FABlocks.SIGILLARIA_BUTTON.get(), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()));
        this.shaped(RecipeCategory.DECORATIONS, "sign", FAItems.SIGILLARIA_SIGN.get(), 3, PatternBuilder.builder("###", "###", " $ "), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, "hanging_sign", FAItems.SIGILLARIA_HANGING_SIGN.get(), 6, PatternBuilder.builder("$ $", "###", "###"), IngredientBuilder.build(FABlocks.STRIPPED_SIGILLARIA_LOG.get()).symbol('#').requires(), IngredientBuilder.build(Items.CHAIN).symbol('$'));
        this.boat(RecipeCategory.TRANSPORTATION, "boat", FAItems.SIGILLARIA_BOAT.get(), PatternBuilder.builder("# #", "###"), IngredientBuilder.build(FABlocks.SIGILLARIA_PLANKS.get()).symbol('#'));
        this.chestBoat(RecipeCategory.TRANSPORTATION, "chest_boat", FAItems.SIGILLARIA_CHEST_BOAT.get(), IngredientBuilder.build(FAItems.SIGILLARIA_BOAT.get()), IngredientBuilder.build(Items.CHEST));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FABlocks.CALAMITES_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.CALAMITES_LOG.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "bark", FABlocks.STRIPPED_CALAMITES_WOOD.get(), 3, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.STRIPPED_CALAMITES_LOG.get()).symbol('#'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, "planks", FABlocks.CALAMITES_PLANKS.get(), 4, IngredientBuilder.build(FAItemTags.CALAMITES_LOGS));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_stairs", FABlocks.CALAMITES_STAIRS.get(), 4, PatternBuilder.builder("#  ", "## ", "###"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "wooden_slab", FABlocks.CALAMITES_SLAB.get(), 6, PatternBuilder.builder("###"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.DECORATIONS, "wooden_fence", FABlocks.CALAMITES_FENCE.get(), 3, PatternBuilder.builder("#$#", "#$#"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_fence_gate", FABlocks.CALAMITES_FENCE_GATE.get(), PatternBuilder.builder("$#$", "$#$"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_door", FABlocks.CALAMITES_DOOR.get(), 3, PatternBuilder.builder("##", "##", "##"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_trapdoor", FABlocks.CALAMITES_TRAPDOOR.get(), 2, PatternBuilder.builder("##", "##"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shaped(RecipeCategory.REDSTONE, "wooden_pressure_plate", FABlocks.CALAMITES_PRESSURE_PLATE.get(), PatternBuilder.builder("##"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.shapeless(RecipeCategory.REDSTONE, "wooden_button", FABlocks.CALAMITES_BUTTON.get(), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()));
        this.shaped(RecipeCategory.DECORATIONS, "sign", FAItems.CALAMITES_SIGN.get(), 3, PatternBuilder.builder("###", "###", " $ "), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#').requires(), IngredientBuilder.build(Items.STICK).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, "hanging_sign", FAItems.CALAMITES_HANGING_SIGN.get(), 6, PatternBuilder.builder("$ $", "###", "###"), IngredientBuilder.build(FABlocks.STRIPPED_CALAMITES_LOG.get()).symbol('#').requires(), IngredientBuilder.build(Items.CHAIN).symbol('$'));
        this.boat(RecipeCategory.TRANSPORTATION, "boat", FAItems.CALAMITES_BOAT.get(), PatternBuilder.builder("# #", "###"), IngredientBuilder.build(FABlocks.CALAMITES_PLANKS.get()).symbol('#'));
        this.chestBoat(RecipeCategory.TRANSPORTATION, "chest_boat", FAItems.CALAMITES_CHEST_BOAT.get(), IngredientBuilder.build(FAItems.CALAMITES_BOAT.get()), IngredientBuilder.build(Items.CHEST));
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_VASE.get(), PatternBuilder.builder("###", "# #", "###"), IngredientBuilder.build(Items.BRICK).symbol('#').requires());
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_JADE_VASE.get(), PatternBuilder.builder("#$#", "$ $", "#$#"), IngredientBuilder.build(Items.BRICK).symbol('#').requires(), IngredientBuilder.build(FAItems.JADE.get()).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_OCELOT_VASE.get(), PatternBuilder.builder("#$#", "$ $", "#$#"), IngredientBuilder.build(Items.BRICK).symbol('#').requires(), IngredientBuilder.build(FAItems.JADE_OCELOT.get()).symbol('$'));
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_VILLAGER_VASE.get(), PatternBuilder.builder("#$#", "$ $", "#$#"), IngredientBuilder.build(Items.BRICK).symbol('#').requires(), IngredientBuilder.build(FAItems.JADE_VILLAGER.get()).symbol('$'));
        this.llama(Items.IRON_INGOT, FABlocks.IRON_LLAMA_STATUE.get());
        this.llama(Items.COPPER_INGOT, FABlocks.COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get());

        this.special("magic_conch", MagicConchRecipe::new);

        this.copySmithingTemplate(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Blocks.STONE_BRICKS);

        this.food(FAItems.COOKED_TRICERATOPS.get(), FAItems.RAW_TRICERATOPS.get(), 0.35F);
        this.food(FAItems.COOKED_VELOCIRAPTOR.get(), FAItems.RAW_VELOCIRAPTOR.get(), 0.35F);
        this.food(FAItems.COOKED_TYRANNOSAURUS.get(), FAItems.RAW_TYRANNOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_PTERANODON.get(), FAItems.RAW_PTERANODON.get(), 0.35F);
        this.food(FAItems.SIO_CHIU_LE.get(), FAItems.NAUTILUS.get(), 0.35F);
        this.food(FAItems.COOKED_FUTABASAURUS.get(), FAItems.RAW_FUTABASAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_MOSASAURUS.get(), FAItems.RAW_MOSASAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_STEGOSAURUS.get(), FAItems.RAW_STEGOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_DILOPHOSAURUS.get(), FAItems.RAW_DILOPHOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_BRACHIOSAURUS.get(), FAItems.RAW_BRACHIOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_SMILODON.get(), FAItems.RAW_SMILODON.get(), 0.35F);
        this.food(FAItems.COOKED_MAMMOTH.get(), FAItems.RAW_MAMMOTH.get(), 0.35F);
        this.food(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get(), FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), 0.35F);
        this.food(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), 0.35F);
        this.food(FAItems.COOKED_CARNOTAURUS.get(), FAItems.RAW_CARNOTAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_CRYOLOPHOSAURUS.get(), FAItems.RAW_CRYOLOPHOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_THERIZINOSAURUS.get(), FAItems.RAW_THERIZINOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_PACHYCEPHALOSAURUS.get(), FAItems.RAW_PACHYCEPHALOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_COMPSOGNATHUS.get(), FAItems.RAW_COMPSOGNATHUS.get(), 0.35F);
        this.food(FAItems.COOKED_DODO.get(), FAItems.RAW_DODO.get(), 0.35F);
        this.food(FAItems.COOKED_MOA.get(), FAItems.RAW_MOA.get(), 0.35F);
        this.food(FAItems.COOKED_GALLIMIMUS.get(), FAItems.RAW_GALLIMIMUS.get(), 0.35F);
        this.food(FAItems.COOKED_SPINOSAURUS.get(), FAItems.RAW_SPINOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_ANKYLOSAURUS.get(), FAItems.RAW_ANKYLOSAURUS.get(), 0.35F);
        this.food(FAItems.COOKED_DIMETRODON.get(), FAItems.RAW_DIMETRODON.get(), 0.35F);

        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_SWORD.get(), RecipeCategory.COMBAT);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_SHOVEL.get(), RecipeCategory.TOOLS);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_PICKAXE.get(), RecipeCategory.TOOLS);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_AXE.get(), RecipeCategory.TOOLS);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_HOE.get(), RecipeCategory.TOOLS);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HELMET, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_HELMET.get(), RecipeCategory.COMBAT);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_CHESTPLATE, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_CHESTPLATE.get(), RecipeCategory.COMBAT);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_LEGGINGS, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_LEGGINGS.get(), RecipeCategory.COMBAT);
        this.smithing(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_BOOTS, FAItems.SCARAB_GEM.get(), FAItems.SCARAB_GEM_BOOTS.get(), RecipeCategory.COMBAT);

        this.cultivate(CultivationBookCategory.EGG, FAItems.TRICERATOPS_DNA.get(), FAItems.TRICERATOPS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.VELOCIRAPTOR_DNA.get(), FAItems.VELOCIRAPTOR_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.TYRANNOSAURUS_DNA.get(), FAItems.TYRANNOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.PTERANODON_DNA.get(), FAItems.PTERANODON_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.NAUTILUS_DNA.get(), FAItems.NAUTILUS_EGGS.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.FUTABASAURUS_DNA.get(), FAItems.FUTABASAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.MOSASAURUS_DNA.get(), FAItems.MOSASAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.STEGOSAURUS_DNA.get(), FAItems.STEGOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.DILOPHOSAURUS_DNA.get(), FAItems.DILOPHOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.BRACHIOSAURUS_DNA.get(), FAItems.BRACHIOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.ARMADILLO_DNA.get(), FAItems.ARMADILLO_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.AXOLOTL_DNA.get(), FAItems.AXOLOTLSPAWN.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.CAT_DNA.get(), FAItems.CAT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.CHICKEN_DNA.get(), FAItems.INCUBATED_CHICKEN_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.COW_DNA.get(), FAItems.COW_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.DOLPHIN_DNA.get(), FAItems.DOLPHIN_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.DONKEY_DNA.get(), FAItems.DONKEY_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.FOX_DNA.get(), FAItems.FOX_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.FROG_DNA.get(), Blocks.FROGSPAWN, 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.GOAT_DNA.get(), FAItems.GOAT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.HORSE_DNA.get(), FAItems.HORSE_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.LLAMA_DNA.get(), FAItems.LLAMA_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.MULE_DNA.get(), FAItems.MULE_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.OCELOT_DNA.get(), FAItems.OCELOT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.PANDA_DNA.get(), FAItems.PANDA_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.PARROT_DNA.get(), FAItems.INCUBATED_PARROT_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.PIG_DNA.get(), FAItems.PIG_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.POLAR_BEAR_DNA.get(), FAItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.RABBIT_DNA.get(), FAItems.RABBIT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.SHEEP_DNA.get(), FAItems.SHEEP_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.WOLF_DNA.get(), FAItems.WOLF_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.SMILODON_DNA.get(), FAItems.SMILODON_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.MAMMOTH_DNA.get(), FAItems.MAMMOTH_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.CARNOTAURUS_DNA.get(), FAItems.CARNOTAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.CRYOLOPHOSAURUS_DNA.get(), FAItems.CRYOLOPHOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.THERIZINOSAURUS_DNA.get(), FAItems.THERIZINOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.PACHYCEPHALOSAURUS_DNA.get(), FAItems.PACHYCEPHALOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.COMPSOGNATHUS_DNA.get(), FAItems.COMPSOGNATHUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.DODO_DNA.get(), FAItems.INCUBATED_DODO_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.MOA_DNA.get(), FAItems.INCUBATED_MOA_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.GALLIMIMUS_DNA.get(), FAItems.GALLIMIMUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.SPINOSAURUS_DNA.get(), FAItems.SPINOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.ANKYLOSAURUS_DNA.get(), FAItems.ANKYLOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.DIMETRODON_DNA.get(), FAItems.DIMETRODON_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.JURASSIC_FERN_DNA.get(), FAItems.JURASSIC_FERN_SPORES.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.LEPIDODENDRON_DNA.get(), FABlocks.LEPIDODENDRON_SAPLING.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.SIGILLARIA_DNA.get(), FABlocks.SIGILLARIA_SAPLING.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.CALAMITES_DNA.get(), FABlocks.CALAMITES_SAPLING.get(), 6000);

        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_HELMET_ARTIFACT.get(), FAItems.ANCIENT_HELMET.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), FAItems.ANCIENT_CHESTPLATE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_LEGGINGS_ARTIFACT.get(), FAItems.ANCIENT_LEGGINGS.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_BOOTS_ARTIFACT.get(), FAItems.ANCIENT_BOOTS.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_SWORD_ARTIFACT.get(), FAItems.ANCIENT_SWORD.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_SHOVEL_ARTIFACT.get(), FAItems.ANCIENT_SHOVEL.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_PICKAXE_ARTIFACT.get(), FAItems.ANCIENT_PICKAXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_AXE_ARTIFACT.get(), FAItems.ANCIENT_AXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.RESTORE, FAItems.ANCIENT_HOE_ARTIFACT.get(), FAItems.ANCIENT_HOE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_axe_repair", FAItems.SCARAB_GEM_AXE.get(), FAItems.SCARAB_GEM_AXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_hoe_repair", FAItems.SCARAB_GEM_HOE.get(), FAItems.SCARAB_GEM_HOE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_pickaxe_repair", FAItems.SCARAB_GEM_PICKAXE.get(), FAItems.SCARAB_GEM_PICKAXE.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_shovel_repair", FAItems.SCARAB_GEM_SHOVEL.get(), FAItems.SCARAB_GEM_SHOVEL.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_sword_repair", FAItems.SCARAB_GEM_SWORD.get(), FAItems.SCARAB_GEM_SWORD.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "diamond_javelin_repair", FAItems.BROKEN_DIAMOND_JAVELIN.get(), FAItems.DIAMOND_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "golden_javelin_repair", FAItems.BROKEN_GOLDEN_JAVELIN.get(), FAItems.GOLDEN_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "iron_javelin_repair", FAItems.BROKEN_IRON_JAVELIN.get(), FAItems.IRON_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "netherite_javelin_repair", FAItems.BROKEN_NETHERITE_JAVELIN.get(), FAItems.NETHERITE_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "scarab_gem_javelin_repair", FAItems.BROKEN_SCARAB_GEM_JAVELIN.get(), FAItems.SCARAB_GEM_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "stone_javelin_repair", FAItems.BROKEN_STONE_JAVELIN.get(), FAItems.STONE_JAVELIN.get(), 3000);
        this.archaeology(ArchaeologyBookCategory.REPAIR, "wooden_javelin_repair", FAItems.BROKEN_WOODEN_JAVELIN.get(), FAItems.WOODEN_JAVELIN.get(), 3000);

        this.analyzation(AnalyzationBookCategory.MISC, FAItems.FOSSIL.get(), FAAnalyzerResultTags.FOSSIL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RELIC_SCRAP.get(), FAAnalyzerResultTags.RELIC_SCRAP_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.FROZEN_MEAT.get(), FAAnalyzerResultTags.FROZEN_MEAT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.AXOLOTL_BUCKET, FAAnalyzerResultTags.AXOLOTL_BUCKET_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.TROPICAL_FISH_BUCKET, FAAnalyzerResultTags.TROPICAL_FISH_BUCKET_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.PORKCHOP, FAAnalyzerResultTags.PORKCHOP_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.BEEF, FAAnalyzerResultTags.BEEF_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.CHICKEN, FAAnalyzerResultTags.CHICKEN_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.FEATHER, FAAnalyzerResultTags.FEATHER_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.BAMBOO, FAAnalyzerResultTags.BAMBOO_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.SLIME_BALL, FAAnalyzerResultTags.SLIME_BALL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.MUTTON, FAAnalyzerResultTags.MUTTON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.RABBIT, FAAnalyzerResultTags.RAW_RABBIT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.BONE, FAAnalyzerResultTags.BONE_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.EMERALD, FAAnalyzerResultTags.EMERALD_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.GOAT_HORN, FAAnalyzerResultTags.GOAT_HORN_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItemTags.FROGLIGHTS, "froglights_outputs", FAAnalyzerResultTags.FROGLIGHT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.LEATHER, FAAnalyzerResultTags.LEATHER_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.STRING, FAAnalyzerResultTags.STRING_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.COD, FAAnalyzerResultTags.COD_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.SALMON, FAAnalyzerResultTags.SALMON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, ItemTags.WOOL, "wool_outputs", FAAnalyzerResultTags.WOOL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, Items.ARMADILLO_SCUTE, FAAnalyzerResultTags.ARMADILLO_SCUTE_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_BRACHIOSAURUS.get(), FAAnalyzerResultTags.RAW_BRACHIOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_DILOPHOSAURUS.get(), FAAnalyzerResultTags.RAW_DILOPHOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_MAMMOTH.get(), FAAnalyzerResultTags.RAW_MAMMOTH_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_MOSASAURUS.get(), FAAnalyzerResultTags.RAW_MOSASAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_FUTABASAURUS.get(), FAAnalyzerResultTags.RAW_FUTABASAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_PTERANODON.get(), FAAnalyzerResultTags.RAW_PTERANODON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_SMILODON.get(), FAAnalyzerResultTags.RAW_SMILODON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_STEGOSAURUS.get(), FAAnalyzerResultTags.RAW_STEGOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_TRICERATOPS.get(), FAAnalyzerResultTags.RAW_TRICERATOPS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_TYRANNOSAURUS.get(), FAAnalyzerResultTags.RAW_TYRANNOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_VELOCIRAPTOR.get(), FAAnalyzerResultTags.RAW_VELOCIRAPTOR_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_CARNOTAURUS.get(), FAAnalyzerResultTags.RAW_CARNOTAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_CRYOLOPHOSAURUS.get(), FAAnalyzerResultTags.RAW_CRYOLOPHOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_THERIZINOSAURUS.get(), FAAnalyzerResultTags.RAW_THERIZINOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_PACHYCEPHALOSAURUS.get(), FAAnalyzerResultTags.RAW_PACHYCEPHALOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_COMPSOGNATHUS.get(), FAAnalyzerResultTags.RAW_COMPSOGNATHUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_DODO.get(), FAAnalyzerResultTags.RAW_DODO_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_MOA.get(), FAAnalyzerResultTags.RAW_MOA_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_GALLIMIMUS.get(), FAAnalyzerResultTags.RAW_GALLIMIMUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_SPINOSAURUS.get(), FAAnalyzerResultTags.RAW_SPINOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_ANKYLOSAURUS.get(), FAAnalyzerResultTags.RAW_ANKYLOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.MISC, FAItems.RAW_DIMETRODON.get(), FAAnalyzerResultTags.RAW_DIMETRODON_RESULTS, 100);
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
