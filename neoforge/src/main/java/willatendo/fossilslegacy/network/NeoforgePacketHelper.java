package willatendo.fossilslegacy.network;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import willatendo.fossilslegacy.network.clientbound.ClientboundFossilScreenPacket;
import willatendo.fossilslegacy.network.clientbound.ClientboundPackets;
import willatendo.fossilslegacy.network.serverbound.ServerboundPackets;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetDNARecombinatorGenePacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetFossilPartPositionsPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundSetFossilPartRotationsPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundVehicleSinkPacket;
import willatendo.fossilslegacy.network.serverbound.ServerboundStartTimeMachinePacket;

public class NeoforgePacketHelper {
    public static void handleApplyGenePacket(ServerboundSetDNARecombinatorGenePacket serverboundSetDNARecombinatorGenePacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> ServerboundPackets.serverboundSetDNARecombinatorGenePacket(serverboundSetDNARecombinatorGenePacket.blockPos(), serverboundSetDNARecombinatorGenePacket.modelType(), serverboundSetDNARecombinatorGenePacket.skin(), serverboundSetDNARecombinatorGenePacket.pattern(), iPayloadContext.player().level()));
    }

    public static void handleSetRotationsPacket(ServerboundSetFossilPartRotationsPacket serverboundSetFossilPartRotationsPacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> ServerboundPackets.serverboundSetRotationsPacket(serverboundSetFossilPartRotationsPacket.id(), serverboundSetFossilPartRotationsPacket.part(), serverboundSetFossilPartRotationsPacket.xRot(), serverboundSetFossilPartRotationsPacket.yRot(), serverboundSetFossilPartRotationsPacket.zRot(), iPayloadContext.player().level()));
    }

    public static void handleSetPositionsPacket(ServerboundSetFossilPartPositionsPacket serverboundSetFossilPartPositionsPacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> ServerboundPackets.serverboundSetFossilPartPositionsPacket(serverboundSetFossilPartPositionsPacket.id(), serverboundSetFossilPartPositionsPacket.part(), serverboundSetFossilPartPositionsPacket.x(), serverboundSetFossilPartPositionsPacket.y(), serverboundSetFossilPartPositionsPacket.z(), iPayloadContext.player().level()));
    }

    public static void handleSinkPacket(ServerboundVehicleSinkPacket sinkPacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> ServerboundPackets.serverboundSinkPacket((ServerPlayer) iPayloadContext.player(), sinkPacket.shouldSink()));
    }

    public static void handleTimeMachineUpdatePacket(ServerboundStartTimeMachinePacket serverboundStartTimeMachinePacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> ServerboundPackets.serverboundStartTimeMachinePacket(serverboundStartTimeMachinePacket.blockPos(), iPayloadContext.player().level()));
    }

    public static void handleFossilMenuPacket(ClientboundFossilScreenPacket clientboundFossilScreenPacket, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> ClientboundPackets.clientboundFossilMenuPacket(clientboundFossilScreenPacket.id(), clientboundFossilScreenPacket.fossilRotations(), clientboundFossilScreenPacket.fossilPositions(), clientboundFossilScreenPacket.fossilVariant(), iPayloadContext.player().level()));
    }
}
