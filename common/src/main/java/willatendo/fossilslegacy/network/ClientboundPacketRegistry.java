package willatendo.fossilslegacy.network;

import willatendo.fossilslegacy.network.clientbound.ClientboundOpenDinopediaScreenPacket;
import willatendo.fossilslegacy.network.clientbound.ClientboundOpenFossilScreenPacket;
import willatendo.fossilslegacy.network.clientbound.ClientboundPackets;
import willatendo.simplelibrary.client.event.registry.ClientboundPacketRegister;

public final class ClientboundPacketRegistry {
    public static void clientboundPacketSetup(ClientboundPacketRegister clientboundPacketRegister) {
        clientboundPacketRegister.registerClientbound(ClientboundOpenDinopediaScreenPacket.class, ClientboundOpenDinopediaScreenPacket.TYPE, ClientboundOpenDinopediaScreenPacket.STREAM_CODEC, ClientboundOpenDinopediaScreenPacket::encode, ClientboundOpenDinopediaScreenPacket::decode, ClientboundPackets::clientboundOpenDinopediaScreenPacket);
        clientboundPacketRegister.registerClientbound(ClientboundOpenFossilScreenPacket.class, ClientboundOpenFossilScreenPacket.TYPE, ClientboundOpenFossilScreenPacket.STREAM_CODEC, ClientboundOpenFossilScreenPacket::encode, ClientboundOpenFossilScreenPacket::decode, ClientboundPackets::clientboundOpenFossilScreenPacket);
    }
}
