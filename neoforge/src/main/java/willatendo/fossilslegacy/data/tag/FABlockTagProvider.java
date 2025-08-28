package willatendo.fossilslegacy.data.tag;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.registry.FABlockRegistry;
import willatendo.fossilslegacy.server.tags.FABlockTags;
import willatendo.simplelibrary.server.registry.SimpleHolder;

import java.util.concurrent.CompletableFuture;

public class FABlockTagProvider extends BlockTagsProvider {
    public FABlockTagProvider(PackOutput packOutput, CompletableFuture<Provider> provider, String modId) {
        super(packOutput, provider, modId);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(BlockTags.PLANKS).add(FABlockRegistry.getPlanks());
        this.tag(BlockTags.WOODEN_BUTTONS).add(FABlockRegistry.getButtons());
        this.tag(BlockTags.WOODEN_DOORS).add(FABlockRegistry.getDoors());
        this.tag(BlockTags.WOODEN_STAIRS).add(FABlockRegistry.getStairs());
        this.tag(BlockTags.STAIRS).add(FABlocks.ASPHALT_STAIRS.get(), FABlocks.POLISHED_ASPHALT_STAIRS.get(), FABlocks.POLISHED_ASPHALT_BRICK_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(FABlockRegistry.getSlabs());
        this.tag(BlockTags.SLABS).add(FABlocks.ASPHALT_SLAB.get(), FABlocks.POLISHED_ASPHALT_SLAB.get(), FABlocks.POLISHED_ASPHALT_BRICK_SLAB.get());
        this.tag(BlockTags.WOODEN_FENCES).add(FABlockRegistry.getFences());
        this.tag(BlockTags.WALLS).add(FABlocks.ASPHALT_WALL.get(), FABlocks.POLISHED_ASPHALT_WALL.get(), FABlocks.POLISHED_ASPHALT_BRICK_WALL.get());
        this.tag(BlockTags.SAPLINGS).add(FABlockRegistry.getSaplings());
        this.tag(BlockTags.LOGS_THAT_BURN).addTags(FABlockRegistry.LOG_TAGS);
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).addTags(FABlockRegistry.LOG_TAGS);
        this.tag(BlockTags.FLOWER_POTS).add(FABlockRegistry.getPottedSaplings());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(FABlockRegistry.getPressurePlates());
        this.tag(BlockTags.LEAVES).add(FABlockRegistry.getLeaves());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(FABlockRegistry.getTrapdoors());
        this.tag(BlockTags.STANDING_SIGNS).add(FABlockRegistry.getSigns());
        this.tag(BlockTags.WALL_SIGNS).add(FABlockRegistry.getWallSigns());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(FABlockRegistry.getHangingSigns());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(FABlockRegistry.getWallHangingSigns());
        this.tag(BlockTags.FENCE_GATES).add(FABlockRegistry.getFenceGates());
        this.tag(BlockTags.UNSTABLE_BOTTOM_CENTER).add(FABlockRegistry.getFenceGates());
        this.tag(BlockTags.CAULDRONS).add(FABlocks.RAW_CHICKEN_SOUP_CAULDRON.get(), FABlocks.COOKED_CHICKEN_SOUP_CAULDRON.get(), FABlocks.RAW_BERRY_MEDLEY_CAULDRON.get(), FABlocks.COOKED_BERRY_MEDLEY_CAULDRON.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(FABlocks.CENOZOIC_FOSSIL_ORE.get(), FABlocks.MESOZOIC_FOSSIL_ORE.get(), FABlocks.PALAEOZOIC_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_CENOZOIC_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_MESOZOIC_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_PALAEOZOIC_FOSSIL_ORE.get(), FABlocks.AMBER_ORE.get(), FABlocks.DEEPSLATE_AMBER_ORE.get(), FABlocks.PLANT_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_PLANT_FOSSIL_ORE.get(), FABlocks.RELIC_IN_STONE.get(), FABlocks.RELIC_IN_DEEPSLATE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(FABlocks.CENOZOIC_FOSSIL_ORE.get(), FABlocks.MESOZOIC_FOSSIL_ORE.get(), FABlocks.PALAEOZOIC_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_CENOZOIC_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_MESOZOIC_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_PALAEOZOIC_FOSSIL_ORE.get(), FABlocks.AMBER_ORE.get(), FABlocks.DEEPSLATE_AMBER_ORE.get(), FABlocks.PLANT_FOSSIL_ORE.get(), FABlocks.DEEPSLATE_PLANT_FOSSIL_ORE.get(), FABlocks.RELIC_IN_STONE.get(), FABlocks.RELIC_IN_DEEPSLATE.get(), FABlocks.SKULL_BLOCK.get(), FABlocks.SKULL_LANTERN_BLOCK.get(), FABlocks.DNA_ANALYZER.get(), FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLACK_SHATTERED_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BLUE_SHATTERED_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.BROWN_SHATTERED_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.CYAN_SHATTERED_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GRAY_SHATTERED_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.GREEN_SHATTERED_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_SHATTERED_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_SHATTERED_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.LIME_SHATTERED_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.MAGENTA_SHATTERED_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.ORANGE_SHATTERED_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PINK_SHATTERED_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.PURPLE_SHATTERED_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.WHITE_SHATTERED_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get(), FABlocks.YELLOW_SHATTERED_CULTIVATOR.get(), FABlocks.FEEDER.get(), FABlocks.ICED_STONE.get(), FABlocks.SMALL_CAGE.get(), FABlocks.MEDIUM_CAGE.get(), FABlocks.STRAIGHT_TRACK.get(), FABlocks.CORNER_TRACK.get(), FABlocks.RAMP_TRACK.get(), FABlocks.ASPHALT.get(), FABlocks.ASPHALT_STAIRS.get(), FABlocks.ASPHALT_SLAB.get(), FABlocks.ASPHALT_WALL.get(), FABlocks.POLISHED_ASPHALT.get(), FABlocks.POLISHED_ASPHALT_STAIRS.get(), FABlocks.POLISHED_ASPHALT_SLAB.get(), FABlocks.POLISHED_ASPHALT_WALL.get(), FABlocks.POLISHED_ASPHALT_BRICKS.get(), FABlocks.POLISHED_ASPHALT_BRICK_STAIRS.get(), FABlocks.POLISHED_ASPHALT_BRICK_SLAB.get(), FABlocks.POLISHED_ASPHALT_BRICK_WALL.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(FABlockRegistry.getPlanks()).add(FABlockRegistry.getLogs()).add(FABlockRegistry.getWood()).add(FABlockRegistry.getStrippedLogs()).add(FABlockRegistry.getStrippedWood()).add(FABlockRegistry.getStairs()).add(FABlockRegistry.getAllSigns()).add(FABlockRegistry.getDoors()).add(FABlockRegistry.getAllHangingSigns()).add(FABlockRegistry.getPressurePlates()).add(FABlockRegistry.getFences()).add(FABlockRegistry.getTrapdoors()).add(FABlockRegistry.getFenceGates()).add(FABlockRegistry.getButtons()).add(FABlockRegistry.getSlabs()).add(FABlocks.ARCHAEOLOGY_WORKBENCH.get(), FABlocks.PALAEONTOLOGY_TABLE.get(), FABlocks.DRUM.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(FABlocks.PERMAFROST.get());
        this.tag(BlockTags.DRAGON_IMMUNE).add(FABlocks.TIME_MACHINE.get());
        this.tag(BlockTags.WITHER_IMMUNE).add(FABlocks.TIME_MACHINE.get());
        this.tag(FABlockTags.STONES).add(FABlocks.ASPHALT.get(), FABlocks.POLISHED_ASPHALT.get(), FABlocks.POLISHED_ASPHALT_WALL.get());

        for (int i = 0; i < FABlockRegistry.woodSize(); i++) {
            this.tag(FABlockRegistry.LOG_TAGS[i]).add(FABlockRegistry.getLog(i).get(), FABlockRegistry.getStrippedLog(i).get(), FABlockRegistry.getWood(i).get(), FABlockRegistry.getStrippedWood(i).get());
        }
        this.tag(FABlockTags.ANKYLOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.BARYONYX_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.BRACHIOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CARNOTAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.COMPSOGNATHUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CRYOLOPHOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.CULTIVATORS).add(FABlocks.BLACK_CULTIVATOR.get(), FABlocks.BLACK_SHATTERED_CULTIVATOR.get(), FABlocks.BLUE_CULTIVATOR.get(), FABlocks.BLUE_SHATTERED_CULTIVATOR.get(), FABlocks.BROWN_CULTIVATOR.get(), FABlocks.BROWN_SHATTERED_CULTIVATOR.get(), FABlocks.CYAN_CULTIVATOR.get(), FABlocks.CYAN_SHATTERED_CULTIVATOR.get(), FABlocks.GRAY_CULTIVATOR.get(), FABlocks.GRAY_SHATTERED_CULTIVATOR.get(), FABlocks.GREEN_CULTIVATOR.get(), FABlocks.GREEN_SHATTERED_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_CULTIVATOR.get(), FABlocks.LIGHT_BLUE_SHATTERED_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_CULTIVATOR.get(), FABlocks.LIGHT_GRAY_SHATTERED_CULTIVATOR.get(), FABlocks.LIME_CULTIVATOR.get(), FABlocks.LIME_SHATTERED_CULTIVATOR.get(), FABlocks.MAGENTA_CULTIVATOR.get(), FABlocks.MAGENTA_SHATTERED_CULTIVATOR.get(), FABlocks.ORANGE_CULTIVATOR.get(), FABlocks.ORANGE_SHATTERED_CULTIVATOR.get(), FABlocks.PINK_CULTIVATOR.get(), FABlocks.PINK_SHATTERED_CULTIVATOR.get(), FABlocks.PURPLE_CULTIVATOR.get(), FABlocks.PURPLE_SHATTERED_CULTIVATOR.get(), FABlocks.WHITE_CULTIVATOR.get(), FABlocks.WHITE_SHATTERED_CULTIVATOR.get(), FABlocks.YELLOW_CULTIVATOR.get(), FABlocks.YELLOW_SHATTERED_CULTIVATOR.get());
        this.tag(FABlockTags.CYCAD_PLANTABLE_ON).addTag(BlockTags.DIRT);
        this.tag(FABlockTags.ZAMITES_PLANTABLE_ON).addTag(BlockTags.DIRT);
        this.tag(FABlockTags.DILOPHOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DIMETRODON_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DODO_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.DRYOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.EATABLE_FERN).add(FABlocks.SHORT_HORSETAIL.get(), FABlocks.TALL_HORSETAIL.get(), FABlocks.JURASSIC_FERN.get());
        this.tag(FABlockTags.EATABLE_LEAVES).addTags(BlockTags.LEAVES);
        this.tag(FABlockTags.ELASMOTHERIUM_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.FEEDER).add(FABlocks.FEEDER.get());
        this.tag(FABlockTags.GALLIMIMUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.SAND);
        this.tag(FABlockTags.JURASSIC_FERN_PLANTABLE_ON).addTag(BlockTags.DIRT);
        this.tag(FABlockTags.LLAMA_STATUES).add(FABlocks.IRON_LLAMA_STATUE.get(), FABlocks.COPPER_LLAMA_STATUE.get(), FABlocks.EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.OXIDIZED_COPPER_LLAMA_STATUE.get(), FABlocks.WEATHERED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_EXPOSED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_OXIDIZED_COPPER_LLAMA_STATUE.get(), FABlocks.WAXED_WEATHERED_COPPER_LLAMA_STATUE.get());
        this.tag(FABlockTags.MAMMOTH_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.MINEABLE_WITH_ANCIENT_HOE).addTags(BlockTags.MINEABLE_WITH_HOE).add(Blocks.WHEAT, Blocks.CARROTS, Blocks.POTATOES, Blocks.BEETROOTS, Blocks.MELON_STEM, Blocks.ATTACHED_MELON_STEM, Blocks.PUMPKIN_STEM, Blocks.ATTACHED_PUMPKIN_STEM, Blocks.PITCHER_CROP, Blocks.TORCHFLOWER_CROP);
        this.tag(FABlockTags.MOA_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.NEEDS_SCARAB_GEM_TOOL).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.PACHYCEPHALOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.PERMAFROST_FROSTABLE).add(Blocks.STONE, Blocks.GRANITE, Blocks.ANDESITE, Blocks.DIORITE);
        this.tag(FABlockTags.PTERANODON_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.SMILODON_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.SPINOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.SPINOSAURUS_UNBREAKABLES).add(FABlocks.FEEDER.get(), Blocks.BEDROCK, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_TRAPDOOR, Blocks.IRON_DOOR, Blocks.CHAIN, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_PORTAL_FRAME, Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY, Blocks.ENCHANTING_TABLE, Blocks.EMERALD_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.BARRIER, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_VOID, Blocks.SPAWNER, Blocks.TRIAL_SPAWNER, Blocks.LIGHT, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK).addTags(BlockTags.ANVIL);
        this.tag(FABlockTags.STEGOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.THERIZINOSAURUS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON);
        this.tag(FABlockTags.TRICERATOPS_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.SAND);
        this.tag(FABlockTags.TYRANNOSAURUS_UNBREAKABLES).add(FABlocks.FEEDER.get(), Blocks.BEDROCK, Blocks.IRON_BLOCK, Blocks.IRON_BARS, Blocks.IRON_TRAPDOOR, Blocks.IRON_DOOR, Blocks.CHAIN, Blocks.OBSIDIAN, Blocks.CRYING_OBSIDIAN, Blocks.END_PORTAL_FRAME, Blocks.NETHER_PORTAL, Blocks.END_PORTAL, Blocks.END_GATEWAY, Blocks.ENCHANTING_TABLE, Blocks.EMERALD_BLOCK, Blocks.REDSTONE_BLOCK, Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.BARRIER, Blocks.STRUCTURE_BLOCK, Blocks.STRUCTURE_VOID, Blocks.SPAWNER, Blocks.TRIAL_SPAWNER, Blocks.LIGHT, Blocks.COMMAND_BLOCK, Blocks.CHAIN_COMMAND_BLOCK, Blocks.REPEATING_COMMAND_BLOCK).addTags(BlockTags.ANVIL);
        this.tag(FABlockTags.VELOCIRAPTOR_SPAWNABLE).addTags(BlockTags.ANIMALS_SPAWNABLE_ON).add(Blocks.SAND);
    }
}
