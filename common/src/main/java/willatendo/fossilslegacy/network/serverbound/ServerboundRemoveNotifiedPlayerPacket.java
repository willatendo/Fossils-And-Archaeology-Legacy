package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

import java.util.UUID;

public record ServerboundRemoveNotifiedPlayerPacket(BlockPos blockPos, UUID playerUuid) implements CustomPacketPayload {
    public static final Type<ServerboundRemoveNotifiedPlayerPacket> TYPE = new Type<>(FAPackets.SERVERBOUND_REMOVE_NOTIFIED_PLAYER);
    public static final StreamCodec<ByteBuf, ServerboundRemoveNotifiedPlayerPacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundRemoveNotifiedPlayerPacket::blockPos, UUIDUtil.STREAM_CODEC, ServerboundRemoveNotifiedPlayerPacket::playerUuid, ServerboundRemoveNotifiedPlayerPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
