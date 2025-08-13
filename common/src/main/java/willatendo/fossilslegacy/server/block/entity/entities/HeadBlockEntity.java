package willatendo.fossilslegacy.server.block.entity.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;

public class HeadBlockEntity extends BlockEntity {
    public HeadBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FABlockEntityTypes.HEAD.get(), blockPos, blockState);
    }
}
