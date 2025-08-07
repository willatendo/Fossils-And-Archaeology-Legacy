package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.BiFunction;

public class CooksoniaBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<CooksoniaBlock> CODEC = Block.simpleCodec(CooksoniaBlock::new);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty AMOUNT = BlockStateProperties.FLOWER_AMOUNT;
    private static final BiFunction<Direction, Integer, VoxelShape> SHAPE_BY_PROPERTIES = Util.memoize((direction, amount) -> {
        VoxelShape[] voxelShapes = new VoxelShape[]{Block.box(8.0, 0.0, 8.0, 16.0, 3.0, 16.0), Block.box(8.0, 0.0, 0.0, 16.0, 3.0, 8.0), Block.box(0.0, 0.0, 0.0, 8.0, 3.0, 8.0), Block.box(0.0, 0.0, 8.0, 8.0, 3.0, 16.0)};
        VoxelShape voxelShape = Shapes.empty();

        for (int i = 0; i < amount; ++i) {
            int j = Math.floorMod(i - direction.get2DDataValue(), 4);
            voxelShape = Shapes.or(voxelShape, voxelShapes[j]);
        }

        return voxelShape.singleEncompassing();
    });

    public CooksoniaBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(AMOUNT, 1));
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
        return !blockPlaceContext.isSecondaryUseActive() && blockPlaceContext.getItemInHand().is(this.asItem()) && blockState.getValue(AMOUNT) < 4 ? true : super.canBeReplaced(blockState, blockPlaceContext);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE_BY_PROPERTIES.apply(blockState.getValue(HORIZONTAL_FACING), blockState.getValue(AMOUNT));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockState = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        return blockState.is(this) ? blockState.setValue(AMOUNT, Math.min(4, blockState.getValue(AMOUNT) + 1)) : this.defaultBlockState().setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
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
        if (amount < 4) {
            serverLevel.setBlock(blockPos, blockState.setValue(AMOUNT, amount + 1), 2);
        } else {
            Block.popResource(serverLevel, blockPos, new ItemStack(this));
        }
    }

    @Override
    public MapCodec<CooksoniaBlock> codec() {
        return CODEC;
    }
}
