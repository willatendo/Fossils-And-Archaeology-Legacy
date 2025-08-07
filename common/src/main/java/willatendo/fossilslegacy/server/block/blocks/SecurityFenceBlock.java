package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public abstract class SecurityFenceBlock extends Block implements SimpleWaterloggedBlock {
    public static final EnumProperty<SecurityFenceBlock.Layer> LAYER = EnumProperty.create("layer", SecurityFenceBlock.Layer.class);
    public static final EnumProperty<SecurityFenceBlock.Side> NORTH = EnumProperty.create("north", SecurityFenceBlock.Side.class);
    public static final EnumProperty<SecurityFenceBlock.Side> EAST = EnumProperty.create("east", SecurityFenceBlock.Side.class);
    public static final EnumProperty<SecurityFenceBlock.Side> SOUTH = EnumProperty.create("south", SecurityFenceBlock.Side.class);
    public static final EnumProperty<SecurityFenceBlock.Side> WEST = EnumProperty.create("west", SecurityFenceBlock.Side.class);
    public static final BooleanProperty POST = BooleanProperty.create("post");
    public static final BooleanProperty FORCE_POST = BooleanProperty.create("force_post");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final Map<Direction, EnumProperty<SecurityFenceBlock.Side>> PROPERTY_BY_DIRECTION = Map.of(Direction.NORTH, NORTH, Direction.EAST, EAST, Direction.SOUTH, SOUTH, Direction.WEST, WEST);
    private static final Map<SecurityFenceBlock.Layer, SecurityFenceBlock.Side> LAYER_TO_SIDE = Map.of(SecurityFenceBlock.Layer.FOUNDATION, SecurityFenceBlock.Side.FOUNDATION, SecurityFenceBlock.Layer.BOTTOM, SecurityFenceBlock.Side.BOTTOM, SecurityFenceBlock.Layer.MIDDLE, SecurityFenceBlock.Side.MIDDLE, SecurityFenceBlock.Layer.TOP, SecurityFenceBlock.Side.TOP);

    public SecurityFenceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(LAYER, SecurityFenceBlock.Layer.BOTTOM).setValue(NORTH, SecurityFenceBlock.Side.NONE).setValue(EAST, SecurityFenceBlock.Side.NONE).setValue(SOUTH, SecurityFenceBlock.Side.NONE).setValue(WEST, SecurityFenceBlock.Side.NONE).setValue(POST, true).setValue(FORCE_POST, false).setValue(WATERLOGGED, false));
    }

    protected VoxelShape createVoxelShapes(BlockState blockState, int barThickness, int postThickness, int bottomThickness, int bottomHeight) {
        VoxelShape middlePost = Block.box(8.0F - (float) postThickness / 2, 0.0F, 8.0F - (float) postThickness / 2, 8.0F + (float) postThickness / 2, 16.0F, 8.0F + (float) postThickness / 2);
        VoxelShape bottomPost = Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 8.0F - (float) bottomThickness / 2, 8.0F + (float) bottomThickness / 2, bottomHeight, 8.0F + (float) bottomThickness / 2);
        VoxelShape foundationPost = Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 8.0F - (float) bottomThickness / 2, 8.0F + (float) bottomThickness / 2, 16.0F, 8.0F + (float) bottomThickness / 2);
        boolean top = blockState.getValue(LAYER) == SecurityFenceBlock.Layer.TOP;
        boolean middle = blockState.getValue(LAYER) == SecurityFenceBlock.Layer.MIDDLE;
        boolean bottom = blockState.getValue(LAYER) == SecurityFenceBlock.Layer.BOTTOM;
        VoxelShape postShape = (top || middle) ? middlePost : bottom ? Shapes.join(bottomPost, Block.box(8.0F - (float) postThickness / 2, bottomHeight, 8.0F - (float) postThickness / 2, 8.0F + (float) postThickness / 2, 16.0F, 8.0F + (float) postThickness / 2), BooleanOp.OR) : foundationPost;
        boolean north = blockState.getValue(NORTH) != SecurityFenceBlock.Side.NONE;
        VoxelShape topNorth = Block.box(8.0F - (float) barThickness / 2, 0.0F, 0.0F, 8.0F + (float) barThickness / 2, 8.0F, 8.0F - (float) postThickness / 2);
        VoxelShape middleNorth = Block.box(8.0F - (float) barThickness / 2, 0.0F, 0.0F, 8.0F + (float) barThickness / 2, 16.0F, 8.0F - (float) postThickness / 2);
        VoxelShape bottomNorth = Shapes.join(Block.box(8.0F - (float) barThickness / 2, bottomHeight, 0.0F, 8.0F + (float) barThickness / 2, 16.0F, 8.0F - (float) postThickness / 2), Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 0.0F, 8.0F + (float) bottomThickness / 2, bottomHeight, 8.0F - (float) bottomThickness / 2), BooleanOp.OR);
        VoxelShape foundationNorth = Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 0.0F, 8.0F + (float) bottomThickness / 2, 16.0F, 8.0F - (float) bottomThickness / 2);
        VoxelShape northShape = top ? topNorth : middle ? middleNorth : bottom ? bottomNorth : foundationNorth;
        boolean east = blockState.getValue(EAST) != SecurityFenceBlock.Side.NONE;
        VoxelShape topEast = Block.box(8.0F + (float) postThickness / 2, 0.0F, 8.0F - (float) barThickness / 2, 16.0F, 8.0F, 8.0F + (float) barThickness / 2);
        VoxelShape middleEast = Block.box(8.0F + (float) postThickness / 2, 0.0F, 8.0F - (float) barThickness / 2, 16.0F, 16.0F, 8.0F + (float) barThickness / 2);
        VoxelShape bottomEast = Shapes.join(Block.box(8.0F + (float) postThickness / 2, bottomHeight, 8.0F - (float) barThickness / 2, 16.0F, 16.0F, 8.0F + (float) barThickness / 2), Block.box(8.0F + (float) bottomThickness / 2, 0.0F, 8.0F - (float) bottomThickness / 2, 16.0F, bottomHeight, 8.0F + (float) bottomThickness / 2), BooleanOp.OR);
        VoxelShape foundationEast = Block.box(8.0F + (float) bottomThickness / 2, 0.0F, 8.0F - (float) bottomThickness / 2, 16.0F, 16.0F, 8.0F + (float) bottomThickness / 2);
        VoxelShape eastShape = top ? topEast : middle ? middleEast : bottom ? bottomEast : foundationEast;
        boolean south = blockState.getValue(SOUTH) != SecurityFenceBlock.Side.NONE;
        VoxelShape topSouth = Block.box(8.0F - (float) barThickness / 2, 0.0F, 8.0F + (float) postThickness / 2, 8.0F + (float) barThickness / 2, 8.0F, 16.0F);
        VoxelShape middleSouth = Block.box(8.0F - (float) barThickness / 2, 0.0F, 8.0F + (float) postThickness / 2, 8.0F + (float) barThickness / 2, 16.0F, 16.0F);
        VoxelShape bottomSouth = Shapes.join(Block.box(8.0F - (float) barThickness / 2, bottomHeight, 8.0F + (float) postThickness / 2, 8.0F + (float) barThickness / 2, 16.0F, 16.0F), Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 8.0F + (float) bottomThickness / 2, 8.0F + (float) bottomThickness / 2, bottomHeight, 16.0F), BooleanOp.OR);
        VoxelShape foundationSouth = Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 8.0F + (float) bottomThickness / 2, 8.0F + (float) bottomThickness / 2, 16.0F, 16.0F);
        VoxelShape southShape = top ? topSouth : middle ? middleSouth : bottom ? bottomSouth : foundationSouth;
        boolean west = blockState.getValue(WEST) != SecurityFenceBlock.Side.NONE;
        VoxelShape topWest = Block.box(0.0F, 0.0F, 8.0F - (float) barThickness / 2, 8.0F - (float) postThickness / 2, 8.0F, 8.0F + (float) barThickness / 2);
        VoxelShape middleWest = Block.box(0.0F, 0.0F, 8.0F - (float) barThickness / 2, 8.0F - (float) postThickness / 2, 16.0F, 8.0F + (float) barThickness / 2);
        VoxelShape bottomWest = Shapes.join(Block.box(0.0F, bottomHeight, 8.0F - (float) barThickness / 2, 8.0F - (float) postThickness / 2, 16.0F, 8.0F + (float) barThickness / 2), Block.box(0.0F, 0.0F, 8.0F - (float) bottomThickness / 2, 8.0F - (float) bottomThickness / 2, bottomHeight, 8.0F + (float) bottomThickness / 2), BooleanOp.OR);
        VoxelShape foundationWest = Block.box(0.0F, 0.0F, 8.0F - (float) bottomThickness / 2, 8.0F - (float) bottomThickness / 2, 16.0F, 8.0F + (float) bottomThickness / 2);
        VoxelShape westShape = top ? topWest : middle ? middleWest : bottom ? bottomWest : foundationWest;

        VoxelShape northSouth = Shapes.join(northShape, southShape, BooleanOp.OR);
        VoxelShape eastWest = Shapes.join(eastShape, westShape, BooleanOp.OR);
        VoxelShape foundationCenter = Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 8.0F - (float) bottomThickness / 2, 8.0F + (float) bottomThickness / 2, 16.0F, 8.0F + (float) bottomThickness / 2);
        VoxelShape topNorthSouthCenter = Block.box(8.0F - (float) barThickness / 2, 0.0F, 8.0F - (float) postThickness / 2, 8.0F + (float) barThickness / 2, 8.0F, 8.0F + (float) postThickness / 2);
        VoxelShape middleNorthSouthCenter = Block.box(8.0F - (float) barThickness / 2, 0.0F, 8.0F - (float) postThickness / 2, 8.0F + (float) barThickness / 2, 16.0F, 8.0F + (float) postThickness / 2);
        VoxelShape bottomNorthSouthCenter = Shapes.join(Block.box(8.0F - (float) barThickness / 2, bottomHeight, 8.0F - (float) postThickness / 2, 8.0F + (float) barThickness / 2, 16.0F, 8.0F + (float) postThickness / 2), Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 8.0F - (float) bottomThickness / 2, 8.0F + (float) bottomThickness / 2, bottomHeight, 8.0F + (float) bottomThickness / 2), BooleanOp.OR);
        VoxelShape northSouthCenter = top ? topNorthSouthCenter : middle ? middleNorthSouthCenter : bottom ? bottomNorthSouthCenter : foundationCenter;
        VoxelShape topEastWestCenter = Block.box(8.0F - (float) postThickness / 2, 0.0F, 8.0F - (float) barThickness / 2, 8.0F + (float) postThickness / 2, 8.0F, 8.0F + (float) barThickness / 2);
        VoxelShape middleEastWestCenter = Block.box(8.0F - (float) postThickness / 2, 0.0F, 8.0F - (float) barThickness / 2, 8.0F + (float) postThickness / 2, 16.0F, 8.0F + (float) barThickness / 2);
        VoxelShape bottomEastWestCenter = Shapes.join(Block.box(8.0F - (float) postThickness / 2, bottomHeight, 8.0F - (float) barThickness / 2, 8.0F + (float) postThickness / 2, 16.0F, 8.0F + (float) barThickness / 2), Block.box(8.0F - (float) bottomThickness / 2, 0.0F, 8.0F - (float) bottomThickness / 2, 8.0F + (float) bottomThickness / 2, bottomHeight, 8.0F + (float) bottomThickness / 2), BooleanOp.OR);
        VoxelShape eastWestCenter = top ? topEastWestCenter : middle ? middleEastWestCenter : bottom ? bottomEastWestCenter : foundationCenter;

        if ((north && south) && !(east || west)) {
            return Shapes.join(northSouth, northSouthCenter, BooleanOp.OR);
        }
        if (!(north || south) && (east && west)) {
            return Shapes.join(eastWest, eastWestCenter, BooleanOp.OR);
        }

        if (!north && !south && !east && !west) {
            return postShape;
        }

        if (north && south && east & west) {
            return Shapes.join(Shapes.join(Shapes.join(northShape, eastShape, BooleanOp.OR), Shapes.join(southShape, westShape, BooleanOp.OR), BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (north && !east && !south && !west) {
            return Shapes.join(northShape, postShape, BooleanOp.OR);
        }

        if (!north && east && !south && !west) {
            return Shapes.join(eastShape, postShape, BooleanOp.OR);
        }

        if (!north && !east && south && !west) {
            return Shapes.join(southShape, postShape, BooleanOp.OR);
        }

        if (!north && !east && !south && west) {
            return Shapes.join(westShape, postShape, BooleanOp.OR);
        }

        if (north && east && !south && !west) {
            return Shapes.join(Shapes.join(northShape, eastShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (!north && east && south && !west) {
            return Shapes.join(Shapes.join(eastShape, southShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (!north && !east && south && west) {
            return Shapes.join(Shapes.join(southShape, westShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (north && !east && !south && west) {
            return Shapes.join(Shapes.join(westShape, northShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (north && east && south && !west) {
            return Shapes.join(Shapes.join(Shapes.join(northShape, eastShape, BooleanOp.OR), southShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (!north && east && south && west) {
            return Shapes.join(Shapes.join(Shapes.join(eastShape, southShape, BooleanOp.OR), westShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (north && !east && south && west) {
            return Shapes.join(Shapes.join(Shapes.join(southShape, westShape, BooleanOp.OR), northShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        if (north && east && !south && west) {
            return Shapes.join(Shapes.join(Shapes.join(westShape, northShape, BooleanOp.OR), eastShape, BooleanOp.OR), postShape, BooleanOp.OR);
        }

        return Shapes.block();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        BlockState returningBlockState = super.getStateForPlacement(blockPlaceContext);
        BlockState belowBlockState = level.getBlockState(blockPos.below());
        if (belowBlockState.is(this) && (belowBlockState.getValue(LAYER) == SecurityFenceBlock.Layer.BOTTOM || belowBlockState.getValue(LAYER) == SecurityFenceBlock.Layer.TOP || belowBlockState.getValue(LAYER) == Layer.MIDDLE)) {
            returningBlockState = returningBlockState.setValue(LAYER, SecurityFenceBlock.Layer.TOP);
        }
        if (level.getBlockState(blockPos.above()).is(this) && (level.getBlockState(blockPos.above()).getValue(LAYER) == Layer.BOTTOM || level.getBlockState(blockPos.above()).getValue(LAYER) == Layer.FOUNDATION)) {
            returningBlockState = returningBlockState.setValue(LAYER, SecurityFenceBlock.Layer.FOUNDATION);
        }
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            SecurityFenceBlock.Side side = this.connects(returningBlockState, level.getBlockState(blockPos.relative(direction)), level, blockPos, direction);
            returningBlockState = returningBlockState.setValue(PROPERTY_BY_DIRECTION.get(direction), side);
        }
        returningBlockState = returningBlockState.setValue(POST, this.shouldPost(returningBlockState, level.getBlockState(blockPos.above())));
        return returningBlockState;
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos neighborBlockPos, BlockState neighborBlockState, RandomSource randomSource) {
        if (blockState.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
        }

        BlockState returningBlockState = super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, neighborBlockPos, neighborBlockState, randomSource);
        if (direction == Direction.UP) {
            if (neighborBlockState.is(this) && neighborBlockState.getValue(LAYER) == SecurityFenceBlock.Layer.TOP && blockState.getValue(LAYER) == SecurityFenceBlock.Layer.TOP) {
                returningBlockState = returningBlockState.setValue(LAYER, Layer.MIDDLE);
            }
            returningBlockState = returningBlockState.setValue(POST, this.shouldPost(blockState, neighborBlockState));
        }
        if (direction.getAxis().isHorizontal()) {
            returningBlockState = returningBlockState.setValue(PROPERTY_BY_DIRECTION.get(direction), this.connects(blockState, neighborBlockState, levelReader, blockPos, direction));
            returningBlockState = returningBlockState.setValue(POST, this.shouldPost(blockState, levelReader.getBlockState(blockPos.above())));
        }
        return returningBlockState;
    }

    private SecurityFenceBlock.Side connects(BlockState blockState, BlockState checkingBlockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        boolean checkingBlockIsThis = checkingBlockState.is(this);
        SecurityFenceBlock.Layer layer = blockState.getValue(LAYER);
        if (layer == SecurityFenceBlock.Layer.FOUNDATION) {
            if (checkingBlockIsThis) {
                SecurityFenceBlock.Layer checkingLayer = checkingBlockState.getValue(LAYER);
                return this.moreImportant(layer, checkingLayer) ? LAYER_TO_SIDE.get(layer) : LAYER_TO_SIDE.get(checkingLayer);
            }
            return !Block.isExceptionForConnection(checkingBlockState) && checkingBlockState.isFaceSturdy(blockGetter, blockPos, direction.getOpposite()) ? SecurityFenceBlock.Side.FOUNDATION : SecurityFenceBlock.Side.NONE;
        } else {
            if (checkingBlockIsThis) {
                SecurityFenceBlock.Layer checkingLayer = checkingBlockState.getValue(LAYER);
                return this.moreImportant(layer, checkingLayer) ? LAYER_TO_SIDE.get(layer) : LAYER_TO_SIDE.get(checkingLayer);
            }
            return SecurityFenceBlock.Side.NONE;
        }
    }

    private boolean moreImportant(SecurityFenceBlock.Layer layer, SecurityFenceBlock.Layer checkingLayer) {
        return layer == SecurityFenceBlock.Layer.TOP && checkingLayer != SecurityFenceBlock.Layer.TOP || layer == SecurityFenceBlock.Layer.MIDDLE && (checkingLayer == SecurityFenceBlock.Layer.BOTTOM || checkingLayer == SecurityFenceBlock.Layer.FOUNDATION) || layer == SecurityFenceBlock.Layer.BOTTOM && checkingLayer == SecurityFenceBlock.Layer.FOUNDATION;
    }

    private boolean shouldPost(BlockState blockstate, BlockState neighborBlockState) {
        boolean flag = neighborBlockState.getBlock() instanceof SecurityFenceBlock && neighborBlockState.getValue(POST);
        if (flag) {
            return true;
        } else {
            boolean south = blockstate.getValue(SOUTH) == SecurityFenceBlock.Side.NONE;
            boolean west = blockstate.getValue(WEST) == SecurityFenceBlock.Side.NONE;
            boolean east = blockstate.getValue(EAST) == SecurityFenceBlock.Side.NONE;
            boolean north = blockstate.getValue(NORTH) == SecurityFenceBlock.Side.NONE;
            return north && south && west && east || north != south || west != east;
        }
    }

    @Override
    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState blockState) {
        return !(Boolean) blockState.getValue(WATERLOGGED);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYER, NORTH, EAST, SOUTH, WEST, POST, FORCE_POST, WATERLOGGED);
    }

    public enum Side implements StringRepresentable {
        NONE("none"),
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom"),
        FOUNDATION("foundation");

        private final String name;

        Side(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

    public enum Layer implements StringRepresentable {
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom"),
        FOUNDATION("foundation");

        private final String name;

        Layer(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}
