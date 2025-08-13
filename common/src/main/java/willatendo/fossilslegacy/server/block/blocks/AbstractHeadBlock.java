package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.redstone.Orientation;
import willatendo.fossilslegacy.server.block.entity.entities.HeadBlockEntity;
import willatendo.fossilslegacy.server.item.FAHeadTypes;

public abstract class AbstractHeadBlock extends Block implements EntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private final FAHeadTypes faHeadTypes;

    public AbstractHeadBlock(FAHeadTypes faHeadTypes, Properties properties) {
        super(properties);
        this.faHeadTypes = faHeadTypes;
        this.registerDefaultState(this.getStateDefinition().any().setValue(POWERED, false));
    }

    public FAHeadTypes getType() {
        return this.faHeadTypes;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new HeadBlockEntity(blockPos, blockState);
    }

    @Override
    protected boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int id, int param) {
        super.triggerEvent(blockState, level, blockPos, id, param);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity == null ? false : blockEntity.triggerEvent(id, param);
    }

    @Override
    protected boolean isPathfindable(BlockState blockState, PathComputationType pathComputationType) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(POWERED, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos()));
    }

    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block neighborBlock, Orientation orientation, boolean movedByPiston) {
        if (!level.isClientSide()) {
            boolean flag = level.hasNeighborSignal(blockPos);
            if (flag != blockState.getValue(POWERED)) {
                level.setBlock(blockPos, blockState.setValue(POWERED, flag), 2);
            }
        }
    }
}
