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
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.recipe.MagicConchRecipe;
import willatendo.simplelibrary.data.SimpleRecipeProvider;

import java.util.ArrayList;
import java.util.List;
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
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), IngredientBuilder.build(FossilsLegacyBlocks.SKULL_BLOCK.get()).requires(), IngredientBuilder.build(Items.TORCH));
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
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.GENE_MODIFIER.get(), PatternBuilder.builder("#$#", "#&#", "#!#"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#').requires(), IngredientBuilder.build(Blocks.REDSTONE_BLOCK).symbol('$'), IngredientBuilder.build(Items.NETHER_STAR).symbol('&'), IngredientBuilder.build(Items.GOLD_INGOT).symbol('!'));
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), IngredientBuilder.build(Items.PAPER), IngredientBuilder.build(Blocks.CRAFTING_TABLE).requires());
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
        this.shaped(RecipeCategory.TRANSPORTATION, "boat", FossilsLegacyItems.LEPIDODENDRON_BOAT.get(), PatternBuilder.builder("# #", "###"), IngredientBuilder.build(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get()).symbol('#'));
        this.chestBoat(RecipeCategory.TRANSPORTATION, "chest_boat", FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT.get(), IngredientBuilder.build(FossilsLegacyItems.LEPIDODENDRON_BOAT.get()), IngredientBuilder.build(Items.CHEST));

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
        this.cultivate(CultivationBookCategory.PLANT, FossilsLegacyItems.PETRIFIED_LEPIDODENDRON_SAPLING.get(), FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), 6000);

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

        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.FOSSIL.get(), Items.BONE_MEAL, 60, 100, new AnalyzerResult(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 20), new AnalyzerResult(FossilsLegacyItems.PETRIFIED_LEPIDODENDRON_SAPLING.get(), 20), new AnalyzerResult(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.MOSASAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.NAUTILUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.FUTABASAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.PTERANODON_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.STEGOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.TRICERATOPS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.CARNOTAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.COMPSOGNATHUS_DNA.get(), 2));
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.RELIC_SCRAP.get(), Blocks.GRAVEL, 40, 100, new AnalyzerResult(FossilsLegacyItems.STONE_TABLET.get(), 30), new AnalyzerResult(Items.FLINT, 20), new AnalyzerResult(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_PICKAXE_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_AXE_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_HOE_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.PREHISTORIC_COIN.get(), 1));
        this.analyzation(AnalyzationBookCategory.MISC, FossilsLegacyItems.FROZEN_MEAT.get(), FossilsLegacyItems.SMILODON_DNA.get(), 33, 100, new AnalyzerResult(FossilsLegacyItems.MAMMOTH_DNA.get(), 33), new AnalyzerResult(FossilsLegacyItems.DODO_DNA.get(), 33), new AnalyzerResult(Items.BEEF, 34));
        this.simpleAnalyzation(Items.AXOLOTL_BUCKET, FossilsLegacyItems.AXOLOTL_DNA.get());
        this.simpleAnalyzation(Items.TROPICAL_FISH_BUCKET, FossilsLegacyItems.AXOLOTL_DNA.get());
        this.simpleAnalyzation(Items.PORKCHOP, FossilsLegacyItems.PIG_DNA.get());
        this.simpleAnalyzation(Items.BEEF, FossilsLegacyItems.COW_DNA.get());
        this.simpleAnalyzation(Items.CHICKEN, FossilsLegacyItems.CHICKEN_DNA.get());
        this.simpleAnalyzation(Items.FEATHER, FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.PARROT_DNA.get());
        this.simpleAnalyzation(Items.BAMBOO, FossilsLegacyItems.PANDA_DNA.get());
        this.simpleAnalyzation(Items.SLIME_BALL, FossilsLegacyItems.PANDA_DNA.get());
        this.simpleAnalyzation(Items.MUTTON, FossilsLegacyItems.SHEEP_DNA.get());
        this.simpleAnalyzation(Items.RABBIT, FossilsLegacyItems.RABBIT_DNA.get());
        this.simpleAnalyzation(Items.BONE, FossilsLegacyItems.WOLF_DNA.get());
        this.simpleAnalyzation(Items.EMERALD, FossilsLegacyItems.FOX_DNA.get());
        this.simpleAnalyzation(Items.GOAT_HORN, FossilsLegacyItems.GOAT_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItemTags.FROGLIGHTS, "froglights_outputs", FossilsLegacyItems.FROG_DNA.get());
        this.simpleAnalyzation(Items.LEATHER, FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.MULE_DNA.get());
        this.simpleAnalyzation(Items.STRING, FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.FOX_DNA.get());
        this.simpleAnalyzation(Items.COD, FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get());
        this.simpleAnalyzation(Items.SALMON, FossilsLegacyItems.POLAR_BEAR_DNA.get());
        this.simpleAnalyzation(ItemTags.WOOL, "wool_outputs", FossilsLegacyItems.SHEEP_DNA.get());
        this.simpleAnalyzation(Items.ARMADILLO_SCUTE, FossilsLegacyItems.ARMADILLO_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_MAMMOTH.get(), FossilsLegacyItems.MAMMOTH_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_MOSASAURUS.get(), FossilsLegacyItems.MOSASAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_FUTABASAURUS.get(), FossilsLegacyItems.FUTABASAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_PTERANODON.get(), FossilsLegacyItems.PTERANODON_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_SMILODON.get(), FossilsLegacyItems.SMILODON_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_STEGOSAURUS.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_TRICERATOPS.get(), FossilsLegacyItems.TRICERATOPS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), FossilsLegacyItems.VELOCIRAPTOR_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_CARNOTAURUS.get(), FossilsLegacyItems.CARNOTAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_THERIZINOSAURUS.get(), FossilsLegacyItems.THERIZINOSAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS.get(), FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get());
        this.simpleAnalyzation(FossilsLegacyItems.RAW_COMPSOGNATHUS.get(), FossilsLegacyItems.COMPSOGNATHUS_DNA.get());
    }

    public void boat(RecipeCategory recipeCategory, String group, ItemLike output, PatternBuilder patternBuilder, IngredientBuilder... ingredientBuilders) {
        ShapedRecipeBuilder shapedRecipeBuilder = shapedRecipeBuilder = ShapedRecipeBuilder.shaped(recipeCategory, output);

        if (group != null) {
            shapedRecipeBuilder.group(group);
        }

        String[] patterns = patternBuilder.getPattern();

        for (int i = 0; i < patterns.length; ++i) {
            shapedRecipeBuilder.pattern(patterns[i]);
        }

        for (int i = 0; i < ingredientBuilders.length; ++i) {
            IngredientBuilder ingredientBuilder = ingredientBuilders[i];
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

    public void cultivator(ItemLike output, ItemLike dye, ItemLike glass) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "cultivators", output, PatternBuilder.builder("#$#", "#%#", "@@@"), IngredientBuilder.build(Blocks.GLASS).symbol('#').requires(), IngredientBuilder.build(dye).symbol('$'), IngredientBuilder.build(Items.WATER_BUCKET).symbol('%'), IngredientBuilder.build(Items.IRON_INGOT).symbol('@'));
        this.shaped(this.toName(output) + "_from_colored_glass", RecipeCategory.BUILDING_BLOCKS, "cultivators", output, PatternBuilder.builder("# #", "#%#", "@@@"), IngredientBuilder.build(glass).symbol('#').requires(), IngredientBuilder.build(Items.WATER_BUCKET).symbol('%'), IngredientBuilder.build(Items.IRON_INGOT).symbol('@'));
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

    public void analyzation(AnalyzationBookCategory analyzationBookCategory, ItemLike ingredient, ItemLike result, int weight, int time, AnalyzerResult... analyzerResults) {
        AnalyzationRecipeBuilder analyzationRecipeBuilder = AnalyzationRecipeBuilder.recipe(analyzationBookCategory, ingredient, result, weight, time).unlockedBy(getHasName(ingredient), has(ingredient));
        for (AnalyzerResult analyzerResult : analyzerResults) {
            analyzationRecipeBuilder.addResult(analyzerResult.result(), analyzerResult.weight());
        }
        this.recipeBuilders.put(this.toName(ingredient) + "_outputs", analyzationRecipeBuilder);
    }

    public void analyzation(AnalyzationBookCategory analyzationBookCategory, TagKey<Item> itemTagKey, String name, ItemLike result, int weight, int time, AnalyzerResult... analyzerResults) {
        AnalyzationRecipeBuilder analyzationRecipeBuilder = AnalyzationRecipeBuilder.recipe(analyzationBookCategory, itemTagKey, result, weight, time).unlockedBy("has_" + itemTagKey.location().getPath(), has(itemTagKey));
        for (AnalyzerResult analyzerResult : analyzerResults) {
            analyzationRecipeBuilder.addResult(analyzerResult.result(), analyzerResult.weight());
        }
        this.recipeBuilders.put(name, analyzationRecipeBuilder);
    }

    public void simpleAnalyzation(ItemLike input, Item dna) {
        this.analyzation(AnalyzationBookCategory.MISC, input, dna, 100, 100);
    }

    public void simpleAnalyzation(TagKey<Item> input, String name, Item... dnas) {
        List<AnalyzerResult> analyzerResults = new ArrayList<>();
        for (Item dna : dnas) {
            analyzerResults.add(new AnalyzerResult(dna, 100 / dnas.length));
        }
        this.analyzation(AnalyzationBookCategory.MISC, input, name, dnas[0], 100 / dnas.length, 100, analyzerResults.toArray(AnalyzerResult[]::new));
    }

    public void simpleAnalyzation(ItemLike input, Item... dnas) {
        List<AnalyzerResult> analyzerResults = new ArrayList<>();
        for (Item dna : dnas) {
            analyzerResults.add(new AnalyzerResult(dna, 100 / dnas.length));
        }
        this.analyzation(AnalyzationBookCategory.MISC, input, dnas[0], 100 / dnas.length, 100, analyzerResults.toArray(AnalyzerResult[]::new));
    }

    private static final record AnalyzerResult(Item result, int weight) {
    }
}
