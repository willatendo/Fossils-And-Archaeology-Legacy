package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import willatendo.fossilslegacy.server.block.entity.entities.FossilsHangingSignBlockEntity;

public class FossilsWallHangingSignBlock extends WallHangingSignBlock {
    public FossilsWallHangingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FossilsHangingSignBlockEntity(blockPos, blockState);
    }
}
