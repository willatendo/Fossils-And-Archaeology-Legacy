package willatendo.fossilslegacy.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

public class FossilsLegacyPackets {
    public static void registerClientToServerPackets() {
        PayloadTypeRegistry.playC2S().register(ServerboundTimeMachineUpdatePacket.TYPE, ServerboundTimeMachineUpdatePacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundSinkPacket.TYPE, ServerboundSinkPacket.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ServerboundTimeMachineUpdatePacket.TYPE, FossilsLegacyPackets::serverboundTimeMachineUpdatePacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSinkPacket.TYPE, FossilsLegacyPackets::serverboundSinkPacket);
    }

    public static void serverboundTimeMachineUpdatePacket(ServerboundTimeMachineUpdatePacket serverboundTimeMachineUpdatePacket, ServerPlayNetworking.Context context) {
        BlockPos blockPos = serverboundTimeMachineUpdatePacket.blockPos();
        ServerLevel serverLevel = context.player().serverLevel();
        BasicPackets.serverboundTimeMachineUpdatePacket(blockPos, serverLevel);
    }

    public static void serverboundSinkPacket(ServerboundSinkPacket serverboundSinkPacket, ServerPlayNetworking.Context context) {
        boolean shouldSink = serverboundSinkPacket.shouldSink();
        BasicPackets.serverboundSinkPacket(context.player(), shouldSink);
    }
}
