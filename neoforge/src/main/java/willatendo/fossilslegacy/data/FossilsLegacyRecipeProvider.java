package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.data.recipe.AnalyzationRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.ArchaeologyRecipeBuilder;
import willatendo.fossilslegacy.data.recipe.CultivationRecipeBuilder;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
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
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), IngredientBuilder.build(Items.PAPER), IngredientBuilder.build(Blocks.CRAFTING_TABLE).requires());
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.DRUM.get(), PatternBuilder.builder("###", "$%$", "$$$"), IngredientBuilder.build(Items.LEATHER).symbol('#').requires(), IngredientBuilder.build(ItemTags.PLANKS).symbol('$'), IngredientBuilder.build(Items.REDSTONE).symbol('%'));
        this.shaped(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyBlocks.FEEDER.get(), PatternBuilder.builder("#$#", "%@!", "!!!"), IngredientBuilder.build(Items.IRON_INGOT).symbol('#'), IngredientBuilder.build(Blocks.GLASS).symbol('$'), IngredientBuilder.build(Blocks.STONE_BUTTON).symbol('%'), IngredientBuilder.build(Items.BUCKET).symbol('@'), IngredientBuilder.build(Blocks.STONE).symbol('!').requires());
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), IngredientBuilder.build(Items.CHICKEN), IngredientBuilder.build(Items.BUCKET).requires());
        this.shapeless("skull_bonemeal", RecipeCategory.MISC, Items.BONE_MEAL, 5, IngredientBuilder.build(FossilsLegacyBlocks.SKULL_BLOCK.get()));
        this.shapeless(RecipeCategory.MISC, FossilsLegacyItems.OVERWORLD_COIN.get(), IngredientBuilder.build(FossilsLegacyItems.PREHISTORIC_COIN.get()).requires());
        this.shapeless(RecipeCategory.MISC, FossilsLegacyItems.PREHISTORIC_COIN.get(), IngredientBuilder.build(FossilsLegacyItems.OVERWORLD_COIN.get()).requires());
        this.food(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get(), FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_PTERANODON_MEAT.get(), FossilsLegacyItems.COOKED_PTERANODON_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get(), FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_SMILODON_MEAT.get(), FossilsLegacyItems.COOKED_SMILODON_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_CARNOTAURUS_MEAT.get(), FossilsLegacyItems.COOKED_CARNOTAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_THERIZINOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_THERIZINOSAURUS_MEAT.get(), 0.35F);
        this.food(FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_PACHYCEPHALOSAURUS_MEAT.get(), 0.35F);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_SWORD.get(), RecipeCategory.COMBAT);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), RecipeCategory.TOOLS);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), RecipeCategory.TOOLS);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_AXE.get(), RecipeCategory.TOOLS);
        this.smithing(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, FossilsLegacyItems.SCARAB_GEM.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), RecipeCategory.TOOLS);
        this.cultivate(FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TRICERATOPS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.PTERANODON_DNA.get(), FossilsLegacyItems.PTERANODON_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.NAUTILUS_EGGS.get(), 6000);
        this.cultivate(FossilsLegacyItems.FUTABASAURUS_DNA.get(), FossilsLegacyItems.FUTABASAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyBlocks.AXOLOTLSPAWN.get(), 6000);
        this.cultivate(FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.COW_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.FROG_DNA.get(), Blocks.FROGSPAWN, 6000);
        this.cultivate(FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.WOLF_DNA.get(), FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get(), 6000);
        this.cultivate(FossilsLegacyItems.CARNOTAURUS_DNA.get(), FossilsLegacyItems.CARNOTAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), FossilsLegacyItems.THERIZINOSAURUS_EGG.get(), 6000);
        this.cultivate(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get(), FossilsLegacyItems.PACHYCEPHALOSAURUS_EGG.get(), 6000);
        this.archaeology(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_HELMET.get(), 3000);
        this.archaeology(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), 3000);
        this.archaeology(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_LEGGINGS.get(), 3000);
        this.archaeology(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_BOOTS.get(), 3000);
        this.archaeology(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), FossilsLegacyItems.ANCIENT_SWORD.get(), 3000);
        this.archaeology("scarab_axe_repair", FossilsLegacyItems.SCARAB_GEM_AXE.get(), FossilsLegacyItems.SCARAB_GEM_AXE.get(), 3000);
        this.archaeology("scarab_hoe_repair", FossilsLegacyItems.SCARAB_GEM_HOE.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), 3000);
        this.archaeology("scarab_pickaxe_repair", FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), 3000);
        this.archaeology("scarab_shovel_repair", FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), 3000);
        this.archaeology("scarab_sword_repair", FossilsLegacyItems.SCARAB_GEM_SWORD.get(), FossilsLegacyItems.SCARAB_GEM_SWORD.get(), 3000);
        this.archaeology("diamond_javelin_repair", FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyItems.DIAMOND_JAVELIN.get(), 3000);
        this.archaeology("golden_javelin_repair", FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyItems.GOLDEN_JAVELIN.get(), 3000);
        this.archaeology("iron_javelin_repair", FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyItems.IRON_JAVELIN.get(), 3000);
        this.archaeology("netherite_javelin_repair", FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyItems.NETHERITE_JAVELIN.get(), 3000);
        this.archaeology("scarab_gem_javelin_repair", FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get(), FossilsLegacyItems.SCARAB_GEM_JAVELIN.get(), 3000);
        this.archaeology("stone_javelin_repair", FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyItems.STONE_JAVELIN.get(), 3000);
        this.archaeology("wooden_javelin_repair", FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyItems.WOODEN_JAVELIN.get(), 3000);
        this.special("magic_conch", MagicConchRecipe::new);
        this.copySmithingTemplate(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), Blocks.STONE_BRICKS);

        this.analyzation(FossilsLegacyItems.FOSSIL.get(), Items.BONE_MEAL, 60, 100, new AnalyzerResult(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), 20), new AnalyzerResult(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.MOSASAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.NAUTILUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.FUTABASAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.PTERANODON_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.STEGOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.TRICERATOPS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.CARNOTAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), 2), new AnalyzerResult(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get(), 2));
        this.analyzation(FossilsLegacyItems.RELIC_SCRAP.get(), Blocks.GRAVEL, 40, 100, new AnalyzerResult(FossilsLegacyItems.STONE_TABLET.get(), 30), new AnalyzerResult(Items.FLINT, 20), new AnalyzerResult(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get(), 5), new AnalyzerResult(FossilsLegacyItems.PREHISTORIC_COIN.get(), 1));
        this.analyzation(FossilsLegacyItems.FROZEN_MEAT.get(), FossilsLegacyItems.SMILODON_DNA.get(), 33, 100, new AnalyzerResult(FossilsLegacyItems.MAMMOTH_DNA.get(), 33), new AnalyzerResult(Items.BEEF, 34));
        simpleAnalyzation(Items.PORKCHOP, FossilsLegacyItems.PIG_DNA.get());
        simpleAnalyzation(Items.BEEF, FossilsLegacyItems.COW_DNA.get());
        simpleAnalyzation(Items.CHICKEN, FossilsLegacyItems.CHICKEN_DNA.get());
        simpleAnalyzation(Items.FEATHER, FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.PARROT_DNA.get());
        simpleAnalyzation(Items.BAMBOO, FossilsLegacyItems.PANDA_DNA.get());
        simpleAnalyzation(Items.SLIME_BALL, FossilsLegacyItems.PANDA_DNA.get());
        simpleAnalyzation(Items.MUTTON, FossilsLegacyItems.SHEEP_DNA.get());
        simpleAnalyzation(Items.RABBIT, FossilsLegacyItems.RABBIT_DNA.get());
        simpleAnalyzation(Items.BONE, FossilsLegacyItems.WOLF_DNA.get());
        simpleAnalyzation(Items.EMERALD, FossilsLegacyItems.FOX_DNA.get());
        simpleAnalyzation(Items.GOAT_HORN, FossilsLegacyItems.GOAT_DNA.get());
        simpleAnalyzation(FossilsLegacyItemTags.FROGLIGHTS, FossilsLegacyItems.FROG_DNA.get());
        simpleAnalyzation(Items.LEATHER, FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.MULE_DNA.get());
        simpleAnalyzation(Items.STRING, FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.FOX_DNA.get());
        simpleAnalyzation(Items.COD, FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get());
        simpleAnalyzation(Items.SALMON, FossilsLegacyItems.POLAR_BEAR_DNA.get());
        simpleAnalyzation(ItemTags.WOOL, FossilsLegacyItems.SHEEP_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), FossilsLegacyItems.MAMMOTH_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), FossilsLegacyItems.MOSASAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get(), FossilsLegacyItems.FUTABASAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_PTERANODON_MEAT.get(), FossilsLegacyItems.PTERANODON_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_SMILODON_MEAT.get(), FossilsLegacyItems.SMILODON_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), FossilsLegacyItems.TRICERATOPS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get(), FossilsLegacyItems.VELOCIRAPTOR_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_CARNOTAURUS_MEAT.get(), FossilsLegacyItems.CARNOTAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS_MEAT.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_THERIZINOSAURUS_MEAT.get(), FossilsLegacyItems.THERIZINOSAURUS_DNA.get());
        simpleAnalyzation(FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS_MEAT.get(), FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get());
    }

    public void cultivator(ItemLike output, ItemLike dye, ItemLike glass) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, "cultivators", output, PatternBuilder.builder("#$#", "#%#", "@@@"), IngredientBuilder.build(Blocks.GLASS).symbol('#').requires(), IngredientBuilder.build(dye).symbol('$'), IngredientBuilder.build(Items.WATER_BUCKET).symbol('%'), IngredientBuilder.build(Items.IRON_INGOT).symbol('@'));
        this.shaped(this.toName(output) + "_from_colored_glass", RecipeCategory.BUILDING_BLOCKS, "cultivators", output, PatternBuilder.builder("# #", "#%#", "@@@"), IngredientBuilder.build(Blocks.GLASS).symbol('#').requires(), IngredientBuilder.build(Items.WATER_BUCKET).symbol('%'), IngredientBuilder.build(Items.IRON_INGOT).symbol('@'));
    }

    public void cultivate(Item ingredient, ItemLike itemLike, int time) {
        CultivationRecipeBuilder cultivationRecipeBuilder = CultivationRecipeBuilder.recipe(ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient));
        this.recipeBuilders.put(this.toName(itemLike), cultivationRecipeBuilder);
    }

    public void archaeology(String name, Item ingredient, ItemLike itemLike, int time) {
        ArchaeologyRecipeBuilder archaeologyRecipeBuilder = ArchaeologyRecipeBuilder.recipe(ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient));
        this.recipeBuilders.put(name, archaeologyRecipeBuilder);
    }

    public void archaeology(Item ingredient, ItemLike itemLike, int time) {
        ArchaeologyRecipeBuilder archaeologyRecipeBuilder = ArchaeologyRecipeBuilder.recipe(ingredient, itemLike, time).unlockedBy(getHasName(ingredient), has(ingredient));
        this.recipeBuilders.put(this.toName(itemLike), archaeologyRecipeBuilder);
    }

    public void analyzation(ItemLike ingredient, ItemLike result, int weight, int time, AnalyzerResult... analyzerResults) {
        AnalyzationRecipeBuilder analyzationRecipeBuilder = AnalyzationRecipeBuilder.recipe(ingredient, result, weight, time).unlockedBy(getHasName(ingredient) + "_outputs", has(ingredient));
        for (AnalyzerResult analyzerResult : analyzerResults) {
            analyzationRecipeBuilder.addResult(analyzerResult.result(), analyzerResult.weight());
        }
        this.recipeBuilders.put(this.toName(ingredient), analyzationRecipeBuilder);
    }

    public void analyzation(TagKey<Item> itemTagKey, String requires, ItemLike result, int weight, int time, AnalyzerResult... analyzerResults) {
        AnalyzationRecipeBuilder analyzationRecipeBuilder = AnalyzationRecipeBuilder.recipe(itemTagKey, result, weight, time).unlockedBy(requires + "_outputs", has(itemTagKey));
        for (AnalyzerResult analyzerResult : analyzerResults) {
            analyzationRecipeBuilder.addResult(analyzerResult.result(), analyzerResult.weight());
        }
        this.recipeBuilders.put(requires, analyzationRecipeBuilder);
    }

    public void simpleAnalyzation(ItemLike input, Item dna) {
        this.analyzation(input, dna, 100, 100);
    }

    public void simpleAnalyzation(TagKey<Item> input, Item dna) {
        AnalyzationRecipeBuilder.recipe(input, dna, 100, 100);
    }

    public void simpleAnalyzation(TagKey<Item> input, String requires, Item... dnas) {
        AnalyzerResult[] analyzerResults = new AnalyzerResult[dnas.length];
        for (int i = 1; i < dnas.length; i++) {
            analyzerResults[i] = new AnalyzerResult(dnas[i], 100 / dnas.length);
        }
    }

    public void simpleAnalyzation(ItemLike input, Item... dnas) {
        List<AnalyzerResult> analyzerResults = new ArrayList<>();
        for (Item dna : dnas) {
            analyzerResults.add(new AnalyzerResult(dna, 100 / dnas.length));
        }
        this.analyzation(input, dnas[0], 100 / dnas.length, 100, analyzerResults.toArray(AnalyzerResult[]::new));
    }

    private String toName(ItemLike itemLike) {
        return BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath();
    }

    private static final record AnalyzerResult(Item result, int weight) {
    }
}
