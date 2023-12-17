package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class FossilsLegacyLanguageProvider extends SimpleLanguageProvider {
	public FossilsLegacyLanguageProvider(PackOutput packedOutput, String modId, String local) {
		super(packedOutput, modId, local);
	}

	@Override
	protected void addTranslations() {
		// Advancements
		this.add("advancements.fossilslegacy.anu.root.title", "Awoken");
		this.add("advancements.fossilslegacy.anu.root.desc", "Find Anu!");

		this.add("advancements.fossilslegacy.legacy.root.title", "The Legacy");
		this.add("advancements.fossilslegacy.legacy.root.desc", "Play the Fossils and Archaeology: Legacy!");
		this.add("advancements.fossilslegacy.legacy.fossil.title", "Fossils!");
		this.add("advancements.fossilslegacy.legacy.fossil.desc", "Aquire a fossil!");
		this.add("advancements.fossilslegacy.legacy.relic_scrap.title", "Old News");
		this.add("advancements.fossilslegacy.legacy.relic_scrap.desc", "Aquire a relic scrap!");
		this.add("advancements.fossilslegacy.legacy.sword_artifact.title", "Once Feared");
		this.add("advancements.fossilslegacy.legacy.sword_artifact.desc", "Aquire a Sword Artifact.");
		this.add("advancements.fossilslegacy.legacy.ancient_sword.title", "1.21 Gigawatts!");
		this.add("advancements.fossilslegacy.legacy.ancient_sword.desc", "Repair an Ancient Sword!");
		this.add("advancements.fossilslegacy.legacy.pigman.title", "From the Dead!");
		this.add("advancements.fossilslegacy.legacy.pigman.desc", "Spawn a pigman!");
		this.add("advancements.fossilslegacy.legacy.helmet_artifact.title", "Black Magic");
		this.add("advancements.fossilslegacy.legacy.helmet_artifact.desc", "Aquire a Helmet Artifact");
		this.add("advancements.fossilslegacy.legacy.ancient_helmet.title", "Nether Connections");
		this.add("advancements.fossilslegacy.legacy.ancient_helmet.desc", "Repair an Ancient Helmet");
		this.add("advancements.fossilslegacy.legacy.tamed_pigman.title", "Till Death I'm To Serve You!");
		this.add("advancements.fossilslegacy.legacy.tamed_pigman.desc", "Spawn a tamed pigman!");
		this.add("advancements.fossilslegacy.legacy.archaeology_workbench.title", "An Archaeologist's Table!");
		this.add("advancements.fossilslegacy.legacy.archaeology_workbench.desc", "Make a Archaeology Workbench!");
		this.add("advancements.fossilslegacy.legacy.stone_hieroglyph.title", "An Old Story");
		this.add("advancements.fossilslegacy.legacy.stone_hieroglyph.desc", "Place a cave painting!");
		this.add("advancements.fossilslegacy.legacy.skull_block.title", "Spooky Skeletons!");
		this.add("advancements.fossilslegacy.legacy.skull_block.desc", "Or...Maybe just their skulls?");
		this.add("advancements.fossilslegacy.legacy.skeletons.title", "Real Pirates");
		this.add("advancements.fossilslegacy.legacy.skeletons.desc", "Kill a drowned pirate!");

		// Blocks
		this.add(FossilsLegacyBlocks.FOSSIL_ORE.get(), "Fossil Ore");
		this.add(FossilsLegacyBlocks.SKULL_BLOCK.get(), "Skull Block");
		this.add(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), "Skull Lanturn Block");
		this.add(FossilsLegacyBlocks.ANALYZER.get(), "Analyzer");
		this.add("block.fossilslegacy.cultivator.shatter", "Warning! Cultivation falure!");
		this.add(FossilsLegacyBlocks.CULTIVATOR.get(), "Cultivator");
		this.add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), "Archaeology Workbench");
		this.add(FossilsLegacyBlocks.JURASSIC_FERN.get(), "Jurassic Fern");
		this.add("block.fossilslegacy.drum.hit", "Set all creatures that are commanded with a %s to %s.");
		this.add(FossilsLegacyBlocks.DRUM.get(), "Drum");
		this.add(FossilsLegacyBlocks.FEEDER.get(), "Feeder");
		this.add(FossilsLegacyBlocks.PERMAFROST.get(), "Permafrost");
		this.add(FossilsLegacyBlocks.ICED_STONE.get(), "Iced Stone");

		// Commands
		this.add("command.fossilslegacy.follow", "Follow");
		this.add("command.fossilslegacy.stay", "Stay");
		this.add("command.fossilslegacy.free_move", "Free Move");
		this.add("command.fossilslegacy.command.use", "Set to %s");
		this.add("command.fossilslegacy.magic_conch.use", "Set all plesiosaurs in a 30 block radius to %s.");

		// Creative Mode Tab
		this.add(FossilsLegacyCreativeModeTabs.FOSSILS_LEGACY.get(), "F/A: Legacy");

		// Deaths
		this.add("death.attack.javelin", "%1$s was impaled by %2$s");
		this.add("death.attack.dinosaur_starve", "%1$s starved to death");

		// Dinopedia
		this.add("dinopedia.fossilslegacy.age", "Age: %s");
		this.add("dinopedia.fossilslegacy.cold", "Cold");
		this.add("dinopedia.fossilslegacy.creature", "Creature: %s");
		this.add("dinopedia.fossilslegacy.dry", "Dry");
		this.add("dinopedia.fossilslegacy.egg", "%s Egg");
		this.add("dinopedia.fossilslegacy.embryo", "Embryo: %s");
		this.add("dinopedia.fossilslegacy.health", "Health: %s / %s");
		this.add("dinopedia.fossilslegacy.hunger", "Hunger: %s / %s");
		this.add("dinopedia.fossilslegacy.not_owner", "You Are Not the Owner");
		this.add("dinopedia.fossilslegacy.owner", "Owner: %s");
		this.add("dinopedia.fossilslegacy.pregnancy_time", "Pregnacy Time: %s");
		this.add("dinopedia.fossilslegacy.remaining_time", "Hatching Time: %s");
		this.add("dinopedia.fossilslegacy.rideable", "Rideable");
		this.add("dinopedia.fossilslegacy.temperature", "Temperature: %s");
		this.add("dinopedia.fossilslegacy.warm", "Warm");
		this.add("dinopedia.fossilslegacy.wet", "Wet");
		this.add("dinopedia.fossilslegacy.wild", "This Animal is Wild");

		// Entities
		this.add(FossilsLegacyEntities.BRACHIOSAURUS.get());
		this.add(FossilsLegacyEntities.MAMMOTH.get());
		this.add(FossilsLegacyEntities.MOSASAURUS.get());
		this.add(FossilsLegacyEntities.NAUTILUS.get());
		this.add(FossilsLegacyEntities.PTERANODON.get());
		this.add(FossilsLegacyEntities.SMILODON.get());
		this.add(FossilsLegacyEntities.STEGOSAURUS.get());
		this.add(FossilsLegacyEntities.TRICERATOPS.get());
		this.add(FossilsLegacyEntities.TYRANNOSAURUS.get());
		this.add(FossilsLegacyEntities.VELOCIRAPTOR.get());

		this.add(FossilsLegacyEntities.EGG.get(), "Egg");
		this.add("entity.fossilslegacy.egg.died", "An egg was too cold and died!");
		this.add("entity.fossilslegacy.egg.died.dry", "An egg was dry and died!");
		this.add(FossilsLegacyEntities.FOSSIL.get(), "Fossil");

		this.add(FossilsLegacyEntities.PREGNANT_CAT.get(), "Pregnant Cat");
		this.add(FossilsLegacyEntities.PREGNANT_COW.get(), "Pregnant Cow");
		this.add(FossilsLegacyEntities.PREGNANT_DOLPHIN.get(), "Pregnant Dolphin");
		this.add(FossilsLegacyEntities.PREGNANT_DONKEY.get(), "Pregnant Donkey");
		this.add(FossilsLegacyEntities.PREGNANT_FOX.get(), "Pregnant Fox");
		this.add(FossilsLegacyEntities.PREGNANT_GOAT.get(), "Pregnant Goat");
		this.add(FossilsLegacyEntities.PREGNANT_HORSE.get(), "Pregnant Horse");
		this.add(FossilsLegacyEntities.PREGNANT_LLAMA.get(), "Pregnant Llama");
		this.add(FossilsLegacyEntities.PREGNANT_MAMMOTH.get(), "Pregnant Mammoth");
		this.add(FossilsLegacyEntities.PREGNANT_MULE.get(), "Pregnant Mule");
		this.add(FossilsLegacyEntities.PREGNANT_OCELOT.get(), "Pregnant Ocelot");
		this.add(FossilsLegacyEntities.PREGNANT_PANDA.get(), "Pregnant Panda");
		this.add(FossilsLegacyEntities.PREGNANT_PIG.get(), "Pregnant Pig");
		this.add(FossilsLegacyEntities.PREGNANT_POLAR_BEAR.get(), "Pregnant Polar Bear");
		this.add(FossilsLegacyEntities.PREGNANT_RABBIT.get(), "Pregnant Rabbit");
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), "Pregnant Sheep");
		this.add(FossilsLegacyEntities.PREGNANT_SMILODON.get(), "Pregnant Smildon");
		this.add(FossilsLegacyEntities.PREGNANT_WOLF.get(), "Pregnant Wolf");

		this.add(FossilsLegacyEntities.ZOMBIFIED_PIGMAN.get(), "Zombified Pigman");
		this.add(FossilsLegacyEntities.DROWNED_PIRATE.get(), "Drowned Pirate");

		this.add(FossilsLegacyEntities.THROWN_JAVELIN.get(), "Thrown Javelin");
		this.add(FossilsLegacyEntities.STONE_HIEROGLYPH.get(), "Stone Hieroglyph");

		// Items
		this.add(FossilsLegacyItems.FOSSIL.get(), "Fossil");
		this.add(FossilsLegacyItems.TRICERATOPS_DNA.get(), "Triceratops DNA");
		this.add(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), "Velociraptor DNA");
		this.add(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), "Tyrannosaurus DNA");
		this.add(FossilsLegacyItems.PTEROSAURUS_DNA.get(), "Pterosaurus DNA");
		this.add(FossilsLegacyItems.NAUTILUS_DNA.get(), "Nautilus DNA");
		this.add(FossilsLegacyItems.PLESIOSAURUS_DNA.get(), "Plesiosaurus DNA");
		this.add(FossilsLegacyItems.MOSASAURUS_DNA.get(), "Mosasaurus DNA");
		this.add(FossilsLegacyItems.STEGOSAURUS_DNA.get(), "Stegosaurus DNA");
		this.add(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), "Dilophosaurus DNA");
		this.add(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), "Brachiosaurus DNA");
		this.add(FossilsLegacyItems.TRICERATOPS_EGG.get(), "Triceratops Egg");
		this.add(FossilsLegacyItems.VELOCIRAPTOR_EGG.get(), "Velociraptor Egg");
		this.add(FossilsLegacyItems.TYRANNOSAURUS_EGG.get(), "Tyrannosaurus Egg");
		this.add(FossilsLegacyItems.PTEROSAURUS_EGG.get(), "Pterosaurus Egg");
		this.add(FossilsLegacyItems.NAUTILUS_EGGS.get(), "Nautilus Eggs");
		this.add(FossilsLegacyItems.PLESIOSAURUS_EGG.get(), "Plesiosaurus Egg");
		this.add(FossilsLegacyItems.MOSASAURUS_EGG.get(), "Mosasaurus Egg");
		this.add(FossilsLegacyItems.STEGOSAURUS_EGG.get(), "Stegosaurus Egg");
		this.add(FossilsLegacyItems.DILOPHOSAURUS_EGG.get(), "Dilophosaurus Egg");
		this.add(FossilsLegacyItems.BRACHIOSAURUS_EGG.get(), "Brachiosaurus Egg");
		this.add(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get(), "Raw Triceratops Meat");
		this.add(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get(), "Raw Velociraptor Meat");
		this.add(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get(), "Raw Tyrannosaurus Meat");
		this.add(FossilsLegacyItems.RAW_PTEROSAURUS_MEAT.get(), "Raw Pterosaurus Meat");
		this.add(FossilsLegacyItems.NAUTILUS.get(), "Nautilus");
		this.add(FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get(), "Raw Plesiosaurus Meat");
		this.add(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get(), "Raw Mosasaurus Meat");
		this.add(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get(), "Raw Stegosaurus Meat");
		this.add(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get(), "Raw Dilophosaurus Meat");
		this.add(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get(), "Raw Brachiosaurus Meat");
		this.add(FossilsLegacyItems.RAW_SMILODON_MEAT.get(), "Raw Smilodon Meat");
		this.add(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get(), "Raw Mammoth Meat");
		this.add(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get(), "Cooked Triceratops Meat");
		this.add(FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get(), "Cooked Velociraptor Meat");
		this.add(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get(), "Cooked Tyrannosaurus Meat");
		this.add(FossilsLegacyItems.COOKED_PTEROSAURUS_MEAT.get(), "Cooked Pterosaurus Meat");
		this.add(FossilsLegacyItems.SIO_CHIU_LE.get(), "Sio-Chiu-Le");
		this.add(FossilsLegacyItems.COOKED_PLESIOSAURUS_MEAT.get(), "Cooked Plesiosaurus Meat");
		this.add(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get(), "Cooked Mosasaurus Meat");
		this.add(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get(), "Cooked Stegosaurus Meat");
		this.add(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get(), "Cooked Dilophosaurus Meat");
		this.add(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get(), "Cooked Brachiosaurus Meat");
		this.add(FossilsLegacyItems.COOKED_SMILODON_MEAT.get(), "Cooked Smilodon Meat");
		this.add(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get(), "Cooked Mammoth Meat");
		this.add(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get(), "Tyrannosarus Tooth");
		this.add(FossilsLegacyItems.TOOTH_DAGGER.get(), "Tooth Dagger");
		this.add(FossilsLegacyItems.SKULL_STICK.get(), "Skull Stick");
		this.add(FossilsLegacyItems.DINOPEDIA.get());
		this.add(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), "Bucket of Raw Chicken Soup");
		this.add(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), "Bucket of Cooked Chicken Soup");
		this.add(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get(), "Chicken Essence Bottle");
		this.add(FossilsLegacyItems.NAUTILUS_SHELL.get(), "Nautilus Shell");
		this.add(FossilsLegacyItems.MAGIC_CONCH.get(), "Magic Conch");
		this.add("item.fossilslegacy.magic_conch.desc", "%s");
		this.add(FossilsLegacyItems.FROZEN_MEAT.get(), "Frozen Meat");
		this.add(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get(), "Frozen Meat");
		this.add(FossilsLegacyItems.AXOLOTL_DNA.get(), "Axolotl DNA");
		this.add(FossilsLegacyItems.CAT_DNA.get(), "Cat DNA");
		this.add(FossilsLegacyItems.CHICKEN_DNA.get(), "Chicken DNA");
		this.add(FossilsLegacyItems.COW_DNA.get(), "Cow DNA");
		this.add(FossilsLegacyItems.DOLPHIN_DNA.get(), "Dolphin DNA");
		this.add(FossilsLegacyItems.DONKEY_DNA.get(), "Donkey DNA");
		this.add(FossilsLegacyItems.FOX_DNA.get(), "Fox DNA");
		this.add(FossilsLegacyItems.FROG_DNA.get(), "Frog DNA");
		this.add(FossilsLegacyItems.GOAT_DNA.get(), "Goat DNA");
		this.add(FossilsLegacyItems.HORSE_DNA.get(), "Horse DNA");
		this.add(FossilsLegacyItems.LLAMA_DNA.get(), "Llama DNA");
		this.add(FossilsLegacyItems.MULE_DNA.get(), "Mule DNA");
		this.add(FossilsLegacyItems.OCELOT_DNA.get(), "Ocelot DNA");
		this.add(FossilsLegacyItems.PANDA_DNA.get(), "Panda DNA");
		this.add(FossilsLegacyItems.PARROT_DNA.get(), "Parrot DNA");
		this.add(FossilsLegacyItems.PIG_DNA.get(), "Pig DNA");
		this.add(FossilsLegacyItems.POLAR_BEAR_DNA.get(), "Polar Bear DNA");
		this.add(FossilsLegacyItems.RABBIT_DNA.get(), "Rabbit DNA");
		this.add(FossilsLegacyItems.SHEEP_DNA.get(), "Sheep DNA");
		this.add(FossilsLegacyItems.TURTLE_DNA.get(), "Turtle DNA");
		this.add(FossilsLegacyItems.WOLF_DNA.get(), "Wolf DNA");
		this.add(FossilsLegacyItems.SMILODON_DNA.get(), "Smilodon DNA");
		this.add(FossilsLegacyItems.MAMMOTH_DNA.get(), "Mammoth DNA");
		this.add(FossilsLegacyItems.AXOLOTL_EGGS.get(), "Axolotl Eggs");
		this.add(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get(), "Cat Embryo Syringe");
		this.add(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get(), "Incubated Chicken Egg");
		this.add(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get(), "Cow Embryo Syringe");
		this.add(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get(), "Dolphin Embryo Syringe");
		this.add(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get(), "Donkey Embryo Syringe");
		this.add(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get(), "Fox Embryo Syringe");
		this.add(FossilsLegacyItems.FROG_EGGS.get(), "Frog Eggs");
		this.add(FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get(), "Goat Embryo Syringe");
		this.add(FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get(), "Horse Embryo Syringe");
		this.add(FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get(), "Llama Embryo Syringe");
		this.add(FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get(), "Mule Embryo Syringe");
		this.add(FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get(), "Ocelot Embryo Syringe");
		this.add(FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get(), "Panda Embryo Syringe");
		this.add(FossilsLegacyItems.INCUBATED_PARROT_EGG.get(), "Incubated Parrot Egg");
		this.add(FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get(), "Pig Embryo Syringe");
		this.add(FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get(), "Polar Bear Embryo Syringe");
		this.add(FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get(), "Rabbit Embryo Syringe");
		this.add(FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get(), "Sheep Embryo Syringe");
		this.add(FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get(), "Wolf Embryo Syringe");
		this.add(FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get(), "Smilodon Embryo Syringe");
		this.add(FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get(), "Mammoth Embryo Syringe");
		this.add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get(), "Jurassic Fern Spores");
		this.add(FossilsLegacyItems.RELIC_SCRAP.get(), "Relic Scrap");
		this.add(FossilsLegacyItems.STONE_HIEROGLYPH.get(), "Stone Hieroglyph");
		this.add(FossilsLegacyItems.SWORD_ARTIFACT.get(), "Sword Artifact");
		this.add(FossilsLegacyItems.HELMET_ARTIFACT.get(), "Helmet Artifact");
		this.add(FossilsLegacyItems.GEM_ARTIFACT.get(), "Gem Artifact");
		this.add(FossilsLegacyItems.ANCIENT_SWORD.get(), "Ancient Sword");
		this.add(FossilsLegacyItems.ANCIENT_HELMET.get(), "Ancient Helmet");
		this.add(FossilsLegacyItems.GEM_SWORD.get(), "Gem Sword");
		this.add(FossilsLegacyItems.GEM_SHOVEL.get(), "Gem Shovel");
		this.add(FossilsLegacyItems.GEM_PICKAXE.get(), "Gem Pickaxe");
		this.add(FossilsLegacyItems.GEM_AXE.get(), "Gem Axe");
		this.add(FossilsLegacyItems.GEM_HOE.get(), "Gem Hoe");
		this.add(FossilsLegacyItems.WOODEN_JAVELIN.get(), "Wooden Javelin");
		this.add(FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), "Wooden Javelin");
		this.add(FossilsLegacyItems.STONE_JAVELIN.get(), "Stone Javelin");
		this.add(FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), "Stone Javelin");
		this.add(FossilsLegacyItems.IRON_JAVELIN.get(), "Iron Javelin");
		this.add(FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), "Iron Javelin");
		this.add(FossilsLegacyItems.GOLDEN_JAVELIN.get(), "Golden Javelin");
		this.add(FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), "Golden Javelin");
		this.add(FossilsLegacyItems.DIAMOND_JAVELIN.get(), "Diamond Javelin");
		this.add(FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), "Diamond Javelin");
		this.add(FossilsLegacyItems.NETHERITE_JAVELIN.get(), "Netherite Javelin");
		this.add(FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), "Netherite Javelin");
		this.add(FossilsLegacyItems.GEM_JAVELIN.get(), "Gem Javelin");
		this.add(FossilsLegacyItems.BROKEN_GEM_JAVELIN.get(), "Gem Javelin");

		this.add(FossilsLegacyItems.DROWNED_PIRATE_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.ZOMBIFIED_PIGMAN_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());

		this.add("item.fossilslegacy.smithing_template.gem_upgrade.applies_to", "Netherite Equipment");
		this.add("item.fossilslegacy.smithing_template.gem_upgrade.ingredients", "Gem Artifact");
		this.add("item.fossilslegacy.smithing_template.gem_upgrade.base_slot_description", "Add netherite weapon or tool");
		this.add("item.fossilslegacy.smithing_template.gem_upgrade.additions_slot_description", "Add gem artifact");

		// JEI
		this.add("jei.fossilslegacy.archaeology", "Archaeology");
		this.add("jei.fossilslegacy.analyzation", "Analyzation");
		this.add("jei.fossilslegacy.cultivation", "Cultivation");
		this.add("jei.fossilslegacy.biomatter", "Biomatter");
		this.add("jei.fossilslegacy.biomatter.biomatterCount.single", "Biomatter for 1 item");
		this.add("jei.fossilslegacy.biomatter.biomatterCount", "Biomatter for %s items");

		// Menus
		this.add("menu.fossilslegacy.analyzer", "Analyzer");
		this.add("menu.fossilslegacy.archaeology_workbench", "Archaeology Workbench");
		this.add("menu.fossilslegacy.cultivator", "Cultivator");
		this.add("menu.fossilslegacy.feeder", "Feeder");

		// Stone Hieroglyph
		this.add("stone_hieroglyph.fossilslegacy.lighting.title", "Lightning");
		this.add("stone_hieroglyph.fossilslegacy.lighting.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.social.title", "Social");
		this.add("stone_hieroglyph.fossilslegacy.social.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.great_war.title", "Great War");
		this.add("stone_hieroglyph.fossilslegacy.great_war.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.anu_death.title", "Anu's Death");
		this.add("stone_hieroglyph.fossilslegacy.anu_death.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.portal.title", "Portal");
		this.add("stone_hieroglyph.fossilslegacy.portal.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.herobrine.title", "Herobrine");
		this.add("stone_hieroglyph.fossilslegacy.herobrine.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.skeleton_and_creeper.title", "Skeleton and Creeper");
		this.add("stone_hieroglyph.fossilslegacy.skeleton_and_creeper.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.zombie_and_spider.title", "Zombie and Spider");
		this.add("stone_hieroglyph.fossilslegacy.zombie_and_spider.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_in_iceberg.title", "Tyrannosaurus in Iceberg");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_in_iceberg.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_transport.title", "Tyrannosaurus Transport");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_transport.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_melt.title", "Tyrannosaurus Melt");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_melt.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_attack.title", "Tyrannosaurus Attack");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_attack.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_death.title", "Tyrannosaurus Death");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_death.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_corpse.title", "Tyrannosaurus Corpse");
		this.add("stone_hieroglyph.fossilslegacy.tyrannosaurus_corpse.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.princess.title", "Princess");
		this.add("stone_hieroglyph.fossilslegacy.princess.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.mosasaurus.title", "Mosasaurus");
		this.add("stone_hieroglyph.fossilslegacy.mosasaurus.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.holy_mosasaurus.title", "Holy Mosasaurus");
		this.add("stone_hieroglyph.fossilslegacy.holy_mosasaurus.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.past.title", "Past");
		this.add("stone_hieroglyph.fossilslegacy.past.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.time_machine.title", "Time Machine");
		this.add("stone_hieroglyph.fossilslegacy.time_machine.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.future.title", "Future");
		this.add("stone_hieroglyph.fossilslegacy.future.author", "Team July");
		this.add("stone_hieroglyph.fossilslegacy.random", "Random variant");

		// Sounds
		this.add("sound.fossilslegacy.brachiosaurus.ambient", "Brachiosaurus Calls");
		this.add("sound.fossilslegacy.brachiosaurus.hurt", "Brachiosaurus Hurts");
		this.add("sound.fossilslegacy.brachiosaurus.death", "Brachiosaurus Dies");
		this.add("sound.fossilslegacy.drum.hit", "Drum Hit");
		this.add("sound.fossilslegacy.drum.triple_hit", "Drum Triple Hit");
		this.add("sound.fossilslegacy.mammoth.ambient", "Mammoth Trumpets");
		this.add("sound.fossilslegacy.mammoth.hurt", "Mammoth Hurts");
		this.add("sound.fossilslegacy.mammoth.death", "Mammoth Dies");
		this.add("sound.fossilslegacy.pteranodon.ambient", "Pteranodon Calls");
		this.add("sound.fossilslegacy.pteranodon.hurt", "Pteranodon Hurts");
		this.add("sound.fossilslegacy.pteranodon.death", "Pteranodon Dies");
		this.add("sound.fossilslegacy.smilodon.ambient", "Smilodon Roars");
		this.add("sound.fossilslegacy.smilodon.hurt", "Smilodon Hurts");
		this.add("sound.fossilslegacy.smilodon.death", "Smilodon Dies");
		this.add("sound.fossilslegacy.stegosaurus.ambient", "Stegosaurus Calls");
		this.add("sound.fossilslegacy.stegosaurus.hurt", "Stegosaurus Hurts");
		this.add("sound.fossilslegacy.stegosaurus.death", "Stegosaurus Dies");
		this.add("sound.fossilslegacy.triceratops.ambient", "Triceratops Calls");
		this.add("sound.fossilslegacy.triceratops.hurt", "Triceratops Hurts");
		this.add("sound.fossilslegacy.triceratops.death", "Triceratops Dies");
		this.add("sound.fossilslegacy.tyrannosaurus.ambient", "Tyrannosaurus Rumbles");
		this.add("sound.fossilslegacy.tyrannosaurus.attack", "Tyrannosaurus Roars");
		this.add("sound.fossilslegacy.tyrannosaurus.hurt", "Tyrannosaurus Hurts");
		this.add("sound.fossilslegacy.tyrannosaurus.death", "Tyrannosaurus Dies");
		this.add("sound.fossilslegacy.velociraptor.ambient.tame", "Velociraptor Whines");
		this.add("sound.fossilslegacy.velociraptor.ambient.wild", "Velociraptor Hisses");
		this.add("sound.fossilslegacy.velociraptor.attack", "Velociraptor Attacks");
		this.add("sound.fossilslegacy.velociraptor.hurt", "Velociraptor Hurts");
		this.add("sound.fossilslegacy.velociraptor.death", "Velociraptor Dies");

		// Upgrades
		this.add("upgrade.fossilslegacy.gem_upgrade", "Gem Upgrade");
	}
}
