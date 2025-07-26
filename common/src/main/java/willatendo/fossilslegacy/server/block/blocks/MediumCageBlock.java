package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.block.FABlocks;

public class MediumCageBlock extends Block {
    public static final VoxelShape BOTTOM = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 2.0F, 16.0F);
    public static final VoxelShape TOP = Block.box(0.0F, 14.0F, 0.0F, 16.0F, 16.0F, 16.0F);
    public static final VoxelShape PART_1_BOTTOM = Block.box(0.0F, 2.0F, 0.0F, 2.0F, 16.0F, 2.0F);
    public static final VoxelShape PART_1_TOP = Block.box(0.0F, 0.0F, 0.0F, 2.0F, 14.0F, 2.0F);
    public static final VoxelShape PART_2_BOTTOM = Block.box(14.0F, 2.0F, 0.0F, 16.0F, 16.0F, 2.0F);
    public static final VoxelShape PART_2_TOP = Block.box(14.0F, 0.0F, 0.0F, 16.0F, 14.0F, 2.0F);
    public static final VoxelShape PART_3_BOTTOM = Block.box(0.0F, 2.0F, 14.0F, 2.0F, 16.0F, 16.0F);
    public static final VoxelShape PART_3_TOP = Block.box(0.0F, 0.0F, 14.0F, 2.0F, 14.0F, 16.0F);
    public static final VoxelShape PART_4_BOTTOM = Block.box(14.0F, 2.0F, 14.0F, 16, 16.0F, 16.0F);
    public static final VoxelShape PART_4_TOP = Block.box(14.0F, 0.0F, 14.0F, 16.0F, 14.0F, 16.0F);
    public static final VoxelShape NORTH_LEFT_BOTTOM = Block.box(2.0F, 2.0F, 0.0F, 16.0F, 16.0F, 2.0F);
    public static final VoxelShape NORTH_LEFT_TOP = Block.box(2.0F, 0.0F, 0.0F, 16.0F, 14.0F, 2.0F);
    public static final VoxelShape NORTH_RIGHT_BOTTOM = Block.box(0.0F, 2.0F, 0.0F, 14.0F, 16.0F, 2.0F);
    public static final VoxelShape NORTH_RIGHT_TOP = Block.box(0.0F, 0.0F, 0.0F, 14.0F, 14.0F, 2.0F);
    public static final VoxelShape EAST_LEFT_BOTTOM = Block.box(14.0F, 2.0F, 2.0F, 16.0F, 16.0F, 16.0F);
    public static final VoxelShape EAST_LEFT_TOP = Block.box(14.0F, 0.0F, 2.0F, 16.0F, 14.0F, 16.0F);
    public static final VoxelShape EAST_RIGHT_BOTTOM = Block.box(14.0F, 2.0F, 0.0F, 16.0F, 16.0F, 14.0F);
    public static final VoxelShape EAST_RIGHT_TOP = Block.box(14.0F, 0.0F, 0.0F, 16.0F, 14.0F, 14.0F);
    public static final VoxelShape SOUTH_LEFT_BOTTOM = Block.box(2.0F, 2.0F, 14.0F, 16.0F, 16.0F, 16.0F);
    public static final VoxelShape SOUTH_LEFT_TOP = Block.box(2.0F, 0.0F, 14.0F, 16.0F, 14.0F, 16.0F);
    public static final VoxelShape SOUTH_RIGHT_BOTTOM = Block.box(0.0F, 2.0F, 14.0F, 14.0F, 16.0F, 16.0F);
    public static final VoxelShape SOUTH_RIGHT_TOP = Block.box(0.0F, 0.0F, 14.0F, 14.0F, 14.0F, 16.0F);
    public static final VoxelShape WEST_LEFT_BOTTOM = Block.box(0.0F, 2.0F, 0.0F, 2.0F, 16.0F, 14.0F);
    public static final VoxelShape WEST_LEFT_TOP = Block.box(0.0F, 0.0F, 0.0F, 2.0F, 14.0F, 14.0F);
    public static final VoxelShape WEST_RIGHT_BOTTOM = Block.box(0.0F, 2.0F, 2.0F, 2.0F, 16.0F, 16.0F);
    public static final VoxelShape WEST_RIGHT_TOP = Block.box(0.0F, 0.0F, 2.0F, 2.0F, 14.0F, 16.0F);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final IntegerProperty PART = IntegerProperty.create("part", 1, 4);
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public MediumCageBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(OPEN, false).setValue(POWERED, false).setValue(PART, 1).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction facing = blockState.getValue(HORIZONTAL_FACING);
        int part = blockState.getValue(PART);
        boolean bottom = blockState.getValue(HALF) == DoubleBlockHalf.LOWER;
        boolean open = blockState.getValue(OPEN);
        VoxelShape base = bottom ? BOTTOM : TOP;
        VoxelShape bar = part == 1 ? bottom ? PART_1_BOTTOM : PART_1_TOP : part == 2 ? bottom ? PART_2_BOTTOM : PART_2_TOP : part == 3 ? bottom ? PART_3_BOTTOM : PART_3_TOP : part == 4 ? bottom ? PART_4_BOTTOM : PART_4_TOP : Shapes.block();
        VoxelShape baseAndBar = Shapes.join(base, bar, BooleanOp.OR);
        VoxelShape wallNS = part == 1 ? open && facing == Direction.NORTH ? Shapes.empty() : bottom ? NORTH_LEFT_BOTTOM : NORTH_LEFT_TOP : part == 2 ? open && facing == Direction.NORTH ? Shapes.empty() : bottom ? NORTH_RIGHT_BOTTOM : NORTH_RIGHT_TOP : part == 3 ? open && facing == Direction.SOUTH ? Shapes.empty() : bottom ? SOUTH_LEFT_BOTTOM : SOUTH_LEFT_TOP : part == 4 ? open && facing == Direction.SOUTH ? Shapes.empty() : bottom ? SOUTH_RIGHT_BOTTOM : SOUTH_RIGHT_TOP : Shapes.block();
        VoxelShape wallEW = part == 1 ? open && facing == Direction.WEST ? Shapes.empty() : bottom ? WEST_RIGHT_BOTTOM : WEST_RIGHT_TOP : part == 2 ? open && facing == Direction.EAST ? Shapes.empty() : bottom ? EAST_LEFT_BOTTOM : EAST_LEFT_TOP : part == 3 ? open && facing == Direction.WEST ? Shapes.empty() : bottom ? WEST_LEFT_BOTTOM : WEST_LEFT_TOP : part == 4 ? open && facing == Direction.EAST ? Shapes.empty() : bottom ? EAST_RIGHT_BOTTOM : EAST_RIGHT_TOP : Shapes.block();
        VoxelShape walls = Shapes.join(wallNS, wallEW, BooleanOp.OR);
        return Shapes.join(baseAndBar, walls, BooleanOp.OR);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        blockState = blockState.cycle(OPEN);
        level.setBlock(blockPos, blockState, 10);
        this.playSound(player, level, blockPos, blockState.getValue(OPEN));
        level.gameEvent(player, this.isOpen(blockState) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);

        DoubleBlockHalf doubleBlockHalf = blockState.getValue(HALF);
        int part = blockState.getValue(PART);
        if (part == 1) {
            BlockPos blockPosAt = blockPos.south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.east();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.east().south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            BlockPos relative = doubleBlockHalf == DoubleBlockHalf.LOWER ? blockPos.above() : blockPos.below();
            blockPosAt = relative;
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.east();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.east().south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
        } else if (part == 2) {
            BlockPos blockPosAt = blockPos.south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.west();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.west().south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            BlockPos relative = doubleBlockHalf == DoubleBlockHalf.LOWER ? blockPos.above() : blockPos.below();
            blockPosAt = relative;
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.west();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.west().south();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
        } else if (part == 3) {
            BlockPos blockPosAt = blockPos.north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.east();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.east().north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            BlockPos relative = doubleBlockHalf == DoubleBlockHalf.LOWER ? blockPos.above() : blockPos.below();
            blockPosAt = relative;
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.east();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.east().north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
        } else if (part == 4) {
            BlockPos blockPosAt = blockPos.north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.west();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = blockPos.west().north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            BlockPos relative = doubleBlockHalf == DoubleBlockHalf.LOWER ? blockPos.above() : blockPos.below();
            blockPosAt = relative;
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.west();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
            blockPosAt = relative.west().north();
            level.setBlock(blockPosAt, level.getBlockState(blockPosAt).cycle(OPEN), 10);
        }
        return InteractionResult.SUCCESS;
    }

    public boolean isOpen(BlockState blockState) {
        return blockState.getValue(OPEN);
    }

    private void playSound(Entity source, Level level, BlockPos blockPos, boolean isOpening) {
        level.playSound(source, blockPos, isOpening ? SoundEvents.IRON_DOOR_OPEN : SoundEvents.IRON_DOOR_CLOSE, SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState blockState) {
        return true;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide && (player.isCreative() || !player.hasCorrectToolForDrops(blockState))) {
            MediumCageBlock.preventDropInCreative(level, blockPos, blockState, player);
        }

        return super.playerWillDestroy(level, blockPos, blockState, player);
    }

    protected static void preventDropInCreative(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        DoubleBlockHalf doubleBlockHalf = blockState.getValue(HALF);
        int part = blockState.getValue(PART);
        BlockPos droppingBlockPos = blockPos;
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            droppingBlockPos = blockPos.below();
        }
        if (part == 2) {
            droppingBlockPos = droppingBlockPos.west();
        }
        if (part == 3) {
            droppingBlockPos = droppingBlockPos.north();
        }
        if (part == 4) {
            droppingBlockPos = droppingBlockPos.west().north();
        }
        BlockState droppingBlockState = level.getBlockState(droppingBlockPos);
        if (droppingBlockState.is(blockState.getBlock()) && droppingBlockState.getValue(HALF) == DoubleBlockHalf.LOWER && droppingBlockState.getValue(PART) == 1) {
            level.setBlock(droppingBlockPos, Blocks.AIR.defaultBlockState(), 35);
            level.levelEvent(player, 2001, droppingBlockPos, Block.getId(droppingBlockState));
        }
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighborBlockPos, BlockState neighborBlockState, RandomSource randomSource) {
        int part = blockState.getValue(PART);
        DoubleBlockHalf doubleBlockHalf = blockState.getValue(HALF);
        boolean hasOpposite = (doubleBlockHalf == DoubleBlockHalf.LOWER ? levelReader.getBlockState(blockPos.above()).is(this) : levelReader.getBlockState(blockPos.below()).is(this));
        boolean hasPart = part == 1 ? (levelReader.getBlockState(blockPos.south()).is(this) && levelReader.getBlockState(blockPos.east()).is(this)) : part == 2 ? (levelReader.getBlockState(blockPos.south()).is(this) && levelReader.getBlockState(blockPos.west()).is(this)) : part == 3 ? (levelReader.getBlockState(blockPos.north()).is(this) && levelReader.getBlockState(blockPos.east()).is(this)) : (levelReader.getBlockState(blockPos.north()).is(this) && levelReader.getBlockState(blockPos.west()).is(this));
        return hasOpposite && hasPart ? super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighborBlockPos, neighborBlockState, randomSource) : Blocks.AIR.defaultBlockState();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction facing = blockPlaceContext.getHorizontalDirection();
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        boolean flag = level.hasNeighborSignal(blockPos);
        BlockState blockState = super.getStateForPlacement(blockPlaceContext).setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite()).setValue(POWERED, flag).setValue(OPEN, flag);
        boolean hasRoom =
                level.isInWorldBounds(blockPos.relative(facing)) &&
                        level.isInWorldBounds(blockPos.relative(facing.getCounterClockWise())) &&
                        level.isInWorldBounds(blockPos.relative(facing).relative(facing.getCounterClockWise())) &&
                        level.isInWorldBounds(blockPos.above()) &&
                        level.isInWorldBounds(blockPos.above().relative(facing)) &&
                        level.isInWorldBounds(blockPos.above().relative(facing.getCounterClockWise())) &&
                        level.isInWorldBounds(blockPos.above().relative(facing).relative(facing.getCounterClockWise()))
                && level.getBlockState(blockPos.relative(facing)).canBeReplaced()
                        && level.getBlockState(blockPos.relative(facing.getCounterClockWise())).canBeReplaced()
                        && level.getBlockState(blockPos.relative(facing).relative(facing.getCounterClockWise())).canBeReplaced()
                        && level.getBlockState(blockPos.above()).canBeReplaced()
                        && level.getBlockState(blockPos.above().relative(facing)).canBeReplaced()
                        && level.getBlockState(blockPos.above().relative(facing.getCounterClockWise())).canBeReplaced()
                        && level.getBlockState(blockPos.above().relative(facing).relative(facing.getCounterClockWise())).canBeReplaced()
                ;
        return !hasRoom ? null : facing == Direction.NORTH ? blockState.setValue(PART, 4) : facing == Direction.EAST ? blockState.setValue(PART, 3) : facing == Direction.WEST ? blockState.setValue(PART, 2) : blockState;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity placer, ItemStack itemStack) {
        Direction facing = placer.getDirection();
        Direction placeFacing = facing.getOpposite();
        int left = facing == Direction.NORTH ? 3 : facing == Direction.EAST ? 1 : facing == Direction.WEST ? 4 : 2;
        int ahead = facing == Direction.NORTH ? 2 : facing == Direction.EAST ? 4 : facing == Direction.WEST ? 1 : 3;
        int aheadLeft = facing == Direction.NORTH ? 1 : facing == Direction.EAST ? 2 : facing == Direction.WEST ? 3 : 4;
        BlockState blockStateToPlace = FABlocks.MEDIUM_CAGE.get().defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER);
        level.setBlock(blockPos.relative(facing.getCounterClockWise()), blockStateToPlace.setValue(PART, left).setValue(HORIZONTAL_FACING, placeFacing), 3);
        level.setBlock(blockPos.relative(facing), blockStateToPlace.setValue(PART, ahead).setValue(HORIZONTAL_FACING, placeFacing), 3);
        level.setBlock(blockPos.relative(facing).relative(facing.getCounterClockWise()), blockStateToPlace.setValue(PART, aheadLeft).setValue(HORIZONTAL_FACING, placeFacing), 3);
        blockStateToPlace = FABlocks.MEDIUM_CAGE.get().defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER);
        level.setBlock(blockPos.above(), blockStateToPlace.setValue(PART, facing == Direction.NORTH ? 4 : facing == Direction.EAST ? 3 : facing == Direction.WEST ? 2 : 1).setValue(HORIZONTAL_FACING, placeFacing), 3);
        level.setBlock(blockPos.above().relative(facing.getCounterClockWise()), blockStateToPlace.setValue(PART, left).setValue(HORIZONTAL_FACING, placeFacing), 3);
        level.setBlock(blockPos.above().relative(facing), blockStateToPlace.setValue(PART, ahead).setValue(HORIZONTAL_FACING, placeFacing), 3);
        level.setBlock(blockPos.above().relative(facing).relative(facing.getCounterClockWise()), blockStateToPlace.setValue(PART, aheadLeft).setValue(HORIZONTAL_FACING, placeFacing), 3);
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
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, Orientation orientation, boolean movedByPiston) {
        boolean flag = level.hasNeighborSignal(blockPos);
        if (!this.defaultBlockState().is(block) && flag != blockState.getValue(POWERED)) {
            if (flag != blockState.getValue(OPEN)) {
                this.playSound(null, level, blockPos, flag);
                level.gameEvent(null, flag ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
            }

            level.setBlock(blockPos, blockState.setValue(POWERED, flag).setValue(OPEN, flag), 2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, OPEN, POWERED, PART, HALF);
    }
}
