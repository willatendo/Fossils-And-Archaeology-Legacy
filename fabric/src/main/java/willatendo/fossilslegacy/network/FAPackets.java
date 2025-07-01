package willatendo.fossilslegacy.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class FAPackets {
    public static void registerClientToServerPackets() {
        PayloadTypeRegistry.playC2S().register(ServerboundApplyGenePacket.TYPE, ServerboundApplyGenePacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundAddRotationsPacket.TYPE, ServerboundAddRotationsPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundSinkPacket.TYPE, ServerboundSinkPacket.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(ServerboundTimeMachineUpdatePacket.TYPE, ServerboundTimeMachineUpdatePacket.STREAM_CODEC);

        PayloadTypeRegistry.playS2C().register(ClientboundFossilMenuPacket.TYPE, ClientboundFossilMenuPacket.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ServerboundApplyGenePacket.TYPE, FAPackets::serverboundApplyGenePacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundAddRotationsPacket.TYPE, FAPackets::serverboundAddRotationsPacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSetRotationsPacket.TYPE, FAPackets::serverboundSetRotationsPacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundSinkPacket.TYPE, FAPackets::serverboundSinkPacket);
        ServerPlayNetworking.registerGlobalReceiver(ServerboundTimeMachineUpdatePacket.TYPE, FAPackets::serverboundTimeMachineUpdatePacket);

        ClientPlayNetworking.registerGlobalReceiver(ClientboundFossilMenuPacket.TYPE, FAPackets::clientboundFossilMenuPacket);
    }

    public static void serverboundApplyGenePacket(ServerboundApplyGenePacket serverboundApplyGenePacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundApplyGenePacket(serverboundApplyGenePacket.blockPos(), serverboundApplyGenePacket.modelType(), serverboundApplyGenePacket.skin(), serverboundApplyGenePacket.pattern(), context.player().serverLevel());
    }

    public static void serverboundAddRotationsPacket(ServerboundAddRotationsPacket serverboundAddRotationsPacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundAddRotationsPacket(serverboundAddRotationsPacket.id(), serverboundAddRotationsPacket.part(), serverboundAddRotationsPacket.xRot(), serverboundAddRotationsPacket.yRot(), serverboundAddRotationsPacket.zRot(), context.player().serverLevel());
    }

    public static void serverboundTimeMachineUpdatePacket(ServerboundTimeMachineUpdatePacket serverboundTimeMachineUpdatePacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundTimeMachineUpdatePacket(serverboundTimeMachineUpdatePacket.blockPos(), context.player().serverLevel());
    }

    public static void serverboundSetRotationsPacket(ServerboundSetRotationsPacket serverboundSetRotationsPacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundSetRotationsPacket(serverboundSetRotationsPacket.id(), serverboundSetRotationsPacket.part(), serverboundSetRotationsPacket.xRot(), serverboundSetRotationsPacket.yRot(), serverboundSetRotationsPacket.zRot(), context.player().serverLevel());
    }

    public static void serverboundSinkPacket(ServerboundSinkPacket serverboundSinkPacket, ServerPlayNetworking.Context context) {
        BasicPackets.serverboundSinkPacket(context.player(), serverboundSinkPacket.shouldSink());
    }

    public static void clientboundFossilMenuPacket(ClientboundFossilMenuPacket clientboundFossilMenuPacket, ClientPlayNetworking.Context context) {
        BasicPackets.clientboundFossilMenuPacket(clientboundFossilMenuPacket.id(), clientboundFossilMenuPacket.fossilRotations(), clientboundFossilMenuPacket.fossilVariant(), context.player().level());
    }
}
