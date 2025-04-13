package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.block.entity.entities.CageBlockEntity;

public class CageBlock extends Block implements EntityBlock {
    public CageBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CageBlockEntity(blockPos, blockState);
    }
}
