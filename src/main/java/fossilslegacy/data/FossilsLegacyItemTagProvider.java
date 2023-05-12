package fossilslegacy.data;

import java.util.concurrent.CompletableFuture;

import fossilslegacy.server.item.FossilsLegacyItemTags;
import fossilslegacy.server.item.FossilsLegacyItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FossilsLegacyItemTagProvider extends ItemTagsProvider {
	public FossilsLegacyItemTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, CompletableFuture<TagLookup<Block>> blockTags, String modId, ExistingFileHelper existingFileHelper) {
		super(packOutput, provider, blockTags, modId, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(FossilsLegacyItemTags.CAKE_EGGS).add(FossilsLegacyItems.TRICERATOPS_EGG.get(), FossilsLegacyItems.UTAHRAPTOR_EGG.get(), FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), FossilsLegacyItems.PTEROSAURUS_EGG.get(), FossilsLegacyItems.PLESIOSAURUS_EGG.get(), FossilsLegacyItems.MOSASAURUS_EGG.get(), FossilsLegacyItems.STEGOSAURUS_EGG.get(), FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
		this.tag(FossilsLegacyItemTags.DNA).add(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FROG_DNA.get(), FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.PLESIOSAURUS_DNA.get(), FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.PTEROSAURUS_DNA.get(), FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TURTLE_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.UTAHRAPTOR_DNA.get(), FossilsLegacyItems.WOLF_DNA.get());
		this.tag(FossilsLegacyItemTags.DRUM_INSTRUMENT).add(Items.STICK, Items.BONE, FossilsLegacyItems.SKULL_STICK.get());
		this.tag(FossilsLegacyItemTags.HIGH_CHANCE_FOSSIL_OUTPUTS).add(Items.BONE_MEAL, FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
		this.tag(FossilsLegacyItemTags.LOW_CHANCE_FOSSIL_OUTPUTS).add(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), FossilsLegacyItems.MOSASAURUS_DNA.get(), FossilsLegacyItems.NAUTILUS_DNA.get(), FossilsLegacyItems.PLESIOSAURUS_DNA.get(), FossilsLegacyItems.PTEROSAURUS_DNA.get(), FossilsLegacyItems.STEGOSAURUS_DNA.get(), FossilsLegacyItems.TRICERATOPS_DNA.get(), FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), FossilsLegacyItems.UTAHRAPTOR_DNA.get());
		this.tag(FossilsLegacyItemTags.FROZEN_MEAT_OUTPUTS).add(FossilsLegacyItems.AXOLOTL_DNA.get(), FossilsLegacyItems.CAT_DNA.get(), FossilsLegacyItems.CHICKEN_DNA.get(), FossilsLegacyItems.COW_DNA.get(), FossilsLegacyItems.DOLPHIN_DNA.get(), FossilsLegacyItems.DONKEY_DNA.get(), FossilsLegacyItems.FOX_DNA.get(), FossilsLegacyItems.FROG_DNA.get(), FossilsLegacyItems.GOAT_DNA.get(), FossilsLegacyItems.HORSE_DNA.get(), FossilsLegacyItems.LLAMA_DNA.get(), FossilsLegacyItems.MAMMOTH_DNA.get(), FossilsLegacyItems.MULE_DNA.get(), FossilsLegacyItems.OCELOT_DNA.get(), FossilsLegacyItems.PANDA_DNA.get(), FossilsLegacyItems.PARROT_DNA.get(), FossilsLegacyItems.PIG_DNA.get(), FossilsLegacyItems.POLAR_BEAR_DNA.get(), FossilsLegacyItems.RABBIT_DNA.get(), FossilsLegacyItems.SHEEP_DNA.get(), FossilsLegacyItems.SMILODON_DNA.get(), FossilsLegacyItems.TURTLE_DNA.get(), FossilsLegacyItems.WOLF_DNA.get(), Items.BEEF, Items.PORKCHOP, Items.MUTTON, Items.RABBIT, Items.RABBIT_FOOT, Items.CHICKEN, Items.COD, Items.SALMON, Items.TROPICAL_FISH, Items.PUFFERFISH);
		this.tag(FossilsLegacyItemTags.BEEF_OUTPUTS).add(FossilsLegacyItems.COW_DNA.get());
		this.tag(FossilsLegacyItemTags.PORKCHOP_OUTPUTS).add(FossilsLegacyItems.PIG_DNA.get());
		this.tag(FossilsLegacyItemTags.MUTTON_OUTPUTS).add(FossilsLegacyItems.SHEEP_DNA.get());
		this.tag(FossilsLegacyItemTags.CHICKEN_OUTPUTS).add(FossilsLegacyItems.CHICKEN_DNA.get());
		this.tag(FossilsLegacyItemTags.RABBIT_OUTPUTS).add(FossilsLegacyItems.RABBIT_DNA.get());
		this.tag(FossilsLegacyItemTags.TRICERATOPS_MEAT_OUTPUTS).add(FossilsLegacyItems.TRICERATOPS_DNA.get());
		this.tag(FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES).add(Items.STICK);
		this.tag(FossilsLegacyItemTags.UTAHRAPTOR_MEAT_OUTPUTS).add(FossilsLegacyItems.UTAHRAPTOR_DNA.get());
		this.tag(FossilsLegacyItemTags.TYRANNOSAURUS_MEAT_OUTPUTS).add(FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
		this.tag(FossilsLegacyItemTags.PTEROSAURUS_MEAT_OUTPUTS).add(FossilsLegacyItems.PTEROSAURUS_DNA.get());
		this.tag(FossilsLegacyItemTags.PLESIOSAURUS_MEAT_OUTPUTS).add(FossilsLegacyItems.PLESIOSAURUS_DNA.get());
		this.tag(FossilsLegacyItemTags.MOSASAURUS_MEAT_OUTPUTS).add(FossilsLegacyItems.MOSASAURUS_DNA.get());
		this.tag(FossilsLegacyItemTags.STEGOSAURUS_MEAT_OUTPUTS).add(FossilsLegacyItems.STEGOSAURUS_DNA.get());
		this.tag(FossilsLegacyItemTags.DILOPHOSAURUS_MEAT_OUTPUTS).add(FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
		this.tag(FossilsLegacyItemTags.BRACHIOSAURUS_MEAT_OUTPUTS).add(FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
		this.tag(FossilsLegacyItemTags.SMILODON_MEAT_OUTPUTS).add(FossilsLegacyItems.SMILODON_DNA.get());
		this.tag(FossilsLegacyItemTags.MAMMOTH_MEAT_OUTPUTS).add(FossilsLegacyItems.MAMMOTH_DNA.get());
		this.tag(FossilsLegacyItemTags.HIGH_CHANCE_RELIC_SCRAP_OUTPUTS).add(FossilsLegacyItems.STONE_HIEROGLYPH.get(), Items.GRAVEL, Items.FLINT);
		this.tag(FossilsLegacyItemTags.LOW_CHANCE_RELIC_SCRAP_OUTPUTS).add(FossilsLegacyItems.HELMET_ARTIFACT.get(), FossilsLegacyItems.SWORD_ARTIFACT.get());
		this.tag(FossilsLegacyItemTags.PIGLIN_TAMER).add(FossilsLegacyItems.ANCIENT_HELMET.get());
	}
}
