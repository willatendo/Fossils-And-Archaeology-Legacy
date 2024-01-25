package willatendo.fossilslegacy.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntities;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class FossilsLegacyLanguageProvider extends SimpleLanguageProvider {
	public FossilsLegacyLanguageProvider(FabricDataOutput fabricDataOutput, String local) {
		super(fabricDataOutput, local);
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
		this.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.title", "Once Feared");
		this.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.desc", "Aquire a Sword Artifact.");
		this.add("advancements.fossilslegacy.legacy.ancient_sword.title", "1.21 Gigawatts!");
		this.add("advancements.fossilslegacy.legacy.ancient_sword.desc", "Repair an Ancient Sword!");
		this.add("advancements.fossilslegacy.legacy.pigman.title", "From the Dead!");
		this.add("advancements.fossilslegacy.legacy.pigman.desc", "Spawn a pigman!");
		this.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.title", "Black Magic");
		this.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.desc", "Aquire a Helmet Artifact");
		this.add("advancements.fossilslegacy.legacy.ancient_helmet.title", "Nether Connections");
		this.add("advancements.fossilslegacy.legacy.ancient_helmet.desc", "Repair an Ancient Helmet");
		this.add("advancements.fossilslegacy.legacy.tamed_pigman.title", "Till Death I'm To Serve You!");
		this.add("advancements.fossilslegacy.legacy.tamed_pigman.desc", "Spawn a tamed pigman!");
		this.add("advancements.fossilslegacy.legacy.archaeology_workbench.title", "An Archaeologist's Table!");
		this.add("advancements.fossilslegacy.legacy.archaeology_workbench.desc", "Make a Archaeology Workbench!");
		this.add("advancements.fossilslegacy.legacy.stone_tablet.title", "An Old Story");
		this.add("advancements.fossilslegacy.legacy.stone_tablet.desc", "Place a cave painting!");
		this.add("advancements.fossilslegacy.legacy.skull_block.title", "Spooky Skeletons!");
		this.add("advancements.fossilslegacy.legacy.skull_block.desc", "Or...Maybe just their skulls?");
		this.add("advancements.fossilslegacy.legacy.skeletons.title", "Real Pirates");
		this.add("advancements.fossilslegacy.legacy.skeletons.desc", "Kill a drowned pirate!");

		// Blocks
		this.add(FossilsLegacyBlocks.FOSSIL_ORE.get());
		this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
		this.add(FossilsLegacyBlocks.SKULL_BLOCK.get());
		this.add(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
		this.add(FossilsLegacyBlocks.ANALYZER.get());
		this.add(FossilsLegacyBlocks.CULTIVATOR.get());
		this.add("block.fossilslegacy.cultivator.shatter", "Warning! Cultivation falure!");
		this.add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
		this.add(FossilsLegacyBlocks.JURASSIC_FERN.get());
		this.add(FossilsLegacyBlocks.DRUM.get());
		this.add("block.fossilslegacy.drum.hit", "Set all creatures that are commanded with a %s to %s.");
		this.add(FossilsLegacyBlocks.FEEDER.get());
		this.add(FossilsLegacyBlocks.PERMAFROST.get());
		this.add(FossilsLegacyBlocks.ICED_STONE.get());
		this.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get());

		// Commands
		this.add("command.fossilslegacy.follow", "Follow");
		this.add("command.fossilslegacy.stay", "Stay");
		this.add("command.fossilslegacy.free_move", "Free Move");
		this.add("command.fossilslegacy.command.use", "Set to %s");
		this.add("command.fossilslegacy.magic_conch.use", "Set all plesiosaurs in a 30 block radius to %s.");

		// Creative Mode Tab
		this.add(FossilsLegacyCreativeModeTabs.FOSSILS_LEGACY.get(), "F/A: Legacy");

		// Deaths
		this.add("death.attack.dinosaur_starve", "%1$s starved to death");
		this.add("death.attack.dilophosaurus_envenomation", "%1$s was envenomated by %2$s");
		this.add("death.attack.javelin", "%1$s was impaled by %2$s");

		// Dinopedia
		this.add("dinopedia.fossilslegacy.able_to_fly", "Able to Fly");
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
		this.add(FossilsLegacyEntities.DILOPHOSAURUS.get());
		this.add(FossilsLegacyEntities.MAMMOTH.get());
		this.add(FossilsLegacyEntities.MOSASAURUS.get());
		this.add(FossilsLegacyEntities.NAUTILUS.get());
		this.add(FossilsLegacyEntities.PTERANODON.get());
		this.add(FossilsLegacyEntities.SMILODON.get());
		this.add(FossilsLegacyEntities.STEGOSAURUS.get());
		this.add(FossilsLegacyEntities.TRICERATOPS.get());
		this.add(FossilsLegacyEntities.TYRANNOSAURUS.get());
		this.add(FossilsLegacyEntities.VELOCIRAPTOR.get());

		this.add(FossilsLegacyEntities.EGG.get());
		this.add("entity.fossilslegacy.egg.died", "An egg was too cold and died!");
		this.add("entity.fossilslegacy.egg.died.dry", "An egg was dry and died!");
		this.add(FossilsLegacyEntities.FOSSIL.get());

		this.add(FossilsLegacyEntities.PREGNANT_CAT.get(), "Cat");
		this.add(FossilsLegacyEntities.PREGNANT_COW.get(), "Cow");
		this.add(FossilsLegacyEntities.PREGNANT_DOLPHIN.get(), "Dolphin");
		this.add(FossilsLegacyEntities.PREGNANT_DONKEY.get(), "Donkey");
		this.add(FossilsLegacyEntities.PREGNANT_FOX.get(), "Fox");
		this.add(FossilsLegacyEntities.PREGNANT_GOAT.get(), "Goat");
		this.add(FossilsLegacyEntities.PREGNANT_HORSE.get(), "Horse");
		this.add(FossilsLegacyEntities.PREGNANT_LLAMA.get(), "Llama");
		this.add(FossilsLegacyEntities.PREGNANT_MAMMOTH.get(), "Mammoth");
		this.add(FossilsLegacyEntities.PREGNANT_MULE.get(), "Mule");
		this.add(FossilsLegacyEntities.PREGNANT_OCELOT.get(), "Ocelot");
		this.add(FossilsLegacyEntities.PREGNANT_PANDA.get(), "Panda");
		this.add(FossilsLegacyEntities.PREGNANT_PIG.get(), "Pig");
		this.add(FossilsLegacyEntities.PREGNANT_POLAR_BEAR.get(), "Polar Bear");
		this.add(FossilsLegacyEntities.PREGNANT_RABBIT.get(), "Rabbit");
		this.add(FossilsLegacyEntities.PREGNANT_SHEEP.get(), "Sheep");
		this.add(FossilsLegacyEntities.PREGNANT_SMILODON.get(), "Smildon");
		this.add(FossilsLegacyEntities.PREGNANT_WOLF.get(), "Wolf");

//		this.add(FossilsLegacyEntities.ANU.get(), "Anu");
		this.add("entity.fossilslegacy.anu.speach.greetings", "Kneel down! Resistance is futile!");
		this.add("entity.fossilslegacy.anu.speach.weak_attacked", "Bare hands? Brave!");
		this.add("entity.fossilslegacy.anu.speach.threating", "Draw your sword, kid!");
		this.add("entity.fossilslegacy.anu.speach.bow_attacked", "Bow-using coward! Stop hidding!");
		this.add("entity.fossilslegacy.anu.speach.learned_here", "Look what I learned here!");
		this.add("entity.fossilslegacy.anu.speach.learned_there", "Look what I learned there!");
		this.add("entity.fossilslegacy.anu.speach.generic_ranged_attacked", "So, is that your weapon?");
		this.add("entity.fossilslegacy.anu.speach.generic_melee_attacked", "Ha! Stop Playing!");
		this.add("entity.fossilslegacy.anu.speach.summon_zombified_piglins", "Work for me, rise my servants!");
		this.add("entity.fossilslegacy.anu.speach.summon_pigs", "Brutes, wake up your wisdom!");
		this.add("entity.fossilslegacy.anu.speach.qi_shock", "Qi-shock!");
		this.add("entity.fossilslegacy.anu.speach.rain_fire", "Let's rain fire!");
		this.add(FossilsLegacyEntities.TAMED_ZOMBIFIED_PIGLIN.get(), "Zombified Piglin");
		this.add("entity.fossilslegacy.zombified_piglin.speach.anu_summon", "All hiel Anu!");
		this.add("entity.fossilslegacy.zombified_piglin.speach.sacrifice", "I cannot live without my Master!");
		this.add("entity.fossilslegacy.zombified_piglin.speach.summon", "I swear my life to %s!");
		this.add(FossilsLegacyEntities.DROWNED_PIRATE.get());

		this.add(FossilsLegacyEntities.THROWN_JAVELIN.get());
		this.add(FossilsLegacyEntities.STONE_TABLET.get());

		// Items
		this.add(FossilsLegacyItems.FOSSIL.get());
		this.add(FossilsLegacyItems.TRICERATOPS_DNA.get(), "Triceratops DNA");
		this.add(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), "Velociraptor DNA");
		this.add(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), "Tyrannosaurus DNA");
		this.add(FossilsLegacyItems.PTERANODON_DNA.get(), "Pterandon DNA");
		this.add(FossilsLegacyItems.NAUTILUS_DNA.get(), "Plesiosaurus DNA");
		this.add(FossilsLegacyItems.PLESIOSAURUS_DNA.get(), "Plesiosaurus DNA");
		this.add(FossilsLegacyItems.MOSASAURUS_DNA.get(), "Mosasaurus DNA");
		this.add(FossilsLegacyItems.STEGOSAURUS_DNA.get(), "Stegosaurus DNA");
		this.add(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), "Dilophosaurus DNA");
		this.add(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), "Brachiosaurus DNA");
		this.add(FossilsLegacyItems.TRICERATOPS_EGG.get());
		this.add(FossilsLegacyItems.VELOCIRAPTOR_EGG.get());
		this.add(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
		this.add(FossilsLegacyItems.PTERANODON_EGG.get());
		this.add(FossilsLegacyItems.NAUTILUS_EGGS.get());
		this.add(FossilsLegacyItems.PLESIOSAURUS_EGG.get());
		this.add(FossilsLegacyItems.MOSASAURUS_EGG.get());
		this.add(FossilsLegacyItems.STEGOSAURUS_EGG.get());
		this.add(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
		this.add(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
		this.add(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get());
		this.add(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get());
		this.add(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.RAW_PTERANODON_MEAT.get());
		this.add(FossilsLegacyItems.NAUTILUS.get());
		this.add(FossilsLegacyItems.RAW_PLESIOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get());
		this.add(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.RAW_SMILODON_MEAT.get());
		this.add(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_PTERANODON_MEAT.get());
		this.add(FossilsLegacyItems.SIO_CHIU_LE.get(), "Sio-Chiu-Le");
		this.add(FossilsLegacyItems.COOKED_PLESIOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_SMILODON_MEAT.get());
		this.add(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get());
		this.add(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
		this.add(FossilsLegacyItems.TOOTH_DAGGER.get());
		this.add(FossilsLegacyItems.SKULL_STICK.get());
		this.add(FossilsLegacyItems.DINOPEDIA.get());
		this.add(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), "Bucket of Raw Chicken Soup");
		this.add(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), "Bucket of Cooked Chicken Soup");
		this.add(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
		this.add(FossilsLegacyItems.NAUTILUS_SHELL.get());
		this.add(FossilsLegacyItems.MAGIC_CONCH.get());
		this.add("item.fossilslegacy.magic_conch.desc", "%s");
		this.add("item.fossilslegacy.magic_conch.use", "Set all Plesiosaurs in a 30-Block Area to %s");
		this.add(FossilsLegacyItems.FROZEN_MEAT.get());
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
		this.add(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
		this.add(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.INCUBATED_PARROT_EGG.get());
		this.add(FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get());
		this.add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
		this.add(FossilsLegacyItems.RELIC_SCRAP.get());
		this.add(FossilsLegacyItems.STONE_TABLET.get());
		this.add(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get());
		this.add(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get());
		this.add(FossilsLegacyItems.SCARAB_GEM.get());
		this.add(FossilsLegacyItems.ANCIENT_SWORD.get());
		this.add(FossilsLegacyItems.ANCIENT_HELMET.get());
		this.add(FossilsLegacyItems.SCARAB_GEM_SWORD.get());
		this.add(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get());
		this.add(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get());
		this.add(FossilsLegacyItems.SCARAB_GEM_AXE.get());
		this.add(FossilsLegacyItems.SCARAB_GEM_HOE.get());
		this.add(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), "Smithing Template");
		this.add(FossilsLegacyItems.WOODEN_JAVELIN.get());
		this.add(FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), "Wooden Javelin");
		this.add(FossilsLegacyItems.STONE_JAVELIN.get());
		this.add(FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), "Stone Javelin");
		this.add(FossilsLegacyItems.IRON_JAVELIN.get());
		this.add(FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), "Iron Javelin");
		this.add(FossilsLegacyItems.GOLDEN_JAVELIN.get());
		this.add(FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), "Golden Javelin");
		this.add(FossilsLegacyItems.DIAMOND_JAVELIN.get());
		this.add(FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), "Diamond Javelin");
		this.add(FossilsLegacyItems.NETHERITE_JAVELIN.get());
		this.add(FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), "Netherite Javelin");
		this.add(FossilsLegacyItems.SCARAB_GEM_JAVELIN.get());
		this.add(FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get(), "Scarab Gem Javelin");

		this.add(FossilsLegacyItems.DROWNED_PIRATE_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.ZOMBIFIED_PIGMAN_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());

		this.add(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.PLESIOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
		this.add(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());

		this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.applies_to", "Netherite Equipment");
		this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.ingredients", "Scarab Gem");
		this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.base_slot_description", "Add netherite weapon or tool");
		this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.additions_slot_description", "Add scarab gem");

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

		// Packs
		this.add("pack.fossilslegacy.fa_legacy_textures", "F/A Legacy Original Textures");

		// Stone Tablet
		this.add("stone_tablet.fossilslegacy.lighting.title", "Lightning");
		this.add("stone_tablet.fossilslegacy.lighting.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.social.title", "Social");
		this.add("stone_tablet.fossilslegacy.social.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.great_war.title", "Great War");
		this.add("stone_tablet.fossilslegacy.great_war.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.anu_death.title", "Anu's Death");
		this.add("stone_tablet.fossilslegacy.anu_death.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.portal.title", "Portal");
		this.add("stone_tablet.fossilslegacy.portal.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.herobrine.title", "Herobrine");
		this.add("stone_tablet.fossilslegacy.herobrine.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.skeleton_and_creeper.title", "Skeleton and Creeper");
		this.add("stone_tablet.fossilslegacy.skeleton_and_creeper.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.zombie_and_spider.title", "Zombie and Spider");
		this.add("stone_tablet.fossilslegacy.zombie_and_spider.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_in_iceberg.title", "Tyrannosaurus in Iceberg");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_in_iceberg.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_transport.title", "Tyrannosaurus Transport");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_transport.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_melt.title", "Tyrannosaurus Melt");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_melt.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_attack.title", "Tyrannosaurus Attack");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_attack.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_death.title", "Tyrannosaurus Death");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_death.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_corpse.title", "Tyrannosaurus Corpse");
		this.add("stone_tablet.fossilslegacy.tyrannosaurus_corpse.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.princess.title", "Princess");
		this.add("stone_tablet.fossilslegacy.princess.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.mosasaurus.title", "Mosasaurus");
		this.add("stone_tablet.fossilslegacy.mosasaurus.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.holy_mosasaurus.title", "Holy Mosasaurus");
		this.add("stone_tablet.fossilslegacy.holy_mosasaurus.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.past.title", "Past");
		this.add("stone_tablet.fossilslegacy.past.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.time_machine.title", "Time Machine");
		this.add("stone_tablet.fossilslegacy.time_machine.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.future.title", "Future");
		this.add("stone_tablet.fossilslegacy.future.author", "Kajun");
		this.add("stone_tablet.fossilslegacy.random", "Random variant");

		// Sounds
		this.add("sound.fossilslegacy.brachiosaurus.ambient", "Brachiosaurus Calls");
		this.add("sound.fossilslegacy.brachiosaurus.hurt", "Brachiosaurus Hurts");
		this.add("sound.fossilslegacy.brachiosaurus.death", "Brachiosaurus Dies");
		this.add("sound.fossilslegacy.dilophosaurus.ambient", "Dilophosaurus Hisses");
		this.add("sound.fossilslegacy.dilophosaurus.call", "Dilophosaurus Calls");
		this.add("sound.fossilslegacy.dilophosaurus.hurt", "Dilophosaurus Hurts");
		this.add("sound.fossilslegacy.dilophosaurus.death", "Dilophosaurus Dies");
		this.add("sound.fossilslegacy.drum.hit", "Drum Hit");
		this.add("sound.fossilslegacy.drum.triple_hit", "Drum Triple Hit");
		this.add("sound.fossilslegacy.mammoth.ambient", "Mammoth Trumpets");
		this.add("sound.fossilslegacy.mammoth.hurt", "Mammoth Hurts");
		this.add("sound.fossilslegacy.mammoth.death", "Mammoth Dies");
		this.add("sound.fossilslegacy.plesiosaurus.ambient", "Plesiosaurus Chirps");
		this.add("sound.fossilslegacy.plesiosaurus.hurt", "Plesiosaurus Hurts");
		this.add("sound.fossilslegacy.plesiosaurus.death", "Plesiosaurus Dies");
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
		this.add("upgrade.fossilslegacy.scarab_gem_upgrade", "Scarab Gem Upgrade");
	}
}
