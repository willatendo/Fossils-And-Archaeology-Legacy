package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

public record ServerboundDamageHammerPacket(int id) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundDamageHammerPacket> TYPE = new CustomPacketPayload.Type<>(FAPackets.SERVERBOUND_DAMAGE_HAMMER);
    public static final StreamCodec<ByteBuf, ServerboundDamageHammerPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ServerboundDamageHammerPacket::id, ServerboundDamageHammerPacket::new);

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.id());
    }

    public static ServerboundDamageHammerPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundDamageHammerPacket(friendlyByteBuf.readInt());
    }
}
