package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.block.blocks.CultivatorBlock;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.simplelibrary.server.registry.SimpleHolder;
import willatendo.simplelibrary.server.util.SimpleUtils;

import java.util.concurrent.CompletableFuture;

public class FABlockTagProvider extends BlockTagsProvider {
    public FABlockTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(BlockTags.PLANKS).add(FABlocks.ARCHAEOPTERIS_PLANKS.get(), FABlocks.LEPIDODENDRON_PLANKS.get(), FABlocks.SIGILLARIA_PLANKS.get(), FABlocks.CALAMITES_PLANKS.get(), FABlocks.GINKGO_PLANKS.get(), FABlocks.ARAUCARIA_PLANKS.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(FABlocks.ARCHAEOPTERIS_BUTTON.get(), FABlocks.LEPIDODENDRON_BUTTON.get(), FABlocks.SIGILLARIA_BUTTON.get(), FABlocks.CALAMITES_BUTTON.get(), FABlocks.GINKGO_BUTTON.get(), FABlocks.ARAUCARIA_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(FABlocks.ARCHAEOPTERIS_DOOR.get(), FABlocks.LEPIDODENDRON_DOOR.get(), FABlocks.SIGILLARIA_DOOR.get(), FABlocks.CALAMITES_DOOR.get(), FABlocks.GINKGO_DOOR.get(), FABlocks.ARAUCARIA_DOOR.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(FABlocks.ARCHAEOPTERIS_STAIRS.get(), FABlocks.LEPIDODENDRON_STAIRS.get(), FABlocks.SIGILLARIA_STAIRS.get(), FABlocks.CALAMITES_STAIRS.get(), FABlocks.GINKGO_STAIRS.get(), FABlocks.ARAUCARIA_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(FABlocks.ARCHAEOPTERIS_SLAB.get(), FABlocks.LEPIDODENDRON_SLAB.get(), FABlocks.SIGILLARIA_SLAB.get(), FABlocks.CALAMITES_SLAB.get(), FABlocks.GINKGO_SLAB.get(), FABlocks.ARAUCARIA_SLAB.get());
        this.tag(BlockTags.WOODEN_FENCES).add(FABlocks.ARCHAEOPTERIS_FENCE.get(), FABlocks.LEPIDODENDRON_FENCE.get(), FABlocks.SIGILLARIA_FENCE.get(), FABlocks.CALAMITES_FENCE.get(), FABlocks.GINKGO_FENCE.get(), FABlocks.ARAUCARIA_FENCE.get());
        this.tag(BlockTags.SAPLINGS).add(FABlocks.ARCHAEOPTERIS_SAPLING.get(), FABlocks.LEPIDODENDRON_SAPLING.get(), FABlocks.SIGILLARIA_SAPLING.get(), FABlocks.CALAMITES_SAPLING.get(), FABlocks.GINKGO_SAPLING.get(), FABlocks.ARAUCARIA_SAPLING.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTags(FABlockTags.ARAUCARIA_LOGS, FABlockTags.ARCHAEOPTERIS_LOGS, FABlockTags.LEPIDODENDRON_LOGS, FABlockTags.SIGILLARIA_LOGS, FABlockTags.CALAMITES_LOGS, FABlockTags.GINKGO_LOGS, FABlockTags.ARAUCARIA_LOGS);
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).addTags(FABlockTags.ARAUCARIA_LOGS, FABlockTags.ARCHAEOPTERIS_LOGS, FABlockTags.LEPIDODENDRON_LOGS, FABlockTags.SIGILLARIA_LOGS, FABlockTags.CALAMITES_LOGS, FABlockTags.GINKGO_LOGS, FABlockTags.ARAUCARIA_LOGS);
        this.tag(BlockTags.FLOWER_POTS).add(FABlocks.POTTED_ARCHAEOPTERIS_SAPLING.get(), FABlocks.POTTED_LEPIDODENDRON_SAPLING.get(), FABlocks.POTTED_SIGILLARIA_SAPLING.get(), FABlocks.POTTED_CALAMITES_SAPLING.get(), FABlocks.POTTED_GINKGO_SAPLING.get(), FABlocks.POTTED_ARAUCARIA_SAPLING.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(FABlocks.ARCHAEOPTERIS_PRESSURE_PLATE.get(), FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), FABlocks.SIGILLARIA_PRESSURE_PLATE.get(), FABlocks.CALAMITES_PRESSURE_PLATE.get(), FABlocks.GINKGO_PRESSURE_PLATE.get(), FABlocks.ARAUCARIA_PRESSURE_PLATE.get());
        this.tag(BlockTags.LEAVES).add(FABlocks.ARCHAEOPTERIS_LEAVES.get(), FABlocks.LEPIDODENDRON_LEAVES.get(), FABlocks.SIGILLARIA_LEAVES.get(), FABlocks.CALAMITES_LEAVES.get(), FABlocks.GINKGO_LEAVES.get(), FABlocks.ARAUCARIA_LEAVES.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(FABlocks.ARCHAEOPTERIS_TRAPDOOR.get(), FABlocks.LEPIDODENDRON_TRAPDOOR.get(), FABlocks.SIGILLARIA_TRAPDOOR.get(), FABlocks.CALAMITES_TRAPDOOR.get(), FABlocks.GINKGO_TRAPDOOR.get(), FABlocks.ARAUCARIA_TRAPDOOR.get());
        this.tag(BlockTags.STANDING_SIGNS).add(FABlocks.ARCHAEOPTERIS_SIGN.get(), FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.SIGILLARIA_SIGN.get(), FABlocks.CALAMITES_SIGN.get(), FABlocks.GINKGO_SIGN.get(), FABlocks.ARAUCARIA_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(FABlocks.ARCHAEOPTERIS_WALL_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get(), FABlocks.GINKGO_WALL_SIGN.get(), FABlocks.ARAUCARIA_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(FABlocks.ARCHAEOPTERIS_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.GINKGO_HANGING_SIGN.get(), FABlocks.ARAUCARIA_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(FABlocks.ARCHAEOPTERIS_WALL_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get(), FABlocks.GINKGO_WALL_HANGING_SIGN.get(), FABlocks.ARAUCARIA_WALL_HANGING_SIGN.get());
        this.tag(BlockTags.FENCE_GATES).add(FABlocks.ARCHAEOPTERIS_FENCE_GATE.get(), FABlocks.LEPIDODENDRON_FENCE_GATE.get(), FABlocks.SIGILLARIA_FENCE_GATE.get(), FABlocks.CALAMITES_FENCE_GATE.get(), FABlocks.GINKGO_FENCE_GATE.get(), FABlocks.ARAUCARIA_FENCE_GATE.get());
        this.tag(BlockTags.CAULDRONS).add(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(FABlocks.FOSSIL_ORE.get(), FABlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(FABlocks.FOSSIL_ORE.get(), FABlocks.DEEPSLATE_FOSSIL_ORE.get(), FABlocks.SKULL_BLOCK.get(), FABlocks.SKULL_LANTERN_BLOCK.get(), FABlocks.ANALYZER.get(), FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get(), FABlocks.FEEDER.get(), FABlocks.ICED_STONE.get(), FABlocks.SMALL_CAGE.get(), FABlocks.MEDIUM_CAGE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                FABlocks.ARAUCARIA_PLANKS.get(), FABlocks.ARAUCARIA_LOG.get(), FABlocks.STRIPPED_ARAUCARIA_LOG.get(), FABlocks.ARAUCARIA_WOOD.get(), FABlocks.STRIPPED_ARAUCARIA_WOOD.get(), FABlocks.ARAUCARIA_STAIRS.get(), FABlocks.ARAUCARIA_SIGN.get(), FABlocks.ARAUCARIA_WALL_SIGN.get(), FABlocks.ARAUCARIA_DOOR.get(), FABlocks.ARAUCARIA_HANGING_SIGN.get(), FABlocks.ARAUCARIA_WALL_HANGING_SIGN.get(), FABlocks.ARAUCARIA_PRESSURE_PLATE.get(), FABlocks.ARAUCARIA_FENCE.get(), FABlocks.ARAUCARIA_TRAPDOOR.get(), FABlocks.ARAUCARIA_FENCE_GATE.get(), FABlocks.ARAUCARIA_BUTTON.get(), FABlocks.ARAUCARIA_SLAB.get(),
                FABlocks.ARCHAEOPTERIS_PLANKS.get(), FABlocks.ARCHAEOPTERIS_LOG.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get(), FABlocks.ARCHAEOPTERIS_WOOD.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get(), FABlocks.ARCHAEOPTERIS_STAIRS.get(), FABlocks.ARCHAEOPTERIS_SIGN.get(), FABlocks.ARCHAEOPTERIS_WALL_SIGN.get(), FABlocks.ARCHAEOPTERIS_DOOR.get(), FABlocks.ARCHAEOPTERIS_HANGING_SIGN.get(), FABlocks.ARCHAEOPTERIS_WALL_HANGING_SIGN.get(), FABlocks.ARCHAEOPTERIS_PRESSURE_PLATE.get(), FABlocks.ARCHAEOPTERIS_FENCE.get(), FABlocks.ARCHAEOPTERIS_TRAPDOOR.get(), FABlocks.ARCHAEOPTERIS_FENCE_GATE.get(), FABlocks.ARCHAEOPTERIS_BUTTON.get(), FABlocks.ARCHAEOPTERIS_SLAB.get(), FABlocks.ARCHAEOLOGY_WORKBENCH.get(), FABlocks.PALAEONTOLOGY_TABLE.get(), FABlocks.DRUM.get(), FABlocks.GINKGO_PLANKS.get(), FABlocks.GINKGO_LOG.get(), FABlocks.STRIPPED_GINKGO_LOG.get(), FABlocks.GINKGO_WOOD.get(), FABlocks.STRIPPED_GINKGO_WOOD.get(), FABlocks.GINKGO_STAIRS.get(), FABlocks.GINKGO_SIGN.get(), FABlocks.GINKGO_WALL_SIGN.get(), FABlocks.GINKGO_DOOR.get(), FABlocks.GINKGO_HANGING_SIGN.get(), FABlocks.GINKGO_WALL_HANGING_SIGN.get(), FABlocks.GINKGO_PRESSURE_PLATE.get(), FABlocks.GINKGO_FENCE.get(), FABlocks.GINKGO_TRAPDOOR.get(), FABlocks.GINKGO_FENCE_GATE.get(), FABlocks.GINKGO_BUTTON.get(), FABlocks.GINKGO_SLAB.get(), FABlocks.LEPIDODENDRON_PLANKS.get(), FABlocks.LEPIDODENDRON_LOG.get(), FABlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FABlocks.LEPIDODENDRON_WOOD.get(), FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), FABlocks.LEPIDODENDRON_STAIRS.get(), FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get(), FABlocks.LEPIDODENDRON_DOOR.get(), FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), FABlocks.LEPIDODENDRON_FENCE.get(), FABlocks.LEPIDODENDRON_TRAPDOOR.get(), FABlocks.LEPIDODENDRON_FENCE_GATE.get(), FABlocks.LEPIDODENDRON_BUTTON.get(), FABlocks.LEPIDODENDRON_SLAB.get(), FABlocks.SIGILLARIA_PLANKS.get(), FABlocks.SIGILLARIA_LOG.get(), FABlocks.STRIPPED_SIGILLARIA_LOG.get(), FABlocks.SIGILLARIA_WOOD.get(), FABlocks.STRIPPED_SIGILLARIA_WOOD.get(), FABlocks.SIGILLARIA_STAIRS.get(), FABlocks.SIGILLARIA_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get(), FABlocks.SIGILLARIA_DOOR.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FABlocks.SIGILLARIA_PRESSURE_PLATE.get(), FABlocks.SIGILLARIA_FENCE.get(), FABlocks.SIGILLARIA_TRAPDOOR.get(), FABlocks.SIGILLARIA_FENCE_GATE.get(), FABlocks.SIGILLARIA_BUTTON.get(), FABlocks.SIGILLARIA_SLAB.get(), FABlocks.CALAMITES_PLANKS.get(), FABlocks.CALAMITES_LOG.get(), FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.CALAMITES_WOOD.get(), FABlocks.STRIPPED_CALAMITES_WOOD.get(), FABlocks.CALAMITES_STAIRS.get(), FABlocks.CALAMITES_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get(), FABlocks.CALAMITES_DOOR.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get(), FABlocks.CALAMITES_PRESSURE_PLATE.get(), FABlocks.CALAMITES_FENCE.get(), FABlocks.CALAMITES_TRAPDOOR.get(), FABlocks.CALAMITES_FENCE_GATE.get(), FABlocks.CALAMITES_BUTTON.get(), FABlocks.CALAMITES_SLAB.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(FABlocks.PERMAFROST.get());
        this.tag(BlockTags.DRAGON_IMMUNE).add(FABlocks.TIME_MACHINE.get());
        this.tag(BlockTags.WITHER_IMMUNE).add(FABlocks.TIME_MACHINE.get());

        this.tag(FABlockTags.ANKYLOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.ARAUCARIA_LOGS).add(FABlocks.ARAUCARIA_LOG.get(), FABlocks.ARAUCARIA_WOOD.get(), FABlocks.STRIPPED_ARAUCARIA_LOG.get(), FABlocks.STRIPPED_ARAUCARIA_WOOD.get());
        this.tag(FABlockTags.ARCHAEOPTERIS_LOGS).add(FABlocks.ARCHAEOPTERIS_LOG.get(), FABlocks.ARCHAEOPTERIS_WOOD.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_LOG.get(), FABlocks.STRIPPED_ARCHAEOPTERIS_WOOD.get());
        this.tag(FABlockTags.BARYONYX_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.BRACHIOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CALAMITES_LOGS).add(FABlocks.CALAMITES_LOG.get(), FABlocks.CALAMITES_WOOD.get(), FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.STRIPPED_CALAMITES_WOOD.get());
        this.tag(FABlockTags.CARNOTAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.COMPSOGNATHUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CRYOLOPHOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CULTIVATORS).add(FABlocks.WHITE_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.RED_CULTIVATOR.get(), FABlocks.BLACK_CULTIVATOR.get());
        this.tag(FABlockTags.CYCAD_PLANTABLE_ON).addTag(BlockTags.DIRT);
        this.tag(FABlockTags.DILOPHOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DIMETRODON_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DODO_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DRYOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.EATABLE_FERN).add(FABlocks.SHORT_HORSETAIL.get(), FABlocks.TALL_HORSETAIL.get(), FABlocks.JURASSIC_FERN.get());
        this.tag(FABlockTags.EATABLE_LEAVES).addTags(BlockTags.LEAVES);
        this.tag(FABlockTags.ELASMOTHERIUM_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.FEEDER).add(FABlocks.FEEDER.get());
        this.tag(FABlockTags.GALLIMIMUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.SAND);
        this.tag(FABlockTags.GINKGO_LOGS).add(FABlocks.GINKGO_LOG.get(), FABlocks.GINKGO_WOOD.get(), FABlocks.STRIPPED_GINKGO_LOG.get(), FABlocks.STRIPPED_GINKGO_WOOD.get());
        this.tag(FABlockTags.JURASSIC_FERN_PLANTABLE_ON).addTag(BlockTags.DIRT);
        this.tag(FABlockTags.LLAMA_STATUES).add(FABlocks.IRON_LLAMA_STATUE.get(), FABlocks.COPPER_LLAMA_STATUE.get(), FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        this.tag(FABlockTags.LEPIDODENDRON_LOGS).add(FABlocks.LEPIDODENDRON_LOG.get(), FABlocks.LEPIDODENDRON_WOOD.get(), FABlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.tag(FABlockTags.MAMMOTH_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.MINEABLE_WITH_ANCIENT_HOE).addTags(BlockTags.MINEABLE_WITH_HOE).add(Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS, Blocks.MELON_STEM, Blocks.ATTACHED_MELON_STEM, Blocks.PUMPKIN_STEM, Blocks.ATTACHED_PUMPKIN_STEM, Blocks.PITCHER_CROP, Blocks.TORCHFLOWER_CROP);
        this.tag(FABlockTags.MOA_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.PACHYCEPHALOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.PERMAFROST_FROSTABLE).add(Blocks.STONE, Blocks.GRANITE, Blocks.ANDESITE, Blocks.DIORITE);
        this.tag(FABlockTags.PTERANODON_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.SMILODON_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.SIGILLARIA_LOGS).add(FABlocks.SIGILLARIA_LOG.get(), FABlocks.SIGILLARIA_WOOD.get(), FABlocks.STRIPPED_SIGILLARIA_LOG.get(), FABlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.tag(FABlockTags.SPINOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.SPINOSAURUS_UNBREAKABLES).add(FABlocks.FEEDER.get(), Blocks.BEDROCK, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_TRAPDOOR, Blocks.IRON_DOOR, Blocks.CHAIN, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_PORTAL_FRAME, Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY, Blocks.ENCHANTING_TABLE, Blocks.EMERALD_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.BARRIER, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_VOID, Blocks.SPAWNER, Blocks.TRIAL_SPAWNER, Blocks.LIGHT, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK).addTags(BlockTags.ANVIL);
        this.tag(FABlockTags.STEGOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.THERIZINOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.TRICERATOPS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.SAND);
        this.tag(FABlockTags.TYRANNOSAURUS_UNBREAKABLES).add(FABlocks.FEEDER.get(), Blocks.BEDROCK, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_TRAPDOOR, Blocks.IRON_DOOR, Blocks.CHAIN, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_PORTAL_FRAME, Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY, Blocks.ENCHANTING_TABLE, Blocks.EMERALD_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.BARRIER, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_VOID, Blocks.SPAWNER, Blocks.TRIAL_SPAWNER, Blocks.LIGHT, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK).addTags(BlockTags.ANVIL);
        this.tag(FABlockTags.VELOCIRAPTOR_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.SAND);
    }
}
