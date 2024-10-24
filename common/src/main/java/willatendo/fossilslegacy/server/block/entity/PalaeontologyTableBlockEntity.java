package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PalaeontologyTableBlockEntity extends BlockEntity {
    public PalaeontologyTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FossilsLegacyBlockEntityTypes.PALEONTOLOGY_TABLE.get(), blockPos, blockState);
    }
}
