package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;
import willatendo.fossilslegacy.server.block.DNARecombinatorMode;

public record ServerboundSetDNARecombinatorModePacket(BlockPos blockPos, DNARecombinatorMode mode) implements CustomPacketPayload {
    public static final Type<ServerboundSetDNARecombinatorModePacket> TYPE = new Type<>(FAPackets.SERVERBOUND_SET_DNA_RECOMBINATOR_MODE);
    public static final StreamCodec<ByteBuf, ServerboundSetDNARecombinatorModePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundSetDNARecombinatorModePacket::blockPos, DNARecombinatorMode.STREAM_CODEC, ServerboundSetDNARecombinatorModePacket::mode, ServerboundSetDNARecombinatorModePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos());
        DNARecombinatorMode.STREAM_CODEC.encode(friendlyByteBuf, this.mode());
    }

    public static ServerboundSetDNARecombinatorModePacket decode(FriendlyByteBuf friendlyByteBuf) {
        return new ServerboundSetDNARecombinatorModePacket(friendlyByteBuf.readBlockPos(), DNARecombinatorMode.STREAM_CODEC.decode(friendlyByteBuf));
    }
}
