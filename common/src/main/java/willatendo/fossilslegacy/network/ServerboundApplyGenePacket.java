package willatendo.fossilslegacy.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.util.ForgeHandlePacket;

import java.util.Optional;

public record ServerboundApplyGenePacket(BlockPos blockPos, String modelType, String skin, Optional<String> pattern) implements CustomPacketPayload {
    public static final Type<ServerboundApplyGenePacket> TYPE = new Type<>(BasicPackets.APPLY_GENE);
    public static final StreamCodec<ByteBuf, ServerboundApplyGenePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundApplyGenePacket::blockPos, ByteBufCodecs.STRING_UTF8, ServerboundApplyGenePacket::modelType, ByteBufCodecs.STRING_UTF8, ServerboundApplyGenePacket::skin, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundApplyGenePacket::pattern, ServerboundApplyGenePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos());
        friendlyByteBuf.writeUtf(this.modelType());
        friendlyByteBuf.writeUtf(this.skin());
        boolean hasPattern = this.pattern().isPresent();
        friendlyByteBuf.writeBoolean(hasPattern);
        if (hasPattern) {
            friendlyByteBuf.writeUtf(this.pattern().get());
        }
    }

    public static ServerboundApplyGenePacket decode(FriendlyByteBuf friendlyByteBuf) {
        BlockPos blockPos = friendlyByteBuf.readBlockPos();
        String modelType = friendlyByteBuf.readUtf();
        String skin = friendlyByteBuf.readUtf();
        Optional<String> pattern = Optional.empty();
        if (friendlyByteBuf.readBoolean()) {
            pattern = Optional.of(friendlyByteBuf.readUtf());
        }
        return new ServerboundApplyGenePacket(blockPos, modelType, skin, pattern);
    }

    public static void handle(ForgeHandlePacket forgeHandlePacket, ServerboundApplyGenePacket serverboundApplyGenePacket) {
        BasicPackets.serverboundApplyGenePacket(serverboundApplyGenePacket.blockPos(), serverboundApplyGenePacket.modelType(), serverboundApplyGenePacket.skin(), serverboundApplyGenePacket.pattern(), forgeHandlePacket.getServerPlayer().level());
    }
}
