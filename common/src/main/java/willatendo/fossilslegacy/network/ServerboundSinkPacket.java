package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;

public record ServerboundSinkPacket(boolean shouldSink) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundSinkPacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.SINK);
    public static final StreamCodec<ByteBuf, ServerboundSinkPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundSinkPacket::shouldSink, ServerboundSinkPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.shouldSink());
    }

    public static ServerboundSinkPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundSinkPacket(friendlyByteBuf.readBoolean());
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ServerboundSinkPacket serverboundSinkPacket) {
        BasicPackets.serverboundSinkPacket(forgeHandlePacket.getServerPlayer(), serverboundSinkPacket.shouldSink());
    }
}
