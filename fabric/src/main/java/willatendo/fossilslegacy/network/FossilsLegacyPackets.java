package willatendo.fossilslegacy.network;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.level.Level;
import willatendo.fossilslegacy.server.utils.FossilsLegacyUtils;

public class FossilsLegacyPackets {
    public static final ResourceLocation TIME_MACHINE_UPDATE = FossilsLegacyUtils.resource("time_machine_update");
    public static final ResourceLocation SINK = FossilsLegacyUtils.resource("sink");

    public static void registerClientToServerPackets() {
        ServerPlayNetworking.registerGlobalReceiver(TIME_MACHINE_UPDATE, FossilsLegacyPackets::serverboundTimeMachineUpdatePacket);
        ServerPlayNetworking.registerGlobalReceiver(SINK, FossilsLegacyPackets::serverboundSinkPacket);
    }

    public static void serverboundTimeMachineUpdatePacket(MinecraftServer minecraftServer, ServerPlayer serverPlayer, ServerGamePacketListenerImpl serverGamePacketListener, FriendlyByteBuf friendlyByteBuf, PacketSender packetSender) {
        BlockPos blockPos = friendlyByteBuf.readBlockPos();
        boolean timeTravelling = friendlyByteBuf.readBoolean();
        Level level = serverGamePacketListener.getPlayer().level();
        BasicPackets.serverboundTimeMachineUpdatePacket(blockPos, timeTravelling, level);
    }

    public static void serverboundSinkPacket(MinecraftServer minecraftServer, ServerPlayer serverPlayer, ServerGamePacketListenerImpl serverGamePacketListener, FriendlyByteBuf friendlyByteBuf, PacketSender packetSender) {
        boolean shouldSink = friendlyByteBuf.readBoolean();
        BasicPackets.serverboundSinkPacket(serverPlayer, shouldSink);
    }
}
