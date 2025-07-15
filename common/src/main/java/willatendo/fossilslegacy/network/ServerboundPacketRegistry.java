package willatendo.fossilslegacy.network;

import willatendo.fossilslegacy.network.serverbound.*;
import willatendo.simplelibrary.server.event.registry.ServerboundPacketRegister;

public final class ServerboundPacketRegistry {
    public static void serverboundPacketSetup(ServerboundPacketRegister serverboundPacketRegister) {
        serverboundPacketRegister.registerServerbound(ServerboundDamageHammerPacket.class, ServerboundDamageHammerPacket.TYPE, ServerboundDamageHammerPacket.STREAM_CODEC, ServerboundDamageHammerPacket::encode, ServerboundDamageHammerPacket::decode, ServerboundPackets::serverboundDamageHammerPacket);
        serverboundPacketRegister.registerServerbound(ServerboundSetDNARecombinatorGenePacket.class, ServerboundSetDNARecombinatorGenePacket.TYPE, ServerboundSetDNARecombinatorGenePacket.STREAM_CODEC, ServerboundSetDNARecombinatorGenePacket::encode, ServerboundSetDNARecombinatorGenePacket::decode, ServerboundPackets::serverboundSetDNARecombinatorGenePacket);
        serverboundPacketRegister.registerServerbound(ServerboundSetDNARecombinatorModePacket.class, ServerboundSetDNARecombinatorModePacket.TYPE, ServerboundSetDNARecombinatorModePacket.STREAM_CODEC, ServerboundSetDNARecombinatorModePacket::encode, ServerboundSetDNARecombinatorModePacket::decode, ServerboundPackets::serverboundSetDNARecombinatorModePacket);
        serverboundPacketRegister.registerServerbound(ServerboundSetFossilPartPositionsPacket.class, ServerboundSetFossilPartPositionsPacket.TYPE, ServerboundSetFossilPartPositionsPacket.STREAM_CODEC, ServerboundSetFossilPartPositionsPacket::encode, ServerboundSetFossilPartPositionsPacket::decode, ServerboundPackets::serverboundSetFossilPartPositionsPacket);
        serverboundPacketRegister.registerServerbound(ServerboundSetFossilPartRotationsPacket.class, ServerboundSetFossilPartRotationsPacket.TYPE, ServerboundSetFossilPartRotationsPacket.STREAM_CODEC, ServerboundSetFossilPartRotationsPacket::encode, ServerboundSetFossilPartRotationsPacket::decode, ServerboundPackets::serverboundSetRotationsPacket);
        serverboundPacketRegister.registerServerbound(ServerboundStartTimeMachinePacket.class, ServerboundStartTimeMachinePacket.TYPE, ServerboundStartTimeMachinePacket.STREAM_CODEC, ServerboundStartTimeMachinePacket::encode, ServerboundStartTimeMachinePacket::decode, ServerboundPackets::serverboundStartTimeMachinePacket);
        serverboundPacketRegister.registerServerbound(ServerboundVehicleSinkPacket.class, ServerboundVehicleSinkPacket.TYPE, ServerboundVehicleSinkPacket.STREAM_CODEC, ServerboundVehicleSinkPacket::encode, ServerboundVehicleSinkPacket::decode, ServerboundPackets::serverboundSinkPacket);
    }
}
