package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record ServerboundSetDNARecombinatorGenePacket(BlockPos blockPos, Optional<String> modelType, Optional<String> skin, Optional<String> pattern, List<Optional<String>> attributeGenes) implements CustomPacketPayload {
    public static final Type<ServerboundSetDNARecombinatorGenePacket> TYPE = new Type<>(FAPackets.SERVERBOUND_SET_DNA_RECOMBINATOR_GENE);
    public static final StreamCodec<ByteBuf, ServerboundSetDNARecombinatorGenePacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundSetDNARecombinatorGenePacket::blockPos, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundSetDNARecombinatorGenePacket::modelType, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundSetDNARecombinatorGenePacket::skin, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8), ServerboundSetDNARecombinatorGenePacket::pattern, ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8).apply(ByteBufCodecs.list()), ServerboundSetDNARecombinatorGenePacket::attributeGenes, ServerboundSetDNARecombinatorGenePacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    // Forge Start

    public void encode(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(this.blockPos());
        boolean hasModelType = this.modelType().isPresent();
        friendlyByteBuf.writeBoolean(hasModelType);
        if (hasModelType) {
            friendlyByteBuf.writeUtf(this.modelType().get());
        }
        boolean hasSkin = this.skin().isPresent();
        friendlyByteBuf.writeBoolean(hasSkin);
        if (hasSkin) {
            friendlyByteBuf.writeUtf(this.skin().get());
        }
        boolean hasPattern = this.pattern().isPresent();
        friendlyByteBuf.writeBoolean(hasPattern);
        if (hasPattern) {
            friendlyByteBuf.writeUtf(this.pattern().get());
        }
        friendlyByteBuf.writeInt(this.attributeGenes.size());
        this.attributeGenes.forEach(optionalGene -> {
            boolean isPresent = optionalGene.isPresent();
            friendlyByteBuf.writeBoolean(isPresent);
            if (isPresent) {
                friendlyByteBuf.writeUtf(optionalGene.get());
            }
        });
    }

    public static ServerboundSetDNARecombinatorGenePacket decode(FriendlyByteBuf friendlyByteBuf) {
        BlockPos blockPos = friendlyByteBuf.readBlockPos();
        Optional<String> modelType = Optional.empty();
        if (friendlyByteBuf.readBoolean()) {
            modelType = Optional.of(friendlyByteBuf.readUtf());
        }
        Optional<String> skin = Optional.empty();
        if (friendlyByteBuf.readBoolean()) {
            skin = Optional.of(friendlyByteBuf.readUtf());
        }
        Optional<String> pattern = Optional.empty();
        if (friendlyByteBuf.readBoolean()) {
            pattern = Optional.of(friendlyByteBuf.readUtf());
        }
        List<Optional<String>> attributeGenes = new ArrayList<>();
        for (int i = 0; i < friendlyByteBuf.readInt(); i++) {
            boolean isPresent = friendlyByteBuf.readBoolean();
            Optional<String> attributeGene = Optional.empty();
            if (isPresent) {
                attributeGene = Optional.of(friendlyByteBuf.readUtf());
            }
            attributeGenes.add(attributeGene);
        }
        return new ServerboundSetDNARecombinatorGenePacket(blockPos, modelType, skin, pattern, attributeGenes);
    }
}
