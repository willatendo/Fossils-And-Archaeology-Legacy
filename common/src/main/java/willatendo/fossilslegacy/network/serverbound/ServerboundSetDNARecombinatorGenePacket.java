package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

import java.util.Optional;

public record ServerboundSetDNARecombinatorGenePacket(BlockPos blockPos, String modelType, String skin, Optional<String> pattern) implements CustomPacketPayload {
    public static final Type<ServerboundSetDNARecombinatorGenePacket> TYPE = new Type<>(FAPackets.SERVERBOUND_SET_DNA_RECOMBINATOR_GENE);
    public static final StreamCodec<ByteBuf, ServerboundSetDNARecombinatorGenePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundSetDNARecombinatorGenePacket::blockPos, ByteBufCodecs.STRING_UTF8, ServerboundSetDNARecombinatorGenePacket::modelType, ByteBufCodecs.STRING_UTF8, ServerboundSetDNARecombinatorGenePacket::skin, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundSetDNARecombinatorGenePacket::pattern, ServerboundSetDNARecombinatorGenePacket::new);

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

    public static ServerboundSetDNARecombinatorGenePacket decode(FriendlyByteBuf friendlyByteBuf) {
        BlockPos blockPos = friendlyByteBuf.readBlockPos();
        String modelType = friendlyByteBuf.readUtf();
        String skin = friendlyByteBuf.readUtf();
        Optional<String> pattern = Optional.empty();
        if (friendlyByteBuf.readBoolean()) {
            pattern = Optional.of(friendlyByteBuf.readUtf());
        }
        return new ServerboundSetDNARecombinatorGenePacket(blockPos, modelType, skin, pattern);
    }
}
