package willatendo.fossilslegacy.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import willatendo.fossilslegacy.server.block.entity.FossilsHangingSignBlockEntity;

public class FossilsCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public FossilsCeilingHangingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FossilsHangingSignBlockEntity(blockPos, blockState);
    }
}
