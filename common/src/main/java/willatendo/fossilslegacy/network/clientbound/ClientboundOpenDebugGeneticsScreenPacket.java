package willatendo.fossilslegacy.network.clientbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

public record ClientboundOpenDebugGeneticsScreenPacket(int id) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ClientboundOpenDebugGeneticsScreenPacket> TYPE = new CustomPacketPayload.Type<>(FAPackets.CLIENTBOUND_OPEN_DEBUG_GENETICS_SCREEN);
    public static final StreamCodec<ByteBuf, ClientboundOpenDebugGeneticsScreenPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ClientboundOpenDebugGeneticsScreenPacket::id, ClientboundOpenDebugGeneticsScreenPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
