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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.FABlocks;
import willatendo.fossilslegacy.server.tags.FABlockTags;

import java.util.Map;
import java.util.function.Function;

public class ZamitesLogBlock extends Block {
    public static final MapCodec<ZamitesLogBlock> CODEC = Block.simpleCodec(ZamitesLogBlock::new);
    public static final IntegerProperty SIZE = IntegerProperty.create("size", 1, 2);
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = Map.of(Direction.NORTH, NORTH, Direction.EAST, EAST, Direction.SOUTH, SOUTH, Direction.WEST, WEST);
    private static final VoxelShape SHAPE_2 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape SHAPE_1 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final Map<Direction, Function<Boolean, VoxelShape>> BRANCHES = Map.of(Direction.NORTH, small -> Block.box(5.0F, 5.0F, 0.0F, 11.0F, 11.0F, small ? 4.0F : 3.0F), Direction.EAST, small -> Block.box(small ? 12.0F : 13.0F, 5.0F, 5.0F, 16.0F, 11.0F, 11.0F), Direction.SOUTH, small -> Block.box(5.0F, 5.0F, small ? 12.0F : 13.0F, 11.0F, 11.0F, 16.0F), Direction.WEST, small -> Block.box(0.0F, 5.0F, 5.0F, small ? 4.0F : 3.0F, 11.0F, 11.0F));

    public ZamitesLogBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(SIZE, 2).setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
    }

    public boolean connectsTo(BlockState blockState) {
        return blockState.is(FABlocks.ZAMITES_BRANCH.get()) && blockState.getValue(ZamitesBranchBlock.PART) == 1;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        BlockState northBlockState = level.getBlockState(blockPos.north());
        BlockState eastBlockState = level.getBlockState(blockPos.east());
        BlockState southBlockState = level.getBlockState(blockPos.south());
        BlockState westBlockState = level.getBlockState(blockPos.west());
        return super.getStateForPlacement(blockPlaceContext).setValue(NORTH, this.connectsTo(northBlockState)).setValue(EAST, this.connectsTo(eastBlockState)).setValue(SOUTH, this.connectsTo(southBlockState)).setValue(WEST, this.connectsTo(westBlockState));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        VoxelShape voxelShape = blockState.getValue(SIZE) == 2 ? SHAPE_2 : SHAPE_1;
        boolean small = blockState.getValue(SIZE) == 1;
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (blockState.getValue(PROPERTY_BY_DIRECTION.get(direction))) {
                voxelShape = Shapes.join(voxelShape, BRANCHES.get(direction).apply(small), BooleanOp.OR);
            }
        }
        return voxelShape;
    }

    @Override
    protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getBlockState(blockPos.below()).is(this) || levelReader.getBlockState(blockPos.below()).is(FABlockTags.ZAMITES_PLANTABLE_ON);
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighbourBlockPos, BlockState neighbourBlockState, RandomSource randomSource) {
        return !blockState.canSurvive(levelReader, blockPos) ? Blocks.AIR.defaultBlockState() : direction.getAxis().isHorizontal() ? blockState.setValue(PROPERTY_BY_DIRECTION.get(direction), this.connectsTo(neighbourBlockState)) : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighbourBlockPos, neighbourBlockState, randomSource);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SIZE, NORTH, EAST, SOUTH, WEST);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }
}