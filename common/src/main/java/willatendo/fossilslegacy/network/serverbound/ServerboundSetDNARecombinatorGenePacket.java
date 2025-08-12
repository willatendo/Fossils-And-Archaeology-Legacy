package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

import java.util.List;
import java.util.Optional;

public record ServerboundSetDNARecombinatorGenePacket(BlockPos blockPos, Optional<String> modelType, Optional<String> skin, Optional<String> pattern, List<Optional<String>> attributeGenes) implements CustomPacketPayload {
    public static final Type<ServerboundSetDNARecombinatorGenePacket> TYPE = new Type<>(FAPackets.SERVERBOUND_SET_DNA_RECOMBINATOR_GENE);
    public static final StreamCodec<ByteBuf, ServerboundSetDNARecombinatorGenePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundSetDNARecombinatorGenePacket::blockPos, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundSetDNARecombinatorGenePacket::modelType, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundSetDNARecombinatorGenePacket::skin, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundSetDNARecombinatorGenePacket::pattern, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8).apply(ByteBufCodecs.list()), ServerboundSetDNARecombinatorGenePacket::attributeGenes, ServerboundSetDNARecombinatorGenePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
