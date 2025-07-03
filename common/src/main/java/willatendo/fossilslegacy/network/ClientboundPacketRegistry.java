package willatendo.fossilslegacy.network;

import willatendo.fossilslegacy.network.clientbound.ClientboundFossilScreenPacket;
import willatendo.fossilslegacy.network.clientbound.ClientboundPackets;
import willatendo.simplelibrary.client.event.registry.ClientboundPacketRegister;

public final class ClientboundPacketRegistry {
    public static void clientboundPacketSetup(ClientboundPacketRegister clientboundPacketRegister) {
        clientboundPacketRegister.registerClientbound(ClientboundFossilScreenPacket.class, ClientboundFossilScreenPacket.TYPE, ClientboundFossilScreenPacket.STREAM_CODEC, ClientboundFossilScreenPacket::encode, ClientboundFossilScreenPacket::decode, ClientboundPackets::clientboundFossilMenuPacket);
    }
}
