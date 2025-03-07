package willatendo.fossilslegacy.network;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class NeoforgePacketHelper {
    public static void handleApplyGenePacket(ServerboundApplyGenePacket serverboundApplyGenePacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> BasicPackets.serverboundApplyGenePacket(serverboundApplyGenePacket.blockPos(), serverboundApplyGenePacket.modelType(), serverboundApplyGenePacket.skin(), serverboundApplyGenePacket.pattern(), iPayloadContext.player().level()));
    }

    public static void handleSinkPacket(ServerboundSinkPacket sinkPacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> BasicPackets.serverboundSinkPacket((ServerPlayer) iPayloadContext.player(), sinkPacket.shouldSink()));
    }

    public static void handleTimeMachineUpdatePacket(ServerboundTimeMachineUpdatePacket serverboundTimeMachineUpdatePacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> BasicPackets.serverboundTimeMachineUpdatePacket(serverboundTimeMachineUpdatePacket.blockPos(), iPayloadContext.player().level()));
    }
}
