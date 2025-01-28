package willatendo.fossilslegacy.server.block.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import willatendo.fossilslegacy.server.block.entity.FABlockEntityTypes;
import willatendo.fossilslegacy.server.block.entity.entities.RawSoupBlockEntity;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class RawSoupCauldronBlock extends SoupCauldronBlock implements EntityBlock {
    public RawSoupCauldronBlock(CauldronInteraction.InteractionMap interactionMap, Properties properties) {
        super(interactionMap, properties);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : SimpleUtils.createTickerHelper(blockEntityType, FABlockEntityTypes.RAW_SOUP.get(), RawSoupBlockEntity::serverTick);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new RawSoupBlockEntity(blockPos, blockState);
    }
}
