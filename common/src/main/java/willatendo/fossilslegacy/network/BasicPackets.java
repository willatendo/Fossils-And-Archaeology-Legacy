package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.entity.Futabasaurus;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class BasicPackets {
    public static final ResourceLocation TIME_MACHINE_UPDATE = FossilsLegacyUtils.resource("time_machine_update");
    public static final ResourceLocation SINK = FossilsLegacyUtils.resource("sink");

    public static void serverboundTimeMachineUpdatePacket(BlockPos blockPos, Level level) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            timeMachineBlockEntity.timeTravel();
        }
    }

    public static void serverboundSinkPacket(ServerPlayer serverPlayer, boolean shouldSink) {
        Entity entity = serverPlayer.getControlledVehicle();
        if (entity != null) {
            if (entity instanceof Futabasaurus futabasaurus) {
                futabasaurus.setShouldSink(shouldSink);
            }
        }
    }
}
