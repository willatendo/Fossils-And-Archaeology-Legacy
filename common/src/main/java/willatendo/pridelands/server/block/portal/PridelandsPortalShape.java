package willatendo.pridelands.server.block.portal;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.mutable.MutableInt;
import willatendo.pridelands.server.block.PridelandsBlocks;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Predicate;

public class PridelandsPortalShape {
    private static final BlockBehaviour.StatePredicate FRAME = (blockState, blockGetter, blockPos) -> blockState.is(PridelandsBlocks.PRIDELANDS_PORTAL_FRAME.get());
    private final Direction.Axis axis;
    private final Direction rightDir;
    private final int numPortalBlocks;
    private final BlockPos bottomLeft;
    private final int height;
    private final int width;

    private PridelandsPortalShape(Direction.Axis axis, int numPortalBlocks, Direction rightDir, BlockPos bottomLeft, int width, int height) {
        this.axis = axis;
        this.numPortalBlocks = numPortalBlocks;
        this.rightDir = rightDir;
        this.bottomLeft = bottomLeft;
        this.width = width;
        this.height = height;
    }

    public static Optional<PridelandsPortalShape> findEmptyPortalShape(LevelAccessor levelAccessor, BlockPos blockPos, Direction.Axis axis) {
        return PridelandsPortalShape.findPortalShape(levelAccessor, blockPos, pridelandsPortalShape -> pridelandsPortalShape.isValid() && pridelandsPortalShape.numPortalBlocks == 0, axis);
    }

    public static Optional<PridelandsPortalShape> findPortalShape(LevelAccessor level, BlockPos bottomLeft, Predicate<PridelandsPortalShape> predicate, Direction.Axis axis) {
        Optional<PridelandsPortalShape> optional = Optional.of(PridelandsPortalShape.findAnyShape(level, bottomLeft, axis)).filter(predicate);
        if (optional.isPresent()) {
            return optional;
        } else {
            Direction.Axis shapeAxis = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
            return Optional.of(PridelandsPortalShape.findAnyShape(level, bottomLeft, shapeAxis)).filter(predicate);
        }
    }

    public static PridelandsPortalShape findAnyShape(BlockGetter level, BlockPos bottomLeft, Direction.Axis axis) {
        Direction direction = axis == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
        BlockPos blockpos = PridelandsPortalShape.calculateBottomLeft(level, direction, bottomLeft);
        if (blockpos == null) {
            return new PridelandsPortalShape(axis, 0, direction, bottomLeft, 0, 0);
        } else {
            int width = PridelandsPortalShape.calculateWidth(level, blockpos, direction);
            if (width == 0) {
                return new PridelandsPortalShape(axis, 0, direction, blockpos, 0, 0);
            } else {
                MutableInt mutableInt = new MutableInt();
                int height = PridelandsPortalShape.calculateHeight(level, blockpos, direction, width, mutableInt);
                return new PridelandsPortalShape(axis, mutableInt.getValue(), direction, blockpos, width, height);
            }
        }
    }

    @Nullable
    private static BlockPos calculateBottomLeft(BlockGetter blockGetter, Direction direction, BlockPos blockPos) {
        for (int i = Math.max(blockGetter.getMinY(), blockPos.getY() - 21); blockPos.getY() > i && PridelandsPortalShape.isEmpty(blockGetter.getBlockState(blockPos.below())); blockPos = blockPos.below()) {
        }
        Direction oppositeDirection = direction.getOpposite();
        int distance = PridelandsPortalShape.getDistanceUntilEdgeAboveFrame(blockGetter, blockPos, oppositeDirection) - 1;
        return distance < 0 ? null : blockPos.relative(oppositeDirection, distance);
    }

    private static int calculateWidth(BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        int distance = PridelandsPortalShape.getDistanceUntilEdgeAboveFrame(blockGetter, blockPos, direction);
        return distance >= 2 && distance <= 21 ? distance : 0;
    }

    private static int getDistanceUntilEdgeAboveFrame(BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();

        for (int i = 0; i <= 21; ++i) {
            mutableBlockPos.set(blockPos).move(direction, i);
            BlockState blockstate = blockGetter.getBlockState(mutableBlockPos);
            if (!PridelandsPortalShape.isEmpty(blockstate)) {
                if (FRAME.test(blockstate, blockGetter, mutableBlockPos)) {
                    return i;
                }
                break;
            }

            BlockState blockState = blockGetter.getBlockState(mutableBlockPos.move(Direction.DOWN));
            if (!FRAME.test(blockState, blockGetter, mutableBlockPos)) {
                break;
            }
        }

        return 0;
    }

    private static int calculateHeight(BlockGetter blockGetter, BlockPos blockPos, Direction direction, int width, MutableInt portalBlocks) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int distance = PridelandsPortalShape.getDistanceUntilTop(blockGetter, blockPos, direction, mutableBlockPos, width, portalBlocks);
        return distance >= 3 && distance <= 21 && hasTopFrame(blockGetter, blockPos, direction, mutableBlockPos, width, distance) ? distance : 0;
    }

    private static boolean hasTopFrame(BlockGetter blockGetter, BlockPos blockPos, Direction direction, BlockPos.MutableBlockPos checkPos, int width, int distanceUntilTop) {
        for (int i = 0; i < width; ++i) {
            BlockPos.MutableBlockPos mutableBlockPos = checkPos.set(blockPos).move(Direction.UP, distanceUntilTop).move(direction, i);
            if (!FRAME.test(blockGetter.getBlockState(mutableBlockPos), blockGetter, mutableBlockPos)) {
                return false;
            }
        }

        return true;
    }

    private static int getDistanceUntilTop(BlockGetter blockGetter, BlockPos blockPos, Direction direction, BlockPos.MutableBlockPos checkPos, int width, MutableInt portalBlocks) {
        for (int i = 0; i < 21; ++i) {
            checkPos.set(blockPos).move(Direction.UP, i).move(direction, -1);
            if (!FRAME.test(blockGetter.getBlockState(checkPos), blockGetter, checkPos)) {
                return i;
            }

            checkPos.set(blockPos).move(Direction.UP, i).move(direction, width);
            if (!FRAME.test(blockGetter.getBlockState(checkPos), blockGetter, checkPos)) {
                return i;
            }

            for (int j = 0; j < width; ++j) {
                checkPos.set(blockPos).move(Direction.UP, i).move(direction, j);
                BlockState blockstate = blockGetter.getBlockState(checkPos);
                if (!PridelandsPortalShape.isEmpty(blockstate)) {
                    return i;
                }

                if (blockstate.is(PridelandsBlocks.PRIDELANDS_PORTAL.get())) {
                    portalBlocks.increment();
                }
            }
        }

        return 21;
    }

    private static boolean isEmpty(BlockState state) {
        return state.isAir() || state.is(PridelandsBlocks.PRIDELANDS_PORTAL.get());
    }

    public boolean isValid() {
        return this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
    }

    public void createPortalBlocks(LevelAccessor levelAccessor) {
        BlockState blockState = PridelandsBlocks.PRIDELANDS_PORTAL.get().defaultBlockState().setValue(NetherPortalBlock.AXIS, this.axis);
        BlockPos.betweenClosed(this.bottomLeft, this.bottomLeft.relative(Direction.UP, this.height - 1).relative(this.rightDir, this.width - 1)).forEach(blockPos -> levelAccessor.setBlock(blockPos, blockState, 18));
    }

    public boolean isComplete() {
        return this.isValid() && this.numPortalBlocks == this.width * this.height;
    }

    public static Vec3 getRelativePosition(BlockUtil.FoundRectangle foundRectangle, Direction.Axis axis, Vec3 pos, EntityDimensions entityDimensions) {
        double width = (double) foundRectangle.axis1Size - (double) entityDimensions.width();
        double height = (double) foundRectangle.axis2Size - (double) entityDimensions.height();
        BlockPos blockPos = foundRectangle.minCorner;
        double x;
        double y;
        if (width > 0.0) {
            y = (double) blockPos.get(axis) + (double) entityDimensions.width() / 2.0;
            x = Mth.clamp(Mth.inverseLerp(pos.get(axis) - y, 0.0, width), 0.0, 1.0);
        } else {
            x = 0.5;
        }

        Direction.Axis direction$axis1;
        if (height > 0.0) {
            direction$axis1 = Direction.Axis.Y;
            y = Mth.clamp(Mth.inverseLerp(pos.get(direction$axis1) - (double) blockPos.get(direction$axis1), 0.0, height), 0.0, 1.0);
        } else {
            y = 0.0;
        }

        direction$axis1 = axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X;
        double z = pos.get(direction$axis1) - ((double) blockPos.get(direction$axis1) + 0.5);
        return new Vec3(x, y, z);
    }

    public static Vec3 findCollisionFreePosition(Vec3 pos, ServerLevel serverLevel, Entity entity, EntityDimensions dimensions) {
        if (!(dimensions.width() > 4.0F) && !(dimensions.height() > 4.0F)) {
            double y = (double) dimensions.height() / 2.0;
            Vec3 vec3 = pos.add(0.0, y, 0.0);
            VoxelShape voxelshape = Shapes.create(AABB.ofSize(vec3, dimensions.width(), 0.0, dimensions.width()).expandTowards(0.0, 1.0, 0.0).inflate(1.0E-6));
            Optional<Vec3> freePosition = serverLevel.findFreePosition(entity, voxelshape, vec3, dimensions.width(), dimensions.height(), dimensions.width());
            Optional<Vec3> map = freePosition.map(posIn -> posIn.subtract(0.0, y, 0.0));
            return map.orElse(pos);
        } else {
            return pos;
        }
    }
}
