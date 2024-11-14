package willatendo.fossilslegacy.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.Anu;
import willatendo.fossilslegacy.server.entity.FossilsLegacyEntityTypes;
import willatendo.fossilslegacy.server.entity.FossilsLegacyFossilVariants;
import willatendo.fossilslegacy.server.entity.TamedZombifiedPiglin;
import willatendo.fossilslegacy.server.entity.util.DinoSituation;
import willatendo.fossilslegacy.server.entity.util.interfaces.SpeakerType;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;
import willatendo.fossilslegacy.server.genetics.cosmetics.CoatType;
import willatendo.fossilslegacy.server.genetics.cosmetics.FossilsLegacyCoatTypes;
import willatendo.fossilslegacy.server.item.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.tags.*;
import willatendo.simplelibrary.data.SimpleLanguageProvider;

import java.util.Map;
import java.util.TreeMap;

public class FossilsLegacyLanguageProvider extends SimpleLanguageProvider {
    protected final Map<String, String> translations = new TreeMap();

    public FossilsLegacyLanguageProvider(PackOutput packOutput, String modId, String local) {
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
        this.add(FossilsLegacyBlocks.PALAEONTOLOGY_TABLE.get());
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
        this.add(FossilsLegacyBlocks.MAYAN_VASE.get());
        this.add(FossilsLegacyBlocks.MAYAN_JADE_VASE.get());
        this.add(FossilsLegacyBlocks.MAYAN_OCELOT_VASE.get());
        this.add(FossilsLegacyBlocks.MAYAN_VILLAGER_VASE.get());
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
        this.add(FossilsLegacyBlocks.SIGILLARIA_PLANKS.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_SAPLING.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_LOG.get());
        this.add(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_WOOD.get());
        this.add(FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_LEAVES.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_STAIRS.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_SIGN.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_DOOR.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_HANGING_SIGN.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_PRESSURE_PLATE.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_FENCE.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_TRAPDOOR.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_BUTTON.get());
        this.add(FossilsLegacyBlocks.SIGILLARIA_SLAB.get());
        this.add(FossilsLegacyBlocks.CALAMITES_PLANKS.get());
        this.add(FossilsLegacyBlocks.CALAMITES_SAPLING.get());
        this.add(FossilsLegacyBlocks.CALAMITES_LOG.get());
        this.add(FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get());
        this.add(FossilsLegacyBlocks.CALAMITES_WOOD.get());
        this.add(FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get());
        this.add(FossilsLegacyBlocks.CALAMITES_LEAVES.get());
        this.add(FossilsLegacyBlocks.CALAMITES_STAIRS.get());
        this.add(FossilsLegacyBlocks.CALAMITES_SIGN.get());
        this.add(FossilsLegacyBlocks.CALAMITES_DOOR.get());
        this.add(FossilsLegacyBlocks.CALAMITES_HANGING_SIGN.get());
        this.add(FossilsLegacyBlocks.CALAMITES_PRESSURE_PLATE.get());
        this.add(FossilsLegacyBlocks.CALAMITES_FENCE.get());
        this.add(FossilsLegacyBlocks.CALAMITES_TRAPDOOR.get());
        this.add(FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get());
        this.add(FossilsLegacyBlocks.CALAMITES_BUTTON.get());
        this.add(FossilsLegacyBlocks.CALAMITES_SLAB.get());

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
        this.addCoatType(FossilsLegacyCoatTypes.ANKYLOSAURUS, "Ankylosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.BRACHIOSAURUS, "Brachiosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.COMPSOGNATHUS, "Compsognathus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.CRYOLOPHOSAURUS, "Cryolophosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.DILOPHOSAURUS, "Dilophosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.DODO, "Dodo (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.FUTABASAURUS, "Futabasaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.GALLIMIMUS, "Gallimimus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.MOA, "Moa (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.MAMMOTH, "Mammoth (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.MOSASAURUS, "Mosasaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.PACHYCEPHALOSAURUS, "Pachycephalosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.PTERANODON, "Pteranodon (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.SMILODON, "Smilodon 2024)");
        this.addCoatType(FossilsLegacyCoatTypes.SPINOSAURUS, "Spinosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.STEGOSAURUS, "Stegosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.THERIZINOSAURUS, "Therizinosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.GREEN_TRICERATOPS, "Green Triceratops (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.BROWN_TRICERATOPS, "Brown Triceratops (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.TYRANNOSAURUS, "Tyrannosaurus (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.GREEN_VELOCIRAPTOR, "Green Velociraptor (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.SANDY_VELOCIRAPTOR, "Sandy Velociraptor (2024)");
        this.addCoatType(FossilsLegacyCoatTypes.WHITE_VELOCIRAPTOR, "White Velociraptor (2024)");

        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_BRACHIOSAURUS, "Brachiosaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_GREEN_CARNOTAURUS, "Green Carnotaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_RED_CARNOTAURUS, "Red Carnotaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_CRYOLOPHOSAURUS, "Cryolophosaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_DILOPHOSAURUS, "Dilophosaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_FUTABASAURUS, "Futabasaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_MAMMOTH, "Mammoth (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_MOSASAURUS, "Mosasaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_PTERANODON, "Pteranodon (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_SMILODON, "Smilodon (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_STEGOSAURUS, "Stegosaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_FEATHERED_THERIZINOSAURUS, "Featherless Therizinosaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_FEATHERLESS_THERIZINOSAURUS, "Featherless Therizinosaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_GREEN_TRICERATOPS, "Green Triceratops (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_BROWN_TRICERATOPS, "Brown Triceratops (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_TYRANNOSAURUS, "Tyrannosaurus (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_GREEN_VELOCIRAPTOR, "Green Velociraptor (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_SANDY_VELOCIRAPTOR, "Sandy Velociraptor (2011)");
        this.addCoatType(FossilsLegacyCoatTypes.LEGACY_WHITE_VELOCIRAPTOR, "White Velociraptor (2011)");

        this.add("coat_type.toast.title", "New Genetic Material Unlocked");
        this.add("coat_type.toast.description", "...");

        // Coat Types
        this.add("fossilVariant.fossilslegacy.ankylosaurus", "Ankylosaurus (2024)");
        this.add("fossilVariant.fossilslegacy.brachiosaurus", "Brachiosaurus (2024)");
        this.add("fossilVariant.fossilslegacy.green_carnotaurus", "Green Carnotaurus (2011)");
        this.add("fossilVariant.fossilslegacy.red_carnotaurus", "Red Carnotaurus (2011)");
        this.add("fossilVariant.fossilslegacy.compsognathus", "Compsognathus (2024)");
        this.add("fossilVariant.fossilslegacy.cryolophosaurus", "Cryolophosaurus (2011)");
        this.add("fossilVariant.fossilslegacy.dilophosaurus", "Dilophosaurus (2011)");
        this.add("fossilVariant.fossilslegacy.dodo", "Dodo (2024)");
        this.add("fossilVariant.fossilslegacy.futabasaurus", "Futabasaurus (2024)");
        this.add("fossilVariant.fossilslegacy.gallimimus", "Gallimimus (2024)");
        this.add("fossilVariant.fossilslegacy.mammoth", "Mammoth (2011)");
        this.add("fossilVariant.fossilslegacy.moa", "Moa (2024)");
        this.add("fossilVariant.fossilslegacy.mosasaurus", "Mosasaurus (2011)");
        this.add("fossilVariant.fossilslegacy.pachycephalosaurus", "Pachycephalosaurus (2024)");
        this.add("fossilVariant.fossilslegacy.pteranodon", "Pteranodon (2011)");
        this.add("fossilVariant.fossilslegacy.spinosaurus", "Spinosaurus (2024)");
        this.add("fossilVariant.fossilslegacy.stegosaurus", "Stegosaurus (2011)");
        this.add("fossilVariant.fossilslegacy.smilodon", "Smilodon (2011)");
        this.add("fossilVariant.fossilslegacy.feathered_therizinosaurus", "Feathered Therizinosaurus (2011)");
        this.add("fossilVariant.fossilslegacy.featherless_therizinosaurus", "Featherless Therizinosaurus (2011)");
        this.add("fossilVariant.fossilslegacy.brown_triceratops", "Brown Triceratops (2024)");
        this.add("fossilVariant.fossilslegacy.green_triceratops", "Green Triceratops (2024)");
        this.add("fossilVariant.fossilslegacy.tyrannosaurus_legacy", "Tyrannosaurus (2011)");
        this.add("fossilVariant.fossilslegacy.green_velociraptor", "Green Velociraptor (2024)");
        this.add("fossilVariant.fossilslegacy.sandy_velociraptor", "Sandy Velociraptor (2024)");
        this.add("fossilVariant.fossilslegacy.white_velociraptor", "White Velociraptor (2024)");
        this.add("fossilVariant.fossilslegacy.legacy_brachiosaurus", "Brachiosaurus (2011)");
        this.add("fossilVariant.fossilslegacy.legacy_futabasaurus", "Futabasaurus (2011)");
        this.add("fossilVariant.fossilslegacy.legacy_brown_triceratops", "Brown Triceratops (2011)");
        this.add("fossilVariant.fossilslegacy.legacy_green_triceratops", "Green Triceratops (2011)");
        this.add("fossilVariant.fossilslegacy.legacy_green_velociraptor", "Green Velociraptor (2011)");
        this.add("fossilVariant.fossilslegacy.legacy_sandy_velociraptor", "Sandy Velociraptor (2011)");
        this.add("fossilVariant.fossilslegacy.legacy_white_velociraptor", "White Velociraptor (2011)");

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
        this.add("container.fossilslegacy.gene_modification_table", "Gene Modification Table");
        this.add("container.fossilslegacy.gene_modification_table.apply_gene.tutorial", "Use '%s' to apply gene.");
        this.add("container.fossilslegacy.gene_modification_table.coat_type.location", "%s/%s");
        this.add("container.fossilslegacy.gene_modification_table.coat_type.none", "N/A");
        this.add("container.fossilslegacy.gene_modification_table.coat_type.no_genome_applicable", "No Applicable Genome");
        this.add("container.fossilslegacy.gene_modification_table.insert_dna", "Insert DNA");
        this.add("container.fossilslegacy.gene_modification_table.navigate_left.tutorial", "Use '%s' to navigate left.");
        this.add("container.fossilslegacy.gene_modification_table.navigate_right.tutorial", "Use '%s' to navigate right.");
        this.add("container.fossilslegacy.feeder", "Feeder");
        this.add("container.fossilslegacy.palaeontology_table", "Palaeontology Table");
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
        this.add(FossilsLegacyEntityTypes.ANKYLOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.BRACHIOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.COMPSOGNATHUS.get());
        this.add(FossilsLegacyEntityTypes.DILOPHOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.DIMETRODON.get());
        this.add(FossilsLegacyEntityTypes.DODO.get());
        this.add(FossilsLegacyEntityTypes.MOA.get());
        this.add(FossilsLegacyEntityTypes.MAMMOTH.get());
        this.add(FossilsLegacyEntityTypes.MOSASAURUS.get());
        this.add(FossilsLegacyEntityTypes.NAUTILUS.get());
        this.add(FossilsLegacyEntityTypes.FUTABASAURUS.get());
        this.add(FossilsLegacyEntityTypes.GALLIMIMUS.get());
        this.add(FossilsLegacyEntityTypes.PACHYCEPHALOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.PTERANODON.get());
        this.add(FossilsLegacyEntityTypes.SMILODON.get());
        this.add(FossilsLegacyEntityTypes.SPINOSAURUS.get());
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

        this.add("entity.minecraft.villager.fossilslegacy.archaeologist", "Archaeologist");
        this.add("entity.minecraft.archaeologist", "Archaeologist");
        this.add("entity.minecraft.villager.fossilslegacy.palaeontologist", "Palaentologist");
        this.add("entity.minecraft.palaeontologist", "Palaentologist");

        // Filled Maps
        this.add("filled_map.mayan_temple", "Mayan Explorer Map");

        // Fossil Variants
        this.addFossilVariant(FossilsLegacyFossilVariants.ANKYLOSAURUS, "Ankylosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.BRACHIOSAURUS, "Brachiosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.LEGACY_BRACHIOSAURUS, "Legacy Brachiosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.CARNOTAURUS, "Carnotaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.COMPSOGNATHUS, "Compsognathus");
        this.addFossilVariant(FossilsLegacyFossilVariants.CRYOLOPHOSAURUS, "Cryolophosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.DILOPHOSAURUS, "Dilophosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.DIMETRODON, "Dimetrodon");
        this.addFossilVariant(FossilsLegacyFossilVariants.FUTABASAURUS, "Futabasaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.LEGACY_FUTABASAURUS, "Legacy Futabasaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.GALLIMIMUS, "Gallimimus");
        this.addFossilVariant(FossilsLegacyFossilVariants.PACHYCEPHALOSAURUS, "Pachycephalosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.PTERANODON, "Pteranodon");
        this.addFossilVariant(FossilsLegacyFossilVariants.LEGACY_PTERANODON, "Legacy Pteranodon");
        this.addFossilVariant(FossilsLegacyFossilVariants.SPINOSAURUS, "Spinosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.STEGOSAURUS, "Stegosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.THERIZINOSAURUS, "Therizinosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.TRICERATOPS, "Triceratops");
        this.addFossilVariant(FossilsLegacyFossilVariants.LEGACY_TRICERATOPS, "Legacy Triceratops");
        this.addFossilVariant(FossilsLegacyFossilVariants.TYRANNOSAURUS, "Tyrannosaurus");
        this.addFossilVariant(FossilsLegacyFossilVariants.VELOCIRAPTOR, "Velociraptor");

        // JEI
        this.add("gui.jei.category.registry.coat_types", "Coat Types");
        this.add("gui.jei.category.tagInformation.coat_types", "Coat Types");

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
        this.add(FossilsLegacyItems.GALLIMIMUS_DNA.get(), "Gallimimus DNA");
        this.add(FossilsLegacyItems.SPINOSAURUS_DNA.get(), "Spinosaurus DNA");
        this.add(FossilsLegacyItems.ANKYLOSAURUS_DNA.get(), "Ankylosaurus DNA");
        this.add(FossilsLegacyItems.DIMETRODON_DNA.get(), "Dimetrodon DNA");
        this.add("item.fossilslegacy.dna.coat_type", "Coat Type: %s");
        this.add(FossilsLegacyItems.PETRIFIED_LEPIDODENDRON_SAPLING.get());
        this.add(FossilsLegacyItems.PETRIFIED_SIGILLARIA_SAPLING.get());
        this.add(FossilsLegacyItems.PETRIFIED_CALAMITES_SAPLING.get());
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
        this.add(FossilsLegacyItems.GALLIMIMUS_EGG.get());
        this.add(FossilsLegacyItems.SPINOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.ANKYLOSAURUS_EGG.get());
        this.add(FossilsLegacyItems.DIMETRODON_EGG.get());
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
        this.add(FossilsLegacyItems.RAW_MOA.get());
        this.add(FossilsLegacyItems.RAW_GALLIMIMUS.get());
        this.add(FossilsLegacyItems.RAW_SPINOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_ANKYLOSAURUS.get());
        this.add(FossilsLegacyItems.RAW_DIMETRODON.get());
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
        this.add(FossilsLegacyItems.COOKED_MOA.get());
        this.add(FossilsLegacyItems.COOKED_GALLIMIMUS.get());
        this.add(FossilsLegacyItems.COOKED_SPINOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_ANKYLOSAURUS.get());
        this.add(FossilsLegacyItems.COOKED_DIMETRODON.get());
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
        this.add(FossilsLegacyItems.LEGACY_GENETIC_CODE.get());
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
        this.add(FossilsLegacyItems.MOA_DNA.get(), "Moa DNA");
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
        this.add(FossilsLegacyItems.INCUBATED_MOA_EGG.get());
        this.add(FossilsLegacyItems.MOA_EGG.get());
        this.add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        this.add(FossilsLegacyItems.ARTICULATED_FOSSIL.get());
        this.add("item.fossilslegacy.articulated_fossil.ankylosaurus", "Articulated Ankylosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.brachiosaurus", "Articulated Brachiosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.legacy_brachiosaurus", "Articulated Legacy Brachiosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.carnotaurus", "Articulated Carnotaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.compsognathus", "Articulated Compsognathus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.cryolophosaurus", "Articulated Cryolophosaurus Fossil");
        this.add("item.fossilslegacy.articulated_fossil.dilophosaurus", "Articulated Dilophosaursu Fossil");
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
        this.add(FossilsLegacyItems.JADE.get());
        this.add(FossilsLegacyItems.JADE_OCELOT.get());
        this.add(FossilsLegacyItems.JADE_VILLAGER.get());
        this.add(FossilsLegacyItems.CODEX.get());
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
        this.add(FossilsLegacyItems.MOA_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.GALLIMIMUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.SPINOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.ANKYLOSAURUS_SPAWN_EGG.get());
        this.add(FossilsLegacyItems.DIMETRODON_SPAWN_EGG.get());
        this.add("item.fossilslegacy.dinosaur_spawn_egg.desc", "Crouch to spawn baby");

        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.applies_to", "Netherite Equipment");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.ingredient", "Scarab Gem");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.base_slot_description", "Add netherite weapon or tool");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.additions_slot_description", "Add scarab gem");

        this.add(FossilsLegacyItems.OVERWORLD_COIN.get());
        this.add(FossilsLegacyItems.ICE_AGE_COIN.get());
        this.add(FossilsLegacyItems.PREHISTORIC_COIN.get());

        this.add(FossilsLegacyItems.LEPIDODENDRON_BOAT.get());
        this.add(FossilsLegacyItems.LEPIDODENDRON_CHEST_BOAT.get(), "Lepidodendron Boat with Chest");
        this.add(FossilsLegacyItems.SIGILLARIA_BOAT.get());
        this.add(FossilsLegacyItems.SIGILLARIA_CHEST_BOAT.get(), "Sigillaria Boat with Chest");
        this.add(FossilsLegacyItems.CALAMITES_BOAT.get());
        this.add(FossilsLegacyItems.CALAMITES_CHEST_BOAT.get(), "Calamites Boat with Chest");

        this.add(FossilsLegacyItems.DEBUG_MAX_HUNGER.get(), "Debug Max Hunger");
        this.add(FossilsLegacyItems.DEBUG_MAX_HEALTH.get(), "Debug Max Health");
        this.add(FossilsLegacyItems.DEBUG_FULL_GROWN.get(), "Debug Full Grown");
        this.add(FossilsLegacyItems.DEBUG_BABY.get(), "Debug Baby");
        this.add(FossilsLegacyItems.DEBUG_TAME.get(), "Debug Tame");
        this.add(FossilsLegacyItems.DEBUG_CHANGE_GENETICS.get(), "Debug Change Genetics");

        // JEI
        this.add("jei.fossilslegacy.archaeology", "Archaeology");
        this.add("jei.fossilslegacy.articulated_fossil", "Articulated Fossil");
        this.add("jei.fossilslegacy.analyzation", "Analyzation");
        this.add("jei.fossilslegacy.cultivation", "Cultivation");
        this.add("jei.fossilslegacy.biomatter", "Biomatter");
        this.add("jei.fossilslegacy.biomatter.biomatterCount.single", "Biomatter for 1 item");
        this.add("jei.fossilslegacy.biomatter.biomatterCount", "Biomatter for %s items");
        this.add("jei.fossilslegacy.feeder", "Feeder");
        this.add("jei.fossilslegacy.feeder.food_level", "Provides %s food");
        this.add("jei.fossilslegacy.gene_modification", "Gene Modification");
        this.add("jei.fossilslegacy.gene_modification.coat_type", "Cosmetic");
        this.add("jei.fossilslegacy.gene_modification.use_genetic_code", "Unlocks %s Coat Types");

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
        this.add(FossilsLegacyBiomeTags.HAS_ACADEMY, "Has Academy");
        this.add(FossilsLegacyBiomeTags.HAS_MAYAN_TEMPLE, "Has Mayan Temple");
        this.add(FossilsLegacyBiomeTags.HAS_MOAI, "Has Moai");
        this.add(FossilsLegacyBiomeTags.HAS_TOTEM_POLE, "Has Totem Pole");
        this.add(FossilsLegacyBiomeTags.HAS_WEAPON_SHOP, "Has Weapon Shop");

        this.add(FossilsLegacyBlockTags.EATABLE_FERN, "Eatable Fern");
        this.add(FossilsLegacyBlockTags.EATABLE_LEAVES, "Eatable Leaves");
        this.add(FossilsLegacyBlockTags.FEEDER, "Feeder");
        this.add(FossilsLegacyBlockTags.JURASSIC_FERN_PLANTABLE_ON, "Jurassic Fern Plantable On");
        this.add(FossilsLegacyBlockTags.LEPIDODENDRON_LOGS, "Lepidodendron Logs");
        this.add(FossilsLegacyBlockTags.PERMAFROST_FROSTABLE, "Permafrost Frostable");
        this.add(FossilsLegacyBlockTags.SIGILLARIA_LOGS, "Sigillaria Logs");
        this.add(FossilsLegacyBlockTags.CALAMITES_LOGS, "Calamites Logs");
        this.add(FossilsLegacyBlockTags.SPINOSAURUS_UNBREAKABLES, "Spinosaurus Unbreakables");
        this.add(FossilsLegacyBlockTags.TYRANNOSAURUS_UNBREAKABLES, "Tyrannosaurus Unbreakables");

        this.add(FossilsLegacyCoatTypeTags.ANKYLOSAURUS, "Ankylosaurus");
        this.add(FossilsLegacyCoatTypeTags.BRACHIOSAURUS, "Brachiosaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_BRACHIOSAURUS, "Non-Legacy Brachiosaurus");
        this.add(FossilsLegacyCoatTypeTags.CARNOTAURUS, "Carnotaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_CARNOTAURUS, "Non-Legacy Carnotaurus");
        this.add(FossilsLegacyCoatTypeTags.COMPSOGNATHUS, "Compsognathus");
        this.add(FossilsLegacyCoatTypeTags.CRYOLOPHOSAURUS, "Cryolophosaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_CRYOLOPHOSAURUS, "Non-Legacy Cryolophosaurus");
        this.add(FossilsLegacyCoatTypeTags.DILOPHOSAURUS, "Dilophosaurus");
        this.add(FossilsLegacyCoatTypeTags.DIMETRODON, "Dimetrodon");
        this.add(FossilsLegacyCoatTypeTags.DODO, "Dodo");
        this.add(FossilsLegacyCoatTypeTags.FUTABASAURUS, "Futabasaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_FUTABASAURUS, "Non-Legacy Futabasaurus");
        this.add(FossilsLegacyCoatTypeTags.GALLIMIMUS, "Gallimimus");
        this.add(FossilsLegacyCoatTypeTags.LEGACY, "Legacy");
        this.add(FossilsLegacyCoatTypeTags.MOA, "Moa");
        this.add(FossilsLegacyCoatTypeTags.MAMMOTH, "Mammoth");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_MAMMOTH, "Non-Legacy Mammoth");
        this.add(FossilsLegacyCoatTypeTags.MOSASAURUS, "Mosasaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_MOSASAURUS, "Non-Legacy Mosasaurus");
        this.add(FossilsLegacyCoatTypeTags.PACHYCEPHALOSAURUS, "Pachycephalosaurus");
        this.add(FossilsLegacyCoatTypeTags.PTERANODON, "Pteranodon");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_PTERANODON, "Non-Legacy Pteranodon");
        this.add(FossilsLegacyCoatTypeTags.SMILODON, "Smilodon");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_SMILODON, "Non-Legacy Smilodon");
        this.add(FossilsLegacyCoatTypeTags.SPINOSAURUS, "Spinosaurus");
        this.add(FossilsLegacyCoatTypeTags.STEGOSAURUS, "Stegosaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_STEGOSAURUS, "Non-Legacy Stegosaurus");
        this.add(FossilsLegacyCoatTypeTags.THERIZINOSAURUS, "Therizinosaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_THERIZINOSAURUS, "Non-Legacy Therizinosaurus");
        this.add(FossilsLegacyCoatTypeTags.TRICERATOPS, "Triceratops");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_TRICERATOPS, "Non-Legacy Triceratops");
        this.add(FossilsLegacyCoatTypeTags.TYRANNOSAURUS, "Tyrannosaurus");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_TYRANNOSAURUS, "Non-Legacy Tyrannosaurus");
        this.add(FossilsLegacyCoatTypeTags.VELOCIRAPTOR, "Velociraptor");
        this.add(FossilsLegacyCoatTypeTags.LEGACY_VELOCIRAPTOR, "Legacy Velociraptor");
        this.add(FossilsLegacyCoatTypeTags.NON_LEGACY_VELOCIRAPTOR, "Non-Legacy Velociraptor");

        this.add(FossilsLegacyDamgeTypeTags.SPINOSAURUS_IMMUNE, "Spinosaurus Immune");
        this.add(FossilsLegacyDamgeTypeTags.TYRANNOSAURUS_IMMUNE, "Tyrannosaurus Immune");

        this.add(FossilsLegacyEntityTypeTags.CARNOTAURUS_VICTIMS, "Carnotaurus");
        this.add(FossilsLegacyEntityTypeTags.COMPSOGNATHUS_VICTIMS, "Compsognathus");
        this.add(FossilsLegacyEntityTypeTags.CRYOLOPHOSAURUS_VICTIMS, "Cryolophosaurus");
        this.add(FossilsLegacyEntityTypeTags.DILOPHOSAURUS_VICTIMS, "Dilophosaurus");
        this.add(FossilsLegacyEntityTypeTags.MOSASAURUS_VICTIMS, "Mosasaurus");
        this.add(FossilsLegacyEntityTypeTags.SPINOSAURUS_VICTIMS, "Spinosaurs");
        this.add(FossilsLegacyEntityTypeTags.TYRANNOSAURUS_VICTIMS, "Tyrannosaurus");
        this.add(FossilsLegacyEntityTypeTags.VELOCIRAPTOR_VICTIMS, "Velociraptor");

        this.add(FossilsLegacyFluidTags.PERMAFROST_FREEZABLE, "Permaforst Freezable");

        this.add(FossilsLegacyFossilVariantTags.PLACEABLE_FROM_FOSSIL, "Placeable from Fossil");

        this.add(FossilsLegacyItemTags.ANKYLOSAURUS_COMMANDABLES, "Ankylosaurus Commandables");
        this.add(FossilsLegacyItemTags.BRACHIOSAURUS_COMMANDABLES, "Brachiosaurus Commandables");
        this.add(FossilsLegacyItemTags.CAKE_EGGS, "Cake Eggs");
        this.add(FossilsLegacyItemTags.CALAMITES_LOGS, "Calamites Logs");
        this.add(FossilsLegacyItemTags.CARNIVORE_FOODS, "Carnivore Foods");
        this.add(FossilsLegacyItemTags.CARNOTAURUS_COMMANDABLES, "Canotaurus Commandables");
        this.add(FossilsLegacyItemTags.COMPSOGNATHUS_COMMANDABLES, "Compsognathus Commandables");
        this.add(FossilsLegacyItemTags.CRYOLOPHOSAURUS_COMMANDABLES, "Cryolophosaurus Commandables");
        this.add(FossilsLegacyItemTags.DILOPHOSAURUS_COMMANDABLES, "Dilophosaurus Commandables");
        this.add(FossilsLegacyItemTags.DNA, "DNA");
        this.add(FossilsLegacyItemTags.DRUM_INSTRUMENT, "Drum Instrument");
        this.add(FossilsLegacyItemTags.FROGLIGHTS, "Froglights");
        this.add(FossilsLegacyItemTags.GALLIMIMUS_COMMANDABLES, "Gallimimus Commandables");
        this.add(FossilsLegacyItemTags.HERBIVORE_FOODS, "Herbivore Foods");
        this.add(FossilsLegacyItemTags.LEPIDODENDRON_LOGS, "Lepidodendron Logs");
        this.add(FossilsLegacyItemTags.MAMMOTH_COMMANDABLES, "Mammoth Commandables");
        this.add(FossilsLegacyItemTags.MESOZOIC_FOSSIL, "Mesozoic Fossil");
        this.add(FossilsLegacyItemTags.OMNIVORE_FOODS, "Omnivore Foods");
        this.add(FossilsLegacyItemTags.PACHYCEPHALOSAURUS_COMMANDABLES, "Pachycephalosaurus Commandables");
        this.add(FossilsLegacyItemTags.PIGLIN_TAMING_ARMOR, "Piglin Taming Armor");
        this.add(FossilsLegacyItemTags.PISCIVORE_FOODS, "Piscivore Foods");
        this.add(FossilsLegacyItemTags.PTERANODON_COMMANDABLES, "Pteranodon Commandables");
        this.add(FossilsLegacyItemTags.REPAIR_WHEN_BROKEN_IN_ARCHAEOLOGY_TABLE, "Repair When Broken In Archaeology Table");
        this.add(FossilsLegacyItemTags.SIGILLARIA_LOGS, "Sigillaria Logs");
        this.add(FossilsLegacyItemTags.SPINOSAURUS_COMMANDABLES, "Spinosaurus Commandables");
        this.add(FossilsLegacyItemTags.STEGOSAURUS_COMMANDABLES, "Stegosaurus Commandables");
        this.add(FossilsLegacyItemTags.TRICERATOPS_COMMANDABLES, "Triceratops Commandables");
        this.add(FossilsLegacyItemTags.THERIZINOSAURUS_COMMANDABLES, "Therizinosaurus Commandables");
        this.add(FossilsLegacyItemTags.TYRANNOSAURUS_COMMANDABLES, "Tyrannosaurus Commandables");

        this.add(FossilsLegacyStoneTabletVariantTags.PLACEABLE, "Placeable");

        // Upgrades
        this.add("upgrade.fossilslegacy.scarab_gem_upgrade", "Scarab Gem Upgrade");
    }

    public void add(SpeakerType<?> speakerType, String translation) {
        this.add(speakerType.getTranslationKey(), translation);
    }

    public void addFossilVariant(ResourceKey<FossilVariant> fossilVariantResourceKey, String translation) {
        this.add(fossilVariantResourceKey.location().toLanguageKey("fossil_variant"), translation);
    }

    public void addCoatType(ResourceKey<CoatType> coatTypeResourceKey, String translation) {
        this.add(coatTypeResourceKey.location().toLanguageKey("coat_type"), translation);
    }

    @Override
    public void add(String key, String value) {
        super.add(key, value);
        if (this.translations.put(key, value) != null) {
            throw new IllegalStateException("Duplicate translation key " + key);
        }
    }
}
