package willatendo.fossilslegacy.server.block.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HardenedTarBlock extends HalfTransparentBlock {
    public static final MapCodec<HardenedTarBlock> CODEC = Block.simpleCodec(HardenedTarBlock::new);
    public static final VoxelShape SHORT_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0F, 14.0F, 16.0F);
    public static final BooleanProperty SHORT = BooleanProperty.create("short");

    public HardenedTarBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(SHORT, false));
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return blockState.getValue(SHORT) ? SHORT_SHAPE : super.getShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockState = super.getStateForPlacement(blockPlaceContext);
        if (blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().above()).isAir()) {
            blockState = blockState.setValue(SHORT, false);
        } else {
            blockState = blockState.setValue(SHORT, true);
        }
        return blockState;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHORT);
    }

    @Override
    protected MapCodec<? extends HalfTransparentBlock> codec() {
        return CODEC;
    }
}
