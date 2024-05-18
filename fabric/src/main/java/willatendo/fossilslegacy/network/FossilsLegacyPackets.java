package willatendo.fossilslegacy.network;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.level.block.entity.BlockEntity;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyPackets {
    public static void registerClientToServerPackets() {
        ServerPlayNetworking.registerGlobalReceiver(BasicPackets.TIME_MACHINE_UPDATE, FossilsLegacyPackets::serverboundTimeMachineUpdatePacket);
        ServerPlayNetworking.registerGlobalReceiver(BasicPackets.SINK, FossilsLegacyPackets::serverboundSinkPacket);
    }

    public static void serverboundTimeMachineUpdatePacket(MinecraftServer minecraftServer, ServerPlayer serverPlayer, ServerGamePacketListenerImpl serverGamePacketListener, FriendlyByteBuf friendlyByteBuf, PacketSender packetSender) {
        minecraftServer.execute(() -> {
            BlockPos blockPos = friendlyByteBuf.readBlockPos();
            ServerLevel serverLevel = serverPlayer.serverLevel();
            BlockEntity blockEntity = serverLevel.getBlockEntity(blockPos);
            if (blockEntity == null) {
                FossilsLegacyUtils.LOGGER.info("Null");
            }
            BasicPackets.serverboundTimeMachineUpdatePacket(blockPos, serverLevel);
        });
    }

    public static void serverboundSinkPacket(MinecraftServer minecraftServer, ServerPlayer serverPlayer, ServerGamePacketListenerImpl serverGamePacketListener, FriendlyByteBuf friendlyByteBuf, PacketSender packetSender) {
        minecraftServer.execute(() -> {
            boolean shouldSink = friendlyByteBuf.readBoolean();
            BasicPackets.serverboundSinkPacket(serverPlayer, shouldSink);
        });
    }
}
