package willatendo.fossilslegacy.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import willatendo.fossilslegacy.server.entity.variants.FossilVariant;

public class PalaeontologyTableBlockEntity extends BlockEntity {
    private Holder<FossilVariant> display;

    public PalaeontologyTableBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FossilsLegacyBlockEntityTypes.PALEONTOLOGY_TABLE.get(), blockPos, blockState);
    }

    public void setDisplay(Holder<FossilVariant> display) {
        this.display = display;
    }

    public Holder<FossilVariant> getDisplay() {
        return this.display;
    }
}
