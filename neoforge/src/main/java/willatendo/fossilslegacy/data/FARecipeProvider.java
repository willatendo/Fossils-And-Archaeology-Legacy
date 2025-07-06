package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
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
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.concurrent.CompletableFuture;

public class FARecipeProvider extends RecipeProvider {
    protected FARecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    private String name(String id) {
        return FAUtils.ID + ":" + id;
    }

    @Override
    protected void buildRecipes() {
        this.shaped(RecipeCategory.FOOD, Items.CAKE).pattern("###").pattern("$%$").pattern("&&&").define('#', Items.MILK_BUCKET).define('$', Items.SUGAR).define('%', this.tag(FAItemTags.CAKE_EGGS)).define('&', Items.WHEAT).unlockedBy("has_egg", has(FAItemTags.CAKE_EGGS)).save(this.output, this.name("cake_from_eggs"));
        this.shaped(RecipeCategory.FOOD, FAItems.CHICKEN_ESSENCE_BOTTLE.get(), 8).pattern("###").pattern("#$#").pattern("###").define('#', Items.GLASS_BOTTLE).define('$', FAItems.COOKED_CHICKEN_SOUP_BUCKET.get()).unlockedBy(getHasName(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get()), has(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get()));
        this.shapeless(RecipeCategory.FOOD, FAItems.RAW_BERRY_MEDLEY_BUCKET.get()).requires(Items.BUCKET).requires(Items.SWEET_BERRIES, 4).requires(Items.CARROT).requires(Items.POTATO).requires(Items.BEEF).requires(Items.PORKCHOP).unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET)).save(this.output);
        this.shaped(RecipeCategory.FOOD, FAItems.ROMANTIC_CONCOCTION_BOTTLE.get(), 8).pattern("###").pattern("#$#").pattern("###").define('#', Items.GLASS_BOTTLE).define('$', FAItems.COOKED_BERRY_MEDLEY_BUCKET.get()).unlockedBy(getHasName(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get()), has(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get())).save(this.output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FABlocks.SKULL_LANTERN_BLOCK.get()).requires(FABlocks.SKULL_BLOCK.get()).requires(Items.TORCH).unlockedBy(getHasName(FABlocks.SKULL_BLOCK.get()), has(FABlocks.SKULL_BLOCK.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FAItems.SKULL_STICK.get()).pattern("#").pattern("$").define('#', FABlocks.SKULL_BLOCK.get()).define('$', Items.STICK).unlockedBy(getHasName(FABlocks.SKULL_BLOCK.get()), has(FABlocks.SKULL_BLOCK.get())).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FAItems.TOOTH_DAGGER.get()).pattern("#").pattern("$").define('#', FAItems.TYRANNOSAURUS_TOOTH.get()).define('$', Items.STICK).unlockedBy(getHasName(FAItems.TYRANNOSAURUS_TOOTH.get()), has(FAItems.TYRANNOSAURUS_TOOTH.get())).save(this.output);
        this.shapeless(RecipeCategory.TOOLS, FAItems.DINOPEDIA.get()).requires(Items.BOOK).requires(this.tag(FAItemTags.DNA)).unlockedBy("has_dna", has(FAItemTags.DNA)).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.ANALYZER.get()).pattern("#%#").pattern("#$#").define('#', Items.IRON_INGOT).define('%', FAItems.RELIC_SCRAP.get()).define('$', FAItems.FOSSIL.get()).unlockedBy(getHasName(FAItems.FOSSIL.get()), has(FAItems.FOSSIL.get())).save(this.output);
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
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.DNA_RECOMBINATOR.get()).pattern("#$#").pattern("#&#").pattern("#!#").define('#', Items.IRON_INGOT).define('$', Blocks.REDSTONE_BLOCK).define('&', Items.NETHER_STAR).define('!', Items.GOLD_INGOT).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(this.output);
        this.craftingTable(FABlocks.ARCHAEOLOGY_WORKBENCH.get(), Items.PAPER);
        this.craftingTable(FABlocks.PALAEONTOLOGY_TABLE.get(), FAItems.FOSSIL.get());
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.DRUM.get()).pattern("###").pattern("$%$").pattern("$$$").define('#', Items.LEATHER).define('$', this.tag(ItemTags.PLANKS)).define('%', Items.REDSTONE).unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER)).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FABlocks.FEEDER.get()).pattern("#$#").pattern("%@!").pattern("!!!").define('#', Items.IRON_INGOT).define('$', Blocks.GLASS).define('%', Blocks.STONE_BUTTON).define('@', Items.BUCKET).define('!', Blocks.STONE).unlockedBy(getHasName(Blocks.STONE), has(Blocks.STONE)).save(this.output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FAItems.RAW_CHICKEN_SOUP_BUCKET.get()).requires(Items.CHICKEN).requires(Items.BUCKET).unlockedBy(getHasName(Items.BUCKET), has(Items.BUCKET)).save(this.output);
        this.shapeless(RecipeCategory.MISC, Items.BONE_MEAL, 5).requires(FABlocks.SKULL_BLOCK.get()).unlockedBy(getHasName(FABlocks.SKULL_BLOCK.get()), has(FABlocks.SKULL_BLOCK.get())).save(this.output, FAUtils.ID + ":skull_bonemeal");
        this.shapeless(RecipeCategory.MISC, FAItems.OVERWORLD_COIN.get()).requires(FAItems.PREHISTORIC_COIN.get()).unlockedBy(getHasName(FAItems.OVERWORLD_COIN.get()), has(FAItems.OVERWORLD_COIN.get())).save(this.output);
        this.shapeless(RecipeCategory.MISC, FAItems.PREHISTORIC_COIN.get()).requires(FAItems.OVERWORLD_COIN.get()).unlockedBy(getHasName(FAItems.PREHISTORIC_COIN.get()), has(FAItems.PREHISTORIC_COIN.get())).save(this.output);
        this.woodType(FABlocks.LEPIDODENDRON_LOG.get(), FABlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FABlocks.LEPIDODENDRON_WOOD.get(), FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), FAItemTags.LEPIDODENDRON_LOGS, FABlocks.LEPIDODENDRON_PLANKS.get(), FABlocks.LEPIDODENDRON_STAIRS.get(), FABlocks.LEPIDODENDRON_SLAB.get(), FABlocks.LEPIDODENDRON_FENCE.get(), FABlocks.LEPIDODENDRON_FENCE_GATE.get(), FABlocks.LEPIDODENDRON_DOOR.get(), FABlocks.LEPIDODENDRON_TRAPDOOR.get(), FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), FABlocks.LEPIDODENDRON_BUTTON.get(), FAItems.LEPIDODENDRON_SIGN.get(), FAItems.LEPIDODENDRON_HANGING_SIGN.get(), FAItems.LEPIDODENDRON_BOAT.get(), FAItems.LEPIDODENDRON_CHEST_BOAT.get());
        this.woodType(FABlocks.SIGILLARIA_LOG.get(), FABlocks.STRIPPED_SIGILLARIA_LOG.get(), FABlocks.SIGILLARIA_WOOD.get(), FABlocks.STRIPPED_SIGILLARIA_WOOD.get(), FAItemTags.SIGILLARIA_LOGS, FABlocks.SIGILLARIA_PLANKS.get(), FABlocks.SIGILLARIA_STAIRS.get(), FABlocks.SIGILLARIA_SLAB.get(), FABlocks.SIGILLARIA_FENCE.get(), FABlocks.SIGILLARIA_FENCE_GATE.get(), FABlocks.SIGILLARIA_DOOR.get(), FABlocks.SIGILLARIA_TRAPDOOR.get(), FABlocks.SIGILLARIA_PRESSURE_PLATE.get(), FABlocks.SIGILLARIA_BUTTON.get(), FAItems.SIGILLARIA_SIGN.get(), FAItems.SIGILLARIA_HANGING_SIGN.get(), FAItems.SIGILLARIA_BOAT.get(), FAItems.SIGILLARIA_CHEST_BOAT.get());
        this.woodType(FABlocks.CALAMITES_LOG.get(), FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.CALAMITES_WOOD.get(), FABlocks.STRIPPED_CALAMITES_WOOD.get(), FAItemTags.CALAMITES_LOGS, FABlocks.CALAMITES_PLANKS.get(), FABlocks.CALAMITES_STAIRS.get(), FABlocks.CALAMITES_SLAB.get(), FABlocks.CALAMITES_FENCE.get(), FABlocks.CALAMITES_FENCE_GATE.get(), FABlocks.CALAMITES_DOOR.get(), FABlocks.CALAMITES_TRAPDOOR.get(), FABlocks.CALAMITES_PRESSURE_PLATE.get(), FABlocks.CALAMITES_BUTTON.get(), FAItems.CALAMITES_SIGN.get(), FAItems.CALAMITES_HANGING_SIGN.get(), FAItems.CALAMITES_BOAT.get(), FAItems.CALAMITES_CHEST_BOAT.get());
        this.woodType(FABlocks.ARCHAEOPTERIS_LOG.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get(), FABlocks.ARCHAEOPTERIS_WOOD.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get(), FAItemTags.ARCHAEOPTERIS_LOGS, FABlocks.ARCHAEOPTERIS_PLANKS.get(), FABlocks.ARCHAEOPTERIS_STAIRS.get(), FABlocks.ARCHAEOPTERIS_SLAB.get(), FABlocks.ARCHAEOPTERIS_FENCE.get(), FABlocks.ARCHAEOPTERIS_FENCE_GATE.get(), FABlocks.ARCHAEOPTERIS_DOOR.get(), FABlocks.ARCHAEOPTERIS_TRAPDOOR.get(), FABlocks.ARCHAEOPTERIS_PRESSURE_PLATE.get(), FABlocks.ARCHAEOPTERIS_BUTTON.get(), FAItems.ARCHAEOPTERIS_SIGN.get(), FAItems.ARCHAEOPTERIS_HANGING_SIGN.get(), FAItems.ARCHAEOPTERIS_BOAT.get(), FAItems.ARCHAEOPTERIS_CHEST_BOAT.get());
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_VASE.get()).pattern("###").pattern("# #").pattern("###").define('#', Items.BRICK).unlockedBy(getHasName(Items.BRICK), has(Items.BRICK)).save(this.output);
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_JADE_VASE.get()).pattern("#$#").pattern("$ $").pattern("#$#").define('#', Items.BRICK).define('$', FAItems.JADE.get()).unlockedBy(getHasName(Items.BRICK), has(Items.BRICK)).save(this.output);
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_OCELOT_VASE.get()).pattern("#$#").pattern("$ $").pattern("#$#").define('#', Items.BRICK).define('$', FAItems.JADE_OCELOT.get()).unlockedBy(getHasName(Items.BRICK), has(Items.BRICK)).save(this.output);
        this.shaped(RecipeCategory.DECORATIONS, FABlocks.MAYAN_VILLAGER_VASE.get()).pattern("#$#").pattern("$ $").pattern("#$#").define('#', Items.BRICK).define('$', FAItems.JADE_VILLAGER.get()).unlockedBy(getHasName(Items.BRICK), has(Items.BRICK)).save(this.output);
        this.llama(Items.IRON_INGOT, FABlocks.IRON_LLAMA_STATUE.get());
        this.llama(Items.COPPER_INGOT, FABlocks.COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        this.waxCopper(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get());
        this.decorationPlaque(Blocks.WHITE_CONCRETE, FAItems.WHITE_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.ORANGE_CONCRETE, FAItems.ORANGE_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.MAGENTA_CONCRETE, FAItems.MAGENTA_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.LIGHT_BLUE_CONCRETE, FAItems.LIGHT_BLUE_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.YELLOW_CONCRETE, FAItems.YELLOW_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.LIME_CONCRETE, FAItems.LIME_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.PINK_CONCRETE, FAItems.PINK_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.GRAY_CONCRETE, FAItems.GRAY_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.LIGHT_GRAY_CONCRETE, FAItems.LIGHT_GRAY_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.CYAN_CONCRETE, FAItems.CYAN_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.PURPLE_CONCRETE, FAItems.PURPLE_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.BLUE_CONCRETE, FAItems.BLUE_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.BROWN_CONCRETE, FAItems.BROWN_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.GREEN_CONCRETE, FAItems.GREEN_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.RED_CONCRETE, FAItems.RED_DECORATION_PLAQUE.get());
        this.decorationPlaque(Blocks.BLACK_CONCRETE, FAItems.BLACK_DECORATION_PLAQUE.get());
        this.shaped(RecipeCategory.TOOLS, FABlocks.SMALL_CAGE.get()).pattern("###").pattern("$$$").pattern("###").define('#', Blocks.STONE_BRICKS).define('$', Blocks.IRON_BARS).unlockedBy(getHasName(Blocks.IRON_BARS), has(Blocks.IRON_BARS)).save(this.output);
        this.shaped(RecipeCategory.COMBAT, FAItems.RIFLE.get()).pattern("###").pattern(" $%").define('#', Items.IRON_INGOT).define('$', Items.STICK).define('%', ItemTags.PLANKS).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(this.output);
        this.shaped(RecipeCategory.COMBAT, FAItems.GREEN_TRANQUILIZER_DART.get(), 4).pattern("  $").pattern(" # ").pattern("%  ").define('$', Items.FEATHER).define('#', Items.POISONOUS_POTATO).define('%', Items.IRON_INGOT).unlockedBy(getHasName(Items.POISONOUS_POTATO), has(Items.POISONOUS_POTATO)).save(this.output);
        this.shaped(RecipeCategory.COMBAT, FAItems.RED_TRANQUILIZER_DART.get(), 4).pattern("  $").pattern(" # ").pattern("%  ").define('$', Items.FEATHER).define('#', Items.ROTTEN_FLESH).define('%', Items.IRON_INGOT).unlockedBy(getHasName(Items.ROTTEN_FLESH), has(Items.ROTTEN_FLESH)).save(this.output);
        this.shaped(RecipeCategory.COMBAT, FAItems.BLUE_TRANQUILIZER_DART.get(), 4).pattern("  $").pattern(" # ").pattern("%  ").define('$', Items.FEATHER).define('#', Items.FERMENTED_SPIDER_EYE).define('%', Items.IRON_INGOT).unlockedBy(getHasName(Items.FERMENTED_SPIDER_EYE), has(Items.FERMENTED_SPIDER_EYE)).save(this.output);
        this.hammer(ItemTags.WOODEN_TOOL_MATERIALS, FAItems.WOODEN_HAMMER.get());
        this.hammer(ItemTags.STONE_TOOL_MATERIALS, FAItems.STONE_HAMMER.get());
        this.hammer(Items.IRON_INGOT, FAItems.IRON_HAMMER.get());
        this.hammer(Items.GOLD_INGOT, FAItems.GOLDEN_HAMMER.get());
        this.hammer(Items.DIAMOND, FAItems.DIAMOND_HAMMER.get());
        this.netheriteSmithing(FAItems.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, FAItems.NETHERITE_HAMMER.get());

        SpecialRecipeBuilder.special(MagicConchRecipe::new).save(this.output, "magic_conch");

        this.copySmithingTemplate(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Blocks.STONE_BRICKS);

        this.food(FAItems.COOKED_TRICERATOPS.get(), FAItems.RAW_TRICERATOPS.get());
        this.food(FAItems.COOKED_VELOCIRAPTOR.get(), FAItems.RAW_VELOCIRAPTOR.get());
        this.food(FAItems.COOKED_TYRANNOSAURUS.get(), FAItems.RAW_TYRANNOSAURUS.get());
        this.food(FAItems.COOKED_PTERANODON.get(), FAItems.RAW_PTERANODON.get());
        this.food(FAItems.SIO_CHIU_LE.get(), FAItems.NAUTILUS.get());
        this.food(FAItems.COOKED_FUTABASAURUS.get(), FAItems.RAW_FUTABASAURUS.get());
        this.food(FAItems.COOKED_MOSASAURUS.get(), FAItems.RAW_MOSASAURUS.get());
        this.food(FAItems.COOKED_STEGOSAURUS.get(), FAItems.RAW_STEGOSAURUS.get());
        this.food(FAItems.COOKED_DILOPHOSAURUS.get(), FAItems.RAW_DILOPHOSAURUS.get());
        this.food(FAItems.COOKED_BRACHIOSAURUS.get(), FAItems.RAW_BRACHIOSAURUS.get());
        this.food(FAItems.COOKED_SMILODON.get(), FAItems.RAW_SMILODON.get());
        this.food(FAItems.COOKED_MAMMOTH.get(), FAItems.RAW_MAMMOTH.get());
        this.food(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get(), FAItems.RAW_CHICKEN_SOUP_BUCKET.get());
        this.food(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FAItems.RAW_BERRY_MEDLEY_BUCKET.get());
        this.food(FAItems.COOKED_CARNOTAURUS.get(), FAItems.RAW_CARNOTAURUS.get());
        this.food(FAItems.COOKED_CRYOLOPHOSAURUS.get(), FAItems.RAW_CRYOLOPHOSAURUS.get());
        this.food(FAItems.COOKED_THERIZINOSAURUS.get(), FAItems.RAW_THERIZINOSAURUS.get());
        this.food(FAItems.COOKED_PACHYCEPHALOSAURUS.get(), FAItems.RAW_PACHYCEPHALOSAURUS.get());
        this.food(FAItems.COOKED_COMPSOGNATHUS.get(), FAItems.RAW_COMPSOGNATHUS.get());
        this.food(FAItems.COOKED_DODO.get(), FAItems.RAW_DODO.get());
        this.food(FAItems.COOKED_MOA.get(), FAItems.RAW_MOA.get());
        this.food(FAItems.COOKED_GALLIMIMUS.get(), FAItems.RAW_GALLIMIMUS.get());
        this.food(FAItems.COOKED_SPINOSAURUS.get(), FAItems.RAW_SPINOSAURUS.get());
        this.food(FAItems.COOKED_ANKYLOSAURUS.get(), FAItems.RAW_ANKYLOSAURUS.get());
        this.food(FAItems.COOKED_DIMETRODON.get(), FAItems.RAW_DIMETRODON.get());
        this.food(FAItems.COOKED_ICHTHYOSAURUS.get(), FAItems.RAW_ICHTHYOSAURUS.get());
        this.food(FAItems.COOKED_ELASMOTHERIUM.get(), FAItems.RAW_ELASMOTHERIUM.get());
        this.food(FAItems.COOKED_DRYOSAURUS.get(), FAItems.RAW_DRYOSAURUS.get());
        this.food(FAItems.COOKED_BARYONYX.get(), FAItems.RAW_BARYONYX.get());

        this.scarabGemSmithing(Items.NETHERITE_SWORD, RecipeCategory.COMBAT, FAItems.SCARAB_GEM_SWORD.get());
        this.scarabGemSmithing(Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, FAItems.SCARAB_GEM_SHOVEL.get());
        this.scarabGemSmithing(Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, FAItems.SCARAB_GEM_PICKAXE.get());
        this.scarabGemSmithing(Items.NETHERITE_AXE, RecipeCategory.TOOLS, FAItems.SCARAB_GEM_AXE.get());
        this.scarabGemSmithing(Items.NETHERITE_HOE, RecipeCategory.TOOLS, FAItems.SCARAB_GEM_HOE.get());
        this.scarabGemSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, FAItems.SCARAB_GEM_HELMET.get());
        this.scarabGemSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, FAItems.SCARAB_GEM_CHESTPLATE.get());
        this.scarabGemSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, FAItems.SCARAB_GEM_LEGGINGS.get());
        this.scarabGemSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, FAItems.SCARAB_GEM_BOOTS.get());

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
        this.cultivate(CultivationBookCategory.EGG, FAItems.ELASMOTHERIUM_DNA.get(), FAItems.ELASMOTHERIUM_EMBRYO_SYRINGE.get(), 6000);
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
        this.cultivate(CultivationBookCategory.EGG, FAItems.ICHTHYOSAURUS_DNA.get(), FAItems.ICHTHYOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.DRYOSAURUS_DNA.get(), FAItems.DRYOSAURUS_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.EGG, FAItems.BARYONYX_DNA.get(), FAItems.BARYONYX_EGG.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.CYCAD_DNA.get(), FAItems.CYCAD_CONE.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.HORSETAIL_DNA.get(), FAItems.HORSETAIL_SPORE.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.JURASSIC_FERN_DNA.get(), FAItems.JURASSIC_FERN_SPORES.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.LEPIDODENDRON_DNA.get(), FAItems.LEPIDODENDRON_CONE.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.SIGILLARIA_DNA.get(), FAItems.SIGILLARIA_SPORE.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.CALAMITES_DNA.get(), FAItems.CALAMITES_SPORE.get(), 6000);
        this.cultivate(CultivationBookCategory.PLANT, FAItems.ARCHAEOPTERIS_DNA.get(), FAItems.ARCHAEOPTERIS_SPORE.get(), 6000);

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

        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.FOSSIL.get(), FAAnalyzerResultTags.FOSSIL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.ARCHAEOLOGY, FAItems.RELIC_SCRAP.get(), FAAnalyzerResultTags.RELIC_SCRAP_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.FROZEN_MEAT.get(), FAAnalyzerResultTags.FROZEN_MEAT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.AXOLOTL_BUCKET, FAAnalyzerResultTags.AXOLOTL_BUCKET_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.TROPICAL_FISH_BUCKET, FAAnalyzerResultTags.TROPICAL_FISH_BUCKET_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.PORKCHOP, FAAnalyzerResultTags.PORKCHOP_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.BEEF, FAAnalyzerResultTags.BEEF_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.CHICKEN, FAAnalyzerResultTags.CHICKEN_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.FEATHER, FAAnalyzerResultTags.FEATHER_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.BAMBOO, FAAnalyzerResultTags.BAMBOO_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.SLIME_BALL, FAAnalyzerResultTags.SLIME_BALL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.MUTTON, FAAnalyzerResultTags.MUTTON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.RABBIT, FAAnalyzerResultTags.RAW_RABBIT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.BONE, FAAnalyzerResultTags.BONE_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.EMERALD, FAAnalyzerResultTags.EMERALD_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.GOAT_HORN, FAAnalyzerResultTags.GOAT_HORN_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItemTags.FROGLIGHTS, "froglights_outputs", FAAnalyzerResultTags.FROGLIGHT_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.LEATHER, FAAnalyzerResultTags.LEATHER_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.STRING, FAAnalyzerResultTags.STRING_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.COD, FAAnalyzerResultTags.COD_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.SALMON, FAAnalyzerResultTags.SALMON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, ItemTags.WOOL, "wool_outputs", FAAnalyzerResultTags.WOOL_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, Items.ARMADILLO_SCUTE, FAAnalyzerResultTags.ARMADILLO_SCUTE_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_BRACHIOSAURUS.get(), FAAnalyzerResultTags.RAW_BRACHIOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_DILOPHOSAURUS.get(), FAAnalyzerResultTags.RAW_DILOPHOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_MAMMOTH.get(), FAAnalyzerResultTags.RAW_MAMMOTH_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_MOSASAURUS.get(), FAAnalyzerResultTags.RAW_MOSASAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_FUTABASAURUS.get(), FAAnalyzerResultTags.RAW_FUTABASAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_PTERANODON.get(), FAAnalyzerResultTags.RAW_PTERANODON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_SMILODON.get(), FAAnalyzerResultTags.RAW_SMILODON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_STEGOSAURUS.get(), FAAnalyzerResultTags.RAW_STEGOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_TRICERATOPS.get(), FAAnalyzerResultTags.RAW_TRICERATOPS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_TYRANNOSAURUS.get(), FAAnalyzerResultTags.RAW_TYRANNOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_VELOCIRAPTOR.get(), FAAnalyzerResultTags.RAW_VELOCIRAPTOR_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_CARNOTAURUS.get(), FAAnalyzerResultTags.RAW_CARNOTAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_CRYOLOPHOSAURUS.get(), FAAnalyzerResultTags.RAW_CRYOLOPHOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_THERIZINOSAURUS.get(), FAAnalyzerResultTags.RAW_THERIZINOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_PACHYCEPHALOSAURUS.get(), FAAnalyzerResultTags.RAW_PACHYCEPHALOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_COMPSOGNATHUS.get(), FAAnalyzerResultTags.RAW_COMPSOGNATHUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_DODO.get(), FAAnalyzerResultTags.RAW_DODO_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_MOA.get(), FAAnalyzerResultTags.RAW_MOA_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_GALLIMIMUS.get(), FAAnalyzerResultTags.RAW_GALLIMIMUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_SPINOSAURUS.get(), FAAnalyzerResultTags.RAW_SPINOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_ANKYLOSAURUS.get(), FAAnalyzerResultTags.RAW_ANKYLOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_DIMETRODON.get(), FAAnalyzerResultTags.RAW_DIMETRODON_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_ICHTHYOSAURUS.get(), FAAnalyzerResultTags.RAW_ICTHYOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_ELASMOTHERIUM.get(), FAAnalyzerResultTags.RAW_ELASMOTHERIUM_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_DRYOSAURUS.get(), FAAnalyzerResultTags.RAW_DRYOSAURUS_RESULTS, 100);
        this.analyzation(AnalyzationBookCategory.PALAEONTOLOGY, FAItems.RAW_BARYONYX.get(), FAAnalyzerResultTags.RAW_BARYONYX_RESULTS, 100);
    }

    public void woodType(Block log, Block strippedLog, Block wood, Block strippedWood, TagKey<Item> logs, Block planks, Block stairs, Block slab, Block fence, Block fenceGate, Block door, Block trapdoor, Block pressurePlate, Block button, Item sign, Item hangingSign, Item boat, Item chestBoat) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, wood, 3).group("bark").pattern("##").pattern("##").define('#', log).unlockedBy(getHasName(log), has(log)).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, strippedWood, 3).group("bark").pattern("##").pattern("##").define('#', strippedLog).unlockedBy(getHasName(strippedLog), has(strippedLog)).save(this.output);
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4).group("planks").requires(logs).unlockedBy("has_log", has(logs)).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4).group("wooden_stairs").pattern("#  ").pattern("## ").pattern("###").define('#', planks).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 6).group("wooden_slab").pattern("###").define('#', planks).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.DECORATIONS, fence, 3).group("wooden_fence").pattern("#$#").pattern("#$#").define('#', planks).define('$', Items.STICK).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.REDSTONE, fenceGate).group("wooden_fence_gate").pattern("$#$").pattern("$#$").define('#', planks).define('$', Items.STICK).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.REDSTONE, door, 3).group("wooden_door").pattern("##").pattern("##").pattern("##").define('#', planks).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.REDSTONE, trapdoor, 2).group("wooden_trapdoor").pattern("###").pattern("###").define('#', planks).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.REDSTONE, pressurePlate).group("wooden_pressure_plate").pattern("##").define('#', planks).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shapeless(RecipeCategory.REDSTONE, button).group("wooden_button").requires(planks).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.REDSTONE, sign, 3).group("sign").pattern("###").pattern("###").pattern(" $ ").define('#', planks).define('$', Items.STICK).unlockedBy(getHasName(planks), has(planks)).save(this.output);
        this.shaped(RecipeCategory.REDSTONE, hangingSign, 6).group("hanging_sign").pattern("$ $").pattern("###").pattern("###").define('#', strippedLog).define('$', Blocks.CHAIN).unlockedBy(getHasName(strippedLog), has(strippedLog)).save(this.output);
        this.shaped(RecipeCategory.TRANSPORTATION, boat).group("boat").pattern("# #").pattern("###").define('#', planks).unlockedBy("in_water", insideOf(Blocks.WATER)).save(this.output);
        this.shapeless(RecipeCategory.TRANSPORTATION, chestBoat).group("chest_boat").requires(boat).requires(Items.CHEST).unlockedBy("has_boat", has(ItemTags.BOATS)).save(this.output);
    }

    protected void food(Item cooked, Item raw) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(raw), RecipeCategory.FOOD, cooked, 0.35F, 200).unlockedBy(getHasName(raw), has(raw)).save(this.output);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(raw), RecipeCategory.FOOD, cooked, 0.35F, 100).unlockedBy(getHasName(raw), has(raw)).save(this.output, FAUtils.ID + ":" + getItemName(cooked) + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(raw), RecipeCategory.FOOD, cooked, 0.35F, 600).unlockedBy(getHasName(raw), has(raw)).save(this.output, FAUtils.ID + ":" + getItemName(cooked) + "_from_campfire_cooking");
    }

    protected void scarabGemSmithing(Item ingredientItem, RecipeCategory category, Item resultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(ingredientItem), this.tag(FAItemTags.SCARAB_GEM_TOOL_MATERIALS), category, resultItem).unlocks("has_scarab_gem", this.has(FAItemTags.SCARAB_GEM_TOOL_MATERIALS)).save(this.output, getItemName(resultItem) + "_smithing");
    }

    public void decorationPlaque(ItemLike concrete, ItemLike output) {
        this.shaped(RecipeCategory.DECORATIONS, output).group("decoration_plaque").pattern("###").pattern("###").pattern(" $ ").define('#', concrete).define('$', Items.IRON_INGOT).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(this.output);
    }

    public void hammer(TagKey<Item> material, ItemLike output) {
        this.shaped(RecipeCategory.DECORATIONS, output).pattern("###").pattern("###").pattern(" $ ").define('#', material).define('$', Items.STICK).unlockedBy("has_" + material.location().getPath(), this.has(material)).save(this.output);
    }

    public void hammer(ItemLike material, ItemLike output) {
        this.shaped(RecipeCategory.DECORATIONS, output).pattern("###").pattern("###").pattern(" $ ").define('#', material).define('$', Items.STICK).unlockedBy(RecipeProvider.getHasName(material), this.has(material)).save(this.output);
    }

    public void llama(ItemLike ingredient, ItemLike output) {
        this.shaped(RecipeCategory.DECORATIONS, output).group("llama").pattern("#  ").pattern("###").pattern("# #").define('#', ingredient).unlockedBy(getHasName(ingredient), has(ingredient)).save(this.output);
    }

    public void waxCopper(ItemLike nonWaxed, ItemLike waxed) {
        this.shapeless(RecipeCategory.DECORATIONS, waxed).group("waxed_llama").requires(nonWaxed).requires(Items.HONEYCOMB).unlockedBy(getHasName(nonWaxed), has(nonWaxed)).save(this.output);
    }

    public void cultivator(ItemLike output, ItemLike dye, ItemLike glass) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, output).group("cultivators").pattern("#$#").pattern("#%#").pattern("@@@").define('#', Blocks.GLASS).define('$', dye).define('%', Items.WATER_BUCKET).define('@', Items.IRON_INGOT).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).save(this.output);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, output).group("cultivators").pattern("# #").pattern("#%#").pattern("@@@").define('#', glass).define('%', Items.WATER_BUCKET).define('@', Items.IRON_INGOT).unlockedBy(getHasName(Items.WATER_BUCKET), has(Items.WATER_BUCKET)).save(this.output, FAUtils.ID + ":" + getItemName(output) + "_from_dyed_glass");
    }

    public void craftingTable(ItemLike output, ItemLike modifier) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, output).pattern("$$").pattern("##").pattern("##").define('#', this.tag(ItemTags.PLANKS)).define('$', modifier).unlockedBy(getHasName(modifier), has(modifier)).save(this.output);
    }

    public void cultivate(CultivationBookCategory cultivationBookCategory, Item ingredient, ItemLike itemLike, int time) {
        CultivationRecipeBuilder.recipe(cultivationBookCategory, null, ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient)).save(this.output);
    }

    public void archaeology(ArchaeologyBookCategory archaeologyBookCategory, String name, Item ingredient, ItemLike itemLike, int time) {
        ArchaeologyRecipeBuilder.recipe(archaeologyBookCategory, ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient)).save(this.output, FAUtils.ID + ":" + name);
    }

    public void archaeology(ArchaeologyBookCategory archaeologyBookCategory, Item ingredient, ItemLike itemLike, int time) {
        ArchaeologyRecipeBuilder.recipe(archaeologyBookCategory, ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient)).save(this.output);
    }

    public void analyzation(AnalyzationBookCategory analyzationBookCategory, ItemLike ingredient, TagKey<AnalyzerResult> results, int time) {
        AnalyzationRecipeBuilder.recipe(analyzationBookCategory, Ingredient.of(ingredient), results, time).unlockedBy(getHasName(ingredient), has(ingredient)).save(this.output, ResourceKey.create(Registries.RECIPE, FAUtils.resource(getItemName(ingredient) + "_outputs")));
    }

    public void analyzation(AnalyzationBookCategory analyzationBookCategory, TagKey<Item> itemTagKey, String name, TagKey<AnalyzerResult> results, int time) {
        AnalyzationRecipeBuilder.recipe(analyzationBookCategory, this.tag(itemTagKey), results, time).unlockedBy("has_" + itemTagKey.location().getPath(), has(itemTagKey)).save(this.output, ResourceKey.create(Registries.RECIPE, FAUtils.resource(name)));
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new FARecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "F/A Recipes";
        }
    }
}
