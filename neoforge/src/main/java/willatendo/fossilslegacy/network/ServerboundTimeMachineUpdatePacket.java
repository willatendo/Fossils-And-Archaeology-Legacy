package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundTimeMachineUpdatePacket(BlockPos blockPos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundTimeMachineUpdatePacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.TIME_MACHINE_UPDATE);
    public static final StreamCodec<ByteBuf, ServerboundTimeMachineUpdatePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundTimeMachineUpdatePacket::blockPos, ServerboundTimeMachineUpdatePacket::new);

    public static void handle(ServerboundTimeMachineUpdatePacket serverboundTimeMachineUpdatePacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            BasicPackets.serverboundTimeMachineUpdatePacket(serverboundTimeMachineUpdatePacket.blockPos(), iPayloadContext.player().level());
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
