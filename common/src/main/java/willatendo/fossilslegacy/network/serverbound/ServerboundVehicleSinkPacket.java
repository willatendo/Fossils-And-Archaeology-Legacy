package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

public record ServerboundVehicleSinkPacket(boolean shouldSink) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundVehicleSinkPacket> TYPE = new CustomPacketPayload.Type<>(FAPackets.SERVERBOUND_VEHICLE_SINK);
    public static final StreamCodec<ByteBuf, ServerboundVehicleSinkPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, ServerboundVehicleSinkPacket::shouldSink, ServerboundVehicleSinkPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.shouldSink());
    }

    public static ServerboundVehicleSinkPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundVehicleSinkPacket(friendlyByteBuf.readBoolean());
    }
}
