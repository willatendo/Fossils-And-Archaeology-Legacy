package willatendo.fossilslegacy.network;

import willatendo.fossilslegacy.network.serverbound.*;
import willatendo.simplelibrary.server.event.registry.ServerboundPacketRegister;

public final class ServerboundPacketRegistry {
    public static void serverboundPacketSetup(ServerboundPacketRegister serverboundPacketRegister) {
        serverboundPacketRegister.registerServerbound(ServerboundDamageHammerPacket.TYPE, ServerboundDamageHammerPacket.STREAM_CODEC, ServerboundPackets::serverboundDamageHammerPacket);
        serverboundPacketRegister.registerServerbound(ServerboundSetDNARecombinatorGenePacket.TYPE, ServerboundSetDNARecombinatorGenePacket.STREAM_CODEC, ServerboundPackets::serverboundSetDNARecombinatorGenePacket);
        serverboundPacketRegister.registerServerbound(ServerboundSetFossilPartPositionsPacket.TYPE, ServerboundSetFossilPartPositionsPacket.STREAM_CODEC, ServerboundPackets::serverboundSetFossilPartPositionsPacket);
        serverboundPacketRegister.registerServerbound(ServerboundSetFossilPartRotationsPacket.TYPE, ServerboundSetFossilPartRotationsPacket.STREAM_CODEC, ServerboundPackets::serverboundSetRotationsPacket);
        serverboundPacketRegister.registerServerbound(ServerboundStartTimeMachinePacket.TYPE, ServerboundStartTimeMachinePacket.STREAM_CODEC, ServerboundPackets::serverboundStartTimeMachinePacket);
        serverboundPacketRegister.registerServerbound(ServerboundVehicleSinkPacket.TYPE, ServerboundVehicleSinkPacket.STREAM_CODEC, ServerboundPackets::serverboundSinkPacket);
    }
}
