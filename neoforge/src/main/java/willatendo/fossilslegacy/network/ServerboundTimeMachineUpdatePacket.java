package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public record ServerboundTimeMachineUpdatePacket(BlockPos blockPos) implements CustomPacketPayload {
    @Override
    public void write(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos);
    }

    @Override
    public ResourceLocation id() {
        return BasicPackets.TIME_MACHINE_UPDATE;
    }

    public static ServerboundTimeMachineUpdatePacket decode(FriendlyByteBuf friendlyByteBuf) {
        BlockPos blockPos = friendlyByteBuf.readBlockPos();
        return new ServerboundTimeMachineUpdatePacket(blockPos);
    }

    public void handle(PlayPayloadContext playPayloadContext) {
        playPayloadContext.workHandler().submitAsync(() -> {
            BasicPackets.serverboundTimeMachineUpdatePacket(this.blockPos(), playPayloadContext.level().get());
        });
    }
}
