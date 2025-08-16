package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Function;

public interface TallPlantBlock {
    boolean featurePlace(WorldGenLevel worldGenLevel, RandomSource randomSource, BlockPos blockPos, int height, BlockState[] blockStates, Function<BlockPos, Boolean> canPlace);

    IntegerProperty sizeProperty();

    int[][] sizesPerHeight();
}
