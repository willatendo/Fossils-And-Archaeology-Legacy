package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import willatendo.fossilslegacy.server.block.entity.entities.FossilsSignBlockEntity;

public class FossilsStandingSignBlock extends StandingSignBlock {
    public FossilsStandingSignBlock(WoodType woodType, Properties properties) {
        super(woodType, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FossilsSignBlockEntity(blockPos, blockState);
    }
}
