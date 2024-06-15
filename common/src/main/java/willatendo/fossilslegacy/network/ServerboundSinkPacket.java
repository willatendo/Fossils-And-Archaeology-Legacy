package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public record ServerboundSinkPacket(boolean shouldSink) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundSinkPacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.SINK);
    public static final StreamCodec<ByteBuf, ServerboundSinkPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundSinkPacket::shouldSink, ServerboundSinkPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
