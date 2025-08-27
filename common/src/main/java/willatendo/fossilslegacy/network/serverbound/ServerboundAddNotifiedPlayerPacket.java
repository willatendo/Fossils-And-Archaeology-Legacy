package willatendo.fossilslegacy.network.serverbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import willatendo.fossilslegacy.network.FAPackets;

import java.util.UUID;

public record ServerboundAddNotifiedPlayerPacket(BlockPos blockPos, UUID playerUuid) implements CustomPacketPayload {
    public static final Type<ServerboundAddNotifiedPlayerPacket> TYPE = new Type<>(FAPackets.SERVERBOUND_ADD_NOTIFIED_PLAYER);
    public static final StreamCodec<ByteBuf, ServerboundAddNotifiedPlayerPacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ServerboundAddNotifiedPlayerPacket::blockPos, UUIDUtil.STREAM_CODEC, ServerboundAddNotifiedPlayerPacket::playerUuid, ServerboundAddNotifiedPlayerPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
