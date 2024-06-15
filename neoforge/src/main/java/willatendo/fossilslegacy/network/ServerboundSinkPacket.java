package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundSinkPacket(boolean shouldSink) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundSinkPacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.SINK);
    public static final StreamCodec<ByteBuf, ServerboundSinkPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundSinkPacket::shouldSink, ServerboundSinkPacket::new);

    public static void handle(ServerboundSinkPacket sinkPacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            BasicPackets.serverboundSinkPacket((ServerPlayer) iPayloadContext.player(), sinkPacket.shouldSink());
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
