package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;

public record ServerboundAddRotationsPacket(int id, String part, float xRot, float yRot, float zRot) implements CustomPacketPayload {
    public static final Type<ServerboundAddRotationsPacket> TYPE = new Type<>(BasicPackets.ADD_ROTATIONS);
    public static final StreamCodec<ByteBuf, ServerboundAddRotationsPacket> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.INT, ServerboundAddRotationsPacket::id, ByteBufCodecs.STRING_UTF8, ServerboundAddRotationsPacket::part, ByteBufCodecs.FLOAT, ServerboundAddRotationsPacket::xRot, ByteBufCodecs.FLOAT, ServerboundAddRotationsPacket::yRot, ByteBufCodecs.FLOAT, ServerboundAddRotationsPacket::zRot, ServerboundAddRotationsPacket::new);

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

    public static ServerboundAddRotationsPacket decode(FriendlyByteBuf friendlyByteBuf) {
        int id = friendlyByteBuf.readInt();
        String part = friendlyByteBuf.readUtf();
        float xRot = friendlyByteBuf.readFloat();
        float yRot = friendlyByteBuf.readFloat();
        float zRot = friendlyByteBuf.readFloat();
        return new ServerboundAddRotationsPacket(id, part, xRot, yRot, zRot);
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ServerboundAddRotationsPacket serverboundAddRotationsPacket) {
        BasicPackets.serverboundAddRotationsPacket(serverboundAddRotationsPacket.id(), serverboundAddRotationsPacket.part(), serverboundAddRotationsPacket.xRot(), serverboundAddRotationsPacket.yRot(), serverboundAddRotationsPacket.zRot(), forgeHandlePacket.getServerPlayer().level());
    }
}
