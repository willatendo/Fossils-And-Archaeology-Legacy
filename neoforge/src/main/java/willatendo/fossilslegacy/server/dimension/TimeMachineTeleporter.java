package willatendo.fossilslegacy.server.dimension;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.portal.PortalInfo;
import net.neoforged.neoforge.common.util.ITeleporter;
import willatendo.fossilslegacy.server.block.FossilsLegacyBlocks;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.item.CoinItem;

import java.util.function.Function;

public class TimeMachineTeleporter implements ITeleporter {
    private final PortalInfo portalInfo;
    private final BlockPos timeMachineBlockPos;

    public TimeMachineTeleporter(PortalInfo portalInfo, BlockPos timeMachineBlockPos) {
        this.portalInfo = portalInfo;
        this.timeMachineBlockPos = timeMachineBlockPos;
    }

    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel destinationLevel, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
        if (!destinationLevel.getBlockState(this.timeMachineBlockPos).is(FossilsLegacyBlocks.TIME_MACHINE.get())) {
            destinationLevel.setBlock(this.timeMachineBlockPos, FossilsLegacyBlocks.TIME_MACHINE.get().defaultBlockState(), 3);
        }
        BlockEntity blockEntity = destinationLevel.getBlockEntity(this.timeMachineBlockPos);
        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            timeMachineBlockEntity.setItem(0, new ItemStack(CoinItem.ITEM_MAP.get(destinationLevel.dimension())));
        }
        return this.portalInfo;
    }

    @Override
    public Entity placeEntity(Entity newEntity, ServerLevel currentLevel, ServerLevel destinationLevel, float yaw, Function<Boolean, Entity> repositionEntity) {
        newEntity.fallDistance = 0;
        return repositionEntity.apply(false);
    }
}
