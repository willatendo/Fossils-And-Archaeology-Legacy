package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.tags.FABlockTags;

import java.util.function.Function;

public class ZamitesHeadBlock extends Block implements BonemealableBlock, TallPlantBlock {
    public static final MapCodec<ZamitesHeadBlock> CODEC = Block.simpleCodec(ZamitesHeadBlock::new);
    private static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D);

    public ZamitesHeadBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean featurePlace(WorldGenLevel worldGenLevel, RandomSource randomSource, BlockPos blockPos, int height, BlockState[] blockStates, Function<BlockPos, Boolean> canPlace) {
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(randomSource);
        for (int i = 0; i < height; i++) {
            BlockPos aboveBlockPos = blockPos.above(i);
            if (!canPlace.apply(aboveBlockPos)) {
                return false;
            }
            if (height == 3 && i == 2) {
                if (!canPlace.apply(aboveBlockPos.relative(direction)) || !canPlace.apply(aboveBlockPos.relative(direction).above())) {
                    return false;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            BlockPos aboveBlockPos = blockPos.above(i);
            if (height == 3 && i == 1) {
                worldGenLevel.setBlock(aboveBlockPos.relative(direction), FABlocks.ZAMITES_BRANCH.get().defaultBlockState().setValue(ZamitesBranchBlock.HORIZONTAL_FACING, direction).setValue(ZamitesBranchBlock.PART, 1), 3);
                worldGenLevel.setBlock(aboveBlockPos.relative(direction).above(), FABlocks.ZAMITES_BRANCH.get().defaultBlockState().setValue(ZamitesBranchBlock.HORIZONTAL_FACING, direction).setValue(ZamitesBranchBlock.PART, 2), 3);
                blockStates[i] = blockStates[i].setValue(ZamitesLogBlock.NORTH, direction == Direction.NORTH).setValue(ZamitesLogBlock.EAST, direction == Direction.EAST).setValue(ZamitesLogBlock.SOUTH, direction == Direction.SOUTH).setValue(ZamitesLogBlock.WEST, direction == Direction.WEST);
            }
            worldGenLevel.setBlock(aboveBlockPos, blockStates[i], 2);
        }
        return true;
    }

    @Override
    public IntegerProperty sizeProperty() {
        return ZamitesLogBlock.SIZE;
    }

    @Override
    public int[][] sizesPerHeight() {
        return new int[][]{{}, {1}, {2, 1}};
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        BlockPos aboveBlockPos = blockPlaceContext.getClickedPos().above();
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.is(this) && level.getBlockState(aboveBlockPos).isAir() && aboveBlockPos.getY() < level.getHeight()) {
            level.setBlock(blockPos.above(), blockState, 3);
            return this.placeLogs(level, blockPos, blockState, false);
        } else {
            return super.getStateForPlacement(blockPlaceContext);
        }
    }

    private BlockState placeLogs(Level level, BlockPos cycadHeadBlockPos, BlockState blockState, boolean placeAt) {
        BlockState blockStateBelowHead = level.getBlockState(cycadHeadBlockPos.below());
        BlockState blockState2BelowHead = level.getBlockState(cycadHeadBlockPos.below(2));
        if (!blockStateBelowHead.is(FABlocks.ZAMITES_LOG.get())) {
            if (placeAt) {
                level.setBlock(cycadHeadBlockPos, FABlocks.ZAMITES_LOG.get().defaultBlockState().setValue(ZamitesLogBlock.SIZE, 1), 3);
            }
            return FABlocks.ZAMITES_LOG.get().defaultBlockState().setValue(ZamitesLogBlock.SIZE, 1);
        }
        if (!blockState2BelowHead.is(FABlocks.ZAMITES_LOG.get())) {
            level.setBlock(cycadHeadBlockPos.below(), FABlocks.ZAMITES_LOG.get().defaultBlockState().setValue(ZamitesLogBlock.SIZE, 2), 3);
            Direction branch = Direction.Plane.HORIZONTAL.getRandomDirection(level.getRandom());
            level.setBlock(cycadHeadBlockPos.relative(branch), FABlocks.ZAMITES_BRANCH.get().defaultBlockState().setValue(ZamitesBranchBlock.HORIZONTAL_FACING, branch).setValue(ZamitesBranchBlock.PART, 1), 3);
            level.setBlock(cycadHeadBlockPos.above().relative(branch), FABlocks.ZAMITES_BRANCH.get().defaultBlockState().setValue(ZamitesBranchBlock.HORIZONTAL_FACING, branch).setValue(ZamitesBranchBlock.PART, 2), 3);
        }
        if (placeAt) {
            level.setBlock(cycadHeadBlockPos, FABlocks.ZAMITES_LOG.get().defaultBlockState().setValue(ZamitesLogBlock.SIZE, 1), 3);
        }
        return FABlocks.ZAMITES_LOG.get().defaultBlockState().setValue(ZamitesLogBlock.SIZE, 1);
    }

    @Override
    protected boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return blockPlaceContext.getItemInHand().is(this.asItem());
    }

    @Override
    protected void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(40) == 0 && !serverLevel.getBlockState(blockPos.below(2)).is(FABlocks.ZAMITES_LOG.get())) {
            serverLevel.setBlock(blockPos.above(), blockState, 3);
            this.placeLogs(serverLevel, blockPos, blockState, true);
        }
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState blockState) {
        return true;
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getBlockState(blockPos.below()).is(FABlocks.ZAMITES_LOG.get()) || levelReader.getBlockState(blockPos.below()).is(FABlockTags.ZAMITES_PLANTABLE_ON);
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighbourBlockPos, BlockState neighbourBlockState, RandomSource randomSource) {
        return !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighbourBlockPos, neighbourBlockState, randomSource);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        BlockPos abovePos = blockPos.above();
        return level.getBlockState(abovePos).isAir() && abovePos.getY() < level.getHeight();
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        serverLevel.setBlock(blockPos.above(), blockState, 3);
        this.placeLogs(serverLevel, blockPos, blockState, true);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
