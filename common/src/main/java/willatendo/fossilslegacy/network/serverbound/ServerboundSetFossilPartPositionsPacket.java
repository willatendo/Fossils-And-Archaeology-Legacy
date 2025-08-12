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
}
