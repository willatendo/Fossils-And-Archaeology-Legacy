package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.FABlocks;

public class TallHorsetailBlock extends HorsetailBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public TallHorsetailBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(AMOUNT, 1));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Shapes.block();
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return !blockPlaceContext.isSecondaryUseActive() && blockPlaceContext.getItemInHand().is(this.asItem()) && blockState.getValue(AMOUNT) < 3 ? true : blockState.canBeReplaced() && (blockPlaceContext.getItemInHand().isEmpty() || !blockPlaceContext.getItemInHand().is(this.asItem()));
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighborBlockPos, BlockState neighbourBlockState, RandomSource randomSource) {
        DoubleBlockHalf doubleBlockHalf = blockState.getValue(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleBlockHalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || neighbourBlockState.is(this) && neighbourBlockState.getValue(HALF) != doubleBlockHalf) {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighborBlockPos, neighbourBlockState, randomSource);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();
        return blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos.above()).canBeReplaced(blockPlaceContext) ? super.getStateForPlacement(blockPlaceContext) : null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        BlockState placedBlockState = level.getBlockState(blockPos);
        if (placedBlockState.is(this) && placedBlockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            BlockPos aboveBlockPos = blockPos.above();
            level.setBlock(aboveBlockPos, TallHorsetailBlock.copyWaterloggedFrom(level, aboveBlockPos, blockState.setValue(HALF, DoubleBlockHalf.UPPER)), 3);
        } else if (placedBlockState.is(this) && placedBlockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockPos belowBlockPos = blockPos.below();
            level.setBlock(belowBlockPos, TallHorsetailBlock.copyWaterloggedFrom(level, belowBlockPos, blockState.setValue(HALF, DoubleBlockHalf.LOWER)), 3);
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(state, level, pos);
        } else {
            BlockState blockstate = level.getBlockState(pos.below());
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public static void placeAt(LevelAccessor levelAccessor, BlockState blockState, BlockPos blockPos, int flags) {
        BlockPos blockpos = blockPos.above();
        levelAccessor.setBlock(blockPos, TallHorsetailBlock.copyWaterloggedFrom(levelAccessor, blockPos, blockState.setValue(HALF, DoubleBlockHalf.LOWER)), flags);
        levelAccessor.setBlock(blockpos, TallHorsetailBlock.copyWaterloggedFrom(levelAccessor, blockpos, blockState.setValue(HALF, DoubleBlockHalf.UPPER)), flags);
    }

    public static BlockState copyWaterloggedFrom(LevelReader level, BlockPos pos, BlockState state) {
        return state.hasProperty(BlockStateProperties.WATERLOGGED) ? state.setValue(BlockStateProperties.WATERLOGGED, level.isWaterAt(pos)) : state;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                TallHorsetailBlock.preventDropFromBottomPart(level, blockPos, blockState, player);
            } else {
                Block.dropResources(blockState, level, blockPos, null, player, player.getMainHandItem());
            }
        }

        return super.playerWillDestroy(level, blockPos, blockState, player);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, Blocks.AIR.defaultBlockState(), blockEntity, itemStack);
    }

    protected static void preventDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        DoubleBlockHalf doubleBlockHalf = blockState.getValue(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos belowBlockPos = blockPos.below();
            BlockState belowBlockState = level.getBlockState(belowBlockPos);
            if (belowBlockState.is(blockState.getBlock()) && belowBlockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState waterOrAirBlockState = belowBlockState.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(belowBlockPos, waterOrAirBlockState, 35);
                level.levelEvent(player, 2001, belowBlockPos, Block.getId(belowBlockState));
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(HALF));
    }

    @Override
    protected long getSeed(BlockState blockState, BlockPos blockPos) {
        return Mth.getSeed(blockPos.getX(), blockPos.below(blockState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), blockPos.getZ());
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        int amount = blockState.getValue(AMOUNT);
        if (amount < 3 && blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            serverLevel.setBlock(blockPos, blockState.setValue(AMOUNT, amount + 1), 2);
            serverLevel.setBlock(blockPos.above(), blockState.setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER).setValue(AMOUNT, amount + 1), 2);
        } else {
            Block.popResource(serverLevel, blockPos, new ItemStack(this));
        }
    }
}
