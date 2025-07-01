package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;

public record ServerboundSetRotationsPacket(int id, String part, float xRot, float yRot, float zRot) implements CustomPacketPayload {
    public static final Type<ServerboundSetRotationsPacket> TYPE = new Type<>(BasicPackets.SET_ROTATIONS);
    public static final StreamCodec<ByteBuf, ServerboundSetRotationsPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ServerboundSetRotationsPacket::id, ByteBufCodecs.STRING_UTF8, ServerboundSetRotationsPacket::part, ByteBufCodecs.FLOAT, ServerboundSetRotationsPacket::xRot, ByteBufCodecs.FLOAT, ServerboundSetRotationsPacket::yRot, ByteBufCodecs.FLOAT, ServerboundSetRotationsPacket::zRot, ServerboundSetRotationsPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(this.id());
        friendlyByteBuf.writeUtf(this.part());
        friendlyByteBuf.writeFloat(this.xRot());
        friendlyByteBuf.writeFloat(this.yRot());
        friendlyByteBuf.writeFloat(this.zRot());
    }

    public static ServerboundSetRotationsPacket decode(FriendlyByteBuf friendlyByteBuf) {
        int id = friendlyByteBuf.readInt();
        String part = friendlyByteBuf.readUtf();
        float xRot = friendlyByteBuf.readFloat();
        float yRot = friendlyByteBuf.readFloat();
        float zRot = friendlyByteBuf.readFloat();
        return new ServerboundSetRotationsPacket(id, part, xRot, yRot, zRot);
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ServerboundSetRotationsPacket serverboundSetRotationsPacket) {
        BasicPackets.serverboundSetRotationsPacket(serverboundSetRotationsPacket.id(), serverboundSetRotationsPacket.part(), serverboundSetRotationsPacket.xRot(), serverboundSetRotationsPacket.yRot(), serverboundSetRotationsPacket.zRot(), forgeHandlePacket.getServerPlayer().level());
    }
}
