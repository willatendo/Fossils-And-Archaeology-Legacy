package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FossilsHangingSignBlockEntity extends HangingSignBlockEntity {
    public FossilsHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FossilsLegacyBlockEntityTypes.FOSSILS_HANGING_SIGN.get();
    }
}
