package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlockTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyItemTagProvider extends ItemTagsProvider {
    public FossilsLegacyItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ItemTags.PLANKS).add(FossilsLegacyItems.LEPIDODENDRON_PLANKS);
        this.tag(ItemTags.WOODEN_BUTTONS).add(FossilsLegacyItems.LEPIDODENDRON_BUTTON);
        this.tag(ItemTags.WOODEN_DOORS).add(FossilsLegacyItems.LEPIDODENDRON_DOOR.get());
        this.tag(ItemTags.WOODEN_STAIRS).add(FossilsLegacyItems.LEPIDODENDRON_STAIRS);
        this.tag(ItemTags.WOODEN_SLABS).add(FossilsLegacyItems.LEPIDODENDRON_SLAB);
        this.tag(ItemTags.WOODEN_FENCES).add(FossilsLegacyItems.LEPIDODENDRON_FENCE);
        this.tag(ItemTags.SAPLINGS).add(FossilsLegacyItems.LEPIDODENDRON_SAPLING);
        this.tag(ItemTags.LOGS_THAT_BURN).addTags(FossilsLegacyItemTags.LEPIDODENDRON_LOGS);
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(FossilsLegacyItems.LEPIDODENDRON_PRESSURE_PLATE);
        this.tag(ItemTags.LEAVES).add(FossilsLegacyItems.LEPIDODENDRON_LEAVES);
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(FossilsLegacyItems.LEPIDODENDRON_TRAPDOOR);
        this.tag(ItemTags.SIGNS).add(FossilsLegacyItems.LEPIDODENDRON_SIGN.get());
        this.tag(ItemTags.HANGING_SIGNS).add(FossilsLegacyItems.LEPIDODENDRON_HANGING_SIGN.get());
        this.tag(ItemTags.FENCE_GATES).add(FossilsLegacyItems.LEPIDODENDRON_FENCE_GATE);

        this.tag(ItemTags.WOLF_FOOD).add(FossilsLegacyItems.RAW_TRICERATOPS.get(), FossilsLegacyItems.RAW_VELOCIRAPTOR.get(), FossilsLegacyItems.RAW_TYRANNOSAURUS.get(), FossilsLegacyItems.RAW_PTERANODON.get(), FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.RAW_FUTABASAURUS.get(), FossilsLegacyItems.RAW_MOSASAURUS.get(), FossilsLegacyItems.RAW_STEGOSAURUS.get(), FossilsLegacyItems.RAW_DILOPHOSAURUS.get(), FossilsLegacyItems.RAW_BRACHIOSAURUS.get(), FossilsLegacyItems.RAW_SMILODON.get(), FossilsLegacyItems.RAW_MAMMOTH.get(), FossilsLegacyItems.RAW_CARNOTAURUS.get(), FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.RAW_THERIZINOSAURUS.get(), FossilsLegacyItems.COOKED_TRICERATOPS.get(), FossilsLegacyItems.COOKED_VELOCIRAPTOR.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS.get(), FossilsLegacyItems.COOKED_PTERANODON.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.COOKED_FUTABASAURUS.get(), FossilsLegacyItems.COOKED_MOSASAURUS.get(), FossilsLegacyItems.COOKED_STEGOSAURUS.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS.get(), FossilsLegacyItems.COOKED_SMILODON.get(), FossilsLegacyItems.COOKED_MAMMOTH.get(), FossilsLegacyItems.COOKED_CARNOTAURUS.get(), FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS.get(), FossilsLegacyItems.COOKED_THERIZINOSAURUS.get());

        this.copy(FossilsLegacyBlockTags.LEPIDODENDRON_LOGS, FossilsLegacyItemTags.LEPIDODENDRON_LOGS);
        this.tag(FossilsLegacyItemTags.BRACHIOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.CAKE_EGGS).add(FossilsLegacyItems.TRICERATOPS_EGG.get(), FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), FossilsLegacyItems.PTERANODON_EGG.get(), FossilsLegacyItems.FUTABASAURUS_EGG.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        this.tag(FossilsLegacyItemTags.CARNOTAURUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.COMPSOGNATHUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.CRYOLOPHOSAURUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.DILOPHOSAURUS_COMMANDABLES).add(Items.BONE);
        this.tag(FossilsLegacyItemTags.DNA).add(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FROG_DNA.get(), FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.FUTABASAURUS_DNA.get(), FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.PTERANODON_DNA.get(), FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), FossilsLegacyItems.WOLF_DNA.get(), FossilsLegacyItems.CARNOTAURUS_DNA.get(), FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), FossilsLegacyItems.THERIZINOSAURUS_DNA.get());
        this.tag(FossilsLegacyItemTags.DRUM_INSTRUMENT).add(Items.STICK, Items.BONE, FossilsLegacyItems.SKULL_STICK.get(), Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
        this.tag(FossilsLegacyItemTags.FROGLIGHTS).add(Items.OCHRE_FROGLIGHT, Items.PEARLESCENT_FROGLIGHT, Items.VERDANT_FROGLIGHT);
        this.tag(FossilsLegacyItemTags.MAMMOTH_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.PACHYCEPHALOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.PIGLIN_TAMING_ARMOUR).add(FossilsLegacyItems.ANCIENT_HELMET.get(), FossilsLegacyItems.ANCIENT_CHESTPLATE.get(), FossilsLegacyItems.ANCIENT_LEGGINGS.get(), FossilsLegacyItems.ANCIENT_BOOTS.get());
        this.tag(FossilsLegacyItemTags.PTERANODON_COMMANDABLES).add(Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
        this.tag(FossilsLegacyItemTags.STEGOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.THERIZINOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.TYRANNOSAURUS_COMMANDABLES).add(FossilsLegacyItems.SKULL_STICK.get());

        this.tag(FossilsLegacyItemTags.REPAIR_WHEN_BROKEN_IN_ARCHAEOLOGY_TABLE).add(FossilsLegacyItems.SCARAB_GEM_AXE.get(), FossilsLegacyItems.SCARAB_GEM_HOE.get(), FossilsLegacyItems.SCARAB_GEM_PICKAXE.get(), FossilsLegacyItems.SCARAB_GEM_SHOVEL.get(), FossilsLegacyItems.SCARAB_GEM_SWORD.get());
    }
}
