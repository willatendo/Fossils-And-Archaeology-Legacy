package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.server.utils.ForgeHandlePacket;

public record ServerboundTimeMachineUpdatePacket(BlockPos blockPos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundTimeMachineUpdatePacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.TIME_MACHINE_UPDATE);
    public static final StreamCodec<ByteBuf, ServerboundTimeMachineUpdatePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundTimeMachineUpdatePacket::blockPos, ServerboundTimeMachineUpdatePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos());
    }

    public static ServerboundTimeMachineUpdatePacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundTimeMachineUpdatePacket(friendlyByteBuf.readBlockPos());
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ServerboundTimeMachineUpdatePacket serverboundTimeMachineUpdatePacket) {
        BasicPackets.serverboundTimeMachineUpdatePacket(serverboundTimeMachineUpdatePacket.blockPos(), forgeHandlePacket.getServerPlayer().level());
    }
}
