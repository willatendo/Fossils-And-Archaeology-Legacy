package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FossilsSignBlockEntity extends SignBlockEntity {
    public FossilsSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return FossilsLegacyBlockEntityTypes.FOSSILS_SIGN.get();
    }
}
