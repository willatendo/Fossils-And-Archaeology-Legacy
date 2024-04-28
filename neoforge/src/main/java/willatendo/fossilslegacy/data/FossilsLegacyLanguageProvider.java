package willatendo.fossilslegacy.data;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class FossilsLegacyLanguageProvider extends LanguageProvider {
    private final String modId;

    public FossilsLegacyLanguageProvider(PackOutput packfabricDataOutput, String modId, String local) {
        super(packfabricDataOutput, modId, local);
        this.modId = modId;
    }

    @Override
    protected void addTranslations() {
        // Advancements
        this.add("advancements.fossilslegacy.anu.root.title", "Broken Rule");
        this.add("advancements.fossilslegacy.anu.root.desc", "Bring Anu to the Overworld!");

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

        // Cloth-Config
        this.add("text.autoconfig.fossilslegacy.title", "Fossils and Archaeology Legacy");

        this.add("text.autoconfig.fossilslegacy.category.common", "Common Options");
        this.add("text.autoconfig.fossilslegacy.option.common.animalsStarve", "Animals Starve");
        this.add("text.autoconfig.fossilslegacy.option.common.animalsBreakBlocks", "Animals Break Blocks");
        this.add("text.autoconfig.fossilslegacy.option.common.animalsGrow", "Animals Grow");
        this.add("text.autoconfig.fossilslegacy.option.common.anuSpawns", "Anu Spawns");

        this.add("text.autoconfig.fossilslegacy.category.server", "Server Options");
        this.add("text.autoconfig.fossilslegacy.option.server.enableExperiments", "Enable Experiments");

        // Blocks
        this.add(FossilsLegacyBlocks.FOSSIL_ORE.get());
        this.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.add(FossilsLegacyBlocks.SKULL_BLOCK.get());
        this.add(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        this.add(FossilsLegacyBlocks.ANALYZER.get());
        this.add(FossilsLegacyBlocks.CULTIVATOR.get());
        this.add("block.fossilslegacy.cultivator.shatter", "Warning! Cultivation failure!");
        this.add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        this.add(FossilsLegacyBlocks.JURASSIC_FERN.get());
        this.add(FossilsLegacyBlocks.DRUM.get());
        this.add("block.fossilslegacy.drum.hit", "Set all creatures that are commanded with a %s to %s.");
        this.add(FossilsLegacyBlocks.FEEDER.get());
        this.add(FossilsLegacyBlocks.PERMAFROST.get());
        this.add(FossilsLegacyBlocks.ICED_STONE.get());
        this.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get());
        this.add(FossilsLegacyBlocks.TIME_MACHINE.get());

        // Commands
        this.add("command.fossilslegacy.follow", "Follow");
        this.add("command.fossilslegacy.stay", "Stay");
        this.add("command.fossilslegacy.free_move", "Free Move");
        this.add("command.fossilslegacy.command.use", "Set to %s");
        this.add("command.fossilslegacy.magic_conch.use", "Set all plesiosaurs in a 30 block radius to %s.");

        // Creative Mode Tab
        this.add(FossilsLegacyCreativeModeTabs.FOSSILS_LEGACY.get(), "F/A: Legacy");

        // Resource Packs
        this.add("resourcePack.fossilslegacy.description", "Fossils and Archaeology: Legacy Edition Assets");
        this.add("resourcePack.fossilslegacy.fa_legacy_textures.description", "Fossils and Archaeology Legacy Assets");

        // Deaths
        this.add("death.attack.dinosaur_starve", "%1$s starved to death");
        this.add("death.attack.dilophosaurus_envenomation", "%1$s was envenomated by %2$s");
        this.add("death.attack.javelin", "%1$s was impaled by %2$s");

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

        // Data Packs
        this.add("dataPack.fossilslegacy.fa_experiments.description", "Enables Experimental F/A Legacy Features");

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
        this.add(FossilsLegacyEntityTypes.DILOPHOSAURUS.get());
        this.add(FossilsLegacyEntityTypes.MAMMOTH.get());
        this.add(FossilsLegacyEntityTypes.MOSASAURUS.get());
        this.add(FossilsLegacyEntityTypes.NAUTILUS.get());
        this.add(FossilsLegacyEntityTypes.FUTABASAURUS.get());
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
        this.add(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), "Smildon");
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
        this.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.ANU_SUMMON, "All hiel Anu!");
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
        this.add(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get());
        this.add(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_PTERANODON_MEAT.get());
        this.add(FossilsLegacyItems.NAUTILUS.get());
        this.add(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_SMILODON_MEAT.get());
        this.add(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get());
        this.add(FossilsLegacyItems.RAW_CARNOTAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_CRYOLOPHOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.RAW_THERIZINOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_PTERANODON_MEAT.get());
        this.add(FossilsLegacyItems.SIO_CHIU_LE.get(), "Sio-Chiu-Le");
        this.add(FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_SMILODON_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_CARNOTAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_CRYOLOPHOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.COOKED_THERIZINOSAURUS_MEAT.get());
        this.add(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
        this.add(FossilsLegacyItems.TOOTH_DAGGER.get());
        this.add(FossilsLegacyItems.THERIZINOSAURUS_CLAWS.get());
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
        this.add("item.fossilslegacy.dinosaur_spawn_egg.desc", "Crouch to spawn baby");

        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.applies_to", "Netherite Equipment");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.ingredients", "Scarab Gem");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.base_slot_description", "Add netherite weapon or tool");
        this.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.additions_slot_description", "Add scarab gem");

        this.add(FossilsLegacyItems.OVERWORLD_COIN.get());
        this.add(FossilsLegacyItems.NETHER_COIN.get());
        this.add(FossilsLegacyItems.PREHISTORIC_COIN.get());

        for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
            this.add(items.get(), "Debug Item");
        }

        this.add("debugItem.fossilslegacy.type", "Type: %s");
        this.add("debugItem.fossilslegacy.set_max_hunger", "Set Max Hunger");
        this.add("debugItem.fossilslegacy.set_max_health", "Set Max Health");
        this.add("debugItem.fossilslegacy.set_full_grown", "Set Full Grown");
        this.add("debugItem.fossilslegacy.set_baby", "Set Baby");
        this.add("debugItem.fossilslegacy.set_owner_as_me", "Set Owner As Me");

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

        // Menus
        this.add("menu.fossilslegacy.analyzer", "Analyzer");
        this.add("menu.fossilslegacy.archaeology_workbench", "Archaeology Workbench");
        this.add("menu.fossilslegacy.cultivator", "Cultivator");
        this.add("menu.fossilslegacy.feeder", "Feeder");
        this.add("menu.fossilslegacy.time_machine", "Time Machine");
        this.add("menu.fossilslegacy.time_machine.start", "Start");
        this.add("menu.fossilslegacy.time_machine.memory", "Memory");

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
        this.add("sound.fossilslegacy.carnotaurus.ambient", "Carnotaurus Grumbles");
        this.add("sound.fossilslegacy.carnotaurus.hurt", "Carnotaurus Hurts");
        this.add("sound.fossilslegacy.carnotaurus.death", "Carnotaurus Dies");
        this.add("sound.fossilslegacy.cryolophosaurus.ambient", "Cryolophosaurus Grumbles");
        this.add("sound.fossilslegacy.cryolophosaurus.hurt", "Cryolophosaurus Hurts");
        this.add("sound.fossilslegacy.cryolophosaurus.death", "Cryolophosaurus Dies");
        this.add("sound.fossilslegacy.dilophosaurus.ambient", "Dilophosaurus Hisses");
        this.add("sound.fossilslegacy.dilophosaurus.call", "Dilophosaurus Calls");
        this.add("sound.fossilslegacy.dilophosaurus.hurt", "Dilophosaurus Hurts");
        this.add("sound.fossilslegacy.dilophosaurus.death", "Dilophosaurus Dies");
        this.add("sound.fossilslegacy.drum.hit", "Drum Hit");
        this.add("sound.fossilslegacy.drum.triple_hit", "Drum Triple Hit");
        this.add("sound.fossilslegacy.mammoth.ambient", "Mammoth Trumpets");
        this.add("sound.fossilslegacy.mammoth.hurt", "Mammoth Hurts");
        this.add("sound.fossilslegacy.mammoth.death", "Mammoth Dies");
        this.add("sound.fossilslegacy.futabasaurus.ambient", "Futabasaurus Chirps");
        this.add("sound.fossilslegacy.futabasaurus.hurt", "Futabasaurus Hurts");
        this.add("sound.fossilslegacy.futabasaurus.death", "Futabasaurus Dies");
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
        this.add("sound.fossilslegacy.therizinosaurus.ambient", "Therizinosaurus Grumbles");
        this.add("sound.fossilslegacy.therizinosaurus.hurt", "Therizinosaurus Hurts");
        this.add("sound.fossilslegacy.therizinosaurus.death", "Therizinosaurus Dies");
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


    public void add(Block key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(Item key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(ItemStack key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(Enchantment key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(MobEffect key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(EntityType<?> key, String name) {
        this.add(key.getDescriptionId(), name);
    }

    public void add(Item item) {
        this.add(item, SimpleUtils.autoName(BuiltInRegistries.ITEM.getKey(item).getPath()));
    }

    public void add(Block block) {
        this.add(block, SimpleUtils.autoName(BuiltInRegistries.BLOCK.getKey(block).getPath()));
    }

    public void add(Enchantment enchantment) {
        this.add(enchantment, SimpleUtils.autoName(BuiltInRegistries.ENCHANTMENT.getKey(enchantment).getPath()));
    }

    public void add(MobEffect mobEffect) {
        this.add(mobEffect, SimpleUtils.autoName(BuiltInRegistries.MOB_EFFECT.getKey(mobEffect).getPath()));
    }

    public void add(EntityType<?> entityType) {
        this.add(entityType, SimpleUtils.autoName(BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath()));
    }

    public void add(SoundEvent soundEvent) {
        this.add(soundEvent, SimpleUtils.autoName(BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getPath()));
    }

    public void add(MenuType menuType) {
        this.add(menuType, SimpleUtils.autoName(BuiltInRegistries.MENU.getKey(menuType).getPath()));
    }

    public void add(String category, String advancement, String title, String desc) {
        this.add("advancements." + this.modId + "." + category + "." + advancement + ".title", title);
        this.add("advancements." + this.modId + "." + category + "." + advancement + ".desc", desc);
    }

    public void add(SoundEvent soundEvent, String name) {
        this.add("sound." + BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getNamespace() + BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getPath(), name);
    }

    public void add(MenuType menuType, String name) {
        this.add("menu." + BuiltInRegistries.MENU.getKey(menuType).getNamespace() + BuiltInRegistries.MENU.getKey(menuType).getPath(), name);
    }

    public void add(CreativeModeTab creativeModeTab, String name) {
        this.add(creativeModeTab.getDisplayName().getString(), name);
    }

    public void addDesc(Item item, String... descs) {
        for (int i = 0; i < descs.length; i++) {
            this.add(item.getDescriptionId() + ".desc" + i, descs[i]);
        }
    }

    public void addDesc(Item item, String desc) {
        this.add(item.getDescriptionId() + ".desc", desc);
    }

    public void addDesc(Block block, String... descs) {
        for (int i = 0; i < descs.length; i++) {
            this.add(block.getDescriptionId() + ".desc" + i, descs[i]);
        }
    }

    public void addDesc(Block block, String name) {
        this.add(block.getDescriptionId() + ".desc", name);
    }

    public void add(SpeakerType<?> speakerType, String translation) {
        this.add(speakerType.getTranslationKey(), translation);
    }
}
