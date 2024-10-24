package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;

public record ServerboundApplyFossilVariantPacket(BlockPos blockPos, String fossilVariant) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<ServerboundApplyFossilVariantPacket> TYPE = new CustomPacketPayload.Type<>(BasicPackets.APPLY_FOSSIL_VARIANT);
    public static final StreamCodec<ByteBuf, ServerboundApplyFossilVariantPacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundApplyFossilVariantPacket::blockPos, ByteBufCodecs.STRING_UTF8, ServerboundApplyFossilVariantPacket::fossilVariant, ServerboundApplyFossilVariantPacket::new);

    @Override
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos());
        friendlyByteBuf.writeUtf(this.fossilVariant);
    }

    public static ServerboundApplyFossilVariantPacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundApplyFossilVariantPacket(friendlyByteBuf.readBlockPos(), friendlyByteBuf.readUtf());
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ServerboundApplyFossilVariantPacket serverboundApplyFossilVariantPacket) {
        BasicPackets.serverboundApplyFossilVariantPacket(serverboundApplyFossilVariantPacket.blockPos(), serverboundApplyFossilVariantPacket.fossilVariant, forgeHandlePacket.getServerPlayer().level());
    }
}
