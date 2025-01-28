package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.tags.FABlockTags;

import java.util.concurrent.CompletableFuture;

public class FABlockTagProvider extends BlockTagsProvider {
    public FABlockTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(BlockTags.PLANKS).add(FABlocks.LEPIDODENDRON_PLANKS.get(), FABlocks.SIGILLARIA_PLANKS.get(), FABlocks.CALAMITES_PLANKS.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(FABlocks.LEPIDODENDRON_BUTTON.get(), FABlocks.SIGILLARIA_BUTTON.get(), FABlocks.CALAMITES_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(FABlocks.LEPIDODENDRON_DOOR.get(), FABlocks.SIGILLARIA_DOOR.get(), FABlocks.CALAMITES_DOOR.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(FABlocks.LEPIDODENDRON_STAIRS.get(), FABlocks.SIGILLARIA_STAIRS.get(), FABlocks.CALAMITES_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(FABlocks.LEPIDODENDRON_SLAB.get(), FABlocks.SIGILLARIA_SLAB.get(), FABlocks.CALAMITES_SLAB.get());
        this.tag(BlockTags.WOODEN_FENCES).add(FABlocks.LEPIDODENDRON_FENCE.get(), FABlocks.SIGILLARIA_FENCE.get(), FABlocks.CALAMITES_FENCE.get());
        this.tag(BlockTags.SAPLINGS).add(FABlocks.LEPIDODENDRON_SAPLING.get(), FABlocks.SIGILLARIA_SAPLING.get(), FABlocks.CALAMITES_SAPLING.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTags(FABlockTags.LEPIDODENDRON_LOGS, FABlockTags.SIGILLARIA_LOGS, FABlockTags.CALAMITES_LOGS);
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).addTags(FABlockTags.LEPIDODENDRON_LOGS, FABlockTags.SIGILLARIA_LOGS, FABlockTags.CALAMITES_LOGS);
        this.tag(BlockTags.FLOWER_POTS).add(FABlocks.POTTED_LEPIDODENDRON_SAPLING.get(), FABlocks.POTTED_SIGILLARIA_SAPLING.get(), FABlocks.POTTED_CALAMITES_SAPLING.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), FABlocks.SIGILLARIA_PRESSURE_PLATE.get(), FABlocks.CALAMITES_PRESSURE_PLATE.get());
        this.tag(BlockTags.LEAVES).add(FABlocks.LEPIDODENDRON_LEAVES.get(), FABlocks.SIGILLARIA_LEAVES.get(), FABlocks.CALAMITES_LEAVES.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(FABlocks.LEPIDODENDRON_TRAPDOOR.get(), FABlocks.SIGILLARIA_TRAPDOOR.get(), FABlocks.CALAMITES_TRAPDOOR.get());
        this.tag(BlockTags.STANDING_SIGNS).add(FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.SIGILLARIA_SIGN.get(), FABlocks.CALAMITES_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(FABlocks.LEPIDODENDRON_WALL_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.CALAMITES_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get());
        this.tag(BlockTags.FENCE_GATES).add(FABlocks.LEPIDODENDRON_FENCE_GATE.get(), FABlocks.SIGILLARIA_FENCE_GATE.get(), FABlocks.CALAMITES_FENCE_GATE.get());
        this.tag(BlockTags.CAULDRONS).add(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(FABlocks.FOSSIL_ORE.get(), FABlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(FABlocks.FOSSIL_ORE.get(), FABlocks.DEEPSLATE_FOSSIL_ORE.get(), FABlocks.SKULL_BLOCK.get(), FABlocks.SKULL_LANTERN_BLOCK.get(), FABlocks.ANALYZER.get(), FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get(), FABlocks.FEEDER.get(), FABlocks.ICED_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(FABlocks.ARCHAEOLOGY_WORKBENCH.get(), FABlocks.PALAEONTOLOGY_TABLE.get(), FABlocks.DRUM.get(), FABlocks.LEPIDODENDRON_PLANKS.get(), FABlocks.LEPIDODENDRON_LOG.get(), FABlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FABlocks.LEPIDODENDRON_WOOD.get(), FABlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), FABlocks.LEPIDODENDRON_STAIRS.get(), FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get(), FABlocks.LEPIDODENDRON_DOOR.get(), FABlocks.LEPIDODENDRON_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), FABlocks.LEPIDODENDRON_FENCE.get(), FABlocks.LEPIDODENDRON_TRAPDOOR.get(), FABlocks.LEPIDODENDRON_FENCE_GATE.get(), FABlocks.LEPIDODENDRON_BUTTON.get(), FABlocks.LEPIDODENDRON_SLAB.get(), FABlocks.SIGILLARIA_PLANKS.get(), FABlocks.SIGILLARIA_LOG.get(), FABlocks.STRIPPED_SIGILLARIA_LOG.get(), FABlocks.SIGILLARIA_WOOD.get(), FABlocks.STRIPPED_SIGILLARIA_WOOD.get(), FABlocks.SIGILLARIA_STAIRS.get(), FABlocks.SIGILLARIA_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get(), FABlocks.SIGILLARIA_DOOR.get(), FABlocks.SIGILLARIA_HANGING_SIGN.get(), FABlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FABlocks.SIGILLARIA_PRESSURE_PLATE.get(), FABlocks.SIGILLARIA_FENCE.get(), FABlocks.SIGILLARIA_TRAPDOOR.get(), FABlocks.SIGILLARIA_FENCE_GATE.get(), FABlocks.SIGILLARIA_BUTTON.get(), FABlocks.SIGILLARIA_SLAB.get(), FABlocks.CALAMITES_PLANKS.get(), FABlocks.CALAMITES_LOG.get(), FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.CALAMITES_WOOD.get(), FABlocks.STRIPPED_CALAMITES_WOOD.get(), FABlocks.CALAMITES_STAIRS.get(), FABlocks.CALAMITES_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get(), FABlocks.CALAMITES_DOOR.get(), FABlocks.CALAMITES_HANGING_SIGN.get(), FABlocks.CALAMITES_WALL_HANGING_SIGN.get(), FABlocks.CALAMITES_PRESSURE_PLATE.get(), FABlocks.CALAMITES_FENCE.get(), FABlocks.CALAMITES_TRAPDOOR.get(), FABlocks.CALAMITES_FENCE_GATE.get(), FABlocks.CALAMITES_BUTTON.get(), FABlocks.CALAMITES_SLAB.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(FABlocks.PERMAFROST.get());
        this.tag(BlockTags.DRAGON_IMMUNE).add(FABlocks.TIME_MACHINE.get());
        this.tag(BlockTags.WITHER_IMMUNE).add(FABlocks.TIME_MACHINE.get());

        this.tag(FABlockTags.ANKYLOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.BRACHIOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CALAMITES_LOGS).add(FABlocks.CALAMITES_LOG.get(), FABlocks.CALAMITES_WOOD.get(), FABlocks.STRIPPED_CALAMITES_LOG.get(), FABlocks.STRIPPED_CALAMITES_WOOD.get());
        this.tag(FABlockTags.CARNOTAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.COMPSOGNATHUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CRYOLOPHOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DILOPHOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DIMETRODON_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DODO_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.EATABLE_FERN).add(FABlocks.JURASSIC_FERN.get());
        this.tag(FABlockTags.EATABLE_LEAVES).addTags(BlockTags.LEAVES);
        this.tag(FABlockTags.FEEDER).add(FABlocks.FEEDER.get());
        this.tag(FABlockTags.GALLIMIMUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.SAND);
        this.tag(FABlockTags.JURASSIC_FERN_PLANTABLE_ON).addTag(BlockTags.DIRT);
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
