package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.fossilslegacy.server.tags.FAItemTags;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class FAItemTagProvider extends ItemTagsProvider {
    public FAItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId) {
        super(packOutput, provider, blockTags, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ItemTags.PLANKS).add(FAItems.ARCHAEOPTERIS_PLANKS, FAItems.LEPIDODENDRON_PLANKS, FAItems.SIGILLARIA_PLANKS, FAItems.CALAMITES_PLANKS, FAItems.GINKGO_PLANKS, FAItems.ARAUCARIA_PLANKS);
        this.tag(ItemTags.WOODEN_BUTTONS).add(FAItems.ARCHAEOPTERIS_BUTTON, FAItems.LEPIDODENDRON_BUTTON, FAItems.SIGILLARIA_BUTTON, FAItems.CALAMITES_BUTTON, FAItems.GINKGO_BUTTON, FAItems.ARAUCARIA_BUTTON);
        this.tag(ItemTags.WOODEN_DOORS).add(FAItems.ARCHAEOPTERIS_DOOR.get(), FAItems.LEPIDODENDRON_DOOR.get(), FAItems.SIGILLARIA_DOOR.get(), FAItems.CALAMITES_DOOR.get(), FAItems.GINKGO_DOOR.get(), FAItems.ARAUCARIA_DOOR.get());
        this.tag(ItemTags.WOODEN_STAIRS).add(FAItems.ARCHAEOPTERIS_STAIRS, FAItems.LEPIDODENDRON_STAIRS, FAItems.SIGILLARIA_STAIRS, FAItems.CALAMITES_STAIRS, FAItems.GINKGO_STAIRS, FAItems.ARAUCARIA_STAIRS);
        this.tag(ItemTags.WOODEN_SLABS).add(FAItems.ARCHAEOPTERIS_SLAB, FAItems.LEPIDODENDRON_SLAB, FAItems.SIGILLARIA_SLAB, FAItems.CALAMITES_SLAB, FAItems.GINKGO_SLAB, FAItems.ARAUCARIA_SLAB);
        this.tag(ItemTags.WOODEN_FENCES).add(FAItems.ARCHAEOPTERIS_FENCE, FAItems.LEPIDODENDRON_FENCE, FAItems.SIGILLARIA_FENCE, FAItems.CALAMITES_FENCE, FAItems.GINKGO_FENCE, FAItems.ARAUCARIA_FENCE);
        this.tag(Tags.Items.FENCE_GATES_WOODEN).add(FAItems.ARCHAEOPTERIS_FENCE_GATE, FAItems.LEPIDODENDRON_FENCE_GATE, FAItems.SIGILLARIA_FENCE_GATE, FAItems.CALAMITES_FENCE_GATE, FAItems.GINKGO_FENCE_GATE, FAItems.ARAUCARIA_FENCE_GATE);
        this.tag(ItemTags.SAPLINGS).add(FAItems.ARCHAEOPTERIS_SAPLING, FAItems.LEPIDODENDRON_SAPLING, FAItems.SIGILLARIA_SAPLING, FAItems.CALAMITES_SAPLING, FAItems.GINKGO_SAPLING, FAItems.ARAUCARIA_SAPLING);
        this.tag(ItemTags.LOGS_THAT_BURN).addTags(FAItemTags.ARAUCARIA_LOGS, FAItemTags.ARCHAEOPTERIS_LOGS, FAItemTags.LEPIDODENDRON_LOGS, FAItemTags.SIGILLARIA_LOGS, FAItemTags.CALAMITES_LOGS, FAItemTags.GINKGO_LOGS, FAItemTags.ARAUCARIA_LOGS);
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(FAItems.ARCHAEOPTERIS_PRESSURE_PLATE, FAItems.LEPIDODENDRON_PRESSURE_PLATE, FAItems.SIGILLARIA_PRESSURE_PLATE, FAItems.CALAMITES_PRESSURE_PLATE, FAItems.GINKGO_PRESSURE_PLATE, FAItems.ARAUCARIA_PRESSURE_PLATE);
        this.tag(ItemTags.LEAVES).add(FAItems.ARCHAEOPTERIS_LEAVES, FAItems.LEPIDODENDRON_LEAVES, FAItems.SIGILLARIA_LEAVES, FAItems.CALAMITES_LEAVES, FAItems.GINKGO_LEAVES, FAItems.ARAUCARIA_LEAVES);
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(FAItems.ARCHAEOPTERIS_TRAPDOOR, FAItems.LEPIDODENDRON_TRAPDOOR, FAItems.SIGILLARIA_TRAPDOOR, FAItems.CALAMITES_TRAPDOOR, FAItems.GINKGO_TRAPDOOR, FAItems.ARAUCARIA_TRAPDOOR);
        this.tag(ItemTags.SIGNS).add(FAItems.ARCHAEOPTERIS_SIGN.get(), FAItems.LEPIDODENDRON_SIGN.get(), FAItems.SIGILLARIA_SIGN.get(), FAItems.CALAMITES_SIGN.get(), FAItems.GINKGO_SIGN.get(), FAItems.ARAUCARIA_SIGN.get());
        this.tag(ItemTags.HANGING_SIGNS).add(FAItems.ARCHAEOPTERIS_HANGING_SIGN.get(), FAItems.LEPIDODENDRON_HANGING_SIGN.get(), FAItems.SIGILLARIA_HANGING_SIGN.get(), FAItems.CALAMITES_HANGING_SIGN.get(), FAItems.GINKGO_HANGING_SIGN.get(), FAItems.ARAUCARIA_HANGING_SIGN.get());
        this.tag(ItemTags.FENCE_GATES).add(FAItems.ARCHAEOPTERIS_FENCE_GATE, FAItems.LEPIDODENDRON_FENCE_GATE, FAItems.SIGILLARIA_FENCE_GATE, FAItems.CALAMITES_FENCE_GATE, FAItems.GINKGO_FENCE_GATE, FAItems.ARAUCARIA_FENCE_GATE);
        this.tag(ItemTags.BOATS).add(FAItems.ARAUCARIA_BOAT.get(), FAItems.ARAUCARIA_CHEST_BOAT.get(), FAItems.ARCHAEOPTERIS_BOAT.get(), FAItems.ARCHAEOPTERIS_CHEST_BOAT.get(), FAItems.LEPIDODENDRON_BOAT.get(), FAItems.LEPIDODENDRON_CHEST_BOAT.get(), FAItems.SIGILLARIA_BOAT.get(), FAItems.SIGILLARIA_CHEST_BOAT.get(), FAItems.CALAMITES_BOAT.get(), FAItems.CALAMITES_CHEST_BOAT.get(), FAItems.GINKGO_BOAT.get(), FAItems.GINKGO_CHEST_BOAT.get());
        this.tag(ItemTags.GAZE_DISGUISE_EQUIPMENT).add(FAItems.SKULL_BLOCK.get());

        this.tagEquipment(FAItems.SCARAB_GEM_SWORD.get(), FAItems.SCARAB_GEM_PICKAXE.get(), FAItems.SCARAB_GEM_AXE.get(), FAItems.SCARAB_GEM_SHOVEL.get(), FAItems.SCARAB_GEM_HOE.get(), FAItems.SCARAB_GEM_HELMET.get(), FAItems.SCARAB_GEM_CHESTPLATE.get(), FAItems.SCARAB_GEM_LEGGINGS.get(), FAItems.SCARAB_GEM_BOOTS.get());
        this.tagEquipment(FAItems.ANCIENT_SWORD.get(), FAItems.ANCIENT_PICKAXE.get(), FAItems.ANCIENT_AXE.get(), FAItems.ANCIENT_SHOVEL.get(), FAItems.ANCIENT_HOE.get(), FAItems.ANCIENT_HELMET.get(), FAItems.ANCIENT_CHESTPLATE.get(), FAItems.ANCIENT_LEGGINGS.get(), FAItems.ANCIENT_BOOTS.get());
        this.tag(Tags.Items.BUCKETS).add(FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), FAItems.COOKED_BERRY_MEDLEY_BUCKET.get(), FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), FAItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        this.tag(Tags.Items.SEEDS).add(FAItems.ARAUCARIA_CONE.get(), FAItems.ARCHAEOPTERIS_SPORE.get(), FAItems.CALAMITES_SPORE.get(), FAItems.CYCAD_CONE.get(), FAItems.GINKGO_SEED.get(), FAItems.HORSETAIL_SPORE.get(), FAItems.JURASSIC_FERN_SPORES.get(), FAItems.SIGILLARIA_SPORE.get());
        this.tag(Tags.Items.TOOLS_SHEAR).add(FAItems.THERIZINOSAURUS_CLAWS.get());
        this.tag(Tags.Items.EGGS).addTags(FAItemTags.CAKE_EGGS).add(FAItems.DODO_EGG.get(), FAItems.INCUBATED_DODO_EGG.get(), FAItems.MOA_EGG.get(), FAItems.INCUBATED_MOA_EGG.get(), FAItems.INCUBATED_CHICKEN_EGG.get(), FAItems.INCUBATED_PARROT_EGG.get());
        this.tag(Tags.Items.GEMS).add(FAItems.SCARAB_GEM.get(), FAItems.JADE.get(), FAItems.JADE_OCELOT.get(), FAItems.JADE_VILLAGER.get());
        this.tag(Tags.Items.BONES).add(FAItems.CENOZOIC_FOSSIL.get(), FAItems.MESOZOIC_FOSSIL.get(), FAItems.PALAEOZOIC_FOSSIL.get(), FAItems.PLANT_FOSSIL.get());
        this.tag(Tags.Items.RANGED_WEAPON_TOOLS).add(FAItems.WOODEN_JAVELIN.get(), FAItems.BROKEN_WOODEN_JAVELIN.get(), FAItems.STONE_JAVELIN.get(), FAItems.BROKEN_STONE_JAVELIN.get(), FAItems.GOLDEN_JAVELIN.get(), FAItems.BROKEN_GOLDEN_JAVELIN.get(), FAItems.IRON_JAVELIN.get(), FAItems.BROKEN_IRON_JAVELIN.get(), FAItems.DIAMOND_JAVELIN.get(), FAItems.BROKEN_DIAMOND_JAVELIN.get(), FAItems.NETHERITE_JAVELIN.get(), FAItems.BROKEN_NETHERITE_JAVELIN.get(), FAItems.SCARAB_GEM_JAVELIN.get(), FAItems.BROKEN_SCARAB_GEM_JAVELIN.get());
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(FAItems.WOODEN_JAVELIN.get(), FAItems.BROKEN_WOODEN_JAVELIN.get(), FAItems.STONE_JAVELIN.get(), FAItems.BROKEN_STONE_JAVELIN.get(), FAItems.GOLDEN_JAVELIN.get(), FAItems.BROKEN_GOLDEN_JAVELIN.get(), FAItems.IRON_JAVELIN.get(), FAItems.BROKEN_IRON_JAVELIN.get(), FAItems.DIAMOND_JAVELIN.get(), FAItems.BROKEN_DIAMOND_JAVELIN.get(), FAItems.NETHERITE_JAVELIN.get(), FAItems.BROKEN_NETHERITE_JAVELIN.get(), FAItems.SCARAB_GEM_JAVELIN.get(), FAItems.BROKEN_SCARAB_GEM_JAVELIN.get());
        this.tag(ItemTags.VANISHING_ENCHANTABLE).add(FAItems.WOODEN_JAVELIN.get(), FAItems.BROKEN_WOODEN_JAVELIN.get(), FAItems.STONE_JAVELIN.get(), FAItems.BROKEN_STONE_JAVELIN.get(), FAItems.GOLDEN_JAVELIN.get(), FAItems.BROKEN_GOLDEN_JAVELIN.get(), FAItems.IRON_JAVELIN.get(), FAItems.BROKEN_IRON_JAVELIN.get(), FAItems.DIAMOND_JAVELIN.get(), FAItems.BROKEN_DIAMOND_JAVELIN.get(), FAItems.NETHERITE_JAVELIN.get(), FAItems.BROKEN_NETHERITE_JAVELIN.get(), FAItems.SCARAB_GEM_JAVELIN.get(), FAItems.BROKEN_SCARAB_GEM_JAVELIN.get());
        this.tag(Tags.Items.FOODS).add(FAItems.CHICKEN_ESSENCE_BOTTLE.get(), FAItems.ROMANTIC_CONCOCTION_BOTTLE.get(), FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), FAItems.SIO_CHIU_LE.get());
        this.tag(ItemTags.WOLF_FOOD).add(FAItems.SIO_CHIU_LE.get());
        this.tag(ItemTags.MEAT).add(FAItems.SIO_CHIU_LE.get());
        this.tag(Tags.Items.FOODS_FOOD_POISONING).add(FAItems.RAW_CHICKEN_SOUP_BUCKET.get());
        this.tag(FAItemTags.CARNIVORE_FOODS).add(Items.BEEF, Items.COOKED_BEEF, Items.CHICKEN, Items.COOKED_CHICKEN, Items.MUTTON, Items.COOKED_MUTTON, Items.RABBIT, Items.COOKED_RABBIT, Items.PORKCHOP, Items.COOKED_PORKCHOP, Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON, Items.TROPICAL_FISH, FAItems.RAW_TRICERATOPS.get(), FAItems.RAW_VELOCIRAPTOR.get(), FAItems.RAW_TYRANNOSAURUS.get(), FAItems.RAW_PTERANODON.get(), FAItems.RAW_FUTABASAURUS.get(), FAItems.RAW_MOSASAURUS.get(), FAItems.RAW_STEGOSAURUS.get(), FAItems.RAW_DILOPHOSAURUS.get(), FAItems.RAW_BRACHIOSAURUS.get(), FAItems.RAW_SMILODON.get(), FAItems.RAW_MAMMOTH.get(), FAItems.RAW_CARNOTAURUS.get(), FAItems.RAW_CRYOLOPHOSAURUS.get(), FAItems.RAW_THERIZINOSAURUS.get(), FAItems.RAW_PACHYCEPHALOSAURUS.get(), FAItems.RAW_COMPSOGNATHUS.get(), FAItems.RAW_DODO.get(), FAItems.RAW_MOA.get(), FAItems.RAW_GALLIMIMUS.get(), FAItems.RAW_SPINOSAURUS.get(), FAItems.RAW_ANKYLOSAURUS.get(), FAItems.RAW_DIMETRODON.get(), FAItems.RAW_ICHTHYOSAURUS.get(), FAItems.RAW_ELASMOTHERIUM.get(), FAItems.COOKED_TRICERATOPS.get(), FAItems.COOKED_VELOCIRAPTOR.get(), FAItems.COOKED_TYRANNOSAURUS.get(), FAItems.COOKED_PTERANODON.get(), FAItems.SIO_CHIU_LE.get(), FAItems.COOKED_FUTABASAURUS.get(), FAItems.COOKED_MOSASAURUS.get(), FAItems.COOKED_STEGOSAURUS.get(), FAItems.COOKED_DILOPHOSAURUS.get(), FAItems.COOKED_BRACHIOSAURUS.get(), FAItems.COOKED_SMILODON.get(), FAItems.COOKED_MAMMOTH.get(), FAItems.COOKED_CARNOTAURUS.get(), FAItems.COOKED_CRYOLOPHOSAURUS.get(), FAItems.COOKED_THERIZINOSAURUS.get(), FAItems.COOKED_PACHYCEPHALOSAURUS.get(), FAItems.COOKED_COMPSOGNATHUS.get(), FAItems.COOKED_DODO.get(), FAItems.COOKED_MOA.get(), FAItems.COOKED_GALLIMIMUS.get(), FAItems.COOKED_SPINOSAURUS.get(), FAItems.COOKED_ANKYLOSAURUS.get(), FAItems.COOKED_DIMETRODON.get(), FAItems.COOKED_ICHTHYOSAURUS.get(), FAItems.COOKED_ELASMOTHERIUM.get());
        this.tag(FAItemTags.HERBIVORE_FOODS).add(Items.APPLE, Items.WHEAT, Items.BREAD, Items.SUGAR_CANE, Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.MELON_SLICE, Items.SWEET_BERRIES, Items.GLOW_BERRIES, Items.CARROT, Items.POTATO, Items.BAKED_POTATO, Items.BEETROOT, Items.KELP, FAItems.JURASSIC_FERN_SPORES.get(), FAItems.ARAUCARIA_CONE.get(), FAItems.ARCHAEOPTERIS_SPORE.get(), FAItems.CALAMITES_SPORE.get(), FAItems.CYCAD_CONE.get(), FAItems.GINKGO_SEED.get(), FAItems.HORSETAIL_SPORE.get(), FAItems.SIGILLARIA_SPORE.get());
        this.tag(FAItemTags.OMNIVORE_FOODS).addTags(FAItemTags.CARNIVORE_FOODS, FAItemTags.HERBIVORE_FOODS);
        this.tag(FAItemTags.PISCIVORE_FOODS).add(Items.COD, Items.COOKED_COD, Items.SALMON, Items.COOKED_SALMON, Items.TROPICAL_FISH, FAItems.SIO_CHIU_LE.get(), FAItems.NAUTILUS.get());
        this.tag(FAItemTags.MESOZOIC_FOSSIL).add(FAItems.MESOZOIC_FOSSIL.get());
        this.tag(ItemTags.SWORD_ENCHANTABLE).add(FAItems.THERIZINOSAURUS_CLAWS.get());

        this.copy(FABlockTags.ARAUCARIA_LOGS, FAItemTags.ARAUCARIA_LOGS);
        this.copy(FABlockTags.ARCHAEOPTERIS_LOGS, FAItemTags.ARCHAEOPTERIS_LOGS);
        this.copy(FABlockTags.LEPIDODENDRON_LOGS, FAItemTags.LEPIDODENDRON_LOGS);
        this.copy(FABlockTags.SIGILLARIA_LOGS, FAItemTags.SIGILLARIA_LOGS);
        this.copy(FABlockTags.CALAMITES_LOGS, FAItemTags.CALAMITES_LOGS);
        this.copy(FABlockTags.GINKGO_LOGS, FAItemTags.GINKGO_LOGS);
        this.copy(FABlockTags.CULTIVATORS, FAItemTags.CULTIVATORS);

        this.dinosaurTags(FAItems.RAW_TRICERATOPS.get(), FAItems.COOKED_TRICERATOPS.get(), FAItems.TRICERATOPS_EGG.get(), FAItems.TRICERATOPS_DNA.get(), FAItemTags.TRICERATOPS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_VELOCIRAPTOR.get(), FAItems.COOKED_VELOCIRAPTOR.get(), FAItems.VELOCIRAPTOR_EGG.get(), FAItems.VELOCIRAPTOR_DNA.get());
        this.dinosaurTags(FAItems.RAW_TYRANNOSAURUS.get(), FAItems.COOKED_TYRANNOSAURUS.get(), FAItems.TYRANNOSAURUS_EGG.get(), FAItems.TYRANNOSAURUS_DNA.get(), FAItemTags.TYRANNOSAURUS_COMMANDABLES, FAItems.SKULL_STICK.get());
        this.dinosaurTags(FAItems.RAW_PTERANODON.get(), FAItems.COOKED_PTERANODON.get(), FAItems.PTERANODON_EGG.get(), FAItems.PTERANODON_DNA.get(), FAItemTags.PTERANODON_COMMANDABLES, Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
        this.dinosaurTags(FAItems.RAW_FUTABASAURUS.get(), FAItems.COOKED_FUTABASAURUS.get(), FAItems.FUTABASAURUS_EGG.get(), FAItems.FUTABASAURUS_DNA.get());
        this.dinosaurTags(FAItems.RAW_MOSASAURUS.get(), FAItems.COOKED_MOSASAURUS.get(), FAItems.MOSASAURUS_EGG.get(), FAItems.MOSASAURUS_DNA.get());
        this.dinosaurTags(FAItems.RAW_STEGOSAURUS.get(), FAItems.COOKED_STEGOSAURUS.get(), FAItems.STEGOSAURUS_EGG.get(), FAItems.STEGOSAURUS_DNA.get(), FAItemTags.STEGOSAURUS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_DILOPHOSAURUS.get(), FAItems.COOKED_DILOPHOSAURUS.get(), FAItems.DILOPHOSAURUS_EGG.get(), FAItems.DILOPHOSAURUS_DNA.get(), FAItemTags.DILOPHOSAURUS_COMMANDABLES, Items.BONE);
        this.dinosaurTags(FAItems.RAW_BRACHIOSAURUS.get(), FAItems.COOKED_BRACHIOSAURUS.get(), FAItems.BRACHIOSAURUS_EGG.get(), FAItems.BRACHIOSAURUS_DNA.get(), FAItemTags.BRACHIOSAURUS_COMMANDABLES, Items.STICK);
        this.cenozoicTags(FAItems.RAW_SMILODON.get(), FAItems.COOKED_SMILODON.get(), FAItems.SMILODON_DNA.get());
        this.cenozoicTags(FAItems.RAW_MAMMOTH.get(), FAItems.COOKED_MAMMOTH.get(), FAItems.MAMMOTH_DNA.get(), FAItemTags.MAMMOTH_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_CARNOTAURUS.get(), FAItems.COOKED_CARNOTAURUS.get(), FAItems.CARNOTAURUS_EGG.get(), FAItems.CARNOTAURUS_DNA.get(), FAItemTags.CARNOTAURUS_COMMANDABLES, Items.BONE);
        this.dinosaurTags(FAItems.RAW_CRYOLOPHOSAURUS.get(), FAItems.COOKED_CRYOLOPHOSAURUS.get(), FAItems.CRYOLOPHOSAURUS_EGG.get(), FAItems.CRYOLOPHOSAURUS_DNA.get(), FAItemTags.CRYOLOPHOSAURUS_COMMANDABLES, Items.BONE);
        this.dinosaurTags(FAItems.RAW_THERIZINOSAURUS.get(), FAItems.COOKED_THERIZINOSAURUS.get(), FAItems.THERIZINOSAURUS_EGG.get(), FAItems.THERIZINOSAURUS_DNA.get(), FAItemTags.THERIZINOSAURUS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_PACHYCEPHALOSAURUS.get(), FAItems.COOKED_PACHYCEPHALOSAURUS.get(), FAItems.PACHYCEPHALOSAURUS_EGG.get(), FAItems.PACHYCEPHALOSAURUS_DNA.get(), FAItemTags.PACHYCEPHALOSAURUS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_COMPSOGNATHUS.get(), FAItems.COOKED_COMPSOGNATHUS.get(), FAItems.COMPSOGNATHUS_EGG.get(), FAItems.COMPSOGNATHUS_DNA.get(), FAItemTags.COMPSOGNATHUS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_MOA.get(), FAItems.COOKED_MOA.get(), FAItems.MOA_EGG.get(), FAItems.MOA_DNA.get());
        this.dinosaurTags(FAItems.RAW_GALLIMIMUS.get(), FAItems.COOKED_GALLIMIMUS.get(), FAItems.GALLIMIMUS_EGG.get(), FAItems.GALLIMIMUS_DNA.get(), FAItemTags.GALLIMIMUS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_DRYOSAURUS.get(), FAItems.COOKED_DRYOSAURUS.get(), FAItems.DRYOSAURUS_EGG.get(), FAItems.DRYOSAURUS_DNA.get(), FAItemTags.DRYOSAURUS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_SPINOSAURUS.get(), FAItems.COOKED_SPINOSAURUS.get(), FAItems.SPINOSAURUS_EGG.get(), FAItems.SPINOSAURUS_DNA.get(), FAItemTags.SPINOSAURUS_COMMANDABLES, FAItems.SKULL_STICK.get());
        this.dinosaurTags(FAItems.RAW_ANKYLOSAURUS.get(), FAItems.COOKED_ANKYLOSAURUS.get(), FAItems.ANKYLOSAURUS_EGG.get(), FAItems.ANKYLOSAURUS_DNA.get(), FAItemTags.ANKYLOSAURUS_COMMANDABLES, Items.STICK);
        this.dinosaurTags(FAItems.RAW_DIMETRODON.get(), FAItems.COOKED_DIMETRODON.get(), FAItems.DIMETRODON_EGG.get(), FAItems.DIMETRODON_DNA.get(), FAItemTags.DIMETRODON_COMMANDABLES, Items.BONE);
        this.dinosaurTags(FAItems.RAW_ICHTHYOSAURUS.get(), FAItems.COOKED_ICHTHYOSAURUS.get(), FAItems.ICHTHYOSAURUS_EGG.get(), FAItems.ICHTHYOSAURUS_DNA.get());
        this.cenozoicTags(FAItems.RAW_ELASMOTHERIUM.get(), FAItems.COOKED_ELASMOTHERIUM.get(), FAItems.ELASMOTHERIUM_DNA.get());
        this.tag(FAItemTags.DINO_EGGS).add(FAItems.TRICERATOPS_EGG.get(), FAItems.VELOCIRAPTOR_EGG.get(), FAItems.TYRANNOSAURUS_EGG.get(), FAItems.PTERANODON_EGG.get(), FAItems.NAUTILUS_EGGS.get(), FAItems.FUTABASAURUS_EGG.get(), FAItems.MOSASAURUS_EGG.get(), FAItems.STEGOSAURUS_EGG.get(), FAItems.DILOPHOSAURUS_EGG.get(), FAItems.BRACHIOSAURUS_EGG.get(), FAItems.CARNOTAURUS_EGG.get(), FAItems.CRYOLOPHOSAURUS_EGG.get(), FAItems.THERIZINOSAURUS_EGG.get(), FAItems.PACHYCEPHALOSAURUS_EGG.get(), FAItems.COMPSOGNATHUS_EGG.get(), FAItems.GALLIMIMUS_EGG.get(), FAItems.SPINOSAURUS_EGG.get(), FAItems.ANKYLOSAURUS_EGG.get(), FAItems.DIMETRODON_EGG.get(), FAItems.ICHTHYOSAURUS_EGG.get(), FAItems.DRYOSAURUS_EGG.get(), FAItems.BARYONYX_EGG.get());
        this.tag(FAItemTags.ANIMAL_DNA).add(FAItems.AXOLOTL_DNA.get(), FAItems.BARYONYX_DNA.get(), FAItems.CAT_DNA.get(), FAItems.CHICKEN_DNA.get(), FAItems.COW_DNA.get(), FAItems.DODO_DNA.get(), FAItems.DOLPHIN_DNA.get(), FAItems.DONKEY_DNA.get(), FAItems.DRYOSAURUS_DNA.get(), FAItems.FOX_DNA.get(), FAItems.FROG_DNA.get(), FAItems.GOAT_DNA.get(), FAItems.HORSE_DNA.get(), FAItems.ICHTHYOSAURUS_DNA.get(), FAItems.LLAMA_DNA.get(), FAItems.MULE_DNA.get(), FAItems.NAUTILUS_DNA.get(), FAItems.OCELOT_DNA.get(), FAItems.PANDA_DNA.get(), FAItems.PARROT_DNA.get(), FAItems.PIG_DNA.get(), FAItems.POLAR_BEAR_DNA.get(), FAItems.RABBIT_DNA.get(), FAItems.SHEEP_DNA.get(), FAItems.WOLF_DNA.get());
        this.tag(FAItemTags.PLANT_DNA).add(FAItems.ARAUCARIA_DNA.get(), FAItems.ARCHAEOPTERIS_DNA.get(), FAItems.CALAMITES_DNA.get(), FAItems.CYCAD_DNA.get(), FAItems.GINKGO_DNA.get(), FAItems.HORSETAIL_DNA.get(), FAItems.JURASSIC_FERN_DNA.get(), FAItems.LEPIDODENDRON_DNA.get(), FAItems.SIGILLARIA_DNA.get());
        this.tag(FAItemTags.DNA).addTags(FAItemTags.ANIMAL_DNA, FAItemTags.PLANT_DNA);
        this.tag(FAItemTags.EMBRYO_SYRINGES).add(FAItems.ARMADILLO_EMBRYO_SYRINGE.get(), FAItems.CAT_EMBRYO_SYRINGE.get(), FAItems.COW_EMBRYO_SYRINGE.get(), FAItems.DOLPHIN_EMBRYO_SYRINGE.get(), FAItems.DONKEY_EMBRYO_SYRINGE.get(), FAItems.FOX_EMBRYO_SYRINGE.get(), FAItems.GOAT_EMBRYO_SYRINGE.get(), FAItems.HORSE_EMBRYO_SYRINGE.get(), FAItems.LLAMA_EMBRYO_SYRINGE.get(), FAItems.MULE_EMBRYO_SYRINGE.get(), FAItems.OCELOT_EMBRYO_SYRINGE.get(), FAItems.PANDA_EMBRYO_SYRINGE.get(), FAItems.PIG_EMBRYO_SYRINGE.get(), FAItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), FAItems.RABBIT_EMBRYO_SYRINGE.get(), FAItems.SHEEP_EMBRYO_SYRINGE.get(), FAItems.WOLF_EMBRYO_SYRINGE.get(), FAItems.SMILODON_EMBRYO_SYRINGE.get(), FAItems.MAMMOTH_EMBRYO_SYRINGE.get(), FAItems.ELASMOTHERIUM_EMBRYO_SYRINGE.get());
        this.tag(FAItemTags.HAMMERS).add(FAItems.DIAMOND_HAMMER.get(), FAItems.GOLDEN_HAMMER.get(), FAItems.IRON_HAMMER.get(), FAItems.NETHERITE_HAMMER.get(), FAItems.STONE_HAMMER.get(), FAItems.WOODEN_HAMMER.get());

        this.tag(FAItemTags.DRUM_INSTRUMENT).add(Items.STICK, Items.BONE, FAItems.SKULL_STICK.get(), Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
        this.tag(FAItemTags.FROGLIGHTS).add(Items.OCHRE_FROGLIGHT, Items.PEARLESCENT_FROGLIGHT, Items.VERDANT_FROGLIGHT);
        this.tag(FAItemTags.PIGLIN_TAMING_ARMOR).add(FAItems.ANCIENT_HELMET.get(), FAItems.ANCIENT_CHESTPLATE.get(), FAItems.ANCIENT_LEGGINGS.get(), FAItems.ANCIENT_BOOTS.get());

        this.tag(FAItemTags.REPAIR_WHEN_BROKEN_IN_ARCHAEOLOGY_TABLE).add(FAItems.SCARAB_GEM_AXE.get(), FAItems.SCARAB_GEM_HOE.get(), FAItems.SCARAB_GEM_PICKAXE.get(), FAItems.SCARAB_GEM_SHOVEL.get(), FAItems.SCARAB_GEM_SWORD.get(), FAItems.BROKEN_WOODEN_JAVELIN.get(), FAItems.BROKEN_STONE_JAVELIN.get(), FAItems.BROKEN_IRON_JAVELIN.get(), FAItems.BROKEN_GOLDEN_JAVELIN.get(), FAItems.BROKEN_DIAMOND_JAVELIN.get(), FAItems.BROKEN_NETHERITE_JAVELIN.get(), FAItems.BROKEN_SCARAB_GEM_JAVELIN.get());
        this.tag(FAItemTags.SCARAB_GEM_TOOL_MATERIALS).add(FAItems.SCARAB_GEM.get());

        this.tag(FAItemTags.DARTS).add(FAItems.BLUE_TRANQUILIZER_DART.get(), FAItems.GREEN_TRANQUILIZER_DART.get(), FAItems.RED_TRANQUILIZER_DART.get());
        this.tag(FAItemTags.JADE).add(FAItems.JADE.get(), FAItems.JADE_OCELOT.get(), FAItems.JADE_VILLAGER.get());
        this.tag(FAItemTags.KEY).add(FAItems.IRON_KEY.get(), FAItems.GOLDEN_KEY.get());
        this.copy(FABlockTags.LLAMA_STATUES, FAItemTags.LLAMA_STATUES);
    }

    private void cenozoicTags(Item rawMeat, Item cookedMeat, Item dna, TagKey<Item> commandables, Item... commandableItems) {
        this.cenozoicTags(rawMeat, cookedMeat, dna, Optional.of(commandables), commandableItems);
    }

    private void cenozoicTags(Item rawMeat, Item cookedMeat, Item dna) {
        this.cenozoicTags(rawMeat, cookedMeat, dna, Optional.empty());
    }

    private void cenozoicTags(Item rawMeat, Item cookedMeat, Item dna, Optional<TagKey<Item>> commandables, Item... commandableItems) {
        this.tag(Tags.Items.FOODS).add(rawMeat, cookedMeat);
        this.tag(ItemTags.WOLF_FOOD).add(rawMeat, cookedMeat);
        this.tag(ItemTags.MEAT).add(rawMeat, cookedMeat);
        this.tag(Tags.Items.FOODS_RAW_MEAT).add(rawMeat);
        this.tag(FAItemTags.ANIMAL_DNA).add(dna);
        commandables.ifPresent(itemTagKey -> this.tag(itemTagKey).add(commandableItems));
    }

    private void dinosaurTags(Item rawMeat, Item cookedMeat, Item egg, Item dna, TagKey<Item> commandables, Item... commandableItems) {
        this.dinosaurTags(rawMeat, cookedMeat, egg, dna, Optional.of(commandables), commandableItems);
    }

    private void dinosaurTags(Item rawMeat, Item cookedMeat, Item egg, Item dna) {
        this.dinosaurTags(rawMeat, cookedMeat, egg, dna, Optional.empty());
    }

    private void dinosaurTags(Item rawMeat, Item cookedMeat, Item egg, Item dna, Optional<TagKey<Item>> commandables, Item... commandableItems) {
        this.tag(Tags.Items.FOODS).add(rawMeat, cookedMeat);
        this.tag(ItemTags.WOLF_FOOD).add(rawMeat, cookedMeat);
        this.tag(ItemTags.MEAT).add(rawMeat, cookedMeat);
        this.tag(Tags.Items.FOODS_RAW_MEAT).add(rawMeat);
        this.tag(FAItemTags.CAKE_EGGS).add(egg);
        this.tag(FAItemTags.ANIMAL_DNA).add(dna);
        commandables.ifPresent(itemTagKey -> this.tag(itemTagKey).add(commandableItems));
    }

    private void tagEquipment(Item sword, Item pickaxe, Item axe, Item shovel, Item hoe, Item helmet, Item chestplate, Item leggings, Item boots) {
        this.tag(Tags.Items.TOOLS).add(sword, pickaxe, axe, shovel, hoe);
        this.tag(Tags.Items.ENCHANTABLES).add(sword, pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots);
        this.tag(ItemTags.ARMOR_ENCHANTABLE).add(helmet, chestplate, leggings, boots);
        this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(helmet, chestplate, leggings, boots);
        this.tag(ItemTags.TRIMMABLE_ARMOR).add(helmet, chestplate, leggings, boots);
        this.tag(ItemTags.MINING_ENCHANTABLE).add(sword, pickaxe, axe, shovel, hoe);
        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(pickaxe, axe, shovel, hoe);
        this.tag(ItemTags.VANISHING_ENCHANTABLE).add(sword, pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots);
        this.tag(ItemTags.DURABILITY_ENCHANTABLE).add(sword, pickaxe, axe, shovel, hoe, helmet, chestplate, leggings, boots);
        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(sword, axe);
        this.tag(ItemTags.BREAKS_DECORATED_POTS).add(sword, axe);
        this.tag(Tags.Items.MELEE_WEAPON_TOOLS).add(sword, axe);
        this.tag(ItemTags.WEAPON_ENCHANTABLE).add(sword, axe);
        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(sword);
        this.tag(ItemTags.SWORDS).add(sword);
        this.tag(ItemTags.SWORD_ENCHANTABLE).add(sword);
        this.tag(ItemTags.PICKAXES).add(pickaxe);
        this.tag(Tags.Items.MINING_TOOL_TOOLS).add(pickaxe);
        this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(pickaxe);
        this.tag(ItemTags.SHOVELS).add(shovel);
        this.tag(ItemTags.AXES).add(axe);
        this.tag(ItemTags.HOES).add(hoe);
        this.tag(ItemTags.HEAD_ARMOR).add(helmet);
        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(helmet);
        this.tag(ItemTags.CHEST_ARMOR).add(chestplate);
        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(chestplate);
        this.tag(ItemTags.LEG_ARMOR).add(leggings);
        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(leggings);
        this.tag(ItemTags.FOOT_ARMOR).add(boots);
        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(boots);
    }
}
