package willatendo.pridelands.data;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import willatendo.pridelands.server.block.PridelandsBlocks;

import java.util.Map;
import java.util.stream.Stream;

public class PridelandsBlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();

    public static final BlockFamily OUTSTONE = PridelandsBlockFamilies.familyBuilder(PridelandsBlocks.OUTSTONE.get()).slab(PridelandsBlocks.OUTSTONE_SLAB.get()).stairs(PridelandsBlocks.OUTSTONE_STAIRS.get()).pressurePlate(PridelandsBlocks.OUTSTONE_PRESSURE_PLATE.get()).button(PridelandsBlocks.OUTSTONE_BUTTON.get()).getFamily();
    public static final BlockFamily OUTSTONE_BRICKS = PridelandsBlockFamilies.familyBuilder(PridelandsBlocks.OUTSTONE_BRICKS.get()).slab(PridelandsBlocks.OUTSTONE_BRICK_SLAB.get()).stairs(PridelandsBlocks.OUTSTONE_BRICK_STAIRS.get()).wall(PridelandsBlocks.OUTSTONE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily PRIDESTONE = PridelandsBlockFamilies.familyBuilder(PridelandsBlocks.PRIDESTONE.get()).slab(PridelandsBlocks.PRIDESTONE_SLAB.get()).stairs(PridelandsBlocks.PRIDESTONE_STAIRS.get()).pressurePlate(PridelandsBlocks.PRIDESTONE_PRESSURE_PLATE.get()).button(PridelandsBlocks.PRIDESTONE_BUTTON.get()).getFamily();
    public static final BlockFamily PRIDESTONE_BRICKS = PridelandsBlockFamilies.familyBuilder(PridelandsBlocks.PRIDESTONE_BRICKS.get()).slab(PridelandsBlocks.PRIDESTONE_BRICK_SLAB.get()).stairs(PridelandsBlocks.PRIDESTONE_BRICK_STAIRS.get()).wall(PridelandsBlocks.PRIDESTONE_BRICK_WALL.get()).getFamily();
    public static final BlockFamily MOSSY_PRIDESTONE_BRICKS = PridelandsBlockFamilies.familyBuilder(PridelandsBlocks.MOSSY_PRIDESTONE_BRICKS.get()).slab(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_SLAB.get()).stairs(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_STAIRS.get()).wall(PridelandsBlocks.MOSSY_PRIDESTONE_BRICK_WALL.get()).getFamily();

    private static BlockFamily.Builder familyBuilder(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = MAP.put(baseBlock, builder.getFamily());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}
