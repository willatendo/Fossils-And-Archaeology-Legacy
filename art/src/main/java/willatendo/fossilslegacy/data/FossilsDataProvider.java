package willatendo.fossilslegacy.data;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import willatendo.fossilslegacy.experiments.server.block.FossilsExperimentsBlocks;
import willatendo.fossilslegacy.experiments.server.item.FossilsExperimentsItems;
import willatendo.fossilslegacy.server.FossilsLegacyCreativeModeTabs;
import willatendo.fossilslegacy.server.block.ArchaeologyWorkbenchBlock;
import willatendo.fossilslegacy.server.block.CultivatorBlock;
import willatendo.fossilslegacy.server.block.FeederBlock;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.entity.*;
import willatendo.fossilslegacy.server.item.FossilsLegacyItems;
import willatendo.fossilslegacy.server.sound.FossilsLegacySoundEvents;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.function.Function;

public class FossilsDataProvider {


    public static void addItemModels(BasicItemModelsProvider basicItemModelsProvider) {
        basicItemModelsProvider.basicItem(FossilsLegacyItems.FOSSIL.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.TRICERATOPS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.VELOCIRAPTOR_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.TYRANNOSAURUS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.PTERANODON_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.NAUTILUS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.FUTABASAURUS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.MOSASAURUS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.STEGOSAURUS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DILOPHOSAURUS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BRACHIOSAURUS_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.TRICERATOPS_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.VELOCIRAPTOR_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.PTERANODON_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.NAUTILUS_EGGS.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.FUTABASAURUS_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.MOSASAURUS_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.STEGOSAURUS_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_PTERANODON_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.NAUTILUS.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_SMILODON_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_PTERANODON_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SIO_CHIU_LE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_SMILODON_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.TOOTH_DAGGER.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.SKULL_STICK.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DINOPEDIA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.NAUTILUS_SHELL.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.FROZEN_MEAT.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get(), FossilsLegacyUtils.resource("item/frozen_meat"));
        basicItemModelsProvider.basicItem(FossilsLegacyItems.AXOLOTL_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.CAT_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.CHICKEN_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COW_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DOLPHIN_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DONKEY_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.FOX_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.FROG_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.GOAT_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.HORSE_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.LLAMA_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.MULE_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.OCELOT_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.PANDA_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.PARROT_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.PIG_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.POLAR_BEAR_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RABBIT_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SHEEP_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.WOLF_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SMILODON_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.MAMMOTH_DNA.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.INCUBATED_PARROT_EGG.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.MAGIC_CONCH.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.RELIC_SCRAP.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.STONE_TABLET.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SCARAB_GEM.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.ANCIENT_SWORD.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.ANCIENT_HELMET.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.SCARAB_GEM_SWORD.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.SCARAB_GEM_AXE.get());
        basicItemModelsProvider.handheldItem(FossilsLegacyItems.SCARAB_GEM_HOE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.WOODEN_JAVELIN.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), FossilsLegacyUtils.resource("item/wooden_javelin"));
        basicItemModelsProvider.basicItem(FossilsLegacyItems.STONE_JAVELIN.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), FossilsLegacyUtils.resource("item/stone_javelin"));
        basicItemModelsProvider.basicItem(FossilsLegacyItems.IRON_JAVELIN.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), FossilsLegacyUtils.resource("item/iron_javelin"));
        basicItemModelsProvider.basicItem(FossilsLegacyItems.GOLDEN_JAVELIN.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), FossilsLegacyUtils.resource("item/golden_javelin"));
        basicItemModelsProvider.basicItem(FossilsLegacyItems.DIAMOND_JAVELIN.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), FossilsLegacyUtils.resource("item/diamond_javelin"));
        basicItemModelsProvider.basicItem(FossilsLegacyItems.NETHERITE_JAVELIN.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), FossilsLegacyUtils.resource("item/netherite_javelin"));
        basicItemModelsProvider.basicItem(FossilsLegacyItems.SCARAB_GEM_JAVELIN.get());
        basicItemModelsProvider.basicItem(FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get(), FossilsLegacyUtils.resource("item/scarab_gem_javelin"));

        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.ANU_SPAWN_EGG.get());

        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());

        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
        basicItemModelsProvider.spawnEggItem(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());

        basicItemModelsProvider.basicItem(FossilsExperimentsItems.OVERWORLD_COIN.get());
        basicItemModelsProvider.basicItem(FossilsExperimentsItems.NETHER_COIN.get());
        basicItemModelsProvider.basicItem(FossilsExperimentsItems.PREHISTORIC_COIN.get());

        for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
            basicItemModelsProvider.handheldItem(items.get(), new ResourceLocation("item/bone"));
        }

        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.FOSSIL_ORE.get());
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.SKULL_BLOCK.get());
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.ANALYZER.get());
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.CULTIVATOR.get());
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        basicItemModelsProvider.basicItem(FossilsLegacyBlocks.JURASSIC_FERN.get(), FossilsLegacyUtils.resource("block/fern_lower_3"));
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.DRUM.get(), FossilsLegacyUtils.resource("block/drum_follow"));
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.FEEDER.get(), FossilsLegacyUtils.resource("block/feeder_empty"));
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.PERMAFROST.get());
        basicItemModelsProvider.blockItem(FossilsLegacyBlocks.ICED_STONE.get());
        basicItemModelsProvider.basicItem(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), FossilsLegacyUtils.resource("block/axolotlspawn"));
    }

    public static void addBlockStates(BasicBlockStateProvider basicBlockStateProvider) {
        basicBlockStateProvider.simpleBlock(FossilsLegacyBlocks.FOSSIL_ORE.get());
        basicBlockStateProvider.simpleBlock(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        basicBlockStateProvider.horizontalBlock(FossilsLegacyBlocks.SKULL_BLOCK.get(), "skull_block", FossilsLegacyUtils.resource("block/skull"), FossilsLegacyUtils.resource("block/skull"), FossilsLegacyUtils.resource("block/skull_front"), FossilsLegacyUtils.resource("block/skull_crack"), FossilsLegacyUtils.resource("block/skull_crack"), FossilsLegacyUtils.resource("block/skull_crack"), FossilsLegacyUtils.resource("block/skull_crack"));
        basicBlockStateProvider.horizontalBlock(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), "skull_lanturn_block", FossilsLegacyUtils.resource("block/skull"), FossilsLegacyUtils.resource("block/skull"), FossilsLegacyUtils.resource("block/skull_lanturn_front"), FossilsLegacyUtils.resource("block/skull_crack"), FossilsLegacyUtils.resource("block/skull_crack"), FossilsLegacyUtils.resource("block/skull_crack"), FossilsLegacyUtils.resource("block/skull_crack"));
        basicBlockStateProvider.horizontalBlockWithModelHolder(FossilsLegacyBlocks.ANALYZER.get(), blockState -> new BasicBlockStateProvider.ModelHolder("analyzer" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "_active" : ""), FossilsLegacyUtils.resource("block/analyzer_top"), FossilsLegacyUtils.resource("block/analyzer_top"), FossilsLegacyUtils.resource("block/analyzer_front_" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "on" : "off")), FossilsLegacyUtils.resource("block/analyzer_side"), FossilsLegacyUtils.resource("block/analyzer_side"), FossilsLegacyUtils.resource("block/analyzer_side"), FossilsLegacyUtils.resource("block/analyzer_side")));
        basicBlockStateProvider.statesBlock(FossilsLegacyBlocks.CULTIVATOR.get(), CultivatorBlock.ACTIVE, "cultivator", FossilsLegacyUtils.resource("block/cultivator_bottom"), FossilsLegacyUtils.resource("block/cultivator_top"), FossilsLegacyUtils.resource("block/cultivator_side_off"), FossilsLegacyUtils.resource("block/cultivator_side_off"), FossilsLegacyUtils.resource("block/cultivator_side_off"), FossilsLegacyUtils.resource("block/cultivator_side_off"), FossilsLegacyUtils.resource("block/cultivator_side_off"), "cultivator_active", FossilsLegacyUtils.resource("block/cultivator_bottom"), FossilsLegacyUtils.resource("block/cultivator_top"), FossilsLegacyUtils.resource("block/cultivator_side_on"), FossilsLegacyUtils.resource("block/cultivator_side_on"), FossilsLegacyUtils.resource("block/cultivator_side_on"), FossilsLegacyUtils.resource("block/cultivator_side_on"), FossilsLegacyUtils.resource("block/cultivator_side_on"));
        basicBlockStateProvider.horizontalBlockWithModelHolder(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), blockState -> new BasicBlockStateProvider.ModelHolder("archaeology_workbench" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "_active" : ""), new ResourceLocation("block/spruce_planks"), FossilsLegacyUtils.resource("block/archaeology_workbench_top_" + (blockState.getValue(ArchaeologyWorkbenchBlock.ACTIVE) ? "on" : "off")), FossilsLegacyUtils.resource("block/archaeology_workbench_books"), FossilsLegacyUtils.resource("block/archaeology_workbench_side"), FossilsLegacyUtils.resource("block/archaeology_workbench_side"), FossilsLegacyUtils.resource("block/archaeology_workbench_side"), FossilsLegacyUtils.resource("block/archaeology_workbench_side")));
        basicBlockStateProvider.fernBlock(FossilsLegacyBlocks.JURASSIC_FERN.get());
        basicBlockStateProvider.drumBlock(FossilsLegacyBlocks.DRUM.get());
        basicBlockStateProvider.horizontalBlockWithModelHolder(FossilsLegacyBlocks.FEEDER.get(), blockState -> new BasicBlockStateProvider.ModelHolder("feeder" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty"), new ResourceLocation("block/iron_block"), FossilsLegacyUtils.resource("block/feeder_top" + (blockState.getValue(FeederBlock.HAS_FOOD) ? "_full" : "_empty")), FossilsLegacyUtils.resource("block/feeder_front"), FossilsLegacyUtils.resource("block/feeder_side"), FossilsLegacyUtils.resource("block/feeder_side"), FossilsLegacyUtils.resource("block/feeder_side"), FossilsLegacyUtils.resource("block/feeder_side")));
        basicBlockStateProvider.simpleBlock(FossilsLegacyBlocks.PERMAFROST.get());
        basicBlockStateProvider.simpleBlock(FossilsLegacyBlocks.ICED_STONE.get());
        basicBlockStateProvider.parent(FossilsLegacyBlocks.AXOLOTLSPAWN.get(), "axolotlspawn", new ResourceLocation("block/frogspawn"), Pair.of("texture", FossilsLegacyUtils.resource("block/axolotlspawn")), Pair.of("particle", FossilsLegacyUtils.resource("block/axolotlspawn")));

        basicBlockStateProvider.parent(FossilsExperimentsBlocks.TIME_MACHINE.get(), "time_machine", FossilsLegacyUtils.resource("block/template_time_machine"));
    }

    public static void addSounds(BasicSoundDefinitionsProvider basicSoundDefinitionsProvider) {
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.BRACHIOSAURUS_AMBIENT.get(), "brachiosaurus.ambient", "brachiosaurus_ambient_1", "brachiosaurus_ambient_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.BRACHIOSAURUS_HURT.get(), "brachiosaurus.hurt", "brachiosaurus_hurt_1", "brachiosaurus_hurt_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.BRACHIOSAURUS_DEATH.get(), "brachiosaurus.death", "brachiosaurus_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.DILOPHOSAURUS_AMBIENT.get(), "dilophosaurus.ambient", "dilophosaurus_ambient");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.DILOPHOSAURUS_CALL.get(), "dilophosaurus.call", "dilophosaurus_call_1", "dilophosaurus_call_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.DILOPHOSAURUS_HURT.get(), "dilophosaurus.hurt", "dilophosaurus_hurt");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.DILOPHOSAURUS_DEATH.get(), "dilophosaurus.death", "dilophosaurus_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.MAMMOTH_AMBIENT.get(), "mammoth.ambient", "mammoth_ambient");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.MAMMOTH_HURT.get(), "mammoth.hurt", "mammoth_hurt");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.MAMMOTH_DEATH.get(), "mammoth.death", "mammoth_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.FUTABASAURUS_AMBIENT.get(), "futabasaurus.ambient", "futabasaurus_ambient");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.FUTABASAURUS_HURT.get(), "futabasaurus.hurt", "futabasaurus_hurt");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.FUTABASAURUS_DEATH.get(), "futabasaurus.death", "futabasaurus_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.PTERANODON_AMBIENT.get(), "pteranodon.ambient", "pteranodon_ambient_1", "pteranodon_ambient_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.PTERANODON_HURT.get(), "pteranodon.hurt", "pteranodon_hurt");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.PTERANODON_DEATH.get(), "pteranodon.death", "pteranodon_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.SMILODON_AMBIENT.get(), "smilodon.ambient", "smilodon_ambient_1", "smilodon_ambient_2", "smilodon_ambient_3");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.SMILODON_HURT.get(), "smilodon.hurt", "smilodon_hurt");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.SMILODON_DEATH.get(), "smilodon.death", "smilodon_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.STEGOSAURUS_AMBIENT.get(), "stegosaurus.ambient", "stegosaurus_ambient_1", "stegosaurus_ambient_2", "stegosaurus_ambient_3");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.STEGOSAURUS_HURT.get(), "stegosaurus.hurt", "stegosaurus_hurt");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.STEGOSAURUS_DEATH.get(), "stegosaurus.death", "stegosaurus_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.TRICERATOPS_AMBIENT.get(), "triceratops.ambient", "triceratops_ambient_1", "triceratops_ambient_2", "triceratops_ambient_3");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.TRICERATOPS_HURT.get(), "triceratops.hurt", "triceratops_hurt_1", "triceratops_hurt_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.TRICERATOPS_DEATH.get(), "triceratops.death", "triceratops_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.TYRANNOSAURUS_AMBIENT.get(), "tyrannosaurus.ambient", "tyrannosaurus_ambient_1", "tyrannosaurus_ambient_2", "tyrannosaurus_ambient_3");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.TYRANNOSAURUS_ATTACK.get(), "tyrannosaurus.attack", "tyrannosaurus_attack_1", "tyrannosaurus_attack_2", "tyrannosaurus_attack_3");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.TYRANNOSAURUS_HURT.get(), "tyrannosaurus.hurt", "tyrannosaurus_hurt");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.TYRANNOSAURUS_DEATH.get(), "tyrannosaurus.death", "tyrannosaurus_death");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_TAME.get(), "velociraptor.ambient.tame", "velociraptor_ambient_tame_1", "velociraptor_ambient_tame_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.VELOCIRAPTOR_AMBIENT_WILD.get(), "velociraptor.ambient.wild", "velociraptor_ambient_wild_1", "velociraptor_ambient_wild_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.VELOCIRAPTOR_ATTACK.get(), "velociraptor.attack", "velociraptor_attack_1", "velociraptor_attack_2");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.VELOCIRAPTOR_HURT.get(), "velociraptor.hurt", "velociraptor_hurt_1", "velociraptor_hurt_2", "velociraptor_hurt_3");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.VELOCIRAPTOR_DEATH.get(), "velociraptor.death", "velociraptor_death");

        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.DRUM_HIT.get(), "drum.hit", "drum_hit");
        basicSoundDefinitionsProvider.addSounds(FossilsLegacySoundEvents.DRUM_TRIPLE_HIT.get(), "drum.triple_hit", "drum_triple_hit");
    }

    public static void addTranslations(BasicTranslationsProvider basicTranslationsProvider) {
        // Advancements
        basicTranslationsProvider.add("advancements.fossilslegacy.anu.root.title", "Broken Rule");
        basicTranslationsProvider.add("advancements.fossilslegacy.anu.root.desc", "Bring Anu to the Overworld!");

        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.root.title", "The Legacy");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.root.desc", "Play the Fossils and Archaeology: Legacy!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.fossil.title", "Fossils!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.fossil.desc", "Aquire a fossil!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.relic_scrap.title", "Old News");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.relic_scrap.desc", "Aquire a relic scrap!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.title", "Once Feared");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_sword_artifact.desc", "Aquire a Sword Artifact.");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_sword.title", "1.21 Gigawatts!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_sword.desc", "Repair an Ancient Sword!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.pigman.title", "From the Dead!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.pigman.desc", "Spawn a pigman!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.title", "Black Magic");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_helmet_artifact.desc", "Aquire a Helmet Artifact");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_helmet.title", "Nether Connections");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.ancient_helmet.desc", "Repair an Ancient Helmet");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.tamed_pigman.title", "Till Death I'm To Serve You!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.tamed_pigman.desc", "Spawn a tamed pigman!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.archaeology_workbench.title", "An Archaeologist's Table!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.archaeology_workbench.desc", "Make a Archaeology Workbench!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.stone_tablet.title", "An Old Story");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.stone_tablet.desc", "Place a cave painting!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.skull_block.title", "Spooky Skeletons!");
        basicTranslationsProvider.add("advancements.fossilslegacy.legacy.skull_block.desc", "Or...Maybe just their skulls?");

        // Cloth-Config
        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.title", "Fossils and Archaeology Legacy");

        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.category.common", "Common Options");
        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.option.common.animalsStarve", "Animals Starve");
        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.option.common.animalsBreakBlocks", "Animals Break Blocks");
        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.option.common.animalsGrow", "Animals Grow");
        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.option.common.anuSpawns", "Anu Spawns");

        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.category.server", "Server Options");
        basicTranslationsProvider.add("text.autoconfig.fossilslegacy.option.server.enableExperiments", "Enable Experiments");

        // Blocks
        basicTranslationsProvider.add(FossilsLegacyBlocks.FOSSIL_ORE.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.SKULL_BLOCK.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.ANALYZER.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.CULTIVATOR.get());
        basicTranslationsProvider.add("block.fossilslegacy.cultivator.shatter", "Warning! Cultivation failure!");
        basicTranslationsProvider.add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.JURASSIC_FERN.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.DRUM.get());
        basicTranslationsProvider.add("block.fossilslegacy.drum.hit", "Set all creatures that are commanded with a %s to %s.");
        basicTranslationsProvider.add(FossilsLegacyBlocks.FEEDER.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.PERMAFROST.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.ICED_STONE.get());
        basicTranslationsProvider.add(FossilsLegacyBlocks.AXOLOTLSPAWN.get());

        basicTranslationsProvider.add(FossilsExperimentsBlocks.TIME_MACHINE.get());

        // Commands
        basicTranslationsProvider.add("command.fossilslegacy.follow", "Follow");
        basicTranslationsProvider.add("command.fossilslegacy.stay", "Stay");
        basicTranslationsProvider.add("command.fossilslegacy.free_move", "Free Move");
        basicTranslationsProvider.add("command.fossilslegacy.command.use", "Set to %s");
        basicTranslationsProvider.add("command.fossilslegacy.magic_conch.use", "Set all plesiosaurs in a 30 block radius to %s.");

        // Creative Mode Tab
        basicTranslationsProvider.add(FossilsLegacyCreativeModeTabs.FOSSILS_LEGACY.get(), "F/A: Legacy");

        // Data Pack
        basicTranslationsProvider.add("dataPack.fossilslegacy.description", "Fossils and Archaeology: Legacy Edition Assets");
        basicTranslationsProvider.add("dataPack.fossilslegacy.fa_legacy_textures.description", "Fossils and Archaeology Legacy Assets");
        basicTranslationsProvider.add("dataPack.fossilslegacy.experiments.description", "Fossils and Archaeology: Legacy Experiments Assets");

        // Deaths
        basicTranslationsProvider.add("death.attack.dinosaur_starve", "%1$s starved to death");
        basicTranslationsProvider.add("death.attack.dilophosaurus_envenomation", "%1$s was envenomated by %2$s");
        basicTranslationsProvider.add("death.attack.javelin", "%1$s was impaled by %2$s");

        // Dinopedia
        basicTranslationsProvider.add("dinopedia.fossilslegacy.able_to_fly", "Able to Fly");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.age", "Age: %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.cold", "Too Cold");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.creature", "Creature: %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.dangerous", "Caution: Dangerous");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.dry", "Too Dry");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.egg", "%s Egg");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.embryo", "Embryo: %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.health", "Health: %s / %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.hunger", "Hunger: %s / %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.not_owner", "You Are Not the Owner");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.owner", "Owner: %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.pregnancy_time", "Pregnancy Time: %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.remaining_time", "Hatching Time: %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.rideable", "Rideable");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.status", "Status: %s");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.warm", "Warm");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.wet", "Wet");
        basicTranslationsProvider.add("dinopedia.fossilslegacy.wild", "basicTranslationsProvider Animal is Wild");

        // Dino Situations
        basicTranslationsProvider.add(DinoSituation.HUNGRY, "%s is hungry!");
        basicTranslationsProvider.add(DinoSituation.STARVE, "%s is starving!");
        basicTranslationsProvider.add(DinoSituation.NO_SPACE, "%s has no space to grow!");
        basicTranslationsProvider.add(DinoSituation.STARVE_ESCAPE, "%s has escaped from starvation!");
        basicTranslationsProvider.add(DinoSituation.HURT_ESCAPE, "%s will not trust humanity again!");
        basicTranslationsProvider.add(DinoSituation.FULL, "%s is full!");
        basicTranslationsProvider.add(DinoSituation.TAME_TYRANNOSAURUS_ERROR_TOO_YOUNG, "%s is too young to be tamed!");
        basicTranslationsProvider.add(DinoSituation.TAME_TYRANNOSAURUS_ERROR_HEALTH, "%s must be knocked out to be tamed!");

        // Entities
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.BRACHIOSAURUS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.DILOPHOSAURUS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.MAMMOTH.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.MOSASAURUS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.NAUTILUS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.FUTABASAURUS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PTERANODON.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.SMILODON.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.STEGOSAURUS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.TRICERATOPS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.TYRANNOSAURUS.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.VELOCIRAPTOR.get());

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.EGG.get());
        basicTranslationsProvider.add("entity.fossilslegacy.egg.died", "An egg was too cold and died!");
        basicTranslationsProvider.add("entity.fossilslegacy.egg.died.dry", "An egg was dry and died!");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.FOSSIL.get());

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_CAT.get(), "Cat");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_COW.get(), "Cow");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_DOLPHIN.get(), "Dolphin");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_DONKEY.get(), "Donkey");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_FOX.get(), "Fox");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_GOAT.get(), "Goat");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_HORSE.get(), "Horse");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_LLAMA.get(), "Llama");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_MAMMOTH.get(), "Mammoth");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_MULE.get(), "Mule");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_OCELOT.get(), "Ocelot");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_PANDA.get(), "Panda");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_PIG.get(), "Pig");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_POLAR_BEAR.get(), "Polar Bear");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_RABBIT.get(), "Rabbit");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_SHEEP.get(), "Sheep");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_SMILODON.get(), "Smildon");
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.PREGNANT_WOLF.get(), "Wolf");

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.ANU.get(), "Anu");
        basicTranslationsProvider.add(Anu.AnuSpeaker.GREETINGS, "Kneel down! Resistance is futile!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.HAND_ATTACKED, "Bare hands? Brave!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.THREATEN, "Draw your sword, kid!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.BOW_ATTACKED, "Bow-using coward! Stop hidding!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.LEARNED_HERE, "Look what I learned here!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.LEARNED_THERE, "Look what I learned there!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.GENERIC_RANGED_ATTACKED, "So, is that your weapon?");
        basicTranslationsProvider.add(Anu.AnuSpeaker.GENERIC_MELEE_ATTACKED, "Ha! Stop Playing!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.SUMMON_ZOMBIFIED_PIGLINS, "Work for me, rise my servants!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.SUMMON_PIGS, "Brutes, wake up your wisdom!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.QI_SHOCK, "Qi-shock!");
        basicTranslationsProvider.add(Anu.AnuSpeaker.RAIN_FIRE, "Let fire rain!");

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.TAMED_ZOMBIFIED_PIGLIN.get(), "Zombified Piglin");
        basicTranslationsProvider.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.ANU_SUMMON, "All hiel Anu!");
        basicTranslationsProvider.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.SACRIFICE, "I cannot live without my Master!");
        basicTranslationsProvider.add(TamedZombifiedPiglin.TamedZombifiedPiglinSpeaker.SUMMON, "I swear my life to %s!");

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.FAILURESAURUS.get());

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.ANCIENT_LIGHTNING_BOLT.get(), "Lightning Bolt");

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.THROWN_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.THROWN_INCUBATED_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyEntityTypes.DILOPHOSAURUS_VENOM.get());

        basicTranslationsProvider.add(FossilsLegacyEntityTypes.STONE_TABLET.get());

        // Items
        basicTranslationsProvider.add(FossilsLegacyItems.FOSSIL.get());
        basicTranslationsProvider.add(FossilsLegacyItems.TRICERATOPS_DNA.get(), "Triceratops DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.VELOCIRAPTOR_DNA.get(), "Velociraptor DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.TYRANNOSAURUS_DNA.get(), "Tyrannosaurus DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.PTERANODON_DNA.get(), "Pteranodon DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.NAUTILUS_DNA.get(), "Nautilus DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.FUTABASAURUS_DNA.get(), "Futabasaurus DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.MOSASAURUS_DNA.get(), "Mosasaurus DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.STEGOSAURUS_DNA.get(), "Stegosaurus DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.DILOPHOSAURUS_DNA.get(), "Dilophosaurus DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.BRACHIOSAURUS_DNA.get(), "Brachiosaurus DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.TRICERATOPS_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.VELOCIRAPTOR_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.TYRANNOSAURUS_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.PTERANODON_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.NAUTILUS_EGGS.get());
        basicTranslationsProvider.add(FossilsLegacyItems.FUTABASAURUS_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.MOSASAURUS_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.STEGOSAURUS_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.DILOPHOSAURUS_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BRACHIOSAURUS_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_TRICERATOPS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_VELOCIRAPTOR_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_TYRANNOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_PTERANODON_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.NAUTILUS.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_FUTABASAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_MOSASAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_STEGOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_DILOPHOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_BRACHIOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_SMILODON_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_MAMMOTH_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_TRICERATOPS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_VELOCIRAPTOR_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_TYRANNOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_PTERANODON_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SIO_CHIU_LE.get(), "Sio-Chiu-Le");
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_FUTABASAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_MOSASAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_STEGOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_DILOPHOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_BRACHIOSAURUS_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_SMILODON_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_MAMMOTH_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.TYRANNOSAURUS_TOOTH.get());
        basicTranslationsProvider.add(FossilsLegacyItems.TOOTH_DAGGER.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SKULL_STICK.get());
        basicTranslationsProvider.add(FossilsLegacyItems.DINOPEDIA.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RAW_CHICKEN_SOUP_BUCKET.get(), "Bucket of Raw Chicken Soup");
        basicTranslationsProvider.add(FossilsLegacyItems.COOKED_CHICKEN_SOUP_BUCKET.get(), "Bucket of Cooked Chicken Soup");
        basicTranslationsProvider.add(FossilsLegacyItems.CHICKEN_ESSENCE_BOTTLE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.NAUTILUS_SHELL.get());
        basicTranslationsProvider.add(FossilsLegacyItems.MAGIC_CONCH.get());
        basicTranslationsProvider.add("item.fossilslegacy.magic_conch.desc", "%s");
        basicTranslationsProvider.add("item.fossilslegacy.magic_conch.use", "Set all Plesiosaurs in a 30-Block Area to %s");
        basicTranslationsProvider.add(FossilsLegacyItems.FROZEN_MEAT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_FROZEN_MEAT.get(), "Frozen Meat");
        basicTranslationsProvider.add(FossilsLegacyItems.AXOLOTL_DNA.get(), "Axolotl DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.CAT_DNA.get(), "Cat DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.CHICKEN_DNA.get(), "Chicken DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.COW_DNA.get(), "Cow DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.DOLPHIN_DNA.get(), "Dolphin DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.DONKEY_DNA.get(), "Donkey DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.FOX_DNA.get(), "Fox DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.FROG_DNA.get(), "Frog DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.GOAT_DNA.get(), "Goat DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.HORSE_DNA.get(), "Horse DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.LLAMA_DNA.get(), "Llama DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.MULE_DNA.get(), "Mule DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.OCELOT_DNA.get(), "Ocelot DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.PANDA_DNA.get(), "Panda DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.PARROT_DNA.get(), "Parrot DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.PIG_DNA.get(), "Pig DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.POLAR_BEAR_DNA.get(), "Polar Bear DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.RABBIT_DNA.get(), "Rabbit DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.SHEEP_DNA.get(), "Sheep DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.WOLF_DNA.get(), "Wolf DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.SMILODON_DNA.get(), "Smilodon DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.MAMMOTH_DNA.get(), "Mammoth DNA");
        basicTranslationsProvider.add(FossilsLegacyItems.CAT_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.INCUBATED_CHICKEN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.COW_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.DOLPHIN_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.DONKEY_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.FOX_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.GOAT_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.HORSE_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.LLAMA_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.MULE_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.OCELOT_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.PANDA_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.INCUBATED_PARROT_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.PIG_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.POLAR_BEAR_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RABBIT_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SHEEP_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.WOLF_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SMILODON_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.MAMMOTH_EMBRYO_SYRINGE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.JURASSIC_FERN_SPORES.get());
        basicTranslationsProvider.add(FossilsLegacyItems.RELIC_SCRAP.get());
        basicTranslationsProvider.add(FossilsLegacyItems.STONE_TABLET.get());
        basicTranslationsProvider.add(FossilsLegacyItems.ANCIENT_SWORD_ARTIFACT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.ANCIENT_HELMET_ARTIFACT.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM.get());
        basicTranslationsProvider.add(FossilsLegacyItems.ANCIENT_SWORD.get());
        basicTranslationsProvider.add(FossilsLegacyItems.ANCIENT_HELMET.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM_SWORD.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM_SHOVEL.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM_PICKAXE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM_AXE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM_HOE.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM_UPGRADE_SMITHING_TEMPLATE.get(), "Smithing Template");
        basicTranslationsProvider.add(FossilsLegacyItems.WOODEN_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_WOODEN_JAVELIN.get(), "Wooden Javelin");
        basicTranslationsProvider.add(FossilsLegacyItems.STONE_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_STONE_JAVELIN.get(), "Stone Javelin");
        basicTranslationsProvider.add(FossilsLegacyItems.IRON_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_IRON_JAVELIN.get(), "Iron Javelin");
        basicTranslationsProvider.add(FossilsLegacyItems.GOLDEN_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_GOLDEN_JAVELIN.get(), "Golden Javelin");
        basicTranslationsProvider.add(FossilsLegacyItems.DIAMOND_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_DIAMOND_JAVELIN.get(), "Diamond Javelin");
        basicTranslationsProvider.add(FossilsLegacyItems.NETHERITE_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_NETHERITE_JAVELIN.get(), "Netherite Javelin");
        basicTranslationsProvider.add(FossilsLegacyItems.SCARAB_GEM_JAVELIN.get());
        basicTranslationsProvider.add(FossilsLegacyItems.BROKEN_SCARAB_GEM_JAVELIN.get(), "Scarab Gem Javelin");

        basicTranslationsProvider.add(FossilsLegacyItems.ANU_SPAWN_EGG.get());

        basicTranslationsProvider.add(FossilsLegacyItems.FAILURESAURUS_SPAWN_EGG.get());

        basicTranslationsProvider.add(FossilsLegacyItems.BRACHIOSAURUS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.DILOPHOSAURUS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.MAMMOTH_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.MOSASAURUS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.NAUTILUS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.FUTABASAURUS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.PTERANODON_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.SMILODON_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.STEGOSAURUS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.TRICERATOPS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.TYRANNOSAURUS_SPAWN_EGG.get());
        basicTranslationsProvider.add(FossilsLegacyItems.VELOCIRAPTOR_SPAWN_EGG.get());
        basicTranslationsProvider.add("item.fossilslegacy.dinosaur_spawn_egg.desc", "Crouch to spawn baby");

        basicTranslationsProvider.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.applies_to", "Netherite Equipment");
        basicTranslationsProvider.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.ingredients", "Scarab Gem");
        basicTranslationsProvider.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.base_slot_description", "Add netherite weapon or tool");
        basicTranslationsProvider.add("item.fossilslegacy.smithing_template.scarab_gem_upgrade.additions_slot_description", "Add scarab gem");

        basicTranslationsProvider.add(FossilsExperimentsItems.OVERWORLD_COIN.get());
        basicTranslationsProvider.add(FossilsExperimentsItems.NETHER_COIN.get());
        basicTranslationsProvider.add(FossilsExperimentsItems.PREHISTORIC_COIN.get());

        for (SimpleHolder<? extends Item> items : FossilsLegacyItems.DEBUG_ITEMS.getEntriesView()) {
            basicTranslationsProvider.add(items.get(), "Debug Item");
        }

        basicTranslationsProvider.add("debugItem.fossilslegacy.type", "Type: %s");
        basicTranslationsProvider.add("debugItem.fossilslegacy.set_max_hunger", "Set Max Hunger");
        basicTranslationsProvider.add("debugItem.fossilslegacy.set_max_health", "Set Max Health");
        basicTranslationsProvider.add("debugItem.fossilslegacy.set_full_grown", "Set Full Grown");
        basicTranslationsProvider.add("debugItem.fossilslegacy.set_baby", "Set Baby");
        basicTranslationsProvider.add("debugItem.fossilslegacy.set_owner_as_me", "Set Owner As Me");

        // JEI
        basicTranslationsProvider.add("jei.fossilslegacy.archaeology", "Archaeology");
        basicTranslationsProvider.add("jei.fossilslegacy.analyzation", "Analyzation");
        basicTranslationsProvider.add("jei.fossilslegacy.cultivation", "Cultivation");
        basicTranslationsProvider.add("jei.fossilslegacy.biomatter", "Biomatter");
        basicTranslationsProvider.add("jei.fossilslegacy.biomatter.biomatterCount.single", "Biomatter for 1 item");
        basicTranslationsProvider.add("jei.fossilslegacy.biomatter.biomatterCount", "Biomatter for %s items");
        basicTranslationsProvider.add("jei.fossilslegacy.feeder", "Feeder");
        basicTranslationsProvider.add("jei.fossilslegacy.feeder.food_level", "Provides %s food");

        // Keys
        basicTranslationsProvider.add("key.fossilslegacy.sink", "Sink");

        // Menus
        basicTranslationsProvider.add("menu.fossilslegacy.analyzer", "Analyzer");
        basicTranslationsProvider.add("menu.fossilslegacy.archaeology_workbench", "Archaeology Workbench");
        basicTranslationsProvider.add("menu.fossilslegacy.cultivator", "Cultivator");
        basicTranslationsProvider.add("menu.fossilslegacy.feeder", "Feeder");
        basicTranslationsProvider.add("menu.fossilslegacy.time_machine", "Time Machine");
        basicTranslationsProvider.add("menu.fossilslegacy.time_machine.start", "Start");
        basicTranslationsProvider.add("menu.fossilslegacy.time_machine.memory", "Memory");

        // Packs
        basicTranslationsProvider.add("pack.fossilslegacy.fa_legacy_textures", "F/A Legacy Original Textures");

        // Stone Tablet
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.lighting.title", "Lightning");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.lighting.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.social.title", "Social");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.social.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.great_war.title", "Great War");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.great_war.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.anu_death.title", "Anu's Death");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.anu_death.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.portal.title", "Portal");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.portal.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.herobrine.title", "Herobrine");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.herobrine.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.skeleton_and_creeper.title", "Skeleton and Creeper");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.skeleton_and_creeper.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.zombie_and_spider.title", "Zombie and Spider");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.zombie_and_spider.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_in_iceberg.title", "Tyrannosaurus in Iceberg");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_in_iceberg.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_transport.title", "Tyrannosaurus Transport");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_transport.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_melt.title", "Tyrannosaurus Melt");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_melt.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_attack.title", "Tyrannosaurus Attack");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_attack.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_death.title", "Tyrannosaurus Death");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_death.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_corpse.title", "Tyrannosaurus Corpse");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.tyrannosaurus_corpse.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.princess.title", "Princess");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.princess.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.mosasaurus.title", "Mosasaurus");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.mosasaurus.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.holy_mosasaurus.title", "Holy Mosasaurus");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.holy_mosasaurus.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.past.title", "Past");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.past.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.time_machine.title", "Time Machine");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.time_machine.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.future.title", "Future");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.future.author", "Kajun");
        basicTranslationsProvider.add("stone_tablet.fossilslegacy.random", "Random variant");

        // Sounds
        basicTranslationsProvider.add("sound.fossilslegacy.brachiosaurus.ambient", "Brachiosaurus Calls");
        basicTranslationsProvider.add("sound.fossilslegacy.brachiosaurus.hurt", "Brachiosaurus Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.brachiosaurus.death", "Brachiosaurus Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.dilophosaurus.ambient", "Dilophosaurus Hisses");
        basicTranslationsProvider.add("sound.fossilslegacy.dilophosaurus.call", "Dilophosaurus Calls");
        basicTranslationsProvider.add("sound.fossilslegacy.dilophosaurus.hurt", "Dilophosaurus Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.dilophosaurus.death", "Dilophosaurus Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.drum.hit", "Drum Hit");
        basicTranslationsProvider.add("sound.fossilslegacy.drum.triple_hit", "Drum Triple Hit");
        basicTranslationsProvider.add("sound.fossilslegacy.mammoth.ambient", "Mammoth Trumpets");
        basicTranslationsProvider.add("sound.fossilslegacy.mammoth.hurt", "Mammoth Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.mammoth.death", "Mammoth Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.futabasaurus.ambient", "Futabasaurus Chirps");
        basicTranslationsProvider.add("sound.fossilslegacy.futabasaurus.hurt", "Futabasaurus Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.futabasaurus.death", "Futabasaurus Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.pteranodon.ambient", "Pteranodon Calls");
        basicTranslationsProvider.add("sound.fossilslegacy.pteranodon.hurt", "Pteranodon Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.pteranodon.death", "Pteranodon Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.smilodon.ambient", "Smilodon Roars");
        basicTranslationsProvider.add("sound.fossilslegacy.smilodon.hurt", "Smilodon Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.smilodon.death", "Smilodon Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.stegosaurus.ambient", "Stegosaurus Calls");
        basicTranslationsProvider.add("sound.fossilslegacy.stegosaurus.hurt", "Stegosaurus Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.stegosaurus.death", "Stegosaurus Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.triceratops.ambient", "Triceratops Calls");
        basicTranslationsProvider.add("sound.fossilslegacy.triceratops.hurt", "Triceratops Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.triceratops.death", "Triceratops Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.tyrannosaurus.ambient", "Tyrannosaurus Rumbles");
        basicTranslationsProvider.add("sound.fossilslegacy.tyrannosaurus.attack", "Tyrannosaurus Roars");
        basicTranslationsProvider.add("sound.fossilslegacy.tyrannosaurus.hurt", "Tyrannosaurus Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.tyrannosaurus.death", "Tyrannosaurus Dies");
        basicTranslationsProvider.add("sound.fossilslegacy.velociraptor.ambient.tame", "Velociraptor Whines");
        basicTranslationsProvider.add("sound.fossilslegacy.velociraptor.ambient.wild", "Velociraptor Hisses");
        basicTranslationsProvider.add("sound.fossilslegacy.velociraptor.attack", "Velociraptor Attacks");
        basicTranslationsProvider.add("sound.fossilslegacy.velociraptor.hurt", "Velociraptor Hurts");
        basicTranslationsProvider.add("sound.fossilslegacy.velociraptor.death", "Velociraptor Dies");

        // Upgrades
        basicTranslationsProvider.add("upgrade.fossilslegacy.scarab_gem_upgrade", "Scarab Gem Upgrade");
    }

    public static interface Provider {
        String getModId();
    }

    public static interface BasicItemModelsProvider extends Provider {
        default <T> ResourceLocation getFromValue(Registry<T> registry, T value) {
            return new ResourceLocation(registry.getKey(value).getNamespace(), registry.key().location().getPath() + "/" + registry.getKey(value).getPath());
        }

        void basicItem(ItemLike itemLike, ResourceLocation texture);

        default void basicItem(ItemLike itemLike) {
            this.basicItem(itemLike, this.getFromValue(BuiltInRegistries.ITEM, itemLike.asItem()));
        }

        void handheldItem(ItemLike itemLike, ResourceLocation texture);

        default void handheldItem(ItemLike itemLike) {
            this.handheldItem(itemLike, this.getFromValue(BuiltInRegistries.ITEM, itemLike.asItem()));
        }

        void spawnEggItem(ItemLike itemLike, ResourceLocation texture);

        default void spawnEggItem(ItemLike itemLike) {
            this.spawnEggItem(itemLike, this.getFromValue(BuiltInRegistries.ITEM, itemLike.asItem()));
        }

        void blockItem(ItemLike itemLike, ResourceLocation model);

        default void blockItem(Block block) {
            this.spawnEggItem(block, this.getFromValue(BuiltInRegistries.BLOCK, block));
        }
    }

    public static interface BasicBlockStateProvider {
        void simpleBlock(Block block);

        void statesBlock(Block block, Property<Boolean> property, String inActiveModelName, ResourceLocation inActiveDown, ResourceLocation inActiveUp, ResourceLocation inActiveNorth, ResourceLocation inActiveSouth, ResourceLocation inActiveEast, ResourceLocation inActiveWest, ResourceLocation inActiveParticle, String activeModelName, ResourceLocation activeDown, ResourceLocation activeUp, ResourceLocation activeNorth, ResourceLocation activeSouth, ResourceLocation activeEast, ResourceLocation activeWest, ResourceLocation activeParticle);

        void parent(Block block, String modelName, ResourceLocation model);

        void parent(Block block, String modelName, ResourceLocation model, Pair<String, ResourceLocation>... textureOverides);

        void horizontalBlock(Block block, String modelName, ResourceLocation down, ResourceLocation up, ResourceLocation north, ResourceLocation south, ResourceLocation east, ResourceLocation west, ResourceLocation particle);

        void horizontalBlockWithModelHolder(Block block, Function<BlockState, ModelHolder> model);

        void fernBlock(Block block);

        void drumBlock(Block block);

        public static record ModelHolder(String modelName, ResourceLocation down, ResourceLocation up,
                                         ResourceLocation north, ResourceLocation south, ResourceLocation east,
                                         ResourceLocation west, ResourceLocation particle) {
        }
    }

    public static interface BasicSoundDefinitionsProvider {
        void addSounds(SoundEvent soundEvent, String subtitle, String... sounds);
    }

    public static interface BasicTranslationsProvider extends Provider {
        void add(String key, String translation);

        default void add(Block key, String name) {
            this.add(key.getDescriptionId(), name);
        }

        default void add(Item key, String name) {
            this.add(key.getDescriptionId(), name);
        }

        default void add(ItemStack key, String name) {
            this.add(key.getDescriptionId(), name);
        }

        default void add(Enchantment key, String name) {
            this.add(key.getDescriptionId(), name);
        }

        default void add(MobEffect key, String name) {
            this.add(key.getDescriptionId(), name);
        }

        default void add(EntityType<?> key, String name) {
            this.add(key.getDescriptionId(), name);
        }

        default void add(Item item) {
            this.add(item, SimpleUtils.autoName(BuiltInRegistries.ITEM.getKey(item).getPath()));
        }

        default void add(Block block) {
            this.add(block, SimpleUtils.autoName(BuiltInRegistries.BLOCK.getKey(block).getPath()));
        }

        default void add(Enchantment enchantment) {
            this.add(enchantment, SimpleUtils.autoName(BuiltInRegistries.ENCHANTMENT.getKey(enchantment).getPath()));
        }

        default void add(MobEffect mobEffect) {
            this.add(mobEffect, SimpleUtils.autoName(BuiltInRegistries.MOB_EFFECT.getKey(mobEffect).getPath()));
        }

        default void add(EntityType<?> entityType) {
            this.add(entityType, SimpleUtils.autoName(BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath()));
        }

        default void add(SoundEvent soundEvent) {
            this.add(soundEvent, SimpleUtils.autoName(BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getPath()));
        }

        default void add(MenuType menuType) {
            this.add(menuType, SimpleUtils.autoName(BuiltInRegistries.MENU.getKey(menuType).getPath()));
        }

        default void add(String category, String advancement, String title, String desc) {
            this.add("advancements." + this.getModId() + "." + category + "." + advancement + ".title", title);
            this.add("advancements." + this.getModId() + "." + category + "." + advancement + ".desc", desc);
        }

        default void add(SoundEvent soundEvent, String name) {
            this.add("sound." + BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getNamespace() + BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).getPath(), name);
        }

        default void add(MenuType menuType, String name) {
            this.add("menu." + BuiltInRegistries.MENU.getKey(menuType).getNamespace() + BuiltInRegistries.MENU.getKey(menuType).getPath(), name);
        }

        default void add(CreativeModeTab creativeModeTab, String name) {
            this.add(creativeModeTab.getDisplayName().getString(), name);
        }

        default void addDesc(Item item, String... descs) {
            for (int i = 0; i < descs.length; ++i) {
                this.add(item.getDescriptionId() + ".desc" + i, descs[i]);
            }

        }

        default void addDesc(Item item, String desc) {
            this.add(item.getDescriptionId() + ".desc", desc);
        }

        default void addDesc(Block block, String... descs) {
            for (int i = 0; i < descs.length; ++i) {
                this.add(block.getDescriptionId() + ".desc" + i, descs[i]);
            }

        }

        default void addDesc(Block block, String name) {
            this.add(block.getDescriptionId() + ".desc", name);
        }

        default void add(SpeakerType<?> speakerType, String translation) {
            this.add(speakerType.getTranslationKey(), translation);
        }
    }
}
