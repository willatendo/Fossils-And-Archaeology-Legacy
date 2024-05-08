package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public record ServerboundTimeMachineUpdatePacket(BlockPos blockPos,
                                                 boolean timeTravelling) implements CustomPacketPayload {
    @Override
    public void write(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos);
        friendlyByteBuf.writeBoolean(this.timeTravelling);
    }

    @Override
    public ResourceLocation id() {
        return FossilsLegacyPackets.TIME_MACHINE_UPDATE;
    }

    public static ServerboundTimeMachineUpdatePacket decode(FriendlyByteBuf friendlyByteBuf) {
        BlockPos blockPos = friendlyByteBuf.readBlockPos();
        boolean timeTravelling = friendlyByteBuf.readBoolean();
        return new ServerboundTimeMachineUpdatePacket(blockPos, timeTravelling);
    }

    public void handle(PlayPayloadContext playPayloadContext) {
        playPayloadContext.workHandler().submitAsync(() -> {
            BasicPackets.serverboundTimeMachineUpdatePacket(this.blockPos(), this.timeTravelling(), playPayloadContext.level().get());
        });
    }
}
