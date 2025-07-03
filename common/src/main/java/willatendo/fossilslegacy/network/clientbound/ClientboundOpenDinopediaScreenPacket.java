package willatendo.fossilslegacy.network.clientbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

public record ClientboundOpenDinopediaScreenPacket(int id) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClientboundOpenDinopediaScreenPacket> TYPE = new CustomPacketPayload.Type<>(FAPackets.CLIENTBOUND_OPEN_DINOPEDIA_SCREEN);
    public static final StreamCodec<ByteBuf, ClientboundOpenDinopediaScreenPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ClientboundOpenDinopediaScreenPacket::id, ClientboundOpenDinopediaScreenPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.id());
    }

    public static ClientboundOpenDinopediaScreenPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ClientboundOpenDinopediaScreenPacket(friendlyByteBuf.readInt());
    }
}
