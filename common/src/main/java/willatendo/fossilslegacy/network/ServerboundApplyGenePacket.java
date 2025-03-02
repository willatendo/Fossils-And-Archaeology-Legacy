package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;

public record ServerboundApplyGenePacket(BlockPos blockPos, String modelType, String pattern) implements CustomPacketPayload {
    public static final Type<ServerboundApplyGenePacket> TYPE = new Type<>(BasicPackets.APPLY_GENE);
    public static final StreamCodec<ByteBuf, ServerboundApplyGenePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundApplyGenePacket::blockPos, ByteBufCodecs.STRING_UTF8, ServerboundApplyGenePacket::modelType, ByteBufCodecs.STRING_UTF8, ServerboundApplyGenePacket::pattern, ServerboundApplyGenePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos());
        friendlyByteBuf.writeUtf(this.modelType());
        friendlyByteBuf.writeUtf(this.pattern());
    }

    public static ServerboundApplyGenePacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundApplyGenePacket(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readUtf(), friendlyByteBuf.readUtf());
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ServerboundApplyGenePacket serverboundApplyGenePacket) {
        BasicPackets.serverboundApplyGenePacket(serverboundApplyGenePacket.blockPos(), serverboundApplyGenePacket.modelType(), serverboundApplyGenePacket.pattern(), forgeHandlePacket.getServerPlayer().level());
    }
}
