package willatendo.fossilslegacy.data.model;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import willatendo.fossilslegacy.client.model.ArticulatedFossilSpecialRenderer;
import willatendo.fossilslegacy.data.FAModelTemplates;
import willatendo.fossilslegacy.server.item.FAEquipmentAssets;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.utils.FAUtils;
import willatendo.simplelibrary.data.model.SimpleItemModelGenerator;

public class FAItemModelGenerator extends SimpleItemModelGenerator {
    public FAItemModelGenerator(ItemModelGenerators itemModelGenerators) {
        super(itemModelGenerators, FAUtils.ID);
    }

    @Override
    public void run() {
        this.generatedItem(FAItems.FOSSIL.get());
        this.generatedItem(FAItems.TRICERATOPS_DNA.get());
        this.generatedItem(FAItems.VELOCIRAPTOR_DNA.get());
        this.generatedItem(FAItems.TYRANNOSAURUS_DNA.get());
        this.generatedItem(FAItems.PTERANODON_DNA.get());
        this.generatedItem(FAItems.NAUTILUS_DNA.get());
        this.generatedItem(FAItems.FUTABASAURUS_DNA.get());
        this.generatedItem(FAItems.MOSASAURUS_DNA.get());
        this.generatedItem(FAItems.STEGOSAURUS_DNA.get());
        this.generatedItem(FAItems.DILOPHOSAURUS_DNA.get());
        this.generatedItem(FAItems.BRACHIOSAURUS_DNA.get());
        this.generatedItem(FAItems.CARNOTAURUS_DNA.get());
        this.generatedItem(FAItems.CRYOLOPHOSAURUS_DNA.get());
        this.generatedItem(FAItems.THERIZINOSAURUS_DNA.get());
        this.generatedItem(FAItems.PACHYCEPHALOSAURUS_DNA.get());
        this.generatedItem(FAItems.COMPSOGNATHUS_DNA.get());
        this.generatedItem(FAItems.GALLIMIMUS_DNA.get());
        this.generatedItem(FAItems.SPINOSAURUS_DNA.get());
        this.generatedItem(FAItems.ANKYLOSAURUS_DNA.get());
        this.generatedItem(FAItems.DIMETRODON_DNA.get());
        this.generatedItem(FAItems.JURASSIC_FERN_DNA.get());
        this.generatedItem(FAItems.LEPIDODENDRON_DNA.get());
        this.generatedItem(FAItems.SIGILLARIA_DNA.get());
        this.generatedItem(FAItems.CALAMITES_DNA.get());
        this.generatedItem(FAItems.TRICERATOPS_EGG.get());
        this.generatedItem(FAItems.VELOCIRAPTOR_EGG.get());
        this.generatedItem(FAItems.TYRANNOSAURUS_EGG.get());
        this.generatedItem(FAItems.PTERANODON_EGG.get());
        this.generatedItem(FAItems.NAUTILUS_EGGS.get());
        this.generatedItem(FAItems.FUTABASAURUS_EGG.get());
        this.generatedItem(FAItems.MOSASAURUS_EGG.get());
        this.generatedItem(FAItems.STEGOSAURUS_EGG.get());
        this.generatedItem(FAItems.DILOPHOSAURUS_EGG.get());
        this.generatedItem(FAItems.BRACHIOSAURUS_EGG.get());
        this.generatedItem(FAItems.CARNOTAURUS_EGG.get());
        this.generatedItem(FAItems.CRYOLOPHOSAURUS_EGG.get());
        this.generatedItem(FAItems.THERIZINOSAURUS_EGG.get());
        this.generatedItem(FAItems.PACHYCEPHALOSAURUS_EGG.get());
        this.generatedItem(FAItems.COMPSOGNATHUS_EGG.get());
        this.generatedItem(FAItems.GALLIMIMUS_EGG.get());
        this.generatedItem(FAItems.SPINOSAURUS_EGG.get());
        this.generatedItem(FAItems.ANKYLOSAURUS_EGG.get());
        this.generatedItem(FAItems.DIMETRODON_EGG.get());
        this.generatedItem(FAItems.RAW_TRICERATOPS.get());
        this.generatedItem(FAItems.RAW_VELOCIRAPTOR.get());
        this.generatedItem(FAItems.RAW_TYRANNOSAURUS.get());
        this.generatedItem(FAItems.RAW_PTERANODON.get());
        this.generatedItem(FAItems.NAUTILUS.get());
        this.generatedItem(FAItems.RAW_FUTABASAURUS.get());
        this.generatedItem(FAItems.RAW_MOSASAURUS.get());
        this.generatedItem(FAItems.RAW_STEGOSAURUS.get());
        this.generatedItem(FAItems.RAW_DILOPHOSAURUS.get());
        this.generatedItem(FAItems.RAW_BRACHIOSAURUS.get());
        this.generatedItem(FAItems.RAW_SMILODON.get());
        this.generatedItem(FAItems.RAW_MAMMOTH.get());
        this.generatedItem(FAItems.RAW_CARNOTAURUS.get());
        this.generatedItem(FAItems.RAW_CRYOLOPHOSAURUS.get());
        this.generatedItem(FAItems.RAW_THERIZINOSAURUS.get());
        this.generatedItem(FAItems.RAW_PACHYCEPHALOSAURUS.get());
        this.generatedItem(FAItems.RAW_COMPSOGNATHUS.get());
        this.generatedItem(FAItems.RAW_DODO.get());
        this.generatedItem(FAItems.RAW_MOA.get());
        this.generatedItem(FAItems.RAW_GALLIMIMUS.get());
        this.generatedItem(FAItems.RAW_SPINOSAURUS.get());
        this.generatedItem(FAItems.RAW_ANKYLOSAURUS.get());
        this.generatedItem(FAItems.RAW_DIMETRODON.get());
        this.generatedItem(FAItems.COOKED_TRICERATOPS.get());
        this.generatedItem(FAItems.COOKED_VELOCIRAPTOR.get());
        this.generatedItem(FAItems.COOKED_TYRANNOSAURUS.get());
        this.generatedItem(FAItems.COOKED_PTERANODON.get());
        this.generatedItem(FAItems.SIO_CHIU_LE.get());
        this.generatedItem(FAItems.COOKED_FUTABASAURUS.get());
        this.generatedItem(FAItems.COOKED_MOSASAURUS.get());
        this.generatedItem(FAItems.COOKED_STEGOSAURUS.get());
        this.generatedItem(FAItems.COOKED_DILOPHOSAURUS.get());
        this.generatedItem(FAItems.COOKED_BRACHIOSAURUS.get());
        this.generatedItem(FAItems.COOKED_SMILODON.get());
        this.generatedItem(FAItems.COOKED_MAMMOTH.get());
        this.generatedItem(FAItems.COOKED_CARNOTAURUS.get());
        this.generatedItem(FAItems.COOKED_CRYOLOPHOSAURUS.get());
        this.generatedItem(FAItems.COOKED_THERIZINOSAURUS.get());
        this.generatedItem(FAItems.COOKED_PACHYCEPHALOSAURUS.get());
        this.generatedItem(FAItems.COOKED_COMPSOGNATHUS.get());
        this.generatedItem(FAItems.COOKED_DODO.get());
        this.generatedItem(FAItems.COOKED_MOA.get());
        this.generatedItem(FAItems.COOKED_GALLIMIMUS.get());
        this.generatedItem(FAItems.COOKED_SPINOSAURUS.get());
        this.generatedItem(FAItems.COOKED_ANKYLOSAURUS.get());
        this.generatedItem(FAItems.COOKED_DIMETRODON.get());
        this.generatedItem(FAItems.TYRANNOSAURUS_TOOTH.get());
        this.handheldItem(FAItems.TOOTH_DAGGER.get());
        this.generateTherizinosaurusClaw(itemModelGenerators, FAItems.THERIZINOSAURUS_CLAWS.get());
        this.handheldItem(FAItems.SKULL_STICK.get());
        this.generatedItem(FAItems.DINOPEDIA.get());
        this.generatedItem(FAItems.RAW_CHICKEN_SOUP_BUCKET.get());
        this.generatedItem(FAItems.RAW_BERRY_MEDLEY_BUCKET.get());
        this.generatedItem(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        this.generatedItem(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get());
        this.generatedItem(FAItems.CHICKEN_ESSENCE_BOTTLE.get());
        this.generatedItem(FAItems.ROMANTIC_CONCOCTION_BOTTLE.get());
        this.handheldItem(FAItems.LEGACY_GENETIC_CODE.get());
        this.generatedItem(FAItems.NAUTILUS_SHELL.get());
        this.handheldItem(FAItems.FROZEN_MEAT.get());
        this.handheldItem(FAItems.BROKEN_FROZEN_MEAT.get(), this.modLocation("item/frozen_meat"));
        this.generatedItem(FAItems.ARMADILLO_DNA.get());
        this.generatedItem(FAItems.AXOLOTL_DNA.get());
        this.generatedItem(FAItems.CAT_DNA.get());
        this.generatedItem(FAItems.CHICKEN_DNA.get());
        this.generatedItem(FAItems.COW_DNA.get());
        this.generatedItem(FAItems.DOLPHIN_DNA.get());
        this.generatedItem(FAItems.DONKEY_DNA.get());
        this.generatedItem(FAItems.FOX_DNA.get());
        this.generatedItem(FAItems.FROG_DNA.get());
        this.generatedItem(FAItems.GOAT_DNA.get());
        this.generatedItem(FAItems.HORSE_DNA.get());
        this.generatedItem(FAItems.LLAMA_DNA.get());
        this.generatedItem(FAItems.MULE_DNA.get());
        this.generatedItem(FAItems.OCELOT_DNA.get());
        this.generatedItem(FAItems.PANDA_DNA.get());
        this.generatedItem(FAItems.PARROT_DNA.get());
        this.generatedItem(FAItems.PIG_DNA.get());
        this.generatedItem(FAItems.POLAR_BEAR_DNA.get());
        this.generatedItem(FAItems.RABBIT_DNA.get());
        this.generatedItem(FAItems.SHEEP_DNA.get());
        this.generatedItem(FAItems.WOLF_DNA.get());
        this.generatedItem(FAItems.SMILODON_DNA.get());
        this.generatedItem(FAItems.MAMMOTH_DNA.get());
        this.generatedItem(FAItems.DODO_DNA.get());
        this.generatedItem(FAItems.MOA_DNA.get());
        this.generatedItem(FAItems.ARMADILLO_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.CAT_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.INCUBATED_CHICKEN_EGG.get());
        this.generatedItem(FAItems.COW_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.DOLPHIN_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.DONKEY_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.FOX_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.GOAT_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.HORSE_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.LLAMA_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.MULE_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.OCELOT_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.PANDA_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.INCUBATED_PARROT_EGG.get());
        this.generatedItem(FAItems.PIG_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.RABBIT_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.SHEEP_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.WOLF_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.SMILODON_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.MAMMOTH_EMBRYO_SYRINGE.get());
        this.generatedItem(FAItems.INCUBATED_DODO_EGG.get());
        this.generatedItem(FAItems.INCUBATED_MOA_EGG.get());
        this.generatedItem(FAItems.DODO_EGG.get());
        this.generatedItem(FAItems.MOA_EGG.get());
        this.generatedItem(FAItems.MAGIC_CONCH.get());
        this.generatedItem(FAItems.JURASSIC_FERN_SPORES.get());
        this.item(FAItems.ARTICULATED_FOSSIL.get(), ItemModelUtils.specialModel(FAModelTemplates.TEMPLATE_ARTICULATED_FOSSIL.create(FAItems.ARTICULATED_FOSSIL.get(), new TextureMapping().put(TextureSlot.PARTICLE, this.modLocation("item/articulated_fossil")), itemModelGenerators.modelOutput), new ArticulatedFossilSpecialRenderer.Unbaked()));
        this.generatedItem(FAItems.RELIC_SCRAP.get());
        this.generatedItem(FAItems.STONE_TABLET.get());
        this.handheldItem(FAItems.ANCIENT_SWORD_ARTIFACT.get());
        this.handheldItem(FAItems.ANCIENT_SHOVEL_ARTIFACT.get());
        this.handheldItem(FAItems.ANCIENT_PICKAXE_ARTIFACT.get());
        this.handheldItem(FAItems.ANCIENT_AXE_ARTIFACT.get());
        this.handheldItem(FAItems.ANCIENT_HOE_ARTIFACT.get());
        this.generatedItem(FAItems.ANCIENT_HELMET_ARTIFACT.get());
        this.generatedItem(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get());
        this.generatedItem(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get());
        this.generatedItem(FAItems.ANCIENT_BOOTS_ARTIFACT.get());
        this.generatedItem(FAItems.SCARAB_GEM.get());
        this.generatedItem(FAItems.JADE.get());
        this.generatedItem(FAItems.JADE_OCELOT.get());
        this.generatedItem(FAItems.JADE_VILLAGER.get());
        this.generatedItem(FAItems.CODEX.get());
        this.generatedItem(FAItems.QUIPU.get());
        this.handheldItem(FAItems.ANCIENT_SWORD.get());
        this.handheldItem(FAItems.ANCIENT_SHOVEL.get());
        this.handheldItem(FAItems.ANCIENT_PICKAXE.get());
        this.handheldItem(FAItems.ANCIENT_AXE.get());
        this.handheldItem(FAItems.ANCIENT_HOE.get());
        this.helmetItem(FAItems.ANCIENT_HELMET.get(), FAEquipmentAssets.ANCIENT, false);
        this.chestplateItem(FAItems.ANCIENT_CHESTPLATE.get(), FAEquipmentAssets.ANCIENT, false);
        this.leggingsItem(FAItems.ANCIENT_LEGGINGS.get(), FAEquipmentAssets.ANCIENT, false);
        this.bootsItem(FAItems.ANCIENT_BOOTS.get(), FAEquipmentAssets.ANCIENT, false);
        this.handheldItem(FAItems.SCARAB_GEM_SWORD.get());
        this.handheldItem(FAItems.SCARAB_GEM_SHOVEL.get());
        this.handheldItem(FAItems.SCARAB_GEM_PICKAXE.get());
        this.handheldItem(FAItems.SCARAB_GEM_AXE.get());
        this.handheldItem(FAItems.SCARAB_GEM_HOE.get());
        this.helmetItem(FAItems.SCARAB_GEM_HELMET.get(), FAEquipmentAssets.SCARAB_GEM, false);
        this.chestplateItem(FAItems.SCARAB_GEM_CHESTPLATE.get(), FAEquipmentAssets.SCARAB_GEM, false);
        this.leggingsItem(FAItems.SCARAB_GEM_LEGGINGS.get(), FAEquipmentAssets.SCARAB_GEM, false);
        this.bootsItem(FAItems.SCARAB_GEM_BOOTS.get(), FAEquipmentAssets.SCARAB_GEM, false);
        this.generatedItem(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get());
        this.generatedItem(FAItems.WOODEN_JAVELIN.get());
        this.generatedItem(FAItems.BROKEN_WOODEN_JAVELIN.get(), this.modLocation("item/wooden_javelin"));
        this.generatedItem(FAItems.STONE_JAVELIN.get());
        this.generatedItem(FAItems.BROKEN_STONE_JAVELIN.get(), this.modLocation("item/stone_javelin"));
        this.generatedItem(FAItems.IRON_JAVELIN.get());
        this.generatedItem(FAItems.BROKEN_IRON_JAVELIN.get(), this.modLocation("item/iron_javelin"));
        this.generatedItem(FAItems.GOLDEN_JAVELIN.get());
        this.generatedItem(FAItems.BROKEN_GOLDEN_JAVELIN.get(), this.modLocation("item/golden_javelin"));
        this.generatedItem(FAItems.DIAMOND_JAVELIN.get());
        this.generatedItem(FAItems.BROKEN_DIAMOND_JAVELIN.get(), this.modLocation("item/diamond_javelin"));
        this.generatedItem(FAItems.NETHERITE_JAVELIN.get());
        this.generatedItem(FAItems.BROKEN_NETHERITE_JAVELIN.get(), this.modLocation("item/netherite_javelin"));
        this.generatedItem(FAItems.SCARAB_GEM_JAVELIN.get());
        this.generatedItem(FAItems.BROKEN_SCARAB_GEM_JAVELIN.get(), this.modLocation("item/scarab_gem_javelin"));
        this.generatedItem(FAItems.JEEP_1993.get());
        this.spawnEggItem(FAItems.ANU_SPAWN_EGG.get(), 0x432600, 0xa62c14);
        this.spawnEggItem(FAItems.FAILURESAURUS_SPAWN_EGG.get(), 0x51e6a5, 0x1b5128);
        this.spawnEggItem(FAItems.BRACHIOSAURUS_SPAWN_EGG.get(), 0x3b3e55, 0x7f8ba1);
        this.spawnEggItem(FAItems.DILOPHOSAURUS_SPAWN_EGG.get(), 0x686442, 0xf1bc2c);
        this.spawnEggItem(FAItems.FUTABASAURUS_SPAWN_EGG.get(), 0xca6700, 0xb92200);
        this.spawnEggItem(FAItems.MAMMOTH_SPAWN_EGG.get(), 0x3d2700, 0x211500);
        this.spawnEggItem(FAItems.MOSASAURUS_SPAWN_EGG.get(), 0x0d7346, 0xffe1a7);
        this.spawnEggItem(FAItems.NAUTILUS_SPAWN_EGG.get(), 0xc1c1c1, 0xa95453);
        this.spawnEggItem(FAItems.PTERANODON_SPAWN_EGG.get(), 0x7c5d89, 0x450e5b);
        this.spawnEggItem(FAItems.SMILODON_SPAWN_EGG.get(), 0xefa745, 0x9a6527);
        this.spawnEggItem(FAItems.STEGOSAURUS_SPAWN_EGG.get(), 0x839d00, 0x785f00);
        this.spawnEggItem(FAItems.TRICERATOPS_SPAWN_EGG.get(), 0xc2ff51, 0x638a25);
        this.spawnEggItem(FAItems.TYRANNOSAURUS_SPAWN_EGG.get(), 0x918066, 0x4f473a);
        this.spawnEggItem(FAItems.VELOCIRAPTOR_SPAWN_EGG.get(), 0x66965f, 0x884c2e);
        this.spawnEggItem(FAItems.CARNOTAURUS_SPAWN_EGG.get(), 0xbf5242, 0x371c18);
        this.spawnEggItem(FAItems.CRYOLOPHOSAURUS_SPAWN_EGG.get(), 0x547096, 0xec353c);
        this.spawnEggItem(FAItems.THERIZINOSAURUS_SPAWN_EGG.get(), 0x626c44, 0xcf561e);
        this.spawnEggItem(FAItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get(), 0xc06929, 0x2e1a0b);
        this.spawnEggItem(FAItems.COMPSOGNATHUS_SPAWN_EGG.get(), 0x2b482a, 0x172116);
        this.spawnEggItem(FAItems.DODO_SPAWN_EGG.get(), 0x5a5a5a, 0x928b81);
        this.spawnEggItem(FAItems.MOA_SPAWN_EGG.get(), 0x352a17, 0x0f0030);
        this.spawnEggItem(FAItems.GALLIMIMUS_SPAWN_EGG.get(), 0x6e4110, 0x333226);
        this.spawnEggItem(FAItems.SPINOSAURUS_SPAWN_EGG.get(), 0x26261d, 0x646552);
        this.spawnEggItem(FAItems.ANKYLOSAURUS_SPAWN_EGG.get(), 0x533a1b, 0x2d200f);
        this.spawnEggItem(FAItems.DIMETRODON_SPAWN_EGG.get(), 0x291e26, 0x4a2125);
        this.generatedItem(FAItems.LEPIDODENDRON_BOAT.get());
        this.generatedItem(FAItems.LEPIDODENDRON_CHEST_BOAT.get());
        this.generatedItem(FAItems.SIGILLARIA_BOAT.get());
        this.generatedItem(FAItems.SIGILLARIA_CHEST_BOAT.get());
        this.generatedItem(FAItems.CALAMITES_BOAT.get());
        this.generatedItem(FAItems.CALAMITES_CHEST_BOAT.get());

        this.generatedItem(FAItems.OVERWORLD_COIN.get());
        this.generatedItem(FAItems.ICE_AGE_COIN.get());
        this.generatedItem(FAItems.PREHISTORIC_COIN.get());

        this.handheldItem(FAItems.DEBUG_MAX_HUNGER.get(), this.mcLocation("item/bone"));
        this.handheldItem(FAItems.DEBUG_MAX_HEALTH.get(), this.mcLocation("item/bone"));
        this.handheldItem(FAItems.DEBUG_FULL_GROWN.get(), this.mcLocation("item/bone"));
        this.handheldItem(FAItems.DEBUG_BABY.get(), this.mcLocation("item/bone"));
        this.handheldItem(FAItems.DEBUG_TAME.get(), this.mcLocation("item/bone"));
        this.handheldItem(FAItems.DEBUG_CHANGE_GENETICS.get(), this.mcLocation("item/bone"));
    }

    private void generateTherizinosaurusClaw(ItemModelGenerators itemModelGenerators, Item therizinosaursClawItem) {
        ItemModel.Unbaked model2d = ItemModelUtils.plainModel(itemModelGenerators.createFlatItemModel(therizinosaursClawItem, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked model3d = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(therizinosaursClawItem, "_in_hand"));
        this.item(therizinosaursClawItem, ItemModelGenerators.createFlatModelDispatch(model2d, model3d));
    }
}
