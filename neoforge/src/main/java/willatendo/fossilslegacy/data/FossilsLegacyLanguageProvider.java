package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.SpeakerType;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class FossilsLegacyLanguageProvider extends SimpleLanguageProvider {
    public FossilsLegacyLanguageProvider(PackOutput packOutput, String modId, String local) {
        super(packOutput, modId, local);
    }

    @Override
    protected void addTranslations() {
        // Advancements
        this.add("advancements.fossilslegacy.legacy.root.title", "The Legacy");
        this.add("advancements.fossilslegacy.legacy.root.description", "Play the Fossils and Archaeology: Legacy!");
        this.add("advancements.fossilslegacy.legacy.fossil.title", "Fossils!");
        this.add("advancements.fossilslegacy.legacy.fossil.description", "Acquire a fossil!");
        this.add("advancements.fossilslegacy.legacy.analyzer.title", "Analyzer!");
        this.add("advancements.fossilslegacy.legacy.analyzer.description", "Acquire an analyzer!");
        this.add("advancements.fossilslegacy.legacy.relic_scrap.title", "Old News");
        this.add("advancements.fossilslegacy.legacy.relic_scrap.description", "Acquire a relic scrap!");
        this.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.title", "Once Feared");
        this.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.description", "Acquire an ancient sword artifact!");
        this.add("advancements.fossilslegacy.legacy.ancient_sword.title", "1.21 Gigawatts!");
        this.add("advancements.fossilslegacy.legacy.ancient_sword.description", "Repair an ancient sword!");
        this.add("advancements.fossilslegacy.legacy.pigman.title", "From the Dead!");
        this.add("advancements.fossilslegacy.legacy.pigman.description", "Spawn a piglin!");
        this.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.title", "Black Magic");
        this.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.description", "Acquire an ancient helmet artifact!");
        this.add("advancements.fossilslegacy.legacy.fixed_ancient_armor.title", "Nether Connections");
        this.add("advancements.fossilslegacy.legacy.fixed_ancient_armor.description", "Repair a piece of ancient armor!");
        this.add("advancements.fossilslegacy.legacy.decked_out.title", "Decked Out!");
        this.add("advancements.fossilslegacy.legacy.decked_out.description", "Have a complete set of ancient armor!");
        this.add("advancements.fossilslegacy.legacy.tamed_pigman.title", "Till Death I'm To Serve You!");
        this.add("advancements.fossilslegacy.legacy.tamed_pigman.description", "Spawn a tamed piglin!");
        this.add("advancements.fossilslegacy.legacy.archaeology_workbench.title", "An Archaeologist's Table!");
        this.add("advancements.fossilslegacy.legacy.archaeology_workbench.description", "Make a archaeology workbench!");
        this.add("advancements.fossilslegacy.legacy.stone_tablet.title", "An Old Story");
        this.add("advancements.fossilslegacy.legacy.stone_tablet.description", "Place a stone tablet!");
        this.add("advancements.fossilslegacy.legacy.skull_block.title", "Spooky Skeletons!");
        this.add("advancements.fossilslegacy.legacy.skull_block.description", "Or...Maybe just their skulls?");
        this.add("advancements.fossilslegacy.legacy.anu.title", "The Master!");
        this.add("advancements.fossilslegacy.legacy.anu.description", "Summon Anu, the master of the zombified piglins!");
        this.add("advancements.fossilslegacy.legacy.prehistoric_coin.title", "Ticket to the Past!");
        this.add("advancements.fossilslegacy.legacy.prehistoric_coin.description", "Acquire a prehistoric coin!");
        this.add("advancements.fossilslegacy.legacy.overworld_coin.title", "Back to the Future!");
        this.add("advancements.fossilslegacy.legacy.overworld_coin.description", "Acquire an overworld coin!");
        this.add("advancements.fossilslegacy.legacy.time_machine.title", "Time Traveller!");
        this.add("advancements.fossilslegacy.legacy.time_machine.description", "Travel to the past (without art theft)!");

        // Cloth-Config
        this.add("text.autoconfig.fossilslegacy.title", "Fossils and Archaeology Legacy");

        this.add("text.autoconfig.fossilslegacy.category.client", "Client Options");
        this.add("text.autoconfig.fossilslegacy.option.client.featheredDinosaurs", "Feathered Dinosaurs");
        this.add("text.autoconfig.fossilslegacy.option.client.legacyModels", "Legacy Models");

        this.add("text.autoconfig.fossilslegacy.category.common", "Common Options");
        this.add("text.autoconfig.fossilslegacy.option.common.animalsStarve", "Animals Starve");
        this.add("text.autoconfig.fossilslegacy.option.common.animalsBreakBlocks", "Animals Break Blocks");
        this.add("text.autoconfig.fossilslegacy.option.common.animalsGrow", "Animals Grow");

        // Blocks
        this.add(FossilsLegacyBlocks.FOSSIL_ORE.get());
        this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.add(FossilsLegacyBlocks.SKULL_BLOCK.get());
        this.add(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        this.add(FossilsLegacyBlocks.ANALYZER.get());
        this.add(FossilsLegacyBlocks.WHITE_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.ORANGE_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.YELLOW_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.LIME_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.PINK_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.GRAY_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.CYAN_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.PURPLE_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.BLUE_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.BROWN_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.GREEN_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.RED_CULTIVATOR.get());
        this.add(FossilsLegacyBlocks.BLACK_CULTIVATOR.get());
        this.add("block.fossilslegacy.cultivator.shatter", "Warning! Cultivation failure!");
        this.add(FossilsLegacyBlocks.GENE_MODIFICATION_TABLE.get());
        this.add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.add(FossilsLegacyBlocks.JURASSIC_FERN.get());
        this.add(FossilsLegacyBlocks.DRUM.get());
        this.add("block.fossilslegacy.drum.hit", "Set all creatures that are commanded with a %s to %s.");
        this.add(FossilsLegacyBlocks.FEEDER.get());
        this.add(FossilsLegacyBlocks.PERMAFROST.get());
        this.add(FossilsLegacyBlocks.ICED_STONE.get());
        this.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get());
        this.add(FossilsLegacyBlocks.TIME_MACHINE.get());
        this.add(FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get());
        this.add(FossilsLegacyBlocks.COOKED_CHICKEN_SOUP_CAULDRON.get());
        this.add(FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get());
        this.add(FossilsLegacyBlocks.COOKED_BERRY_MEDLEY_CAULDRON.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get());
        this.add(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get());
        this.add(FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_SIGN.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_HANGING_SIGN.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_PRESSURE_PLATE.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_BUTTON.get());
        this.add(FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get());

        // Biomes
        this.add("biome.fossilslegacy.prehistoric_ocean", "Prehistoric Ocean");
        this.add("biome.fossilslegacy.deep_prehistoric_ocean", "Deep Prehistoric Ocean");
        this.add("biome.fossilslegacy.prehistoric_plains", "Prehistoric Plains");
        this.add("biome.fossilslegacy.prehistoric_forest", "Prehistoric Forest");
        this.add("biome.fossilslegacy.prehistoric_desert", "Prehistoric Desert");
        this.add("biome.fossilslegacy.prehistoric_jungle", "Prehistoric Jungle");
        this.add("biome.fossilslegacy.prehistoric_river", "Prehistoric River");
        this.add("biome.fossilslegacy.prehistoric_taiga", "Prehistoric Taiga");
        this.add("biome.fossilslegacy.prehistoric_swamp", "Prehistoric Swamp");
        this.add("biome.fossilslegacy.prehistoric_beach", "Prehistoric Beach");

        // Coat Types
        this.add("coatType.fossilslegacy.brachiosaurus", "Brachiosaurus (2024)");
        this.add("coatType.fossilslegacy.green_carnotaurus", "Green Carnotaurus (2011)");
        this.add("coatType.fossilslegacy.red_carnotaurus", "Red Carnotaurus (2011)");
        this.add("coatType.fossilslegacy.compsognathus", "Compsognathus (2024)");
        this.add("coatType.fossilslegacy.cryolophosaurus", "Cryolophosaurus (2011)");
        this.add("coatType.fossilslegacy.dilophosaurus", "Dilophosaurus (2011)");
        this.add("coatType.fossilslegacy.dodo", "Dodo (2024)");
        this.add("coatType.fossilslegacy.futabasaurus", "Futabasaurus (2024)");
        this.add("coatType.fossilslegacy.mammoth", "Mammoth (2011)");
        this.add("coatType.fossilslegacy.mosasaurus", "Mosasaurus (2011)");
        this.add("coatType.fossilslegacy.pachycephalosaurus", "Pachycephalosaurus (2024)");
        this.add("coatType.fossilslegacy.pteranodon", "Pteranodon (2011)");
        this.add("coatType.fossilslegacy.stegosaurus", "Stegosaurus (2011)");
        this.add("coatType.fossilslegacy.smilodon", "Smilodon (2011)");
        this.add("coatType.fossilslegacy.feathered_therizinosaurus", "Feathered Therizinosaurus (2011)");
        this.add("coatType.fossilslegacy.featherless_therizinosaurus", "Featherless Therizinosaurus (2011)");
        this.add("coatType.fossilslegacy.brown_triceratops", "Brown Triceratops (2024)");
        this.add("coatType.fossilslegacy.green_triceratops", "Green Triceratops (2024)");
        this.add("coatType.fossilslegacy.tyrannosaurus", "Tyrannosaurus (2011)");
        this.add("coatType.fossilslegacy.green_velociraptor", "Green Velociraptor (2024)");
        this.add("coatType.fossilslegacy.sandy_velociraptor", "Sandy Velociraptor (2024)");
        this.add("coatType.fossilslegacy.white_velociraptor", "White Velociraptor (2024)");
        this.add("coatType.fossilslegacy.legacy_brachiosaurus", "Brachiosaurus (2011)");
        this.add("coatType.fossilslegacy.legacy_futabasaurus", "Futabasaurus (2011)");
        this.add("coatType.fossilslegacy.legacy_brown_triceratops", "Brown Triceratops (2011)");
        this.add("coatType.fossilslegacy.legacy_green_triceratops", "Green Triceratops (2011)");
        this.add("coatType.fossilslegacy.legacy_green_velociraptor", "Green Velociraptor (2011)");
        this.add("coatType.fossilslegacy.legacy_sandy_velociraptor", "Sandy Velociraptor (2011)");
        this.add("coatType.fossilslegacy.legacy_white_velociraptor", "White Velociraptor (2011)");

        // Commands
        this.add("command.fossilslegacy.follow", "Follow");
        this.add("command.fossilslegacy.stay", "Stay");
        this.add("command.fossilslegacy.free_move", "Free Move");
        this.add("command.fossilslegacy.command.use", "Set to %s");
        this.add("command.fossilslegacy.magic_conch.use", "Set all plesiosaurs in a 30 block radius to %s.");

        // Containers
        this.add("container.fossilslegacy.analyzer", "Analyzer");
        this.add("container.fossilslegacy.archaeology_workbench", "Archaeology Workbench");
        this.add("container.fossilslegacy.cultivator", "Cultivator");
        this.add("container.fossilslegacy.gene_modifier", "Gene Modifier");
        this.add("container.fossilslegacy.gene_modification_table.coat_type.location", "%s/%s");
        this.add("container.fossilslegacy.gene_modification_table.coat_type.none", "N/A");
        this.add("container.fossilslegacy.gene_modification_table.insert", "Insert DNA");
        this.add("container.fossilslegacy.gene_modification_table.navigate_left.tutorial", "Use '%s' to navigate left.");
        this.add("container.fossilslegacy.gene_modification_table.navigate_right.tutorial", "Use '%s' to navigate right.");
        this.add("container.fossilslegacy.feeder", "Feeder");
        this.add("container.fossilslegacy.time_machine", "Time Machine");
        this.add("container.fossilslegacy.time_machine.start", "Start");

        // Creative Mode Tab
        this.add(FossilsLegacyCreativeModeTabs.FOSSILS_LEGACY.get(), "F/A: Legacy");

        // Deaths
        this.add("death.attack.dinosaur_starve", "%1$s starved to death");
        this.add("death.attack.dilophosaurus_envenomation", "%1$s was envenomated");
        this.add("death.attack.javelin", "%1$s was impaled");
        this.add("death.attack.javelin.player", "%1$s was impaled by %2$s");

        // Dinopedia
        this.add("dinopedia.fossilslegacy.able_to_fly", "Able to Fly");
        this.add("dinopedia.fossilslegacy.age", "Age: %s");
        this.add("dinopedia.fossilslegacy.cold", "Too Cold");
        this.add("dinopedia.fossilslegacy.creature", "Creature: %s");
        this.add("dinopedia.fossilslegacy.dangerous", "Caution: Dangerous");
        this.add("dinopedia.fossilslegacy.dry", "Too Dry");
        this.add("dinopedia.fossilslegacy.egg", "%s Egg");
        this.add("dinopedia.fossilslegacy.embryo", "Embryo: %s");
        this.add("dinopedia.fossilslegacy.health", "Health: %s / %s");
        this.add("dinopedia.fossilslegacy.hunger", "Hunger: %s / %s");
        this.add("dinopedia.fossilslegacy.not_owner", "You Are Not the Owner");
        this.add("dinopedia.fossilslegacy.owner", "Owner: %s");
        this.add("dinopedia.fossilslegacy.pregnancy_time", "Pregnancy Time: %s");
        this.add("dinopedia.fossilslegacy.remaining_time", "Hatching Time: %s");
        this.add("dinopedia.fossilslegacy.rideable", "Rideable");
        this.add("dinopedia.fossilslegacy.status", "Status: %s");
        this.add("dinopedia.fossilslegacy.warm", "Warm");
        this.add("dinopedia.fossilslegacy.wet", "Wet");
        this.add("dinopedia.fossilslegacy.wild", "This Animal is Wild");

        // Dino Situations
        this.add(DinoSituation.HUNGRY, "%s is hungry!");
        this.add(DinoSituation.STARVE, "%s is starving!");
        this.add(DinoSituation.NO_SPACE, "%s has no space to grow!");
        this.add(DinoSituation.STARVE_ESCAPE, "%s has escaped from starvation!");
        this.add(DinoSituation.HURT_ESCAPE, "%s will not trust humanity again!");
        this.add(DinoSituation.FULL, "%s is full!");
        this.add(DinoSituation.TAME_TYRANNOSAURUS_ERROR_TOO_YOUNG, "%s is too young to be tamed!");
        this.add(DinoSituation.TAME_TYRANNOSAURUS_ERROR_HEALTH, "%s must be knocked out to be tamed!");

        // Entities
        this.add(FossilsLegacyEntityTypes.BRACHIOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.COMPSOGNATHUS.get());
        this.add(FossilsLegacyEntityTypes.DILOPHOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.DODO.get());
        this.add(FossilsLegacyEntityTypes.MAMMOTH.get());
        this.add(FossilsLegacyEntityTypes.MOSASAURUS.get());
        this.add(FossilsLegacyEntityTypes.NAUTILUS.get());
        this.add(FossilsLegacyEntityTypes.FUTABASAURUS.get());
        this.add(FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.PTERANODON.get());
        this.add(FossilsLegacyEntityTypes.SMILODON.get());
        this.add(FossilsLegacyEntityTypes.STEGOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.TRICERATOPS.get());
        this.add(FossilsLegacyEntityTypes.TYRANNOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.VELOCIRAPTOR.get());

        this.add(FossilsLegacyEntityTypes.EGG.get());
        this.add("entity.fossilslegacy.egg.died", "An egg was too cold and died!");
        this.add("entity.fossilslegacy.egg.died.dry", "An egg was dry and died!");
        this.add(FossilsLegacyEntityTypes.FOSSIL.get());

        this.add(FossilsLegacyEntityTypes.PREGNANT_ARMADILLO.get(), "Armadillo");
        this.add(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), "Cat");
        this.add(FossilsLegacyEntityTypes.PREGNANT_COW.get(), "Cow");
        this.add(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), "Dolphin");
        this.add(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), "Donkey");
        this.add(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), "Fox");
        this.add(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), "Goat");
        this.add(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), "Horse");
        this.add(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), "Llama");
        this.add(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), "Mammoth");
        this.add(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), "Mule");
        this.add(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), "Ocelot");
        this.add(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), "Panda");
        this.add(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), "Pig");
        this.add(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), "Polar Bear");
        this.add(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), "Rabbit");
        this.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), "Sheep");
        this.add(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), "Smilodon");
        this.add(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), "Wolf");

        this.add(FossilsLegacyEntityTypes.ANU.get(), "Anu");
        this.add(Anu.AnuSpeaker.GREETINGS, "Kneel down! Resistance is futile!");
        this.add(Anu.AnuSpeaker.HAND_ATTACKED, "Bare hands? Brave!");
        this.add(Anu.AnuSpeaker.THREATEN, "Draw your sword, kid!");
        this.add(Anu.AnuSpeaker.BOW_ATTACKED, "Bow-using coward! Stop hidding!");
        this.add(Anu.AnuSpeaker.LEARNED_HERE, "Look what I learned here!");
        this.add(Anu.AnuSpeaker.LEARNED_THERE, "Look what I learned there!");
        this.add(Anu.AnuSpeaker.GENERIC_RANGED_ATTACKED, "So, is that your weapon?");
        this.add(Anu.AnuSpeaker.GENERIC_MELEE_ATTACKED, "Ha! Stop Playing!");
        this.add(Anu.AnuSpeaker.SUMMON_ZOMBIFIED_PIGLINS, "Work for me, rise my servants!");
        this.add(Anu.AnuSpeaker.SUMMON_PIGS, "Brutes, wake up your wisdom!");
        this.add(Anu.AnuSpeaker.QI_SHOCK, "Qi-shock!");
        this.add(Anu.AnuSpeaker.RAIN_FIRE, "Let fire rain!");

        this.add(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), "Zombified Piglin");
        this.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.ANU_SUMMON, "All hail Anu!");
        this.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.SACRIFICE, "I cannot live without my Master!");
        this.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.SUMMON, "I swear my life to %s!");

        this.add(FossilsLegacyEntityTypes.FAILURESAURUS.get());

        this.add(FossilsLegacyEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), "Lightning Bolt");

        this.add(FossilsLegacyEntityTypes.THROWN_JAVELIN.get());
        this.add(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get());
        this.add(FossilsLegacyEntityTypes.DILOPHOSAURUS_VENOM.get());

        this.add(FossilsLegacyEntityTypes.STONE_TABLET.get());

        this.add(FossilsLegacyEntityTypes.CARNOTAURUS.get());
        this.add(FossilsLegacyEntityTypes.CRYOLOPHOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.THERIZINOSAURUS.get());

        // Items
        this.add(FossilsLegacyItems.FOSSIL.get());
        this.add(FossilsLegacyItems.TRICERATOPS_DNA.get(), "Triceratops DNA");
        this.add(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), "Velociraptor DNA");
        this.add(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), "Tyrannosaurus DNA");
        this.add(FossilsLegacyItems.PTERANODON_DNA.get(), "Pteranodon DNA");
        this.add(FossilsLegacyItems.NAUTILUS_DNA.get(), "Nautilus DNA");
        this.add(FossilsLegacyItems.FUTABASAURUS_DNA.get(), "Futabasaurus DNA");
        this.add(FossilsLegacyItems.MOSASAURUS_DNA.get(), "Mosasaurus DNA");
        this.add(FossilsLegacyItems.STEGOSAURUS_DNA.get(), "Stegosaurus DNA");
        this.add(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), "Dilophosaurus DNA");
        this.add(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), "Brachiosaurus DNA");
        this.add(FossilsLegacyItems.CARNOTAURUS_DNA.get(), "Carnotaurus DNA");
        this.add(FossilsLegacyItems.CRYOLOPHOSAURUS_DNA.get(), "Cryolophosaurus DNA");
        this.add(FossilsLegacyItems.THERIZINOSAURUS_DNA.get(), "Therizinosaurus DNA");
        this.add(FossilsLegacyItems.PACHYCEPHALOSAURUS_DNA.get(), "Pachycephalosaurus DNA");
        this.add(FossilsLegacyItems.COMPSOGNATHUS_DNA.get(), "Compsognathus DNA");
        this.add("item.fossilslegacy.dna.coat_type", "Coat Type: %s");
        this.add(FossilsLegacyItems.PETRIFIED_LEPIDODENDRON_SAPLING.get());
        this.add(FossilsLegacyItems.TRICERATOPS_EGG.get());
        this.add(FossilsLegacyItems.VELOCIRAPTOR_EGG.get());
        this.add(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.PTERANODON_EGG.get());
        this.add(FossilsLegacyItems.NAUTILUS_EGGS.get());
        this.add(FossilsLegacyItems.FUTABASAURUS_EGG.get());
        this.add(FossilsLegacyItems.MOSASAURUS_EGG.get());
        this.add(FossilsLegacyItems.STEGOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.CARNOTAURUS_EGG.get());
        this.add(FossilsLegacyItems.CRYOLOPHOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.THERIZINOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.PACHYCEPHALOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.COMPSOGNATHUS_EGG.get());
        this.add(FossilsLegacyItems.RAW_TRICERATOPS.get());
        this.add(FossilsLegacyItems.RAW_VELOCIRAPTOR.get());
        this.add(FossilsLegacyItems.RAW_TYRANNOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_PTERANODON.get());
        this.add(FossilsLegacyItems.NAUTILUS.get());
        this.add(FossilsLegacyItems.RAW_FUTABASAURUS.get());
        this.add(FossilsLegacyItems.RAW_MOSASAURUS.get());
        this.add(FossilsLegacyItems.RAW_STEGOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_DILOPHOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_BRACHIOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_SMILODON.get());
        this.add(FossilsLegacyItems.RAW_MAMMOTH.get());
        this.add(FossilsLegacyItems.RAW_CARNOTAURUS.get());
        this.add(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_THERIZINOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_PACHYCEPHALOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_COMPSOGNATHUS.get());
        this.add(FossilsLegacyItems.RAW_DODO.get());
        this.add(FossilsLegacyItems.COOKED_TRICERATOPS.get());
        this.add(FossilsLegacyItems.COOKED_VELOCIRAPTOR.get());
        this.add(FossilsLegacyItems.COOKED_TYRANNOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_PTERANODON.get());
        this.add(FossilsLegacyItems.SIO_CHIU_LE.get(), "Sio-Chiu-Le");
        this.add(FossilsLegacyItems.COOKED_FUTABASAURUS.get());
        this.add(FossilsLegacyItems.COOKED_MOSASAURUS.get());
        this.add(FossilsLegacyItems.COOKED_STEGOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_DILOPHOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_BRACHIOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_SMILODON.get());
        this.add(FossilsLegacyItems.COOKED_MAMMOTH.get());
        this.add(FossilsLegacyItems.COOKED_CARNOTAURUS.get());
        this.add(FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_THERIZINOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_PACHYCEPHALOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_COMPSOGNATHUS.get());
        this.add(FossilsLegacyItems.COOKED_DODO.get());
        this.add(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
        this.add(FossilsLegacyItems.TOOTH_DAGGER.get());
        this.add(FossilsLegacyItems.THERIZINOSAURUS_CLAWS.get());
        this.add(FossilsLegacyItems.SKULL_STICK.get());
        this.add(FossilsLegacyItems.DINOPEDIA.get());
        this.add(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), "Bucket of Raw Chicken Soup");
        this.add(FossilsLegacyItems.RAW_BERRY_MEDLEY_BUCKET.get(), "Bucket of Raw Berry Medley");
        this.add(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), "Bucket of Cooked Chicken Soup");
        this.add(FossilsLegacyItems.COOKED_BERRY_MEDLEY_BUCKET.get(), "Bucket of Cooked Berry Medley");
        this.add(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
        this.add(FossilsLegacyItems.ROMANTIC_CONCOCTION_BOTTLE.get());
        this.add(FossilsLegacyItems.NAUTILUS_SHELL.get());
        this.add(FossilsLegacyItems.MAGIC_CONCH.get());
        this.add("item.fossilslegacy.magic_conch.desc", "%s");
        this.add("item.fossilslegacy.magic_conch.use", "Set all Plesiosaurs in a 30-Block Area to %s");
        this.add(FossilsLegacyItems.FROZEN_MEAT.get());
        this.add(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get(), "Frozen Meat");
        this.add(FossilsLegacyItems.ARMADILLO_DNA.get(), "Armadillo DNA");
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
        this.add(FossilsLegacyItems.WOLF_DNA.get(), "Wolf DNA");
        this.add(FossilsLegacyItems.SMILODON_DNA.get(), "Smilodon DNA");
        this.add(FossilsLegacyItems.MAMMOTH_DNA.get(), "Mammoth DNA");
        this.add(FossilsLegacyItems.DODO_DNA.get(), "Dodo DNA");
        this.add(FossilsLegacyItems.ARMADILLO_EMBRYO_SYRINGE.get());
        this.add(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
        this.add(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
        this.add(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
        this.add(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
        this.add(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
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
        this.add(FossilsLegacyItems.INCUBATED_DODO_EGG.get());
        this.add(FossilsLegacyItems.DODO_EGG.get());
        this.add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        this.add(FossilsLegacyItems.RELIC_SCRAP.get());
        this.add(FossilsLegacyItems.STONE_TABLET.get());
        this.add(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_SHOVEL_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_PICKAXE_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_AXE_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_HOE_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_CHESTPLATE_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_LEGGINGS_ARTIFACT.get());
        this.add(FossilsLegacyItems.ANCIENT_BOOTS_ARTIFACT.get());
        this.add(FossilsLegacyItems.SCARAB_GEM.get());
        this.add(FossilsLegacyItems.ANCIENT_SWORD.get());
        this.add(FossilsLegacyItems.ANCIENT_SHOVEL.get());
        this.add(FossilsLegacyItems.ANCIENT_PICKAXE.get());
        this.add(FossilsLegacyItems.ANCIENT_AXE.get());
        this.add(FossilsLegacyItems.ANCIENT_HOE.get());
        this.add(FossilsLegacyItems.ANCIENT_HELMET.get());
        this.add(FossilsLegacyItems.ANCIENT_CHESTPLATE.get());
        this.add(FossilsLegacyItems.ANCIENT_LEGGINGS.get());
        this.add(FossilsLegacyItems.ANCIENT_BOOTS.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_SWORD.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_AXE.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_HOE.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_HELMET.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_CHESTPLATE.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_LEGGINGS.get());
        this.add(FossilsLegacyItems.SCARAB_GEM_BOOTS.get());
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

        this.add(FossilsLegacyItems.ANU_SPAWN_EGG.get());

        this.add(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());

        this.add(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.CARNOTAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.CRYOLOPHOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.THERIZINOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.COMPSOGNATHUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.DODO_SPAWN_EGG.get());
        this.add("item.fossilslegacy.dinosaur_spawn_egg.desc", "Crouch to spawn baby");

        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.applies_to", "Netherite Equipment");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.ingredients", "Scarab Gem");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.base_slot_description", "Add netherite weapon or tool");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.additions_slot_description", "Add scarab gem");

        this.add(FossilsLegacyItems.OVERWORLD_COIN.get());
        this.add(FossilsLegacyItems.ICE_AGE_COIN.get());
        this.add(FossilsLegacyItems.PREHISTORIC_COIN.get());

        this.add(FossilsLegacyItems.LEPIDODENDRON_BOAT.get());
        this.add(FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT.get(), "Lepidodendron Boat with Chest");

        this.add(FossilsLegacyItems.DEBUG_MAX_HUNGER.get(), "Debug Item");
        this.add(FossilsLegacyItems.DEBUG_MAX_HEALTH.get(), "Debug Item");
        this.add(FossilsLegacyItems.DEBUG_FULL_GROWN.get(), "Debug Item");
        this.add(FossilsLegacyItems.DEBUG_BABY.get(), "Debug Item");
        this.add(FossilsLegacyItems.DEBUG_TAME.get(), "Debug Item");
        this.add(FossilsLegacyItems.DEBUG_CHANGE_GENETICS.get(), "Debug Item");

        this.add("debugItem.fossilslegacy.type", "Type: %s");
        this.add("debugItem.fossilslegacy.set_max_hunger", "Set Max Hunger");
        this.add("debugItem.fossilslegacy.set_max_health", "Set Max Health");
        this.add("debugItem.fossilslegacy.set_full_grown", "Set Full Grown");
        this.add("debugItem.fossilslegacy.set_baby", "Set Baby");
        this.add("debugItem.fossilslegacy.set_owner_as_me", "Set Owner As Me");
        this.add("debugItem.fossilslegacy.change_genetics", "Change Genetics");

        // JEI
        this.add("jei.fossilslegacy.archaeology", "Archaeology");
        this.add("jei.fossilslegacy.analyzation", "Analyzation");
        this.add("jei.fossilslegacy.cultivation", "Cultivation");
        this.add("jei.fossilslegacy.biomatter", "Biomatter");
        this.add("jei.fossilslegacy.biomatter.biomatterCount.single", "Biomatter for 1 item");
        this.add("jei.fossilslegacy.biomatter.biomatterCount", "Biomatter for %s items");
        this.add("jei.fossilslegacy.feeder", "Feeder");
        this.add("jei.fossilslegacy.feeder.food_level", "Provides %s food");

        // Keys
        this.add("key.fossilslegacy.sink", "Sink");
        this.add("key.fossilslegacy.navigate_left", "Navigate Left");
        this.add("key.fossilslegacy.navigate_right", "Navigate Right");

        // Patterns
        this.add("pattern.fossilslegacy.american_bison", "American Bison");
        this.add("pattern.fossilslegacy.blue_iguana", "Blue Iguana");
        this.add("pattern.fossilslegacy.broadhead_skink", "Broadhead Skink");
        this.add("pattern.fossilslegacy.domestic_pigeon", "Domestic Pigeon");
        this.add("pattern.fossilslegacy.eastern_brown_snake", "Eastern Brown Snake");
        this.add("pattern.fossilslegacy.eastern_indigo_snake", "Eastern Indigo Snake");
        this.add("pattern.fossilslegacy.gray_ratsnake", "Gray Ratsnake");
        this.add("pattern.fossilslegacy.green_parakeet", "Green Parakeet");
        this.add("pattern.fossilslegacy.green_tree_python", "Green Tree Python");
        this.add("pattern.fossilslegacy.inland_taipan", "Inland Taipan");
        this.add("pattern.fossilslegacy.marine_iguana", "Marine Iguana");
        this.add("pattern.fossilslegacy.northern_cardinal", "Northern Cardinal");
        this.add("pattern.fossilslegacy.tiger", "Tiger");

        // Resource Packs
        this.add("resourcePack.fossilslegacy.description", "Fossils and Archaeology: Legacy Assets");
        this.add("resourcePack.fossilslegacy.fa_legacy_textures.description", "1.3.2 Assets");
        this.add("resourcePack.fossilslegacy.fa_legacy_textures.name", "F/A Original Textures");

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
        this.add("stone_tablet.fossilslegacy.anu_totem.title", "Anu Totem");
        this.add("stone_tablet.fossilslegacy.anu_totem.author", "Willatendo");
        this.add("stone_tablet.fossilslegacy.random", "Random variant");

        // Sounds
        this.add("subtitles.entity.brachiosaurus.ambient", "Brachiosaurus calls");
        this.add("subtitles.entity.brachiosaurus.hurt", "Brachiosaurus hurts");
        this.add("subtitles.entity.brachiosaurus.death", "Brachiosaurus dies");
        this.add("subtitles.entity.carnotaurus.ambient", "Carnotaurus grumbles");
        this.add("subtitles.entity.carnotaurus.hurt", "Carnotaurus hurts");
        this.add("subtitles.entity.carnotaurus.death", "Carnotaurus dies");
        this.add("subtitles.entity.compsognathus.ambient", "Compsognathus chirps");
        this.add("subtitles.entity.compsognathus.hurt", "Compsognathus hurts");
        this.add("subtitles.entity.compsognathus.death", "Compsognathus dies");
        this.add("subtitles.entity.cryolophosaurus.ambient", "Cryolophosaurus grumbles");
        this.add("subtitles.entity.cryolophosaurus.hurt", "Cryolophosaurus hurts");
        this.add("subtitles.entity.cryolophosaurus.death", "Cryolophosaurus dies");
        this.add("subtitles.entity.dilophosaurus.ambient", "Dilophosaurus hisses");
        this.add("subtitles.entity.dilophosaurus.call", "Dilophosaurus calls");
        this.add("subtitles.entity.dilophosaurus.hurt", "Dilophosaurus hurts");
        this.add("subtitles.entity.dilophosaurus.death", "Dilophosaurus dies");
        this.add("subtitles.entity.dodo.ambient", "Dodo hoots");
        this.add("subtitles.entity.dodo.hurt", "Dodo hurts");
        this.add("subtitles.entity.dodo.death", "Dodo dies");
        this.add("subtitles.block.drum.hit", "Drum hit");
        this.add("subtitles.block.drum.triple_hit", "Drum triple hit");
        this.add("subtitles.entity.mammoth.ambient", "Mammoth trumpets");
        this.add("subtitles.entity.mammoth.hurt", "Mammoth hurts");
        this.add("subtitles.entity.mammoth.death", "Mammoth dies");
        this.add("subtitles.entity.futabasaurus.ambient", "Futabasaurus chirps");
        this.add("subtitles.entity.futabasaurus.hurt", "Futabasaurus hurts");
        this.add("subtitles.entity.futabasaurus.death", "Futabasaurus dies");
        this.add("subtitles.entity.pachycephalosaurus.ambient", "Pachycephalosaurus chirps");
        this.add("subtitles.entity.pachycephalosaurus.hurt", "Pachycephalosaurus hurts");
        this.add("subtitles.entity.pachycephalosaurus.death", "Pachycephalosaurus dies");
        this.add("subtitles.entity.pteranodon.ambient", "Pteranodon calls");
        this.add("subtitles.entity.pteranodon.hurt", "Pteranodon hurts");
        this.add("subtitles.entity.pteranodon.death", "Pteranodon dies");
        this.add("subtitles.entity.smilodon.ambient", "Smilodon roars");
        this.add("subtitles.entity.smilodon.hurt", "Smilodon hurts");
        this.add("subtitles.entity.smilodon.death", "Smilodon dies");
        this.add("subtitles.entity.stegosaurus.ambient", "Stegosaurus calls");
        this.add("subtitles.entity.stegosaurus.hurt", "Stegosaurus hurts");
        this.add("subtitles.entity.stegosaurus.death", "Stegosaurus dies");
        this.add("subtitles.entity.triceratops.ambient", "Triceratops calls");
        this.add("subtitles.entity.triceratops.hurt", "Triceratops hurts");
        this.add("subtitles.entity.triceratops.death", "Triceratops dies");
        this.add("subtitles.entity.therizinosaurus.ambient", "Therizinosaurus grumbles");
        this.add("subtitles.entity.therizinosaurus.hurt", "Therizinosaurus hurts");
        this.add("subtitles.entity.therizinosaurus.death", "Therizinosaurus dies");
        this.add("subtitles.entity.tyrannosaurus.ambient", "Tyrannosaurus rumbles");
        this.add("subtitles.entity.tyrannosaurus.attack", "Tyrannosaurus roars");
        this.add("subtitles.entity.tyrannosaurus.hurt", "Tyrannosaurus hurts");
        this.add("subtitles.entity.tyrannosaurus.death", "Tyrannosaurus dies");
        this.add("subtitles.entity.velociraptor.ambient.tame", "Velociraptor whines");
        this.add("subtitles.entity.velociraptor.ambient.wild", "Velociraptor hisses");
        this.add("subtitles.entity.velociraptor.attack", "Velociraptor attacks");
        this.add("subtitles.entity.velociraptor.hurt", "Velociraptor hurts");
        this.add("subtitles.entity.velociraptor.death", "Velociraptor dies");

        // Upgrades
        this.add("upgrade.fossilslegacy.scarab_gem_upgrade", "Scarab Gem Upgrade");
    }

    public void add(SpeakerType<?> speakerType, String translation) {
        this.add(speakerType.getTranslationKey(), translation);
    }
}
