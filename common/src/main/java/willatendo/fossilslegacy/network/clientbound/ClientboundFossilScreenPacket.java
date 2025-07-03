package willatendo.fossilslegacy.network.clientbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;
import willatendo.fossilslegacy.server.entity.util.FossilPositions;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;

public record ClientboundFossilScreenPacket(int id, FossilRotations fossilRotations, FossilPositions fossilPositions, String fossilVariant) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClientboundFossilScreenPacket> TYPE = new CustomPacketPayload.Type<>(FAPackets.CLIENTBOUND_FOSSIL_SCREEN);
    public static final StreamCodec<ByteBuf, ClientboundFossilScreenPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ClientboundFossilScreenPacket::id, FossilRotations.STREAM_CODEC_FROM_CODEC, ClientboundFossilScreenPacket::fossilRotations, FossilPositions.STREAM_CODEC_FROM_CODEC, ClientboundFossilScreenPacket::fossilPositions, ByteBufCodecs.STRING_UTF8, ClientboundFossilScreenPacket::fossilVariant, ClientboundFossilScreenPacket::new);

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

    public static ClientboundFossilScreenPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ClientboundFossilScreenPacket(friendlyByteBuf.readInt(), FossilRotations.STREAM_CODEC_FROM_CODEC.decode(friendlyByteBuf), FossilPositions.STREAM_CODEC_FROM_CODEC.decode(friendlyByteBuf), friendlyByteBuf.readUtf());
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ClientboundFossilScreenPacket clientboundFossilScreenPacket) {
        ClientboundPackets.clientboundFossilMenuPacket(clientboundFossilScreenPacket.id(), clientboundFossilScreenPacket.fossilRotations(), clientboundFossilScreenPacket.fossilPositions(), clientboundFossilScreenPacket.fossilVariant(), forgeHandlePacket.getServerPlayer().level());
    }
}
