package willatendo.fossilslegacy.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public record ServerboundSinkPacket(boolean shouldSink) implements CustomPacketPayload {
    @Override
    public void write(FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBoolean(this.shouldSink);
    }

    @Override
    public ResourceLocation id() {
        return FossilsLegacyPackets.SINK;
    }

    public static ServerboundSinkPacket decode(FriendlyByteBuf friendlyByteBuf) {
        boolean shouldSink = friendlyByteBuf.readBoolean();
        return new ServerboundSinkPacket(shouldSink);
    }

    public void handle(PlayPayloadContext playPayloadContext) {
        playPayloadContext.workHandler().submitAsync(() -> {
            Level level = playPayloadContext.level().get();
            BasicPackets.serverboundSinkPacket((ServerPlayer) playPayloadContext.player().get(), this.shouldSink());
        });
    }
}
