package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

public record ServerboundStartTimeMachinePacket(BlockPos blockPos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundStartTimeMachinePacket> TYPE = new CustomPacketPayload.Type<>(FAPackets.SERVERBOUND_START_TIME_MACHINE);
    public static final StreamCodec<ByteBuf, ServerboundStartTimeMachinePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundStartTimeMachinePacket::blockPos, ServerboundStartTimeMachinePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos());
    }

    public static ServerboundStartTimeMachinePacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundStartTimeMachinePacket(friendlyByteBuf.readBlockPos());
    }
}
