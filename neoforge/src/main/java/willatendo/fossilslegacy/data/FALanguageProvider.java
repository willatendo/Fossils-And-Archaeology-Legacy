package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.entity.FAEntityTypes;
import willatendo.fossilslegacy.server.entity.entities.Anu;
import willatendo.fossilslegacy.server.entity.entities.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.interfaces.SpeakerType;
import willatendo.fossilslegacy.server.fossil_variant.FAFossilVariants;
import willatendo.fossilslegacy.server.fossil_variant.FossilVariant;
import willatendo.fossilslegacy.server.item.FACreativeModeTabs;
import willatendo.fossilslegacy.server.item.FAItems;
import willatendo.fossilslegacy.server.item.GeologicalTimeScale;
import willatendo.fossilslegacy.server.level.FAGameRules;
import willatendo.fossilslegacy.server.model_type.FAModelTypes;
import willatendo.fossilslegacy.server.model_type.ModelType;
import willatendo.fossilslegacy.server.stats.FAStats;
import willatendo.fossilslegacy.server.tags.*;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

public class FALanguageProvider extends SimpleLanguageProvider {
    public FALanguageProvider(PackOutput packOutput, String modId, String local) {
        super(packOutput, modId, local);
    }

    @Override
    protected void addTranslations() {
        // Advancements
        this.add("advancements.fossilslegacy.legacy.root.title", "The Legacy");
        this.add("advancements.fossilslegacy.legacy.root.desc", "Play the Fossils and Archaeology: Legacy!");
        this.add("advancements.fossilslegacy.legacy.fossil.title", "Fossils!");
        this.add("advancements.fossilslegacy.legacy.fossil.desc", "Acquire a fossil!");
        this.add("advancements.fossilslegacy.legacy.analyzer.title", "Analyzer!");
        this.add("advancements.fossilslegacy.legacy.analyzer.desc", "Acquire an analyzer!");
        this.add("advancements.fossilslegacy.legacy.palaeontology_table.title", "A Palaeontologist's Table!");
        this.add("advancements.fossilslegacy.legacy.palaeontology_table.desc", "Make a palaeontology table!");
        this.add("advancements.fossilslegacy.legacy.relic_scrap.title", "Old News");
        this.add("advancements.fossilslegacy.legacy.relic_scrap.desc", "Acquire a relic scrap!");
        this.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.title", "Once Feared");
        this.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.desc", "Acquire an ancient sword artifact!");
        this.add("advancements.fossilslegacy.legacy.ancient_sword.title", "1.21 Gigawatts!");
        this.add("advancements.fossilslegacy.legacy.ancient_sword.desc", "Repair an ancient sword!");
        this.add("advancements.fossilslegacy.legacy.pigman.title", "From the Dead!");
        this.add("advancements.fossilslegacy.legacy.pigman.desc", "Spawn a piglin!");
        this.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.title", "Black Magic");
        this.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.desc", "Acquire an ancient helmet artifact!");
        this.add("advancements.fossilslegacy.legacy.fixed_ancient_armor.title", "Nether Connections");
        this.add("advancements.fossilslegacy.legacy.fixed_ancient_armor.desc", "Repair a piece of ancient armor!");
        this.add("advancements.fossilslegacy.legacy.decked_out.title", "Decked Out!");
        this.add("advancements.fossilslegacy.legacy.decked_out.desc", "Have a complete set of ancient armor!");
        this.add("advancements.fossilslegacy.legacy.tamed_pigman.title", "Till Death I'm To Serve You!");
        this.add("advancements.fossilslegacy.legacy.tamed_pigman.desc", "Spawn a tamed piglin!");
        this.add("advancements.fossilslegacy.legacy.archaeology_workbench.title", "An Archaeologist's Table!");
        this.add("advancements.fossilslegacy.legacy.archaeology_workbench.desc", "Make a archaeology workbench!");
        this.add("advancements.fossilslegacy.legacy.stone_tablet.title", "An Old Story");
        this.add("advancements.fossilslegacy.legacy.stone_tablet.desc", "Place a stone tablet!");
        this.add("advancements.fossilslegacy.legacy.skull_block.title", "Spooky Skeletons!");
        this.add("advancements.fossilslegacy.legacy.skull_block.desc", "Or...Maybe just their skulls?");
        this.add("advancements.fossilslegacy.legacy.anu.title", "The Master!");
        this.add("advancements.fossilslegacy.legacy.anu.desc", "Summon Anu, the master of the zombified piglins!");
        this.add("advancements.fossilslegacy.legacy.prehistoric_coin.title", "Ticket to the Past!");
        this.add("advancements.fossilslegacy.legacy.prehistoric_coin.desc", "Acquire a prehistoric coin!");
        this.add("advancements.fossilslegacy.legacy.overworld_coin.title", "Back to the Future!");
        this.add("advancements.fossilslegacy.legacy.overworld_coin.desc", "Acquire an overworld coin!");
        this.add("advancements.fossilslegacy.legacy.time_machine.title", "Time Traveller!");
        this.add("advancements.fossilslegacy.legacy.time_machine.desc", "Travel to the past (without art theft)!");

        // Blocks
        this.add(FABlocks.FOSSIL_ORE.get());
        this.add(FABlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.add(FABlocks.SKULL_BLOCK.get());
        this.add(FABlocks.SKULL_LANTERN_BLOCK.get());
        this.add(FABlocks.ANALYZER.get());
        this.add(FABlocks.WHITE_CULTIVATOR.get());
        this.add(FABlocks.ORANGE_CULTIVATOR.get());
        this.add(FABlocks.MAGENTA_CULTIVATOR.get());
        this.add(FABlocks.LIGHT_BLUE_CULTIVATOR.get());
        this.add(FABlocks.YELLOW_CULTIVATOR.get());
        this.add(FABlocks.LIME_CULTIVATOR.get());
        this.add(FABlocks.PINK_CULTIVATOR.get());
        this.add(FABlocks.GRAY_CULTIVATOR.get());
        this.add(FABlocks.LIGHT_GRAY_CULTIVATOR.get());
        this.add(FABlocks.CYAN_CULTIVATOR.get());
        this.add(FABlocks.PURPLE_CULTIVATOR.get());
        this.add(FABlocks.BLUE_CULTIVATOR.get());
        this.add(FABlocks.BROWN_CULTIVATOR.get());
        this.add(FABlocks.GREEN_CULTIVATOR.get());
        this.add(FABlocks.RED_CULTIVATOR.get());
        this.add(FABlocks.BLACK_CULTIVATOR.get());
        this.add("block.fossilslegacy.cultivator.shatter", "Warning! Cultivation failure!");
        this.add(FABlocks.DNA_RECOMBINATOR.get(), "DNA Recombinator");
        this.add(FABlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.add(FABlocks.PALAEONTOLOGY_TABLE.get());
        this.add(FABlocks.JURASSIC_FERN.get());
        this.add(FABlocks.DRUM.get());
        this.add("block.fossilslegacy.drum.hit", "Set all creatures that are commanded with a %s to %s.");
        this.add(FABlocks.FEEDER.get());
        this.add(FABlocks.PERMAFROST.get());
        this.add(FABlocks.ICED_STONE.get());
        this.add(FABlocks.AXOLOTLSPAWN.get());
        this.add(FABlocks.TIME_MACHINE.get());
        this.add(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get());
        this.add(FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get());
        this.add(FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get());
        this.add(FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get());
        this.add(FABlocks.MAYAN_VASE.get());
        this.add(FABlocks.MAYAN_JADE_VASE.get());
        this.add(FABlocks.MAYAN_OCELOT_VASE.get());
        this.add(FABlocks.MAYAN_VILLAGER_VASE.get());
        this.add(FABlocks.IRON_LLAMA_STATUE.get());
        this.add(FABlocks.COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.WAXED_COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get());
        this.add(FABlocks.LEPIDODENDRON_PLANKS.get());
        this.add(FABlocks.LEPIDODENDRON_SAPLING.get());
        this.add(FABlocks.LEPIDODENDRON_LOG.get());
        this.add(FABlocks.STRIPPED_LEPIDODENDRON_LOG.get());
        this.add(FABlocks.LEPIDODENDRON_WOOD.get());
        this.add(FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.add(FABlocks.LEPIDODENDRON_LEAVES.get());
        this.add(FABlocks.LEPIDODENDRON_STAIRS.get());
        this.add(FABlocks.LEPIDODENDRON_SIGN.get());
        this.add(FABlocks.LEPIDODENDRON_DOOR.get());
        this.add(FABlocks.LEPIDODENDRON_HANGING_SIGN.get());
        this.add(FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get());
        this.add(FABlocks.LEPIDODENDRON_FENCE.get());
        this.add(FABlocks.LEPIDODENDRON_TRAPDOOR.get());
        this.add(FABlocks.LEPIDODENDRON_FENCE_GATE.get());
        this.add(FABlocks.LEPIDODENDRON_BUTTON.get());
        this.add(FABlocks.LEPIDODENDRON_SLAB.get());
        this.add(FABlocks.SIGILLARIA_PLANKS.get());
        this.add(FABlocks.SIGILLARIA_SAPLING.get());
        this.add(FABlocks.SIGILLARIA_LOG.get());
        this.add(FABlocks.STRIPPED_SIGILLARIA_LOG.get());
        this.add(FABlocks.SIGILLARIA_WOOD.get());
        this.add(FABlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.add(FABlocks.SIGILLARIA_LEAVES.get());
        this.add(FABlocks.SIGILLARIA_STAIRS.get());
        this.add(FABlocks.SIGILLARIA_SIGN.get());
        this.add(FABlocks.SIGILLARIA_DOOR.get());
        this.add(FABlocks.SIGILLARIA_HANGING_SIGN.get());
        this.add(FABlocks.SIGILLARIA_PRESSURE_PLATE.get());
        this.add(FABlocks.SIGILLARIA_FENCE.get());
        this.add(FABlocks.SIGILLARIA_TRAPDOOR.get());
        this.add(FABlocks.SIGILLARIA_FENCE_GATE.get());
        this.add(FABlocks.SIGILLARIA_BUTTON.get());
        this.add(FABlocks.SIGILLARIA_SLAB.get());
        this.add(FABlocks.CALAMITES_PLANKS.get());
        this.add(FABlocks.CALAMITES_SAPLING.get());
        this.add(FABlocks.CALAMITES_LOG.get());
        this.add(FABlocks.STRIPPED_CALAMITES_LOG.get());
        this.add(FABlocks.CALAMITES_WOOD.get());
        this.add(FABlocks.STRIPPED_CALAMITES_WOOD.get());
        this.add(FABlocks.CALAMITES_LEAVES.get());
        this.add(FABlocks.CALAMITES_STAIRS.get());
        this.add(FABlocks.CALAMITES_SIGN.get());
        this.add(FABlocks.CALAMITES_DOOR.get());
        this.add(FABlocks.CALAMITES_HANGING_SIGN.get());
        this.add(FABlocks.CALAMITES_PRESSURE_PLATE.get());
        this.add(FABlocks.CALAMITES_FENCE.get());
        this.add(FABlocks.CALAMITES_TRAPDOOR.get());
        this.add(FABlocks.CALAMITES_FENCE_GATE.get());
        this.add(FABlocks.CALAMITES_BUTTON.get());
        this.add(FABlocks.CALAMITES_SLAB.get());

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
        this.addModelType(FAModelTypes.ANKYLOSAURUS, "Ankylosaurus (2024)");
        this.addModelType(FAModelTypes.BRACHIOSAURUS, "Brachiosaurus (2024)");
        this.addModelType(FAModelTypes.COMPSOGNATHUS, "Compsognathus (2024)");
        this.addModelType(FAModelTypes.CRYOLOPHOSAURUS, "Cryolophosaurus (2024)");
        this.addModelType(FAModelTypes.DILOPHOSAURUS, "Dilophosaurus (2024)");
        this.addModelType(FAModelTypes.DODO, "Dodo (2024)");
        this.addModelType(FAModelTypes.FUTABASAURUS, "Futabasaurus (2024)");
        this.addModelType(FAModelTypes.GALLIMIMUS, "Gallimimus (2024)");
        this.addModelType(FAModelTypes.ICHTHYOSAURUS, "Ichthyosaurus (2025)");
        this.addModelType(FAModelTypes.MOA, "Moa (2024)");
        this.addModelType(FAModelTypes.MAMMOTH, "Mammoth (2024)");
        this.addModelType(FAModelTypes.MOSASAURUS, "Mosasaurus (2024)");
        this.addModelType(FAModelTypes.PACHYCEPHALOSAURUS, "Pachycephalosaurus (2024)");
        this.addModelType(FAModelTypes.PTERANODON, "Pteranodon (2024)");
        this.addModelType(FAModelTypes.SMILODON, "Smilodon 2024)");
        this.addModelType(FAModelTypes.SPINOSAURUS, "Spinosaurus (2024)");
        this.addModelType(FAModelTypes.STEGOSAURUS, "Stegosaurus (2024)");
        this.addModelType(FAModelTypes.THERIZINOSAURUS, "Therizinosaurus (2024)");
        this.addModelType(FAModelTypes.TRICERATOPS, "Triceratops (2024)");
        this.addModelType(FAModelTypes.TYRANNOSAURUS, "Tyrannosaurus (2024)");
        this.addModelType(FAModelTypes.VELOCIRAPTOR, "Velociraptor (2024)");

        this.addModelType(FAModelTypes.LEGACY_BRACHIOSAURUS, "Brachiosaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_CARNOTAURUS, "Carnotaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_CRYOLOPHOSAURUS, "Cryolophosaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_DILOPHOSAURUS, "Dilophosaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_FUTABASAURUS, "Futabasaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_MAMMOTH, "Mammoth (2011)");
        this.addModelType(FAModelTypes.LEGACY_MOSASAURUS, "Mosasaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_PTERANODON, "Pteranodon (2011)");
        this.addModelType(FAModelTypes.LEGACY_SMILODON, "Smilodon (2011)");
        this.addModelType(FAModelTypes.LEGACY_STEGOSAURUS, "Stegosaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_THERIZINOSAURUS, "Therizinosaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_TRICERATOPS, "Triceratops (2011)");
        this.addModelType(FAModelTypes.LEGACY_TYRANNOSAURUS, "Tyrannosaurus (2011)");
        this.addModelType(FAModelTypes.LEGACY_VELOCIRAPTOR, "Velociraptor (2011)");

        // Commands
        this.add("command_type.fossilslegacy.follow", "Follow");
        this.add("command_type.fossilslegacy.stay", "Stay");
        this.add("command_type.fossilslegacy.free_move", "Free Move");
        this.add("command_type.fossilslegacy.command.use", "Set to %s");
        this.add("command_type.fossilslegacy.magic_conch.use", "Set all plesiosaurs in a 30 block radius to %s.");

        // Containers
        this.add("container.fossilslegacy.analyzer", "Analyzer");
        this.add("container.fossilslegacy.archaeology_workbench", "Archaeology Workbench");
        this.add("container.fossilslegacy.cultivator", "Cultivator");
        this.add("container.fossilslegacy.dna_recombinator", "DNA Recombinator");
        this.add("container.fossilslegacy.dna_recombinator.apply_gene.tutorial", "Use '%s' to apply gene.");
        this.add("container.fossilslegacy.dna_recombinator.navigation", "%s/%s");
        this.add("container.fossilslegacy.dna_recombinator.none", "N/A");
        this.add("container.fossilslegacy.dna_recombinator.no_genome_applicable", "No Applicable Genome");
        this.add("container.fossilslegacy.dna_recombinator.insert_dna", "Insert DNA");
        this.add("container.fossilslegacy.dna_recombinator.navigate_down.tutorial", "Use '%s' to navigate down.");
        this.add("container.fossilslegacy.dna_recombinator.navigate_left.tutorial", "Use '%s' to navigate left.");
        this.add("container.fossilslegacy.dna_recombinator.navigate_right.tutorial", "Use '%s' to navigate right.");
        this.add("container.fossilslegacy.dna_recombinator.navigate_up.tutorial", "Use '%s' to navigate up.");
        this.add("container.fossilslegacy.feeder", "Feeder");
        this.add("container.fossilslegacy.palaeontology_table", "Palaeontology Table");
        this.add("container.fossilslegacy.time_machine", "Time Machine");
        this.add("container.fossilslegacy.time_machine.start", "Start");

        // Creative Mode Tabs
        this.add(FACreativeModeTabs.FA_BLOCKS.get(), "F/A: Blocks");
        this.add(FACreativeModeTabs.FA_ARCHAEOLOGY_ITEMS.get(), "F/A: Archaeology Items");
        this.add(FACreativeModeTabs.FA_PALAEONTOLOGY_ITEMS.get(), "F/A: Palaeontology Items");
        this.add(FACreativeModeTabs.FA_OTHER_ITEMS.get(), "F/A: Other Items");

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
        this.add(FAEntityTypes.ANKYLOSAURUS.get());
        this.add(FAEntityTypes.BRACHIOSAURUS.get());
        this.add(FAEntityTypes.CARNOTAURUS.get());
        this.add(FAEntityTypes.COMPSOGNATHUS.get());
        this.add(FAEntityTypes.CRYOLOPHOSAURUS.get());
        this.add(FAEntityTypes.DILOPHOSAURUS.get());
        this.add(FAEntityTypes.DIMETRODON.get());
        this.add(FAEntityTypes.DODO.get());
        this.add(FAEntityTypes.MOA.get());
        this.add(FAEntityTypes.MAMMOTH.get());
        this.add(FAEntityTypes.MOSASAURUS.get());
        this.add(FAEntityTypes.NAUTILUS.get());
        this.add(FAEntityTypes.FUTABASAURUS.get());
        this.add(FAEntityTypes.GALLIMIMUS.get());
        this.add(FAEntityTypes.ICHTHYOSAURUS.get());
        this.add(FAEntityTypes.PACHYCEPHALOSAURUS.get());
        this.add(FAEntityTypes.PTERANODON.get());
        this.add(FAEntityTypes.SMILODON.get());
        this.add(FAEntityTypes.SPINOSAURUS.get());
        this.add(FAEntityTypes.STEGOSAURUS.get());
        this.add(FAEntityTypes.THERIZINOSAURUS.get());
        this.add(FAEntityTypes.TRICERATOPS.get());
        this.add(FAEntityTypes.TYRANNOSAURUS.get());
        this.add(FAEntityTypes.VELOCIRAPTOR.get());

        this.add(FAEntityTypes.ANKYLOSAURUS_EGG.get());
        this.add(FAEntityTypes.BRACHIOSAURUS_EGG.get());
        this.add(FAEntityTypes.CARNOTAURUS_EGG.get());
        this.add(FAEntityTypes.COMPSOGNATHUS_EGG.get());
        this.add(FAEntityTypes.CRYOLOPHOSAURUS_EGG.get());
        this.add(FAEntityTypes.DILOPHOSAURUS_EGG.get());
        this.add(FAEntityTypes.DIMETRODON_EGG.get());
        this.add(FAEntityTypes.FUTABASAURUS_EGG.get());
        this.add(FAEntityTypes.GALLIMIMUS_EGG.get());
        this.add(FAEntityTypes.ICHTHYOSAURUS_EGG.get());
        this.add(FAEntityTypes.MOSASAURUS_EGG.get());
        this.add(FAEntityTypes.PACHYCEPHALOSAURUS_EGG.get());
        this.add(FAEntityTypes.PTERANODON_EGG.get());
        this.add(FAEntityTypes.SPINOSAURUS_EGG.get());
        this.add(FAEntityTypes.STEGOSAURUS_EGG.get());
        this.add(FAEntityTypes.THERIZINOSAURUS_EGG.get());
        this.add(FAEntityTypes.TRICERATOPS_EGG.get());
        this.add(FAEntityTypes.TYRANNOSAURUS_EGG.get());
        this.add(FAEntityTypes.VELOCIRAPTOR_EGG.get());
        this.add("entity.fossilslegacy.egg.died", "An egg was too cold and died!");
        this.add("entity.fossilslegacy.egg.died.dry", "An egg was dry and died!");
        this.add(FAEntityTypes.FOSSIL.get());

        this.add(FAEntityTypes.PREGNANT_ARMADILLO.get(), "Armadillo");
        this.add(FAEntityTypes.PREGNANT_CAT.get(), "Cat");
        this.add(FAEntityTypes.PREGNANT_COW.get(), "Cow");
        this.add(FAEntityTypes.PREGNANT_DOLPHIN.get(), "Dolphin");
        this.add(FAEntityTypes.PREGNANT_DONKEY.get(), "Donkey");
        this.add(FAEntityTypes.PREGNANT_FOX.get(), "Fox");
        this.add(FAEntityTypes.PREGNANT_GOAT.get(), "Goat");
        this.add(FAEntityTypes.PREGNANT_HORSE.get(), "Horse");
        this.add(FAEntityTypes.PREGNANT_LLAMA.get(), "Llama");
        this.add(FAEntityTypes.PREGNANT_MAMMOTH.get(), "Mammoth");
        this.add(FAEntityTypes.PREGNANT_MULE.get(), "Mule");
        this.add(FAEntityTypes.PREGNANT_OCELOT.get(), "Ocelot");
        this.add(FAEntityTypes.PREGNANT_PANDA.get(), "Panda");
        this.add(FAEntityTypes.PREGNANT_PIG.get(), "Pig");
        this.add(FAEntityTypes.PREGNANT_POLAR_BEAR.get(), "Polar Bear");
        this.add(FAEntityTypes.PREGNANT_RABBIT.get(), "Rabbit");
        this.add(FAEntityTypes.PREGNANT_SHEEP.get(), "Sheep");
        this.add(FAEntityTypes.PREGNANT_SMILODON.get(), "Smilodon");
        this.add(FAEntityTypes.PREGNANT_WOLF.get(), "Wolf");

        this.add(FAEntityTypes.ANU.get(), "Anu");
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

        this.add(FAEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), "Zombified Piglin");
        this.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.ANU_SUMMON, "All hail Anu!");
        this.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.SACRIFICE, "I cannot live without my Master!");
        this.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.SUMMON, "I swear my life to %s!");

        this.add(FAEntityTypes.FAILURESAURUS.get());

        this.add(FAEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), "Lightning Bolt");

        this.add(FAEntityTypes.THROWN_JAVELIN.get());
        this.add(FAEntityTypes.THROWN_INCUBATED_EGG.get());
        this.add(FAEntityTypes.DILOPHOSAURUS_VENOM.get());

        this.add(FAEntityTypes.STONE_TABLET.get());

        this.add(FAEntityTypes.JEEP.get());

        this.add(FAEntityTypes.CALAMITES_BOAT.get(), "Calamites Boat");
        this.add(FAEntityTypes.CALAMITES_CHEST_BOAT.get(), "Calamites Boat with Chest");
        this.add(FAEntityTypes.LEPIDODENDRON_BOAT.get(), "Calamites Boat");
        this.add(FAEntityTypes.LEPIDODENDRON_CHEST_BOAT.get(), "Calamites Boat with Chest");
        this.add(FAEntityTypes.SIGILLARIA_BOAT.get(), "Sigillaria Boat");
        this.add(FAEntityTypes.SIGILLARIA_CHEST_BOAT.get(), "Sigillaria Boat with Chest");

        this.add("entity.minecraft.villager.fossilslegacy.archaeologist", "Archaeologist");
        this.add("entity.minecraft.archaeologist", "Archaeologist");
        this.add("entity.minecraft.villager.fossilslegacy.palaeontologist", "Palaentologist");
        this.add("entity.minecraft.palaeontologist", "Palaentologist");

        // Filled Maps
        this.add("filled_map.academy", "Academy Explorer Map");
        this.add("filled_map.machu_picchu", "Machu Picchu Explorer Map");
        this.add("filled_map.mayan_temple", "Mayan Explorer Map");
        this.add("filled_map.weapon_shop", "Weapon Shop Explorer Map");

        // Fossil Variants
        this.addFossilVariant(FAFossilVariants.ANKYLOSAURUS, "Ankylosaurus");
        this.addFossilVariant(FAFossilVariants.BRACHIOSAURUS, "Brachiosaurus");
        this.addFossilVariant(FAFossilVariants.LEGACY_BRACHIOSAURUS, "Legacy Brachiosaurus");
        this.addFossilVariant(FAFossilVariants.CARNOTAURUS, "Carnotaurus");
        this.addFossilVariant(FAFossilVariants.COMPSOGNATHUS, "Compsognathus");
        this.addFossilVariant(FAFossilVariants.CRYOLOPHOSAURUS, "Cryolophosaurus");
        this.addFossilVariant(FAFossilVariants.DILOPHOSAURUS, "Dilophosaurus");
        this.addFossilVariant(FAFossilVariants.DIMETRODON, "Dimetrodon");
        this.addFossilVariant(FAFossilVariants.FUTABASAURUS, "Futabasaurus");
        this.addFossilVariant(FAFossilVariants.LEGACY_FUTABASAURUS, "Legacy Futabasaurus");
        this.addFossilVariant(FAFossilVariants.GALLIMIMUS, "Gallimimus");
        this.addFossilVariant(FAFossilVariants.PACHYCEPHALOSAURUS, "Pachycephalosaurus");
        this.addFossilVariant(FAFossilVariants.PTERANODON, "Pteranodon");
        this.addFossilVariant(FAFossilVariants.LEGACY_PTERANODON, "Legacy Pteranodon");
        this.addFossilVariant(FAFossilVariants.SPINOSAURUS, "Spinosaurus");
        this.addFossilVariant(FAFossilVariants.STEGOSAURUS, "Stegosaurus");
        this.addFossilVariant(FAFossilVariants.THERIZINOSAURUS, "Therizinosaurus");
        this.addFossilVariant(FAFossilVariants.TRICERATOPS, "Triceratops");
        this.addFossilVariant(FAFossilVariants.LEGACY_TRICERATOPS, "Legacy Triceratops");
        this.addFossilVariant(FAFossilVariants.TYRANNOSAURUS, "Tyrannosaurus");
        this.addFossilVariant(FAFossilVariants.VELOCIRAPTOR, "Velociraptor");

        // Game Rules
        this.add(FAGameRules.RULE_DOANIMALBLOCKBREAKING, "Do animals break blocks");
        this.add(FAGameRules.RULE_DOANIMALHUNGER, "Do animals get hungry");
        this.add(FAGameRules.RULE_DOANIMALGROWTH, "Do animals grow");

        // JEI
        this.add("gui.jei.category.registry.coat_types", "Coat Types");
        this.add("gui.jei.category.tagInformation.coat_types", "Coat Types");

        // Items
        this.add(FAItems.FOSSIL.get());
        this.add(FAItems.TRICERATOPS_DNA.get(), "Triceratops DNA");
        this.add(FAItems.VELOCIRAPTOR_DNA.get(), "Velociraptor DNA");
        this.add(FAItems.TYRANNOSAURUS_DNA.get(), "Tyrannosaurus DNA");
        this.add(FAItems.PTERANODON_DNA.get(), "Pteranodon DNA");
        this.add(FAItems.NAUTILUS_DNA.get(), "Nautilus DNA");
        this.add(FAItems.FUTABASAURUS_DNA.get(), "Futabasaurus DNA");
        this.add(FAItems.MOSASAURUS_DNA.get(), "Mosasaurus DNA");
        this.add(FAItems.STEGOSAURUS_DNA.get(), "Stegosaurus DNA");
        this.add(FAItems.DILOPHOSAURUS_DNA.get(), "Dilophosaurus DNA");
        this.add(FAItems.BRACHIOSAURUS_DNA.get(), "Brachiosaurus DNA");
        this.add(FAItems.CARNOTAURUS_DNA.get(), "Carnotaurus DNA");
        this.add(FAItems.CRYOLOPHOSAURUS_DNA.get(), "Cryolophosaurus DNA");
        this.add(FAItems.THERIZINOSAURUS_DNA.get(), "Therizinosaurus DNA");
        this.add(FAItems.PACHYCEPHALOSAURUS_DNA.get(), "Pachycephalosaurus DNA");
        this.add(FAItems.COMPSOGNATHUS_DNA.get(), "Compsognathus DNA");
        this.add(FAItems.GALLIMIMUS_DNA.get(), "Gallimimus DNA");
        this.add(FAItems.SPINOSAURUS_DNA.get(), "Spinosaurus DNA");
        this.add(FAItems.ANKYLOSAURUS_DNA.get(), "Ankylosaurus DNA");
        this.add(FAItems.DIMETRODON_DNA.get(), "Dimetrodon DNA");
        this.add(FAItems.ICHTHYOSAURUS_DNA.get(), "Ichthyosaurus DNA");
        this.add(FAItems.DRYOSAURUS_DNA.get(), "Dryosaurus DNA");
        this.add(FAItems.ELASMOTHERIUM_DNA.get(), "Elasmotherium DNA");
        this.add(FAItems.BARYONYX_DNA.get(), "Baryonyx DNA");
        this.add("item.fossilslegacy.model_type", "Model Type: %s");
        this.add("item.fossilslegacy.skin", "Pattern: %s");
        this.add(FAItems.JURASSIC_FERN_DNA.get());
        this.add(FAItems.LEPIDODENDRON_DNA.get());
        this.add(FAItems.SIGILLARIA_DNA.get());
        this.add(FAItems.CALAMITES_DNA.get());
        this.add(FAItems.TRICERATOPS_EGG.get());
        this.add(FAItems.VELOCIRAPTOR_EGG.get());
        this.add(FAItems.TYRANNOSAURUS_EGG.get());
        this.add(FAItems.PTERANODON_EGG.get());
        this.add(FAItems.NAUTILUS_EGGS.get());
        this.add(FAItems.FUTABASAURUS_EGG.get());
        this.add(FAItems.MOSASAURUS_EGG.get());
        this.add(FAItems.STEGOSAURUS_EGG.get());
        this.add(FAItems.DILOPHOSAURUS_EGG.get());
        this.add(FAItems.BRACHIOSAURUS_EGG.get());
        this.add(FAItems.CARNOTAURUS_EGG.get());
        this.add(FAItems.CRYOLOPHOSAURUS_EGG.get());
        this.add(FAItems.THERIZINOSAURUS_EGG.get());
        this.add(FAItems.PACHYCEPHALOSAURUS_EGG.get());
        this.add(FAItems.COMPSOGNATHUS_EGG.get());
        this.add(FAItems.GALLIMIMUS_EGG.get());
        this.add(FAItems.SPINOSAURUS_EGG.get());
        this.add(FAItems.ANKYLOSAURUS_EGG.get());
        this.add(FAItems.DIMETRODON_EGG.get());
        this.add(FAItems.ICHTHYOSAURUS_EGG.get());
        this.add(FAItems.RAW_TRICERATOPS.get());
        this.add(FAItems.RAW_VELOCIRAPTOR.get());
        this.add(FAItems.RAW_TYRANNOSAURUS.get());
        this.add(FAItems.RAW_PTERANODON.get());
        this.add(FAItems.NAUTILUS.get());
        this.add(FAItems.RAW_FUTABASAURUS.get());
        this.add(FAItems.RAW_MOSASAURUS.get());
        this.add(FAItems.RAW_STEGOSAURUS.get());
        this.add(FAItems.RAW_DILOPHOSAURUS.get());
        this.add(FAItems.RAW_BRACHIOSAURUS.get());
        this.add(FAItems.RAW_SMILODON.get());
        this.add(FAItems.RAW_MAMMOTH.get());
        this.add(FAItems.RAW_CARNOTAURUS.get());
        this.add(FAItems.RAW_CRYOLOPHOSAURUS.get());
        this.add(FAItems.RAW_THERIZINOSAURUS.get());
        this.add(FAItems.RAW_PACHYCEPHALOSAURUS.get());
        this.add(FAItems.RAW_COMPSOGNATHUS.get());
        this.add(FAItems.RAW_DODO.get());
        this.add(FAItems.RAW_MOA.get());
        this.add(FAItems.RAW_GALLIMIMUS.get());
        this.add(FAItems.RAW_SPINOSAURUS.get());
        this.add(FAItems.RAW_ANKYLOSAURUS.get());
        this.add(FAItems.RAW_DIMETRODON.get());
        this.add(FAItems.RAW_ICHTHYOSAURUS.get());
        this.add(FAItems.COOKED_TRICERATOPS.get());
        this.add(FAItems.COOKED_VELOCIRAPTOR.get());
        this.add(FAItems.COOKED_TYRANNOSAURUS.get());
        this.add(FAItems.COOKED_PTERANODON.get());
        this.add(FAItems.SIO_CHIU_LE.get(), "Sio-Chiu-Le");
        this.add(FAItems.COOKED_FUTABASAURUS.get());
        this.add(FAItems.COOKED_MOSASAURUS.get());
        this.add(FAItems.COOKED_STEGOSAURUS.get());
        this.add(FAItems.COOKED_DILOPHOSAURUS.get());
        this.add(FAItems.COOKED_BRACHIOSAURUS.get());
        this.add(FAItems.COOKED_SMILODON.get());
        this.add(FAItems.COOKED_MAMMOTH.get());
        this.add(FAItems.COOKED_CARNOTAURUS.get());
        this.add(FAItems.COOKED_CRYOLOPHOSAURUS.get());
        this.add(FAItems.COOKED_THERIZINOSAURUS.get());
        this.add(FAItems.COOKED_PACHYCEPHALOSAURUS.get());
        this.add(FAItems.COOKED_COMPSOGNATHUS.get());
        this.add(FAItems.COOKED_DODO.get());
        this.add(FAItems.COOKED_MOA.get());
        this.add(FAItems.COOKED_GALLIMIMUS.get());
        this.add(FAItems.COOKED_SPINOSAURUS.get());
        this.add(FAItems.COOKED_ANKYLOSAURUS.get());
        this.add(FAItems.COOKED_DIMETRODON.get());
        this.add(FAItems.COOKED_ICHTHYOSAURUS.get());
        this.add(FAItems.TYRANNOSAURUS_TOOTH.get());
        this.add(FAItems.TOOTH_DAGGER.get());
        this.add(FAItems.THERIZINOSAURUS_CLAWS.get());
        this.add(FAItems.SKULL_STICK.get());
        this.add(FAItems.DINOPEDIA.get());
        this.add(FAItems.RAW_CHICKEN_SOUP_BUCKET.get(), "Bucket of Raw Chicken Soup");
        this.add(FAItems.RAW_BERRY_MEDLEY_BUCKET.get(), "Bucket of Raw Berry Medley");
        this.add(FAItems.COOKED_CHICKEN_SOUP_BUCKET.get(), "Bucket of Cooked Chicken Soup");
        this.add(FAItems.COOKED_BERRY_MEDLEY_BUCKET.get(), "Bucket of Cooked Berry Medley");
        this.add(FAItems.CHICKEN_ESSENCE_BOTTLE.get());
        this.add(FAItems.ROMANTIC_CONCOCTION_BOTTLE.get());
        this.add(FAItems.LEGACY_GENETIC_CODE.get());
        this.add(FAItems.NAUTILUS_SHELL.get());
        this.add(FAItems.MAGIC_CONCH.get());
        this.add("item.fossilslegacy.magic_conch.desc", "%s");
        this.add("item.fossilslegacy.magic_conch.use", "Set all commanded with a magic conch in a 30-Block Area to %s");
        this.add(FAItems.FROZEN_MEAT.get());
        this.add(FAItems.BROKEN_FROZEN_MEAT.get(), "Frozen Meat");
        this.add(FAItems.ARMADILLO_DNA.get(), "Armadillo DNA");
        this.add(FAItems.AXOLOTL_DNA.get(), "Axolotl DNA");
        this.add(FAItems.CAT_DNA.get(), "Cat DNA");
        this.add(FAItems.CHICKEN_DNA.get(), "Chicken DNA");
        this.add(FAItems.COW_DNA.get(), "Cow DNA");
        this.add(FAItems.DOLPHIN_DNA.get(), "Dolphin DNA");
        this.add(FAItems.DONKEY_DNA.get(), "Donkey DNA");
        this.add(FAItems.FOX_DNA.get(), "Fox DNA");
        this.add(FAItems.FROG_DNA.get(), "Frog DNA");
        this.add(FAItems.GOAT_DNA.get(), "Goat DNA");
        this.add(FAItems.HORSE_DNA.get(), "Horse DNA");
        this.add(FAItems.LLAMA_DNA.get(), "Llama DNA");
        this.add(FAItems.MULE_DNA.get(), "Mule DNA");
        this.add(FAItems.OCELOT_DNA.get(), "Ocelot DNA");
        this.add(FAItems.PANDA_DNA.get(), "Panda DNA");
        this.add(FAItems.PARROT_DNA.get(), "Parrot DNA");
        this.add(FAItems.PIG_DNA.get(), "Pig DNA");
        this.add(FAItems.POLAR_BEAR_DNA.get(), "Polar Bear DNA");
        this.add(FAItems.RABBIT_DNA.get(), "Rabbit DNA");
        this.add(FAItems.SHEEP_DNA.get(), "Sheep DNA");
        this.add(FAItems.WOLF_DNA.get(), "Wolf DNA");
        this.add(FAItems.SMILODON_DNA.get(), "Smilodon DNA");
        this.add(FAItems.MAMMOTH_DNA.get(), "Mammoth DNA");
        this.add(FAItems.DODO_DNA.get(), "Dodo DNA");
        this.add(FAItems.MOA_DNA.get(), "Moa DNA");
        this.add(FAItems.ARMADILLO_EMBRYO_SYRINGE.get());
        this.add(FAItems.CAT_EMBRYO_SYRINGE.get());
        this.add(FAItems.INCUBATED_CHICKEN_EGG.get());
        this.add(FAItems.COW_EMBRYO_SYRINGE.get());
        this.add(FAItems.DONKEY_EMBRYO_SYRINGE.get());
        this.add(FAItems.DOLPHIN_EMBRYO_SYRINGE.get());
        this.add(FAItems.FOX_EMBRYO_SYRINGE.get());
        this.add(FAItems.GOAT_EMBRYO_SYRINGE.get());
        this.add(FAItems.HORSE_EMBRYO_SYRINGE.get());
        this.add(FAItems.LLAMA_EMBRYO_SYRINGE.get());
        this.add(FAItems.MULE_EMBRYO_SYRINGE.get());
        this.add(FAItems.OCELOT_EMBRYO_SYRINGE.get());
        this.add(FAItems.PANDA_EMBRYO_SYRINGE.get());
        this.add(FAItems.INCUBATED_PARROT_EGG.get());
        this.add(FAItems.PIG_EMBRYO_SYRINGE.get());
        this.add(FAItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        this.add(FAItems.RABBIT_EMBRYO_SYRINGE.get());
        this.add(FAItems.SHEEP_EMBRYO_SYRINGE.get());
        this.add(FAItems.WOLF_EMBRYO_SYRINGE.get());
        this.add(FAItems.SMILODON_EMBRYO_SYRINGE.get());
        this.add(FAItems.MAMMOTH_EMBRYO_SYRINGE.get());
        this.add(FAItems.INCUBATED_DODO_EGG.get());
        this.add(FAItems.DODO_EGG.get());
        this.add(FAItems.INCUBATED_MOA_EGG.get());
        this.add(FAItems.MOA_EGG.get());
        this.add(FAItems.JURASSIC_FERN_SPORES.get());
        this.add(FAItems.ARTICULATED_FOSSIL.get());
        this.add("item.fossilslegacy.articulated_fossil.ankylosaurus", "Articulated Ankylosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.brachiosaurus", "Articulated Brachiosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.legacy_brachiosaurus", "Articulated Legacy Brachiosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.carnotaurus", "Articulated Carnotaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.compsognathus", "Articulated Compsognathus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.cryolophosaurus", "Articulated Cryolophosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.dilophosaurus", "Articulated Dilophosaurs Fossil");
        this.add("item.fossilslegacy.articulated_fossil.dimetrodon", "Articulated Dimetrodon Fossil");
        this.add("item.fossilslegacy.articulated_fossil.futabasaurus", "Articulated Futabasaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.legacy_futabasaurus", "Articulated Legacy Futabasaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.gallimimus", "Articulated Gallimimus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.pachycephalosaurus", "Articulated Pachycephalosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.pteranodon", "Articulated Pteranodon Fossil");
        this.add("item.fossilslegacy.articulated_fossil.legacy_pteranodon", "Articulated Legacy Pteranodon Fossil");
        this.add("item.fossilslegacy.articulated_fossil.spinosaurus", "Articulated Spinosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.stegosaurus", "Articulated Stegosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.therizinosaurus", "Articulated Therizinosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.triceratops", "Articulated Triceratops Fossil");
        this.add("item.fossilslegacy.articulated_fossil.legacy_triceratops", "Articulated Legacy Triceratops Fossil");
        this.add("item.fossilslegacy.articulated_fossil.tyrannosaurus", "Articulated Tyrannosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.velociraptor", "Articulated Velociraptor Fossil");
        this.add(FAItems.RELIC_SCRAP.get());
        this.add(FAItems.STONE_TABLET.get());
        this.add(FAItems.ANCIENT_SWORD_ARTIFACT.get());
        this.add(FAItems.ANCIENT_SHOVEL_ARTIFACT.get());
        this.add(FAItems.ANCIENT_PICKAXE_ARTIFACT.get());
        this.add(FAItems.ANCIENT_AXE_ARTIFACT.get());
        this.add(FAItems.ANCIENT_HOE_ARTIFACT.get());
        this.add(FAItems.ANCIENT_HELMET_ARTIFACT.get());
        this.add(FAItems.ANCIENT_CHESTPLATE_ARTIFACT.get());
        this.add(FAItems.ANCIENT_LEGGINGS_ARTIFACT.get());
        this.add(FAItems.ANCIENT_BOOTS_ARTIFACT.get());
        this.add(FAItems.SCARAB_GEM.get());
        this.add(FAItems.JADE.get());
        this.add(FAItems.JADE_OCELOT.get());
        this.add(FAItems.JADE_VILLAGER.get());
        this.add(FAItems.CODEX.get());
        this.add(FAItems.QUIPU.get());
        this.add(FAItems.ANCIENT_SWORD.get());
        this.add(FAItems.ANCIENT_SHOVEL.get());
        this.add(FAItems.ANCIENT_PICKAXE.get());
        this.add(FAItems.ANCIENT_AXE.get());
        this.add(FAItems.ANCIENT_HOE.get());
        this.add(FAItems.ANCIENT_HELMET.get());
        this.add(FAItems.ANCIENT_CHESTPLATE.get());
        this.add(FAItems.ANCIENT_LEGGINGS.get());
        this.add(FAItems.ANCIENT_BOOTS.get());
        this.add(FAItems.SCARAB_GEM_SWORD.get());
        this.add(FAItems.SCARAB_GEM_SHOVEL.get());
        this.add(FAItems.SCARAB_GEM_PICKAXE.get());
        this.add(FAItems.SCARAB_GEM_AXE.get());
        this.add(FAItems.SCARAB_GEM_HOE.get());
        this.add(FAItems.SCARAB_GEM_HELMET.get());
        this.add(FAItems.SCARAB_GEM_CHESTPLATE.get());
        this.add(FAItems.SCARAB_GEM_LEGGINGS.get());
        this.add(FAItems.SCARAB_GEM_BOOTS.get());
        this.add(FAItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), "Smithing Template");
        this.add(FAItems.WOODEN_JAVELIN.get());
        this.add(FAItems.BROKEN_WOODEN_JAVELIN.get(), "Wooden Javelin");
        this.add(FAItems.STONE_JAVELIN.get());
        this.add(FAItems.BROKEN_STONE_JAVELIN.get(), "Stone Javelin");
        this.add(FAItems.IRON_JAVELIN.get());
        this.add(FAItems.BROKEN_IRON_JAVELIN.get(), "Iron Javelin");
        this.add(FAItems.GOLDEN_JAVELIN.get());
        this.add(FAItems.BROKEN_GOLDEN_JAVELIN.get(), "Golden Javelin");
        this.add(FAItems.DIAMOND_JAVELIN.get());
        this.add(FAItems.BROKEN_DIAMOND_JAVELIN.get(), "Diamond Javelin");
        this.add(FAItems.NETHERITE_JAVELIN.get());
        this.add(FAItems.BROKEN_NETHERITE_JAVELIN.get(), "Netherite Javelin");
        this.add(FAItems.SCARAB_GEM_JAVELIN.get());
        this.add(FAItems.BROKEN_SCARAB_GEM_JAVELIN.get(), "Scarab Gem Javelin");

        this.add(FAItems.JEEP_1993.get(), "1993 Jeep");

        this.add(FAItems.ANU_SPAWN_EGG.get());

        this.add(FAItems.FAILURESAURUS_SPAWN_EGG.get());

        this.add(FAItems.BRACHIOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.DILOPHOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.MAMMOTH_SPAWN_EGG.get());
        this.add(FAItems.MOSASAURUS_SPAWN_EGG.get());
        this.add(FAItems.NAUTILUS_SPAWN_EGG.get());
        this.add(FAItems.FUTABASAURUS_SPAWN_EGG.get());
        this.add(FAItems.PTERANODON_SPAWN_EGG.get());
        this.add(FAItems.SMILODON_SPAWN_EGG.get());
        this.add(FAItems.STEGOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.TRICERATOPS_SPAWN_EGG.get());
        this.add(FAItems.TYRANNOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.VELOCIRAPTOR_SPAWN_EGG.get());
        this.add(FAItems.CARNOTAURUS_SPAWN_EGG.get());
        this.add(FAItems.CRYOLOPHOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.THERIZINOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.PACHYCEPHALOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.COMPSOGNATHUS_SPAWN_EGG.get());
        this.add(FAItems.DODO_SPAWN_EGG.get());
        this.add(FAItems.MOA_SPAWN_EGG.get());
        this.add(FAItems.GALLIMIMUS_SPAWN_EGG.get());
        this.add(FAItems.SPINOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.ANKYLOSAURUS_SPAWN_EGG.get());
        this.add(FAItems.DIMETRODON_SPAWN_EGG.get());
        this.add(FAItems.ICHTHYOSAURUS_SPAWN_EGG.get());
        this.add("item.fossilslegacy.dinosaur_spawn_egg.desc", "Crouch to spawn baby");

        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.applies_to", "Netherite Equipment");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.ingredient", "Scarab Gem");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.base_slot_description", "Add netherite weapon or tool");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.additions_slot_description", "Add scarab gem");

        this.add(FAItems.OVERWORLD_COIN.get());
        this.add(FAItems.ICE_AGE_COIN.get());
        this.add(FAItems.PREHISTORIC_COIN.get());

        this.add(FAItems.LEPIDODENDRON_BOAT.get());
        this.add(FAItems.LEPIDODENDRON_CHEST_BOAT.get(), "Lepidodendron Boat with Chest");
        this.add(FAItems.SIGILLARIA_BOAT.get());
        this.add(FAItems.SIGILLARIA_CHEST_BOAT.get(), "Sigillaria Boat with Chest");
        this.add(FAItems.CALAMITES_BOAT.get());
        this.add(FAItems.CALAMITES_CHEST_BOAT.get(), "Calamites Boat with Chest");

        this.add(FAItems.DEBUG_MAX_HUNGER.get(), "Debug Max Hunger");
        this.add(FAItems.DEBUG_MAX_HEALTH.get(), "Debug Max Health");
        this.add(FAItems.DEBUG_FULL_GROWN.get(), "Debug Full Grown");
        this.add(FAItems.DEBUG_BABY.get(), "Debug Baby");
        this.add(FAItems.DEBUG_TAME.get(), "Debug Tame");
        this.add(FAItems.DEBUG_CHANGE_GENETICS.get(), "Debug Change Genetics");

        this.add("item.fossilslegacy.dna.era", "Era: %s");
        this.add("item.fossilslegacy.dna.period", "Period: %s");

        this.add(GeologicalTimeScale.Era.CENOZOIC, "Cenozoic");
        this.add(GeologicalTimeScale.Era.MESOZOIC, "Mesozoic");
        this.add(GeologicalTimeScale.Era.PALEOZOIC, "Paleozoic");

        this.add(GeologicalTimeScale.Period.QUATERNARY, "Quaternary");
        this.add(GeologicalTimeScale.Period.NEOGENE, "Neogene");
        this.add(GeologicalTimeScale.Period.PALEOGENE, "Paleogene");
        this.add(GeologicalTimeScale.Period.CRETACEOUS, "Cretaceous");
        this.add(GeologicalTimeScale.Period.JURASSIC, "Jurassic");
        this.add(GeologicalTimeScale.Period.TRIASSIC, "Triassic");
        this.add(GeologicalTimeScale.Period.PERMIAN, "Permian");
        this.add(GeologicalTimeScale.Period.CARBONIFEROUS, "Carboniferous");
        this.add(GeologicalTimeScale.Period.DEVONIAN, "Devonian");
        this.add(GeologicalTimeScale.Period.SILURIAN, "Silurian");
        this.add(GeologicalTimeScale.Period.ORDOVICIAN, "Ordovician");
        this.add(GeologicalTimeScale.Period.CAMBRIAN, "Cambrian");

        // JEI
        this.add("jei.fossilslegacy.analyzation", "Analyzation");
        this.add("jei.fossilslegacy.ancient_axe_bonus", "Ancient Axe Bonus");
        this.add("jei.fossilslegacy.ancient_axe_bonus.count", "%s - %s items");
        this.add("jei.fossilslegacy.archaeology", "Archaeology");
        this.add("jei.fossilslegacy.articulated_fossil", "Articulated Fossil");
        this.add("jei.fossilslegacy.biomatter", "Biomatter");
        this.add("jei.fossilslegacy.biomatter.biomatterCount.single", "Biomatter for 1 item");
        this.add("jei.fossilslegacy.biomatter.biomatterCount", "Biomatter for %s items");
        this.add("jei.fossilslegacy.cultivation", "Cultivation");
        this.add("jei.fossilslegacy.feeder", "Feeder");
        this.add("jei.fossilslegacy.feeder.food_level", "Provides %s food");
        this.add("jei.fossilslegacy.gene_modification", "Gene Modification");
        this.add("jei.fossilslegacy.gene_modification.coat_type", "Cosmetic");
        this.add("jei.fossilslegacy.gene_modification.use_genetic_code", "Unlocks %s Coat Types");
        this.add("jei.fossilslegacy.information", "Information");
        this.add("jei.fossilslegacy.information.informationCount.single", "Information for 1 item");
        this.add("jei.fossilslegacy.information.informationCount", "Information for %s items");
        this.add("jei.fossilslegacy.jewel_recovery", "Jewel Recovery");

        // Keys
        this.add("key.fossilslegacy.apply_gene", "Apply Gene");
        this.add("key.fossilslegacy.navigate_left", "Navigate Left");
        this.add("key.fossilslegacy.navigate_right", "Navigate Right");
        this.add("key.fossilslegacy.navigate_up", "Navigate Up");
        this.add("key.fossilslegacy.navigate_down", "Navigate Down");
        this.add("key.fossilslegacy.sink", "Sink");

        this.add("key.categories.fossilslegacy.dinosaur_ridding", "Dinosaur Ridding");

        // Patterns
        this.add("skin.fossilslegacy.american_bison", "American Bison");
        this.add("skin.fossilslegacy.blue_iguana", "Blue Iguana");
        this.add("skin.fossilslegacy.broadhead_skink", "Broadhead Skink");
        this.add("skin.fossilslegacy.domestic_pigeon", "Domestic Pigeon");
        this.add("skin.fossilslegacy.eastern_brown_snake", "Eastern Brown Snake");
        this.add("skin.fossilslegacy.eastern_indigo_snake", "Eastern Indigo Snake");
        this.add("skin.fossilslegacy.gray_ratsnake", "Gray Ratsnake");
        this.add("skin.fossilslegacy.green_parakeet", "Green Parakeet");
        this.add("skin.fossilslegacy.green_tree_python", "Green Tree Python");
        this.add("skin.fossilslegacy.inland_taipan", "Inland Taipan");
        this.add("skin.fossilslegacy.marine_iguana", "Marine Iguana");
        this.add("skin.fossilslegacy.northern_cardinal", "Northern Cardinal");
        this.add("skin.fossilslegacy.tiger", "Tiger");
        this.addSkin("amazon_rainforest", "Amazon Rainforest");
        this.addSkin("champlain_valley", "Champlain Valley");
        this.addSkin("death_valley", "Death Valley");
        this.addSkin("gambia_river_basin", "Gambia River Basin");
        this.addSkin("great_sandy_desert", "Great Sandy Desert");
        this.addSkin("limpopo_river", "Limpopo River");
        this.addSkin("mangrove_forest", "Mangrove Forest");
        this.addSkin("qilian_mountains", "Qilian Mountains");
        this.addSkin("salar_del_huasco", "Salar del Huasco");
        this.addSkin("sonoran_desert", "Sonoran Desert");
        this.addSkin("yukon_river", "Yukon River");
        this.addSkin("svalbard", "Svalbard");
        this.addPattern("blank", "Patternless");
        this.addPattern("chalcorana", "Chalcorana");
        this.addPattern("lithobates", "Lithobates");
        this.addPattern("papurana", "Papurana");
        this.addPattern("pelophylax", "Pelophylax");
        this.addPattern("pulchrana", "Pulchrana");
        this.addPattern("rana", "Rana");

        this.add("pattern_holder.fossilslegacy.composite", "%s / %s");

        // Resource Packs
        this.add("resourcePack.fossilslegacy.description", "Fossils and Archaeology: Legacy Assets");
        this.add("resourcePack.fossilslegacy.fa_legacy_textures.description", "1.3.2 Assets");
        this.add("resourcePack.fossilslegacy.fa_legacy_textures.modelName", "F/A Original Textures");

        // Stats
        this.addStat(FAStats.INTERACT_WITH_ANALYZER, "Interactions with Analyzer");
        this.addStat(FAStats.INTERACT_WITH_ARCHAEOLOGY_WORKBENCH, "Interactions with Archaeology Workbench");
        this.addStat(FAStats.INTERACT_WITH_CULTIVATOR, "Interactions with Cultivator");
        this.addStat(FAStats.INTERACT_WITH_FEEDER, "Interactions with Feeder");
        this.addStat(FAStats.INTERACT_WITH_GENE_MODIFICATION_TABLE, "Interactions with Gene Modification Table");
        this.addStat(FAStats.INTERACT_WITH_PALAEONTOLOGY_TABLE, "Interactions with Palaeontology Table");

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
        this.add("subtitles.entity.ankylosaurus.ambient", "Ankylosaurus calls");
        this.add("subtitles.entity.ankylosaurus.hurt", "Ankylosaurus hurts");
        this.add("subtitles.entity.ankylosaurus.death", "Ankylosaurus dies");
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
        this.add("subtitles.entity.dimetrodon.ambient", "Dimetrodon hisses");
        this.add("subtitles.entity.dimetrodon.hurt", "Dimetrodon hurts");
        this.add("subtitles.entity.dimetrodon.death", "Dimetrodon dies");
        this.add("subtitles.entity.dodo.ambient", "Dodo hoots");
        this.add("subtitles.entity.dodo.hurt", "Dodo hurts");
        this.add("subtitles.entity.dodo.death", "Dodo dies");
        this.add("subtitles.block.drum.hit", "Drum hit");
        this.add("subtitles.block.drum.triple_hit", "Drum triple hit");
        this.add("subtitles.entity.mammoth.ambient", "Mammoth trumpets");
        this.add("subtitles.entity.mammoth.hurt", "Mammoth hurts");
        this.add("subtitles.entity.mammoth.death", "Mammoth dies");
        this.add("subtitles.entity.moa.ambient", "Moa calls");
        this.add("subtitles.entity.moa.hurt", "Moa hurts");
        this.add("subtitles.entity.moa.death", "Moa dies");
        this.add("subtitles.entity.futabasaurus.ambient", "Futabasaurus chirps");
        this.add("subtitles.entity.futabasaurus.hurt", "Futabasaurus hurts");
        this.add("subtitles.entity.futabasaurus.death", "Futabasaurus dies");
        this.add("subtitles.entity.gallimimus.ambient", "Gallimimus calls");
        this.add("subtitles.entity.gallimimus.hurt", "Gallimimus hurts");
        this.add("subtitles.entity.gallimimus.death", "Gallimimus dies");
        this.add("subtitles.entity.pachycephalosaurus.ambient", "Pachycephalosaurus chirps");
        this.add("subtitles.entity.pachycephalosaurus.hurt", "Pachycephalosaurus hurts");
        this.add("subtitles.entity.pachycephalosaurus.death", "Pachycephalosaurus dies");
        this.add("subtitles.entity.pteranodon.ambient", "Pteranodon calls");
        this.add("subtitles.entity.pteranodon.hurt", "Pteranodon hurts");
        this.add("subtitles.entity.pteranodon.death", "Pteranodon dies");
        this.add("subtitles.entity.smilodon.ambient", "Smilodon roars");
        this.add("subtitles.entity.smilodon.hurt", "Smilodon hurts");
        this.add("subtitles.entity.smilodon.death", "Smilodon dies");
        this.add("subtitles.entity.spinosaurus.ambient", "Spinosaurus roars");
        this.add("subtitles.entity.spinosaurus.hurt", "Spinosaurus hurts");
        this.add("subtitles.entity.spinosaurus.death", "Spinosaurus dies");
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

        // Tags
        this.add(FAAnalyzerResultTags.FOSSIL_RESULTS, "Fossil Results");
        this.add(FAAnalyzerResultTags.RELIC_SCRAP_RESULTS, "Relic Scrap Results");
        this.add(FAAnalyzerResultTags.FROZEN_MEAT_RESULTS, "Frozen Meat Results");
        this.add(FAAnalyzerResultTags.AXOLOTL_BUCKET_RESULTS, "Axolotl Bucket Results");
        this.add(FAAnalyzerResultTags.TROPICAL_FISH_BUCKET_RESULTS, "Tropical Fish Bucket Results");
        this.add(FAAnalyzerResultTags.PORKCHOP_RESULTS, "Porkchop Results");
        this.add(FAAnalyzerResultTags.BEEF_RESULTS, "Beef Results");
        this.add(FAAnalyzerResultTags.CHICKEN_RESULTS, "Chicken Results");
        this.add(FAAnalyzerResultTags.FEATHER_RESULTS, "Feather Results");
        this.add(FAAnalyzerResultTags.BAMBOO_RESULTS, "Bamboo Results");
        this.add(FAAnalyzerResultTags.SLIME_BALL_RESULTS, "Slime Ball Results");
        this.add(FAAnalyzerResultTags.MUTTON_RESULTS, "Mutton Results");
        this.add(FAAnalyzerResultTags.RAW_RABBIT_RESULTS, "Raw Rabbit Results");
        this.add(FAAnalyzerResultTags.BONE_RESULTS, "Bone Results");
        this.add(FAAnalyzerResultTags.EMERALD_RESULTS, "Emerald Results");
        this.add(FAAnalyzerResultTags.GOAT_HORN_RESULTS, "Goat Horn Results");
        this.add(FAAnalyzerResultTags.FROGLIGHT_RESULTS, "Froglight Results");
        this.add(FAAnalyzerResultTags.LEATHER_RESULTS, "Leather Results");
        this.add(FAAnalyzerResultTags.STRING_RESULTS, "String Results");
        this.add(FAAnalyzerResultTags.COD_RESULTS, "Cod Results");
        this.add(FAAnalyzerResultTags.SALMON_RESULTS, "Salmon Results");
        this.add(FAAnalyzerResultTags.WOOL_RESULTS, "Wool Results");
        this.add(FAAnalyzerResultTags.ARMADILLO_SCUTE_RESULTS, "Armadillo Scute Results");
        this.add(FAAnalyzerResultTags.RAW_BRACHIOSAURUS_RESULTS, "Raw Brachiosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_DILOPHOSAURUS_RESULTS, "Raw Dimetrodon Results");
        this.add(FAAnalyzerResultTags.RAW_MAMMOTH_RESULTS, "Raw Mammoth Results");
        this.add(FAAnalyzerResultTags.RAW_MOSASAURUS_RESULTS, "Raw Mosasaurus Results");
        this.add(FAAnalyzerResultTags.RAW_FUTABASAURUS_RESULTS, "Raw Futabasaurus Results");
        this.add(FAAnalyzerResultTags.RAW_PTERANODON_RESULTS, "Raw Pteranodon Results");
        this.add(FAAnalyzerResultTags.RAW_SMILODON_RESULTS, "Raw Smilodon Results");
        this.add(FAAnalyzerResultTags.RAW_STEGOSAURUS_RESULTS, "Raw Stegosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_TRICERATOPS_RESULTS, "Raw Triceratops Results");
        this.add(FAAnalyzerResultTags.RAW_TYRANNOSAURUS_RESULTS, "Raw Tyrannosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_VELOCIRAPTOR_RESULTS, "Raw Velociraptor Results");
        this.add(FAAnalyzerResultTags.RAW_CARNOTAURUS_RESULTS, "Raw Carnotaurus Results");
        this.add(FAAnalyzerResultTags.RAW_CRYOLOPHOSAURUS_RESULTS, "Raw Cryolophosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_THERIZINOSAURUS_RESULTS, "Raw Therizinosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_PACHYCEPHALOSAURUS_RESULTS, "Raw Pachycephalosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_COMPSOGNATHUS_RESULTS, "Raw Compsognathus Results");
        this.add(FAAnalyzerResultTags.RAW_DODO_RESULTS, "Raw Dodo Results");
        this.add(FAAnalyzerResultTags.RAW_MOA_RESULTS, "Raw Moa Results");
        this.add(FAAnalyzerResultTags.RAW_GALLIMIMUS_RESULTS, "Raw Gallimimus Results");
        this.add(FAAnalyzerResultTags.RAW_SPINOSAURUS_RESULTS, "Raw Spinosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_ANKYLOSAURUS_RESULTS, "Raw Ankylosaurus Results");
        this.add(FAAnalyzerResultTags.RAW_DIMETRODON_RESULTS, "Raw Dimetrodon Results");

        this.add(FABiomeTags.HAS_ACADEMY, "Has Academy");
        this.add(FABiomeTags.HAS_LAB, "Has Lab");
        this.add(FABiomeTags.HAS_MACHU_PICCHU, "Has Machu Picchu");
        this.add(FABiomeTags.HAS_MAYAN_TEMPLE, "Has Mayan Temple");
        this.add(FABiomeTags.HAS_MOAI, "Has Moai");
        this.add(FABiomeTags.HAS_TOTEM_POLE, "Has Totem Pole");
        this.add(FABiomeTags.HAS_WEAPON_SHOP, "Has Weapon Shop");

        this.add(FABlockTags.ANKYLOSAURUS_SPAWNABLE, "Ankylosaurus Spawnable");
        this.add(FABlockTags.BRACHIOSAURUS_SPAWNABLE, "Brachiosaurus Spawnable");
        this.add(FABlockTags.CALAMITES_LOGS, "Calamites Logs");
        this.add(FABlockTags.CARNOTAURUS_SPAWNABLE, "Carnotaurus Spawnable");
        this.add(FABlockTags.COMPSOGNATHUS_SPAWNABLE, "Compsognathus Spawnable");
        this.add(FABlockTags.CRYOLOPHOSAURUS_SPAWNABLE, "Cryolophosaurus Spawnable");
        this.add(FABlockTags.DILOPHOSAURUS_SPAWNABLE, "Dilophosaurus Spawnable");
        this.add(FABlockTags.DIMETRODON_SPAWNABLE, "Dimetrodon Spawnable");
        this.add(FABlockTags.DODO_SPAWNABLE, "Dodo Spawnable");
        this.add(FABlockTags.EATABLE_FERN, "Eatable Fern");
        this.add(FABlockTags.EATABLE_LEAVES, "Eatable Leaves");
        this.add(FABlockTags.FEEDER, "Feeder");
        this.add(FABlockTags.GALLIMIMUS_SPAWNABLE, "Gallimimus Spawnable");
        this.add(FABlockTags.JURASSIC_FERN_PLANTABLE_ON, "Jurassic Fern Plantable On");
        this.add(FABlockTags.LEPIDODENDRON_LOGS, "Lepidodendron Logs");
        this.add(FABlockTags.MAMMOTH_SPAWNABLE, "Mammoth Spawnable");
        this.add(FABlockTags.MOA_SPAWNABLE, "Moa Spawnable");
        this.add(FABlockTags.PACHYCEPHALOSAURUS_SPAWNABLE, "Pachycephalosaurus Spawnable");
        this.add(FABlockTags.PERMAFROST_FROSTABLE, "Permafrost Frostable");
        this.add(FABlockTags.PTERANODON_SPAWNABLE, "Pteranodon Spawnable");
        this.add(FABlockTags.SIGILLARIA_LOGS, "Sigillaria Logs");
        this.add(FABlockTags.SMILODON_SPAWNABLE, "Smilodon Spawnable");
        this.add(FABlockTags.SPINOSAURUS_SPAWNABLE, "Spinosaurus Spawnable");
        this.add(FABlockTags.SPINOSAURUS_UNBREAKABLES, "Spinosaurus Unbreakables");
        this.add(FABlockTags.STEGOSAURUS_SPAWNABLE, "Stegosaurus Spawnable");
        this.add(FABlockTags.THERIZINOSAURUS_SPAWNABLE, "Therizinosaurus Spawnable");
        this.add(FABlockTags.TRICERATOPS_SPAWNABLE, "Triceratops Spawnable");
        this.add(FABlockTags.TYRANNOSAURUS_SPAWNABLE, "Tyrannosaurus Spawnable");
        this.add(FABlockTags.TYRANNOSAURUS_UNBREAKABLES, "Tyrannosaurus Unbreakables");
        this.add(FABlockTags.VELOCIRAPTOR_SPAWNABLE, "Velociraptor Spawnable");

        this.add(FAModelTypeTags.ANKYLOSAURUS, "Ankylosaurus");
        this.add(FAModelTypeTags.BRACHIOSAURUS, "Brachiosaurus");
        this.add(FAModelTypeTags.NON_LEGACY_BRACHIOSAURUS, "Non-Legacy Brachiosaurus");
        this.add(FAModelTypeTags.CARNOTAURUS, "Carnotaurus");
        this.add(FAModelTypeTags.NON_LEGACY_CARNOTAURUS, "Non-Legacy Carnotaurus");
        this.add(FAModelTypeTags.COMPSOGNATHUS, "Compsognathus");
        this.add(FAModelTypeTags.CRYOLOPHOSAURUS, "Cryolophosaurus");
        this.add(FAModelTypeTags.NON_LEGACY_CRYOLOPHOSAURUS, "Non-Legacy Cryolophosaurus");
        this.add(FAModelTypeTags.DILOPHOSAURUS, "Dilophosaurus");
        this.add(FAModelTypeTags.NON_LEGACY_DILOPHOSAURUS, "Non-Legacy Dilophosaurus");
        this.add(FAModelTypeTags.DIMETRODON, "Dimetrodon");
        this.add(FAModelTypeTags.DODO, "Dodo");
        this.add(FAModelTypeTags.FUTABASAURUS, "Futabasaurus");
        this.add(FAModelTypeTags.NON_LEGACY_FUTABASAURUS, "Non-Legacy Futabasaurus");
        this.add(FAModelTypeTags.GALLIMIMUS, "Gallimimus");
        this.add(FAModelTypeTags.LEGACY, "Legacy");
        this.add(FAModelTypeTags.MAMMOTH, "Mammoth");
        this.add(FAModelTypeTags.NON_LEGACY_MAMMOTH, "Non-Legacy Mammoth");
        this.add(FAModelTypeTags.MOA, "Moa");
        this.add(FAModelTypeTags.MOSASAURUS, "Mosasaurus");
        this.add(FAModelTypeTags.NON_LEGACY_MOSASAURUS, "Non-Legacy Mosasaurus");
        this.add(FAModelTypeTags.PACHYCEPHALOSAURUS, "Pachycephalosaurus");
        this.add(FAModelTypeTags.PTERANODON, "Pteranodon");
        this.add(FAModelTypeTags.NON_LEGACY_PTERANODON, "Non-Legacy Pteranodon");
        this.add(FAModelTypeTags.SMILODON, "Smilodon");
        this.add(FAModelTypeTags.NON_LEGACY_SMILODON, "Non-Legacy Smilodon");
        this.add(FAModelTypeTags.SPINOSAURUS, "Spinosaurus");
        this.add(FAModelTypeTags.STEGOSAURUS, "Stegosaurus");
        this.add(FAModelTypeTags.NON_LEGACY_STEGOSAURUS, "Non-Legacy Stegosaurus");
        this.add(FAModelTypeTags.THERIZINOSAURUS, "Therizinosaurus");
        this.add(FAModelTypeTags.NON_LEGACY_THERIZINOSAURUS, "Non-Legacy Therizinosaurus");
        this.add(FAModelTypeTags.TRICERATOPS, "Triceratops");
        this.add(FAModelTypeTags.NON_LEGACY_TRICERATOPS, "Non-Legacy Triceratops");
        this.add(FAModelTypeTags.TYRANNOSAURUS, "Tyrannosaurus");
        this.add(FAModelTypeTags.NON_LEGACY_TYRANNOSAURUS, "Non-Legacy Tyrannosaurus");
        this.add(FAModelTypeTags.VELOCIRAPTOR, "Velociraptor");
        this.add(FAModelTypeTags.LEGACY_VELOCIRAPTOR, "Legacy Velociraptor");
        this.add(FAModelTypeTags.NON_LEGACY_VELOCIRAPTOR, "Non-Legacy Velociraptor");

        this.add(FADamageTypeTags.SPINOSAURUS_IMMUNE, "Spinosaurus Immune");
        this.add(FADamageTypeTags.TYRANNOSAURUS_IMMUNE, "Tyrannosaurus Immune");

        this.add(FAEntityTypeTags.CARNOTAURUS_VICTIMS, "Carnotaurus Victims");
        this.add(FAEntityTypeTags.COMPSOGNATHUS_VICTIMS, "Compsognathus Victims");
        this.add(FAEntityTypeTags.CRYOLOPHOSAURUS_VICTIMS, "Cryolophosaurus Victims");
        this.add(FAEntityTypeTags.DILOPHOSAURUS_VICTIMS, "Dilophosaurus Victims");
        this.add(FAEntityTypeTags.DIMETRODON_VICTIMS, "Dimetrodon Victims");
        this.add(FAEntityTypeTags.MAGIC_CONCH_COMMANDABLE, "Magic Conch Commandables");
        this.add(FAEntityTypeTags.MOSASAURUS_VICTIMS, "Mosasaurus Victims");
        this.add(FAEntityTypeTags.SPINOSAURUS_VICTIMS, "Spinosaurs Victims");
        this.add(FAEntityTypeTags.TYRANNOSAURUS_VICTIMS, "Tyrannosaurus Victims");
        this.add(FAEntityTypeTags.VELOCIRAPTOR_VICTIMS, "Velociraptor Victims");

        this.add(FAFluidTags.PERMAFROST_FREEZABLE, "Permaforst Freezable");

        this.add(FAFossilVariantTags.PLACEABLE_FROM_FOSSIL, "Placeable from Fossil");

        this.add(FAFuelEntryTags.ARCHAEOLOGY_WORKBENCH, "Archaeology Workbench Fuels");
        this.add(FAFuelEntryTags.CULTIVATOR, "Cultivator Fuels");

        this.add(FAItemTags.ANKYLOSAURUS_COMMANDABLES, "Ankylosaurus Commandables");
        this.add(FAItemTags.BRACHIOSAURUS_COMMANDABLES, "Brachiosaurus Commandables");
        this.add(FAItemTags.CAKE_EGGS, "Cake Eggs");
        this.add(FAItemTags.CALAMITES_LOGS, "Calamites Logs");
        this.add(FAItemTags.CARNIVORE_FOODS, "Carnivore Foods");
        this.add(FAItemTags.CARNOTAURUS_COMMANDABLES, "Canotaurus Commandables");
        this.add(FAItemTags.COMPSOGNATHUS_COMMANDABLES, "Compsognathus Commandables");
        this.add(FAItemTags.CRYOLOPHOSAURUS_COMMANDABLES, "Cryolophosaurus Commandables");
        this.add(FAItemTags.DILOPHOSAURUS_COMMANDABLES, "Dilophosaurus Commandables");
        this.add(FAItemTags.DIMETRODON_COMMANDABLES, "Dimetrodon Commandables");
        this.add(FAItemTags.DNA, "DNA");
        this.add(FAItemTags.DRUM_INSTRUMENT, "Drum Instrument");
        this.add(FAItemTags.FROGLIGHTS, "Froglights");
        this.add(FAItemTags.GALLIMIMUS_COMMANDABLES, "Gallimimus Commandables");
        this.add(FAItemTags.ICHTHYOSAURUS_COMMANDABLES, "Ichthyosaurus Commandables");
        this.add(FAItemTags.HERBIVORE_FOODS, "Herbivore Foods");
        this.add(FAItemTags.LEPIDODENDRON_LOGS, "Lepidodendron Logs");
        this.add(FAItemTags.MAMMOTH_COMMANDABLES, "Mammoth Commandables");
        this.add(FAItemTags.MESOZOIC_FOSSIL, "Mesozoic Fossil");
        this.add(FAItemTags.OMNIVORE_FOODS, "Omnivore Foods");
        this.add(FAItemTags.PACHYCEPHALOSAURUS_COMMANDABLES, "Pachycephalosaurus Commandables");
        this.add(FAItemTags.PIGLIN_TAMING_ARMOR, "Piglin Taming Armor");
        this.add(FAItemTags.PISCIVORE_FOODS, "Piscivore Foods");
        this.add(FAItemTags.PTERANODON_COMMANDABLES, "Pteranodon Commandables");
        this.add(FAItemTags.REPAIR_WHEN_BROKEN_IN_ARCHAEOLOGY_TABLE, "Repair When Broken In Archaeology Table");
        this.add(FAItemTags.SIGILLARIA_LOGS, "Sigillaria Logs");
        this.add(FAItemTags.SPINOSAURUS_COMMANDABLES, "Spinosaurus Commandables");
        this.add(FAItemTags.STEGOSAURUS_COMMANDABLES, "Stegosaurus Commandables");
        this.add(FAItemTags.TRICERATOPS_COMMANDABLES, "Triceratops Commandables");
        this.add(FAItemTags.THERIZINOSAURUS_COMMANDABLES, "Therizinosaurus Commandables");
        this.add(FAItemTags.TYRANNOSAURUS_COMMANDABLES, "Tyrannosaurus Commandables");

        this.add(FAStoneTabletVariantTags.PLACEABLE, "Placeable");

        this.add(FAStructureTags.ICHTHYOSAURUS_LOCATED, "Ichthyosaurus Located");
        this.add(FAStructureTags.ACADEMY, "Academy");
        this.add(FAStructureTags.MACHU_PICCHU, "Machu Picchu");
        this.add(FAStructureTags.MAYAN_TEMPLE, "Mayan Temple");
        this.add(FAStructureTags.WEAPON_SHOP, "Weapon Shop");

        // Upgrades
        this.add("upgrade.fossilslegacy.scarab_gem_upgrade", "Scarab Gem Upgrade");
    }

    public void add(SpeakerType<?> speakerType, String translation) {
        this.add(speakerType.getTranslationKey(), translation);
    }

    public void addFossilVariant(ResourceKey<FossilVariant> fossilVariant, String translation) {
        this.add(fossilVariant.location().toLanguageKey("fossil_variant"), translation);
    }

    public void addModelType(ResourceKey<ModelType> modelType, String translation) {
        this.add(modelType.location().toLanguageKey("model_type"), translation);
    }

    public void addSkin(String pattern, String translation) {
        this.add("skin.fossilslegacy." + pattern, translation);
    }

    public void addPattern(String pattern, String translation) {
        this.add("pattern.fossilslegacy." + pattern, translation);
    }

    public void addStat(ResourceLocation stat, String name) {
        this.add("stat." + stat.getNamespace() + "." + stat.getPath(), name);
    }

    public void add(GeologicalTimeScale.Era era, String name) {
        this.add("item.fossilslegacy.dna.era." + era.getName(), name);
    }

    public void add(GeologicalTimeScale.Period period, String name) {
        this.add("item.fossilslegacy.dna.period." + period.getName(), name);
    }
}
