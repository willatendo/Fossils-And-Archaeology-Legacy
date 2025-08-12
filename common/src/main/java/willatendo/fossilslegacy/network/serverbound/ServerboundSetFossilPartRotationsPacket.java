package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

public record ServerboundSetFossilPartRotationsPacket(int id, String part, float xRot, float yRot, float zRot) implements CustomPacketPayload {
    public static final Type<ServerboundSetFossilPartRotationsPacket> TYPE = new Type<>(FAPackets.SERVERBOUND_SET_FOSSIL_PART_ROTATIONS);
    public static final StreamCodec<ByteBuf, ServerboundSetFossilPartRotationsPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ServerboundSetFossilPartRotationsPacket::id, ByteBufCodecs.STRING_UTF8, ServerboundSetFossilPartRotationsPacket::part, ByteBufCodecs.FLOAT, ServerboundSetFossilPartRotationsPacket::xRot, ByteBufCodecs.FLOAT, ServerboundSetFossilPartRotationsPacket::yRot, ByteBufCodecs.FLOAT, ServerboundSetFossilPartRotationsPacket::zRot, ServerboundSetFossilPartRotationsPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
