package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class MacrotaeniopterisBlock extends DoublePlantBlock implements SimpleWaterloggedBlock, BonemealableBlock {
    public static final MapCodec<MacrotaeniopterisBlock> CODEC = Block.simpleCodec(MacrotaeniopterisBlock::new);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty AMOUNT = IntegerProperty.create("amount", 1, 5);

    public MacrotaeniopterisBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return !blockPlaceContext.isSecondaryUseActive() && blockPlaceContext.getItemInHand().is(this.asItem()) && blockState.getValue(AMOUNT) < 5 ? true : blockState.canBeReplaced() && (blockPlaceContext.getItemInHand().isEmpty() || !blockPlaceContext.getItemInHand().is(this.asItem()));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        FluidState fluidState = level.getFluidState(blockPlaceContext.getClickedPos());
        if (level.getFluidState(blockPlaceContext.getClickedPos().above()).is(FluidTags.WATER)) {
            return null;
        }
        BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        return blockState.is(this) ? blockState.setValue(AMOUNT, Math.min(5, blockState.getValue(AMOUNT) + 1)) : super.getStateForPlacement(blockPlaceContext).setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity placer, ItemStack itemStack) {
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
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighborBlockPos, BlockState neighborBlockState, RandomSource randomSource) {
        if (blockState.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }

        DoubleBlockHalf doubleBlockHalf = blockState.getValue(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleBlockHalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || neighborBlockState.is(this) && neighborBlockState.getValue(HALF) != doubleBlockHalf) {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighborBlockPos, neighborBlockState, randomSource);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    @Override
    protected FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(HORIZONTAL_FACING, rotation.rotate(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(HORIZONTAL_FACING, WATERLOGGED, AMOUNT));
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        int amount = blockState.getValue(AMOUNT);
        if (amount < 5 && blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            serverLevel.setBlock(blockPos, blockState.setValue(AMOUNT, amount + 1), 2);
            serverLevel.setBlock(blockPos.above(), blockState.setValue(MacrotaeniopterisBlock.HALF, DoubleBlockHalf.UPPER).setValue(AMOUNT, amount + 1), 2);
        } else {
            Block.popResource(serverLevel, blockPos, new ItemStack(this));
        }
    }

    @Override
    public MapCodec<? extends DoublePlantBlock> codec() {
        return CODEC;
    }
}
