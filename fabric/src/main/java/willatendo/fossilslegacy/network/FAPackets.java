package willatendo.fossilslegacy.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class FAPackets {
    public static void registerClientToServerPackets() {
        PayloadTypeRegistry.playC2S().register(ServerboundApplyGenePacket.TYPE, ServerboundApplyGenePacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundSinkPacket.TYPE, ServerboundSinkPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundTimeMachineUpdatePacket.TYPE, ServerboundTimeMachineUpdatePacket.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ServerboundApplyGenePacket.TYPE, FAPackets::serverboundApplyGenePacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSinkPacket.TYPE, FAPackets::serverboundSinkPacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundTimeMachineUpdatePacket.TYPE, FAPackets::serverboundTimeMachineUpdatePacket);
    }

    public static void serverboundApplyGenePacket(ServerboundApplyGenePacket serverboundApplyGenePacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundApplyGenePacket(serverboundApplyGenePacket.blockPos(), serverboundApplyGenePacket.coatType(), context.player().serverLevel());
    }

    public static void serverboundTimeMachineUpdatePacket(ServerboundTimeMachineUpdatePacket serverboundTimeMachineUpdatePacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundTimeMachineUpdatePacket(serverboundTimeMachineUpdatePacket.blockPos(), context.player().serverLevel());
    }

    public static void serverboundSinkPacket(ServerboundSinkPacket serverboundSinkPacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundSinkPacket(context.player(), serverboundSinkPacket.shouldSink());
    }
}
