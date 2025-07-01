package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;
import willatendo.fossilslegacy.server.entity.util.FossilRotations;

public record ClientboundFossilMenuPacket(int id, FossilRotations fossilRotations, String fossilVariant) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClientboundFossilMenuPacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.FOSSIL_MENU);
    public static final StreamCodec<ByteBuf, ClientboundFossilMenuPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ClientboundFossilMenuPacket::id, FossilRotations.STREAM_CODEC_FROM_CODEC, ClientboundFossilMenuPacket::fossilRotations, ByteBufCodecs.STRING_UTF8, ClientboundFossilMenuPacket::fossilVariant, ClientboundFossilMenuPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.id());
        FossilRotations.STREAM_CODEC_FROM_CODEC.encode(friendlyByteBuf, this.fossilRotations);
        friendlyByteBuf.writeUtf(this.fossilVariant());
    }

    public static ClientboundFossilMenuPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ClientboundFossilMenuPacket(friendlyByteBuf.readInt(), FossilRotations.STREAM_CODEC_FROM_CODEC.decode(friendlyByteBuf), friendlyByteBuf.readUtf());
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ClientboundFossilMenuPacket clientboundFossilMenuPacket) {
        BasicPackets.clientboundFossilMenuPacket(clientboundFossilMenuPacket.id(), clientboundFossilMenuPacket.fossilRotations(), clientboundFossilMenuPacket.fossilVariant(), forgeHandlePacket.getServerPlayer().level());
    }
}
