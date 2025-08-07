package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RampTrackBlock extends Block {
    public static final MapCodec<RampTrackBlock> CODEC = Block.simpleCodec(RampTrackBlock::new);
    private static final VoxelShape PART_1_SHAPE = Block.box(0.0F, 0.0F, 0.0F, 16.0F, 4.0F, 16.0F);
    private static final VoxelShape PART_2_SHAPE = Block.box(0.0F, 4.0F, 0.0F, 16.0F, 8.0F, 16.0F);
    private static final VoxelShape PART_3_SHAPE = Block.box(0.0F, 8.0F, 0.0F, 16.0F, 12.0F, 16.0F);
    private static final VoxelShape PART_4_SHAPE = Block.box(0.0F, 12.0F, 0.0F, 16.0F, 16.0F, 16.0F);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty PART = IntegerProperty.create("part", 1, 4);

    public RampTrackBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(PART, 1));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {

        return blockState.getValue(PART) == 1 ? PART_1_SHAPE : blockState.getValue(PART) == 2 ? PART_2_SHAPE : blockState.getValue(PART) == 3 ? PART_3_SHAPE : PART_4_SHAPE;
    }

    private void placeAll(Level level, Direction direction, BlockPos blockPos) {
        level.setBlock(blockPos.relative(direction), this.defaultBlockState().setValue(PART, 2).setValue(HORIZONTAL_FACING, direction), 3);
        level.setBlock(blockPos.relative(direction, 2), this.defaultBlockState().setValue(PART, 3).setValue(HORIZONTAL_FACING, direction), 3);
        level.setBlock(blockPos.relative(direction, 3), this.defaultBlockState().setValue(PART, 4).setValue(HORIZONTAL_FACING, direction), 3);
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighborBlockPos, BlockState neighborBlockState, RandomSource randomSource) {
        return direction == Direction.DOWN && !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighborBlockPos, neighborBlockState, randomSource);
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos belowBlockPos = blockPos.below();
        return Block.canSupportRigidBlock(levelReader, belowBlockPos) || Block.canSupportCenter(levelReader, belowBlockPos, Direction.UP);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Direction direction = blockPlaceContext.getHorizontalDirection();
        return level.getBlockState(blockPos.relative(direction)).canBeReplaced(blockPlaceContext) && level.isInWorldBounds(blockPos.relative(direction)) && this.canSurvive(this.defaultBlockState(), level, blockPos.relative(direction)) && level.getBlockState(blockPos.relative(direction, 2)).canBeReplaced(blockPlaceContext) && level.isInWorldBounds(blockPos.relative(direction, 2)) && this.canSurvive(this.defaultBlockState(), level, blockPos.relative(direction, 2)) ? this.defaultBlockState().setValue(HORIZONTAL_FACING, direction) : null;
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
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, placer, itemStack);
        if (!level.isClientSide) {
            this.placeAll(level, blockState.getValue(HORIZONTAL_FACING), blockPos);
            level.blockUpdated(blockPos, Blocks.AIR);
            blockState.updateNeighbourShapes(level, blockPos, 3);
        }
    }

    @Override
    protected long getSeed(BlockState blockState, BlockPos blockPos) {
        int part = blockState.getValue(PART);
        Direction direction = blockState.getValue(HORIZONTAL_FACING);
        BlockPos seedBlockPos = part == 2 ? blockPos.relative(direction.getOpposite()) : part == 3 ? blockPos.relative(direction.getOpposite(), 2) : part == 4 ? blockPos.relative(direction.getOpposite(), 3) : blockPos;
        return Mth.getSeed(seedBlockPos.getX(), seedBlockPos.getY(), seedBlockPos.getZ());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, PART);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
