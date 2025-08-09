package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class DipterisBlock extends BushBlock {
    public static final MapCodec<DipterisBlock> CODEC = Block.simpleCodec(DipterisBlock::new);
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public DipterisBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return super.getStateForPlacement(blockPlaceContext).setValue(HORIZONTAL_FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
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
        super.createBlockStateDefinition(builder.add(HORIZONTAL_FACING));
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }
}
