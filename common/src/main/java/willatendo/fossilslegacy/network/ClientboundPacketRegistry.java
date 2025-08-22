package willatendo.fossilslegacy.network;

import willatendo.fossilslegacy.network.clientbound.ClientboundOpenDebugGeneticsScreenPacket;
import willatendo.fossilslegacy.network.clientbound.ClientboundOpenDinopediaScreenPacket;
import willatendo.fossilslegacy.network.clientbound.ClientboundOpenFossilScreenPacket;
import willatendo.fossilslegacy.network.clientbound.ClientboundPackets;
import willatendo.simplelibrary.client.event.registry.ClientboundPacketRegister;

public final class ClientboundPacketRegistry {
    public static void clientboundPacketSetup(ClientboundPacketRegister clientboundPacketRegister) {
        clientboundPacketRegister.registerClientbound(ClientboundOpenDebugGeneticsScreenPacket.TYPE, ClientboundOpenDebugGeneticsScreenPacket.STREAM_CODEC, ClientboundPackets::clientboundOpenDebugGeneticsScreenPacket);
        clientboundPacketRegister.registerClientbound(ClientboundOpenDinopediaScreenPacket.TYPE, ClientboundOpenDinopediaScreenPacket.STREAM_CODEC, ClientboundPackets::clientboundOpenDinopediaScreenPacket);
        clientboundPacketRegister.registerClientbound(ClientboundOpenFossilScreenPacket.TYPE, ClientboundOpenFossilScreenPacket.STREAM_CODEC, ClientboundPackets::clientboundOpenFossilScreenPacket);
    }
}
