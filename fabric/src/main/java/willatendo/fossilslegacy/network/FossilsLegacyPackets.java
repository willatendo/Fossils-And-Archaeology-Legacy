package willatendo.fossilslegacy.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class FossilsLegacyPackets {
    public static void registerClientToServerPackets() {
        PayloadTypeRegistry.playC2S().register(ServerboundApplyGenePacket.TYPE, ServerboundApplyGenePacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundSinkPacket.TYPE, ServerboundSinkPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundTimeMachineUpdatePacket.TYPE, ServerboundTimeMachineUpdatePacket.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ServerboundApplyGenePacket.TYPE, FossilsLegacyPackets::serverboundApplyGenePacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSinkPacket.TYPE, FossilsLegacyPackets::serverboundSinkPacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundTimeMachineUpdatePacket.TYPE, FossilsLegacyPackets::serverboundTimeMachineUpdatePacket);
    }

    public static void registerServerToClientPackets() {
        PayloadTypeRegistry.playS2C().register(ClientboundAlertUnlockedCoatTypesPacket.TYPE, ClientboundAlertUnlockedCoatTypesPacket.STREAM_CODEC);

        ClientPlayNetworking.registerGlobalReceiver(ClientboundAlertUnlockedCoatTypesPacket.TYPE, FossilsLegacyPackets::clientboundAlertUnlockedCoatTypes);
    }

    public static void clientboundAlertUnlockedCoatTypes(ClientboundAlertUnlockedCoatTypesPacket clientboundAlertUnlockedCoatTypesPacket, ClientPlayNetworking.Context context) {
        BasicPackets.clientboundAlertUnlockedCoatTypes(clientboundAlertUnlockedCoatTypesPacket.coatTypes(), context.player(), context.player().level());
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
