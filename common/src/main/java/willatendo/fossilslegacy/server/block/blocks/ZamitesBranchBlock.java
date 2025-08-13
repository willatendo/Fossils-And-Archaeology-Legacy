package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
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
import willatendo.fossilslegacy.server.block.FABlocks;

import java.util.Map;

public class ZamitesBranchBlock extends Block {
    public static final MapCodec<ZamitesBranchBlock> CODEC = Block.simpleCodec(ZamitesBranchBlock::new);
    public static final IntegerProperty PART = IntegerProperty.create("part", 1, 2);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final Map<Direction, VoxelShape> BOTTOM_SHAPES = Map.of(Direction.NORTH, Block.box(5.0F, 5.0F, 10.0F, 11.0F, 16.0F, 16.0F), Direction.EAST, Block.box(0.0F, 5.0F, 5.0F, 6.0F, 16.0F, 11.0F), Direction.SOUTH, Block.box(5.0F, 5.0F, 0.0F, 11.0F, 16.0F, 6.0F), Direction.WEST, Block.box(10.0F, 5.0F, 5.0F, 16.0F, 16.0F, 11.0F));
    private static final Map<Direction, VoxelShape> TOP_SHAPES = Map.of(Direction.NORTH, Block.box(6.0F, 0.0F, 11.0F, 10.0F, 9.0F, 15.0F), Direction.EAST, Block.box(1.0F, 0.0F, 6.0F, 5.0F, 9.0F, 10.0F), Direction.SOUTH, Block.box(6.0F, 0.0F, 1.0F, 10.0F, 9.0F, 5.0F), Direction.WEST, Block.box(11.0F, 0.0F, 6.0F, 15.0F, 9.0F, 10.0F));

    public ZamitesBranchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(PART, 1).setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(HORIZONTAL_FACING);
        return blockState.getValue(PART) == 2 ? TOP_SHAPES.get(direction) : BOTTOM_SHAPES.get(direction);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos belowBlockPos = blockPlaceContext.getClickedPos().below();
        if (level.getBlockState(belowBlockPos).is(this)) {
            return super.getStateForPlacement(blockPlaceContext).setValue(PART, 2).setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
        } else {
            return super.getStateForPlacement(blockPlaceContext).setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
        }
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return blockState.getValue(PART) == 2 ? levelReader.getBlockState(blockPos.below()).is(this) : levelReader.getBlockState(blockPos.relative(blockState.getValue(HORIZONTAL_FACING).getOpposite())).is(FABlocks.ZAMITES_LOG.get()) || levelReader.getBlockState(blockPos.relative(blockState.getValue(HORIZONTAL_FACING).getOpposite())).is(FABlocks.ZAMITES_HEAD.get());
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighbourBlockPos, BlockState neighbourBlockState, RandomSource randomSource) {
        return !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighbourBlockPos, neighbourBlockState, randomSource);
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(HORIZONTAL_FACING, rotation.rotate(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART, HORIZONTAL_FACING);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}
