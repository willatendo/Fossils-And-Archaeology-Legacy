package willatendo.fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.item.FossilsLegacyItemTags;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;

public class FossilsLegacyItemTagProvider extends ItemTagsProvider {
	public FossilsLegacyItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, blockTags, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(FossilsLegacyItemTags.BRACHIOSAURUS_COMMANDABLES).add(Items.STICK);
		this.tag(FossilsLegacyItemTags.CAKE_EGGS).add(FossilsLegacyItems.TRICERATOPS_EGG.get(), FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), FossilsLegacyItems.PTEROSAURUS_EGG.get(), FossilsLegacyItems.PLESIOSAURUS_EGG.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
		this.tag(FossilsLegacyItemTags.DNA).add(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FROG_DNA.get(), FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.PLESIOSAURUS_DNA.get(), FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.PTEROSAURUS_DNA.get(), FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TURTLE_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), FossilsLegacyItems.WOLF_DNA.get());
		this.tag(FossilsLegacyItemTags.DRUM_INSTRUMENT).add(Items.STICK, Items.BONE, FossilsLegacyItems.SKULL_STICK.get(), Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
		this.tag(FossilsLegacyItemTags.PIGLIN_TAMING_HELMETS).add(FossilsLegacyItems.ANCIENT_HELMET.get());
		this.tag(FossilsLegacyItemTags.PTERANODON_COMMANDABLES).add(Items.ARROW, Items.SPECTRAL_ARROW, Items.TIPPED_ARROW);
		this.tag(FossilsLegacyItemTags.STEGOSAURUS_COMMANDABLES).add(Items.STICK);
		this.tag(FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES).add(Items.STICK);
		this.tag(FossilsLegacyItemTags.TYRANNOSAURUS_COMMANDABLES).add(FossilsLegacyItems.SKULL_STICK.get());
	}
}
