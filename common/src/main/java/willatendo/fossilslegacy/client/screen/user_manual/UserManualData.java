package willatendo.fossilslegacy.client.screen.user_manual;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FAUtils;

import java.util.*;

public final class UserManualData {
    private static final ResourceLocation SHAPELESS = FAUtils.resource("container/user_manual/shapeless");
    private static final Map<Item, ItemPage> ITEM_INFORMATION = new HashMap<>();
    private static final Map<RecipeType<?>, RecipeTypePage> RECIPE_TYPE_INFORMATION = new HashMap<>();

    public static ItemPage getItemInformation(ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (!ITEM_INFORMATION.containsKey(item)) {
            return ItemPage.EMPTY;
        }
        return ITEM_INFORMATION.get(item);
    }

    public static RecipeTypePage getRecipeTypeInformation(RecipeType<?> recipeType) {
        if (!RECIPE_TYPE_INFORMATION.containsKey(recipeType)) {
            return RecipeTypePage.EMPTY;
        }
        return RECIPE_TYPE_INFORMATION.get(recipeType);
    }

    public static void init() {
        UserManualData.add(FAItems.RELIC_SCRAP.get(), List.of(FAUtils.resource("analyzer")), List.of(), Component.literal("Relics from the past. From suspicious sand and gravel patches."), Component.literal("Can be used in some recipes and can give other archaeological items."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.SCARAB_GEM.get(), List.of(FAUtils.resource("scarab_gem_sword_smithing"), FAUtils.resource("scarab_gem_shovel_smithing"), FAUtils.resource("scarab_gem_pickaxe_smithing"), FAUtils.resource("scarab_gem_axe_smithing"), FAUtils.resource("scarab_gem_hoe_smithing"), FAUtils.resource("scarab_gem_helmet_smithing"), FAUtils.resource("scarab_gem_chestplate_smithing"), FAUtils.resource("scarab_gem_leggings_smithing"), FAUtils.resource("scarab_gem_boots_smithing")), List.of(), Component.literal("A relics from the past. From suspicious sand and gravel patches."), Component.literal("Can be used in some recipes and can be used to tame a knocked out tyrannosaurus."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.JADE.get(), List.of(FAUtils.resource("mayan_jade_vase")), List.of(), Component.literal("A Mayan relic from the past, found in Mayan structures."), Component.literal("Can be used in some recipes and is decorative."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.JADE_OCELOT.get(), List.of(FAUtils.resource("mayan_ocelot_vase")), List.of(), Component.literal("A Mayan relic from the past, found in Mayan structures."), Component.literal("Can be used in some recipes and is decorative."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.JADE_VILLAGER.get(), List.of(FAUtils.resource("mayan_villager_vase")), List.of(), Component.literal("A Mayan relic from the past, found in Mayan structures."), Component.literal("Can be used in some recipes and is decorative."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.CODEX.get(), List.of(), List.of(), Component.literal("A Mayan relic from the past, found in Mayan structures."), Component.literal("Is decorative."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.QUIPU.get(), List.of(), List.of(), Component.literal("An Incan relic from the past, found in Incan structures."), Component.literal("Is decorative."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.CENOZOIC_FOSSIL.get(), List.of(FAUtils.resource("analyzer"), FAUtils.resource("palaeontology_table")), List.of(), Component.literal("Fossils from the Cenozoic. From cenozoic fossil ore, which can be found from y128-y50."), Component.literal("Can be used in some recipes and can give DNA from the Cenozoic."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.MESOZOIC_FOSSIL.get(), List.of(FAUtils.resource("analyzer"), FAUtils.resource("palaeontology_table")), List.of(), Component.literal("Fossils from the Mesozoic. From mesozoic fossil ore, which can be found from y50-y20."), Component.literal("Can be used in some recipes and can give DNA from the Mesozoic."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.PALAEOZOIC_FOSSIL.get(), List.of(FAUtils.resource("analyzer"), FAUtils.resource("palaeontology_table")), List.of(), Component.literal("Fossils from the Palaeozoic. From palaeozoic fossil ore, which can be found from y20-y0."), Component.literal("Can be used in some recipes and can give DNA from the Palaeozoic."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.PLANT_FOSSIL.get(), List.of(), List.of(), Component.literal("Plant fossils, found from plant fossil ore."), Component.literal("Can give plant DNA from many eras."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.AMBER.get(), List.of(), List.of(), Component.literal("Fossilized tree sap from amber ore."), Component.literal("Decorative gem."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.MOSQUITO_IN_AMBER.get(), List.of(), List.of(), Component.literal("Mosquito in fossilized tree sap from amber ore."), Component.literal("Can give land-animal DNA from many eras."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.LEECH_IN_ICE.get(), List.of(), List.of(), Component.literal("Leech in a block of ice, often from an ice burg."), Component.literal("Can give water-animal DNA from many eras."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.FROZEN_MEAT.get(), List.of(), List.of(), Component.literal("Frozen meat from permafrost."), Component.literal("Can give water-animal DNA from many eras."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.STORAGE_DISC.get(), List.of(FAUtils.resource("storage_disc")), List.of(), Component.literal("Plates of iron to save genetic code."), Component.literal("Used to encode and decode DNA."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.BLANK_DNA.get(), List.of(FAUtils.resource("blank_dna")), List.of(), Component.literal("Mix of nucleotides, phosphates, and deoxyribose."), Component.literal("Used to clone DNA."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.DINOPEDIA.get(), List.of(FAUtils.resource("dinopedia")), List.of(), Component.literal("Book of information."), Component.literal("Used on animal to get certain stats."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), List.of(FAUtils.resource("raw_chicken_soup_bucket"), FAUtils.resource("cooked_chicken_soup_bucket")), List.of(), Component.literal("A bucket of chicken in broth."), Component.literal("Used to make Chicken Essence."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get(), List.of(FAUtils.resource("cooked_chicken_soup_bucket"), FAUtils.resource("chicken_essence_bottle")), List.of(), Component.literal("A bucket of cooked chicken in broth."), Component.literal("Used to make Chicken Essence and is a heart meal."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.CHICKEN_ESSENCE_BOTTLE.get(), List.of(FAUtils.resource("chicken_essence_bottle")), List.of(), Component.literal("Essence of chicken."), Component.literal("Can be used to grow a dinosaur one growth stage, with a cost of hunger."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), List.of(FAUtils.resource("raw_berry_medley_bucket")), List.of(), Component.literal("Bucket of various berries, meat, and vegetables."), Component.literal("Used to make Romantic Concoction."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get(), List.of(FAUtils.resource("cooked_berry_medley_bucket"), FAUtils.resource("romantic_concoction_bottle")), List.of(), Component.literal("A bucket of cooked berries, meat, and vegetable."), Component.literal("Used to make Romantic Concoction and can be eaten."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.ROMANTIC_CONCOCTION_BOTTLE.get(), List.of(FAUtils.resource("romantic_concoction_bottle")), List.of(), Component.literal("Concoction of food."), Component.literal("Can be used to mate dinosaurs."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.RIFLE.get(), List.of(FAUtils.resource("rifle")), List.of(), Component.literal("Long barrel of iron."), Component.literal("Can be used to sedate dinosaurs for capture and movement."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.GREEN_TRANQUILIZER_DART.get(), List.of(FAUtils.resource("green_tranquilizer_dart")), List.of(), Component.literal("Dart tipped with poisonous potato."), Component.literal("Can be used in a rifle to sedate dinosaurs for capture and movement for a shorter length of time."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.RED_TRANQUILIZER_DART.get(), List.of(FAUtils.resource("red_tranquilizer_dart")), List.of(), Component.literal("Dart tipped with rotten flesh."), Component.literal("Can be used in a rifle to sedate dinosaurs for capture and movement for a medium length of time."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.BLUE_TRANQUILIZER_DART.get(), List.of(FAUtils.resource("blue_tranquilizer_dart")), List.of(), Component.literal("Dart tipped with fermented spider eye."), Component.literal("Can be used in a rifle to sedate dinosaurs for capture and movement for a long length of time."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.TAR_BUCKET.get(), List.of(), List.of(), Component.literal("Bucket filled with tar."), Component.literal("A bucket filled with hot, thick tar."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.THERIZINOSAURUS_CLAWS.get(), List.of(), List.of(), Component.literal("Claws from a therizinosaurus."), Component.literal("Can be used as a slow, but powerful weapon."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.TYRANNOSAURUS_TOOTH.get(), List.of(FAUtils.resource("tooth_dagger")), List.of(), Component.literal("Tooth from a tyrannosaurus."), Component.literal("Can be used as an ingredient."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.TOOTH_DAGGER.get(), List.of(FAUtils.resource("tooth_dagger")), List.of(), Component.literal("A tooth dagger."), Component.literal("Used like a sword, made of tyrannosaurus tooth."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.SKULL_STICK.get(), List.of(FAUtils.resource("skull_stick")), List.of(), Component.literal("A skull stick."), Component.literal("Used to command some large carnivores."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.NAUTILUS_SHELL.get(), List.of(), List.of(), Component.literal("Shell from a nautilus."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.MAGIC_CONCH.get(), List.of(), List.of(), Component.literal("A playable nautilus shell."), Component.literal("Used to command some water animals. Can change command by placing it in a crafting table."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.LEGACY_GENETIC_CODE.get(), List.of(), List.of(), Component.literal("Old genetic code."), Component.literal("Used in DNA Recombinator to provide old genetic information."), Component.literal("For more information, look to the recipes."));
        Component hammerDesc2 = Component.literal("Used to cultivate DNA in eggs, embryos, seeds, spores, and cones.");
        Component hammerDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.WOODEN_HAMMER.get(), List.of(FAUtils.resource("wooden_hammer")), List.of(), Component.literal("A wooden tool."), hammerDesc2, hammerDesc3);
        UserManualData.add(FAItems.STONE_HAMMER.get(), List.of(FAUtils.resource("stone_hammer")), List.of(), Component.literal("A stone tool."), hammerDesc2, hammerDesc3);
        UserManualData.add(FAItems.IRON_HAMMER.get(), List.of(FAUtils.resource("iron_hammer")), List.of(), Component.literal("An iron tool."), hammerDesc2, hammerDesc3);
        UserManualData.add(FAItems.GOLDEN_HAMMER.get(), List.of(FAUtils.resource("golden_hammer")), List.of(), Component.literal("A golden tool."), hammerDesc2, hammerDesc3);
        UserManualData.add(FAItems.DIAMOND_HAMMER.get(), List.of(FAUtils.resource("diamond_hammer")), List.of(), Component.literal("A diamond tool."), hammerDesc2, hammerDesc3);
        UserManualData.add(FAItems.NETHERITE_HAMMER.get(), List.of(FAUtils.resource("netherite_hammer")), List.of(), Component.literal("A netherite tool."), hammerDesc2, hammerDesc3);
        UserManualData.add(FAItems.IRON_KEY.get(), List.of(FAUtils.resource("iron_key")), List.of(), Component.literal("An iron tool."), Component.literal("Used to lock and open cages. Shift and left-click assign it, the cage will need it to open, place in crafting table with another key to clone it."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.GOLDEN_KEY.get(), List.of(FAUtils.resource("golden_key")), List.of(), Component.literal("A golden tool."), Component.literal("Used to lock and open cages. Shift and right-click assign it, the cage will need it to open, place in crafting table with another key to clone it."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.BOLT_CUTTER.get(), List.of(FAUtils.resource("bolt_cutter")), List.of(), Component.literal("An iron tool."), Component.literal("Used to cut open locked cages. Right-click to break it."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.FLARE.get(), List.of(FAUtils.resource("flare"), FAUtils.resource("renew_flare")), List.of(), Component.literal("An utility tool."), Component.literal("Used to lure certain creatures towards you, Right-click to start it."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.FLARE_BODY.get(), List.of(FAUtils.resource("flare_body")), List.of(), Component.literal("An ingredient."), Component.literal("The remnants of flare."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.USER_MANUAL.get(), List.of(FAUtils.resource("user_manuel")), List.of(), Component.literal("An encyclopedia of information."), Component.literal("A manuel that contains all information for the Fossils and Archaeology Mod."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FAItems.JEEP_1993.get(), List.of(), List.of(), Component.literal("A vehicle from 1993."), Component.literal("A car for transportation."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.SKULL_BLOCK.get(), List.of(FAUtils.resource("skull_lantern_block"), FAUtils.resource("skull_stick")), List.of(BlockLootRecipe.dropSelf(FABlocks.SKULL_BLOCK.get())), Component.literal("A skull block."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.ANALYZER.get(), List.of(FAUtils.resource("analyzer")), List.of(BlockLootRecipe.dropSelf(FABlocks.ANALYZER.get())), Component.literal("A utility block."), Component.literal("Used to analyzer discovered items."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.DNA_CODER.get(), List.of(FAUtils.resource("dna_coder")), List.of(BlockLootRecipe.dropSelf(FABlocks.DNA_CODER.get())), Component.literal("A utility block."), Component.literal("Used to decode and encode DNA."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.DNA_HYBRIDIZER.get(), List.of(FAUtils.resource("dna_hybridizer")), List.of(BlockLootRecipe.dropSelf(FABlocks.DNA_HYBRIDIZER.get())), Component.literal("A utility block."), Component.literal("Used to combine and hybridize DNA."), Component.literal("For more information, look to the recipes."));
        Component cultivatorDesc1 = Component.literal("A utility block.");
        Component cultivatorDesc2 = Component.literal("Used to cultivate DNA in eggs, embryos, seeds, spores, and cones.");
        Component cultivatorDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FABlocks.WHITE_CULTIVATOR.get(), List.of(FAUtils.resource("white_cultivator"), FAUtils.resource("white_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.WHITE_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.ORANGE_CULTIVATOR.get(), List.of(FAUtils.resource("orange_cultivator"), FAUtils.resource("orange_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.ORANGE_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.MAGENTA_CULTIVATOR.get(), List.of(FAUtils.resource("magenta_cultivator"), FAUtils.resource("magenta_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.MAGENTA_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.LIGHT_BLUE_CULTIVATOR.get(), List.of(FAUtils.resource("light_blue_cultivator"), FAUtils.resource("light_blue_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.LIGHT_BLUE_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.YELLOW_CULTIVATOR.get(), List.of(FAUtils.resource("yellow_cultivator"), FAUtils.resource("yellow_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.YELLOW_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.LIME_CULTIVATOR.get(), List.of(FAUtils.resource("lime_cultivator"), FAUtils.resource("lime_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.LIME_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.PINK_CULTIVATOR.get(), List.of(FAUtils.resource("pink_cultivator"), FAUtils.resource("pink_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.PINK_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.GRAY_CULTIVATOR.get(), List.of(FAUtils.resource("gray_cultivator"), FAUtils.resource("gray_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.GRAY_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.LIGHT_GRAY_CULTIVATOR.get(), List.of(FAUtils.resource("light_gray_cultivator"), FAUtils.resource("light_gray_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.LIGHT_GRAY_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.CYAN_CULTIVATOR.get(), List.of(FAUtils.resource("cyan_cultivator"), FAUtils.resource("cyan_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.CYAN_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.PURPLE_CULTIVATOR.get(), List.of(FAUtils.resource("purple_cultivator"), FAUtils.resource("purple_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.PURPLE_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.BLUE_CULTIVATOR.get(), List.of(FAUtils.resource("blue_cultivator"), FAUtils.resource("blue_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.BLUE_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.BROWN_CULTIVATOR.get(), List.of(FAUtils.resource("brown_cultivator"), FAUtils.resource("brown_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.BROWN_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.GREEN_CULTIVATOR.get(), List.of(FAUtils.resource("green_cultivator"), FAUtils.resource("green_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.GREEN_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.RED_CULTIVATOR.get(), List.of(FAUtils.resource("red_cultivator"), FAUtils.resource("red_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.RED_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.BLACK_CULTIVATOR.get(), List.of(FAUtils.resource("black_cultivator"), FAUtils.resource("black_cultivator_from_dyed_glass")), List.of(BlockLootRecipe.dropSelf(FABlocks.BLACK_CULTIVATOR.get())), cultivatorDesc1, cultivatorDesc2, cultivatorDesc3);
        UserManualData.add(FABlocks.DNA_RECOMBINATOR.get(), List.of(FAUtils.resource("dna_recombinator")), List.of(BlockLootRecipe.dropSelf(FABlocks.DNA_RECOMBINATOR.get())), Component.literal("A utility block."), Component.literal("Used to modify parts of DNA."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.ARCHAEOLOGY_WORKBENCH.get(), List.of(FAUtils.resource("archaeology_workbench")), List.of(BlockLootRecipe.dropSelf(FABlocks.ARCHAEOLOGY_WORKBENCH.get())), Component.literal("A utility block."), Component.literal("Used to repair and restore broken artifacts."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.PALAEONTOLOGY_TABLE.get(), List.of(FAUtils.resource("palaeontology_table")), List.of(BlockLootRecipe.dropSelf(FABlocks.PALAEONTOLOGY_TABLE.get())), Component.literal("A utility block."), Component.literal("Used to articulate fossils into skeletons."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.DRUM.get(), List.of(FAUtils.resource("drum")), List.of(BlockLootRecipe.dropSelf(FABlocks.DRUM.get())), Component.literal("A utility block."), Component.literal("Used send commands to many creatures at once. Left-click to set the command, right-click to send the command."), Component.literal("For more information, look to the recipes."));
        UserManualData.add(FABlocks.FEEDER.get(), List.of(FAUtils.resource("feeder")), List.of(BlockLootRecipe.dropSelf(FABlocks.FEEDER.get())), Component.literal("A utility block."), Component.literal("Used for animals to feed themselves when hungry."), Component.literal("For more information, look to the recipes."));
        Component dnaDesc1 = Component.literal("Deoxyribonucleic acid.");
        Component dnaDesc2 = Component.literal("Information of a creature, used to recreate the aforementioned.");
        Component dnaDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.DIMETRODON_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.ISOTELUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.ANKYLOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.BARYONYX_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.BRACHIOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.CARNOTAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.COMPSOGNATHUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.CRYOLOPHOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.DILOPHOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.DRYOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.FUTABASAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.GALLIMIMUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.ICHTHYOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.MOSASAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.PACHYCEPHALOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.PTERANODON_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.SPINOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.STEGOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.THERIZINOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.TRICERATOPS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.TYRANNOSAURUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.VELOCIRAPTOR_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.DODO_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.ELASMOTHERIUM_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.MAMMOTH_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.MOA_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.ARMADILLO_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.AXOLOTL_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.CAT_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.CHICKEN_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.COW_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.DOLPHIN_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.DONKEY_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.FOX_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.FROG_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.GOAT_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.HORSE_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.LLAMA_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.MULE_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.NAUTILUS_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.OCELOT_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.PANDA_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.PARROT_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.PIG_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.POLAR_BEAR_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.RABBIT_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.SHEEP_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        UserManualData.add(FAItems.WOLF_DNA.get(), List.of(), List.of(), dnaDesc1, dnaDesc2, dnaDesc3);
        Component eggDesc1 = Component.literal("An egg.");
        Component eggDesc2 = Component.literal("The egg of a creature, place down and give heat to allow it to hatch.");
        Component eggDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.ANKYLOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.BARYONYX_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.CARNOTAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.COMPSOGNATHUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.CRYOLOPHOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.DILOPHOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.DIMETRODON_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.DRYOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.FUTABASAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.GALLIMIMUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.ICHTHYOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.MOSASAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.PACHYCEPHALOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.PTERANODON_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.SPINOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.STEGOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.THERIZINOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.TRICERATOPS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.TYRANNOSAURUS_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        UserManualData.add(FAItems.VELOCIRAPTOR_EGG.get(), List.of(), List.of(), eggDesc1, eggDesc2, eggDesc3);
        Component embryoSyringeDesc1 = Component.literal("A syringe filled with a creature embryo.");
        Component embryoSyringeDesc2 = Component.literal("Use on a mammal to impregnate.");
        Component embryoSyringeDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.ELASMOTHERIUM_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.MAMMOTH_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.SMILODON_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.ARMADILLO_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.CAT_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.COW_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.DOLPHIN_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.DONKEY_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.FOX_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.GOAT_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.HORSE_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.LLAMA_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.MULE_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.OCELOT_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.PANDA_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.PIG_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.RABBIT_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.SHEEP_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        UserManualData.add(FAItems.WOLF_EMBRYO_SYRINGE.get(), List.of(), List.of(), embryoSyringeDesc1, embryoSyringeDesc2, embryoSyringeDesc3);
        Component incubatedEggDesc1 = Component.literal("An incubated egg.");
        Component incubatedEggDesc2 = Component.literal("Throw to hatch.");
        Component incubatedEggDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.INCUBATED_DODO_EGG.get(), List.of(), List.of(), incubatedEggDesc1, incubatedEggDesc2, incubatedEggDesc3);
        UserManualData.add(FAItems.INCUBATED_MOA_EGG.get(), List.of(), List.of(), incubatedEggDesc1, incubatedEggDesc2, incubatedEggDesc3);
        UserManualData.add(FAItems.INCUBATED_CHICKEN_EGG.get(), List.of(), List.of(), incubatedEggDesc1, incubatedEggDesc2, incubatedEggDesc3);
        UserManualData.add(FAItems.INCUBATED_PARROT_EGG.get(), List.of(), List.of(), incubatedEggDesc1, incubatedEggDesc2, incubatedEggDesc3);
        Component thrownEggDesc1 = Component.literal("An egg.");
        Component thrownEggDesc2 = Component.literal("Throw for a chance to hatch.");
        Component thrownEggDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.DODO_EGG.get(), List.of(), List.of(), thrownEggDesc1, thrownEggDesc2, thrownEggDesc3);
        UserManualData.add(FAItems.MOA_EGG.get(), List.of(), List.of(), thrownEggDesc1, thrownEggDesc2, thrownEggDesc3);
        Component placeEggDesc1 = Component.literal("A cluster of eggs.");
        Component placeEggDesc2 = Component.literal("Place to hatch.");
        Component placeEggDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.ISOTELUS_EGGS.get(), List.of(), List.of(), placeEggDesc1, placeEggDesc2, placeEggDesc3);
        UserManualData.add(FAItems.NAUTILUS_EGGS.get(), List.of(), List.of(), placeEggDesc1, placeEggDesc2, placeEggDesc3);
        UserManualData.add(FABlocks.AXOLOTLSPAWN.get(), List.of(), List.of(), Component.literal("A cluster of eggs."), Component.literal("Place on water and wait to hatch."), Component.literal("For more information, look to the recipes."));
        Component rawMeatDesc1 = Component.literal("Raw meat from an animal.");
        Component rawMeatDesc2 = Component.literal("Can be used to get DNA or cooked to eat.");
        Component rawMeatDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.RAW_ANKYLOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_BARYONYX.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_BRACHIOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_CARNOTAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_COMPSOGNATHUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_CRYOLOPHOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_DILOPHOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_DIMETRODON.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_DODO.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_DRYOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_ELASMOTHERIUM.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_FUTABASAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_GALLIMIMUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_ICHTHYOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_MAMMOTH.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_MOA.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_MOSASAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_PACHYCEPHALOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_PTERANODON.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_SMILODON.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_SPINOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_STEGOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_THERIZINOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_TRICERATOPS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_TYRANNOSAURUS.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.RAW_VELOCIRAPTOR.get(), List.of(), List.of(), rawMeatDesc1, rawMeatDesc2, rawMeatDesc3);
        UserManualData.add(FAItems.NAUTILUS.get(), List.of(), List.of(), Component.literal("A living nautilus."), Component.literal("Can be placed back down into water or cooked for food."), Component.literal("For more information, look to the recipes."));
        Component cookedMeatDesc1 = Component.literal("Cooked meat from an animal.");
        Component cookedMeatDesc2 = Component.literal("A hearty meal.");
        Component cookedMeatDesc3 = Component.literal("For more information, look to the recipes.");
        UserManualData.add(FAItems.COOKED_ANKYLOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_BARYONYX.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_BRACHIOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_CARNOTAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_COMPSOGNATHUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_CRYOLOPHOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_DILOPHOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_DIMETRODON.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_DODO.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_DRYOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_ELASMOTHERIUM.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_FUTABASAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_GALLIMIMUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_ICHTHYOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_MAMMOTH.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_MOA.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_MOSASAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_PACHYCEPHALOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_PTERANODON.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_SMILODON.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_SPINOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_STEGOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_THERIZINOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_TRICERATOPS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_TYRANNOSAURUS.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.COOKED_VELOCIRAPTOR.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);
        UserManualData.add(FAItems.SIO_CHIU_LE.get(), List.of(), List.of(), cookedMeatDesc1, cookedMeatDesc2, cookedMeatDesc3);

        UserManualData.add(RecipeType.CRAFTING, FAUtils.resource("container/user_manual/crafting"), 116, 54, 29, 16, new DrawCraftingTableRecipe(), Blocks.CRAFTING_TABLE, Blocks.CRAFTER);
        UserManualData.add(RecipeType.SMELTING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.FURNACE);
        UserManualData.add(RecipeType.SMOKING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.SMOKER);
        UserManualData.add(RecipeType.BLASTING, FAUtils.resource("container/user_manual/smelting"), 82, 54, 55, 16, new DrawFurnaceRecipe(), Blocks.BLAST_FURNACE);
        UserManualData.add(RecipeType.SMITHING, FAUtils.resource("container/user_manual/smithing"), 108, 18, 32, 34, new DrawSmithingTableRecipe(), Blocks.SMITHING_TABLE);
    }

    public static void add(ItemLike itemLike, Component... informaiton) {
        UserManualData.add(itemLike, List.of(), List.of(), informaiton);
    }

    public static void add(ItemLike itemLike, List<ResourceLocation> recipes, List<LootRecipe> lootTables, Component... informaiton) {
        ITEM_INFORMATION.put(itemLike.asItem(), new ItemPage(recipes.stream().map(UserManualData::createRecipeKey).toList(), lootTables, Arrays.asList(informaiton)));
    }

    private static ResourceKey<Recipe<?>> createRecipeKey(ResourceLocation id) {
        return ResourceKey.create(Registries.RECIPE, id);
    }

    public static void add(RecipeType<?> recipeType, ResourceLocation texture, int width, int height, int xOffset, int yOffset, DrawRecipe drawRecipe, Block... containers) {
        RECIPE_TYPE_INFORMATION.put(recipeType, new RecipeTypePage(texture, width, height, xOffset, yOffset, drawRecipe, containers));
    }

    public record ItemPage(List<ResourceKey<Recipe<?>>> recipes, List<LootRecipe> lootTables, List<Component> information) {
        public static final ItemPage EMPTY = new ItemPage(List.of(), List.of(), List.of());
    }

    public record RecipeTypePage(ResourceLocation texture, int width, int height, int xOffset, int yOffset, DrawRecipe drawRecipe, Block... containers) {
        public static final RecipeTypePage EMPTY = new RecipeTypePage(null, 0, 0, 0, 0, (level, recipe, provider, slotPlacer, spriteDrawer) -> {
        });
    }

    public interface LootRecipe {
        void draw(SlotPlacer slotPlacer);
    }

    public record BlockLootRecipe(Block block, ItemLike... drops) implements LootRecipe {
        public static BlockLootRecipe dropSelf(Block block) {
            return new BlockLootRecipe(block, block);
        }

        @Override
        public void draw(SlotPlacer slotPlacer) {
            slotPlacer.place(1, 1, new ItemStack(this.block));
            for (int i = 0; i < this.drops.length; i++) {
                slotPlacer.place(55 + (i * 18), 1, new ItemStack(this.drops[i]));
            }
        }
    }

    public interface DrawRecipe {
        void draw(Level level, Recipe<?> recipe, HolderLookup.Provider registries, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer);
    }

    static class DrawCraftingTableRecipe implements DrawRecipe {
        @Override
        public void draw(Level level, Recipe<?> recipe, HolderLookup.Provider registries, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
            ItemStack output;
            if (recipe instanceof ShapedRecipe shapedRecipe) {
                List<Optional<Ingredient>> ingredients = shapedRecipe.getIngredients();
                output = recipe.assemble(null, registries);
                for (int x = 0; x < shapedRecipe.getWidth(); x++) {
                    for (int y = 0; y < shapedRecipe.getHeight(); y++) {
                        int index = x + (y * shapedRecipe.getWidth());
                        if (index < ingredients.size()) {
                            Optional<Ingredient> ingredient = ingredients.get(index);
                            if (ingredient.isPresent()) {
                                slotPlacer.place(1 + x * 18, 1 + y * 18, ingredient.get());
                            }
                        }
                    }
                }

                slotPlacer.place(95, 19, output);
            }
            List<Ingredient> ingredients = recipe.placementInfo().ingredients();
            if (recipe instanceof ShapelessRecipe) {
                output = recipe.assemble(null, registries);
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        int index = x + (y * 3);
                        if (index < ingredients.size()) {
                            slotPlacer.place(1 + x * 18, 1 + y * 18, ingredients.get(index));
                        }
                    }
                }

                slotPlacer.place(95, 19, output);

                spriteDrawer.draw(93, 16, 16, 16, 16, 16, SHAPELESS);
            }
        }
    }

    static class DrawFurnaceRecipe implements DrawRecipe {
        @Override
        public void draw(Level level, Recipe<?> recipe, HolderLookup.Provider registries, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
            ItemStack output;
            List<Ingredient> ingredients = recipe.placementInfo().ingredients();
            if (recipe instanceof SmeltingRecipe smeltingRecipe) {
                output = smeltingRecipe.assemble(null, registries);
                slotPlacer.place(1, 1, ingredients.getFirst());

                slotPlacer.place(1, 37, level.fuelValues().fuelItems().stream().map(ItemStack::new).toList());

                slotPlacer.place(61, 19, output);
            }
        }
    }

    static class DrawSmithingTableRecipe implements DrawRecipe {
        @Override
        public void draw(Level level, Recipe<?> recipe, HolderLookup.Provider registries, SlotPlacer slotPlacer, SpriteDrawer spriteDrawer) {
            ItemStack output;
            List<Ingredient> ingredients = recipe.placementInfo().ingredients();
            if (recipe instanceof SmithingTransformRecipe smithingTransformRecipe) {
                Optional<Ingredient> template = smithingTransformRecipe.templateIngredient();
                Optional<Ingredient> base = smithingTransformRecipe.baseIngredient();
                Optional<Ingredient> addition = smithingTransformRecipe.additionIngredient();
                output = smithingTransformRecipe.assemble(new SmithingRecipeInput(new ItemStack(template.get().items().toList().getFirst()), new ItemStack(base.get().items().toList().getFirst()), new ItemStack(addition.get().items().toList().getFirst())), registries);
                template.ifPresent(ingredient -> slotPlacer.place(1, 1, ingredient));
                base.ifPresent(ingredient -> slotPlacer.place(19, 1, ingredient));
                addition.ifPresent(ingredient -> slotPlacer.place(37, 1, ingredient));

                if (output != null) {
                    slotPlacer.place(91, 1, output);
                }
            }
        }
    }

    public static class SlotPlacer {
        private final Map<Coordinate, List<ItemStack>> data = new HashMap<>();

        public void place(int x, int y, Ingredient ingredient) {
            this.data.put(new Coordinate(x, y), ingredient.items().map(ItemStack::new).toList());
        }

        public void place(int x, int y, ItemStack itemStack) {
            this.data.put(new Coordinate(x, y), List.of(itemStack));
        }

        public void place(int x, int y, List<ItemStack> itemStacks) {
            this.data.put(new Coordinate(x, y), itemStacks);
        }

        public Set<Map.Entry<Coordinate, List<ItemStack>>> forEach() {
            return this.data.entrySet();
        }
    }

    public static class SpriteDrawer {
        private final Map<SpriteInformation, ResourceLocation> data = new HashMap<>();

        public void draw(int x, int y, int width, int height, int u, int v, ResourceLocation texture) {
            this.data.put(new SpriteInformation(new Coordinate(x, y), width, height, u, v), texture);
        }

        public Set<Map.Entry<SpriteInformation, ResourceLocation>> forEach() {
            return this.data.entrySet();
        }
    }

    public record Coordinate(int x, int y) {
    }

    public record SpriteInformation(Coordinate coordinate, int width, int height, int u, int v) {
    }
}
