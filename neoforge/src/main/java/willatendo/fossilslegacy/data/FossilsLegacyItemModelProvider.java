package willatendo.fossilslegacy.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.data.SimpleItemModelProvider;

public class FossilsLegacyItemModelProvider extends SimpleItemModelProvider {
    public FossilsLegacyItemModelProvider(PackOutput packOutput, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, modId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(FossilsLegacyItems.FOSSIL.get());
        this.basicItem(FossilsLegacyItems.TRICERATOPS_DNA.get());
        this.basicItem(FossilsLegacyItems.VELOCIRAPTOR_DNA.get());
        this.basicItem(FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.PTERANODON_DNA.get());
        this.basicItem(FossilsLegacyItems.NAUTILUS_DNA.get());
        this.basicItem(FossilsLegacyItems.FUTABASAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.MOSASAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.STEGOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.CARNOTAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.THERIZINOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.COMPSOGNATHUS_DNA.get());
        this.basicItem(FossilsLegacyItems.GALLIMIMUS_DNA.get());
        this.basicItem(FossilsLegacyItems.SPINOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.ANKYLOSAURUS_DNA.get());
        this.basicItem(FossilsLegacyItems.PETRIFIED_LEPIDODENDRON_SAPLING.get());
        this.basicItem(FossilsLegacyItems.PETRIFIED_SIGILLARIA_SAPLING.get());
        this.basicItem(FossilsLegacyItems.PETRIFIED_CALAMITES_SAPLING.get());
        this.basicItem(FossilsLegacyItems.TRICERATOPS_EGG.get());
        this.basicItem(FossilsLegacyItems.VELOCIRAPTOR_EGG.get());
        this.basicItem(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.PTERANODON_EGG.get());
        this.basicItem(FossilsLegacyItems.NAUTILUS_EGGS.get());
        this.basicItem(FossilsLegacyItems.FUTABASAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.MOSASAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.STEGOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.CARNOTAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.CRYOLOPHOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.THERIZINOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.PACHYCEPHALOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.COMPSOGNATHUS_EGG.get());
        this.basicItem(FossilsLegacyItems.GALLIMIMUS_EGG.get());
        this.basicItem(FossilsLegacyItems.SPINOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.ANKYLOSAURUS_EGG.get());
        this.basicItem(FossilsLegacyItems.RAW_TRICERATOPS.get());
        this.basicItem(FossilsLegacyItems.RAW_VELOCIRAPTOR.get());
        this.basicItem(FossilsLegacyItems.RAW_TYRANNOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_PTERANODON.get());
        this.basicItem(FossilsLegacyItems.NAUTILUS.get());
        this.basicItem(FossilsLegacyItems.RAW_FUTABASAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_MOSASAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_STEGOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_DILOPHOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_BRACHIOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_SMILODON.get());
        this.basicItem(FossilsLegacyItems.RAW_MAMMOTH.get());
        this.basicItem(FossilsLegacyItems.RAW_CARNOTAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_THERIZINOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_COMPSOGNATHUS.get());
        this.basicItem(FossilsLegacyItems.RAW_DODO.get());
        this.basicItem(FossilsLegacyItems.RAW_MOA.get());
        this.basicItem(FossilsLegacyItems.RAW_GALLIMIMUS.get());
        this.basicItem(FossilsLegacyItems.RAW_SPINOSAURUS.get());
        this.basicItem(FossilsLegacyItems.RAW_ANKYLOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_TRICERATOPS.get());
        this.basicItem(FossilsLegacyItems.COOKED_VELOCIRAPTOR.get());
        this.basicItem(FossilsLegacyItems.COOKED_TYRANNOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_PTERANODON.get());
        this.basicItem(FossilsLegacyItems.SIO_CHIU_LE.get());
        this.basicItem(FossilsLegacyItems.COOKED_FUTABASAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_MOSASAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_STEGOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_DILOPHOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_BRACHIOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_SMILODON.get());
        this.basicItem(FossilsLegacyItems.COOKED_MAMMOTH.get());
        this.basicItem(FossilsLegacyItems.COOKED_CARNOTAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_THERIZINOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_PACHYCEPHALOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_COMPSOGNATHUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_DODO.get());
        this.basicItem(FossilsLegacyItems.COOKED_MOA.get());
        this.basicItem(FossilsLegacyItems.COOKED_GALLIMIMUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_SPINOSAURUS.get());
        this.basicItem(FossilsLegacyItems.COOKED_ANKYLOSAURUS.get());
        this.basicItem(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
        this.handheldItem(FossilsLegacyItems.TOOTH_DAGGER.get());
        this.handheldItem(FossilsLegacyItems.THERIZINOSAURUS_CLAWS.get());
        this.handheldItem(FossilsLegacyItems.SKULL_STICK.get());
        this.basicItem(FossilsLegacyItems.DINOPEDIA.get());
        this.basicItem(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get());
        this.basicItem(FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get());
        this.basicItem(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        this.basicItem(FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get());
        this.basicItem(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
        this.basicItem(FossilsLegacyItems.ROMANTIC_CONCOCTION_BOTTLE.get());
        this.basicItem(FossilsLegacyItems.NAUTILUS_SHELL.get());
        this.handheldItem(FossilsLegacyItems.FROZEN_MEAT.get());
        this.handheldItem(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get(), this.modLoc("item/frozen_meat"));
        this.basicItem(FossilsLegacyItems.ARMADILLO_DNA.get());
        this.basicItem(FossilsLegacyItems.AXOLOTL_DNA.get());
        this.basicItem(FossilsLegacyItems.CAT_DNA.get());
        this.basicItem(FossilsLegacyItems.CHICKEN_DNA.get());
        this.basicItem(FossilsLegacyItems.COW_DNA.get());
        this.basicItem(FossilsLegacyItems.DOLPHIN_DNA.get());
        this.basicItem(FossilsLegacyItems.DONKEY_DNA.get());
        this.basicItem(FossilsLegacyItems.FOX_DNA.get());
        this.basicItem(FossilsLegacyItems.FROG_DNA.get());
        this.basicItem(FossilsLegacyItems.GOAT_DNA.get());
        this.basicItem(FossilsLegacyItems.HORSE_DNA.get());
        this.basicItem(FossilsLegacyItems.LLAMA_DNA.get());
        this.basicItem(FossilsLegacyItems.MULE_DNA.get());
        this.basicItem(FossilsLegacyItems.OCELOT_DNA.get());
        this.basicItem(FossilsLegacyItems.PANDA_DNA.get());
        this.basicItem(FossilsLegacyItems.PARROT_DNA.get());
        this.basicItem(FossilsLegacyItems.PIG_DNA.get());
        this.basicItem(FossilsLegacyItems.POLAR_BEAR_DNA.get());
        this.basicItem(FossilsLegacyItems.RABBIT_DNA.get());
        this.basicItem(FossilsLegacyItems.SHEEP_DNA.get());
        this.basicItem(FossilsLegacyItems.WOLF_DNA.get());
        this.basicItem(FossilsLegacyItems.SMILODON_DNA.get());
        this.basicItem(FossilsLegacyItems.MAMMOTH_DNA.get());
        this.basicItem(FossilsLegacyItems.DODO_DNA.get());
        this.basicItem(FossilsLegacyItems.MOA_DNA.get());
        this.basicItem(FossilsLegacyItems.ARMADILLO_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
        this.basicItem(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.INCUBATED_PARROT_EGG.get());
        this.basicItem(FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get());
        this.basicItem(FossilsLegacyItems.INCUBATED_DODO_EGG.get());
        this.basicItem(FossilsLegacyItems.INCUBATED_MOA_EGG.get());
        this.basicItem(FossilsLegacyItems.DODO_EGG.get());
        this.basicItem(FossilsLegacyItems.MOA_EGG.get());
        this.basicItem(FossilsLegacyItems.MAGIC_CONCH.get());
        this.basicItem(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        this.basicItem(FossilsLegacyItems.ARTICULATED_FOSSIL.get());
        this.basicItem(FossilsLegacyItems.RELIC_SCRAP.get());
        this.basicItem(FossilsLegacyItems.STONE_TABLET.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_PICKAXE_ARTIFACT.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_AXE_ARTIFACT.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_HOE_ARTIFACT.get());
        this.basicItem(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get());
        this.basicItem(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get());
        this.basicItem(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get());
        this.basicItem(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get());
        this.basicItem(FossilsLegacyItems.SCARAB_GEM.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_SWORD.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_SHOVEL.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_PICKAXE.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_AXE.get());
        this.handheldItem(FossilsLegacyItems.ANCIENT_HOE.get());
        this.armorItem(FossilsLegacyItems.ANCIENT_HELMET.get(), "helmet");
        this.armorItem(FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), "chestplate");
        this.armorItem(FossilsLegacyItems.ANCIENT_LEGGINGS.get(), "leggings");
        this.armorItem(FossilsLegacyItems.ANCIENT_BOOTS.get(), "boots");
        this.handheldItem(FossilsLegacyItems.SCARAB_GEM_SWORD.get());
        this.handheldItem(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get());
        this.handheldItem(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get());
        this.handheldItem(FossilsLegacyItems.SCARAB_GEM_AXE.get());
        this.handheldItem(FossilsLegacyItems.SCARAB_GEM_HOE.get());
        this.armorItem(FossilsLegacyItems.SCARAB_GEM_HELMET.get(), "helmet");
        this.armorItem(FossilsLegacyItems.SCARAB_GEM_CHESTPLATE.get(), "chestplate");
        this.armorItem(FossilsLegacyItems.SCARAB_GEM_LEGGINGS.get(), "leggings");
        this.armorItem(FossilsLegacyItems.SCARAB_GEM_BOOTS.get(), "boots");
        this.basicItem(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get());
        this.basicItem(FossilsLegacyItems.WOODEN_JAVELIN.get());
        this.basicItem(FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), this.modLoc("item/wooden_javelin"));
        this.basicItem(FossilsLegacyItems.STONE_JAVELIN.get());
        this.basicItem(FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), this.modLoc("item/stone_javelin"));
        this.basicItem(FossilsLegacyItems.IRON_JAVELIN.get());
        this.basicItem(FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), this.modLoc("item/iron_javelin"));
        this.basicItem(FossilsLegacyItems.GOLDEN_JAVELIN.get());
        this.basicItem(FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), this.modLoc("item/golden_javelin"));
        this.basicItem(FossilsLegacyItems.DIAMOND_JAVELIN.get());
        this.basicItem(FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), this.modLoc("item/diamond_javelin"));
        this.basicItem(FossilsLegacyItems.NETHERITE_JAVELIN.get());
        this.basicItem(FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), this.modLoc("item/netherite_javelin"));
        this.basicItem(FossilsLegacyItems.SCARAB_GEM_JAVELIN.get());
        this.basicItem(FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get(), this.modLoc("item/scarab_gem_javelin"));

        this.spawnEggItem(FossilsLegacyItems.ANU_SPAWN_EGG.get());

        this.spawnEggItem(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());

        this.spawnEggItem(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.CARNOTAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.CRYOLOPHOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.THERIZINOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.COMPSOGNATHUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.DODO_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.MOA_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.GALLIMIMUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.SPINOSAURUS_SPAWN_EGG.get());
        this.spawnEggItem(FossilsLegacyItems.ANKYLOSAURUS_SPAWN_EGG.get());
        this.basicItem(FossilsLegacyItems.LEPIDODENDRON_BOAT.get());
        this.basicItem(FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT.get());
        this.basicItem(FossilsLegacyItems.SIGILLARIA_BOAT.get());
        this.basicItem(FossilsLegacyItems.SIGILLARIA_CHEST_BOAT.get());
        this.basicItem(FossilsLegacyItems.CALAMITES_BOAT.get());
        this.basicItem(FossilsLegacyItems.CALAMITES_CHEST_BOAT.get());

        this.basicItem(FossilsLegacyItems.OVERWORLD_COIN.get());
        this.basicItem(FossilsLegacyItems.ICE_AGE_COIN.get());
        this.basicItem(FossilsLegacyItems.PREHISTORIC_COIN.get());

        this.handheldItem(FossilsLegacyItems.DEBUG_MAX_HUNGER.get(), FossilsLegacyUtils.mc("item/bone"));
        this.handheldItem(FossilsLegacyItems.DEBUG_MAX_HEALTH.get(), FossilsLegacyUtils.mc("item/bone"));
        this.handheldItem(FossilsLegacyItems.DEBUG_FULL_GROWN.get(), FossilsLegacyUtils.mc("item/bone"));
        this.handheldItem(FossilsLegacyItems.DEBUG_BABY.get(), FossilsLegacyUtils.mc("item/bone"));
        this.handheldItem(FossilsLegacyItems.DEBUG_TAME.get(), FossilsLegacyUtils.mc("item/bone"));
        this.handheldItem(FossilsLegacyItems.DEBUG_CHANGE_GENETICS.get(), FossilsLegacyUtils.mc("item/bone"));

        this.basicBlock(FossilsLegacyBlocks.FOSSIL_ORE.get());
        this.basicBlock(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.basicBlock(FossilsLegacyBlocks.SKULL_BLOCK.get());
        this.basicBlock(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        this.basicBlock(FossilsLegacyBlocks.ANALYZER.get());
        this.basicBlock(FossilsLegacyBlocks.WHITE_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.LIME_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.PINK_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.GRAY_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.CYAN_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.BLUE_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.BROWN_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.GREEN_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.RED_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.BLACK_CULTIVATOR.get());
        this.basicBlock(FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get());
        this.basicBlock(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.basicBlock(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get());
        this.basicItem(FossilsLegacyBlocks.JURASSIC_FERN.getId(), this.modLoc("block/fern_lower_3"));
        this.basicBlock(FossilsLegacyBlocks.DRUM.get(), "drum_follow");
        this.basicBlock(FossilsLegacyBlocks.FEEDER.get(), "feeder_empty");
        this.basicBlock(FossilsLegacyBlocks.PERMAFROST.get());
        this.basicBlock(FossilsLegacyBlocks.ICED_STONE.get());
        this.basicItem(FossilsLegacyItems.AXOLOTLSPAWN.get(), this.modLoc("block/axolotlspawn"));
        this.basicBlock(FossilsLegacyBlocks.TIME_MACHINE.get());
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get());
        this.basicItem(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.getId(), this.modLoc("block/lepidodendron_sapling"));
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get());
        this.basicBlock(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get());
        this.basicBlock(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get());
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get());
        this.basicItem(FossilsLegacyItems.LEPIDODENDRON_SIGN.get());
        this.basicItem(FossilsLegacyItems.LEPIDODENDRON_DOOR.get());
        this.basicItem(FossilsLegacyItems.LEPIDODENDRON_HANGING_SIGN.get());
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_PRESSURE_PLATE.get());
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get(), "lepidodendron_fence_inventory");
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get(), "lepidodendron_trapdoor_bottom");
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get());
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_BUTTON.get(), "lepidodendron_button_inventory");
        this.basicBlock(FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get());
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get());
        this.basicItem(FossilsLegacyBlocks.SIGILLARIA_SAPLING.getId(), this.modLoc("block/sigillaria_sapling"));
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_LOG.get());
        this.basicBlock(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get());
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_WOOD.get());
        this.basicBlock(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get());
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_STAIRS.get());
        this.basicItem(FossilsLegacyItems.SIGILLARIA_SIGN.get());
        this.basicItem(FossilsLegacyItems.SIGILLARIA_DOOR.get());
        this.basicItem(FossilsLegacyItems.SIGILLARIA_HANGING_SIGN.get());
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_PRESSURE_PLATE.get());
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_FENCE.get(), "sigillaria_fence_inventory");
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_TRAPDOOR.get(), "sigillaria_trapdoor_bottom");
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get());
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_BUTTON.get(), "sigillaria_button_inventory");
        this.basicBlock(FossilsLegacyBlocks.SIGILLARIA_SLAB.get());
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_PLANKS.get());
        this.basicItem(FossilsLegacyBlocks.CALAMITES_SAPLING.getId(), this.modLoc("block/calamites_sapling"));
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_LOG.get());
        this.basicBlock(FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get());
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_WOOD.get());
        this.basicBlock(FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get());
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_LEAVES.get());
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_STAIRS.get());
        this.basicItem(FossilsLegacyItems.CALAMITES_SIGN.get());
        this.basicItem(FossilsLegacyItems.CALAMITES_DOOR.get());
        this.basicItem(FossilsLegacyItems.CALAMITES_HANGING_SIGN.get());
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_PRESSURE_PLATE.get());
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_FENCE.get(), "calamites_fence_inventory");
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_TRAPDOOR.get(), "calamites_trapdoor_bottom");
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get());
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_BUTTON.get(), "calamites_button_inventory");
        this.basicBlock(FossilsLegacyBlocks.CALAMITES_SLAB.get());
    }

    public void basicBlock(Block block, String blockModel) {
        this.getBuilder(BuiltInRegistries.BLOCK.getKey(block).getPath()).parent(new ModelFile.UncheckedModelFile(this.modLoc("block/" + blockModel)));
    }

    private void armorItem(Item item, String type) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String name = id.getPath();
        this.basicItem(item).override().model(this.withExistingParent(name + "_quartz_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_quartz"))).predicate(this.mcLoc("trim_type"), 0.1F).end().override().model(this.withExistingParent(name + "_iron_darker_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_iron_darker"))).predicate(this.mcLoc("trim_type"), 0.2F).end().override().model(this.withExistingParent(name + "_netherite_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_netherite"))).predicate(this.mcLoc("trim_type"), 0.3F).end().override().model(this.withExistingParent(name + "_redstone_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_redstone"))).predicate(this.mcLoc("trim_type"), 0.4F).end().override().model(this.withExistingParent(name + "_copper_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_copper"))).predicate(this.mcLoc("trim_type"), 0.5F).end().override().model(this.withExistingParent(name + "_gold_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_gold"))).predicate(this.mcLoc("trim_type"), 0.6F).end().override().model(this.withExistingParent(name + "_emerald_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_emerald"))).predicate(this.mcLoc("trim_type"), 0.7F).end().override().model(this.withExistingParent(name + "_diamond_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_diamond"))).predicate(this.mcLoc("trim_type"), 0.8F).end().override().model(this.withExistingParent(name + "_lapis_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_lapis"))).predicate(this.mcLoc("trim_type"), 0.9F).end().override().model(this.withExistingParent(name + "_amethyst_trim", this.mcLoc("generated")).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + name)).texture("layer1", this.mcLoc("trims/items/" + type + "_trim_amethyst"))).predicate(this.mcLoc("trim_type"), 1.0F).end();
    }
}
