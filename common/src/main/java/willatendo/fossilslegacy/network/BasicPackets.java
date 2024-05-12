package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.server.block.entity.TimeMachineBlockEntity;
import willatendo.fossilslegacy.server.entity.Futabasaurus;

public class BasicPackets {
    public static void serverboundTimeMachineUpdatePacket(BlockPos blockPos, boolean timeTravelling, Level level) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof TimeMachineBlockEntity timeMachineBlockEntity) {
            timeMachineBlockEntity.setTimeTravelling(timeTravelling);
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
