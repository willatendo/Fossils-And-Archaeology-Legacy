package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyItemTagProvider extends ItemTagsProvider {
    public FossilsLegacyItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, blockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ItemTags.WOLF_FOOD).add(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get(), FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.RAW_PTERANODON_MEAT.get(), FossilsLegacyItems.NAUTILUS.get(), FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get(), FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.RAW_SMILODON_MEAT.get(), FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), FossilsLegacyItems.RAW_CARNOTAURUS_MEAT.get(), FossilsLegacyItems.RAW_CRYOLOPHOSAURUS_MEAT.get(), FossilsLegacyItems.RAW_THERIZINOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get(), FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get(), FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_PTERANODON_MEAT.get(), FossilsLegacyItems.SIO_CHIU_LE.get(), FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get(), FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get(), FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_SMILODON_MEAT.get(), FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get(), FossilsLegacyItems.COOKED_CARNOTAURUS_MEAT.get(), FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS_MEAT.get(), FossilsLegacyItems.COOKED_THERIZINOSAURUS_MEAT.get());
        this.tag(FossilsLegacyItemTags.BRACHIOSAURUS_COMMANDABLES).add(Items.STICK);
        this.tag(FossilsLegacyItemTags.CAKE_EGGS).add(FossilsLegacyItems.TRICERATOPS_EGG.get(), FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), FossilsLegacyItems.PTERANODON_EGG.get(), FossilsLegacyItems.FUTABASAURUS_EGG.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        this.tag(FossilsLegacyItemTags.CARNOTAURUS_COMMANDABLES).add(Items.BONE);
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
