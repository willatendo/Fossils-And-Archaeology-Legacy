package willatendo.fossilslegacy.data;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.tags.FossilsLegacyBlockTags;

import java.util.concurrent.CompletableFuture;

public class FossilsLegacyBlockTagProvider extends BlockTagsProvider {
    public FossilsLegacyBlockTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId, ExistingFileHelper existingFileHelper) {
        super(packOutput, provider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(BlockTags.PLANKS).add(FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get(), FossilsLegacyBlocks.SIGILLARIA_PLANKS.get(), FossilsLegacyBlocks.CALAMITES_PLANKS.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(FossilsLegacyBlocks.LEPIDODENDRON_BUTTON.get(), FossilsLegacyBlocks.SIGILLARIA_BUTTON.get(), FossilsLegacyBlocks.CALAMITES_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get(), FossilsLegacyBlocks.SIGILLARIA_DOOR.get(), FossilsLegacyBlocks.CALAMITES_DOOR.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get(), FossilsLegacyBlocks.SIGILLARIA_STAIRS.get(), FossilsLegacyBlocks.CALAMITES_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get(), FossilsLegacyBlocks.SIGILLARIA_SLAB.get(), FossilsLegacyBlocks.CALAMITES_SLAB.get());
        this.tag(BlockTags.WOODEN_FENCES).add(FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get(), FossilsLegacyBlocks.SIGILLARIA_FENCE.get(), FossilsLegacyBlocks.CALAMITES_FENCE.get());
        this.tag(BlockTags.SAPLINGS).add(FossilsLegacyBlocks.LEPIDODENDRON_SAPLING.get(), FossilsLegacyBlocks.SIGILLARIA_SAPLING.get(), FossilsLegacyBlocks.CALAMITES_SAPLING.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTags(FossilsLegacyBlockTags.LEPIDODENDRON_LOGS, FossilsLegacyBlockTags.SIGILLARIA_LOGS, FossilsLegacyBlockTags.CALAMITES_LOGS);
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).addTags(FossilsLegacyBlockTags.LEPIDODENDRON_LOGS, FossilsLegacyBlockTags.SIGILLARIA_LOGS, FossilsLegacyBlockTags.CALAMITES_LOGS);
        this.tag(BlockTags.FLOWER_POTS).add(FossilsLegacyBlocks.POTTED_LEPIDODENDRON_SAPLING.get(), FossilsLegacyBlocks.POTTED_SIGILLARIA_SAPLING.get(), FossilsLegacyBlocks.POTTED_CALAMITES_SAPLING.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(FossilsLegacyBlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), FossilsLegacyBlocks.SIGILLARIA_PRESSURE_PLATE.get(), FossilsLegacyBlocks.CALAMITES_PRESSURE_PLATE.get());
        this.tag(BlockTags.LEAVES).add(FossilsLegacyBlocks.LEPIDODENDRON_LEAVES.get(), FossilsLegacyBlocks.SIGILLARIA_LEAVES.get(), FossilsLegacyBlocks.CALAMITES_LEAVES.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get(), FossilsLegacyBlocks.SIGILLARIA_TRAPDOOR.get(), FossilsLegacyBlocks.CALAMITES_TRAPDOOR.get());
        this.tag(BlockTags.STANDING_SIGNS).add(FossilsLegacyBlocks.LEPIDODENDRON_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_SIGN.get(), FossilsLegacyBlocks.CALAMITES_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(FossilsLegacyBlocks.LEPIDODENDRON_WALL_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_SIGN.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(FossilsLegacyBlocks.LEPIDODENDRON_HANGING_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_HANGING_SIGN.get(), FossilsLegacyBlocks.CALAMITES_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(FossilsLegacyBlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_HANGING_SIGN.get());
        this.tag(BlockTags.FENCE_GATES).add(FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get(), FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get(), FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get());
        this.tag(BlockTags.CAULDRONS).add(FossilsLegacyBlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FossilsLegacyBlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), FossilsLegacyBlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), FossilsLegacyBlocks.COOKED_BERRY_MEDLEY_CAULDRON.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(FossilsLegacyBlocks.FOSSIL_ORE.get(), FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(FossilsLegacyBlocks.FOSSIL_ORE.get(), FossilsLegacyBlocks.DEEPSLATE_FOSSIL_ORE.get(), FossilsLegacyBlocks.SKULL_BLOCK.get(), FossilsLegacyBlocks.SKULL_LANTURN_BLOCK.get(), FossilsLegacyBlocks.ANALYZER.get(), FossilsLegacyBlocks.BLACK_CULTIVATOR.get(), FossilsLegacyBlocks.BLUE_CULTIVATOR.get(), FossilsLegacyBlocks.BROWN_CULTIVATOR.get(), FossilsLegacyBlocks.CYAN_CULTIVATOR.get(), FossilsLegacyBlocks.GRAY_CULTIVATOR.get(), FossilsLegacyBlocks.GREEN_CULTIVATOR.get(), FossilsLegacyBlocks.LIGHT_BLUE_CULTIVATOR.get(), FossilsLegacyBlocks.LIGHT_GRAY_CULTIVATOR.get(), FossilsLegacyBlocks.LIME_CULTIVATOR.get(), FossilsLegacyBlocks.MAGENTA_CULTIVATOR.get(), FossilsLegacyBlocks.ORANGE_CULTIVATOR.get(), FossilsLegacyBlocks.PINK_CULTIVATOR.get(), FossilsLegacyBlocks.PURPLE_CULTIVATOR.get(), FossilsLegacyBlocks.WHITE_CULTIVATOR.get(), FossilsLegacyBlocks.YELLOW_CULTIVATOR.get(), FossilsLegacyBlocks.FEEDER.get(), FossilsLegacyBlocks.ICED_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(FossilsLegacyBlocks.ARCHAEOLOGY_WORKBENCH.get(), FossilsLegacyBlocks.DRUM.get(), FossilsLegacyBlocks.LEPIDODENDRON_PLANKS.get(), FossilsLegacyBlocks.LEPIDODENDRON_LOG.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get(), FossilsLegacyBlocks.LEPIDODENDRON_STAIRS.get(), FossilsLegacyBlocks.LEPIDODENDRON_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_DOOR.get(), FossilsLegacyBlocks.LEPIDODENDRON_HANGING_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_WALL_HANGING_SIGN.get(), FossilsLegacyBlocks.LEPIDODENDRON_PRESSURE_PLATE.get(), FossilsLegacyBlocks.LEPIDODENDRON_FENCE.get(), FossilsLegacyBlocks.LEPIDODENDRON_TRAPDOOR.get(), FossilsLegacyBlocks.LEPIDODENDRON_FENCE_GATE.get(), FossilsLegacyBlocks.LEPIDODENDRON_BUTTON.get(), FossilsLegacyBlocks.LEPIDODENDRON_SLAB.get(), FossilsLegacyBlocks.SIGILLARIA_PLANKS.get(), FossilsLegacyBlocks.SIGILLARIA_LOG.get(), FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get(), FossilsLegacyBlocks.SIGILLARIA_WOOD.get(), FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get(), FossilsLegacyBlocks.SIGILLARIA_STAIRS.get(), FossilsLegacyBlocks.SIGILLARIA_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_DOOR.get(), FossilsLegacyBlocks.SIGILLARIA_HANGING_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_WALL_HANGING_SIGN.get(), FossilsLegacyBlocks.SIGILLARIA_PRESSURE_PLATE.get(), FossilsLegacyBlocks.SIGILLARIA_FENCE.get(), FossilsLegacyBlocks.SIGILLARIA_TRAPDOOR.get(), FossilsLegacyBlocks.SIGILLARIA_FENCE_GATE.get(), FossilsLegacyBlocks.SIGILLARIA_BUTTON.get(), FossilsLegacyBlocks.SIGILLARIA_SLAB.get(), FossilsLegacyBlocks.CALAMITES_PLANKS.get(), FossilsLegacyBlocks.CALAMITES_LOG.get(), FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get(), FossilsLegacyBlocks.CALAMITES_WOOD.get(), FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get(), FossilsLegacyBlocks.CALAMITES_STAIRS.get(), FossilsLegacyBlocks.CALAMITES_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_SIGN.get(), FossilsLegacyBlocks.CALAMITES_DOOR.get(), FossilsLegacyBlocks.CALAMITES_HANGING_SIGN.get(), FossilsLegacyBlocks.CALAMITES_WALL_HANGING_SIGN.get(), FossilsLegacyBlocks.CALAMITES_PRESSURE_PLATE.get(), FossilsLegacyBlocks.CALAMITES_FENCE.get(), FossilsLegacyBlocks.CALAMITES_TRAPDOOR.get(), FossilsLegacyBlocks.CALAMITES_FENCE_GATE.get(), FossilsLegacyBlocks.CALAMITES_BUTTON.get(), FossilsLegacyBlocks.CALAMITES_SLAB.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(FossilsLegacyBlocks.PERMAFROST.get());

        this.tag(FossilsLegacyBlockTags.LEPIDODENDRON_LOGS).add(FossilsLegacyBlocks.LEPIDODENDRON_LOG.get(), FossilsLegacyBlocks.LEPIDODENDRON_WOOD.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_LOG.get(), FossilsLegacyBlocks.STRIPPED_LEPIDODENDRON_WOOD.get());
        this.tag(FossilsLegacyBlockTags.SIGILLARIA_LOGS).add(FossilsLegacyBlocks.SIGILLARIA_LOG.get(), FossilsLegacyBlocks.SIGILLARIA_WOOD.get(), FossilsLegacyBlocks.STRIPPED_SIGILLARIA_LOG.get(), FossilsLegacyBlocks.STRIPPED_SIGILLARIA_WOOD.get());
        this.tag(FossilsLegacyBlockTags.CALAMITES_LOGS).add(FossilsLegacyBlocks.CALAMITES_LOG.get(), FossilsLegacyBlocks.CALAMITES_WOOD.get(), FossilsLegacyBlocks.STRIPPED_CALAMITES_LOG.get(), FossilsLegacyBlocks.STRIPPED_CALAMITES_WOOD.get());
        this.tag(FossilsLegacyBlockTags.EATABLE_FERN).add(FossilsLegacyBlocks.JURASSIC_FERN.get());
        this.tag(FossilsLegacyBlockTags.EATABLE_LEAVES).addTags(BlockTags.LEAVES);
        this.tag(FossilsLegacyBlockTags.FEEDER).add(FossilsLegacyBlocks.FEEDER.get());
        this.tag(FossilsLegacyBlockTags.JURASSIC_FERN_PLANTABLE_ON).addTag(BlockTags.DIRT);
        this.tag(FossilsLegacyBlockTags.PERMAFROST_FROSTABLE).add(Blocks.STONE, Blocks.GRANITE, Blocks.ANDESITE, Blocks.DIORITE);
        this.tag(FossilsLegacyBlockTags.TYRANNOSAURUS_UNBREAKABLES).add(FossilsLegacyBlocks.FEEDER.get(), Blocks.BEDROCK, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_TRAPDOOR, Blocks.IRON_DOOR, Blocks.CHAIN, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_PORTAL_FRAME, Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY, Blocks.ENCHANTING_TABLE, Blocks.EMERALD_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.BARRIER, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_VOID, Blocks.SPAWNER, Blocks.TRIAL_SPAWNER, Blocks.LIGHT, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK).addTags(BlockTags.ANVIL);
        this.tag(FossilsLegacyBlockTags.SPINOSAURUS_UNBREAKABLES).add(FossilsLegacyBlocks.FEEDER.get(), Blocks.BEDROCK, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_TRAPDOOR, Blocks.IRON_DOOR, Blocks.CHAIN, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_PORTAL_FRAME, Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY, Blocks.ENCHANTING_TABLE, Blocks.EMERALD_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.BARRIER, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_VOID, Blocks.SPAWNER, Blocks.TRIAL_SPAWNER, Blocks.LIGHT, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK).addTags(BlockTags.ANVIL);
    }
}
