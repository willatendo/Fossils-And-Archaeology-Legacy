package willatendo.pridelands.server.block.blocks;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.pridelands.server.particles.PridelandsParticles;
import willatendo.pridelands.server.utils.PridelandsUtils;

import java.util.Optional;

public class PridelandsPortalBlock extends Block implements Portal {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_SHAPE = Block.box(0.0F, 0.0F, 6.0F, 16.0F, 16.0F, 10.0F);
    protected static final VoxelShape Z_AXIS_SHAPE = Block.box(6.0F, 0.0F, 0.0F, 10.0F, 16.0F, 16.0F);

    public PridelandsPortalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return blockState.getValue(AXIS) == Direction.Axis.Z ? Z_AXIS_SHAPE : X_AXIS_SHAPE;
    }

    @Override
    protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos newBlockPos, BlockState newBlockState, RandomSource randomSource) {
        Direction.Axis directionAxis = direction.getAxis();
        Direction.Axis axis = blockState.getValue(AXIS);
        boolean flag = axis != directionAxis && directionAxis.isHorizontal();
        return !flag && !newBlockState.is(this) && !PortalShape.findAnyShape(levelReader, blockPos, axis).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, newBlockPos, newBlockState, randomSource);
    }

    @Override
    protected void entityInside(BlockState blockState, Level level, BlockPos pos, Entity entity) {
        if (entity.canUsePortal(false)) {
            entity.setAsInsidePortal(this, pos);
        }
    }

    @Override
    public int getPortalTransitionTime(ServerLevel serverLevel, Entity entity) {
        int time;
        if (entity instanceof Player player) {
            time = Math.max(0, serverLevel.getGameRules().getInt(player.getAbilities().invulnerable ? GameRules.RULE_PLAYERS_NETHER_PORTAL_CREATIVE_DELAY : GameRules.RULE_PLAYERS_NETHER_PORTAL_DEFAULT_DELAY));
        } else {
            time = 0;
        }

        return time;
    }

    @Override
    public TeleportTransition getPortalDestination(ServerLevel serverLevel, Entity entity, BlockPos blockPos) {
        ResourceKey<Level> levelResourceKey = serverLevel.dimension() == Level.NETHER ? Level.OVERWORLD : Level.NETHER;
        ServerLevel destinationServerLevel = serverLevel.getServer().getLevel(levelResourceKey);
        if (destinationServerLevel == null) {
            return null;
        } else {
            boolean isNether = destinationServerLevel.dimension() == Level.NETHER;
            WorldBorder worldBorder = destinationServerLevel.getWorldBorder();
            double teleportationScale = DimensionType.getTeleportationScale(serverLevel.dimensionType(), destinationServerLevel.dimensionType());
            BlockPos exitBlockPos = worldBorder.clampToBounds(entity.getX() * teleportationScale, entity.getY(), entity.getZ() * teleportationScale);
            return this.getExitPortal(destinationServerLevel, entity, blockPos, exitBlockPos, isNether, worldBorder);
        }
    }

    private TeleportTransition getExitPortal(ServerLevel serverLevel, Entity entity, BlockPos blockPos, BlockPos exitBlockPos, boolean isNether, WorldBorder worldBorder) {
        Optional<BlockPos> portalPosition = serverLevel.getPortalForcer().findClosestPortalPosition(exitBlockPos, isNether, worldBorder);
        BlockUtil.FoundRectangle foundRectangle;
        TeleportTransition.PostTeleportTransition postTeleportTransition;
        if (portalPosition.isPresent()) {
            BlockPos portalBlockPos = portalPosition.get();
            BlockState portalBlockState = serverLevel.getBlockState(portalBlockPos);
            foundRectangle = BlockUtil.getLargestRectangleAround(portalBlockPos, portalBlockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, blockPosIn -> serverLevel.getBlockState(blockPosIn) == portalBlockState);
            postTeleportTransition = TeleportTransition.PLAY_PORTAL_SOUND.then(entityIn -> entityIn.placePortalTicket(portalBlockPos));
        } else {
            Direction.Axis axis = entity.level().getBlockState(blockPos).getOptionalValue(AXIS).orElse(Direction.Axis.X);
            Optional<BlockUtil.FoundRectangle> portal = serverLevel.getPortalForcer().createPortal(exitBlockPos, axis);
            if (portal.isEmpty()) {
                PridelandsUtils.LOGGER.error("Unable to create a portal, likely target out of worldborder");
                return null;
            }

            foundRectangle = portal.get();
            postTeleportTransition = TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET);
        }

        return PridelandsPortalBlock.getDimensionTransitionFromExit(entity, blockPos, foundRectangle, serverLevel, postTeleportTransition);
    }

    private static TeleportTransition getDimensionTransitionFromExit(Entity entity, BlockPos blockPos, BlockUtil.FoundRectangle foundRectangle, ServerLevel serverLevel, TeleportTransition.PostTeleportTransition postTeleportTransition) {
        BlockState blockState = entity.level().getBlockState(blockPos);
        Direction.Axis axis;
        Vec3 position;
        if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            BlockUtil.FoundRectangle relativeFoundRectangle = BlockUtil.getLargestRectangleAround(blockPos, axis, 21, Direction.Axis.Y, 21, (p_351016_) -> entity.level().getBlockState(p_351016_) == blockState);
            position = entity.getRelativePortalPosition(axis, relativeFoundRectangle);
        } else {
            axis = Direction.Axis.X;
            position = new Vec3(0.5, 0.0, 0.0);
        }

        return PridelandsPortalBlock.createDimensionTransition(serverLevel, foundRectangle, axis, position, entity, postTeleportTransition);
    }

    private static TeleportTransition createDimensionTransition(ServerLevel serverLevel, BlockUtil.FoundRectangle foundRectangle, Direction.Axis axis, Vec3 offset, Entity entity, TeleportTransition.PostTeleportTransition postTeleportTransition) {
        BlockPos blockPos = foundRectangle.minCorner;
        BlockState blockState = serverLevel.getBlockState(blockPos);
        EntityDimensions entitydimensions = entity.getDimensions(entity.getPose());
        double x = (double) entitydimensions.width() / 2.0 + (foundRectangle.axis1Size - (double) entitydimensions.width()) * offset.x();
        double y = (foundRectangle.axis2Size - (double) entitydimensions.height()) * offset.y();
        double z = 0.5 + offset.z();
        boolean flag = blockState.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X) == Direction.Axis.X;
        return new TeleportTransition(serverLevel, PortalShape.findCollisionFreePosition(new Vec3((double) blockPos.getX() + (flag ? x : z), (double) blockPos.getY() + y, (double) blockPos.getZ() + (flag ? z : x)), serverLevel, entity, entitydimensions), Vec3.ZERO, (float) (axis == blockState.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X) ? 0 : 90), 0.0F, Relative.union(Relative.DELTA, Relative.ROTATION), postTeleportTransition);
    }

    @Override
    public Portal.Transition getLocalTransition() {
        return Transition.CONFUSION;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(100) == 0) {
            level.playLocalSound((double) blockPos.getX() + 0.5, (double) blockPos.getY() + 0.5, (double) blockPos.getZ() + 0.5, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double x = (double) blockPos.getX() + randomSource.nextDouble();
            double y = (double) blockPos.getY() + randomSource.nextDouble();
            double z = (double) blockPos.getZ() + randomSource.nextDouble();
            double xSpeed = ((double) randomSource.nextFloat() - 0.5) * 0.5;
            double ySpeed = ((double) randomSource.nextFloat() - 0.5) * 0.5;
            double zSpeed = ((double) randomSource.nextFloat() - 0.5) * 0.5;
            int j = randomSource.nextInt(2) * 2 - 1;
            if (!level.getBlockState(blockPos.west()).is(this) && !level.getBlockState(blockPos.east()).is(this)) {
                x = (double) blockPos.getX() + 0.5 + 0.25 * (double) j;
                xSpeed = randomSource.nextFloat() * 2.0F * (float) j;
            } else {
                z = (double) blockPos.getZ() + 0.5 + 0.25 * (double) j;
                zSpeed = randomSource.nextFloat() * 2.0F * (float) j;
            }

            level.addParticle(PridelandsParticles.PRIDELANDS_PORTAL.get(), x, y, z, xSpeed, ySpeed, zSpeed);
        }
    }

    @Override
    protected ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState, boolean includeData) {
        return ItemStack.EMPTY;
    }

    @Override
    protected BlockState rotate(BlockState blockState, Rotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch (blockState.getValue(AXIS)) {
                    case Z -> {
                        return blockState.setValue(AXIS, Direction.Axis.X);
                    }
                    case X -> {
                        return blockState.setValue(AXIS, Direction.Axis.Z);
                    }
                    default -> {
                        return blockState;
                    }
                }
            default:
                return blockState;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }
}
