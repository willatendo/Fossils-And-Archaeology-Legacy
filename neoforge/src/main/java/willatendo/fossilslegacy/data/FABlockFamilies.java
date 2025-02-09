package willatendo.fossilslegacy.data;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.block.FABlocks;

import java.util.Map;
import java.util.stream.Stream;

public class FABlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();

    public static final BlockFamily CALAMITES_PLANKS = familyBuilder(FABlocks.CALAMITES_PLANKS.get()).button(FABlocks.CALAMITES_BUTTON.get()).fence(FABlocks.CALAMITES_FENCE.get()).fenceGate(FABlocks.CALAMITES_FENCE_GATE.get()).pressurePlate(FABlocks.CALAMITES_PRESSURE_PLATE.get()).sign(FABlocks.CALAMITES_SIGN.get(), FABlocks.CALAMITES_WALL_SIGN.get()).slab(FABlocks.CALAMITES_SLAB.get()).stairs(FABlocks.CALAMITES_STAIRS.get()).door(FABlocks.CALAMITES_DOOR.get()).trapdoor(FABlocks.CALAMITES_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily LEPIDODENDRON_PLANKS = familyBuilder(FABlocks.LEPIDODENDRON_PLANKS.get()).button(FABlocks.LEPIDODENDRON_BUTTON.get()).fence(FABlocks.LEPIDODENDRON_FENCE.get()).fenceGate(FABlocks.LEPIDODENDRON_FENCE_GATE.get()).pressurePlate(FABlocks.LEPIDODENDRON_PRESSURE_PLATE.get()).sign(FABlocks.LEPIDODENDRON_SIGN.get(), FABlocks.LEPIDODENDRON_WALL_SIGN.get()).slab(FABlocks.LEPIDODENDRON_SLAB.get()).stairs(FABlocks.LEPIDODENDRON_STAIRS.get()).door(FABlocks.LEPIDODENDRON_DOOR.get()).trapdoor(FABlocks.LEPIDODENDRON_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily SIGILLARIA_PLANKS = familyBuilder(FABlocks.SIGILLARIA_PLANKS.get()).button(FABlocks.SIGILLARIA_BUTTON.get()).fence(FABlocks.SIGILLARIA_FENCE.get()).fenceGate(FABlocks.SIGILLARIA_FENCE_GATE.get()).pressurePlate(FABlocks.SIGILLARIA_PRESSURE_PLATE.get()).sign(FABlocks.SIGILLARIA_SIGN.get(), FABlocks.SIGILLARIA_WALL_SIGN.get()).slab(FABlocks.SIGILLARIA_SLAB.get()).stairs(FABlocks.SIGILLARIA_STAIRS.get()).door(FABlocks.SIGILLARIA_DOOR.get()).trapdoor(FABlocks.SIGILLARIA_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();

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
