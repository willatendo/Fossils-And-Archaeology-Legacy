package willatendo.fossilslegacy.server.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import willatendo.fossilslegacy.server.block.entity.ArchaeologyWorkbenchBlockEntity;
import willatendo.fossilslegacy.server.block.entity.BlockEntityHelper;
import willatendo.fossilslegacy.server.block.entity.FossilsLegacyBlockEntityTypes;
import willatendo.fossilslegacy.server.block.entity.PalaeontologyTableBlockEntity;
import willatendo.simplelibrary.server.util.SimpleUtils;

public class PalaeontologyTableBlock extends Block implements EntityBlock {
    public PalaeontologyTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int a, int b) {
        super.triggerEvent(blockState, level, blockPos, a, b);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity == null ? false : blockEntity.triggerEvent(a, b);
    }

    @Override
    public void onRemove(BlockState blockState, Level level, BlockPos blockPos, BlockState newBlockState, boolean flag) {
        if (!blockState.is(newBlockState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof PalaeontologyTableBlockEntity palaeontologyTableBlockEntity) {
                if (level instanceof ServerLevel) {
                    Containers.dropContents(level, blockPos, palaeontologyTableBlockEntity);
                }
                level.updateNeighbourForOutputSignal(blockPos, this);
            }

            super.onRemove(blockState, level, blockPos, newBlockState, flag);
        }
    }

    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity instanceof MenuProvider ? (MenuProvider) blockEntity : null;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof PalaeontologyTableBlockEntity && player instanceof ServerPlayer serverPlayer) {
                SimpleUtils.openContainer(blockEntity, blockPos, serverPlayer);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : BlockEntityHelper.createTickerHelper(blockEntityType, FossilsLegacyBlockEntityTypes.PALEONTOLOGY_TABLE.get(), PalaeontologyTableBlockEntity::serverTick);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PalaeontologyTableBlockEntity(blockPos, blockState);
    }
}
