package fossilslegacy.data;

import fossilslegacy.server.block.FossilsLegacyBlocks;
import fossilslegacy.server.item.FossilsLegacyItems;
import fossilslegacy.server.utils.FossilsLegacyUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import willatendo.simplelibrary.data.SimpleItemModelProvider;

public class FossilsLegacyItemModelProvider extends SimpleItemModelProvider {
	public FossilsLegacyItemModelProvider(PackOutput packedOutput, String modId, ExistingFileHelper existingFileHelper) {
		super(packedOutput, modId, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		this.basicItem(FossilsLegacyItems.FOSSIL.get());
		this.basicItem(FossilsLegacyItems.TRICERATOPS_DNA.get());
		this.basicItem(FossilsLegacyItems.UTAHRAPTOR_DNA.get());
		this.basicItem(FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
		this.basicItem(FossilsLegacyItems.PTEROSAURUS_DNA.get());
		this.basicItem(FossilsLegacyItems.NAUTILUS_DNA.get());
		this.basicItem(FossilsLegacyItems.PLESIOSAURUS_DNA.get());
		this.basicItem(FossilsLegacyItems.MOSASAURUS_DNA.get());
		this.basicItem(FossilsLegacyItems.STEGOSAURUS_DNA.get());
		this.basicItem(FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
		this.basicItem(FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
		this.basicItem(FossilsLegacyItems.TRICERATOPS_EGG.get());
		this.basicItem(FossilsLegacyItems.UTAHRAPTOR_EGG.get());
		this.basicItem(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
		this.basicItem(FossilsLegacyItems.PTEROSAURUS_EGG.get());
		this.basicItem(FossilsLegacyItems.NAUTILUS_EGGS.get());
		this.basicItem(FossilsLegacyItems.PLESIOSAURUS_EGG.get());
		this.basicItem(FossilsLegacyItems.MOSASAURUS_EGG.get());
		this.basicItem(FossilsLegacyItems.STEGOSAURUS_EGG.get());
		this.basicItem(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
		this.basicItem(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
		this.basicItem(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_UTAHRAPTOR_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_PTEROSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.NAUTILUS.get());
		this.basicItem(FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_SMILODON_MEAT.get());
		this.basicItem(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_UTAHRAPTOR_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_PTEROSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.SIO_CHIU_LE.get());
		this.basicItem(FossilsLegacyItems.COOKED_PLESIOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_SMILODON_MEAT.get());
		this.basicItem(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get());
		this.basicItem(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
		this.handheldItem(FossilsLegacyItems.TOOTH_DAGGER.get());
		this.handheldItem(FossilsLegacyItems.SKULL_STICK.get());
		this.basicItem(FossilsLegacyItems.DINOSAUR_ENCYCLOPEDIA.get());
		this.basicItem(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get());
		this.basicItem(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get());
		this.basicItem(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
		this.basicItem(FossilsLegacyItems.NAUTILUS_SHELL.get());
		this.handheldItem(FossilsLegacyItems.FROZEN_MEAT.get());
		this.handheldItem(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get(), this.modLoc("item/frozen_meat"));
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
		this.basicItem(FossilsLegacyItems.TURTLE_DNA.get());
		this.basicItem(FossilsLegacyItems.WOLF_DNA.get());
		this.basicItem(FossilsLegacyItems.SMILODON_DNA.get());
		this.basicItem(FossilsLegacyItems.MAMMOTH_DNA.get());
		this.basicItem(FossilsLegacyItems.AXOLOTL_EGGS.get());
		this.basicItem(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
		this.basicItem(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
		this.basicItem(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
		this.basicItem(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
		this.basicItem(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
		this.basicItem(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get());
		this.basicItem(FossilsLegacyItems.FROG_EGGS.get());
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
		this.basicItem(FossilsLegacyItems.MAGIC_CONCH.get());
		this.basicItem(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
		this.basicItem(FossilsLegacyItems.RELIC_SCRAP.get());
		this.basicItem(FossilsLegacyItems.STONE_HIEROGLYPH.get());
		this.handheldItem(FossilsLegacyItems.SWORD_ARTIFACT.get());
		this.basicItem(FossilsLegacyItems.HELMET_ARTIFACT.get());
		this.basicItem(FossilsLegacyItems.GEM_ARTIFACT.get());
		this.handheldItem(FossilsLegacyItems.ANCIENT_SWORD.get());
		this.basicItem(FossilsLegacyItems.ANCIENT_HELMET.get());
		this.handheldItem(FossilsLegacyItems.GEM_SWORD.get());
		this.handheldItem(FossilsLegacyItems.GEM_SHOVEL.get());
		this.handheldItem(FossilsLegacyItems.GEM_PICKAXE.get());
		this.handheldItem(FossilsLegacyItems.GEM_AXE.get());
		this.handheldItem(FossilsLegacyItems.GEM_HOE.get());
		this.basicItem(FossilsLegacyItems.GEM_UPGRADE_SMITHING_TEMPLATE.get());
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
		this.basicItem(FossilsLegacyItems.GEM_JAVELIN.get());
		this.basicItem(FossilsLegacyItems.BROKEN_GEM_JAVELIN.get(), this.modLoc("item/gem_javelin"));

		this.spawnEggItem(FossilsLegacyItems.ZOMBIFIED_PIGMAN_SPAWN_EGG.get());
		this.spawnEggItem(FossilsLegacyItems.DROWNED_PIRATE_SPAWN_EGG.get());
		this.spawnEggItem(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
		this.spawnEggItem(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
		this.spawnEggItem(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());

		for (RegistryObject<Block> blocks : FossilsLegacyBlocks.BLOCKS.getEntries()) {
			ResourceLocation blockId = blocks.getId();
			if (blocks.get() == FossilsLegacyBlocks.JURASSIC_FERN.get()) {
				this.handheldItem(blockId, FossilsLegacyUtils.resource("block/fern_lower_3"));
			} else {
				this.getBuilder(blockId.toString()).parent(new ModelFile.UncheckedModelFile(FossilsLegacyUtils.resource("block/" + blockId.getPath() + (blockId.getPath().contains("drum") ? "_follow" : blockId.getPath().contains("feeder") ? "_empty" : ""))));
			}
		}
	}
}
