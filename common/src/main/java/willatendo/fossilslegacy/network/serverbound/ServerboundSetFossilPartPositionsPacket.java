package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

public record ServerboundSetFossilPartPositionsPacket(int id, String part, float x, float y, float z) implements CustomPacketPayload {
    public static final Type<ServerboundSetFossilPartPositionsPacket> TYPE = new Type<>(FAPackets.SERVERBOUND_SET_FOSSIL_PART_POSITIONS);
    public static final StreamCodec<ByteBuf, ServerboundSetFossilPartPositionsPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ServerboundSetFossilPartPositionsPacket::id, ByteBufCodecs.STRING_UTF8, ServerboundSetFossilPartPositionsPacket::part, ByteBufCodecs.FLOAT, ServerboundSetFossilPartPositionsPacket::x, ByteBufCodecs.FLOAT, ServerboundSetFossilPartPositionsPacket::y, ByteBufCodecs.FLOAT, ServerboundSetFossilPartPositionsPacket::z, ServerboundSetFossilPartPositionsPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.id());
        friendlyByteBuf.writeUtf(this.part());
        friendlyByteBuf.writeFloat(this.x());
        friendlyByteBuf.writeFloat(this.y());
        friendlyByteBuf.writeFloat(this.z());
    }

    public static ServerboundSetFossilPartPositionsPacket decode(FriendlyByteBuf friendlyByteBuf) {
        int id = friendlyByteBuf.readInt();
        String part = friendlyByteBuf.readUtf();
        float x = friendlyByteBuf.readFloat();
        float y = friendlyByteBuf.readFloat();
        float z = friendlyByteBuf.readFloat();
        return new ServerboundSetFossilPartPositionsPacket(id, part, x, y, z);
    }
}
