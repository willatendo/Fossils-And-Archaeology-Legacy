package willatendo.fossilslegacy.network.clientbound;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import willatendo.fossilslegacy.network.FAPackets;

public record ClientboundPlaySoundPacket(BlockPos blockPos, ResourceKey<SoundEvent> soundEvent, String category, float volume, float pitch, boolean distanceDelay) implements CustomPacketPayload {
    public static final Type<ClientboundPlaySoundPacket> TYPE = new Type<>(FAPackets.CLIENTBOUND_PLAY_SOUND);
    public static final StreamCodec<ByteBuf, ClientboundPlaySoundPacket> STREAM_CODEC = StreamCodec.composite(BlockPos.STREAM_CODEC, ClientboundPlaySoundPacket::blockPos, ResourceKey.streamCodec(Registries.SOUND_EVENT), ClientboundPlaySoundPacket::soundEvent, ByteBufCodecs.STRING_UTF8, ClientboundPlaySoundPacket::category, ByteBufCodecs.FLOAT, ClientboundPlaySoundPacket::volume, ByteBufCodecs.FLOAT, ClientboundPlaySoundPacket::pitch, ByteBufCodecs.BOOL, ClientboundPlaySoundPacket::distanceDelay, ClientboundPlaySoundPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
