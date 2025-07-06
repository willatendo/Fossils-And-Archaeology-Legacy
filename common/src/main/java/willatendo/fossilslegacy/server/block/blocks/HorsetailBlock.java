package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import willatendo.fossilslegacy.server.block.FABlocks;

public class HorsetailBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<HorsetailBlock> CODEC = Block.simpleCodec(HorsetailBlock::new);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty AMOUNT = IntegerProperty.create("amount", 1, 3);
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public HorsetailBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(AMOUNT, 1));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
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
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return !blockPlaceContext.isSecondaryUseActive() && blockPlaceContext.getItemInHand().is(this.asItem()) && blockState.getValue(AMOUNT) < 3 ? true : super.canBeReplaced(blockState, blockPlaceContext);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        return blockState.is(this) ? blockState.setValue(AMOUNT, Math.min(3, blockState.getValue(AMOUNT) + 1)) : this.defaultBlockState().setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, AMOUNT);
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
        if (amount < 3) {
            serverLevel.setBlock(blockPos, blockState.setValue(AMOUNT, amount + 1), 2);
        } else {
            BlockPos aboveBlockPos = blockPos.above();
            if (serverLevel.getBlockState(aboveBlockPos).isAir() && aboveBlockPos.getY() < serverLevel.getMaxY()) {
                serverLevel.setBlock(blockPos, FABlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.LOWER), 2);
                serverLevel.setBlock(blockPos.above(), FABlocks.TALL_HORSETAIL.get().defaultBlockState().setValue(TallHorsetailBlock.HALF, DoubleBlockHalf.UPPER), 2);
            } else {
                Block.popResource(serverLevel, blockPos, new ItemStack(this));
            }
        }
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return HorsetailBlock.CODEC;
    }
}
