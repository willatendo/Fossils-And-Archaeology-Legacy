package willatendo.fossilslegacy.data;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import willatendo.fossilslegacy.server.registry.FABlockRegistry;

import java.util.Map;
import java.util.stream.Stream;

public class FABlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();

    static {
        for (int i = 0; i < FABlockRegistry.woodSize(); i++) {
            FABlockFamilies.familyBuilder(FABlockRegistry.getPlanks(i).get()).button(FABlockRegistry.getButton(i).get()).fence(FABlockRegistry.getFence(i).get()).fenceGate(FABlockRegistry.getFenceGate(i).get()).pressurePlate(FABlockRegistry.getPressurePlate(i).get()).sign(FABlockRegistry.getSign(i).get(), FABlockRegistry.getWallSign(i).get()).slab(FABlockRegistry.getSlab(i).get()).stairs(FABlockRegistry.getStairs(i).get()).door(FABlockRegistry.getDoor(i).get()).trapdoor(FABlockRegistry.getTrapdoor(i).get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
        }
    }

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
