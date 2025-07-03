package willatendo.fossilslegacy.network.clientbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;

public record ClientboundOpenFossilScreenPacket(int id, FossilRotations fossilRotations, FossilPositions fossilPositions, String fossilVariant) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClientboundOpenFossilScreenPacket> TYPE = new CustomPacketPayload.Type<>(FAPackets.CLIENTBOUND_OPEN_FOSSIL_SCREEN);
    public static final StreamCodec<ByteBuf, ClientboundOpenFossilScreenPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ClientboundOpenFossilScreenPacket::id, FossilRotations.STREAM_CODEC_FROM_CODEC, ClientboundOpenFossilScreenPacket::fossilRotations, FossilPositions.STREAM_CODEC_FROM_CODEC, ClientboundOpenFossilScreenPacket::fossilPositions, ByteBufCodecs.STRING_UTF8, ClientboundOpenFossilScreenPacket::fossilVariant, ClientboundOpenFossilScreenPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.id());
        FossilRotations.STREAM_CODEC_FROM_CODEC.encode(friendlyByteBuf, this.fossilRotations());
        FossilPositions.STREAM_CODEC_FROM_CODEC.encode(friendlyByteBuf, this.fossilPositions());
        friendlyByteBuf.writeUtf(this.fossilVariant());
    }

    public static ClientboundOpenFossilScreenPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ClientboundOpenFossilScreenPacket(friendlyByteBuf.readInt(), FossilRotations.STREAM_CODEC_FROM_CODEC.decode(friendlyByteBuf), FossilPositions.STREAM_CODEC_FROM_CODEC.decode(friendlyByteBuf), friendlyByteBuf.readUtf());
    }
}
